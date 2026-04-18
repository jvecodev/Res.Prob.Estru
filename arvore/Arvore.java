package arvore;

public class Arvore {
    

    private Node node;
    private Arvore left;
    private Arvore right;

    public Arvore() {
        this.node = null;
        this.left = null;
        this.right = null;
    }

    public Arvore (Node node){
        this.node = node;
        this.left = null;
        this.right = null;
    }

    public boolean isEmpty() {
        return this.node == null;
    }

    public Node search (int value){

        if(isEmpty()){
            return null;
        }

        if (value == this.node.getValue()){
            return this.node;
        } else if (value < this.node.getValue()){
            if (this.left != null){
                return this.left.search(value);
            } else {
                return null;
            }
        } else {
            if (this.right != null){
                return this.right.search(value);
            } else {
                return null;
            }

        }

    }

    public void insert (Node node){

        if (isEmpty()){
            this.node = node;
        } else if (node.getValue() < this.node.getValue()){
            if (this.left == null){
                this.left = new Arvore(node);
            } else {
                this.left.insert(node);
            }
        } else {
            if (this.right == null){
                this.right = new Arvore(node);
            } else {
                this.right.insert(node);
            }
        }

    }

    public void remove (int value){

        if (isEmpty()){
            return;
        }

        if (value == this.node.getValue()){
            if (this.left == null && this.right == null){
                this.node = null;
            } else if (this.left != null && this.right == null){
                this.node = this.left.node;
                this.right = this.left.right;
                this.left = this.left.left;
            } else if (this.left == null && this.right != null){
                this.node = this.right.node;
                this.left = this.right.left;
                this.right = this.right.right;
            } else {
                Arvore successor = findMin(this.right);
                this.node = successor.node;
                successor.remove(successor.node.getValue());
            }
        } else if (value < this.node.getValue()){
            if (this.left != null){
                this.left.remove(value);
            }
        } else {
            if (this.right != null){
                this.right.remove(value);
            }
        }

    }

    private Arvore findMin(Arvore tree) {
        while (tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    // o inorder é uma forma de percorrer a árvore, visitando primeiro a subárvore esquerda, depois o nó atual e por último a subárvore direita
    public void inOrder() {
        if (!isEmpty()) {
            if (this.left != null) {
                this.left.inOrder();
            }
            System.out.print(this.node.getValue() + " ");
            if (this.right != null) {
                this.right.inOrder();
            }
        }
    }


}
