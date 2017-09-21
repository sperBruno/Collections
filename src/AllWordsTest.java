import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AllWordsTest
{
  public AllWordsTest() {}
  
  @Before
  public void setUp()
    throws Exception
  {}
  
  @Test
  public void testNull()
  {
    try
    {
      Set localSet = Analyzer.allWords(null);
      if (localSet == null)
        Assert.fail("allWords should return empty Set when input is null");
      Assert.assertTrue("allWords should return empty Set when input is null", localSet.isEmpty());
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when input is null");
    }
  }
  
  @Test
  public void testEmpty() {
    try {
      Set localSet = Analyzer.allWords(new LinkedList());
      if (localSet == null)
        Assert.fail("allWords should return empty Set when input is empty");
      Assert.assertTrue("allWords should return empty Set when input is empty", localSet.isEmpty());
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when input is empty");
    }
  }
  
  @Test
  public void testAllWordsDistinct() {
    Sentence localSentence1 = new Sentence(0, "word dog ");
    Sentence localSentence2 = new Sentence(0, "cat monkey ");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localSentence1);
    localLinkedList.add(localSentence2);
    try
    {
      Set localSet = Analyzer.allWords(localLinkedList);
      if (localSet == null) {
        Assert.fail("allWords returns null when all words in List are distinct");
      } else if (localSet.isEmpty()) {
        Assert.fail("allWords returns empty Set when all words in List are distinct");
      }
      Assert.assertEquals("allWords contains incorrect number of elements when all words are distinct", 4L, localSet.size());
      
      Word localWord1 = new Word("word");
      localWord1.increaseTotal(0);
      Word localWord2 = new Word("dog");
      localWord2.increaseTotal(0);
      Word localWord3 = new Word("cat");
      localWord3.increaseTotal(0);
      Word localWord4 = new Word("monkey");
      localWord4.increaseTotal(0);
      
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct", localSet.contains(localWord1));
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct", localSet.contains(localWord2));
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct", localSet.contains(localWord3));
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct", localSet.contains(localWord4));
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when all words in List are distinct");
    }
  }
  
  @Test
  public void testIgnoreNullSentenceInList()
  {
    Sentence localSentence1 = new Sentence(0, "word dog ");
    Sentence localSentence2 = new Sentence(0, "cat monkey ");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localSentence1);
    localLinkedList.add(null);
    localLinkedList.add(localSentence2);
    try
    {
      Set localSet = Analyzer.allWords(localLinkedList);
      if (localSet == null) {
        Assert.fail("allWords returns null when a Sentence in List is null");
      } else if (localSet.isEmpty()) {
        Assert.fail("allWords returns empty Set when a Sentence in List is null");
      }
      Assert.assertTrue("allWords contains incorrect number of elements when a Sentence in List is null", 4 == localSet.size());
      
      Word localWord1 = new Word("word");
      localWord1.increaseTotal(0);
      Word localWord2 = new Word("dog");
      localWord2.increaseTotal(0);
      Word localWord3 = new Word("cat");
      localWord3.increaseTotal(0);
      Word localWord4 = new Word("monkey");
      localWord4.increaseTotal(0);
      
      Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", localSet.contains(localWord1));
      Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", localSet.contains(localWord2));
      Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", localSet.contains(localWord3));
      Assert.assertTrue("allWords does not contain correct Word when a Sentence in List is null", localSet.contains(localWord4));
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when a Sentence in List is null");
    }
  }
  
  @Test
  public void testCorrectTotalAllWordsDistinctScoresPositive()
  {
    Sentence localSentence1 = new Sentence(1, "word dog ");
    Sentence localSentence2 = new Sentence(2, "cat monkey ");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localSentence1);
    localLinkedList.add(localSentence2);
    try
    {
      Set localSet = Analyzer.allWords(localLinkedList);
      if (localSet == null) {
        Assert.fail("allWords returns null when all words are distinct");
      } else if (localSet.isEmpty()) {
        Assert.fail("allWords returns empty Set when all words are distinct");
      }
      Assert.assertTrue("allWords contains incorrect number of elements when all words are distinct", 4 == localSet.size());
      
      Word localWord1 = new Word("word");
      localWord1.increaseTotal(1);
      Word localWord2 = new Word("dog");
      localWord2.increaseTotal(1);
      Word localWord3 = new Word("cat");
      localWord3.increaseTotal(2);
      Word localWord4 = new Word("monkey");
      localWord4.increaseTotal(2);
      
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", localSet.contains(localWord1));
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", localSet.contains(localWord2));
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", localSet.contains(localWord3));
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is positive", localSet.contains(localWord4));
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when all words are distinct");
    }
  }
  
  @Test
  public void testCorrectTotalAllWordsDistinctScoresNegative()
  {
    Sentence localSentence1 = new Sentence(-1, "word dog ");
    Sentence localSentence2 = new Sentence(-2, "cat monkey ");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localSentence1);
    localLinkedList.add(localSentence2);
    try
    {
      Set localSet = Analyzer.allWords(localLinkedList);
      if (localSet == null) {
        Assert.fail("allWords returns null when all words are distinct");
      } else if (localSet.isEmpty()) {
        Assert.fail("allWords returns empty Set when all words are distinct");
      }
      Assert.assertTrue("allWords contains incorrect number of elements when all words are distinct", 4 == localSet.size());
      
      Word localWord1 = new Word("word");
      localWord1.increaseTotal(-1);
      Word localWord2 = new Word("dog");
      localWord2.increaseTotal(-1);
      Word localWord3 = new Word("cat");
      localWord3.increaseTotal(-2);
      Word localWord4 = new Word("monkey");
      localWord4.increaseTotal(-2);
      
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", localSet.contains(localWord1));
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", localSet.contains(localWord2));
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", localSet.contains(localWord3));
      Assert.assertTrue("allWords does not contain correct Word when all words are distinct and score is negative", localSet.contains(localWord4));
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when all words are distinct");
    }
  }
  

  @Test
  public void testSomeWordsAppearMoreThanOnce()
  {
    Sentence localSentence1 = new Sentence(0, "word dog ");
    Sentence localSentence2 = new Sentence(0, "cat dog ");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localSentence1);
    localLinkedList.add(localSentence2);
    try
    {
      Set localSet = Analyzer.allWords(localLinkedList);
      if (localSet == null) {
        Assert.fail("allWords returns null when some words appear more than once");
      } else if (localSet.isEmpty()) {
        Assert.fail("allWords returns empty Set when some words appear more than once");
      }
      Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == localSet.size());
      
      Word localWord1 = new Word("word");
      localWord1.increaseTotal(0);
      Word localWord2 = new Word("dog");
      localWord2.increaseTotal(0);
      
      Word localWord3 = new Word("cat");
      localWord3.increaseTotal(0);
      localWord2.increaseTotal(0);
      
      Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", localSet.contains(localWord1));
      Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", localSet.contains(localWord2));
      Assert.assertTrue("allWords does not contain correct Word when some words appear more than once", localSet.contains(localWord3));
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when some words appear more than once");
    }
  }
  
  @Test
  public void testCorrectTotalSomeWordsAppearMoreThanOnceScoresPositive()
  {
    Sentence localSentence1 = new Sentence(1, "word dog ");
    Sentence localSentence2 = new Sentence(2, "cat dog ");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localSentence1);
    localLinkedList.add(localSentence2);
    try
    {
      Set localSet = Analyzer.allWords(localLinkedList);
      if (localSet == null) {
        Assert.fail("allWords returns null when some words appear more than once");
      } else if (localSet.isEmpty()) {
        Assert.fail("allWords returns empty Set when some words appear more than once");
      }
      Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == localSet.size());
      
      Word localWord1 = new Word("word");
      localWord1.increaseTotal(1);
      Word localWord2 = new Word("dog");
      localWord2.increaseTotal(1);
      
      Word localWord3 = new Word("cat");
      localWord3.increaseTotal(2);
      localWord2.increaseTotal(2);
      
      Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", localSet.contains(localWord1));
      Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", localSet.contains(localWord2));
      Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is positive", localSet.contains(localWord3));
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when some words appear more than once");
    }
  }
  

  @Test
  public void testCorrectTotalSomeWordsAppearMoreThanOnceScoresNegative()
  {
    Sentence localSentence1 = new Sentence(-1, "word dog ");
    Sentence localSentence2 = new Sentence(-2, "cat dog ");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localSentence1);
    localLinkedList.add(localSentence2);
    try
    {
      Set localSet = Analyzer.allWords(localLinkedList);
      if (localSet == null) {
        Assert.fail("allWords returns null when some words appear more than once");
      } else if (localSet.isEmpty()) {
        Assert.fail("allWords returns empty Set when some words appear more than once");
      }
      Assert.assertTrue("allWords contains incorrect number of elements when some words appear more than once", 3 == localSet.size());
      
      Word localWord1 = new Word("word");
      localWord1.increaseTotal(-1);
      Word localWord2 = new Word("dog");
      localWord2.increaseTotal(-1);
      
      Word localWord3 = new Word("cat");
      localWord3.increaseTotal(-2);
      localWord2.increaseTotal(-2);
      
      Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", localSet.contains(localWord1));
      Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", localSet.contains(localWord2));
      Assert.assertTrue("allWords does not contain correct Word when some words appear more than once and score is negative", localSet.contains(localWord3));
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when some words appear more than once");
    }
  }
  
  @Test
  public void testIgnoreWordThatStartsWithCharacterThatIsNotALetter()
  {
    Sentence localSentence = new Sentence(0, "word $dog ");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localSentence);
    try
    {
      Set localSet = Analyzer.allWords(localLinkedList);
      if (localSet == null) {
        Assert.fail("allWords returns null when some words start with character that is not a letter");
      } else if (localSet.isEmpty()) {
        Assert.fail("allWords returns empty Set when some words start with character that is not a letter");
      }
      Assert.assertTrue("allWords contains incorrect number of elements when some words start with character that is not a letter", 1 == localSet.size());
      
      Word localWord = new Word("word");
      localWord.increaseTotal(0);
      
      Assert.assertTrue("allWords does not contain correct Word when some words start with character that is not a letter", localSet.contains(localWord));
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when some words start with character that is not a letter");
    }
  }
  
  @Test
  public void testIgnoreWordThatIsSingleCharacterThatIsNotALetter() {
    Sentence localSentence = new Sentence(0, "word dog ?");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localSentence);
    try
    {
      Set localSet = Analyzer.allWords(localLinkedList);
      if (localSet == null) {
        Assert.fail("allWords returns null when some words are single character that is not a letter");
      } else if (localSet.isEmpty()) {
        Assert.fail("allWords returns empty Set when some words are single character that is not a letter");
      }
      Assert.assertTrue("allWords contains incorrect number of elements when some words are single character that is not a letter", 2 == localSet.size());
      
      Word localWord1 = new Word("word");
      localWord1.increaseTotal(0);
      Word localWord2 = new Word("word");
      localWord2.increaseTotal(0);
      
      Assert.assertTrue("allWords does not contain correct Word when some words are single character that is not a letter", localSet.contains(localWord1));
      Assert.assertTrue("allWords does not contain correct Word when some words are single character that is not a letter", localSet.contains(localWord2));
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when some words are single character that is not a letter");
    }
  }
  
  @Test
  public void testCaseInsensitivity()
  {
    Sentence localSentence1 = new Sentence(0, "word dog ");
    Sentence localSentence2 = new Sentence(0, "cat DOG ");
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(localSentence1);
    localLinkedList.add(localSentence2);
    try
    {
      Set localSet = Analyzer.allWords(localLinkedList);
      if (localSet == null) {
        Assert.fail("allWords returns null when some words are same ignoring case");
      } else if (localSet.isEmpty()) {
        Assert.fail("allWords returns empty Set when some words are same ignoring case");
      }
      Assert.assertTrue("allWords contains incorrect number of elements when some words are same ignoring case", 3 == localSet.size());
      
      Word localWord1 = new Word("word");
      localWord1.increaseTotal(0);
      Word localWord2 = new Word("dog");
      localWord2.increaseTotal(0);
      
      Word localWord3 = new Word("cat");
      localWord3.increaseTotal(0);
      localWord2.increaseTotal(0);
      
      Assert.assertTrue("allWords does not contain correct Word when some words are same ignoring case", localSet.contains(localWord1));
      Assert.assertTrue("allWords does not contain correct Word when some words are same ignoring case", localSet.contains(localWord2));
      Assert.assertTrue("allWords does not contain correct Word when some words are same ignoring case", localSet.contains(localWord3));
    }
    catch (Exception localException) {
      Assert.fail("allWords throws " + localException + " when some words are same ignoring case");
    }
  }
}
