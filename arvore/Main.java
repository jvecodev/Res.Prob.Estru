package arvore;

public class Main {
    public static void main(String[] args) {

        Arvore arvore = new Arvore();

        arvore.insert(new Node(10));
        arvore.insert(new Node(5));
        arvore.insert(new Node(15));
        arvore.insert(new Node(3));
        arvore.insert(new Node(7));

        System.out.print("InOrder: ");
        arvore.inOrder(); 

        System.out.println("\nBusca 7: " + (arvore.search(7) != null));

        arvore.remove(5);

        System.out.print("Após remover 5: ");
        arvore.inOrder(); 
    }
}