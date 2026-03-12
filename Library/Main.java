// package Library;


//criar ebooks e videos que instanciam ItemBibliotecaDigital e implementam as interfaces Baixavel e Visualizavel
public class Main {
    


    public static void main(String[] args) {

        
        Ebook ebook1 = new Ebook("O Senhor dos Anéis", "J.R.R. Tolkien");
        System.out.println(ebook1.descricao());
        ebook1.baixar();

        Ebook ebook2 = new Ebook("1984", "George Orwell");
        System.out.println("\n" + ebook2.descricao());
        ebook2.baixar();

        VideoDigital video1 = new VideoDigital("Aula de Java", "Professor X");
        System.out.println(video1.descricao());
        video1.baixar();
        video1.visualizar();


        VideoDigital video2 = new VideoDigital("Aula de Python", "Professor Y");
        System.out.println(video2.descricao());
        video2.baixar();
        video2.visualizar();



    }

}
