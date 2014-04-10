

/* First created by JCasGen Thu Apr 10 20:30:39 IDT 2014 */
package eu.excitement.type.predicatetruth;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** This type represents a negation-and-uncertainty annotation.
 * Updated by JCasGen Thu Apr 10 20:30:39 IDT 2014
 * XML source: C:/Java/Git/eop/tu2014/src/main/resources/desc/tu2014-TypeSystem.xml
 * @generated */
public class NegationAndUncertainty extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NegationAndUncertainty.class);
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
  protected NegationAndUncertainty() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public NegationAndUncertainty(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public NegationAndUncertainty(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public NegationAndUncertainty(JCas jcas, int begin, int end) {
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
  //* Feature: value

  /** getter for value - gets This represents the value of the annotation.
   * @generated */
  public String getValue() {
    if (NegationAndUncertainty_Type.featOkTst && ((NegationAndUncertainty_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "eu.excitement.type.predicatetruth.NegationAndUncertainty");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NegationAndUncertainty_Type)jcasType).casFeatCode_value);}
    
  /** setter for value - sets This represents the value of the annotation. 
   * @generated */
  public void setValue(String v) {
    if (NegationAndUncertainty_Type.featOkTst && ((NegationAndUncertainty_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "eu.excitement.type.predicatetruth.NegationAndUncertainty");
    jcasType.ll_cas.ll_setStringValue(addr, ((NegationAndUncertainty_Type)jcasType).casFeatCode_value, v);}    
  }

    