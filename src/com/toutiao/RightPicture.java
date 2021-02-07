package com.toutiao;

class Node {
    Node left;
    Node right;
    int value;
    Node () {

    }
}
public class RightPicture {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        Node root = new Node();
        root.value = 1;
        Node _2 = new Node();
        _2.value = 2;
        Node _4 = new Node();
        _4.value = 4;
        Node _6 = new Node();
        _6.value = 6;
        Node _8 = new Node();
        _8.value = 8;
        root.left = _2;
        root.right = _4;
        _2.left = _6;
        _2.right = _8;

        System.out.println(height(root));
        System.out.println();
        System.out.println(root.value);
        rightPicture(root);
    }

    public static int height(Node node) {
        if (node == null) return 0;

        int  leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int maxHeight = leftHeight > rightHeight ? leftHeight : rightHeight;
        return maxHeight + 1;
    }

    public static void rightPicture(Node node) {
        if (node == null) {
            return;
        }
        Node lastLeftNode = node.left;
        Node tmpNode = node.right;
        while (tmpNode != null) {
            System.out.println(tmpNode.value);
            lastLeftNode = node.left;
            tmpNode = tmpNode.right;
        }
        rightPicture(lastLeftNode);
    }

}