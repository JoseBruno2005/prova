import Direcionado.GrafoDirecionado;
import NaoDirecionado.GrafoNaoDirecionado;

public class main {
    public static void main(String[] args) {
        GrafoDirecionado<String> grafo = new GrafoDirecionado<>();

        grafo.adicionarVertice("A");
        grafo.adicionarVertice("B");
        grafo.adicionarVertice("C");
        grafo.adicionarVertice("D");
        grafo.adicionarVertice("E");

        grafo.adicionarAresta("A", "B");
        grafo.adicionarAresta("A", "D");
        grafo.adicionarAresta("D", "B");
        grafo.adicionarAresta("C", "B");
        grafo.adicionarAresta("C", "A");
        grafo.adicionarAresta("C", "D");
        //grafo.adicionarAresta("D", "E");


        grafo.imprimirListasAdjacenciaApartirDe("C");

        GrafoNaoDirecionado grafoNaoDirecinado = new GrafoNaoDirecionado(5);

        grafoNaoDirecinado.adicionarAresta(0, 1);
        grafoNaoDirecinado.adicionarAresta(0, 3);
        grafoNaoDirecinado.adicionarAresta(1, 2);
        grafoNaoDirecinado.adicionarAresta(2, 3);
        grafoNaoDirecinado.adicionarAresta(3, 4);

        grafoNaoDirecinado.imprimirMatrizAdjacenciaApartirDe(0);
        System.out.println(grafoNaoDirecinado.contemCiclo());

        GrafoNaoDirecionado grafo3 = new GrafoNaoDirecionado(5);

        grafo3.adicionarAresta(0, 1);
        grafo3.adicionarAresta(1, 2);
        grafo3.adicionarAresta(1, 3);
        grafo3.adicionarAresta(1, 4);

        System.out.println("O grafo contém ciclo? " + grafo3.contemCiclo());


    }
}
