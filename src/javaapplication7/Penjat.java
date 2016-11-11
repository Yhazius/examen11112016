/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lozano
 */
public class Penjat {

    Scanner sc = new Scanner(System.in);
    private String[] paraules;
    private String letra;
    
    public void setParaules(String[] paraules) {
        this.paraules = paraules;
    }
    
    public Penjat() {        
    }


    public Penjat(String[] paraules) {
        this.paraules = paraules;
    }
    
    /**
     * Generem un numero aleatori segons la longitud de l'array paraules
     * @return un numero entre el numero de valors que existeixen a l'array
     */
    public int random(){    
        Random rnd = new Random();
        return (int)(rnd.nextDouble()*paraules.length);
    }
    
    /**
     * Es retorna la paraula de l'array de paraules emmagatzemades
     * @param pos selecciona la posició que volem agafar de l'array
     * @return la paraula de l'array segons la posició donada
     */
    public String paraula(int pos){
        return paraules[pos];
    }
    /**
     * Es crea un array de caracters per fer la cadena amb la posició del numero de lletres de 
     * la paraula
     * @param paraula es passa la paraula que s'ha d'endevinar
     * @return array de caracters amb el numero de lletres de la paraula convertit en _
     */
    public char[] arrayChar(String paraula){
        int i;
        char lletres[]=new char[paraula.length()];
        for(i=0;i<paraula.length();i++){
            lletres[i] ='_';
        }
        return lletres;
    }
    
    /**
     * Es demana lletres a l'usuari y si aquesta està entre la regExp es valida correctament
     * A més, s'emmegatzema la lletra en un atribut per poder seleccionar-la
     * @return true si la lletra es correcta o false si no
     */
    public boolean escriureLletres(){
        System.out.println ("Si us plau, Escriu una lletra valida");
        String llegit=sc.nextLine().toUpperCase();
        if(llegit.matches("[ABCDEFGHIJKLMNÑOPQRSTUVWXYZ ]")){
            letra = llegit;
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Es recorre tota la cadena i es cambien les coincidencies entre la paraula i la cadena on es
     * va mostrant
     * @param encerts valor que controla el numero d'encerts de la paraula
     * @param lletres array de lletres per obtenir la longitud de la cadena
     * @param paraula a endevinar per l'usuari
     * @param c caracter que ha seleccionat l'usuari per buscar
     * @return numero d'encerts
     */
    public int recorrPar(int encerts, char[] lletres, String paraula, char c){
        int i;
        //COMENTARI VOSTRE
        for(i=0;i<lletres.length;i++){
            if(paraula.charAt(i) == c){
                lletres[i] =c;
                encerts +=1;
            }
            System.out.print(lletres[i]+" ");
        }
        return encerts;
    }
    
    /**
     * 
     * @return 
     */
    public String getLetra() {
        return letra;
    }    
}
