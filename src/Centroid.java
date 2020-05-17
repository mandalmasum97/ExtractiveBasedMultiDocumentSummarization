import java.util.HashMap;
import java.util.Map;

public class Centroid 
{
	 Map<String,Double> cal(Map<Integer,String> hm2,double threshold,double isf[])
	 {
		 Map<String, Double> crd = new HashMap<String, Double>();
		 for(int i=0;i<=isf.length-1;i++) 
		 {
			 
			 if(isf[i]>=threshold)
		     {
				//System.out.println((hm2.get(i+1)));
				 crd.put(hm2.get(i+1),isf[i]);
			 }
		 }
		 return crd;
	 }
	
}
