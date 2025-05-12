import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {
    private Map<Livro, Set<Livro>> grafo;

    public Grafo() {
        grafo = new HashMap<>();
    }

    // Adiciona um livro ao grafo
    public void adicionarLivro(Livro livro) {
        grafo.putIfAbsent(livro, new HashSet<>());
    }

    // Adiciona uma relação de recomendação entre dois livros
    public void adicionarRelacao(Livro livro, Livro livroRelacionado) {
        grafo.putIfAbsent(livro, new HashSet<>());
        grafo.putIfAbsent(livroRelacionado, new HashSet<>());
        grafo.get(livro).add(livroRelacionado);
    }

    // Exibe recomendações de livros para um dado livro
    public Set<Livro> recomendarLivros(Livro livro) {
        return grafo.getOrDefault(livro, new HashSet<>());
    }

    // Exibe as recomendações de todos os livros no grafo
    public void exibirRecomendacoes() {
        for (Map.Entry<Livro, Set<Livro>> entry : grafo.entrySet()) {
            System.out.println("Livro: " + entry.getKey());
            System.out.println("Recomendações:");
            for (Livro recomendado : entry.getValue()) {
                System.out.println("  - " + recomendado);
            }
            System.out.println();
        }
    }

    // Algoritmo de Dijkstra para calcular distâncias mínimas entre livros
    public static Map<Livro, Integer> djikstraSimples(Map<Livro, Set<Livro>> grafo, Livro origem) {
        Map<Livro, Integer> distancias = new HashMap<>();
        Queue<Livro> fila = new LinkedList<>();

        // Inicializa a distância do livro origem para 0
        distancias.put(origem, 0);
        fila.add(origem);

        // Percorre todos os livros relacionados no grafo
        while (!fila.isEmpty()) {
            Livro atual = fila.poll();
            int distanciaAtual = distancias.get(atual);

            // Explora os vizinhos do livro atual (livros relacionados)
            for (Livro vizinho : grafo.getOrDefault(atual, new HashSet<>())) {
                if (!distancias.containsKey(vizinho)) {
                    distancias.put(vizinho, distanciaAtual + 1); // Aumenta a distância
                    fila.add(vizinho);
                }
            }
        }

        return distancias;
    }

    // Exibe as distâncias de cada livro em relação ao livro de origem
    public void exibirDistancias(Livro livroOrigem) {
        Map<Livro, Integer> distancias = djikstraSimples(grafo, livroOrigem);
        System.out.println("Distâncias a partir de: " + livroOrigem);
        for (Map.Entry<Livro, Integer> entry : distancias.entrySet()) {
            System.out.println(entry.getKey() + " -> Distância: " + entry.getValue());
        }
    }

    // Método para obter todos os livros no grafo
    public Set<Livro> getLivros() {
        return grafo.keySet();  // Retorna todos os livros (as chaves do grafo)
    }
}





