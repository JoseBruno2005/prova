package Direcionado;

import java.util.LinkedList;

public class VerticeDirecionado<Object> {

    private Object dado;
    private LinkedList<VerticeDirecionado<Object>> adjacentes;
    private LinkedList<ArestaDirecionada<Object>> arestasSaida;

    public VerticeDirecionado(Object valor){
        this.dado = valor;
        this.adjacentes = new LinkedList<VerticeDirecionado<Object>>();
        this.arestasSaida = new LinkedList<ArestaDirecionada<Object>>();
    }

    public Object getDado() {
        return dado;
    }

    public void setDado(Object dado) {
        this.dado = dado;
    }

    public LinkedList<VerticeDirecionado<Object>> getAdjacentes() {
        return adjacentes;
    }

    public LinkedList<ArestaDirecionada<Object>> getArestasSaida() {
        return arestasSaida;
    }

    public void adicionarAdjacente(VerticeDirecionado<Object> vertice){
        this.adjacentes.add(vertice);
    }

    public void adicionarArestaSaida(ArestaDirecionada<Object> aresta){
        this.arestasSaida.add(aresta);
    }



}
