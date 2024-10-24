package Mains;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Models.Persona;
import Models.Rectangulo;

public class Main {

	public static void main(String[] args) {
		
		List<Rectangulo> listaRectangulos = Stream.generate(() -> Rectangulo.getRandom()).limit(50).toList();
		/* List<Rectangulo> listaRectangulos = List.of(
			    new Rectangulo(null, 30, 50),
			    new Rectangulo(null, 20, 70),
			    new Rectangulo(null, 6, 4)
			);*/

		List<Persona> listaPersonas = Stream.generate(() -> Persona.getRandom()).limit(100).toList();
		/*List<Persona> listaPersonas = List.of(
			    new Persona("Juan", "Pérez", 95, 70, 1.75),
			    new Persona("Ana", "Gómez", 35, 60, 1.60),
			    new Persona("Luis", "Martínez", 40, 80, 1.80),
			    new Persona("Marta", "Sánchez", 28, 55, 1.50),
			    new Persona("Carlos", "López", 50, 90, 1.70),
			    new Persona("Sofía", "Fernández", 22, 65, 1.68),
			    new Persona("Diego", "Ramírez", 33, 75, 1.72),
			    new Persona("Lucía", "Torres", 29, 68, 1.55),
			    new Persona("Roberto", "Hernández", 45, 85, 1.82)
			); */

		
		//Mostrar los rectángulos cuya área es mayor a 300 y su base sea mayor a su altura. //
		//Ordenarlos por la suma de su área y su perímetro de mayor a menor //
		
		System.out.println("------------------------------Rectangulos--------------------------------------------------------------");
		
		 Function<Rectangulo,Double> suma =
				 (Rectangulo r)-> r.getArea() + r.getPerimetro();
				listaRectangulos.stream()
				 .filter( r->r.getArea() > 300 )
				 .filter( r->r.getBase() > r.getAltura() )
				 .sorted( Comparator.comparing( suma ).reversed() )
				 .forEach(System.out::println);
				
		
		//2. Crear una lista convirtiendo la lista de personas en rectángulos (Siendo la estatura*50 la altura y el peso la base),
		//pero solo incluyendo las personas de más de 30 años, ordenadas por edad.
		System.out.println("---------------------------------Lista Convertida-------------------------------------------------------------");
		
		Function<Persona, Rectangulo> conversor =
				p -> new Rectangulo ( p.getNombre(), p.getPeso(), p.getEstatura()*50);
				
				listaPersonas.stream()
						.filter(p -> p.getEdad() > 30)
						.sorted (Comparator.comparing (Persona :: getEdad))
						.map(conversor)
						.forEach(System.out::println);

				 
		//3. Mostrar las personas mayores a 30 años que midan más de 1,5 metros. Los mismos deben estar ordenados por edad como
		//primer criterio y estatura como segundo criterio.
				
		System.out.println("--------------------------------------Personas Mayores a 30------------------------------------------------");
		
		listaPersonas.stream()
				.filter(p -> p.getEdad() > 30)
				.filter(p -> p.getEstatura() > 1.5)
				.sorted(Comparator.comparing(Persona::getEdad)
								  .thenComparing(Persona :: getEstatura))
				.forEach(System.out::println);
		
		//4. Mostrar la persona más joven, contemplando solo las 10 personas más altas.
			
		System.out.println("---------------------------------------Persona mas joven-------------------------------------------------");
		
			
		listaPersonas.stream()
		 .sorted( Comparator.comparing( Persona::getEstatura).reversed())
		 .limit(10)
		 .min( Comparator.comparing( Persona::getEdad ))
		 .ifPresent(System.out::println); 
		
		//5. Mostrar los 30 rectángulos con más área, ordenados por perímetro.
		
		System.out.println("---------------------------------------30 Rectangulos con mas area-------------------------------------------------");
		
		listaRectangulos.stream()
		.sorted(Comparator.comparing(Rectangulo :: getArea).reversed())
		.limit(30)
		.sorted(Comparator.comparing(Rectangulo :: getPerimetro))
		.forEach(System.out :: println);
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------");
	
	
		


		

				 

				 
				

		


	}

}
