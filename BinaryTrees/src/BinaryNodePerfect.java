public class BinaryNodePerfect {

    public static void main(String[] args) {

        BinaryNode<Integer> b4 = new BinaryNode<>(39,null,null);
        b4.binaryInsert(25,b4);
        b4.binaryInsert(136,b4);
        b4.binaryInsert(8,b4);
        b4.binaryInsert(26,b4);
        b4.binaryInsert(93,b4);
        b4.binaryInsert(196,b4);
        boolean is_Perf=b4.isPerfect(b4);
        System.out.println("Checking whether the tree is perfect: "+is_Perf);

        BinaryNode<Integer> b5 = new BinaryNode<>(39,null,null);
        b5.binaryInsert(25,b5);
        b5.binaryInsert(136,b5);
        b5.binaryInsert(8,b5);
        b5.binaryInsert(26,b5);
        b5.binaryInsert(93,b5);

        is_Perf= b5.isPerfect(b5);
        System.out.println("Checking whether the tree is perfect: "+is_Perf);
    }

}
