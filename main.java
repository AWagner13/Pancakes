package pancakes;

import java.util.Arrays;
import java.util.Scanner;

/*
 Integrantes de equipo

-Olivia Janini Lopez Martinez
-Alfredo Misrain Ramos Parra
-Jessy Sebastian Arellano Soriano

*/

public class main {


 
    String movs=""; //los movimientos que se estan haciendo
    int prof_lim = 10; //profundidad limite
    String mov_posSol=""; //movimientos de la solucion encontrada
    String pos_sol=""; //string solucion
    int mejorProf= prof_lim + 1; //profundidad de la mejor solucion hallada 
    int n=0; // tamaño del string;
    
    
    void busqProf(String cad_aOrdenar,int movAnt, int nivelProf)
    {
        if(cad_aOrdenar.equals("abcd")){
            if(mejorProf>nivelProf){
                mov_posSol = movs;
                mejorProf = nivelProf;
                System.out.println(cad_aOrdenar);
                System.out.println(mejorProf);
                System.out.println(mov_posSol);
            }
            return;
        }
        
        if(nivelProf>prof_lim){
            return;
        }
        n = cad_aOrdenar.length();
        for(int m=2;m<=n;m++){          
            
           // System.out.println(m);
            if(m != movAnt){
                //System.out.println(cad_aOrdenar);
                cad_aOrdenar = mover(cad_aOrdenar,m);
                //System.out.println(cad_aOrdenar);
             
                movs = movs.concat(Integer.toString(m));
                busqProf(cad_aOrdenar, m, nivelProf + 1);
                movs=movs.substring(0, movs.length()-1);
                
                cad_aOrdenar = mover(cad_aOrdenar,m);
                
                //System.out.println(cad_aOrdenar);
            }
        }
       
    }
    
    int SolEncon;
    void ProfIterativa(String cad_aOrdenar, int movAnt){
       
        for(int MaxProf=1;MaxProf<=prof_lim;MaxProf++){
            busqProfIter(cad_aOrdenar,0,MaxProf);
            if(cad_aOrdenar.equals("abcd")){
                break;
            }
        }
        
    }
    
        void busqProfIter(String cad_aOrdenar,int movAnt, int nivelProf)
    {
        if(cad_aOrdenar.equals("abcd")){
            if(mejorProf>nivelProf){
                mov_posSol = movs;
                mejorProf = nivelProf;
                System.out.println(cad_aOrdenar);
                System.out.println(mejorProf);
                System.out.println(mov_posSol);
            }
            return;
        }
        
        if(nivelProf>prof_lim){
            return;
        }
        n = cad_aOrdenar.length();

            for(int m=2;m<=n;m++){                 
               // System.out.println(m);
                if(m != movAnt){
                    //System.out.println(cad_aOrdenar);
                    cad_aOrdenar = mover(cad_aOrdenar,m);
                    //System.out.println(cad_aOrdenar);

                    movs = movs.concat(Integer.toString(m));
                    busqProf(cad_aOrdenar, m, nivelProf + 1);
                    movs=movs.substring(0, movs.length()-1);

                    cad_aOrdenar = mover(cad_aOrdenar,m);

                    //System.out.println(cad_aOrdenar);
                }
            }
        
       
    }
        
   
    String mover(String cad,int mov){
        String cadInv= "";
        for(int x = (cad.length()-1); x > (cad.length()- (mov+1)) ; x--){
            cadInv= cadInv + cad.charAt(x);
        }
       // System.out.println(cadInv);
        cad = cad.substring(0, cad.length()-mov);
        //System.out.println(cad);
        cad = cad.concat(cadInv);
        return cad;
        //System.out.println(cad);
    }
    
    float ENCONTRADO =0;
    float INFINITO = Float.POSITIVE_INFINITY;
    
    float IDA(String cad){
        float t;
        int Cota;
        Cota=h4(cad);
        do{
            t=Busq_IDA(cad,0,Cota,0);
            if(t==ENCONTRADO)
                return ENCONTRADO;
            if(t==INFINITO || t==Cota)
                return INFINITO;
            Cota=(int)t;
        }while(true);
    }
    
    float Busq_IDA(String cad, int ant, int Cota, int prof){
        float f,t,min;
        n=cad.length();
        f=h4(cad)+prof;
        if(f>Cota){
            return f;
        }
        if(cad.equals("abcd")){
            mov_posSol = movs;
            System.out.println(cad);
            System.out.println(prof);
            System.out.println(mov_posSol);
            return ENCONTRADO;
        }
        min=INFINITO;
        for(int i=2;i<=n;i++){
            if(i==ant)
                continue;
            cad=mover(cad,i);
            movs = movs.concat(Integer.toString(i));
            t=Busq_IDA(cad,i,Cota, prof+1);
            movs=movs.substring(0, movs.length()-1);
            cad=mover(cad,i);
            if(t==ENCONTRADO)
                return ENCONTRADO;
            if(t<min)
                min=t;
            
        }
        return min;
        
    }
    
    int h4(String cad){
        int i, c=0;
        char [] cadena=cad.toCharArray();
        if(!cad.substring(0, 1).equals("a") && !cad.substring(1,2).equals("b"))
            c=1;
        for(i=0;i<cad.length()-1;i++)
            if(Math.abs(cadena[i]-cadena[i+1])>1)
                c++;  
       return c;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        main pancackes = new main();
        String cad_aOrdenar="cbad";
      //  pancackes.busqProf(cad_aOrdenar, 0, 0);
      //  pancackes.ProfIterativa(cad_aOrdenar, 0);
        pancackes.IDA(cad_aOrdenar);
        
    }
    
}
