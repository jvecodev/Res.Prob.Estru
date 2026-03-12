// package Library;


public class Ebook extends ItemBibliotecaDigital implements Baixavel {
    
    public Ebook(String titulo, String autor) {
        super(titulo, autor);
    }


    @Override
    public String descricao() {
        return "Ebook: " + getTitulo() + " por " + getAutor();
    }

    //baixavel 
    @Override
    public void baixar() {
        System.out.println("Baixando o ebook: " + getTitulo());
    }

}
