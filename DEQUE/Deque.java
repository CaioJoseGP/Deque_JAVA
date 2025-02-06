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

    public void inserirInicio(String placa) {
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
    }

    public void removerCarro(String placa) {
        if (estaVazio()) {
            System.out.println("O estacionamento está vazio!");
            return;
        }
    
        Deque temporario = new Deque(capacidade);
        No atual = inicio;
    
        while (atual != null) {
            if (!atual.placa.equals(placa)) {
                temporario.inserirFim(atual.placa);
            }
            atual = atual.proximo;
        }
    
        if (temporario.tamanho == tamanho) {
            System.out.println("Carro " + placa + " não está no estacionamento.");
            return;
        }
    
        limparEstacionamento();
    
        while (!temporario.estaVazio()) {
            inserirFim(temporario.removerInicioRetorno());
        }
    
        System.out.println("\nCarro " + placa + " removido do estacionamento.");
    }
    
    private void limparEstacionamento() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public void removerInicio() {
        inicio = inicio.proximo;

        if (inicio != null) {
            inicio.anterior = null;
        } else {
            fim = null;
        }

        tamanho--;
    }

    public void removerFim() {
        fim = fim.anterior;

        if (fim != null) {
            fim.proximo = null;
        } else {
            inicio = null;
        }

        tamanho--;
    }

    public String removerInicioRetorno() {
        if (estaVazio()) {
            return null;
        }
    
        String placa = inicio.placa;
    
        if (inicio == fim) { 
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
    
        tamanho--;
        return placa;
    }

    public void inserirFim(String placa) {
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
        int i = 1;

        if (estaVazio()) {
            System.out.println("Não há veículos cadastrados!");
        }

        while(atual != null) {
            System.out.print(" :[ " + atual.placa + " ]: ");
            atual = atual.proximo;

            if(i == 5) {
                System.out.println("\n");
            }

            i++;
        }

        System.out.println();
    }
}