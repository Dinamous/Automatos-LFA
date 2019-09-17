/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatos;

import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class AFD {
    ArrayList<String> estados = new ArrayList();
    ArrayList<String> alfabeto = new ArrayList();
    String estInicial = new String();
    ArrayList<String> estFinal = new ArrayList();
    ArrayList<Transicao> transicao = new ArrayList();

    public ArrayList<String> getEstados() {
        return estados;
    }

    public void setEstados(ArrayList<String> estados) {
        this.estados = estados;
    }

    public ArrayList<String> getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(ArrayList<String> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String getEstInicial() {
        return estInicial;
    }

    public void setEstInicial(String estInicial) {
        this.estInicial = estInicial;
    }

    public ArrayList<String> getEstFinal() {
        return estFinal;
    }

    public void setEstFinal(ArrayList<String> estFinal) {
        this.estFinal = estFinal;
    }

    public ArrayList<Transicao> getTransicao() {
        return transicao;
    }

    public void setTransicao(ArrayList<Transicao> transicao) {
        this.transicao = transicao;
    }

    void setEstInicial(String[] vetor_de_item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
    
}
