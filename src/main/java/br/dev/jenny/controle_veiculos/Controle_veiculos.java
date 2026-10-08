package br.dev.jenny.controle_veiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sesi2dia
 */

public class Controle_veiculos {

    public static Scanner teclado = new Scanner(System.in);

    public static List<Veiculo> listaVeiculos = new ArrayList<>();

    public static void main(String[] args) {

        
        int opcao = 0;
        
        
        while (opcao != 99) {

            System.out.println("------------------------------------------");
            System.out.println("Controle de Vei­culos");
            System.out.println("------------------------------------------");
            System.out.println("10-Incluir vei­culo");
            System.out.println("11-Listar vei­culos");
            System.out.println("20-Sai­da de vei­culo");
            System.out.println("21-Relatorio de vei­culos em Linha.");
            System.out.println("30-Entrada de vei­culo");
            System.out.println("31-Relatorio de vei­culos no patio.");
            System.out.println("99-Sair");
            System.out.println("");
            System.out.print("Digite a opcao:");

            opcao = teclado.nextInt();

            switch (opcao) {
                case 10 ->{
                    incluirVeiculo();
                }

                case 11 -> {
                    System.out.println("Voce escolheu Listar Veiculos");
                    listarVeiculos();
                }
                
                case 20 -> {
                    System.out.println("\n\nSaida de Veiculos\n");
                    saidaVeiculo();
                    
                }
                
                case 30 -> {
                    System.out.println("\n\nEntrada de Veiculos\n");
                    entrarVeiculo();
                    
                }
                
                case 21 -> {
                    relatorioVeiculosLinha();
                }
                
                case 31 -> {
                    relatorioVeiculosPatio();
                }
                
                case 99 -> {
                    break;
                }

                // Implementar os outros cases.
            }
        }
    }

    public static void incluirVeiculo() {
        // Conversar com usuario
        System.out.println("Cadastro de Veiculos");

        // pedir dados veiculo (placa marca modelo)
        
        System.out.printf("Insira a placa : ");
        String placa = teclado.next();

        System.out.printf("Insira a marca : ");
        String marca = teclado.next();

        System.out.printf("Insira o modelo: ");
        String modelo = teclado.next();

        Veiculo veic = new Veiculo(placa, marca, modelo);

        listaVeiculos.add(veic);

    }

    public static void listarVeiculos() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Relatorio de Veiculos");
        System.out.println("-------------------------------------------------------------------------");
        // Cabeçalho alinhado com o toString()
        System.out.printf("%-12s %-15s %-15s %-18s %-10s\n", "PLACA", "MODELO", "MARCA", "MOTORISTA", "STATUS");
        System.out.println("-------------------------------------------------------------------------");

        for (Veiculo v : listaVeiculos) {
            System.out.println(v.toString());
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("<<< FIM DO RELATORIO >>>\n\n");
    }
    
    public static void saidaVeiculo() {
        System.out.print("Informe a placa do veiculo para SAIDA: ");
        String placa = teclado.next();
        
        System.out.print("Motorista: ");
        String motorista = teclado.next();
        
        for (int i = 0; i < listaVeiculos.size(); i++) {
            // ALTERADO: Adicionado .replace("-", "") para comparar sem o hífen
            if (listaVeiculos.get(i).getPlaca().replace("-", "").equalsIgnoreCase(placa.replace("-", ""))) {
                listaVeiculos.get(i).sairComVeiculo(motorista);
                System.out.println("Saída registrada com sucesso!");
                break;
            }
        }
    }
    
    public static void entrarVeiculo() {
        System.out.print("Informe a placa do veiculo para ENTRADA: ");
        String placa = teclado.next();
   
        for (int i = 0; i < listaVeiculos.size(); i++) {
            // ALTERADO: Adicionado .replace("-", "") para comparar sem o hífen
            if (listaVeiculos.get(i).getPlaca().replace("-", "").equalsIgnoreCase(placa.replace("-", ""))) {
                listaVeiculos.get(i).entrarComVeiculo();
                System.out.println("Entrada registrada com sucesso!");
                break;
            }
        }
    }
    
    public static void relatorioVeiculosLinha() {
        System.out.println("-".repeat(73));
        System.out.println("Relatorio de Veiculos em Linha (Rua)");
        System.out.println("-".repeat(73));
        System.out.printf("%-12s %-15s %-15s %-18s %-10s\n", "PLACA", "MODELO", "MARCA", "MOTORISTA", "STATUS");
        System.out.println("-".repeat(73));

        for (Veiculo v : listaVeiculos) {
            if (v.getStatus() == StatusVeiculo.RUA) {
                System.out.println(v.toString());
            }
        }

        System.out.println("-".repeat(73));
        System.out.println("<<< FIM RELATORIO >>>\n\n");
    }

    public static void relatorioVeiculosPatio() {
        System.out.println("-".repeat(73));
        System.out.println("Relatorio de Veiculos no Patio");
        System.out.println("-".repeat(73));
        System.out.printf("%-12s %-15s %-15s %-18s %-10s\n", "PLACA", "MODELO", "MARCA", "MOTORISTA", "STATUS");
        System.out.println("-".repeat(73));

        for (Veiculo v : listaVeiculos) {
            if (v.getStatus() == StatusVeiculo.PATIO) {
                System.out.println(v.toString());
            }
        }

        System.out.println("-".repeat(73));
        System.out.println("<<< FIM RELATORIO >>>\n\n");
    }
}
    
