import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateSentenceScoreTest
{
  public CalculateSentenceScoreTest() {}
  
  @Before
  public void setUp()
    throws Exception
  {}
  
  @Test
  public void testNullMap()
  {
    try
    {
      double d = Analyzer.calculateSentenceScore(null, "This is a test .");
      Assert.assertTrue("calculateSentenceScore does not return 0 when input Map is null", 0.0D == d);
    }
    catch (Exception localException) {
      Assert.fail("calculateSentenceScore throws " + localException + " when input Map is null");
    }
  }
  
  @Test
  public void testEmptyMap() {
    try {
      double d = Analyzer.calculateSentenceScore(new HashMap(), "This is a test .");
      Assert.assertTrue("calculateSentenceScore does not return 0 when input Map is empty", 0.0D == d);
    }
    catch (Exception localException) {
      Assert.fail("calculateSentenceScore throws " + localException + " when input Map is empty");
    }
  }
  
  @Test
  public void testNullSentence() {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dog", Double.valueOf(2.0D));
    try
    {
      double d = Analyzer.calculateSentenceScore(localHashMap, null);
      Assert.assertTrue("calculateSentenceScore does not return 0 when input sentence is null", 0.0D == d);
    }
    catch (Exception localException) {
      Assert.fail("calculateSentenceScore throws " + localException + " when input sentence is null");
    }
  }
  
  @Test
  public void testEmptySentence() {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dog", Double.valueOf(2.0D));
    try
    {
      double d = Analyzer.calculateSentenceScore(localHashMap, "");
      Assert.assertTrue("calculateSentenceScore does not return 0 when input sentence is empty", 0.0D == d);
    }
    catch (Exception localException) {
      Assert.fail("calculateSentenceScore throws " + localException + " when input sentence is empty");
    }
  }
  
  @Test
  public void testSentenceContainsNoValidWords() {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dog", Double.valueOf(2.0D));
    try
    {
      double d = Analyzer.calculateSentenceScore(localHashMap, "$");
      Assert.assertTrue("calculateSentenceScore does not return 0 when input sentence contains no valid words", 0.0D == d);
    }
    catch (Exception localException) {
      Assert.fail("calculateSentenceScore throws " + localException + " when input sentence contains no valid words");
    }
  }
  
  @Test
  public void testAllWordsInSentenceAndScoresAreInts() {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dog", Double.valueOf(2.0D));
    localHashMap.put("cat", Double.valueOf(2.0D));
    try
    {
      double d = Analyzer.calculateSentenceScore(localHashMap, "dog cat");
      Assert.assertTrue("calculateSentenceScore does not return correct value when all words in Map are in sentence and have integer scores", 2.0D == d);
    }
    catch (Exception localException) {
      Assert.fail("calculateSentenceScore throws " + localException + " when all words in Map are in sentence and have integer scores");
    }
  }
  
  @Test
  public void testAllWordsInSentenceAndScoresAreDoubles() {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dog", Double.valueOf(1.7D));
    localHashMap.put("cat", Double.valueOf(1.9D));
    try
    {
      double d = Analyzer.calculateSentenceScore(localHashMap, "dog cat");
      Assert.assertTrue("calculateSentenceScore does not return correct value when all words in Map are in sentence and have floating-point scores", Math.abs(1.8D - d) < 1.0E-6D);
    }
    catch (Exception localException) {
      Assert.fail("calculateSentenceScore throws " + localException + " when all words in Map are in sentence and have floating-point scores");
    }
  }
  
  @Test
  public void testSomeWordsNotInMap() {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dog", Double.valueOf(2.0D));
    localHashMap.put("cat", Double.valueOf(1.0D));
    try
    {
      double d = Analyzer.calculateSentenceScore(localHashMap, "dog cat gorilla");
      
      Assert.assertTrue("calculateSentenceScore does not return correct value when some words in sentence are not in input Map", 1.0D == d);
    }
    catch (Exception localException) {
      Assert.fail("calculateSentenceScore throws " + localException + " when some words in sentence are not in input Map");
    }
  }
  
  @Test
  public void testIgnoreInvalidWords() {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dog", Double.valueOf(2.0D));
    localHashMap.put("cat", Double.valueOf(0.0D));
    try
    {
      double d = Analyzer.calculateSentenceScore(localHashMap, "dog $pig cat");
      
      Assert.assertTrue("calculateSentenceScore does not return correct value when input sentence contains invalid words", 1.0D == d);
    }
    catch (Exception localException) {
      Assert.fail("calculateSentenceScore throws " + localException + " when input sentence contains invalid words");
    }
  }
  
  @Test
  public void testCaseInsensitivity() {
    HashMap localHashMap = new HashMap();
    localHashMap.put("dog", Double.valueOf(2.0D));
    localHashMap.put("cat", Double.valueOf(0.0D));
    try
    {
      double d = Analyzer.calculateSentenceScore(localHashMap, "DOG cat");
      Assert.assertTrue("calculateSentenceScore does not return correct value when input sentence contains words with uppercase letters", 1.0D == d);
    }
    catch (Exception localException) {
      Assert.fail("calculateSentenceScore throws " + localException + " when input sentence contains words with uppercase letters");
    }
  }
}
