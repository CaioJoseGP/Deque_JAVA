public class No {
    int placa;
    No anterior, proximo;

    public No(int placa) {
        this.placa = placa;
        this.anterior = null;
        this.proximo = null;
    }
}