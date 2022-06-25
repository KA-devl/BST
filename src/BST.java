

public class BST {
    public class Node {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //BST CLASS
    public Node root;

    public BST() {
        this.root = null;
    }

    public BST(int data) {
        this.root = new Node(data);
    }

    //add method
    public void add(int data) {
        insert(root, data);
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else if (data < root.data) {
            root.left = insert(root.left, data);

        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;

    }

    //Traverse the bst in ascending order (Inorder)
    //Time complexity is O(n)
    public void allKeys() {
        inOrderRec(root);
    }


    public void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data + " ");
            inOrderRec(root.right);
        }
    }


    public Node findKey(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            return root;
            //if the data given is smaller than root, go left
        } else if (root.data > data) {
            return findKey(root.left, data);
            //if the data given is bigger than root, go right
        } else return findKey(root.right, data);
    }

    //REMOVE A KEY (ALL THE NEXT METHODS PLAY A ROLE INTO THE REMOVE KEY
    public void remove(int data) {
        root = removeRec(root, data);
    }

    Node removeRec(Node root, int key) {
        //base case
        if (root == null)
            return root;
        //keep looping through the tree
        if (key < root.data)
            root.left = removeRec(root.left, key);
        else if (key > root.data)
            root.right = removeRec(root.right, key);


        else { //if this is the key, then delete it
            if (root.left == null) //node with no left child
                return root.right;
            else if (root.right == null) //node with no right child
                return root.left;

            root.data = minValue(root.right);
            root.right = removeRec(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    Node minValueRec(Node root) {
        Node n = root;
        //find the left minimum node
        while (n.left != null) {
            n = n.left;
        }
        System.out.println(+n.data);
        return n;
    }

    public int nextKey(int key) {
        return nextKeyRec(root, key);
    }

    public int nextKeyRec(Node root, int data) {
        Node temp = null;
        Node current = root;
        while (current != null) {
            if (current.data > data) {
                temp = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }

        if (findKey(root, data) == null) {
            return 0;
        } else return temp.data;
    }

    public int prevKey(int key) {
        return prevKeyRec(root, key);

    }

    public int prevKeyRec(Node root, int data) {
        Node temp = null;
        Node current = root;
        while (current != null) {
            if (current.data < data) {
                temp = current;
                current = current.right;
            } else {
                current = current.left;
            }
        }

        if (findKey(root, data) == null) {
            return 0;
        } else return temp.data;
    }


    void rangeKey(int key1, int key2) {
        rangeKeyRec2(root, key1, key2);
    }

    void rangeKeyRec2(Node root, int key1, int key2) {
        if (key1 > key2) {
            int temp = key1;
            key1 = key2;
            key2 = temp;
        }
        rangeKeyRec(root, key1, key2);
        System.out.println("The number of keys between " + key1 + " and " + key2 + " is " + (counter - 2));
    }

    public static int counter = 0;

    void rangeKeyRec(Node root, int key1, int key2) {
        /* base case */
        if (root == null) {
            return;
        }
        if (key1 < root.data) {
            rangeKeyRec(root.left, key1, key2);
        }

        /* if root's data lies in range, then prints root's data */
        if (key1 <= root.data && key2 >= root.data) {
            counter++;
            //System.out.print(root.data + " ");
        }

        /* recursively call the right subtree  */
        rangeKeyRec(root.right, key1, key2);

    }
}

