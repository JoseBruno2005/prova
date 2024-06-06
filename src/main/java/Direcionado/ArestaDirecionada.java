package Direcionado;

public class ArestaDirecionada<Object> {

    private VerticeDirecionado<Object> verticeOrigem;
    private VerticeDirecionado<Object> verticeDestino;

    public ArestaDirecionada(VerticeDirecionado<Object> verticeOrigem, VerticeDirecionado<Object> verticeDestino){
        this.verticeOrigem = verticeOrigem;
        this.verticeDestino = verticeDestino;
    }

    public VerticeDirecionado<Object> getVerticeOrigem() {
        return verticeOrigem;
    }

    public void setVerticeOrigem(VerticeDirecionado<Object> verticeOrigem) {
        this.verticeOrigem = verticeOrigem;
    }

    public VerticeDirecionado<Object> getVerticeDestino() {
        return verticeDestino;
    }

    public void setVerticeDestino(VerticeDirecionado<Object> verticeDestino) {
        this.verticeDestino = verticeDestino;
    }
}
