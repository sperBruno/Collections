/**
 * Created by bruno on 26-09-17.
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsBalancedNodeTest {
    protected BinarySearchTree<String> tree;

    @Before
    public void setUp()
            throws Exception {
        this.tree = new BinarySearchTree();
        this.tree.add("dog");
        this.tree.add("cat");
        this.tree.add("pig");
    }

    @Test
    public void testNull() {
        try {
            boolean bool = this.tree.isBalanced(null);
            Assert.assertFalse("isBalanced should be false when input value is null", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when input value is null");
        }
    }

//    @Test
//    public void testNotInTreeDifferentValue() {
//        BinarySearchTree tmp8_5 = this.tree;
//        tmp8_5.getClass();
//        BinarySearchTree.Node localNode = new BinarySearchTree.Node(tmp8_5, "banana");
//        try {
//            boolean bool = this.tree.isBalanced(localNode);
//            Assert.assertFalse("isBalanced should be false when input Node is not in tree", bool);
//        } catch (Exception localException) {
//            Assert.fail("isBalanced throws " + localException + " when input Node is not in tree");
//        }
//    }

    @Test
    public void testRootBalanced() {
        BinarySearchTree.Node localNode = this.tree.findNode("dog");
        try {
            boolean bool = this.tree.isBalanced(localNode);
            Assert.assertTrue("isBalanced should be true when input Node is root of tree with two children", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when input Node is root of tree with two children");
        }
    }

    @Test
    public void testLeaf() {
        BinarySearchTree.Node localNode = this.tree.findNode("cat");
        try {
            boolean bool = this.tree.isBalanced(localNode);
            Assert.assertTrue("isBalanced should be true when input Node is leaf", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when input Node is leaf");
        }
    }

    @Test
    public void testLeftHeightIsOneGreaterThanRight() {
        this.tree.add("ant");
        BinarySearchTree.Node localNode = this.tree.findNode("dog");
        try {
            boolean bool = this.tree.isBalanced(localNode);
            Assert.assertTrue("isBalanced should be true when difference in heights of child nodes is 1", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of child nodes is 1");
        }
    }

    @Test
    public void testRightHeightIsOneGreaterThanLeft() {
        this.tree.add("zebra");
        BinarySearchTree.Node localNode = this.tree.findNode("dog");
        try {
            boolean bool = this.tree.isBalanced(localNode);
            Assert.assertTrue("isBalanced should be true when difference in heights of child nodes is 1", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of child nodes is 1");
        }
    }

    @Test
    public void testLeftHeightIsTwoGreaterThanRight() {
        this.tree.add("ant");
        this.tree.add("aah!");
        BinarySearchTree.Node localNode = this.tree.findNode("dog");
        try {
            boolean bool = this.tree.isBalanced(localNode);
            Assert.assertFalse("isBalanced should be false when difference in heights of child nodes is more than 1", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of child nodes is more than 1");
        }
    }

    @Test
    public void testRightHeightIsTwoGreaterThanLeft() {
        this.tree.add("rat");
        this.tree.add("skunk");
        BinarySearchTree.Node localNode = this.tree.findNode("dog");
        try {
            boolean bool = this.tree.isBalanced(localNode);
            Assert.assertFalse("isBalanced should be false when difference in heights of child nodes is more than 1", bool);
        } catch (Exception localException) {
            Assert.fail("isBalanced throws " + localException + " when difference in heights of child nodes is more than 1");
        }
    }
}
