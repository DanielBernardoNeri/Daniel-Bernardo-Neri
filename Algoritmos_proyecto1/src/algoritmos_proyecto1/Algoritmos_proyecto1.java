
package algoritmos_proyecto1;
import java.io.*;
import java.util.Locale;


public class Algoritmos_proyecto1 {
    public static void main(String[] args) throws IOException {

//Grafo g1= Grafo.genErdosRenyi(500,245,true,false);
PrintWriter Imprime=new PrintWriter("C:/Graf/Gilbert 500.csv");

   
     
Grafo g2=Grafo.genGilbert(500,0.01,false,true);
//g2.imprimirGrafo();

//Grafo g3=Grafo.genGeografico(500,0.1, false, false);
//g3.imprimirGrafo();

//Grafo g4=Grafo.genBarabasiAlbert(30,23, false, true);
//g4.imprimirGrafo();
Imprime.write(g2.imprimirGrafo());

Imprime.close ();
}

}



