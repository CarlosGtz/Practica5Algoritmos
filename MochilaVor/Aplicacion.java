import javax.swing.JOptionPane;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int p = Integer.parseInt(JOptionPane.showInputDialog("ingrese el numero de objetos que existen"));
	float solucion[] = new float [p];
		beneficio objetos[] = new beneficio[p];
		llenar(objetos); // ingresamos los valores
		mostrar(objetos); //muestra los elementos ingresados
		directa(objetos); // ordena de acuerdo a nuestra funcion seleccion
		mostrar(objetos); // muestre los elementos ordenados
		objetivo(solucion , objetos); // resuelve el problema
		mostrar(solucion,objetos); // muestra la solucion
		
	}
	
	
	
	//funcion para llenar los vectores
	public static void llenar(beneficio vector []  ){
	for(int i = 0 ; i < vector.length ;i++)	{
		int p = Integer.parseInt(JOptionPane.showInputDialog("ingrese el peso del objeto  "+ (i+1))  );
		int b = (Integer.parseInt(JOptionPane.showInputDialog("ingrese el beneficio del objeto "+ (i+1) ) ));
		vector[i]= new beneficio (b,p);
    	
	}	}
	
	//funcion para ordenar segun el beneficio por unidad 
	public static void directa(beneficio [] vector )
	{
		
	int i,k,j;
	double menor;
	beneficio aux = new beneficio();
	aux = vector[0];
	
	for(i=0 ; i<vector.length;i++ )
	{
		menor=vector[i].getBxp();
		k=i;
	
		for(j=i+1 ; j<vector.length;j++ )
		{ 
			if(vector[j].getBxp()< menor)
			{
			menor=vector[j].getBxp();
			aux= vector[j];
			k=j;
		
			}
			
		}
		aux= vector[k];
		vector[k]=vector[i];
		vector[i]=aux;
		
	}
		
	}
	
	public static void mostrar(beneficio [] aux )
	{ String beneficio="beneficio:  ",peso = "peso" , valor="valor por unidad:  " ;
		for(int i=0 ; i<aux.length;i++)
		{
			beneficio+= aux[i].getBeneficio() + "  ,  ";
			peso += aux[i].getPeso() + " , ";
			valor += (aux[i].getBeneficio() / aux[i].getPeso())  + " , ";
					
		}
	JOptionPane.showMessageDialog(null, peso + "\n" + beneficio + "\n" + valor ); 
	}
	
	public static void mostrar(float aux [] , beneficio b [])
	{ String solucion=" solucion:  " ;
	  float suma = 0;
		for(int i=0 ; i<aux.length;i++)
		{
			solucion += aux[i]+ "-------";
			suma+= aux[i]*b[i].getBeneficio();
		}
	JOptionPane.showMessageDialog(null, solucion  + "\n total beneficio: "  + suma ); 
	}
//funcion para seleccionar los objetos
public static void objetivo(float solucion[], beneficio objetos[])
{
 int m = Integer.parseInt(JOptionPane.showInputDialog("ingrese el tamaño de la mochila"));
float pesoactual= 0;
 int i = solucion.length-1;
 
   while(pesoactual < m  || i>= 0)
   { 
	 JOptionPane.showMessageDialog(null, " peso actual: "+ pesoactual +  "   peso objeto " + i + "  :" + objetos[i].getPeso() + "\n  ");
	   
	  if( (pesoactual + objetos[i].getPeso()) < m )
	  {
		  solucion[i]= 1;
		  pesoactual+= objetos[i].getPeso();
		  JOptionPane.showMessageDialog(null, " peso actual: "+ pesoactual +  "   porcentaje tomado del objeto  " + i + "  :" +  solucion[i]*100 + "\n  ");
	  }
	  else
		  
	  {
		 solucion[i]=(m-pesoactual)/objetos[i].getPeso();
		 pesoactual += ((m-pesoactual)/objetos[i].getPeso())* objetos[i].getPeso();
		 JOptionPane.showMessageDialog(null, " peso actual: "+ pesoactual +  "   porcentaje tomado del objeto  " + i + "  :" +  solucion[i]*100 + "\n  "); 
	  }
	   
	i--;   
   }
	 
	 
 

}
	


}