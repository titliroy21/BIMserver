package org.bimserver.shared.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;

public interface LowLevelInterface extends PublicInterface {
	/**
	 * @param pid ObjectID of the Project to start a transaction on
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "startTransaction")
	Long startTransaction(
		@WebParam(name = "poid", partName = "startTransaction.poid") Long poid) throws ServerException, UserException;

	/**
	 * Commit the current transaction, changes will be saved, a transaction must be started by startTransaction first
	 * @param comment Comment describing what has changed
	 * @return ObjectID of the Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "commitTransaction")
	Long commitTransaction(
		@WebParam(name = "tid", partName = "commitTransaction.tid") Long tid,
		@WebParam(name = "comment", partName = "commitTransaction.comment") String comment) throws ServerException, UserException;
	
	/**
	 * Abort the current transaction, changes will not be saved
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "abortTransaction")
	void abortTransaction(
		@WebParam(name = "tid", partName = "abortTransaction.tid") Long tid) throws ServerException, UserException;
	
	/**
	 * Create a new Object
	 * @param className The type of the new object
	 * @return The ObjectID of the newly created object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "createObject")
	Long createObject(
		@WebParam(name = "tid", partName = "createObject.tid") Long tid,
		@WebParam(name = "className", partName = "createObject.className") String className) throws ServerException, UserException;
	
	/**
	 * Remove an object
	 * @param oid ObjectID of the object to remove
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeObject")
	void removeObject(
		@WebParam(name = "tid", partName = "removeObject.tid") Long tid,
		@WebParam(name = "oid", partName = "removeObject.oid") Long oid) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setStringAttribute")
	void setStringAttribute(
		@WebParam(name = "tid", partName = "setStringAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setStringAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setStringAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setStringAttribute.value") String value) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getStringAttribute")
	String getStringAttribute(
		@WebParam(name = "tid", partName = "getStringAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getStringAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getStringAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getStringAttributes")
	List<String> getStringAttributes(
			@WebParam(name = "tid", partName = "getStringAttributes.tid") Long tid,
			@WebParam(name = "oid", partName = "getStringAttributes.oid") Long oid, 
			@WebParam(name = "attributeName", partName = "getStringAttributes.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setDoubleAttribute")
	void setDoubleAttribute(
		@WebParam(name = "tid", partName = "setDoubleAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setDoubleAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setDoubleAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setDoubleAttribute.value") Double value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setDoubleAttributes")
	void setDoubleAttributes(
		@WebParam(name = "tid", partName = "setDoubleAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "setDoubleAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setDoubleAttributes.attributeName") String attributeName, 
		@WebParam(name = "values", partName = "setDoubleAttributes.values") List<Double> values) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDoubleAttribute")
	Double getDoubleAttribute(
		@WebParam(name = "tid", partName = "getDoubleAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getDoubleAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getDoubleAttribute.attributeName") String attributeName) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDoubleAttributes")
	List<Double> getDoubleAttributes(
		@WebParam(name = "tid", partName = "getDoubleAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "getDoubleAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getDoubleAttributes.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Enum value (name of the enum item)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setEnumAttribute")
	void setEnumAttribute(
		@WebParam(name = "tid", partName = "setEnumAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setEnumAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setEnumAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setEnumAttribute.value") String value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Enum value (name of the enum item)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getEnumAttribute")
	String getEnumAttribute(
		@WebParam(name = "tid", partName = "getEnumAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getEnumAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getEnumAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setIntegerAttribute")
	void setIntegerAttribute(
		@WebParam(name = "tid", partName = "setIntegerAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setIntegerAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setIntegerAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setIntegerAttribute.value") Integer value) throws ServerException, UserException;

	@WebMethod(action = "setByteArrayAttribute")
	void setByteArrayAttribute(
		@WebParam(name = "tid", partName = "setByteArrayAttribute.tid") Long tid, 
		@WebParam(name = "oid", partName = "setByteArrayAttribute.oid") Long oid,
		@WebParam(name = "attributeName", partName = "setByteArrayAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setByteArrayAttribute.value") Byte[] value) throws UserException, ServerException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setIntegerAttributes")
	void setIntegerAttributes(
		@WebParam(name = "tid", partName = "setIntegerAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "setIntegerAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setIntegerAttributes.attributeName") String attributeName, 
		@WebParam(name = "values", partName = "setIntegerAttributes.value") List<Integer> values) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setLongAttribute")
	void setLongAttribute(
		@WebParam(name = "tid", partName = "setLongAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setLongAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setLongAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setLongAttribute.value") Long value) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setLongAttributes")
	void setLongAttributes(
			@WebParam(name = "tid", partName = "setLongAttributes.tid") Long tid,
			@WebParam(name = "oid", partName = "setLongAttributes.oid") Long oid, 
			@WebParam(name = "attributeName", partName = "setLongAttributes.attributeName") String attributeName, 
			@WebParam(name = "values", partName = "setLongAttributes.value") List<Long> values) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getIntegerAttribute")
	Integer getIntegerAttribute(
		@WebParam(name = "tid", partName = "getIntegerAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getIntegerAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getIntegerAttribute.attributeName") String attributeName) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getByteArrayAttribute")
	byte[] getByteArrayAttribute(
		@WebParam(name = "tid", partName = "getByteArrayAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getByteArrayAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getByteArrayAttribute.attributeName") String attributeName) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getByteArrayAttributes")
	List<byte[]> getByteArrayAttributes(
			@WebParam(name = "tid", partName = "getByteArrayAttributes.tid") Long tid,
			@WebParam(name = "oid", partName = "getByteArrayAttributes.oid") Long oid, 
			@WebParam(name = "attributeName", partName = "getByteArrayAttributes.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getIntegerAttributes")
	List<Integer> getIntegerAttributes(
			@WebParam(name = "tid", partName = "getIntegerAttributes.tid") Long tid,
			@WebParam(name = "oid", partName = "getIntegerAttributes.oid") Long oid, 
			@WebParam(name = "attributeName", partName = "getIntegerAttributes.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value new Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getLongAttribute")
	Long getLongAttribute(
			@WebParam(name = "tid", partName = "getLongAttribute.tid") Long tid,
			@WebParam(name = "oid", partName = "getLongAttribute.oid") Long oid, 
			@WebParam(name = "attributeName", partName = "getLongAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setBooleanAttribute")
	void setBooleanAttribute(
		@WebParam(name = "tid", partName = "setBooleanAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "setBooleanAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setBooleanAttribute.attributeName") String attributeName, 
		@WebParam(name = "value", partName = "setBooleanAttribute.value") Boolean value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setBooleanAttributes")
	void setBooleanAttributes(
		@WebParam(name = "tid", partName = "setBooleanAttributes.tid") Long tid,
		@WebParam(name = "oid", partName = "setBooleanAttributes.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "setBooleanAttributes.attributeName") String attributeName, 
		@WebParam(name = "values", partName = "setBooleanAttributes.values") List<Boolean> values) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getBooleanAttribute")
	Boolean getBooleanAttribute(
		@WebParam(name = "tid", partName = "getBooleanAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "getBooleanAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "getBooleanAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getBooleanAttributes")
	List<Boolean> getBooleanAttributes(
			@WebParam(name = "tid", partName = "getBooleanAttributes.tid") Long tid,
			@WebParam(name = "oid", partName = "getBooleanAttributes.oid") Long oid, 
			@WebParam(name = "attributeName", partName = "getBooleanAttributes.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference
	 * @param referenceOid ObjectID of the newly referred object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "setReference")
	void setReference(
		@WebParam(name = "tid", partName = "setReference.tid") Long tid,
		@WebParam(name = "oid", partName = "setReference.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "setReference.referenceName") String referenceName, 
		@WebParam(name = "referenceOid", partName = "setReference.referenceOid") Long referenceOid) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference
	 * @param referenceOid ObjectID of the newly referred object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getReference")
	Long getReference(
		@WebParam(name = "tid", partName = "getReference.tid") Long tid,
		@WebParam(name = "oid", partName = "getReference.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "getReference.referenceName") String referenceName) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference
	 * @param referenceOid ObjectID of the newly referred object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getReferences")
	List<Long> getReferences(
			@WebParam(name = "tid", partName = "getReferences.tid") Long tid,
			@WebParam(name = "oid", partName = "getReferences.oid") Long oid, 
			@WebParam(name = "referenceName", partName = "getReferences.referenceName") String referenceName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute to unset
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "unsetAttribute")
	void unsetAttribute(
		@WebParam(name = "tid", partName = "unsetAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "unsetAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "unsetAttribute.attributeName") String attributeName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference to unset (null)
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "unsetReference")
	void unsetReference(
		@WebParam(name = "tid", partName = "unsetReference.tid") Long tid,
		@WebParam(name = "oid", partName = "unsetReference.oid") Long oid,
		@WebParam(name = "referenceName", partName = "unsetReference.referenceName") String referenceName) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New String value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addStringAttribute")
	void addStringAttribute(
		@WebParam(name = "tid", partName = "addStringAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "addStringAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "addStringAttribute.attributeName") String attributeName,
		@WebParam(name = "value", partName = "addStringAttribute.value") String value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Double value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addDoubleAttribute")
	void addDoubleAttribute(
		@WebParam(name = "tid", partName = "addDoubleAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "addDoubleAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "addDoubleAttribute.attributeName") String attributeName,
		@WebParam(name = "value", partName = "addDoubleAttribute.value") Double value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Integer value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addIntegerAttribute")
	void addIntegerAttribute(
		@WebParam(name = "tid", partName = "addIntegerAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "addIntegerAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "addIntegerAttribute.attributeName") String attributeName,
		@WebParam(name = "value", partName = "addIntegerAttribute.value") Integer value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute to add a value to
	 * @param value New Boolean value
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addBooleanAttribute")
	void addBooleanAttribute(
		@WebParam(name = "tid", partName = "addBooleanAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "addBooleanAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "addBooleanAttribute.attributeName") String attributeName,
		@WebParam(name = "value", partName = "addBooleanAttribute.value") Boolean value) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference to add a reference to
	 * @param referenceOid ObjectID of the newly referenced Object
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "addReference")
	void addReference(
		@WebParam(name = "tid", partName = "addReference.tid") Long tid,
		@WebParam(name = "oid", partName = "addReference.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "addReference.referenceName") String referenceName, 
		@WebParam(name = "referenceOid", partName = "addReference.referenceOid") Long referenceOid) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param attributeName Name of the attribute from which to remove an item
	 * @param index Index of the item to remove
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeAttribute")
	void removeAttribute(
		@WebParam(name = "tid", partName = "removeAttribute.tid") Long tid,
		@WebParam(name = "oid", partName = "removeAttribute.oid") Long oid, 
		@WebParam(name = "attributeName", partName = "removeAttribute.attributeName") String attributeName, 
		@WebParam(name = "index", partName = "removeAttribute.index") Integer index) throws ServerException, UserException;
	
	/**
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference from which to remove an item
	 * @param index Index of the item to remove
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeReference")
	void removeReference(
		@WebParam(name = "tid", partName = "removeReference.tid") Long tid,
		@WebParam(name = "oid", partName = "removeReference.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "removeReference.referenceName") String referenceName, 
		@WebParam(name = "index", partName = "removeReference.index") Integer index) throws ServerException, UserException;

	/**
	 * @param oid ObjectID of the object to change
	 * @param referenceName Name of the reference from which to remove an item
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "removeAllReferences")
	void removeAllReferences(
		@WebParam(name = "tid", partName = "removeAllReferences.tid") Long tid,
		@WebParam(name = "oid", partName = "removeAllReferences.oid") Long oid, 
		@WebParam(name = "referenceName", partName = "removeAllReferences.referenceName") String referenceName) throws ServerException, UserException;
	
	@WebMethod(action = "getDataObjectByOid")
	SDataObject getDataObjectByOid(
		@WebParam(name = "roid", partName = "getDataObjectByOid.roid") Long roid,
		@WebParam(name = "oid", partName = "getDataObjectByOid.oid") Long oid) throws ServerException, UserException;

	/**
	 * Get DataObjects based on a list of GUIDs
	 * 
	 * @param roid ObjectID of the Revision
	 * @param guid An IFC GUID
	 * @return The object with the given GUID in the given Revision, of null if not found
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDataObjectByGuid")
	SDataObject getDataObjectByGuid(
		@WebParam(name = "roid", partName = "getDataObjectByGuid.roid") Long roid,
		@WebParam(name = "guid", partName = "getDataObjectByGuid.guid") String guid) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision
	 * @param className Name of the class to query (e.g. "IfcWindow")
	 * @return A list of DataObjects from the given Revision matching the given class
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDataObjectsByType")
	List<SDataObject> getDataObjectsByType(
		@WebParam(name = "roid", partName = "getDataObjectsByType.roid") Long roid,
		@WebParam(name = "className", partName = "getDataObjectsByType.className") String className) throws ServerException, UserException;

	/**
	 * @param roid ObjectID of the Revision
	 * @return A list of DataObjects from the given Revision
	 * @throws ServerException, UserException
	 */
	@WebMethod(action = "getDataObjects")
	List<SDataObject> getDataObjects(
		@WebParam(name = "roid", partName = "getDataObjects.roid") Long roid) throws ServerException, UserException;
}