
/* First created by JCasGen Thu Apr 10 20:30:39 IDT 2014 */
package eu.excitementproject.tu2014.uima;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Apr 10 20:30:39 IDT 2014
 * @generated */
public class StopWord_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (StopWord_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = StopWord_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new StopWord(addr, StopWord_Type.this);
  			   StopWord_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new StopWord(addr, StopWord_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = StopWord.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("eu.excitementproject.tu2014.uima.StopWord");
 
  /** @generated */
  final Feature casFeat_posLevel;
  /** @generated */
  final int     casFeatCode_posLevel;
  /** @generated */ 
  public String getPosLevel(int addr) {
        if (featOkTst && casFeat_posLevel == null)
      jcas.throwFeatMissing("posLevel", "eu.excitementproject.tu2014.uima.StopWord");
    return ll_cas.ll_getStringValue(addr, casFeatCode_posLevel);
  }
  /** @generated */    
  public void setPosLevel(int addr, String v) {
        if (featOkTst && casFeat_posLevel == null)
      jcas.throwFeatMissing("posLevel", "eu.excitementproject.tu2014.uima.StopWord");
    ll_cas.ll_setStringValue(addr, casFeatCode_posLevel, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public StopWord_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_posLevel = jcas.getRequiredFeatureDE(casType, "posLevel", "uima.cas.String", featOkTst);
    casFeatCode_posLevel  = (null == casFeat_posLevel) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_posLevel).getCode();

  }
}



    