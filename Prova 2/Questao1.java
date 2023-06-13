import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) throws Exception {
        Scanner teclado = new Scanner(System.in);
        
        int idade = 0;
        int individuo = 0;
        int ate15 = 0;
        int d16a30 = 0;
        int d31a45 = 0;
        int d46a60 = 0;
        int acima61 = 0;
        double media = 0;
        String maior = "";

        do {
            individuo++;
            System.out.print("Escreva a idade do invidíduo (" + individuo + "): ");
            idade = teclado.nextInt();
            media += idade;
            if (idade < 16 && idade >= 0) {
                ate15++;
            }
            else if (idade > 15 && idade < 31) {
                d16a30++;
            }
            else if (idade > 30 && idade < 46) {
                d31a45++;
            }
            else if (idade > 45 && idade < 61) {
                d46a60++;
            }
            else if (idade >= 61) {
                acima61++;
            }
            else if (idade < 0) {
                individuo--;
                media -= idade;
            }
        } while (idade >= 0);
        
        if (ate15 > acima61 && ate15 > d46a60 && ate15 > d31a45 && ate15 > d16a30) {
            maior = "Até 15 anos";
        }
        if (d16a30 > acima61 && d16a30 > d46a60 && d16a30 > d31a45 && d16a30 > ate15) {
            maior = "De 16 a 30 anos";
        }
        if (d31a45 > acima61 && d31a45 > d46a60 && d31a45 > d16a30 && d31a45 > ate15) {
            maior = "De 31 a 45 anos";
        }
        if (d46a60 > acima61 && d46a60 > d31a45 && d46a60 > d16a30 && d46a60 > ate15) {
            maior = "De 46 a 60 anos";
        }
        if (acima61 > d46a60 && acima61 > d31a45 && acima61 > d16a30 && acima61 > ate15) {
            maior = "Acima de 61 anos";
        }

        // individuo == 100%
        // ate15 ==  ?%
        double percentualPrimeiraFaixa = (ate15 * 100) / individuo;
        
        media /= individuo;

        System.out.println("|===========================================|");
        System.out.println("| Até 15 anos: " + ate15);
        System.out.println("| De 16 a 30 anos: " + d16a30);
        System.out.println("| De 31 a 45 anos: " + d31a45);
        System.out.println("| De 46 a 60 anos: " + d46a60);
        System.out.println("| Acima de 61 anos: " + acima61);
        System.out.println("|===========================================|");
        System.out.println("Percentual da primeira faixa em relação ao total é: " + percentualPrimeiraFaixa);
        System.out.println("|===========================================|");
        System.out.println("| Faixa etária com mais pessoas: " + maior);
        System.out.println("|===========================================|");
        System.out.println("| Média de idade das pessoas informadas: " + media);
        System.out.println("|===========================================|");

        teclado.close();
    }
}
