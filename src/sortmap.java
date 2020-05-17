
import java.lang.*;
import java.util.*;
import java.io.*;
public class sortmap {
	public LinkedHashMap<Integer, Double> sortHashMapByValues(Map<Integer, Double> wordtfidf_rank_sent2) 
	{
        List<Integer> mapKeys = new ArrayList<>(wordtfidf_rank_sent2.keySet());
        List<Double> mapValues = new ArrayList<>(wordtfidf_rank_sent2.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<Integer, Double> sortedMap =
            new LinkedHashMap<>();

        Iterator<Double> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Double val = valueIt.next();
            Iterator<Integer> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Integer key = keyIt.next();
                Double comp1 = wordtfidf_rank_sent2.get(key);
                Double comp2 = val;

                if (comp2.equals(comp1)) {
                    keyIt.remove();
                    sortedMap.put(key, comp1);
                    break;
                }
            }
        }
        return sortedMap;
    }
	
	
}
