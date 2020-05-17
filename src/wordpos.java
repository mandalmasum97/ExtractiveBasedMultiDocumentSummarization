import java.util.HashMap;
import java.util.Map;
public class wordpos {
    Map<String,Integer> wordPos(String w[]){
        Map<String, Integer> pos = new HashMap<String, Integer>();
        int i=0;
        for (int k=0; k<w.length ; k++)
        {
        	
            if(pos.containsKey(w[k]))
            {
            }
            else
            {
                pos.put(w[k],i++);
            }
        }
        return pos;
    }
}
