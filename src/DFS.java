class DFS {
    public static boolean percorrerArvore(Node node, String titulo) {
        if (node == null) {
            return false;
        }

        // Imprime o livro atual
        System.out.println(node.getLivro());

        // Se encontrou o livro, retorna true
        if (node.getLivro().getTitulo().equals(titulo)) {
            return true;
        }

        // Percorrer a árvore à esquerda
        if (percorrerArvore(node.getEsquerdo(), titulo)) {
            return true;
        }

        // Percorrer a árvore à direita
        return percorrerArvore(node.getDireito(), titulo);
    }
}

