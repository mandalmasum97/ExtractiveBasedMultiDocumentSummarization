
public class mean 
{

	public double Mean(double isf[])
	{
	 double mu=0.0;
	 double sum=0;
	 for(int i=0;i<isf.length;i++)
	 {
		 //System.out.println(isf[i]);
		 sum+=isf[i];
	 }
	 
	 mu=sum/(isf.length);
	
	 return mu;
		
	}
}
