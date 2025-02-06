import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque estacionamento = new Deque(10);

        while(true) {
            System.out.print("\nEscolha uma opção:\n" + 
                "C para chegada na PT\n" +
                "R para chegada na RBC\n" +
                "P para partida pela RBC\n" +
                "E para exibir a situação do estacionamento\n" +
                "F para finalizar \n");
            String comando = scanner.next();
            
            if (comando.equals("F")) {
                System.out.println("Saindo...");
                break;
            }

            if(comando.equals("C") || comando.equals("c")) {
                System.out.print("\nDigite a placa: ");
                String placa = scanner.next();

                System.out.println("\nChegada do veículo " + placa + " na PT (entrada principal).");
                estacionamento.inserirInicio(placa);

            } else if(comando.equals("P") || comando.equals("p")) {
                System.out.print("\nDigite a placa: ");
                String placa = scanner.next();
                
                estacionamento.removerCarro(placa);

            } 
            
            //Daqui até o próximo comentário é tudo...
                else if(comando.equals("R") || comando.equals("r")) {
                    System.out.print("\nDigite a placa: ");
                    String placa = scanner.next();
                    
                    System.out.println("\nChegada do veículo " + placa + " na RBC (entrada secundária).");
                    estacionamento.inserirFim(placa);
                } 
            //a parte se pudesse inserir pela RBC !(^o^)!

            else if(comando.equals("E") || comando.equals("e")) {
                System.out.println("\nSituação do estacionamento: ");
                estacionamento.exibir();

            } else {
                System.out.println("\nComando inválido!");
            }
        }

        scanner.close();
    }
}
