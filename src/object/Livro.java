package object;

public class Livro {
    private String titulo;
    private String isbn;
    private Integer codEditor;

    public Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getCodEditor() {
        return codEditor;
    }

    public void setCodEditor(Integer codEditor) {
        this.codEditor = codEditor;
    }

    public Livro(String titulo, String isbn, Integer codEditor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.codEditor = codEditor;
    }
}
