package Mains;

import java.util.ArrayList;
import java.util.Comparator;

import Models.FechaFestiva;
import Comparators.ComparadorDia;
import Comparators.ComparadorFanatismo;
import Comparators.ComparadorMes;
import Comparators.ComparadorNombre;


public class main {

	public static void main(String[] args) {
		
		//Crear una lista con 10 fechas o más//
		FechaFestiva fecha1 = new FechaFestiva(1, 1, "Año Nuevo", 0.95);
		FechaFestiva fecha2 = new FechaFestiva(25, 5, "Revolución de Mayo", 0.88);
		FechaFestiva fecha3 = new FechaFestiva(9, 7, "Independencia", 0.90);
		FechaFestiva fecha4 = new FechaFestiva(12, 10, "Respeto a la Diversidad Cultural", 0.75);
		FechaFestiva fecha5 = new FechaFestiva(8, 12, "Dia de la Virgen", 0.80);
		FechaFestiva fecha6 = new FechaFestiva(25, 12, "Navidad", 0.99);
		FechaFestiva fecha7 = new FechaFestiva(2, 4, "Veterano y de los Caídos en la Guerra de Malvinas", 0.85);
		FechaFestiva fecha8 = new FechaFestiva(1, 5, "Trabajador", 0.87);
		FechaFestiva fecha9 = new FechaFestiva(20, 6, "Bandera", 0.90);
		FechaFestiva fecha10 = new FechaFestiva(16, 7, "Dia del Amigo", 0.92);
		
		ArrayList<FechaFestiva> fechas= new ArrayList<FechaFestiva>();
		
		fechas.add(fecha1);
		fechas.add(fecha2);
		fechas.add(fecha3);
		fechas.add(fecha4);
		fechas.add(fecha5);
		fechas.add(fecha6);
		fechas.add(fecha7);
		fechas.add(fecha8);
		fechas.add(fecha9);
		fechas.add(fecha10);
		
		// Mostrar el listado completo de fechas. 
		
		System.out.println("----------Fechas Festivas: --------------");
		for (FechaFestiva ffestivas: fechas) {
			System.out.println(ffestivas);
		}
		
		
		//Mostrar el listado ordenado por nombre
		
		Comparator<FechaFestiva> ComparadorNombre = new ComparadorNombre();
		fechas.sort(ComparadorNombre);
		
		System.out.println("--------Ordenado por Nombre:  -------------");
		for (FechaFestiva ffestivas: fechas) {
			System.out.println(ffestivas);
		}

		
		//Mostrar el listado ordenado por su ordenamiento natural. 
		
		System.out.println("---------Ordenamiento natural:    ----------");
		fechas.sort(null);
		for(FechaFestiva ffestivas: fechas) {
			System.out.println(ffestivas);
		}
		
		//Mostrar ordenado por día
		Comparator<FechaFestiva>ComparadorDia = new ComparadorDia();
		fechas.sort(ComparadorDia);
		System.out.println("-------Ordenado por Dias:   ----------------");
		for(FechaFestiva ffestivas: fechas) {
			System.out.println(ffestivas);
		}
		
		// Mostrar el listado de fechas por fanatismo de mayor a menor
		
		Comparator<FechaFestiva>ComparadorFanatismo = new ComparadorFanatismo();
		Comparator<FechaFestiva>ComparadorFanatismoReversed =ComparadorFanatismo.reversed();
		fechas.sort(ComparadorFanatismoReversed);

		System.out.println("-------Ordenado por Fanatismo- Reversed:   ----------------");
		for(FechaFestiva ffestivas: fechas) {
			System.out.println(ffestivas);
		}
		
		// Mostrar ordenado por mes
		Comparator<FechaFestiva>ComparadorMes = new ComparadorMes();
		fechas.sort(ComparadorMes);
		
		System.out.println("-------Ordenado por Mes:   ----------------");
		for(FechaFestiva ffestivas: fechas) {
			System.out.println(ffestivas);
		}	
		
		// Mostrar ordenado por mes y dia
		Comparator<FechaFestiva>ComparadorMesyDia = ComparadorMes.thenComparing(ComparadorDia);
		fechas.sort(ComparadorMesyDia);
		
		System.out.println("-------Ordenado por Mes y Dia:   ----------------");
		for(FechaFestiva ffestivas: fechas) {
			System.out.println(ffestivas);
		}	
		
		// Mostrar el listado ordenado por fanatismo (ascendente) y nombre (decente) 
		Comparator<FechaFestiva>ComparadorNombreReversed = ComparadorNombre.reversed();
		Comparator<FechaFestiva>ComparadorFanatismoyNombre= ComparadorFanatismo.thenComparing(ComparadorNombreReversed);
		fechas.sort(ComparadorFanatismoyNombre);
		
		System.out.println("-------Ordenado por Fanatismo y Nombre:   ----------------");
		for(FechaFestiva ffestivas: fechas) {
			System.out.println(ffestivas);
		}	
		
		

	}

}
