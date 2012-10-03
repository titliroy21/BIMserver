/**
 * Copyright (C) 2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.bimserver.models.store;

import org.bimserver.emf.IdEObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.bimserver.models.store.UserSettings#getSerializers <em>Serializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getObjectIDMs <em>Object ID Ms</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getIfcEngines <em>Ifc Engines</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDeserializers <em>Deserializers</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getQueryengines <em>Queryengines</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getModelmergers <em>Modelmergers</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getModelcompares <em>Modelcompares</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultModelMerger <em>Default Model Merger</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultModelCompare <em>Default Model Compare</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultQueryEngine <em>Default Query Engine</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultIfcEngine <em>Default Ifc Engine</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultSerializer <em>Default Serializer</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getDefaultObjectIDM <em>Default Object IDM</em>}</li>
 *   <li>{@link org.bimserver.models.store.UserSettings#getServices <em>Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.bimserver.models.store.StorePackage#getUserSettings()
 * @model
 * @extends IdEObject
 * @generated
 */
public interface UserSettings extends IdEObject {
	/**
	 * Returns the value of the '<em><b>Serializers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.SerializerPluginConfiguration}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.SerializerPluginConfiguration#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serializers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Serializers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Serializers()
	 * @see org.bimserver.models.store.SerializerPluginConfiguration#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<SerializerPluginConfiguration> getSerializers();

	/**
	 * Returns the value of the '<em><b>Object ID Ms</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ObjectIDMPluginConfiguration}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ObjectIDMPluginConfiguration#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object ID Ms</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object ID Ms</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_ObjectIDMs()
	 * @see org.bimserver.models.store.ObjectIDMPluginConfiguration#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<ObjectIDMPluginConfiguration> getObjectIDMs();

	/**
	 * Returns the value of the '<em><b>Ifc Engines</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.IfcEnginePluginConfiguration}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.IfcEnginePluginConfiguration#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ifc Engines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ifc Engines</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_IfcEngines()
	 * @see org.bimserver.models.store.IfcEnginePluginConfiguration#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<IfcEnginePluginConfiguration> getIfcEngines();

	/**
	 * Returns the value of the '<em><b>Deserializers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.DeserializerPluginConfiguration}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.DeserializerPluginConfiguration#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deserializers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deserializers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Deserializers()
	 * @see org.bimserver.models.store.DeserializerPluginConfiguration#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<DeserializerPluginConfiguration> getDeserializers();

	/**
	 * Returns the value of the '<em><b>Queryengines</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.QueryEnginePluginConfiguration}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.QueryEnginePluginConfiguration#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Queryengines</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Queryengines</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Queryengines()
	 * @see org.bimserver.models.store.QueryEnginePluginConfiguration#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<QueryEnginePluginConfiguration> getQueryengines();

	/**
	 * Returns the value of the '<em><b>Modelmergers</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ModelMergerPluginConfiguration}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ModelMergerPluginConfiguration#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modelmergers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modelmergers</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Modelmergers()
	 * @see org.bimserver.models.store.ModelMergerPluginConfiguration#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<ModelMergerPluginConfiguration> getModelmergers();

	/**
	 * Returns the value of the '<em><b>Modelcompares</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.ModelComparePluginConfiguration}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.ModelComparePluginConfiguration#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modelcompares</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modelcompares</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Modelcompares()
	 * @see org.bimserver.models.store.ModelComparePluginConfiguration#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<ModelComparePluginConfiguration> getModelcompares();

	/**
	 * Returns the value of the '<em><b>Default Model Merger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Model Merger</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Model Merger</em>' reference.
	 * @see #setDefaultModelMerger(ModelMergerPluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultModelMerger()
	 * @model
	 * @generated
	 */
	ModelMergerPluginConfiguration getDefaultModelMerger();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultModelMerger <em>Default Model Merger</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Model Merger</em>' reference.
	 * @see #getDefaultModelMerger()
	 * @generated
	 */
	void setDefaultModelMerger(ModelMergerPluginConfiguration value);

	/**
	 * Returns the value of the '<em><b>Default Model Compare</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Model Compare</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Model Compare</em>' reference.
	 * @see #setDefaultModelCompare(ModelComparePluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultModelCompare()
	 * @model
	 * @generated
	 */
	ModelComparePluginConfiguration getDefaultModelCompare();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultModelCompare <em>Default Model Compare</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Model Compare</em>' reference.
	 * @see #getDefaultModelCompare()
	 * @generated
	 */
	void setDefaultModelCompare(ModelComparePluginConfiguration value);

	/**
	 * Returns the value of the '<em><b>Default Query Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Query Engine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Query Engine</em>' reference.
	 * @see #setDefaultQueryEngine(QueryEnginePluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultQueryEngine()
	 * @model
	 * @generated
	 */
	QueryEnginePluginConfiguration getDefaultQueryEngine();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultQueryEngine <em>Default Query Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Query Engine</em>' reference.
	 * @see #getDefaultQueryEngine()
	 * @generated
	 */
	void setDefaultQueryEngine(QueryEnginePluginConfiguration value);

	/**
	 * Returns the value of the '<em><b>Default Ifc Engine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Ifc Engine</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Ifc Engine</em>' reference.
	 * @see #setDefaultIfcEngine(IfcEnginePluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultIfcEngine()
	 * @model
	 * @generated
	 */
	IfcEnginePluginConfiguration getDefaultIfcEngine();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultIfcEngine <em>Default Ifc Engine</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Ifc Engine</em>' reference.
	 * @see #getDefaultIfcEngine()
	 * @generated
	 */
	void setDefaultIfcEngine(IfcEnginePluginConfiguration value);

	/**
	 * Returns the value of the '<em><b>Default Serializer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Serializer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Serializer</em>' reference.
	 * @see #setDefaultSerializer(SerializerPluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultSerializer()
	 * @model
	 * @generated
	 */
	SerializerPluginConfiguration getDefaultSerializer();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultSerializer <em>Default Serializer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Serializer</em>' reference.
	 * @see #getDefaultSerializer()
	 * @generated
	 */
	void setDefaultSerializer(SerializerPluginConfiguration value);

	/**
	 * Returns the value of the '<em><b>Default Object IDM</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Object IDM</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Object IDM</em>' reference.
	 * @see #setDefaultObjectIDM(ObjectIDMPluginConfiguration)
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_DefaultObjectIDM()
	 * @model
	 * @generated
	 */
	ObjectIDMPluginConfiguration getDefaultObjectIDM();

	/**
	 * Sets the value of the '{@link org.bimserver.models.store.UserSettings#getDefaultObjectIDM <em>Default Object IDM</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Object IDM</em>' reference.
	 * @see #getDefaultObjectIDM()
	 * @generated
	 */
	void setDefaultObjectIDM(ObjectIDMPluginConfiguration value);

	/**
	 * Returns the value of the '<em><b>Services</b></em>' reference list.
	 * The list contents are of type {@link org.bimserver.models.store.InternalServicePluginConfiguration}.
	 * It is bidirectional and its opposite is '{@link org.bimserver.models.store.InternalServicePluginConfiguration#getSettings <em>Settings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' reference list.
	 * @see org.bimserver.models.store.StorePackage#getUserSettings_Services()
	 * @see org.bimserver.models.store.InternalServicePluginConfiguration#getSettings
	 * @model opposite="settings"
	 * @generated
	 */
	EList<InternalServicePluginConfiguration> getServices();

} // UserSettings