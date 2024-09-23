package Models;

public class FechaFestiva implements Comparable<FechaFestiva> {
	
	
	//Atributos//
	int dia;
	int mes;
	String nombre;
	Double fanatismo;
	
	//Getters y Setters//
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getFanatismo() {
		return fanatismo;
	}
	public void setFanatismo(Double fanatismo) {
		this.fanatismo = fanatismo;
	} 
	
	//Constructor//
	public FechaFestiva(int dia, int mes, String nombre, double fanatismo) {
		
		this.dia=dia;
		this.mes=mes;
		this.nombre=nombre;
		this.fanatismo=fanatismo;
	}
	
	//toString//
	
	@Override
	public String toString() {
		
		return nombre + "{dia: "+ dia + ", mes: "+ mes + ", fanatismo: " + fanatismo+ "}";
		
	}
	
	//Dias Transcurridos//
	public int getDiasTotales() {
		return (this.mes-1)*30+this.dia;
	}
	
	//Interfaz Comparable//
	public int compareTo(FechaFestiva otraFecha) {
		int resultado=0;
		if(this.getDiasTotales()> otraFecha.getDiasTotales()) {
			resultado=1;
		}else if(this.getDiasTotales()< otraFecha.getDiasTotales()) {
			resultado=-1;
		}
		
		return resultado;
			
	}

}
