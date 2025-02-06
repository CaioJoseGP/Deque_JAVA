public class Deque {
    No inicio;
    No fim;
    int capacidade;
    int tamanho;

    public Deque(int capacidade) {
        this.inicio = null;
        this.fim = null;
        this.capacidade = capacidade;
        this.tamanho = 0;
    }

    public boolean estaCheio() {
        return tamanho >= capacidade;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public void inserirInicio(int placa) {
        if (estaCheio()) {
            System.out.println("Estacionamento cheio! Carro " + placa + " está aguardando vaga.");
            return;
        }

        No novo = new No(placa);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.proximo = inicio;
            inicio.anterior = novo;
            inicio = novo;
        }
        tamanho++;
        System.out.println("Carro " + placa + " estacionado na PT.");
    }

    public void removerCarro(int placa) {
        if (estaVazio()) {
            System.out.println("O estacionamento está vazio!");
            return;
        }

        No atual = inicio;
        int deslocamentos = 0;
        Deque temporario = new Deque(capacidade);

        while (atual != null && atual.placa != placa) {
            temporario.inserirFim(atual.placa);
            atual = atual.proximo;
            deslocamentos++;
        }

        if (atual == null) {
            System.out.println("Carro " + placa + " não está no estacionamento.");
            return;
        }

        if (atual == inicio) {
            removerInicio();

        } else if (atual == fim) {
            removerFim();

        } else {
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
            tamanho--;
        }

        System.out.println("Carro " + placa + " saiu do estacionamento após " + (deslocamentos + 1) + " deslocamentos.");

        while (!temporario.estaVazio()) {
            inserirInicio(temporario.removerFimRetorno());
        }
    }

    public void removerInicio() {
        if (estaVazio()) {
            System.out.println("Deque Vazio!");
            return;
        }

        inicio = inicio.proximo;
        
        if (inicio != null) {
            inicio.anterior = null;

        } else {
            fim = null;
        }

        tamanho--;
    }

    public void removerFim() {
        if (estaVazio()) {
            System.out.println("Deque Vazio!");
            return;
        }

        fim = fim.anterior;

        if (fim != null) {
            fim.proximo = null;

        } else {
            inicio = null;
        }

        tamanho--;
    }

    public int removerFimRetorno() {
        if (estaVazio()) {
            return -1;
        }

        int placa = fim.placa;
        removerFim();
        return placa;
    }

    public void inserirFim(int placa) {
        if (estaCheio()) return;

        No novo = new No(placa);
        if (inicio == null) {
            inicio = novo;
            fim = novo;

        } else {
            novo.anterior = fim;
            fim.proximo = novo;
            fim = novo;
        }

        tamanho++;
    }

    public void exibir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.placa + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }
}