
package javaApplication2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Fabrica {
    
    static int maxDias = 0;

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int prod[][],n,dias = 0;
        String nombres[];
        
        System.out.println("Cuantos obreros son: ");
        n = leer.nextInt();
        
        //pedir casillas para el vector de nombres
        nombres = new String[n];
        
        //pedir los renglones para matriz
        prod = new int[n][];
        for (int i = 0; i < n; i++) {
            System.out.println("Nombre del obrero "+i+" : ");
            leer.nextLine();
            nombres[i] = leer.nextLine();
            System.out.println("Cuantos dias fue a trabajar: ");
            dias = leer.nextInt();
            if (dias > maxDias)
            {
                maxDias = dias;
            }
            
            //crear el total de columnas para el renglon i
            prod[i] = new int[dias];
            //generar aleatoriamente las piezas ensambladas por el obrero i
            for (int j = 0; j < dias; j++) {
                prod[i][j] = (int)(Math.random()*(20 - 10 + 1 ) + 10);
            }
            
        }
        imprimir(nombres,prod);
        Fabrica.sumaProduccion(nombres, prod);
        Fabrica.ProduccionPorDia(prod,maxDias);
    }
    
    public static void ProduccionPorDia(int prod[][],int dias){
        System.out.println("Sumatoria por Columnas");
        int acum;
//        for (int i = 0; i < prod.length; i++)
//        {
//            
//        }
        for (int i = 0; i < dias; i++) {
            
                acum=0;

                for (int k = 0; k < prod.length; k++)
                {
                    int d = prod[k].length;
                    if (d >= dias)
                        acum += prod[k][i];
                }
                /*
                for (int j = 0; j < prod.length; j++) {
                    int a = prod[i].length;
                    if (dias >= prod[i].length)
                        acum += prod[j][i];
                }*/
                System.out.println("Sumatoria Columna "+i+" ="+acum);
            
        }
    }    
    
    public static void sumaProduccion(String nombre[],int prod[][]){
        System.out.println("Produccion por obrero ");
        int acum,mayor=0;
        String aux="";
        for (int i = 0; i < prod.length; i++) {
            System.out.print(nombre[i]+" ");
            acum=0;
            for (int j = 0; j < prod[i].length; j++) {
                acum += prod[i][j];   
            }
            if(acum > mayor){
                aux = nombre[i];
                mayor = acum;
            }
            System.out.println(acum);
        }
        System.out.println("El obrero con mas produccion es: "+aux);
    }
    
    public static void imprimir(String[] nombres,int[][] prod){
        System.out.println("Imprimiendo.....");
        for (int i = 0; i < prod.length; i++) {
            System.out.print(nombres[i]+ "   ");
            for (int j = 0; j < prod[i].length; j++) {
                System.out.print(prod[i][j]+" ");
            }
            System.out.println("");
        }
    }
}