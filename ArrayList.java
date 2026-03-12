public class ArrayList {

    private int size;
    private int capacity;
    private int[] data;

    public ArrayList() {
        capacity = 10;
        data = new int[capacity];
        size = 0;
    }

    public int[] toArray() {

        capacity = capacity * 2;
        int[] novoArray = new int[capacity];

        for (int i = 0; i < size; i++) {
            novoArray[i] = data[i];
        }

        return novoArray;
    }

    public void add(int value) {

        if (size == capacity) {
            data = toArray();
        }

        data[size] = value;
        size++;
    }

    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
    }

    public void remove(int index){
        data[index] = 0;
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public void contain(int value){
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                System.out.println("O valor " + value + " está presente na lista.");
                return;
            }
        }
        System.out.println("O valor " + value + " não está presente na lista.");
    }

    public void set(int index, int value){
        data[index] = value;
    }

    public int get( int index){
        return data[index];
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                System.out.println(" indice " + i);
                return i;
            }
        }
        return -1;
    }   


    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        list.show();

        System.out.println("Removendo o elemento no indice 3");

        list.remove(3);

        list.show();

        System.out.println("Verificando se o valor 5 está presente na lista:");

        list.contain(5);

        System.out.println("Usando o get");

        System.out.println(list.get(0));

        System.out.println("Usando o set");

        list.set(0, 100);

        System.out.println(list.get(0));

        System.out.println("Usando o indexOf para encontrar o indice do valor 5");

        list.indexOf(5);

    }
}