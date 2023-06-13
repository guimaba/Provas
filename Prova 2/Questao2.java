import java.util.Scanner;

public class Questao2 {
    public Questao2() {
        Scanner teclado = new Scanner(System.in);
        int[] vetorPacotes = new int[10];
        int[] vetorEnviados = new int[vetorPacotes.length];
        int posicaoAtual = 0;
        int posicaoEnviados = 0;
        String estoqueOUarmazem = "";

        menu(teclado, estoqueOUarmazem, posicaoAtual, posicaoEnviados, vetorPacotes, vetorEnviados);

        teclado.close();
    }

    private void menu(Scanner teclado, String estoqueOUarmazem, int posicaoAtual, int posicaoEnviados, int[] vetorPacotes, int[] vetorEnviados) {
        int opcao = 0;
        do {
            System.out.println("|========================");
            System.out.println("| 1. Cadastrar pacote.");
            System.out.println("| 2. Consultar pacote.");
            System.out.println("| 3. Enviar pacote.");
            System.out.println("| 4. Mostrar pacote.");
            System.out.println("| 5. Encerrar programa.");
            System.out.println("|========================");
            opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                posicaoAtual = cadastrarPacote(teclado, vetorPacotes, posicaoAtual);
                    break;

                case 2:
                    consultarPacote(teclado, vetorPacotes, posicaoAtual);
                    break;

                case 3:
                posicaoAtual = enviarPacote(teclado, vetorPacotes, vetorEnviados, posicaoAtual, posicaoEnviados);
                    break;

                case 4:
                    System.out.println("Deseja vizualizar o Armazém (A) ou os Enviados (E)?");
                    estoqueOUarmazem = teclado.next();
                    if (estoqueOUarmazem.equalsIgnoreCase("A") || estoqueOUarmazem.equalsIgnoreCase("E")) {
                        ordenarVetor(vetorEnviados, vetorPacotes, estoqueOUarmazem);
                        mostrarPacote(teclado, vetorPacotes, vetorEnviados, estoqueOUarmazem);
                    } else {
                        System.out.println("Valor Inválido!");
                    }
                    break;

                case 5:
                    System.out.println("Finalizando Sistema...");
                    break;

                default:
                    System.out.println("Valor inváildo! Digite novamente.");
                    break;
            }
        } while (opcao != 5);
    }

    // Cadastrar pacote
    public int cadastrarPacote(Scanner teclado, int[] vetorPacotes, int posicaoAtual) {
        if (posicaoAtual != vetorPacotes.length) {
            System.out.print("Digite o código do pacote: ");
            int num = teclado.nextInt();
            boolean existe = false;

            for (int i = 0; i < vetorPacotes.length; i++) {
                    if (vetorPacotes[i] == num) {
                        existe = true;
                        break;
                    }   
            }  
            if (!existe) {
                vetorPacotes[posicaoAtual] = num;
            }                
            else {
                System.out.println("Pacote já cadastrado!");
            }          
        }
        else {
            System.out.println("Limite de pacotes atingido!");
        }
        posicaoAtual++;
        return posicaoAtual;
    }

    // Consultar pacote
    public int consultarPacote(Scanner teclado, int[] vetorPacotes, int posicaoAtual) {
        System.out.print("Digite o número: ");
        int num = teclado.nextInt();
        int posicaoEncontrada = -1;
        boolean achou = false;
        for (int i = 0; i < posicaoAtual; i++) {
            if (vetorPacotes[i] == num) {
                achou = true;
                posicaoEncontrada = posicaoAtual;
                break;
            }
        }
        if (achou) {
            System.out.println("O pacote desejado existe! Na posição: " + posicaoEncontrada);
        } else {
            System.out.println("O pacote desejado nao existe.");
        }
        return posicaoEncontrada;
    }

    // Enviar pacote
    public int enviarPacote(Scanner teclado, int[] vetorPacotes, int[] vetorEnviados, int posicaoAtual, int posicaoEnviados) {
        System.out.print("Digite o código do pacote para enviar: ");
        int num = teclado.nextInt();
        boolean excluiu = false;
        for (int i = 0; i < vetorPacotes.length; i++) {
            if (vetorPacotes[i] == num) {
                for (int j = 0; j < vetorEnviados.length; j++)
                if (vetorEnviados[j] != 0) {
                    posicaoEnviados++;
                }
                else {
                    vetorEnviados[posicaoEnviados] = vetorPacotes[i];
                    break;
                }
                vetorPacotes[i] = 0;
                for (int x = (i + 1); x < vetorPacotes.length; x++) {
                    vetorPacotes[x - 1] = vetorPacotes[x];
                }
                excluiu = true;
                
                break;
            }
        }
        if (excluiu) {
            System.out.println("Pavote enviado com sucesso!");

        } else {
            System.out.println("Pacote não pôde ser enviado.");
        }
        posicaoAtual--;
        return posicaoAtual;
    }

    public void ordenarVetor(int[] vetorEnviados, int[] vetorPacotes, String estoqueOUarmazem) {
        int numTemporario = 0;
        int tamVetorPreenchido = 0;
        for (int z = 0; z < vetorPacotes.length; z++) {
            if (vetorPacotes[z] != 0) {
                tamVetorPreenchido++;
            }
            else {
                break;
            }
        }
        if (estoqueOUarmazem.equalsIgnoreCase("A")) {
            for (int i = 0; i < tamVetorPreenchido; i++) {
                
                for (int x = 0; x < tamVetorPreenchido - i - 1; x++) {
                    if (vetorPacotes[i] != 0) {
                    if (vetorPacotes[x] > vetorPacotes[x + 1]) {
                        numTemporario = vetorPacotes[x + 1];
                        vetorPacotes[x + 1] = vetorPacotes[x];
                        vetorPacotes[x] = numTemporario;
                    }
                    }
                }
            }
        }
        tamVetorPreenchido = 0;
        for (int z = 0; z < vetorEnviados.length; z++) {
            if (vetorEnviados[z] != 0) {
                tamVetorPreenchido++;
            }
            else {
                break;
            }
        }
        if (estoqueOUarmazem.equalsIgnoreCase("E")) {
            for (int i = 0; i < vetorEnviados.length; i++) {
                
                for (int x = 0; x < vetorEnviados.length - i - 1; x++) {
                    if (vetorPacotes[i] != 0) {
                    if (vetorEnviados[x] > vetorEnviados[x + 1]) {
                        numTemporario = vetorEnviados[x + 1];
                        vetorEnviados[x + 1] = vetorEnviados[x];
                        vetorEnviados[x] = numTemporario;
                    }
                    }
                }
            }
        }
    }

    // Mostrar pacote
    public void mostrarPacote(Scanner teclado, int[] vetorPacotes, int[] vetorEnviados, String estoqueOUarmazem) {
        if (estoqueOUarmazem.equalsIgnoreCase("A")) {
            for (int i = 0; i < vetorPacotes.length; i++) {
                if (vetorPacotes[i] != 0) {
                    System.out.println("Posição: [" + (i) + "]: " + vetorPacotes[i]);
                }
            }
        } else if (estoqueOUarmazem.equalsIgnoreCase("E")) {
            for (int i = 0; i < vetorEnviados.length; i++) {
                if (vetorEnviados[i] != 0) {
                    System.out.println("Posição: [" + (i) + "]: " + vetorEnviados[i]);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Questao2();
    }
}
