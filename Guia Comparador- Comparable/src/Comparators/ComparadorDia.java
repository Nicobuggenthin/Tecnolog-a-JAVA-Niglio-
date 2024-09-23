package Comparators;
import java.util.Comparator;
import Models.FechaFestiva;

public class ComparadorDia implements Comparator <FechaFestiva> {
	
	@Override
	public int compare(FechaFestiva dia1, FechaFestiva dia2) {
		return Integer.compare(dia1.getDiasTotales(), dia2.getDiasTotales());
	}

}
