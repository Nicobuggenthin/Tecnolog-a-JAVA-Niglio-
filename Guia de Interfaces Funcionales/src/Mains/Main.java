package Mains;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import Models.Persona;
import Models.Rectangulo;

public class Main {

	public static void main(String[] args) {
		
		//--------Objetos------//
		
		Persona personaA = new Persona("Arturo", 45, 74, 180);
		Persona personaB = new Persona("Carolina", 25, 50, 145);
		
		Rectangulo rectyA = new Rectangulo(5, 5);
		Rectangulo rectyB = new Rectangulo(9,14);
		
		// Comparator <T> Lambda
		//Crear un comparador que compare dos personas por altura.
		
		System.out.println("------COMPARADOR ALTURA-----------");
		
		Comparator<Persona> comparadorAltura = (perA, perB) -> Double.compare(perA.getEstatura(), perB.getEstatura());
		System.out.println(comparadorAltura.compare(personaA, personaB));
		
		//Crear un comparador que compare personas por edad
		
		System.out.println("-----COMPARADOR EDAD-------");
		Comparator<Persona> comparadorEdad = (perA, perB) -> Double.compare(perA.getEdad(), perB.getEdad());
		System.out.println(comparadorEdad.compare(personaA, personaB));
		
		//Crear un comparador que compare personas por edad y si son iguales por estatura. 
		System.out.println("----COMPARADOR EDAD Y ESTATURA");
		Comparator<Persona> comparadorEdadYEstatura = (perA,perB) -> {
			int resultadoEdad = Integer.compare(perA.getEdad(), perB.getEdad());
			if(resultadoEdad == 0) {
				return Double.compare(perA.getEstatura(), perB.getEstatura());
					}else {return resultadoEdad;}
			};
		System.out.println(comparadorEdadYEstatura.compare(personaA, personaB));
		
		//Crear un comparador que compare personas por peso inversamente. 
		System.out.println("-----COMPARADOR PESO INVERTIDO------");
		Comparator<Persona> comparadorPesoInverti = (perA, perB) -> Double.compare(perB.getPeso(), perA.getPeso());
		System.out.println(comparadorPesoInverti.compare(personaA, personaB));
		
		//Crear un comparador que compare la base de dos rect�ngulos
		System.out.println("-----COMPARADOR BASE RECTANGULOS-------");
		Comparator<Rectangulo> comparadorBase = (recA, recB) -> Double.compare(recA.getBase(), recB.getBase());
		System.out.println(comparadorBase.compare(rectyA, rectyB));

		
	//Function <T , R>
	//Crear un funci�n que reciba un rect�ngulo y retorne su �rea
	System.out.println("------Retorno de Area Rectangulo-------");
	Function<Rectangulo, Double> retornarAreaRec = (recA) -> recA.getBase() * recA.getAltura();
	System.out.println(retornarAreaRec.apply(rectyA));
	
	//Crear una funci�n que reciba un rect�ngulo y retorne su per�metro
	System.out.println("--------Retorno Perimetro Rectangulo---------");
	Function<Rectangulo, Double> retornarPeriRec = (recB) -> recB.getAltura()*2 + recB.getBase()*2;
	System.out.println(retornarPeriRec.apply(rectyB));
	
	//Crear un funci�n que reciba un double y retorne el triple de dicho numero 
	System.out.println("-------Retorno Triple Double------");
	Function<Double, Double> retornoTriple = (doubleA) -> doubleA*3;
	System.out.println(retornoTriple.apply(5.00));
	
	//Crear una funci�n que retorne el triple del �rea de un rect�ngulo
	System.out.println("------Retorno de Triple del Area Rectangulo-------");
	Function<Rectangulo, Double> retornarTripleArea = (recA) -> (recA.getBase() * recA.getAltura())*3;
	System.out.println(retornarTripleArea.apply(rectyA));
	
	//Crear una funci�n que reciba una persona y retorne un rect�ngulo cuya altura es la estatura de la persona y su base el peso
	System.out.println("------Retorno Persona a Rectangulo------");
	Function<Persona, Rectangulo> retornarRec = (perA) -> {
		double altura= perA.getEstatura();
		double base= perA.getPeso();
		return new Rectangulo(base, altura);
	};
	
	Rectangulo RectanPerson = retornarRec.apply(personaA);
	System.out.println("Altura: " + RectanPerson.getAltura() + " Base: " + RectanPerson.getBase());
	
	//Realizar una funci�n que retorne el triple del �rea de una persona como si la misma fuera un rect�ngulo (Siendo peso la base y estatura la altura) 
	System.out.println("------Retorno Triple del Area de una Persona(Rectangulo)----------");
	Function<Persona, Double> retornarTrip = (perA) -> {
		double base = perA.getPeso();
		double altura = perA.getEstatura();
		double area = base * altura;
		return area *3;
	};
	System.out.println(retornarTrip.apply(personaB));

	
	
	
	}
}
