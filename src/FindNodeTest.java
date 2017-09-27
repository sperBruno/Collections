import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindNodeTest
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
    public void testTargetIsRoot()
    {
        try
        {
            BinarySearchTree.Node localNode = this.tree.findNode("dog");
            if (localNode == null) {
                Assert.fail("findNode returned null when looking for value that is root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is root", "dog", localNode.value);
        }
        catch (Exception localException)
        {
            Assert.fail("findNode throws " + localException + " when looking for value that is root");
        }
    }

    @Test
    public void testTargetIsLeftChildOfRoot()
    {
        try
        {
            BinarySearchTree.Node localNode = this.tree.findNode("cat");
            if (localNode == null) {
                Assert.fail("findNode returned null when looking for value that is left child of root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is left child of root", "cat", localNode.value);
        }
        catch (Exception localException)
        {
            Assert.fail("findNode throws " + localException + " when looking for value that is left child of root");
        }
    }

    @Test
    public void testTargetIsRightChildOfRoot()
    {
        try
        {
            BinarySearchTree.Node localNode = this.tree.findNode("pig");
            if (localNode == null) {
                Assert.fail("findNode returned null when looking for value that is right child of root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is right child of root", "pig", localNode.value);
        }
        catch (Exception localException)
        {
            Assert.fail("findNode throws " + localException + " when looking for value that is right child of root");
        }
    }

    @Test
    public void testTargetIsGrandchildOfRoot()
    {
        this.tree.add("ant");
        try
        {
            BinarySearchTree.Node localNode = this.tree.findNode("ant");
            if (localNode == null) {
                Assert.fail("findNode returned null when looking for value that is grandchild of root");
            }
            Assert.assertEquals("findNode returned incorrect Node when looking for value that is grandchild of root", "ant", localNode.value);
        }
        catch (Exception localException)
        {
            Assert.fail("findNode throws " + localException + " when looking for value that is grandchild of root");
        }
    }

    @Test
    public void testTargetIsNotInTree()
    {
        try
        {
            BinarySearchTree.Node localNode = this.tree.findNode("monkey");

            Assert.assertNull("findNode did not return null when looking for value that is not in tree", localNode);
        }
        catch (Exception localException)
        {
            Assert.fail("findNode throws " + localException + " when looking for value that is not in tree");
        }
    }

    @Test
    public void testTargetIsNull()
    {
        try
        {
            BinarySearchTree.Node localNode = this.tree.findNode(null);

            Assert.assertNull("findNode did not return null when input value is null", localNode);
        }
        catch (Exception localException)
        {
            Assert.fail("findNode throws " + localException + " when input value is null");
        }
    }
}
