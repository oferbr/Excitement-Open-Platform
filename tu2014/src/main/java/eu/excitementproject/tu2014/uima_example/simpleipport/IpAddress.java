

/* First created by JCasGen Thu May 01 14:10:46 IDT 2014 */
package eu.excitementproject.tu2014.uima_example.simpleipport;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** An IP Address from the document
 * Updated by JCasGen Thu May 01 14:10:46 IDT 2014
 * XML source: C:/Java/Git/eop/tu2014/src/main/resources/desc/TypeSystemDescriptor-SimpleIpPort.xml
 * @generated */
public class IpAddress extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(IpAddress.class);
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
  protected IpAddress() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public IpAddress(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public IpAddress(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public IpAddress(JCas jcas, int begin, int end) {
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
  //* Feature: IsPrivate

  /** getter for IsPrivate - gets 
   * @generated */
  public boolean getIsPrivate() {
    if (IpAddress_Type.featOkTst && ((IpAddress_Type)jcasType).casFeat_IsPrivate == null)
      jcasType.jcas.throwFeatMissing("IsPrivate", "eu.excitementproject.tu2014.uima_example.simpleipport.IpAddress");
    return jcasType.ll_cas.ll_getBooleanValue(addr, ((IpAddress_Type)jcasType).casFeatCode_IsPrivate);}
    
  /** setter for IsPrivate - sets  
   * @generated */
  public void setIsPrivate(boolean v) {
    if (IpAddress_Type.featOkTst && ((IpAddress_Type)jcasType).casFeat_IsPrivate == null)
      jcasType.jcas.throwFeatMissing("IsPrivate", "eu.excitementproject.tu2014.uima_example.simpleipport.IpAddress");
    jcasType.ll_cas.ll_setBooleanValue(addr, ((IpAddress_Type)jcasType).casFeatCode_IsPrivate, v);}    
  }

    