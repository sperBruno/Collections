public class BinarySearchTree<E extends Comparable<E>> {
    protected Node root = null;
    private Node findNode = null;
    private int depthValue = -1;
    private boolean existsValue = false;

    protected void visit(Node n) {
        System.out.println(n.value);
    }

    public boolean contains(E val) {
        return contains(root, val);
    }

    protected boolean contains(Node n, E val) {
        if (n == null) return this.existsValue;

        if (n.value.equals(val)) {
            findNode = n;
            this.existsValue = true;
            return this.existsValue;
        } else if (n.value.compareTo(val) > 0) {
            this.depthValue = depthValue + 1;
            return contains(n.leftChild, val);
        } else {
            this.depthValue = depthValue + 1;
            return contains(n.rightChild, val);
        }
    }

    public boolean add(E val) {
        if (root == null) {
            root = new Node(val);
            return true;
        }
        return add(root, val);
    }

    protected boolean add(Node n, E val) {
        if (n == null) {
            return false;
        }
        int cmp = val.compareTo(n.value);
        if (cmp == 0) {
            return false; // this ensures that the same value does not appear more than once
        } else if (cmp < 0) {
            if (n.leftChild == null) {
                n.leftChild = new Node(val);
                return true;
            } else {
                return add(n.leftChild, val);
            }
        } else {
            if (n.rightChild == null) {
                n.rightChild = new Node(val);
                return true;
            } else {
                return add(n.rightChild, val);
            }
        }
    }

    public boolean remove(E val) {
        return remove(root, null, val);
    }

    protected boolean remove(Node n, Node parent, E val) {
        if (n == null) return false;

        if (val.compareTo(n.value) == -1) {
            return remove(n.leftChild, n, val);
        } else if (val.compareTo(n.value) == 1) {
            return remove(n.rightChild, n, val);
        } else {
            if (n.leftChild != null && n.rightChild != null) {
                n.value = maxValue(n.leftChild);
                remove(n.leftChild, n, n.value);
            } else if (parent == null) {
                root = n.leftChild != null ? n.leftChild : n.rightChild;
            } else if (parent.leftChild == n) {
                parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
            } else {
                parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
            }
            return true;
        }
    }

    protected E maxValue(Node n) {
        if (n.rightChild == null) {
            return n.value;
        } else {
            return maxValue(n.rightChild);
        }
    }

    /*********************************************
     *
     * IMPLEMENT THE METHODS BELOW!
     *
     *********************************************/


    // Method #1.
    public Node findNode(E val) {
        if (val != null) {
            contains(val);
        }
        return this.findNode;

//	return findNode(root, val);

    }

//    private Node findNode(Node n, E val) {
//        System.out.println("Value: " + val);
//        if (n == null || val == null) return null;
//
//        if (n.value.equals(val)) {
//            return n;
//        } else if (n.value.compareTo(val) > 0) {
//            return findNode(n.leftChild, val);
//        } else {
//            return findNode(n.rightChild, val);
//        }
//    }
    // Method #2.
    protected int depth(E val) {

		if(val != null) {
		    this.depthValue = 0;
		    existsValue = contains(val);
            if(this.existsValue == false && this.depthValue>0){
                this.depthValue = -1;
            }
		    return this.depthValue;
        }


        return this.depthValue; // this line is here only so this code will compile if you don't modify it

    }

    // Method #3.
    protected int height(E val) {

		if (val == null || !contains(val)) {return -1;}

        return -2; // this line is here only so this code will compile if you don't modify it

    }

    // Method #4.
    protected boolean isBalanced(Node n) {

		/* IMPLEMENT THIS METHOD! */

        return true; // this line is here only so this code will compile if you don't modify it

    }

    // Method #5. .
    public boolean isBalanced() {

		/* IMPLEMENT THIS METHOD! */

        return false; // this line is here only so this code will compile if you don't modify it

    }

    class Node {
        E value;
        Node leftChild = null;
        Node rightChild = null;

        Node(E value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if ((obj instanceof BinarySearchTree.Node) == false)
                return false;
            Node other = (BinarySearchTree.Node) obj;
            return other.value.compareTo(value) == 0 &&
                    other.leftChild == leftChild && other.rightChild == rightChild;
        }
    }

}
