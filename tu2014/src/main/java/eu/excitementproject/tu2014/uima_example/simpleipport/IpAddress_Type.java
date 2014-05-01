
/* First created by JCasGen Thu May 01 14:10:46 IDT 2014 */
package eu.excitementproject.tu2014.uima_example.simpleipport;

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

/** An IP Address from the document
 * Updated by JCasGen Thu May 01 14:10:46 IDT 2014
 * @generated */
public class IpAddress_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (IpAddress_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = IpAddress_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new IpAddress(addr, IpAddress_Type.this);
  			   IpAddress_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new IpAddress(addr, IpAddress_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = IpAddress.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("eu.excitementproject.tu2014.uima_example.simpleipport.IpAddress");
 
  /** @generated */
  final Feature casFeat_IsPrivate;
  /** @generated */
  final int     casFeatCode_IsPrivate;
  /** @generated */ 
  public boolean getIsPrivate(int addr) {
        if (featOkTst && casFeat_IsPrivate == null)
      jcas.throwFeatMissing("IsPrivate", "eu.excitementproject.tu2014.uima_example.simpleipport.IpAddress");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_IsPrivate);
  }
  /** @generated */    
  public void setIsPrivate(int addr, boolean v) {
        if (featOkTst && casFeat_IsPrivate == null)
      jcas.throwFeatMissing("IsPrivate", "eu.excitementproject.tu2014.uima_example.simpleipport.IpAddress");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_IsPrivate, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public IpAddress_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_IsPrivate = jcas.getRequiredFeatureDE(casType, "IsPrivate", "uima.cas.Boolean", featOkTst);
    casFeatCode_IsPrivate  = (null == casFeat_IsPrivate) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_IsPrivate).getCode();

  }
}



    