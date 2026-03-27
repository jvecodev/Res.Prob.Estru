package Queue;

public class Queue<T> {
    private Node<T> top;
    private Node<T> first;
    private int size;

    public Queue() {
        this.top = null;
        this.first = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            top = newNode;
            first = newNode;
        } else {
            first.next = newNode;
            first = newNode;
        }
        size++;

    }

    //Diferente do pop, o dequeue remove o elemento do início da fila (top) e retorna seu valor
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public T front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return top.data;
    }
        

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void show() {
        Node<T> current = top;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void clear() {
        top = null;
        first = null;
        size = 0;
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

    public String toString() {

        String result = "";
        Node<T> current = top;

        for (int i = 0; i < size; i++) {
            result += current.data + " ";
            current = current.next;
        }

        return result;
    }


    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();

        System.out.println("Inserindo elementos na fila:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("\nElementos na fila:");
        queue.show();

        System.out.println("\nPrimeiro elemento da fila:");
        System.out.println(queue.front());

        System.out.println("\nTamanho da fila:");
        System.out.println(queue.size());

        System.out.println("\nFila (toString):");
        System.out.println(queue.toString());

        System.out.println("\nFila em array:");
        Object[] array = queue.toArray();
        for (Object obj : array) {
            System.out.println(obj);
        }

        System.out.println("\nRemovendo elementos da fila:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        System.out.println("\nFila após remoção de todos os elementos:");
        queue.show();

        System.out.println("\nFila está vazia? " + queue.isEmpty());

    }
    

}
