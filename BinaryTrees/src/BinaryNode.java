import java.util.SortedMap;

public class BinaryNode<E> {
    private int value;
    private BinaryNode<E> left;
    private BinaryNode<E> right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryNode<E> left) {
        this.left = left;
    }

    public BinaryNode<E> getRight() {
        return right;
    }

    public void setRight(BinaryNode<E> right) {
        this.right = right;
    }

    public BinaryNode(int value) {
        this.value = value;
    }

    public BinaryNode(int value, BinaryNode<E> left, BinaryNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * This method prints all the nodes from left middle and in right way
     * @param visitor
     * @param b1
     */
    public void infixTraversal(Visitor visitor, BinaryNode<Integer> b1) {
        if (b1 != null) {
            infixTraversal(visitor, b1.left);
            visitor.visit(b1);
            infixTraversal(visitor, b1.right);
        }
    }

    /**
     * This method checks if any node is present in the binary tree
     * @param target
     * @param b1
     * @return
     */
    public boolean search(int target, BinaryNode<E> b1) {
        boolean flag;
        if (b1 != null) {
            if (b1.getValue() == target)
                return true;
            flag = search(target, b1.left);
            if (!flag)
                flag = search(target, b1.right);
            return flag;
        }
        return false;
    }

    /**
     * This method is used to insert a new node when created
     * @param value
     * @param B1
     */
    public void binaryInsert(int value, BinaryNode<E> B1) {

        if (B1.getValue() < value) {
            if (B1.right != null) {
                binaryInsert(value, B1.right);
            } else {
                B1.setRight(new BinaryNode<>(value, null, null));
            }
        } else {
            if (B1.left != null) {
                binaryInsert(value, B1.left);
            } else {
                B1.setLeft(new BinaryNode<>(value, null, null));
            }
        }
    }

    /**
     * This method checks if any value is present inside the binary tree
     * @param target
     * @return
     */
    public boolean binarysearch(int target) {
        if (this.getValue() == target) {
            return true;
        } else if (target > this.getValue()) {
            if (this.getRight() != null) {
                return this.getRight().binarysearch(target);
            }
        } else {
            if (this.getLeft() != null)
                return this.getLeft().binarysearch(target);
        }
        return false;
    }

    public int height(BinaryNode<E> node) {
        int left = 1;
        int right = 1;

        if (node.getLeft() != null) {
            left = left + height(node.getLeft());
        }
        if (node.getRight() != null) {
            right = right + height(node.getRight());
        }
        return Math.max(left, right);
    }

    /**
     * This method will return the count of the nodes
     * @param node
     * @return
     */
    public int countnode(BinaryNode<E> node) {
        if (node == null)
            return 0;

        return 1 + countnode(node.getLeft()) + countnode(node.getRight());
    }

    /**
     * The count of the node is got from count node method and then height of the method is got from the height node
     * method, after that height is given to the formula and the result is compared with the number of nodes.
     * @param node
     * @return
     */
    public boolean isPerfect(BinaryNode<E> node) {
        int count = countnode(node);
        int max = height(node) - 1;
        int perfect_Formula = (int) (Math.pow(2, max + 1) - 1);
        return perfect_Formula == count;
    }

    /**
     * This method counts the number of leaves in the binary tree by using recursion.
     * @param node
     * @return
     */
    public int leaves(BinaryNode<E> node) {
        int count = 0;
        if (node == null) {
            return count + 1;
        }
        return leaves(node.getLeft()) + leaves(node.getRight());
    }

    /**
     * This method is used to compare two binary trees at the same time using recursion.
     * @param n1
     * @return , the value is true or false.
     */
    @Override
    public boolean equals(Object n1) {

        BinaryNode<?> node = (BinaryNode) n1;
        boolean result = false;

        if(this.value == node.value){
            result = true;
        }

        if(result) {
            if ((node.left != null && this.left != null)) {
                result = this.left.equals(node.left);
            } else if (node.left != null && this.left == null) {
                result = false;
            } else if (node.left == null && this.left != null) {
                result = false;
            }

            if (node.right != null && this.right != null) {
                result = this.right.equals(node.right);
            } else if (node.right != null && this.right == null) {
                result = false;
            } else if (node.right == null && this.right != null) {
                result = false;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        BinaryNode<Integer> b1 = new BinaryNode<>(2,
                new BinaryNode<>(3, new BinaryNode<>(9,
                        null, null), new BinaryNode<>(4, null, null)),
                new BinaryNode<>(7, new BinaryNode<>(1, null, null),
                        new BinaryNode<>(6, null, null)));

        System.out.println(b1.right.right.value);
        StringifyVisitor str = new StringifyVisitor();
        b1.infixTraversal(str, b1);
        System.out.println(str);
        System.out.println(b1.search(6, b1));
        b1.binaryInsert(8, b1);

        System.out.println("Creating a sorted Binary Tree");
        BinaryNode<Integer> b2 = new BinaryNode<>(39, null, null);
        b2.binaryInsert(25, b2);
        b2.binaryInsert(136, b2);
        b2.binaryInsert(93, b2);
        b2.binaryInsert(196, b2);
        b2.binaryInsert(471, b2);
        b2.binaryInsert(8, b2);
        b2.binaryInsert(134, b2);
        b2.binaryInsert(65, b2);
        b2.binaryInsert(6, b2);
        b2.binaryInsert(130, b2);
        b2.binaryInsert(150, b2);
        StringifyVisitor str2 = new StringifyVisitor();
        b2.infixTraversal(str2, b2);
        System.out.println("Sorted Binary Tree created " + str2);

        System.out.println(b2.binarysearch(134));

        int count = b2.height(b2) - 1;
        System.out.println(count);

        BinaryNode<Integer> b3 = new BinaryNode<>(39, null, null);
        b3.binaryInsert(25, b3);
        b3.binaryInsert(136, b3);
        b3.binaryInsert(93, b3);
        b3.binaryInsert(196, b3);
        b3.binaryInsert(471, b3);
        b3.binaryInsert(8, b3);
        b3.binaryInsert(134, b3);
        b3.binaryInsert(65, b3);
        b3.binaryInsert(6, b3);
        b3.binaryInsert(130, b3);
        b3.binaryInsert(150, b3);

        //System.out.println(b3.binarysearch(130));
        System.out.println(str2);
        StringifyVisitor str3 = new StringifyVisitor();
        b3.infixTraversal(str3,b3);
        System.out.println(str3);
        System.out.println("Two binary trees are equal are not: "+b2.equals(b3));
    }

}
