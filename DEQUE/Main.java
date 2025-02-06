import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque estacionamento = new Deque(10);

        while (true) {
            System.out.print("Digite C <placa> para chegada, P <placa> para partida ou F para finalizar: ");
            String comando = scanner.next();
            
            if (comando.equals("F")) {
                break;
            }

            int placa = scanner.nextInt();

            if(comando.equals("C")) {
                estacionamento.inserirInicio(placa);

            } else if(comando.equals("P")) {
                estacionamento.removerCarro(placa);

            } 

            //Caso fosse permitido o carro chegar também pela RBC, a instrução abaixo deve ser implementada:

            /*
                else if(comando.equals("C2")) {
                estacionamento.inserirFim(placa);
            }*/ 
            
            //Além disso, coloca na mensagem do menu a opção C2 ^(°0°)^

            else {
                System.out.println("Comando inválido! Use 'C <placa>' ou 'P <placa>'.");
            }
        }

        scanner.close();
    }
}