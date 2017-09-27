import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DepthTest
{
    protected BinarySearchTree<String> tree;

    @Before
    public void setUp()
            throws Exception
    {
        this.tree = new BinarySearchTree();
        this.tree.add("dog");
        this.tree.add("cat");
        this.tree.add("pig");
    }

    @Test
    public void testNull()
    {
        try
        {
            int i = this.tree.depth(null);
            Assert.assertEquals("depth should be -1 when input value is null", -1L, i);
        }
        catch (Exception localException)
        {
            Assert.fail("depth throws " + localException + " when input value is null");
        }
    }

    @Test
    public void testNotInTree()
    {
        try
        {
            int i = this.tree.depth("banana");
            Assert.assertEquals("depth should be -1 when input value is not in tree", -1L, i);
        }
        catch (Exception localException)
        {
            Assert.fail("depth throws " + localException + " when input value is not in tree");
        }
    }

    @Test
    public void testRoot()
    {
        try
        {
            int i = this.tree.depth("dog");
            Assert.assertEquals("depth should be 0 when input value is root", 0L, i);
        }
        catch (Exception localException)
        {
            Assert.fail("depth throws " + localException + " when input value is root");
        }
    }

    @Test
    public void testLeftChildOfRoot()
    {
        try
        {
            int i = this.tree.depth("cat");
            Assert.assertEquals("depth should be 1 when input value is left child of root", 1L, i);
        }
        catch (Exception localException)
        {
            Assert.fail("depth throws " + localException + " when input value is left child of root");
        }
    }

    @Test
    public void testRightChildOfRoot()
    {
        try
        {
            int i = this.tree.depth("pig");
            Assert.assertEquals("depth should be 1 when input value is right child of root", 1L, i);
        }
        catch (Exception localException)
        {
            Assert.fail("depth throws " + localException + " when input value is right child of root");
        }
    }

    @Test
    public void testGrandchildOfRoot()
    {
        try
        {
            this.tree.add("ant");
            int i = this.tree.depth("ant");
            Assert.assertEquals("depth should be 2 when input value is grandchild of root", 2L, i);
        }
        catch (Exception localException)
        {
            Assert.fail("depth throws " + localException + " when input value is grandchild of root");
        }
    }
}
