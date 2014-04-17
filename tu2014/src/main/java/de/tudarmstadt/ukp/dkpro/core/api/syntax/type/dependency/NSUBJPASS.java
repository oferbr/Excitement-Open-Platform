

/* First created by JCasGen Thu Apr 10 20:30:39 IDT 2014 */
package de.tudarmstadt.ukp.dkpro.core.api.syntax.type.dependency;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** 
 * Updated by JCasGen Thu Apr 10 20:30:39 IDT 2014
 * XML source: C:/Java/Git/eop/tu2014/src/main/resources/desc/tu2014-TypeSystem.xml
 * @generated */
public class NSUBJPASS extends Dependency {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NSUBJPASS.class);
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
  protected NSUBJPASS() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public NSUBJPASS(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public NSUBJPASS(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public NSUBJPASS(JCas jcas, int begin, int end) {
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
     
}

    