package Stack;

// Trabalhando com stack sem funcoes do java.util.Stack

public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    // push: Adiciona um elemento no topo da pilha
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++; 
    }

    public T pop(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public T top(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // size: Retorna o número de elementos na pilha
    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    // show

    public void show(){
        Node<T> current = top;
        for (int i = 0; i < size; i++) {
            System.out.println(current.data);
            current = current.next;
        }
    
    }

    public String toString() {

        String result = "";
        Node<T> current = top;

        for (int i = 0; i < size; i++) {
            result += current.data + " ";
            current = current.next;
        }

        return result;
    }

    public Object[] toArray() {
        Object[] novoArray = new Object[size];
        Node<T> current = top;

        for (int i = 0; i < size; i++) {
            novoArray[i] = current.data;
            current = current.next;
        }


        return novoArray;
    }

    public static void main(String[] args) {

    Stack<Integer> stack = new Stack<>();

    // 🔼 push
    System.out.println("Inserindo elementos:");
    stack.push(10);
    stack.push(20);
    stack.push(30);

    // 👀 show
    System.out.println("\nElementos da pilha:");
    stack.show();

    // 👀 top
    System.out.println("\nTopo da pilha:");
    System.out.println(stack.top());

    // 📏 size
    System.out.println("\nTamanho da pilha:");
    System.out.println(stack.size());

    // 🧾 toString
    System.out.println("\nPilha (toString):");
    System.out.println(stack);

    // 📦 toArray
    System.out.println("\nPilha em array:");
    Object[] array = stack.toArray();
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }

    // 🔽 pop
    System.out.println("\n\nRemovendo elemento:");
    System.out.println("Removido: " + stack.pop());

    // 👀 show depois do pop
    System.out.println("\nPilha após pop:");
    stack.show();

    // 🧹 clear
    System.out.println("\nLimpando pilha...");
    stack.clear();

    // ❓ isEmpty
    System.out.println("Está vazia? " + stack.isEmpty());
}
}   
