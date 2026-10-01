package br.dev.jenny.controle_veiculos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sesi2dia
 */
public class Controle_veiculos {

    
    public static Veiculo meuVeiculo;
    
    public static Scanner tecladoTexto = new Scanner(System.in);
    public static Scanner tecladoNumero = new Scanner(System.in);
    
    public static List<Veiculo> listaVeiculos = new ArrayList<>();
    
    public static void main(String[] args) {
        
       int opcao;
       
       do{
       // menu
        System.out.printf("------------------------------------------\nControle de Veiculos\n------------------------------------------\n");
        System.out.printf("10-Incluir veiculo\n11-Listar veiculos\n20-Saida de veiculo\n21-Relatorio de veiculos em Linha.\n30-Entrada de veiculo\n31-Relatorio de veiculos no patio.\n99-Sair\nDigite a opcao: ");
        opcao = tecladoNumero.nextInt();
        
        meuVeiculo = new Veiculo();
        
        
        
        switch (opcao){
            case 10:
                incluirVeiculo();
                
                break;
                
            case 11:
                listarVeiculos();
                break;
                
            case 20:
                saidaVeiculo();
        }
       } while (opcao != 99);
    }
    
    public static void incluirVeiculo() {
        
        System.out.printf("\n\n--- Incluir veiculo ---\n");
                
        do {
                System.out.printf("Insira a placa do veiculo: ");
                meuVeiculo.placa = tecladoTexto.nextLine();
                
                if(meuVeiculo.placa.isBlank()){
                    break;
                }
                
                System.out.printf("Insira a marca do veiculo: ");
                meuVeiculo.marca = tecladoTexto.nextLine();
                
                System.out.printf("Insira o modelo do veiculo: ");
                meuVeiculo.modelo = tecladoTexto.nextLine();
                
                listaVeiculos.add(meuVeiculo);
        } while(!meuVeiculo.placa.isBlank());
    }
    
    
    public static void saidaVeiculo() {
        System.out.printf("\n\n--- Saída de veiculos ---\n");
        
        System.out.printf("Informe a placa do veiculo: ");
        String placa = tecladoTexto.nextLine();
        
        for(int i = 0; i < listaVeiculos.size(); i++){
            Veiculo veiculoAtual = listaVeiculos.get(i);
            if(veiculoAtual.placa == placa){
                System.out.printf("Veiculo encontrado!\nDados do veiculo:\nPlaca: %s\nMarca: %s\nModelo: %s\n", veiculoAtual.placa, veiculoAtual.marca, veiculoAtual.modelo);
                
                System.out.printf("Insira o nome do motorista: ");
                veiculoAtual.motorista = tecladoTexto.nextLine();
               if(veiculoAtual.status == 1){
                   System.out.printf("O veiculo ja se encontra em linha!");
               }
               if(veiculoAtual.status != 1){
                veiculoAtual.status = 1;
               }
            }
            // fazer verficacoes
        }
        
    }
    
    
    public static void listarVeiculos() {
        System.out.printf("--- Lista de veiculos ---");
           
        for (int i = 0; i < listaVeiculos.size(); i++){
           
            Veiculo veic = listaVeiculos.get(i);
            System.out.println(veic);
           
        }
        }
}
