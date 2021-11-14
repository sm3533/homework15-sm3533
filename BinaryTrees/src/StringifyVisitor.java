public class StringifyVisitor implements Visitor {
    StringBuilder str = new StringBuilder();

    @Override
    public void visit(BinaryNode node) {
        str.append(node.getValue());
        str.append(", ");
    }

    @Override
    public String toString() {
        return String.valueOf(str);
    }
}
