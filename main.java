package pancakes;

import java.util.Arrays;
import java.util.Scanner;

/*
 Integrantes de equipo

-Olivia Janini 
-Alfredo Misrain Ramos Parra
-Jessy Sebastian Arellano Soriano

*/

public class main {

    public static void main(String[] args) {
    	 
        final int TAMANIO=10;
        int lista[]=new int [TAMANIO];
        rellenarArray(lista);
 
        String lista_String[]={"f","d","b","a","c","e","g"};
 
        /*System.out.println("Array de números sin ordenar:");
        imprimirArray(lista);*/
 
        //ordenamos el array
        quicksort(lista, 0, lista.length-1);
 
        /*System.out.println("Array de números ordenado:");
        imprimirArray(lista);*/
 
        System.out.println("Array de String sin ordenar:");
        imprimirArray(lista_String);
 
        //ordenamos el array
        quicksortP(lista_String, 0, lista_String.length-1);
 
        System.out.println("Array de String ordenado:");
        imprimirArray(lista_String);
 
    }
 
    public static void imprimirArray (int lista[]){
        for(int i=0;i<lista.length;i++){
            System.out.println(lista[i]);
        }
    }
 
    public static void imprimirArray (String lista[]){
        for(int i=0;i<lista.length;i++){
            System.out.println(lista[i]);
        }
    }
 
    public static void rellenarArray (int lista[]){
        for(int i=0;i<lista.length;i++){
            lista[i]=numeroAleatorio();
        }
    }
 
    private static int numeroAleatorio (){
        return ((int)Math.floor(Math.random()*1000));
    }
 
    public static void quicksort (int lista1[], int izq, int der){
        int i=izq;
        int j=der;
        int pivote=lista1[(i+j)/2];
        do {
            while (lista1[i]<pivote){
                i++;
            }
            while (lista1[j]>pivote){
                j--;
            }
            if (i<=j){
                int aux=lista1[i];
                lista1[i]=lista1[j];
                lista1[j]=aux;
                i++;
                j--;
            }
        }while(i<=j);
        if (izq<j){
            quicksort(lista1, izq, j);
        }
        if (i<der){
            quicksort(lista1, i, der);
        }
    }
 
    public static void quicksortP (String lista1[], int izq, int der){
        int i=izq;
        int j=der;
        int pivote=(i+j)/2;
        do {
            while (lista1[i].compareToIgnoreCase(lista1[pivote])<0){
                i++;
            }
            while (lista1[j].compareToIgnoreCase(lista1[pivote])>0){
                j--;
            }
            if (i<=j){
                String aux=lista1[i];
                lista1[i]=lista1[j];
                lista1[j]=aux;
                i++;
                j--;
            }
        }while(i<=j);
        if (izq<j){
            quicksortP(lista1, izq, j);
        }
        if (i<der){
            quicksortP(lista1, i, der);
        }
    }

}

