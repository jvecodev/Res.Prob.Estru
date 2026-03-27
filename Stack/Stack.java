package Stack;

public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public T top() { 
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        top = null;
        size = 0;
    }

    public void show() {
        Node<T> current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = top;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) result.append(", ");
            current = current.next;
        }
        return result.append("]").toString();
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = top;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    public static void main(String[] args) {

    Stack<Integer> stack = new Stack<>();

    System.out.println("Inserindo elementos:");
    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println("\nElementos da pilha:");
    stack.show();

    System.out.println("\nTopo da pilha:");
    System.out.println(stack.top());

    System.out.println("\nTamanho da pilha:");
    System.out.println(stack.size());

    System.out.println("\nPilha (toString):");
    System.out.println(stack);

    System.out.println("\nPilha em array:");
    Object[] array = stack.toArray();
    for (int i = 0; i < array.length; i++) {
        System.out.print(array[i] + " ");
    }

    System.out.println("\n\nRemovendo elemento:");
    System.out.println("Removido: " + stack.pop());

    System.out.println("\nPilha após pop:");
    stack.show();

    System.out.println("\nLimpando pilha...");
    stack.clear();

    System.out.println("Está vazia? " + stack.isEmpty());
}
}   
