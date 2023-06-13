package Prova1GuilhermeMaba.src;

import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String nome = ler.nextLine();
        if (!nome.equals("")) {
            int anoNascimento = ler.nextInt();
            if (anoNascimento > 1900) {
                int idade = 2023 - anoNascimento;
                System.out.println("Nome: " + nome + " Idade: " + idade); 
            }
            else {
                System.out.println("Dados Inválidos!");    
            }
        }
        else {
            System.out.println("Dados Inválidos!");
        }
    ler.close();
    }   
}
