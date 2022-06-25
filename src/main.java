

public class main {
    public static void main(String[] args) {
        BST bst = new BST(19);

        bst.add(15);
        bst.add(20);
        bst.add(8);
        bst.add(12);
        bst.add(16);
        bst.add(25);


        bst.inOrderRec(bst.root);
        System.out.println("The next key is " + bst.nextKey(15));
        System.out.println("The previous key is " + bst.prevKey(25));

        bst.rangeKey(25, 8);


    }
}
