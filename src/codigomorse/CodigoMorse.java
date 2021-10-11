/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigomorse;

/**
 *
 * @author Mauricio Fierro
 */

import java.util.*;

public class CodigoMorse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String abecedario[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ñ","O",
            "P","Q","R","S","T","U","V","W","X","Y","0","1","2","3","4","5","6","7","8","9"};
        String morse[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
            "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..","-----",".----","..---","...--","....-",".....",
            "-....","--...","---..","----."};
        
        boolean fin = false;
        Scanner entrada = new Scanner(System.in);
        int apc = 0;
        
        System.out.println("Bienvenido al traductor de codigo morse");
        do{
            System.out.println("Por favor ingrese una opcion");
            System.out.println("1)traducir en español a morse");
            System.out.println("2)traducir de morse a español");
            System.out.println("3)Salir");
            apc = comprobarDatoEnteroIngresado(entrada,1,3);
            entrada.nextLine();
            fin = procesarOpcion(apc, entrada, abecedario, morse);
        }while(!fin);
        
    }
    
    public static boolean procesarOpcion(int apc, Scanner entrada, String[] abecedario, String[] morse){
        if(apc==1){
            System.out.println("Por favor ingrese la  frase español a traducir");
            String frase = entrada.nextLine();
            String fraseATraducir = frase.toUpperCase();
            String mensajeTraducido = fraseMorse(fraseATraducir, abecedario, morse);
            System.out.println("Traduccion del mensaje a codigo morse: ");
            System.out.println(mensajeTraducido);
        }else if(apc==2){
            System.out.println("Por favor ingrese la  frase morse a traducir");
            String frase = entrada.nextLine();
            String mensajeTraducido = morseFrase(frase, abecedario, morse);
            System.out.println("traduccion al Español: ");
            System.out.println(mensajeTraducido);
        }else if(apc==3){
            return true;
        }
        return false;
    }
    public static String morseFrase(String fraseATraducir, String[] abecedario, String[] morse){
        String mensajeEspañol = "";
        String caracterMorse = "";
        int i = 0;
         do {
             boolean terminaCaracter = false;
             
             do{
                 if(Character.toString(fraseATraducir.charAt(i)).equals(" ")){
                     terminaCaracter=true;
                 }else{
                     caracterMorse+=Character.toString(fraseATraducir.charAt(i));
                     i++;
                 }
             }while((!terminaCaracter)&&(i<fraseATraducir.length()));
             
             int z = 0; 
             boolean termina = false;
     
                 do{
                    if(caracterMorse.equals(morse[z])){
                        mensajeEspañol += abecedario[z];
                        termina = true;
                    }
                    z++;
                    if(z==morse.length){
                        if(!termina){
                        termina=true; 
                     }
                 }
              }while(!termina);
           
             caracterMorse="";
             i++;  
             
             try {
             if(Character.toString(fraseATraducir.charAt(i)).equals(" ")){
                 if(Character.toString(fraseATraducir.charAt(i+1)).equals(" ")){
                     mensajeEspañol += " ";
                     i+=2;
                 }
             }
             }catch(StringIndexOutOfBoundsException e){
                 
             }catch(Exception e){
                 
             }
         } while(i<fraseATraducir.length());
         
        return mensajeEspañol; 
    }
    public static String fraseMorse(String fraseATraducir, String[] abecedario, String[] morse) {
        String mensajeMorse="";
        for(int x=0;x < fraseATraducir.length();x++){
          int z = 0; 
          boolean termina = false;
          if(Character.toString(fraseATraducir.charAt(x)).equals(" ")){
              mensajeMorse += "  ";
          }else {
              do{
                if(Character.toString(fraseATraducir.charAt(x)).equals(abecedario[z])){
                    mensajeMorse += morse[z]+ " ";
                    termina = true;
                 }
                 z++;
                 if(z==abecedario.length){
                     if(!termina){
                        termina=true; 
                     }
                 }
             }while(!termina);
          }  
        } 
        return mensajeMorse;
    }

    
    public static int comprobarDatoEnteroIngresado(Scanner entrada, int min, int max){
    int valor = 0;
    boolean error = false;
    do{
        error = false;
        try {
           valor = entrada.nextInt();
           if(!((valor>=min) && (valor<=max))) {
               System.out.println("valor mal ingresado");
               System.out.println("el valor debe estar entre "+min + "y"  + max);
               error = true;
            }
        } catch(InputMismatchException e){
            System.out.println("Tipo de dato mal ngresado. se esperaba un numero");
            error = true;
            entrada.nextLine();
        } catch(Exception e) {
            System.out.println("Error inesperado. " + e);
            error = true;
        }
    }while(error);  
    return valor;
    }
}    
    


