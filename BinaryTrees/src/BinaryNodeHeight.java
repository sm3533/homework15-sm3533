public class BinaryNodeHeight<E> {
    public static void main(String[] args) {
        BinaryNode<Integer> b3 = new BinaryNode<>(11,null,null);
        b3.binaryInsert(9,b3);
        b3.binaryInsert(7,b3);
        b3.binaryInsert(6,b3);
        b3.binaryInsert(5,b3);
        b3.binaryInsert(4,b3);
        b3.binaryInsert(3,b3);
        b3.binaryInsert(2,b3);
        int count=b3.height(b3)-1;
        System.out.println("The height of the binary tree is "+count);
        //System.out.println(Math.pow(2,3+1)-1);
    }
}
