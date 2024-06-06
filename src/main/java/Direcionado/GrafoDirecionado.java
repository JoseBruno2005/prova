package Direcionado;

import java.util.LinkedList;

public class GrafoDirecionado<Object> {

    private LinkedList<VerticeDirecionado<Object>> vertices;
    private LinkedList<ArestaDirecionada<Object>> arestas;

    public GrafoDirecionado(){
        this.vertices = new LinkedList<VerticeDirecionado<Object>>();
        this.arestas = new LinkedList<ArestaDirecionada<Object>>();
    }

    public void adicionarVertice(Object dado){
        VerticeDirecionado<Object> novoVertice = new VerticeDirecionado<>(dado);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(Object verticeOrigem, Object verticeFim){
        VerticeDirecionado<Object> inicio = this.buscaVertice(verticeOrigem);
        VerticeDirecionado<Object> fim = this.buscaVertice(verticeFim);
        ArestaDirecionada<Object> aresta = new ArestaDirecionada<>(inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        inicio.adicionarAdjacente(fim);
        this.arestas.add(aresta);
    }

    public void removerAresta(Object dadoOrigem, Object dadoDestino) {
        VerticeDirecionado<Object> origem = buscaVertice(dadoOrigem);
        VerticeDirecionado<Object> destino = buscaVertice(dadoDestino);

        if (origem != null && destino != null) {
            ArestaDirecionada<Object> arestaParaRemover = null;

            for (ArestaDirecionada<Object> aresta : this.arestas) {
                if (aresta.getVerticeOrigem().equals(origem) && aresta.getVerticeDestino().equals(destino)) {
                    arestaParaRemover = aresta;
                    break;
                }
            }

            if (arestaParaRemover != null) {
                this.arestas.remove(arestaParaRemover);
                origem.getArestasSaida().remove(arestaParaRemover);
                origem.getAdjacentes().remove(destino);
            }
        }
    }

    public VerticeDirecionado<Object> buscaVertice(Object dado){
        VerticeDirecionado<Object> vertice = null;
        for (int i=0; i < this.vertices.size(); i ++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }


    public void imprimirListasAdjacenciaApartirDe(Object valorInicial) {
        VerticeDirecionado<Object> inicial = buscaVertice(valorInicial);
        if (inicial == null) {
            System.out.println("Vértice não encontrado.");
            return;
        }

        LinkedList<VerticeDirecionado<Object>> marcados = new LinkedList<>();
        LinkedList<VerticeDirecionado<Object>> fila = new LinkedList<>();
        marcados.add(inicial);
        fila.add(inicial);

        System.out.println("Listas de Adjacência a partir do vértice " + inicial.getDado() + ":");
        while (!fila.isEmpty()) {
            VerticeDirecionado<Object> visitado = fila.remove(0);
            System.out.print(visitado.getDado() + ": ");
            for (VerticeDirecionado<Object> adjacente : visitado.getAdjacentes()) {
                System.out.print(adjacente.getDado() + " ");
                if (!marcados.contains(adjacente)) {
                    marcados.add(adjacente);
                    fila.add(adjacente);
                }
            }
            System.out.println();
        }
    }
}
