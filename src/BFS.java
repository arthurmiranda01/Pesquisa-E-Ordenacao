import java.util.Queue;
import java.util.LinkedList;

class BFS {
    public static boolean percorrerArvore(Node raiz, String titulo) {
        if (raiz == null) {
            return false;
        }

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            Node node = fila.poll();

            // Imprime o livro atual
            System.out.println(node.getLivro());

            // Se encontrou o livro, retorna true
            if (node.getLivro().getTitulo().equals(titulo)) {
                return true;
            }

            // Adiciona o filho esquerdo à fila, se existir
            if (node.getEsquerdo() != null) {
                fila.add(node.getEsquerdo());
            }

            // Adiciona o filho direito à fila, se existir
            if (node.getDireito() != null) {
                fila.add(node.getDireito());
            }
        }

        return false;
    }
}

