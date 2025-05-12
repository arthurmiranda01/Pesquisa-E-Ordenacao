public class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(Livro livro) {
        Node newNode = new Node(livro);
        newNode.next = top;
        top = newNode;
    }

    public Livro pop() {
        if (top == null) {
            return null; // Pilha vazia
        }
        Livro livro = top.livro;
        top = top.next;
        return livro;
    }

    public void displayStack() {
        if (top == null) {
            System.out.println("O histórico está vazio.");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.println(current.livro);
            current = current.next;
        }
    }

    // Classe interna Node para armazenar o livro e o próximo nó
    private class Node {
        Livro livro;
        Node next;

        // Construtor
        public Node(Livro livro) {
            this.livro = livro;
            this.next = null;
        }
    }
}

