package NaoDirecionado;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GrafoNaoDirecionado {
    private int numVertices;
    private boolean[][] matrizAdjacencia;

    public GrafoNaoDirecionado(int numVertices) {
        this.numVertices = numVertices;
        this.matrizAdjacencia = new boolean[numVertices][numVertices];
    }

    public void adicionarAresta(int v1, int v2) {
        if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
            matrizAdjacencia[v1][v2] = true;
            matrizAdjacencia[v2][v1] = true;
        } else {
            System.out.println("Índices de vértices inválidos.");
        }
    }

    public void removerAresta(int v1, int v2) {
        if (v1 >= 0 && v1 < numVertices && v2 >= 0 && v2 < numVertices) {
            matrizAdjacencia[v1][v2] = false;
            matrizAdjacencia[v2][v1] = false;
        } else {
            System.out.println("Índices de vértices inválidos.");
        }
    }

    public void imprimirMatrizAdjacenciaApartirDe(int verticeInicial) {
        if (verticeInicial < 0 || verticeInicial >= numVertices) {
            System.out.println("Vértice inicial inválido.");
            return;
        }

        boolean[] visitado = new boolean[numVertices];
        boolean[][] matrizResultado = new boolean[numVertices][numVertices];
        Stack<Integer> pilha = new Stack<>();

        pilha.push(verticeInicial);

        while (!pilha.isEmpty()) {
            int vertice = pilha.pop();
            System.out.println("Ta aqui" + vertice);
            if (!visitado[vertice]) {
                visitado[vertice] = true;
                for (int i = 0; i < numVertices; i++) {
                    System.out.println("Ta aqui dentro" + i);
                    System.out.println(!visitado[i]);
                    if (matrizAdjacencia[vertice][i] && !visitado[i]) {
                        pilha.push(i);
                        matrizResultado[vertice][i] = true;
                        matrizResultado[i][vertice] = true;
                    }
                }
            }
        }

        System.out.println("Matriz de Adjacência a partir do vértice " + verticeInicial + ":");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print((matrizResultado[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    public boolean contemCiclo() {
        boolean[] visitado = new boolean[numVertices];

        for (int verticeInicial = 0; verticeInicial < numVertices; verticeInicial++) {
            if (!visitado[verticeInicial]) {
                if (contemCicloBFS(verticeInicial, visitado)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean contemCicloBFS(int verticeInicial, boolean[] visitado) {
        Queue<Integer> fila = new LinkedList<>();
        int[] pai = new int[numVertices];

        fila.add(verticeInicial);
        visitado[verticeInicial] = true;
        pai[verticeInicial] = -1;

        while (!fila.isEmpty()) {
            int vertice = fila.poll();

            for (int i = 0; i < numVertices; i++) {
                if (matrizAdjacencia[vertice][i]) {
                    if (!visitado[i]) {
                        visitado[i] = true;
                        fila.add(i);
                        pai[i] = vertice;
                    } else if (pai[vertice] != i) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
