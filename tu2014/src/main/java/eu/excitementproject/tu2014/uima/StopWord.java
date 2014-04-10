

/* First created by JCasGen Thu Apr 10 20:30:39 IDT 2014 */
package eu.excitementproject.tu2014.uima;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Apr 10 20:30:39 IDT 2014
 * XML source: C:/Java/Git/eop/tu2014/src/main/resources/desc/tu2014-TypeSystem.xml
 * @generated */
public class StopWord extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(StopWord.class);
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
  protected StopWord() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public StopWord(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public StopWord(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public StopWord(JCas jcas, int begin, int end) {
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
  //* Feature: posLevel

  /** getter for posLevel - gets 
   * @generated */
  public String getPosLevel() {
    if (StopWord_Type.featOkTst && ((StopWord_Type)jcasType).casFeat_posLevel == null)
      jcasType.jcas.throwFeatMissing("posLevel", "eu.excitementproject.tu2014.uima.StopWord");
    return jcasType.ll_cas.ll_getStringValue(addr, ((StopWord_Type)jcasType).casFeatCode_posLevel);}
    
  /** setter for posLevel - sets  
   * @generated */
  public void setPosLevel(String v) {
    if (StopWord_Type.featOkTst && ((StopWord_Type)jcasType).casFeat_posLevel == null)
      jcasType.jcas.throwFeatMissing("posLevel", "eu.excitementproject.tu2014.uima.StopWord");
    jcasType.ll_cas.ll_setStringValue(addr, ((StopWord_Type)jcasType).casFeatCode_posLevel, v);}    
  }

    