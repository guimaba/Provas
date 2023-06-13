package Prova1GuilhermeMaba.src;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
            char codigo = ler.next().charAt(0);
            codigo = Character.toUpperCase(codigo);
            double salario = ler.nextDouble();
            if (codigo != 'A' && codigo != 'B' && codigo != 'C' && codigo != 'D' && codigo != 'E' && codigo != 'F') {
                System.out.println("Código Inválido!");
            }
            else {
                switch(codigo) {
                    case 'A':
                    if (salario > 2000) {
                        System.out.println("Salário Inválido.");
                        break;
                    }
                    else {
                    System.out.println("Cargo: Atendente");
                    double valorAumento = salario * 0.4;
                    System.out.println("Valor do aumento: " + df.format(valorAumento));
                    double novoSalario = salario + valorAumento;
                    System.out.println("Novo salário: R$" + df.format(novoSalario));
                    break;
                    }
                    case 'B':
                    if (salario > 2200) {
                        System.out.println("Salário Inválido.");
                        break;
                    }
                    else {
                    System.out.println("Cargo: Estoquista");
                    double valorAumento = salario * 0.3;
                    System.out.println("Valor do aumento: " + df.format(valorAumento));
                    double novoSalario = salario + valorAumento;
                    System.out.println("Novo salário: R$" + df.format(novoSalario));
                    break;
                    }
                    case 'C':
                    if (salario > 2200) {
                        System.out.println("Salário Inválido.");
                        break;
                    }
                    else {
                    System.out.println("Cargo: Caixa");
                    double valorAumento = salario * 0.3;
                    System.out.println("Valor do aumento: " + df.format(valorAumento));
                    double novoSalario = salario + valorAumento;
                    System.out.println("Novo salário: R$" + df.format(novoSalario));
                    break;
                    }
                    case 'D':
                    if (salario > 3000) {
                        System.out.println("Salário Inválido.");
                        break;
                    }
                    else {
                    System.out.println("Cargo: Repositor");
                    double valorAumento = salario * 0.2;
                    System.out.println("Valor do aumento: " + df.format(valorAumento));
                    double novoSalario = salario + valorAumento;
                    System.out.println("Novo salário: R$" + df.format(novoSalario));
                    break;
                    }
                    case 'E':
                    if (salario > 3000) {
                        System.out.println("Salário Inválido.");
                        break;
                    }
                    else {
                    System.out.println("Cargo: Comercial");
                    double valorAumento = salario * 0.2;
                    System.out.println("Valor do aumento: " + df.format(valorAumento));
                    double novoSalario = salario + valorAumento;
                    System.out.println("Novo salário: R$" + df.format(novoSalario));
                    break;
                    }
                    case 'F':
                    if (salario > 15000) {
                        System.out.println("Salário Inválido.");
                        break;
                    }
                    else {
                    System.out.println("Cargo: Gerente");
                    System.out.println("Não possui aumento");
                    break;
                    }
                }
            }
        ler.close();
    }
}
