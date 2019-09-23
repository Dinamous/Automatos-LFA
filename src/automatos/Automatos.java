package automatos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Automatos {
    public static  AFD afnd = new AFD();
    public static AFD afd1 = new AFD();
    public static AFD afd2 = new AFD();
    public static int op=0;
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
   
        ArrayList<String> fech = new ArrayList();
    
        Ler_Arquivo();//função para ler arquivos.
        Operacao();
        
       // Fecho(afd1,afd2,fech);
        
    }

    private static void Ler_Arquivo() throws FileNotFoundException, IOException {// caso não exista o arquivo, função não executa
       
        FileReader arquivo = new FileReader("C:\\Users\\Matheus\\Automatos\\entrada.dat");
        BufferedReader leitor = new BufferedReader(arquivo);
        /*buffer é uma região de memória física utilizada para armazenar temporariamente os dados enquanto 
        eles estão sendo movidos de um lugar para outro*/
       
        String[] vetor_de_item ;//vetor de itens da linha (1, 0, q0, q1...)
        ArrayList<String> aux = new ArrayList();//array auxiliar
        ArrayList<Transicao> aux_trans = new ArrayList();//array auxiliar que guarda as transições 
        Transicao auxx = new Transicao();//instanciando a transição
        String est;//guarda o estado
        String Linha=leitor.readLine();//lê linha por linha
       
        while(!"$".equals(Linha)){//enquanto a leitura do automato não acabou
                    
            op = Integer.parseInt(Linha);//lendo a primeria linha do arquivo - a operaçao
            System.out.println("operação: "+op);
            Linha = leitor.readLine();
           
            //Estados
            vetor_de_item = Linha.split(",");//quebrando a linha em subvetores, separando estados, na linha 2, elementos do alfabeto, etc
            aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxiliar
            afd1.estados = aux;//recebe o array
           
            System.out.println("Estados: "+Arrays.toString(vetor_de_item));
            Linha = leitor.readLine();//ler a próxima linha 
                  
            //Alfabeto
            vetor_de_item = Linha.split(",");//quebrando a linha em subvetores para pegar os elementos do alfabeto
            aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxilair
            afd1.alfabeto = aux;//recebe o array
            System.out.println("Alfabeto: "+Arrays.toString(vetor_de_item));//printa os itens do alfabeto
            Linha = leitor.readLine();//ler a próxima linha 
          
            System.out.println("Transições:");
           
            while(!Linha.contains(">")){
                //q0,0,q1
                vetor_de_item = Linha.split(",");//quebrando a linha em subvetores para pegar os estados
               
                for(String item : vetor_de_item){
                    auxx = new Transicao();//gerando novo endereço de memoria
                    auxx.Est_Origem = vetor_de_item[0];
                    auxx.Simbolo = vetor_de_item[1]; //simbolo = alfabeto
                    auxx.Est_Destino = vetor_de_item[2];
                    //Exemplo: |q0|0|q1|
                    aux_trans.add(auxx);
                }
               
                System.out.println("\t"+auxx.Est_Origem+","+auxx.Simbolo+","+auxx.Est_Destino);
                afd1.transicao = aux_trans;
                Linha = leitor.readLine();
            }
           
            //Estado Inicial
            est = Linha.replace(">", "");//removendo o sinal de >
            afd1.estInicial =est;//recebe o array
            System.out.println("Estado inicial: "+est);
            Linha = leitor.readLine();
           
            //Estado Final
            est = Linha.replace("*", "");//removendo o sinal de *
            vetor_de_item = est.split(",");
            aux.addAll(Arrays.asList(vetor_de_item));
            afd1.estFinal = aux;//recebe o array
            System.out.println("Estado final: : "+Arrays.toString(vetor_de_item));
            Linha = leitor.readLine();
           
           
        }// fim do while
        //=================================================================================================================
        //Leitura do arquivo para o 2° AFD
        
        System.out.println("\n..............................\n");
        
        Linha = leitor.readLine();
           
        //Estados
            vetor_de_item = Linha.split(",");//quebrando a linha em subvetores
            aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxilair
            afd2.estados = aux;//recebe o array
            
            System.out.println("Estados: "+Arrays.toString(vetor_de_item));//printa os estados
            Linha = leitor.readLine();//ler a próxima linha 
                  
            //Alfabeto
            vetor_de_item = Linha.split(",");//quebrando a linha em subvetores
            aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxilair
            afd2.alfabeto = aux;//recebe o array
            System.out.println("Alfabeto: "+Arrays.toString(vetor_de_item));//printa o alfabeto
            Linha = leitor.readLine();//ler a próxima linha 
          
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
                afd2.transicao = aux_trans;
                Linha = leitor.readLine();
            }
           
            //Estado Inicial
            est = Linha.replace(">", "");//removendo o sinal de >
            afd2.estInicial =est;//recebe o array
            System.out.println("estado inicial: "+est);
            Linha = leitor.readLine();
           
            //Estado Final
            est = Linha.replace("*", "");//removendo o sinal de *
            vetor_de_item = est.split(",");
            aux.addAll(Arrays.asList(vetor_de_item));
            afd2.estFinal = aux;//recebe o array
            System.out.println("Estado final: : "+Arrays.toString(vetor_de_item));
        
        }
   
    public static void Fecho(){
   
        switch (op) {
            case 1:
                //se for união
                for(String alfa:afd1.estFinal){//percorre os estados finais afd1
                    for(String beta:afd2.estFinal){//percorre os estados finais afd2
                        if((alfa.equals(afd1.estInicial)||(beta.equals(afd2.estInicial)))){
                            //se os estados iniciais são finais também
                            //então qi se torna o primeiro estado
                            afnd.estados.add("qi");
                            afnd.estInicial = "qi";//recebe o estado inicial qi
                            afnd.estados.addAll(afd1.estados);//adicionando os estados de afd1
                            afnd.estados.addAll(afd2.estados);//adicionando os estados de afd2
                            
                            //adicionando os dois alfabetos
                            afnd.alfabeto.addAll(afd1.alfabeto);
                            afnd.alfabeto.addAll(afd2.alfabeto);
                            
                            Set<String> alfbabeto_sem_repeticao = new HashSet<>(afnd.alfabeto);
                            //HashSet é uma estrutura que não permite repetições
                            //Criando um set para remover todos os elementos repetidos
                            afnd.alfabeto.clear();//apagar todos os elementos
                            afnd.alfabeto.addAll(alfbabeto_sem_repeticao);//atualizando o alfabeto sem elementos repetidos
                            
                            
                        }
                    }
                }   break;
            case 2:
                //se for interseção
                for(String alfa:afd1.estFinal){//percorre os estados afd 1
                    for(String beta:afd2.estFinal){//percorre os estados afd 2
                        if((alfa.equals(afd1.estInicial)&&(beta.equals(afd2.estInicial)))){
                            //se os estados iniciais são finais tbm
                            //então qi se torna o primeiro estado
                            afnd.estados.add("qi");
                            afnd.estInicial = "qi";//recebe o estado inicial qi
                            afnd.estados.addAll(afd1.estados);//adicionando os estados de afd1
                            afnd.estados.addAll(afd2.estados);//adicionando os estados de afd1
                            
                            //adicionando os dois alfabetos
                            afnd.alfabeto.addAll(afd1.alfabeto);
                            afnd.alfabeto.addAll(afd2.alfabeto);
                            
                            Set<String> alfbabeto_sem_repeticao = new HashSet<>(afnd.alfabeto);
                            //Criando um set para remover todos os elementos repetidos
                            afnd.alfabeto.clear();//apagar todos os elementos
                            afnd.alfabeto.addAll(alfbabeto_sem_repeticao);//atualizando o alfabeto sem elementos repetidos
                            
                            //Ja que existe um estado qi, deve-se criar as suas transições
                            Transicao trans;
                            afnd.alfabeto.forEach((n) -> {//para cada elemento do alfabeto, existe uma transição do estado qi
                                //TODO
                                //for each para cada afd
                                //verificar se existe um equivalente nas transições
                                //se não existir, o destino é null
                            });
                            
                            
                        }
                    }
                }   break;
        //caso a operação seja outra
            default:
                break;            
        }

    }
    
    public  static void Operacao(){
        System.out.println("Operação:   "+op);
        
        AFND();
        
        switch(op){
            case 1://União
                System.out.println("União");
                Fecho();
                break;
                
            case 2://Interseção
                System.out.println("Interseção");
                break;
                
            case 3://Concatenação
                System.out.println("Concatenação");
                break;
                
            case 4://Combinação (*)
                System.out.println("Combinação");
                break;    
               
        }
        
    }
    
    public static void AFND(){
       Fecho();
    }

}
