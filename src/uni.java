import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class uni
{

	 Map<Integer,String> Count(Map<String,Integer> hm)
	 {
		 Map<Integer,String> hm2 = new HashMap<Integer,String>();
		 Set<String> keys = hm.keySet();
		 int c=1;
		 for(String key: keys)
	        {
	           hm2.put(c,key);
	           c++;
	        } 																																																																																																																															
	   return hm2;
	 }
}