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

    public void infixTraversal(Visitor visitor, BinaryNode<Integer> b1) {
        if (b1 != null) {
            infixTraversal(visitor, b1.left);
            visitor.visit(b1);
            infixTraversal(visitor, b1.right);
        }
    }

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

    public void binaryInsert(int value,BinaryNode<E> B1){

        if(B1.getValue()<value) {
            if (B1.right != null) {
                binaryInsert(value, B1.right);
            } else {
                B1.setRight(new BinaryNode<>(value,null,null));
            }
        } else {
            if (B1.left != null) {
                binaryInsert(value, B1.left);
            } else {
                B1.setLeft(new BinaryNode<>(value,null,null));
            }
        }
    }

    public boolean binarysearch(int target){
        if(this.getValue()==target){
            return true;
        } else if(target>this.getValue()){
            if(this.getRight() != null){
                return this.getRight().binarysearch(target);
            }
        } else {
            if(this.getLeft() != null)
            return this.getLeft().binarysearch(target);
        }
        return false;
    }

    public int height(BinaryNode<E> node){
        int left=1;
        int right=1;

        if(node.getLeft() != null){
            left=left+height(node.getLeft());
        }
        if(node.getRight() != null){
            right=right+height(node.getRight());
        }
        return Math.max(left,right);
    }

    public int countnode(BinaryNode<E> node){
        if(node==null)
            return 0;

        return 1+countnode(node.getLeft())+countnode(node.getRight());
    }
    public boolean isPerfect(BinaryNode<E> node){
        int count=countnode(node);
        int max= height(node)-1;
        int perfect_Formula = (int) (Math.pow(2, max+1)-1);
        return perfect_Formula==count;

    }
    public int leaves(BinaryNode<E> node){
        int count=0;
        if(node==null){
            return count+1;
        }
        return leaves(node.getLeft())+leaves(node.getRight());
    }
    @Override
    public boolean equals(Object node){
        StringifyVisitor str = new StringifyVisitor();
        this.infixTraversal(str,this);

        }
        return flag;
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
        b1.binaryInsert(8,b1);

        System.out.println("Creating a sorted Binary Tree");
        BinaryNode<Integer> b2 = new BinaryNode<>(39,null,null);
        b2.binaryInsert(25,b2);
        b2.binaryInsert(136,b2);
        b2.binaryInsert(93,b2);
        b2.binaryInsert(196,b2);
        b2.binaryInsert(471,b2);
        b2.binaryInsert(8,b2);
        b2.binaryInsert(134,b2);
        b2.binaryInsert(65,b2);
        b2.binaryInsert(6,b2);
        b2.binaryInsert(130,b2);
        b2.binaryInsert(150,b2);
        StringifyVisitor str2 = new StringifyVisitor();
        b2.infixTraversal(str2, b2);
        System.out.println("Sorted Binary Tree created "+ str2);

        System.out.println(b2.binarysearch(134));

        int count=b2.height(b2)-1;
        System.out.println(count);
    }
}
