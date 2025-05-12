public class Node {
    private Livro livro;
    private Node esquerdo;
    private Node direito;

    public Node(Livro livro) {
        this.livro = livro;
        this.esquerdo = null;
        this.direito = null;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Node getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(Node esquerdo) {
        this.esquerdo = esquerdo;
    }

    public Node getDireito() {
        return direito;
    }

    public void setDireito(Node direito) {
        this.direito = direito;
    }
}

