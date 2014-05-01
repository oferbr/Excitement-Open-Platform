

/* First created by JCasGen Thu May 01 14:10:46 IDT 2014 */
package eu.excitementproject.tu2014.uima_example.simpleipport;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu May 01 14:10:46 IDT 2014
 * XML source: C:/Java/Git/eop/tu2014/src/main/resources/desc/TypeSystemDescriptor-SimpleIpPort.xml
 * @generated */
public class Port extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Port.class);
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
  protected Port() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Port(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Port(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Port(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: Number

  /** getter for Number - gets 
   * @generated */
  public short getNumber() {
    if (Port_Type.featOkTst && ((Port_Type)jcasType).casFeat_Number == null)
      jcasType.jcas.throwFeatMissing("Number", "eu.excitementproject.tu2014.uima_example.simpleipport.Port");
    return jcasType.ll_cas.ll_getShortValue(addr, ((Port_Type)jcasType).casFeatCode_Number);}
    
  /** setter for Number - sets  
   * @generated */
  public void setNumber(short v) {
    if (Port_Type.featOkTst && ((Port_Type)jcasType).casFeat_Number == null)
      jcasType.jcas.throwFeatMissing("Number", "eu.excitementproject.tu2014.uima_example.simpleipport.Port");
    jcasType.ll_cas.ll_setShortValue(addr, ((Port_Type)jcasType).casFeatCode_Number, v);}    
   
    
  //*--------------*
  //* Feature: IsKnown

  /** getter for IsKnown - gets 
   * @generated */
  public boolean getIsKnown() {
    if (Port_Type.featOkTst && ((Port_Type)jcasType).casFeat_IsKnown == null)
      jcasType.jcas.throwFeatMissing("IsKnown", "eu.excitementproject.tu2014.uima_example.simpleipport.Port");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((Port_Type)jcasType).casFeatCode_IsKnown);}
    
  /** setter for IsKnown - sets  
   * @generated */
  public void setIsKnown(boolean v) {
    if (Port_Type.featOkTst && ((Port_Type)jcasType).casFeat_IsKnown == null)
      jcasType.jcas.throwFeatMissing("IsKnown", "eu.excitementproject.tu2014.uima_example.simpleipport.Port");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((Port_Type)jcasType).casFeatCode_IsKnown, v);}    
  }

    