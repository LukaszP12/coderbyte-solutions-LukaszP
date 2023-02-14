package Coderbyte.Medium;

public class PreorderTraversal_M {


    private static class Node {
        String key;
        Node left, right;

        public Node(String item) {
            key = item;
            left = right = null;
        }

    }

    public static class BinaryTree {
        static String preorderString;
        Node root;

        BinaryTree() {
            root = null;
        }

        private Node buildTree(String[] nodes, Node n, int i) {
            if (i < nodes.length) {
                n = new Node(nodes[i]);
                n.left = buildTree(nodes, n.left, 2 * i + 1);
                n.right = buildTree(nodes, n.right, 2 * i + 2);
            }

            return n;
        }


        void printPreorder(Node node, StringBuilder preorderString) {
            if (node == null) {
                return;
            }

            if (node.key != "#") {
                preorderString.append(node.key + " ");
            }

            printPreorder(node.left, preorderString);

            printPreorder(node.right, preorderString);

        }

    }


    public static String PreorderTraversal_M(String[] strArr) {
        BinaryTree tree = new BinaryTree();
        Node node = tree.buildTree(strArr, new Node(strArr[0]), 0);

        StringBuilder builder = new StringBuilder();
        tree.printPreorder(node, builder);

        return builder.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"4", "1", "5", "2", "#", "#", "#"};
        System.out.println(PreorderTraversal_M(strings));

        String[] strings1 = {"5", "2", "6", "1", "9", "#", "8", "#", "#", "#", "#", "4", "#"};
        System.out.println(PreorderTraversal_M(strings1));
    }

}
