

/* First created by JCasGen Thu Apr 10 20:30:38 IDT 2014 */
package de.tudarmstadt.ukp.dkpro.core.api.lexmorph.type.pos;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** Preposition
 * Updated by JCasGen Thu Apr 10 20:30:38 IDT 2014
 * XML source: C:/Java/Git/eop/tu2014/src/main/resources/desc/tu2014-TypeSystem.xml
 * @generated */
public class PP extends POS {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(PP.class);
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
  protected PP() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public PP(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public PP(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public PP(JCas jcas, int begin, int end) {
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

    