package Comparators;
import java.util.Comparator;
import Models.FechaFestiva;

public class ComparadorFanatismo implements Comparator <FechaFestiva>  {
	@Override
	public int compare(FechaFestiva fanatic1, FechaFestiva fanatic2 ) {
		return Double.compare(fanatic1.getFanatismo(), fanatic2.getFanatismo());
	}

}
