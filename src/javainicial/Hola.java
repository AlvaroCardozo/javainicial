/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javainicial;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 *
 * @author admin
 */
public class Hola {
    
    public static void main(String[] args) {
        System.out.println("Hola!");        
        primo(1);
        primo(2);
        primo(5);
        primo(7);
        primo(15);
        // enteros
        int max = Integer.MAX_VALUE;
        long maxL = Long.MAX_VALUE;
        Integer maxBoxed = 10;
        // reales
        float decimal1 = 14.5F;
        double decimal2 = 23.0054;
        Double decimalBoxed = 20D;
        // alfanumericos
        String cadena = "Timoteo Ponce";
        char car1 = 'a';
        char car2 = 23;        
        Character car3 = 'c';
        
        int intNativo = 0;
        Integer intBoxed = null;
        System.out.println("int nativo:" + intNativo);
        System.out.println("int clase:" + intBoxed);
    }

    private static void primo(int n) {
        //numericos     : int, long, float, double
        //alfanumericos : char, String
        //condicionales : boolean
        //primo -> divisible entre si mismo y uno 
        //primo -> divisor = 2
        int divisor = 0;
        for( int i = 1; i <= n ; i++){
            if(n % i == 0)
                divisor++;
        }
        if(divisor == 2)
            System.out.println(n + " es primo!!");
        else
            System.out.println(n + " NO es primo");
    }
}
