// package Library;

// ebook que implementa interface Baixavel
public class VideoDigital extends ItemBibliotecaDigital implements Baixavel, Visualizavel {

    

    public VideoDigital(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public String descricao() {
        return "Video Digital: " + getTitulo() + " por " + getAutor();
    }   

    //baixavel e visualizavel
    @Override
    public void baixar() {
        System.out.println("Baixando o video: " + getTitulo());
    }

    @Override
    public void visualizar() {
        System.out.println("Visualizando o video: " + getTitulo());
    }


}