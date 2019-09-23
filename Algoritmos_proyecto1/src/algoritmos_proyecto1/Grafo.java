package algoritmos_proyecto1;
import java.util.ArrayList;
public class Grafo 
{
    int m,n;
    boolean auto,dirigido;
    ArrayList <ArrayList <Integer>> ListaAdj=new ArrayList <>();
    ArrayList<Double> CoordX=new ArrayList<>();
    ArrayList<Double> CoordY=new ArrayList<>();
    
     public Grafo(int n, int m, boolean auto, boolean dirigido) 
    {
        this.m = m;
        this.n = n;
        this.auto = auto;
        this.dirigido = dirigido;
        for(int i=0;i<n;i++){
            ListaAdj.add(new ArrayList<Integer>());
        }
    }
     
        public void AgregarArista(int a,int b)
    {
        ListaAdj.get(a).add(b);
        if(dirigido==false)
        {
        ListaAdj.get(b).add(a);
        }
    }
     public boolean ChecaAristasRepetidos(int a,int b){
     for (int i=0;i<ListaAdj.get(a).size();i++)
     {
      if (ListaAdj.get(a).get(i)==b){
          return true;
     }
    }
     return false;
    }
        


    public String imprimirGrafo()
    {
        String neri = "";
        for(int i=0;i<(n);i++)            
        {
        System.out.print((i)); 
            neri += "" + i;
             for(int j=0;j<ListaAdj.get(i).size();j++)
             {
             neri += ";"+ListaAdj.get(i).get(j);
             }
             neri += "\n";
        }
        return neri;
    }
   
    
    public static Grafo genErdosRenyi (int n,int m,boolean auto,boolean dirigido)
    {
    Grafo g1= new Grafo (n,m,auto,dirigido);
    for (int i=0;i<m;){
        int u= (int)(Math.random()*(double)n);
        int v= (int)(Math.random()*(double)n);
     
        if (g1.auto==false && u==v){
            continue;
        }
        if (g1.ChecaAristasRepetidos(u, v)){
            continue;
        }
        g1.AgregarArista(u, v);
        i++;

    }
    return g1;
            }

   public static Grafo genGilbert (int n,double p,boolean auto,boolean dirigido)
    {
        Grafo g2= new Grafo (n,0,auto,dirigido);
        
        for(int k=0;k<n;k++)
        {
            for (int l=0;l<n;l++)
            {
             double random= Math.random();
             if (g2.auto==false && k==l){
                continue;
             }
            if (g2.ChecaAristasRepetidos(k, l)){
                continue;
            }
            
              if(random<=p)
             {
                 g2.AgregarArista(k, l);
            // 
             }
            }
        }
        return g2;
    }
   
   public static Grafo genGeografico (int n, double r, boolean auto, boolean dirigido)
   {
   Grafo g3= new Grafo (n,0,auto,dirigido);
   for(int s=0;s<n;s++)
   {
       double x=Math.random();
       double y=Math.random();
       g3.CoordX.add(x);
       g3.CoordY.add(y);
   }
   for (int y=0;y<n;y++)
   {
       for (int z=0;z<n;z++)
       {
           double x1=g3.CoordX.get(y);
           double y1=g3.CoordY.get(y);
           double x2=g3.CoordX.get(z);
           double y2=g3.CoordY.get(z);    
           double d=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        if (g3.auto==false && y==z){
            continue;
        }
        if (g3.ChecaAristasRepetidos(y, z)){
        continue;
        }
       if(d<=r)
            {
           g3.AgregarArista(y, z);
           }
       }
   }
   return g3;       
   }


public static Grafo genBarabasiAlbert (int n,double d,boolean auto,boolean dirigido){
    Grafo g4= new Grafo (n,0,auto,dirigido);
    
    for(int f=0;f<d;f++)
    {
          for(int g=f+1;g<d;g++)
          {
           g4.AgregarArista(f,g);              
          }
    }
    int integer_d = (int)d;
    for (int h=integer_d;h<n;h++)
    {
        for (int m=0;m<=h;m++)
        {
            double adj=g4.ListaAdj.get(m).size();
            double proba=1.00-(adj/d);
            double random=Math.random();
       
            
     if (g4.auto==false && h==m){
           continue; 
       }
        if (g4.ChecaAristasRepetidos(h, m))
        {
        continue;
        }
        if(random<=proba)
       {
           g4.AgregarArista(h,m);
       }
      }
    }
    return g4; 
}}
