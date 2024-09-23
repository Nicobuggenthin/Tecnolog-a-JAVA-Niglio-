package Comparators;
import java.util.Comparator;
import Models.FechaFestiva;

public class ComparadorNombre  implements Comparator <FechaFestiva>  {
	@Override
	public int compare (FechaFestiva nombre1, FechaFestiva nombre2) {
		return nombre1.getNombre().compareToIgnoreCase(nombre2.getNombre());
	}

}
