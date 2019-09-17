/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Automatos {
     
    public static void main(String[] args) throws FileNotFoundException, IOException {
        AFD afd1 = new AFD();
        AFD afd2 = new AFD();
        int operacao=0;
        Ler_Arquivo(afd1,afd2,operacao);//função para ler arquivos.
        
    }

    private static void Ler_Arquivo(AFD afd1,AFD afd2,int operacao) throws FileNotFoundException, IOException {// caso não exista o arquivo, função não executa
       
       FileReader arquivo = new FileReader("C:\\Users\\Matheus\\Automatos\\entrada.dat");
       BufferedReader leitor = new BufferedReader(arquivo);
       
       String[] vetor_de_item ;//vetor de itens da linha
       ArrayList<String> aux = new ArrayList();//array auxiliar
       ArrayList<Transicao> aux_trans = new ArrayList();//array auxiliar
       Transicao auxx = new Transicao();
       String est;
       String Linha=leitor.readLine();
       
       while(!"$".equals(Linha)){//enquanto a leitura do automato não acabou
                    
           operacao = Integer.parseInt(Linha);//lenda a primeria linha do arquivo - a operaçao
           System.out.println("operação: "+operacao);
           Linha = leitor.readLine();
           
           //Estados
           vetor_de_item = Linha.split(",");//quebrando a linha em subvetores
           aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxilair
           afd1.setEstados(aux);//recebe o array
           
           System.out.println("Estados: "+Arrays.toString(vetor_de_item));
           Linha = leitor.readLine();//ler a próxima linha 
                  
           //Alfabeto
           vetor_de_item = Linha.split(",");//quebrando a linha em subvetores
           aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxilair
           afd1.setAlfabeto(aux);//recebe o array
           System.out.println("Alfabeto: "+Arrays.toString(vetor_de_item));
           Linha = leitor.readLine();
          
           System.out.println("Estados:");
           
           while(!Linha.contains(">")){
               //q0,0,q1
               vetor_de_item = Linha.split(",");//quebrando a linha em subvetores
               
               for(String item : vetor_de_item){
                   auxx = new Transicao();//gerando novo endereço de memoria
                   auxx.Est_Origem = vetor_de_item[0];
                   auxx.Simbolo = vetor_de_item[1]; //simbolo = alfabeto
                   auxx.Est_Destino = vetor_de_item[2];
                   //Exemplo: |q0|0|q1|
                   aux_trans.add(auxx);
                }
               
               System.out.println("\t"+auxx.Est_Origem+","+auxx.Simbolo+","+auxx.Est_Destino);
               afd1.setTransicao(aux_trans);
               Linha = leitor.readLine();
           }
           
           //Estado Inicial
           est = Linha.replace(">", "");//removendo o sinal de >
           afd1.setEstInicial(est);//recebe o array
           System.out.println("estado inicial: "+est);
           Linha = leitor.readLine();
           
           //Estado Final
           est = Linha.replace("*", "");//removendo o sinal de *
           vetor_de_item = est.split(",");
           aux.addAll(Arrays.asList(vetor_de_item));
           afd1.setEstFinal(aux);//recebe o array
           System.out.println("Estado final: : "+Arrays.toString(vetor_de_item));
           Linha = leitor.readLine();
           
           
       }// fim do while
       //=================================================================================================================
       //Leitura do arquivo para o 2° AFD
       
       Linha = leitor.readLine();
           
           //Estados
           vetor_de_item = Linha.split(",");//quebrando a linha em subvetores
           aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxilair
           afd2.setEstados(aux);//recebe o array
           
           System.out.println("\n\nEstados: "+Arrays.toString(vetor_de_item));
           Linha = leitor.readLine();
                  
           //Alfabeto
           vetor_de_item = Linha.split(",");//quebrando a linha em subvetores
           aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxilair
           afd2.setAlfabeto(aux);//recebe o array
           System.out.println("Alfabeto: "+Arrays.toString(vetor_de_item));
           Linha = leitor.readLine();
          
           System.out.println("Estados:");
           while(!Linha.contains(">")){
               //q0,0,q1
               vetor_de_item = Linha.split(",");//quebrando a linha em subvetores
               for(String item : vetor_de_item){
                   auxx = new Transicao();//gerando novo endereço de memoria
                   auxx.Est_Origem= vetor_de_item[0];
                   auxx.Simbolo = vetor_de_item[1];
                   auxx.Est_Destino = vetor_de_item[2];
                   aux_trans.add(auxx);
                   
               }
               System.out.println("\t"+auxx.Est_Origem+","+auxx.Simbolo+","+auxx.Est_Destino);
               afd2.setTransicao(aux_trans);
               Linha = leitor.readLine();
           }
           
           //Estado Inicial
            est = Linha.replace(">", "");//removendo o sinal de >
           afd2.setEstInicial(est);//recebe o array
           System.out.println("estado inicial: "+est);
           Linha = leitor.readLine();
           
           //Estado Final
           est = Linha.replace("*", "");//removendo o sinal de *
           vetor_de_item = est.split(",");
           aux.addAll(Arrays.asList(vetor_de_item));
           afd2.setEstFinal(aux);//recebe o array
          System.out.println("Estado final: : "+Arrays.toString(vetor_de_item));
           Linha = leitor.readLine();
           
           
       }
   
}
