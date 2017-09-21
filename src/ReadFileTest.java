import java.io.File;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReadFileTest
{
  protected static final String DIRECTORY = "./";
  
  public ReadFileTest() {}
  
  @Before
  public void setUp()
    throws Exception
  {}
  
  @Test
  public void testNull()
  {
    try
    {
      List localList = Analyzer.readFile(null);
      if (localList == null)
        Assert.fail("readFile should return empty List when input filename is null"); else {
        Assert.assertTrue("readFile should return empty List when input filename is null", localList.isEmpty());
      }
    } catch (Exception localException) {
      Assert.fail("readFile throws " + localException + " when input filename is null");
    }
  }
  
  @Test
  public void testInvalidFilename() {
    try {
      List localList = Analyzer.readFile("invalid name!");
      if (localList == null)
        Assert.fail("readFile should return empty List when input file cannot be read"); else {
        Assert.assertTrue("readFile should return empty List when input file cannot be read", localList.isEmpty());
      }
    } catch (Exception localException) {
      Assert.fail("readFile throws " + localException + " when input file cannot be read");
    }
  }
  
  @Test
  public void testTextOneSentence() {
    File localFile = new File("./test1.txt");
    if (!localFile.exists()) {
      Assert.fail("Could not run test for readFile: be sure that test1.txt is in your project root directory or the directory where you started Java.");
    }
    try {
      List localList = Analyzer.readFile("./test1.txt");
      if (localList == null)
        Assert.fail("readFile returns null when processing file with one sentence");
      if (localList.isEmpty()) {
        Assert.fail("readFile returns empty List when processing file with one sentence");
      }
      Assert.assertTrue("readFile contains wrong number of elements when file has one sentence", 1 == localList.size());
      
      Sentence localSentence = (Sentence)localList.get(0);
      if (localSentence == null) {
        Assert.fail("readFile contains null Sentence when file has one sentence");
      }
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has one sentence", 0 == localSentence.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has one sentence", "this is a test".equals(localSentence.getText()));
    }
    catch (Exception localException) {
      Assert.fail("readFile throws " + localException + " when processing file with one sentence");
    }
  }
  
  @Test
  public void testScoreOneSentence() {
    File localFile = new File("./test2.txt");
    if (!localFile.exists()) {
      Assert.fail("Could not run test for readFile: be sure that test2.txt is in your project root directory or the directory where you started Java.");
    }
    try
    {
      List localList = Analyzer.readFile("./test2.txt");
      if (localList == null)
        Assert.fail("readFile returns null when processing file with one sentence");
      if (localList.isEmpty()) {
        Assert.fail("readFile returns empty List when processing file with one sentence");
      }
      Assert.assertTrue("readFile contains wrong number of elements when file has one sentence", 1 == localList.size());
      
      Sentence localSentence = (Sentence)localList.get(0);
      if (localSentence == null) {
        Assert.fail("readFile contains null Sentence when file has one sentence");
      }
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has one sentence", 2 == localSentence.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has one sentence", "this is a test".equals(localSentence.getText()));
    }
    catch (Exception localException) {
      Assert.fail("readFile throws " + localException + " when processing file with one sentence");
    }
  }
  
  @Test
  public void testMultipleSentencesPositiveScores() {
    File localFile = new File("./test3.txt");
    if (!localFile.exists()) {
      Assert.fail("Could not run test for readFile: be sure that test3.txt is in your project root directory or the directory where you started Java.");
    }
    try
    {
      List localList = Analyzer.readFile("./test3.txt");
      if (localList == null)
        Assert.fail("readFile returns null when processing file with multiple sentences");
      if (localList.isEmpty()) {
        Assert.fail("readFile returns empty List when processing file with multiple sentences");
      }
      Assert.assertTrue("readFile contains wrong number of elements when file has multiple sentences", 3 == localList.size());
      
      Sentence localSentence1 = (Sentence)localList.get(0);
      if (localSentence1 == null)
        Assert.fail("readFile contains null Sentence when file has multiple sentences");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences", 0 == localSentence1.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences", "this is a test".equals(localSentence1.getText()));
      
      Sentence localSentence2 = (Sentence)localList.get(1);
      if (localSentence2 == null)
        Assert.fail("readFile contains null Sentence when file has multiple sentences");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences", 1 == localSentence2.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences", "dogs are so cute".equals(localSentence2.getText()));
      
      Sentence localSentence3 = (Sentence)localList.get(2);
      if (localSentence3 == null)
        Assert.fail("readFile contains null Sentence when file has multiple sentences");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences", 2 == localSentence3.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences", "testing is boring".equals(localSentence3.getText()));
    }
    catch (Exception localException) {
      Assert.fail("readFile throws " + localException + " when processing file with multiple sentences");
    }
  }
  
  @Test
  public void testMultipleSentencesNegativeScores() {
    File localFile = new File("./test4.txt");
    if (!localFile.exists()) {
      Assert.fail("Could not run test for readFile: be sure that test4.txt is in your project root directory or the directory where you started Java.");
    }
    try
    {
      List localList = Analyzer.readFile("./test4.txt");
      if (localList == null)
        Assert.fail("readFile returns null when processing file with multiple sentences");
      if (localList.isEmpty()) {
        Assert.fail("readFile returns empty List when processing file with multiple sentences");
      }
      Assert.assertTrue("readFile contains wrong number of elements when file has multiple sentences", 3 == localList.size());
      
      Sentence localSentence1 = (Sentence)localList.get(1);
      if (localSentence1 == null)
        Assert.fail("readFile contains null Sentence when file has multiple sentences");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences and score is negative", -1 == localSentence1.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences and score is negative", "dogs are so cute".equals(localSentence1.getText()));
      
      Sentence localSentence2 = (Sentence)localList.get(2);
      if (localSentence2 == null)
        Assert.fail("readFile contains null Sentence when file has multiple sentences");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has multiple sentences and score is negative", -2 == localSentence2.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has multiple sentences and score is negative", "testing is boring".equals(localSentence2.getText()));
    }
    catch (Exception localException) {
      Assert.fail("readFile throws " + localException + " when processing file with multiple sentences");
    }
  }
  
  @Test
  public void testIgnoreInvalidSentenceWithNoScore() {
    File localFile = new File("./test5.txt");
    if (!localFile.exists()) {
      Assert.fail("Could not run test for readFile: be sure that test5.txt is in your project root directory or the directory where you started Java.");
    }
    try
    {
      List localList = Analyzer.readFile("./test5.txt");
      if (localList == null)
        Assert.fail("readFile returns null when processing file with invalid sentences that contain no score");
      if (localList.isEmpty()) {
        Assert.fail("readFile returns empty List when processing file with invalid sentences that contain no score");
      }
      Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that contain no score", 2 == localList.size());
      
      Sentence localSentence1 = (Sentence)localList.get(0);
      if (localSentence1 == null)
        Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no score");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no score", 0 == localSentence1.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no score", "this is a test".equals(localSentence1.getText()));
      
      Sentence localSentence2 = (Sentence)localList.get(1);
      if (localSentence2 == null)
        Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no score");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no score", 1 == localSentence2.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no score", "dogs are so cute".equals(localSentence2.getText()));
    }
    catch (Exception localException) {
      Assert.fail("readFile throws " + localException + " when processing file with invalid sentences that contain no score");
    }
  }
  
  @Test
  public void testIgnoreInvalidSentenceWithNoText() {
    File localFile = new File("./test6.txt");
    if (!localFile.exists()) {
      Assert.fail("Could not run test for readFile: be sure that test6.txt is in your project root directory or the directory where you started Java.");
    }
    try
    {
      List localList = Analyzer.readFile("./test6.txt");
      if (localList == null)
        Assert.fail("readFile returns null when processing file with invalid sentences that contain no text");
      if (localList.isEmpty()) {
        Assert.fail("readFile returns empty List when processing file with invalid sentences that contain no text");
      }
      Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that contain no text", 2 == localList.size());
      
      Sentence localSentence1 = (Sentence)localList.get(0);
      if (localSentence1 == null)
        Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no text");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no text", 0 == localSentence1.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no text", "this is a test".contains(localSentence1.getText()));
      
      Sentence localSentence2 = (Sentence)localList.get(1);
      if (localSentence2 == null)
        Assert.fail("readFile contains null Sentence when file has invalid sentences that contain no text");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that contain no text", 1 == localSentence2.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that contain no text", "dogs are so cute".contains(localSentence2.getText()));
    }
    catch (Exception localException) {
      Assert.fail("readFile throws " + localException + " when processing file with invalid sentences that contain no text");
    }
  }
  
  @Test
  public void testIgnoreInvalidSentenceWithScoreOutsideRange() {
    File localFile = new File("./test7.txt");
    if (!localFile.exists()) {
      Assert.fail("Could not run test for readFile: be sure that test7.txt is in your project root directory or the directory where you started Java.");
    }
    try
    {
      List localList = Analyzer.readFile("./test7.txt");
      if (localList == null)
        Assert.fail("readFile returns null when processing file with sentences that have score outside valid range");
      if (localList.isEmpty()) {
        Assert.fail("readFile returns empty List when processing file with invalid sentences that have score outside valid range");
      }
      Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that have score outside valid range", 2 == localList.size());
      
      Sentence localSentence1 = (Sentence)localList.get(0);
      if (localSentence1 == null)
        Assert.fail("readFile contains null Sentence when file has invalid sentences that have score outside valid range");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score outside valid range", 0 == localSentence1.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score outside valid range", "this is a test".equals(localSentence1.getText()));
      
      Sentence localSentence2 = (Sentence)localList.get(1);
      if (localSentence2 == null)
        Assert.fail("readFile contains null Sentence when file has invalid sentences that have score outside valid range");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score outside valid range", 1 == localSentence2.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score outside valid range", "dogs are so cute".equals(localSentence2.getText()));
    }
    catch (Exception localException) {
      Assert.fail("readFile throws " + localException + " when processing file with sentences that have score outside valid range");
    }
  }
  
  @Test
  public void testIgnoreInvalidSentenceWithScoreNotAnInteger() {
    File localFile = new File("./test8.txt");
    if (!localFile.exists()) {
      Assert.fail("Could not run test for readFile: be sure that test8.txt is in your project root directory or the directory where you started Java.");
    }
    try
    {
      List localList = Analyzer.readFile("./test8.txt");
      if (localList == null)
        Assert.fail("readFile returns null when processing file with sentences that have score that is not an integer");
      if (localList.isEmpty()) {
        Assert.fail("readFile returns empty List when processing file with invalid sentences that have score that is not an integer");
      }
      Assert.assertTrue("readFile contains wrong number of elements when file has invalid sentences that have score that is not an integer", 2 == localList.size());
      
      Sentence localSentence1 = (Sentence)localList.get(0);
      if (localSentence1 == null)
        Assert.fail("readFile contains null Sentence when file has invalid sentences that have score that is not an integer");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score that is not an integer", 0 == localSentence1.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score that is not an integer", "this is a test".equals(localSentence1.getText()));
      
      Sentence localSentence2 = (Sentence)localList.get(1);
      if (localSentence2 == null)
        Assert.fail("readFile contains null Sentence when file has invalid sentences that have score that is not an integer");
      Assert.assertTrue("readFile contains Sentence with incorrect score when file has invalid sentences that have score that is not an integer", 1 == localSentence2.getScore());
      Assert.assertTrue("readFile contains Sentence with incorrect text when file has invalid sentences that have score that is not an integer", "dogs are so cute".equals(localSentence2.getText()));
    }
    catch (Exception localException) {
      Assert.fail("readFile throws " + localException + " when processing file with sentences that have score that is not an integer");
    }
  }
}
