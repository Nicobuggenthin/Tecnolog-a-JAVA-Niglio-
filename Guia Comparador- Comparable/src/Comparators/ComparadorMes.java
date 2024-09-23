package Comparators;
import java.util.Comparator;
import Models.FechaFestiva;

public class ComparadorMes implements Comparator<FechaFestiva> {
	@Override
	public int compare(FechaFestiva fecha1, FechaFestiva fecha2) {
		return Integer.compare(fecha1.getMes(), fecha2.getMes());
	}
	
}
