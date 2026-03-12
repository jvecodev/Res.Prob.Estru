public class listWithoutArray2 {

    // This is the smae thing that array makes internal
    // When complet the size of the array
    // Fit in other place in memory with double the size
    // Copy the data to bigger array

    private int size;
    private int[] data;

    public listWithoutArray2(){
        data = new int[2];
        size = 0;
    }

    public void addData(int value){
        if (size == data.length){
            int [] newData = new int [data.length * 2];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }

        data[size] = value;
        size++;
    }

    public void show(){
        for (int q = 0; q < size; q++) {
            System.out.println(data[q]);
        }
    }

    public static void main(String[] args) {

        listWithoutArray2 list = new listWithoutArray2();

        list.addData(1);
        list.addData(2);
        list.addData(3);
        list.addData(4);

        list.show();
    }
}