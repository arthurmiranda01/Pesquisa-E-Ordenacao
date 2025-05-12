import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Biblioteca com livros (LinkedList)
        LinkedList library = new LinkedList();
        Livro livro1 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954);
        Livro livro2 = new Livro("Berserk", "Kentaro Miura", 1981);
        Livro livro3 = new Livro("Harry Potter", "J.K. Rowling", 1998);
        Livro livro4 = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        Livro livro5 = new Livro("Game of Thrones", "George R.R. Martin", 1996);
        Livro livro6 = new Livro("O Nome do Vento", "Patrick Rothfuss", 2007);
        Livro livro7 = new Livro("O Ladrão de Raios", "Rick Riordan", 2005);
        Livro livro8 = new Livro("Mistborn", "Brandon Sanderson", 2006);
        Livro livro9 = new Livro("Eragon", "Christopher Paolini", 2002);
        Livro livro10 = new Livro("A Guerra dos Tronos", "George R.R. Martin", 1996);  // **10º livro adicionado**

        // Adicionando livros à biblioteca
        library.addBook(livro1);
        library.addBook(livro2);
        library.addBook(livro3);
        library.addBook(livro4);
        library.addBook(livro5);
        library.addBook(livro6);
        library.addBook(livro7);
        library.addBook(livro8);
        library.addBook(livro9);
        library.addBook(livro10);  // **Adicionando o 10º livro**

        // Criando a árvore binária de livros
        BinaryTree bst = new BinaryTree();

        // Inserindo livros na árvore binária (baseado no título)
        bst.inserir(livro1);
        bst.inserir(livro2);
        bst.inserir(livro3);
        bst.inserir(livro4);
        bst.inserir(livro5);
        bst.inserir(livro6);
        bst.inserir(livro7);
        bst.inserir(livro8);
        bst.inserir(livro9);
        bst.inserir(livro10);

        // Exibindo livros da árvore binária
        System.out.println("\nLivros na Árvore Binária:");
        bst.listar();

        // Lista de espera (Fila)
        Queue waitingList = new Queue();
        waitingList.enqueue(livro1);
        waitingList.enqueue(livro2);

        // Histórico de navegação (Pilha)
        Stack navigationHistory = new Stack();
        navigationHistory.push(livro3);

        // Grafo de recomendações
        Grafo grafoLivros = new Grafo();
        grafoLivros.adicionarLivro(livro1);
        grafoLivros.adicionarLivro(livro2);
        grafoLivros.adicionarLivro(livro3);
        grafoLivros.adicionarLivro(livro4);
        grafoLivros.adicionarLivro(livro5);
        grafoLivros.adicionarLivro(livro6);
        grafoLivros.adicionarLivro(livro7);
        grafoLivros.adicionarLivro(livro8);
        grafoLivros.adicionarLivro(livro9);
        grafoLivros.adicionarLivro(livro10);

        // Adicionando relações de recomendações no grafo
        grafoLivros.adicionarRelacao(livro1, livro4);
        grafoLivros.adicionarRelacao(livro1, livro3);
        grafoLivros.adicionarRelacao(livro3, livro7);
        grafoLivros.adicionarRelacao(livro2, livro6);
        grafoLivros.adicionarRelacao(livro5, livro9);
        grafoLivros.adicionarRelacao(livro6, livro8);
        grafoLivros.adicionarRelacao(livro9, livro5);

        // Exibir livros na biblioteca
        System.out.println("\nColeção de Livros:");
        library.displayBooks();

        // Exibir fila de espera
        System.out.println("\nLista de Espera (Fila):");
        waitingList.displayQueue();

        // Exibir histórico de navegação
        System.out.println("\nHistórico de Navegação (Pilha):");
        navigationHistory.displayStack();

        // Solicitar ao usuário o título do livro
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o título do livro para buscar: ");
        String titleToSearch = scanner.nextLine();

        // Busca com DFS
        System.out.println("\nBusca em Profundidade (DFS):");
        if (!DFS.percorrerArvore(bst.getRoot(), titleToSearch)) {
            System.out.println("\nLivro não encontrado na DFS.");
        }

        // Busca com BFS
        System.out.println("\nBusca em Largura (BFS):");
        if (!BFS.percorrerArvore(bst.getRoot(), titleToSearch)) {
            System.out.println("\nLivro não encontrado na BFS.");
        }

        // Busca no Grafo com Dijkstra
        System.out.println("\nBusca no Grafo com Dijkstra:");
        Livro livroBusca = null;
        for (Livro livro : grafoLivros.getLivros()) {
            if (livro.getTitulo().equalsIgnoreCase(titleToSearch)) {
                livroBusca = livro;
                break;
            }
        }

        if (livroBusca != null) {
            grafoLivros.exibirDistancias(livroBusca); // Exibindo as distâncias no grafo
        } else {
            System.out.println("\nLivro não encontrado no grafo.");
        }
    }
}






