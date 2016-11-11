
package javaapplication7;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author portatil
 */
public class JavaApplication7 {

    Scanner sc = new Scanner(System.in);
    String[] par = {"ATOM","MOLECULA","BIO", "PERL"};
    public static void main(String[] args) {
        
    JavaApplication7 penjat = new JavaApplication7();     
    penjat.run();
    
    
}
    
    public void run(){
   
   //COMENTARI VOSTRE
    String resposta, llegit="";
    boolean valid;
    int count, encerts, pos;
    char c;   
    
    do{
        //Creem el constructor pasant-li el nostre array de paraules
        Penjat pn = new Penjat(par);      
        int i = 0;      
        
        //Seleccionem una posició aleatoria de l'array       
        int endevina=pn.random();

        //Agafem la paraula de l'array segons la posició que s'envia
        String paraula=pn.paraula(endevina);
            
        System.out.println("La paraula que has d'encertar té "+paraula.length()+" lletres");

        //Creo l'array de caràcters que mostraran les encertades
        char lletres[] = pn.arrayChar(paraula);
        System.out.println(lletres);

        //En aqui anirem demanen lletres fins que s'encerti la paraula o el numero d'errors 
        //sigui de 10
        
        count=0; //Numero d'errors
        encerts=0; //Numero d'encerts

        do{
           valid=false;

            //COMENTARI VOSTRE
          do{
            
            valid = pn.escriureLletres(); //Retorna true si la lletra es valida          
            llegit= pn.getLetra(); //Retorna la lletra seleccionada
          }while(valid == false || llegit.isEmpty() || llegit==null);
          
           //De la nostra lletra, la fem majuscula i seleccionem el primer caracter (la propia
           //lletra)
          c=llegit.toUpperCase().charAt(0);
            
          //Mirem si existeix la lletra en la nostra paraula
          pos = paraula.indexOf(c);
          
          //Retorna -1 si la lletra no existeix. 
          if (pos == -1) {
               count++;
               System.out.println("Aquesta lletra no es troba dins de la paraula. Ara et queden "+ (10-count)+ " intents");
               //Si el count arriba a 10, no s'ha encertat la paraula
               if(count == 10) System.out.println("Has esgotat tots els intents");
           } else {
              
              encerts = pn.recorrPar(encerts,lletres,paraula,c);                   
              System.out.println("Molt bé!!! Torna a intentar-ho");

              if(encerts == paraula.length()){
                  System.out.println("Has acabat encertant la paraula. Felicitats!!!!");
                  count =10;
              }
           }
         }while(count !=10);

        System.out.println("Vols continuar?(S/N)");
        resposta=sc.nextLine().toUpperCase();
       }while(resposta.equals("S"));

   } 
}
