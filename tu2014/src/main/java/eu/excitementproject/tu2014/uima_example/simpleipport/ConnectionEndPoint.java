

/* First created by JCasGen Thu May 01 14:10:46 IDT 2014 */
package eu.excitementproject.tu2014.uima_example.simpleipport;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.TOP;


/** 
 * Updated by JCasGen Thu May 01 14:10:46 IDT 2014
 * XML source: C:/Java/Git/eop/tu2014/src/main/resources/desc/TypeSystemDescriptor-SimpleIpPort.xml
 * @generated */
public class ConnectionEndPoint extends TOP {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(ConnectionEndPoint.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected ConnectionEndPoint() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public ConnectionEndPoint(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ConnectionEndPoint(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: IpAddress

  /** getter for IpAddress - gets 
   * @generated */
  public IpAddress getIpAddress() {
    if (ConnectionEndPoint_Type.featOkTst && ((ConnectionEndPoint_Type)jcasType).casFeat_IpAddress == null)
      jcasType.jcas.throwFeatMissing("IpAddress", "eu.excitementproject.tu2014.uima_example.simpleipport.ConnectionEndPoint");
    return (IpAddress)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ConnectionEndPoint_Type)jcasType).casFeatCode_IpAddress)));}
    
  /** setter for IpAddress - sets  
   * @generated */
  public void setIpAddress(IpAddress v) {
    if (ConnectionEndPoint_Type.featOkTst && ((ConnectionEndPoint_Type)jcasType).casFeat_IpAddress == null)
      jcasType.jcas.throwFeatMissing("IpAddress", "eu.excitementproject.tu2014.uima_example.simpleipport.ConnectionEndPoint");
    jcasType.ll_cas.ll_setRefValue(addr, ((ConnectionEndPoint_Type)jcasType).casFeatCode_IpAddress, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: Port

  /** getter for Port - gets 
   * @generated */
  public Port getPort() {
    if (ConnectionEndPoint_Type.featOkTst && ((ConnectionEndPoint_Type)jcasType).casFeat_Port == null)
      jcasType.jcas.throwFeatMissing("Port", "eu.excitementproject.tu2014.uima_example.simpleipport.ConnectionEndPoint");
    return (Port)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((ConnectionEndPoint_Type)jcasType).casFeatCode_Port)));}
    
  /** setter for Port - sets  
   * @generated */
  public void setPort(Port v) {
    if (ConnectionEndPoint_Type.featOkTst && ((ConnectionEndPoint_Type)jcasType).casFeat_Port == null)
      jcasType.jcas.throwFeatMissing("Port", "eu.excitementproject.tu2014.uima_example.simpleipport.ConnectionEndPoint");
    jcasType.ll_cas.ll_setRefValue(addr, ((ConnectionEndPoint_Type)jcasType).casFeatCode_Port, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    