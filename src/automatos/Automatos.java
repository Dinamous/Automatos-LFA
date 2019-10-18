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

    public static AFD afnd = new AFD();
    public static AFD afd1 = new AFD();
    public static AFD afd2 = new AFD();
    public static int op = 0;

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Ler_Arquivo();//função para ler arquivos.
        //Operacao();
        
        //Uniao();
        Intersecao();
        //Concatenacao();
        //Combinacao();
        Printar_Afnd();

    }

    private static void Ler_Arquivo() throws FileNotFoundException, IOException {// caso não exista o arquivo, função não executa

        FileReader arquivo = new FileReader("C:\\Users\\Matheus\\Automatos\\entrada.dat");
        BufferedReader leitor = new BufferedReader(arquivo);
        /*buffer é uma região de memória física utilizada para armazenar temporariamente os dados enquanto 
                        eles estão sendo movidos de um lugar para outro*/

        String[] vetor_de_item;//vetor de itens da linha (1, 0, q0, q1...)
        ArrayList<String> aux = new ArrayList();//array auxiliar
        ArrayList<Transicao> aux_trans = new ArrayList();//array auxiliar que guarda as transições 
        Transicao auxx = new Transicao();//instanciando a transição
        String est;//guarda o estado
        String Linha = leitor.readLine();//lê linha por linha

        while (!"$".equals(Linha)) {//enquanto a leitura do automato não acabou

            op = Integer.parseInt(Linha);//lendo a primeria linha do arquivo - a operaçao
            System.out.println("operação: " + op);
            Linha = leitor.readLine();

            //Estados
            vetor_de_item = Linha.split(",");//quebrando a linha em subvetores, separando estados, na linha 2, elementos do alfabeto, etc
            aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxiliar
            afd1.estados.addAll(aux);//recebe o array

            System.out.println("Estados: " + Arrays.toString(vetor_de_item));
            Linha = leitor.readLine();//ler a próxima linha 

            //Alfabeto
            vetor_de_item = null;

            if (Linha.contains(",")) {
                vetor_de_item = Linha.split(",");//quebrando a linha em subvetores para pegar os elementos do alfabeto
                afd1.alfabeto.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxilair
                System.out.println("Alfabeto: " + Arrays.toString(vetor_de_item));//printa os itens do alfabeto
            } else {
                afd1.alfabeto.add(Linha);
                System.out.println("Alfabeto: " + Linha);
            }

            Linha = leitor.readLine();//ler a próxima linha 

            System.out.println("Transições:");

            while (!Linha.contains(">")) {
                //q0,0,q1
                vetor_de_item = Linha.split(",");//quebrando a linha em subvetores para pegar os estados
                auxx = null;
                auxx = new Transicao();//gerando novo endereço de memoria

                auxx.Est_Origem = vetor_de_item[0];
                auxx.Simbolo = vetor_de_item[1]; //simbolo = alfabeto
                auxx.Est_Destino = vetor_de_item[2];
                //Exemplo: |q0|0|q1|
                afd1.transicao.add(auxx);

                System.out.println("\t" + auxx.Est_Origem + "," + auxx.Simbolo + "," + auxx.Est_Destino);

                Linha = leitor.readLine();
            }

            //Estado Inicial
            est = Linha.replace(">", "");//removendo o sinal de >
            afd1.estInicial = est;//recebe o array
            System.out.println("Estado inicial: " + est);
            Linha = leitor.readLine();

            //Estado Final
            est = null;
            vetor_de_item = null;
            est = Linha.replace("*", "");//removendo o sinal de *
            vetor_de_item = est.split(",");
            afd1.estFinal.addAll(Arrays.asList(vetor_de_item));
            System.out.println("Estado final: " + Arrays.toString(vetor_de_item));

            Linha = leitor.readLine();

        }// fim do while
        //=================================================================================================================
        //Leitura do arquivo para o 2° AFD

        System.out.println("\n..............................\n");
        aux.clear();
        Linha = leitor.readLine();

        //Estados
        vetor_de_item = Linha.split(",");//quebrando a linha em subvetores
        aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxilair
        afd2.estados.addAll(aux);//recebe o array

        System.out.println("Estados: " + Arrays.toString(vetor_de_item));//printa os estados
        Linha = leitor.readLine();//ler a próxima linha 

        //Alfabeto
        vetor_de_item = null;
        if (Linha.contains(",")) {
            vetor_de_item = Linha.split(",");//quebrando a linha em subvetores para pegar os elementos do alfabeto
            aux.addAll(Arrays.asList(vetor_de_item)); //pelo tamanho de elementos adiciona em uma ARRAY auxilair
            afd2.alfabeto.addAll(aux);//recebe o array
            System.out.println("Alfabeto: " + Arrays.toString(vetor_de_item));//printa os itens do alfabeto
        } else {
            afd2.alfabeto.add(Linha);
            System.out.println("Alfabeto: " + Linha);
        }

        Linha = leitor.readLine();//ler a próxima linha
        System.out.println("Estados:");
        //vetor_de_item = null;
        while (!Linha.contains(">")) {
            //q0,0,q1
            vetor_de_item = Linha.split(",");//quebrando a linha em subvetores

            auxx = new Transicao();//gerando novo endereço de memoria
            auxx.Est_Origem = vetor_de_item[0];
            auxx.Simbolo = vetor_de_item[1]; //simbolo = alfabeto
            auxx.Est_Destino = vetor_de_item[2];
            //Exemplo: |q0|0|q1|
            afd2.transicao.add(auxx);

            System.out.println("\t" + auxx.Est_Origem + "," + auxx.Simbolo + "," + auxx.Est_Destino);

            Linha = leitor.readLine();
        }

        //Estado Inicial
        est = Linha.replace(">", "");//removendo o sinal de >
        afd2.estInicial = est;//recebe o array
        System.out.println("estado inicial: " + est);
        Linha = leitor.readLine();

        //Estado Final
        aux.clear();
        vetor_de_item = null;
        est = null;
        est = Linha.replace("*", "");//removendo o sinal de *
        vetor_de_item = est.split(",");
        afd2.estFinal.addAll(Arrays.asList(vetor_de_item));
        System.out.println("Estado final: : " + Arrays.toString(vetor_de_item));

    }

    public static String Correspondente_Tran(String simbolo, AFD afd) {
        //percurso do afd 
        for (Transicao lista : afd.transicao) {//percorrendo as transições do afd
            if ((lista.Est_Origem.contains(afd.estInicial)) && (lista.Simbolo.equals(simbolo))) {
                //se o estado de origem for inicial, e possuir o simbolo ">"
                //então retorna o estado destino para o fecho
                return lista.Est_Destino;
            }
        }
        //se não possui um equivalente na transição, logo a transição é nula    
        return null;
    }

    public static String Lambda(String estt, String simbolo, AFD afd) {

        for (Transicao lista : afd.transicao) {//percorrendo as transições do afnd
            if ((lista.Est_Origem.contains(estt)) && (lista.Simbolo.equals(simbolo))) {
                //se o estado de origem for inicial, e possuir o simbolo ">"
                //então retorna o estado destino para o fecho
                return lista.Est_Destino;
            }
        }
        //se não possui um equivalente na transição, logo a transição é nula    
        return null;
    }

    public static void Intersecao() {
        //===== Criando o fecho para o conjunto de estados, possivel qi====
        if ((afd1.estFinal.contains(afd1.estInicial) && (afd2.estFinal.contains(afd2.estInicial)))) {
            afnd.estFinal.add("qi");
            //caso ambos os afds possuam estados iniciais e finais
            //qi se torna final
        }

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

        //Ja que existe um estado qi, deve-se criar as suas transições
        afnd.alfabeto.forEach((simbolo) -> {//para cada elemento do alfabeto, existe uma transição do estado qi
            Transicao transaux = new Transicao();
            transaux.Est_Origem = "qi";
            transaux.Simbolo = simbolo;
            transaux.Est_Destino = Correspondente_Tran(simbolo, afd1) +"."+ Correspondente_Tran(simbolo, afd2);
            afnd.estados.add(transaux.Est_Destino);//adicionando o novo estado que surgiu
            afnd.transicao.add(transaux);

        });
        System.out.println("\n Transição:");

        //Adicionando as demais transições
        afnd.transicao.addAll(afd1.transicao);
        afnd.transicao.addAll(afd2.transicao);

        //Adicionando os demais estados finais 
        afnd.estFinal.addAll(afd1.estFinal);
        afnd.estFinal.addAll(afd2.estFinal);
    }

    public static void Uniao() {
        //TODO
        //===== Criando o fecho para o conjunto de estados, possivel qi====
        if ((afd1.estFinal.contains(afd1.estInicial) || (afd2.estFinal.contains(afd2.estInicial)))) {
            afnd.estFinal.add("qi");
            //se pelo menos um dos afd possuir um estado inicial também final
            //qi se torna final
        }

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

        //Já que existe um estado qi, deve-se criar as suas transições
        afnd.alfabeto.forEach((simbolo) -> {//para cada elemento do alfabeto, existe uma transição do estado qi
            Transicao transaux = new Transicao();
            transaux.Est_Origem = "qi";
            transaux.Simbolo = simbolo;
            transaux.Est_Destino = Correspondente_Tran(simbolo, afd1) +"."+ Correspondente_Tran(simbolo, afd2);
            afnd.estados.add(transaux.Est_Destino);//adicionando o novo estado que surgiu
            afnd.transicao.add(transaux);
        });
        System.out.println("\n Transição:");

        //Adicionando as demais transições
        afnd.transicao.addAll(afd1.transicao);
        afnd.transicao.addAll(afd2.transicao);

        //Adicionando os demais estados finais 
        afnd.estFinal.addAll(afd1.estFinal);
        afnd.estFinal.addAll(afd2.estFinal);

    }

    public static void Concatenacao() {
        //Afnd receberá o estado incial do afd1 
        afnd.estInicial = afd1.estInicial;

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
        System.out.println("tamanho:" + afd1.alfabeto.size());
        //Criando a transição lambda para qi
        afnd.alfabeto.forEach((simbolo) -> {
            Transicao trax = new Transicao();
            trax.Est_Origem = afd1.estInicial;// o estado de eorigem é o estado final atual
            trax.Simbolo = simbolo;
            trax.Est_Destino = Correspondente_Tran(simbolo, afd1) +"."+ Correspondente_Tran(simbolo, afd2);
            afnd.transicao.add(trax);
            afnd.estados.add(trax.Est_Destino);
            System.out.println("aaaaaaa");
        });

        //adicionando as transições do afd1 eexceto as finais 
        ArrayList<String> finais = afd1.estFinal;
        for (Transicao lista : afd1.transicao) {
            //para cada transição existente no afd1, será percorrido excluindo os que possuirem
            //o estado de origem final
            if (!finais.contains(lista.Est_Origem)) {
                //se o estado se origem atual da lista estiver contida nos finais, então
                // a trnsição não será adicionada ao afnd
                afnd.transicao.add(lista);
            }
        }

        // Adicionando as transições do afd2       
        afnd.transicao.addAll(afd2.transicao);

        //Adicionando os estados finais de afd2
        afnd.estFinal.addAll(afd2.estFinal);
    }

    public static void Combinacao() {//estrela brilha brilha
        //Criando o estado inicial
        afnd.estInicial = "qi";

        //Criando os estados do afnd
        afnd.estados.add("qi");//a operação estrela possui um estado qi
        afnd.estados.addAll(afd1.estados);//adicionando os demais estados do afd

        //Adicionando os estados finais
        afnd.estFinal = afd1.estFinal;

        //Adicionando o alfabeto
        afnd.alfabeto = afd1.alfabeto;

        //Adicionando a Transição lambda
        // qi, a, ....
        // qi, b, ....
        // qi, c, ....
        
        //Criando transição do qi para o estado inicial
        afnd.alfabeto.forEach((simbolo) -> {
            Transicao trans = new Transicao();
            trans.Est_Origem = "qi";//estado inicial do afnd
            trans.Simbolo = simbolo;
            trans.Est_Destino = afd1.estInicial +"."+ Correspondente_Tran(simbolo, afd1);// antigo q0 do afd
            afnd.transicao.add(trans);//guardando na struct
        });

        //Adicionando as demais transições do afd
        afnd.transicao.addAll(afd1.transicao);

        //Adicionando a Transição Lambda dos finais para o inicial
        afnd.alfabeto.forEach((simbolo) -> {
            afnd.estFinal.forEach((finais) -> {
                //TODO q0 quando final = incial, precisa de transição?
                Transicao trans = new Transicao();
                trans.Est_Origem = finais;//estado inicial do afnd
                trans.Simbolo = simbolo;
                trans.Est_Destino = afd1.estInicial;// antigo q0 do afd
                afnd.transicao.add(trans);
            });
        });
    }

    public static void Operacao() {
        System.out.println("Operação:   " + op);
        switch (op) {
            case 1://União
                System.out.println("União");
                Uniao();
                break;

            case 2://Interseção
                System.out.println("Interseção");
                Intersecao();
                break;

            case 3://Concatenação
                System.out.println("Concatenação");
                Concatenacao();
                break;

            case 4://Combinação (*)
                System.out.println("Combinação");
                Combinacao();
                break;

        }

    }

    public static void Printar_Afnd() {
        System.out.println("---------------------------------------------");
        System.out.println("\n\tAFND");

        System.out.println("\n Estados:\n\t");
        for (String n : afnd.estados) {
            System.out.print(n + " ");
        }

        System.out.println("\n Alfabeto:\t");
        for (String n : afnd.alfabeto) {
            System.out.print(n + " ");
        }

        System.out.println("\n Transição:");
        for (Transicao n : afnd.transicao) {
            System.out.println("\t" + n.Est_Origem + "," + n.Simbolo + "," + n.Est_Destino);
        }

        System.out.println("Estado incial: " + afnd.estInicial);
        System.out.println("\n Estado final:\t");
        for (String n : afnd.estFinal) {
            System.out.print(n + " ");
        }
    }
    
    public static void Transicoes_afnd(){
        
        //Pegando o ultimo estado adicionado
        //No caso a a trnsição lambda gerou um novo estado
        //ex: q2,q4
        String ultimoEstadoObtido = afnd.estados.get(afnd.estados.size()-1);
        String estDest = null;
        ArrayList<String> PossiveisEstados = null;
        
        PossiveisEstados.add(ultimoEstadoObtido);
        //Enquanto houver um estado novo do qual não foi adicionado ao afnd ainda
        //reealiza as operações devidas:
        //1:procura por estado que o compoem 
        //2:adicionar suas devidas transições
        //3: adicionar eventuais estados novos descobertos a mesma operação
        
        //Para cada estado novo encontrado
        //Encontrar sua transição equivalente
        for(String Estado : PossiveisEstados){
            Transicao novaTransicao = new Transicao();
            
            
            String [] UEO_subEstados = Estado.split(".");
            //UEO_subEstados = estados que compoem o ultimo estado encontrado

            //Percorrendo para cada elemento do alfabeto
            for(String simbolo : afnd.alfabeto){
                //Percorrendo para cada elemento que compoz o estado gerado
                for(String subEstados : UEO_subEstados){
                    //Percorrendo todo a transição 
                    for(Transicao trans : afnd.transicao){
                        //Buscando uma transição que satisfaça os subestados (se existirem)
                        if((trans.Est_Origem.equals(subEstados))&&(trans.Simbolo.equals(simbolo))){
                            estDest += trans.Est_Destino+".";
                        }                          
                    }

                }//fim do loop dos subEstados
                
               
                
                //Adicionando a transição pros estados novos encontrados
                //se o estado encontrado já existe, ignora, senão 
                if(!afnd.estados.contains(estDest)){
                   novaTransicao.Est_Origem = ultimoEstadoObtido;
                   novaTransicao.Simbolo = simbolo;
                   novaTransicao.Est_Destino = estDest;
                   
                   afnd.estados.add(estDest);//adicionando o novo estado q surgiu ao afnd
                   PossiveisEstados.add(estDest);
                   //isso garante q caso surja novos estados em cada simbolo num mesmo estado
                   //para q fiquem em fila para serem adicionados
                   /*
                   
                   Ex:
                   Estados |  0  |  1  | 2
                   ...
                   q3      | q1  | q3 | q2q3
                   q2q3    | q1q2|q3q1| q3
                   
                   **Logo  os estados q1q2  q3q1 seram clocados na pilha para serem adicionados
                   */
                   
                   estDest = null;//zerando a variavel para o proximo loop
                }
                
            }//fim do loop do alfabeto
            
        }
        
        
        
        
    }
    
    
    
    

}
