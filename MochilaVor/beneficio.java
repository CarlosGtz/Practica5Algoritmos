
import javax.swing.JOptionPane;

public class beneficio {
 float beneficio;
 float peso;
 float bxp;
public beneficio(float beneficio, float peso) {
	
	this.beneficio = beneficio;
	this.peso = peso;
	this.bxp = (beneficio / peso);
}

public float getBeneficio() {
	return beneficio;
}

public void setBeneficio(float beneficio) {
	this.beneficio = beneficio;
}

public float getPeso() {
	return peso;
}

public void setPeso(float peso) {
	this.peso = peso;
}

public double getBxp() {
	return bxp;
}

public void setBxp(float aux2) {
	this.bxp = aux2;
}

public beneficio() {
	super();
	this.peso=3;
	this.beneficio=6;
	this.bxp = beneficio / peso;
}



 
 
	
}