package org.bimserver.tools.generators;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bimserver.database.migrations.Schema;
import org.bimserver.querycompiler.VirtualFile;
import org.bimserver.utils.StringUtils;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType;
import org.eclipse.emf.codegen.ecore.genmodel.GenDelegationKind;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnumLiteral;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenResourceKind;
import org.eclipse.emf.codegen.ecore.genmodel.GenRuntimeVersion;
import org.eclipse.emf.codegen.ecore.templates.model.AdapterFactoryClass;
import org.eclipse.emf.codegen.ecore.templates.model.EnumClass;
import org.eclipse.emf.codegen.ecore.templates.model.FactoryClass;
import org.eclipse.emf.codegen.ecore.templates.model.PackageClass;
import org.eclipse.emf.codegen.ecore.templates.model.ResourceClass;
import org.eclipse.emf.codegen.ecore.templates.model.ResourceFactoryClass;
import org.eclipse.emf.codegen.ecore.templates.model.SwitchClass;
import org.eclipse.emf.codegen.ecore.templates.model.XMLProcessorClass;
import org.eclipse.emf.codegen.util.ImportManager;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import com.sleepycat.je.DatabaseException;

public class DataObjectGenerator {
	
	private static final String MODEL_PACKAGE = "org.bimserver.models.";
	private final Schema schema;

	public DataObjectGenerator(Schema schema) {
		this.schema = schema;
	}
	
	public VirtualFile generate(VirtualFile basedir) throws DatabaseException {
		GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModel.setRuntimeVersion(GenRuntimeVersion.EMF25);
		genModel.setComplianceLevel(GenJDKLevel.JDK60_LITERAL);
		genModel.setFeatureDelegation(GenDelegationKind.REFLECTIVE_LITERAL);
		genModel.setRootExtendsClass("org.bimserver.emf.IdEObjectImpl");
		genModel.setRootExtendsInterface("org.bimserver.emf.IdEObject");
		genModel.setCanGenerate(true);
		genModel.setModelDirectory("test");
		genModel.setModelName("model name");
		genModel.setForceOverwrite(true);

		Set<GenPackage> genPackages = createGenPackages(genModel, basedir);
		for (GenPackage genPackage : genPackages) {
			genModel.getUsedGenPackages().add(genPackage);
		}
		generatePackages(genPackages, basedir);
		
		return basedir;
	}

	private void generatePackages(Set<GenPackage> genPackages, VirtualFile basedir) {
		for (GenPackage genPackage : genPackages) {
			genPackage.prepareCache();
			
			String packageClassPathImpl = MODEL_PACKAGE + genPackage.getPackageName() + ".impl.";
			packageClassPathImpl = packageClassPathImpl.replace(".", File.separator) + genPackage.getPackageClassName() + ".java";
			VirtualFile packageVirtualFileImpl = basedir.createFile(packageClassPathImpl);
			packageVirtualFileImpl.setStringContent(new PackageClass().generate(new Object[] { genPackage, false, true }));
			
			String packageClassPathInterface = MODEL_PACKAGE + genPackage.getPackageName() + ".";
			packageClassPathInterface = packageClassPathInterface.replace(".", File.separator) + genPackage.getPackageInterfaceName() + ".java";
			VirtualFile packageVirtualFileInterface = basedir.createFile(packageClassPathInterface);
			packageVirtualFileInterface.setStringContent(new PackageClass().generate(new Object[] { genPackage, true, false }));
			
			String factoryClassPathImpl = MODEL_PACKAGE + genPackage.getPackageName() + ".impl.";
			factoryClassPathImpl = factoryClassPathImpl.replace(".", File.separator) + genPackage.getFactoryClassName() + ".java";
			VirtualFile factoryVirtualFileImpl = basedir.createFile(factoryClassPathImpl);
			factoryVirtualFileImpl.setStringContent(new FactoryClass().generate(new Object[] { genPackage, false, true }));
			
			String factoryClassPathInterface = MODEL_PACKAGE + genPackage.getPackageName() + ".";
			factoryClassPathInterface = factoryClassPathInterface.replace(".", File.separator) + genPackage.getFactoryInterfaceName() + ".java";
			VirtualFile factoryVirtualFileInterface = basedir.createFile(factoryClassPathInterface);
			factoryVirtualFileInterface.setStringContent(new FactoryClass().generate(new Object[] { genPackage, true, false }));
			
			String adapterFactoryClassPath = MODEL_PACKAGE + genPackage.getPackageName() + ".util.";
			adapterFactoryClassPath = adapterFactoryClassPath.replace(".", File.separator) + genPackage.getAdapterFactoryClassName() + ".java";
			VirtualFile adapterFactoryVirtualFile = basedir.createFile(adapterFactoryClassPath);
			adapterFactoryVirtualFile.setStringContent(new AdapterFactoryClass().generate(genPackage));
			
			String switchClassPath = MODEL_PACKAGE + genPackage.getPackageName() + ".util.";
			switchClassPath = switchClassPath.replace(".", File.separator) + genPackage.getSwitchClassName() + ".java";
			VirtualFile switchClassVirtualFile = basedir.createFile(switchClassPath);
			switchClassVirtualFile.setStringContent(new SwitchClass().generate(genPackage));
			
			String xmlClassPath = MODEL_PACKAGE + genPackage.getPackageName() + ".util.";
			xmlClassPath = xmlClassPath.replace(".", File.separator) + genPackage.getXMLProcessorClassName() + ".java";
			VirtualFile xmlClassVirtualFile = basedir.createFile(xmlClassPath);
			xmlClassVirtualFile.setStringContent(new XMLProcessorClass().generate(genPackage));

			String resourceFactoryClassPath = MODEL_PACKAGE + genPackage.getPackageName() + ".util.";
			resourceFactoryClassPath = resourceFactoryClassPath.replace(".", File.separator) + genPackage.getResourceFactoryClassName() + ".java";
			VirtualFile resourceFactoryClassVirtualFile = basedir.createFile(resourceFactoryClassPath);
			resourceFactoryClassVirtualFile.setStringContent(new ResourceFactoryClass().generate(genPackage));

			String resourceClassPath = MODEL_PACKAGE + genPackage.getPackageName() + ".util.";
			resourceClassPath = resourceClassPath.replace(".", File.separator) + genPackage.getResourceClassName() + ".java";
			VirtualFile resourceClassVirtualFile = basedir.createFile(resourceClassPath);
			resourceClassVirtualFile.setStringContent(new ResourceClass().generate(genPackage));

//			String validatorClassPath = "com.logiclabs.streamdb.models." + genPackage.getPackageName() + ".util.";
//			validatorClassPath = validatorClassPath.replace(".", File.separator) + genPackage.getValidatorClassName() + ".java";
//			VirtualFile validatorClassVirtualFile = basedir.createFile(validatorClassPath);
//			validatorClassVirtualFile.setStringContent(new ValidatorClass().generate(genPackage));
			
			for (GenClass genClass : genPackage.getGenClasses()) {
				String implFileName = MODEL_PACKAGE + genPackage.getPackageName() + ".impl.";
				implFileName = implFileName.replace(".", File.separator) + genClass.getName() + "Impl.java";
				String interfaceFileName = MODEL_PACKAGE + genPackage.getPackageName() + ".";
				interfaceFileName = interfaceFileName.replace(".", File.separator) + genClass.getName() + ".java";
				VirtualFile implVirtualFile = basedir.createFile(implFileName);
				VirtualFile interfaceVirtualFile = basedir.createFile(interfaceFileName);
				implVirtualFile.setStringContent(new org.eclipse.emf.codegen.ecore.templates.model.Class().generate(new Object[] { genClass, false, true }));
				interfaceVirtualFile.setStringContent(new org.eclipse.emf.codegen.ecore.templates.model.Class().generate(new Object[] { genClass, true, false }));
			}
			for (GenEnum genEnum : genPackage.getGenEnums()) {
				String enumFileName = MODEL_PACKAGE + genPackage.getPackageName() + ".";
				enumFileName = enumFileName.replace(".", File.separator) + genEnum.getName() + ".java";
				VirtualFile enumVirtualFile = basedir.createFile(enumFileName);
				enumVirtualFile.setStringContent(new EnumClass().generate(genEnum));
			}
		}
	}

	private Set<GenPackage> createGenPackages(GenModel genModel, VirtualFile basedir) throws DatabaseException {
		Set<GenPackage> result = new HashSet<GenPackage>();
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		Map<VirtualFile, Resource> resources = new HashMap<VirtualFile, Resource>();
		for (EPackage ePackage : schema.getEPackages()) {
			GenPackage genPackage = GenModelFactory.eINSTANCE.createGenPackage();
			result.add(genPackage);
			genPackage.setPrefix(StringUtils.firstUpperCase(ePackage.getName()));
			genPackage.setBasePackage("org.bimserver.models");
			genPackage.setEcorePackage(ePackage);
//			genPackage.setLoadInitialization(true);
			genModel.getGenPackages().add(genPackage);
			
			ImportManager importManager = new ImportManager("org.bimserver.models");
			genModel.setImportManager(importManager);
			genPackage.setResource(GenResourceKind.XMI_LITERAL);
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					GenClass genClass = GenModelFactory.eINSTANCE.createGenClass();
					genClass.setEcoreClass(eClass);
					genPackage.getGenClasses().add(genClass);
					for (EStructuralFeature eStructuralFeature : eClass.getEStructuralFeatures()) {
						GenFeature genFeature = GenModelFactory.eINSTANCE.createGenFeature();
						genFeature.setEcoreFeature(eStructuralFeature);
						genClass.getGenFeatures().add(genFeature);
					}
				} else if (eClassifier instanceof EEnum) {
					EEnum eEnum = (EEnum) eClassifier;
					GenEnum genEnum = GenModelFactory.eINSTANCE.createGenEnum();
					genEnum.setEcoreEnum(eEnum);
					genPackage.getGenEnums().add(genEnum);
					for (EEnumLiteral eEnumLiteral : eEnum.getELiterals()) {
						GenEnumLiteral genEnumLiteral = GenModelFactory.eINSTANCE.createGenEnumLiteral();
						genEnumLiteral.setEcoreEnumLiteral(eEnumLiteral);
						genEnum.getGenEnumLiterals().add(genEnumLiteral);
					}
				} else if (eClassifier instanceof EDataType) {
					GenDataType genDataType = GenModelFactory.eINSTANCE.createGenDataType();
					genDataType.setEcoreDataType((EDataType) eClassifier);
					genPackage.getGenDataTypes().add(genDataType);
				}
			}
			Resource resource = resourceSet.createResource(URI.createURI("file.ecore"));
			resource.getContents().add(ePackage);
			VirtualFile ecoreFile = basedir.createFile(MODEL_PACKAGE.replace(".", "/") + ePackage.getName() + "/impl/" + ePackage.getName() + ".ecore");
			resources.put(ecoreFile, resource);
		}
		for (VirtualFile virtualFile : resources.keySet()) {
			try {
				Resource resource = resources.get(virtualFile);
				OutputStream openOutputStream = virtualFile.openOutputStream();
				resource.save(openOutputStream, null);
				openOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}