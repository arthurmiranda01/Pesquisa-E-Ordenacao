public class BinaryTree {
    private Node root;

    // Construtor
    public BinaryTree() {
        root = null;
    }

    // Método para obter a raiz da árvore
    public Node getRoot() {
        return root;
    }

    // Método para inserir um livro na árvore
    public void inserir(Livro livro) {
        root = inserirRecursivo(root, livro);
    }

    private Node inserirRecursivo(Node node, Livro livro) {
        if (node == null) {
            return new Node(livro);
        }

        if (livro.getTitulo().compareTo(node.getLivro().getTitulo()) < 0) {
            node.setEsquerdo(inserirRecursivo(node.getEsquerdo(), livro));
        } else if (livro.getTitulo().compareTo(node.getLivro().getTitulo()) > 0) {
            node.setDireito(inserirRecursivo(node.getDireito(), livro));
        }

        return node;
    }

    // Método para listar os livros (opcional)
    public void listar() {
        listarRecursivo(root);
    }

    private void listarRecursivo(Node node) {
        if (node != null) {
            listarRecursivo(node.getEsquerdo());
            System.out.println(node.getLivro());
            listarRecursivo(node.getDireito());
        }
    }
}
