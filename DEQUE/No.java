public class No {
    String placa;
    No anterior, proximo;

    public No(String placa) {
        this.placa = placa;
        this.anterior = null;
        this.proximo = null;
    }
}