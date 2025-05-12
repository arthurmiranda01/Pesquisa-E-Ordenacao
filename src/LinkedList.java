public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addBook(Livro livro) {
        Node newNode = new Node(livro);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayBooks() {
        if (head == null) {
            System.out.println("A lista de livros está vazia.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.livro);
            current = current.next;
        }
    }

    public Livro searchByTitle(String titulo) {
        Node current = head;
        while (current != null) {
            if (current.livro.getTitulo().equalsIgnoreCase(titulo)) {
                return current.livro;
            }
            current = current.next;
        }
        return null;
    }

    public boolean removeByTitle(String titulo) {
        if (head == null) {
            return false;
        }
        if (head.livro.getTitulo().equalsIgnoreCase(titulo)) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.livro.getTitulo().equalsIgnoreCase(titulo)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
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
