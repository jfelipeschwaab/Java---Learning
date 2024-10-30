package Revisão03;

abstract class ItemBiblioteca {
    public String titulo;
    public String autor;
    public int anoPublicacao;

    public ItemBiblioteca(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public abstract String getInfo();

    public String getTitulo() {
        return titulo;
    }
}

class Livro extends ItemBiblioteca {
    private String generoLiterario;

    public Livro(String titulo, String autor, int anoPublicacao, String generoLiterario) {
        super(titulo, autor, anoPublicacao);
        this.generoLiterario = generoLiterario;
    }

    @Override
    public String getInfo() {
        return "Livro - Título: " + getTitulo() + ", Autor: " + autor + ", Ano: " + anoPublicacao + ", Gênero: " + generoLiterario;
    }
}

class Revista extends ItemBiblioteca {
    private int numeroDaEdicao;

    public Revista(String titulo, String autor, int anoPublicacao, int numeroDaEdicao) {
        super(titulo, autor, anoPublicacao);
        this.numeroDaEdicao = numeroDaEdicao;
    }

    @Override
    public String getInfo() {
        return "Revista - Título: " + getTitulo() + ", Autor: " + autor + ", Ano: " + anoPublicacao + ", Edição: " + numeroDaEdicao;
    }
}


