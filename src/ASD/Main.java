package ASD;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(1);
        tree.insert(8);
        tree.insert(0);
        tree.insert(9);
        tree.insert(-3);
        tree.print();
        tree.search(9);
        tree.search2(9);
        tree.search3(9);



    }
    public static class BinarySearchTree {
        Node root;
        static class Node {
            int key;
            Node l;
            Node r;
            Node p;
            public Node(int key, Node p) {
                this.key = key;
                this.p = p;
            }
        }
        Node search(Node t, int key) {
            System.out.println();
            print(t);
            if (t == null || t.key == key){
                return t;
            }
            if (key < t.key){
                return search(t.l, key);
            }else{
                return search(t.r, key);
            }
        }


        Node search2(Node t, int key) {
            System.out.println();
            print(t);
            if (key < t.key){
                return search2(t.l, key);
            }
            if (t == null || t.key == key){
                return t;
            }else{
                return search2(t.r, key);
            }
        }
        Node search3(Node t, int key) {
            System.out.println();
            print(t);
            if (key < t.key){
                return search3(t.l, key);
            }else if (t == null || t.key == key){
                return t;
            }else{
                return search3(t.r, key);
            }
        }


        public Node search(int key) {
            return search(root, key);
        }
        public Node search2(int key) {
            return search2(root, key);
        }
        public Node search3(int key) {
            return search3(root, key);
        }
        Node insert(Node t, Node p, int key) {
            if (t == null) {
                t = new Node(key, p);
            } else {
                if (key < t.key)
                    t.l = insert(t.l, t, key);
                else
                    t.r = insert(t.r, t, key);
            }
            return t;
        }
        public void insert(int key) {
            root = insert(root, null, key);
        }
        void replace(Node a, Node b) {
            if (a.p == null)
                root = b;
            else if (a == a.p.l)
                a.p.l = b;
            else
                a.p.r = b;
            if (b != null)
                b.p = a.p;
        }
        void remove(Node t, int key) {
            if (t == null)
                return;
            if (key < t.key)
                remove(t.l, key);
            else if (key > t.key)
                remove(t.r, key);
            else if (t.l != null && t.r != null) {
                Node m = t.r;
                while (m.l != null)
                    m = m.l;
                t.key = m.key;
                replace(m, m.r);
            } else if (t.l != null) {
                replace(t, t.l);
            } else if (t.r != null) {
                replace(t, t.r);
            } else {
                replace(t, null);
            }
        }
        public void remove(int key) {
            remove(root, key);
        }
        void print(Node t) {
            if (t != null) {
                print(t.l);
                System.out.print(t.key + " ");
                print(t.r);
            }
        }
        void printL(Node t){
            if (t != null) {
                print(t.l);
                System.out.print(t.key + " ");
            }
        }
        void printR(Node t){
            if (t != null) {
                print(t.r);
                System.out.print(t.key + " ");
            }
        }
        public void print() {
            print(root);
            System.out.println();
        }
    }
}
