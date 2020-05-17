
public class standard_dev 
{
	double st_dv(double mn,double isf[])
	{
		double sum=0,var=0,dev=0;
		for(int i=0;i<isf.length;i++)
		{
			sum+=Math.pow(isf[i]-mn,2);
		}
		var=sum/(isf.length);
		dev=Math.sqrt(var);
		return dev;
	}

}
