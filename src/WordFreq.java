import java.util.HashMap;
import java.util.Map;
public class WordFreq {
    Map<String,Integer> wordfreq(String w[]){
        Map<String, Integer> hm = new HashMap<String, Integer>();
       // Map<String, Integer> pos = new HashMap<String, Integer>();
        //int i=0;   
        for (int k=0; k<w.length ; k++)
        {
        	
            if(hm.containsKey(w[k]))
            {
                int cont = hm.get(w[k]);
                hm.put(w[k], cont + 1);
            }
            else
            {
                hm.put(w[k], 1);
               // pos.put(w[k],i++);
            }
        }
        //System.out.println(pos);
        return hm;
    }
}
