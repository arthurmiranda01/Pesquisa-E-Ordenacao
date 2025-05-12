public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(Livro livro) {
        Node newNode = new Node(livro);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public Livro dequeue() {
        if (front == null) {
            return null; // Fila vazia
        }
        Livro livro = front.livro;
        front = front.next;
        if (front == null) {
            rear = null; // Fila ficou vazia
        }
        return livro;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("A lista de espera está vazia.");
            return;
        }
        Node current = front;
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


