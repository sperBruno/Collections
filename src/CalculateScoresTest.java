import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateScoresTest
{
  public CalculateScoresTest() {}
  
  @Before
  public void setUp()
    throws Exception
  {}
  
  @Test
  public void testNull()
  {
    try
    {
      Map localMap = Analyzer.calculateScores(null);
      if (localMap == null)
        Assert.fail("calculateScores should return empty Map when input is null");
      Assert.assertTrue("calculateScores should return empty Map when input is null", localMap.isEmpty());
    }
    catch (Exception localException) {
      Assert.fail("calculateScores throws " + localException + " when input is null");
    }
  }
  
  @Test
  public void testEmpty() {
    try {
      Map localMap = Analyzer.calculateScores(new HashSet());
      if (localMap == null)
        Assert.fail("calculateScores should return empty Map when input is empty");
      Assert.assertTrue("calculateScores should return empty Map when input is empty", localMap.isEmpty());
    }
    catch (Exception localException) {
      Assert.fail("calculateScores throws " + localException + " when input is empty");
    }
  }
  
  @Test
  public void testSingleWord() {
    Word localWord = new Word("apple");
    localWord.increaseTotal(2);
    localWord.increaseTotal(1);
    
    HashSet localHashSet = new HashSet();
    localHashSet.add(localWord);
    try
    {
      Map localMap = Analyzer.calculateScores(localHashSet);
      if (localMap == null) {
        Assert.fail("calculateScores returns null when input has a single Word");
      } else if (localMap.isEmpty()) {
        Assert.fail("calculateScores returns empty Map when input has a single Word");
      }
      Assert.assertTrue("calculateScores has wrong number of elements when input has a single Word", 1 == localMap.size());
      
      Assert.assertTrue("calculateScores has wrong key for element when input has a single Word", localMap.containsKey("apple"));
      
      double d = ((Double)localMap.get("apple")).doubleValue();
      Assert.assertTrue("calculateScores has wrong score value for element when input has a single Word", Math.abs(1.5D - d) <= 1.0E-5D);
    }
    catch (Exception localException) {
      Assert.fail("calculateScores throws " + localException + " when input has a single Word");
    }
  }
  
  @Test
  public void testMultipleWords() {
    Word localWord1 = new Word("apple");
    localWord1.increaseTotal(2);
    localWord1.increaseTotal(1);
    Word localWord2 = new Word("banana");
    localWord2.increaseTotal(1);
    
    HashSet localHashSet = new HashSet();
    localHashSet.add(localWord1);
    localHashSet.add(localWord2);
    try
    {
      Map localMap = Analyzer.calculateScores(localHashSet);
      if (localMap == null) {
        Assert.fail("calculateScores returns null when input has multiple Words");
      } else if (localMap.isEmpty()) {
        Assert.fail("calculateScores returns empty Map when input has multiple Words");
      }
      Assert.assertTrue("calculateScores has wrong number of elements when input has multiple Words", 2 == localMap.size());
      
      Assert.assertTrue("calculateScores has wrong key for element when input has multiple Words", localMap.containsKey("apple"));
      Assert.assertTrue("calculateScores has wrong key for element when input has multiple Words", localMap.containsKey("banana"));
      
      double d = ((Double)localMap.get("apple")).doubleValue();
      Assert.assertTrue("calculateScores has wrong score value for element when input has multiple Words", Math.abs(1.5D - d) <= 1.0E-5D);
      
      d = ((Double)localMap.get("banana")).doubleValue();
      Assert.assertTrue("calculateScores has wrong score value for element when input has multiple Words", 1.0D == d);
    }
    catch (Exception localException) {
      Assert.fail("calculateScores throws " + localException + " when input has multiple Words");
    }
  }
  
  @Test
  public void testIgnoreNullWord() {
    Word localWord = new Word("apple");
    localWord.increaseTotal(2);
    localWord.increaseTotal(1);
    
    HashSet localHashSet = new HashSet();
    localHashSet.add(localWord);
    localHashSet.add(null);
    try
    {
      Map localMap = Analyzer.calculateScores(localHashSet);
      if (localMap == null) {
        Assert.fail("calculateScores returns null when input contains a null Word");
      } else if (localMap.isEmpty()) {
        Assert.fail("calculateScores returns empty Map when input contains a null Word");
      }
      Assert.assertTrue("calculateScores has wrong number of elements when input contains a null Word", 1 == localMap.size());
      
      Assert.assertTrue("calculateScores has wrong key for element when input contains a null Word", localMap.containsKey("apple"));
      
      double d = ((Double)localMap.get("apple")).doubleValue();
      Assert.assertTrue("calculateScores has wrong score value for element when input contains a null Word", Math.abs(1.5D - d) < 1.0E-5D);
    }
    catch (Exception localException) {
      Assert.fail("calculateScores throws " + localException + " when input contains a null Word");
    }
  }
}
