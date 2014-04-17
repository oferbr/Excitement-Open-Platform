package eu.excitementproject.tu2014;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import eu.excitementproject.eop.common.component.lexicalknowledge.LexicalResource;
import eu.excitementproject.eop.common.component.lexicalknowledge.LexicalResourceException;
import eu.excitementproject.eop.common.component.lexicalknowledge.LexicalRule;
import eu.excitementproject.eop.common.representation.partofspeech.ByCanonicalPartOfSpeech;
import eu.excitementproject.eop.common.representation.partofspeech.UnsupportedPosTagStringException;
import eu.excitementproject.eop.core.component.lexicalknowledge.wordnet.WordnetLexicalResource;
import eu.excitementproject.eop.core.component.lexicalknowledge.wordnet.WordnetRuleInfo;
import eu.excitementproject.eop.core.utilities.dictionary.wordnet.Synset;
import eu.excitementproject.eop.core.utilities.dictionary.wordnet.WordNetException;
import eu.excitementproject.eop.core.utilities.dictionary.wordnet.WordNetRelation;

/**
 * This code introduces the LexicalResource interface, and LexicalRule. 
 * 
 * @author Gil, Ofer Bronstein
 */

public class Ex1c {

	public static void main(String[] args) throws LexicalResourceException, UnsupportedPosTagStringException, WordNetException {

		// Initializing our lexical resource
		// Each resource would have different parameters in the c-tor
		// For instance, here we supply the (mandatory) wordnet folder, and a list
		//    of wordnet relations we would like to be retrieved when we query the resource.
		// Wordnet resource allows more optional parameters like whether to use only the first
		//    sense of a term or all of the senses, and whether to "chain" rules (e.g. also
		//    retrieve a hyponym of a hyponym, etc.) 
		WordNetRelation[] relations = new WordNetRelation[] {WordNetRelation.HYPERNYM, WordNetRelation.SYNONYM};
		LexicalResource<WordnetRuleInfo> wordnetLexRes = new WordnetLexicalResource(
				new File("src/main/resources/knowledge/wordnet"),
				new HashSet<WordNetRelation>(Arrays.asList(relations)));
		
		// Also note that like most lexical resources, wordnet defines WordnetRuleInfo,
		//    which holds additional wordnet-specific info for each rule
		// This why this type is used (as a generic parameter) for the type of the variable
		//    holding the resource, and for the type of rule-list returned by querying the resource
		// Also see: http://hltfbk.github.io/Excitement-Open-Platform/specification/spec-1.1.3.html#sec-4.5.1

		// Print all rules where travel/NOUN is on the right-hand side (it is entailed)
		// Note the methods we use here are general for all lexical resources
		// Each retrieved rule, however, has its generic part (printed in the rule's first line, like the lemmas and POSes),
		//    but also its wordnet-specific part (like the synsets)
		// Also note that in this call, we'll get rules entailing travel/NOUN, in ALL OF ITS SENSES
		List<LexicalRule<? extends WordnetRuleInfo>> rules1 = wordnetLexRes.getRulesForRight("travel", new ByCanonicalPartOfSpeech("N"));
		printWordnetRules("getRulesForRight(travel, N)", rules1);
		
		// Print all rules between walk/NOUN and travel/NOUN
		// Note that this could retrieve any number of rules - zero, one, or multiple
		List<LexicalRule<? extends WordnetRuleInfo>> rules2 = wordnetLexRes.getRules("walk", new ByCanonicalPartOfSpeech("N"), "travel", new ByCanonicalPartOfSpeech("N"));
		printWordnetRules("getRules(walk, N, travel, N)", rules2);

		// Same like before, but this time we use a "joker POS", by transferring null
		// These usage works generally for all lexical resources
		List<LexicalRule<? extends WordnetRuleInfo>> rules3 = wordnetLexRes.getRules("walk", null, "travel", null);
		printWordnetRules("getRules(walk, *, travel, *)", rules3);
	}
	
	private static void printWordnetRules(String title, List<LexicalRule<? extends WordnetRuleInfo>> rules) throws WordNetException {
		System.out.printf("\n%s (%d rules):\n", title, rules.size());
		int i=0;
		for (LexicalRule<? extends WordnetRuleInfo> rule : rules) {
			i += 1;
			WordnetRuleInfo info = rule.getInfo();
			Synset leftSynset = info.getLeftSense();
			Synset rightSynset = info.getRightSense();
			System.out.printf("  %d. %s/%s--(%s)-->%s/%s: %f\n        info: Synset(sense#%d, %s: %s) --> Synset(sense#%d, %s: %s)\n", i,
					rule.getLLemma(), rule.getLPos(), rule.getRelation(), rule.getRLemma(), rule.getRPos(), rule.getConfidence(),
					info.getLeftSenseNo(), leftSynset.getWords(), leftSynset.getGloss(), info.getRightSenseNo(), rightSynset.getWords(), rightSynset.getGloss());
		}
	}
}
