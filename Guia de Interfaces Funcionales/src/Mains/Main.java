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
		
		Persona personaA = new Persona("Arturo", 15, 74, 2.10);
		Persona personaB = new Persona("Carolina", 25, 50, 1.45);
		Persona personaC = new Persona ("Bart", 10, 40, 1.10);
		
		Rectangulo rectyA = new Rectangulo(15, 30);
		Rectangulo rectyB = new Rectangulo(5,5);
		
		// Comparator <T> Lambda
		//Crear un comparador que compare dos personas por altura.
		System.out.println("-----------COMPARATOR<T>-----------");
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
		
		//Crear un comparador que compare la base de dos rectángulos
		System.out.println("-----COMPARADOR BASE RECTANGULOS-------");
		Comparator<Rectangulo> comparadorBase = (recA, recB) -> Double.compare(recA.getBase(), recB.getBase());
		System.out.println(comparadorBase.compare(rectyA, rectyB));

		
	//Function <T , R>
	System.out.println("-----------FUNCTION<T, R>-----------");
	
	//Crear un función que reciba un rectángulo y retorne su área
	System.out.println("------Retorno de Area Rectangulo-------");
	Function<Rectangulo, Double> retornarAreaRec = (recA) -> recA.getBase() * recA.getAltura();
	System.out.println(retornarAreaRec.apply(rectyA));
	
	//Crear una función que reciba un rectángulo y retorne su perímetro
	System.out.println("--------Retorno Perimetro Rectangulo---------");
	Function<Rectangulo, Double> retornarPeriRec = (recB) -> recB.getAltura()*2 + recB.getBase()*2;
	System.out.println(retornarPeriRec.apply(rectyB));
	
	//Crear un función que reciba un double y retorne el triple de dicho numero 
	System.out.println("-------Retorno Triple Double------");
	Function<Double, Double> retornoTriple = (doubleA) -> doubleA*3;
	System.out.println(retornoTriple.apply(5.00));
	
	//Crear una función que retorne el triple del área de un rectángulo
	System.out.println("------Retorno de Triple del Area Rectangulo-------");
	Function<Rectangulo, Double> retornarTripleArea = (recA) -> (recA.getBase() * recA.getAltura())*3;
	System.out.println(retornarTripleArea.apply(rectyA));
	
	//Crear una función que reciba una persona y retorne un rectángulo cuya altura es la estatura de la persona y su base el peso
	System.out.println("------Retorno Persona a Rectangulo------");
	Function<Persona, Rectangulo> retornarRec = (perA) -> {
		double altura= perA.getEstatura();
		double base= perA.getPeso();
		return new Rectangulo(base, altura);
	};
	
	Rectangulo RectanPerson = retornarRec.apply(personaA);
	System.out.println("Altura: " + RectanPerson.getAltura() + " Base: " + RectanPerson.getBase());
	
	//Realizar una función que retorne el triple del área de una persona como si la misma fuera un rectángulo (Siendo peso la base y estatura la altura) 
	System.out.println("------Retorno Triple del Area de una Persona(Rectangulo)----------");
	Function<Persona, Double> retornarTrip = (perA) -> {
		double base = perA.getPeso();
		double altura = perA.getEstatura();
		double area = base * altura;
		return area *3;
	};
	System.out.println(retornarTrip.apply(personaB));

	
	//Predicate <T>
	System.out.println("-----------PREDICATE<T>-----------");

	//Crear un predicado que evalúe si una persona mide más de dos metros
	System.out.println("-------Evaluar si mide mas de dos metros ----------");
	Predicate <Persona> personaMasDos = a -> a.getEstatura() > 2.00;
	if (personaMasDos.test(personaA)) {
		System.out.println("Mide mas de dos metros.");
	} else {
		System.out.println("Mide menos de dos metros");
	}
	
	//Crear un predicado que evalúe si la persona no mide más de dos metros 
	System.out.println("-------Evaluar si mide menos de dos metros ----------");
	Predicate <Persona> personaMenosDos = a -> a.getEstatura() < 2.00;
	if (personaMenosDos.test(personaB)) {
		System.out.println("Mide menos de dos metros");
	}else {
		System.out.println("Mide mas de dos metros");
	}
	
	//Crear un predicado que evalúe si es mayor de edad 
	System.out.println("------Evaluar si es mayor de edad------");
	Predicate <Persona> personaMayor = a -> a.getEdad() >18;
	if(personaMayor.test(personaA)) {
		System.out.println("Es mayor de edad");
	}else {
		System.out.println("Es menor de edad");
	}
	
	//Crear un predicado que evalúe si una persona es mayor de edad o mide más de 2 metros
	System.out.println("------Evaluar si es mayor de edad o mide mas de 2 metros -------");
	Predicate <Persona> personaMayorOMasDos = a -> a.getEdad() > 18 || a.getEstatura() > 2.00;
	if(personaMayorOMasDos.test(personaC)) {
	    System.out.println("Es mayor de edad o mide más de 2 metros");
	} else {
		System.out.println("No cumple con ninguna de las condiciones");
	}
	
	//Crear un predicado que evalúe si un rectángulo es un cuadrado
	System.out.println("--------Evaluar si un rectangulo o es un cuadrado----------");
	Predicate<Rectangulo> esUnCuadrado = a -> a.getAltura() == a.getBase();
	if (esUnCuadrado.test(rectyA)) {
		System.out.println("No es un rectangulo, es un CUADRADO");
	} else {
		System.out.println("Es un RECTANGULO");
	}
	
	//Consumer <T>
	System.out.println("-----------CONSUMER<T>-----------");

	//Realizar un consumidor que reciba una persona y muestre su edad por pantalla. 
	System.out.println("-----Muestra de Edad -------");
	Consumer<Persona> mostrarEdad = a -> System.out.println("Tiene: " +a.getEdad() + " años.");
	mostrarEdad.accept(personaA);
	
	//Realizar un consumidor que incremente la edad de una persona en 3. 
	System.out.println("------Incrementador de Edad x 3 ----------");
	Consumer<Persona> incremenTres = a -> System.out.println("Edad incrementada por tres: " + a.getEdad()*3);
	incremenTres.accept(personaB);
	
	//Realizar un consumidor que incremente la edad en 3 de una persona y luego muestre	su edad. 
	System.out.println("-----Muestra de Edad y Edad Triplicada -------");
	Consumer <Persona> mostrarEdadIncrementada = a -> {
		System.out.println("Edad actual: " + a.getEdad());
		System.out.println("Edad Triplicada: " + (a.getEdad()*3));
	};
	mostrarEdadIncrementada.accept(personaC);
	
	//Realizar un consumidor que transforme un rectángulo en un cuadrado, haciendo que su base pase a valer lo que su altura.
	System.out.println("---------De Rectangulo a Cuadrado-------");
	Consumer <Rectangulo> recACuadrado = a -> a.setBase(a.getAltura());
	System.out.println("Base: " + rectyA.getBase() + " Altura:" + rectyA.getAltura());
	recACuadrado.accept(rectyA);
	System.out.println("Base: " + rectyA.getBase() + " Altura:" + rectyA.getAltura());

	}
}
