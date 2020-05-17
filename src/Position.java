import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.*;
public class Position {
	public double[] positional(int senlen)
	{
		double[] crd = new double[senlen];
		for(int i=1;i<=senlen;i++)
		{
			
			
			Double d=0.0;
			d=(1+9*Math.log10(i+1));
			//System.out.println("d;;;;;;="+d);
			d=1/d;
			//System.out.println("d="+d);
			crd[i-1]=d;
			
		}
		return crd;
	}

}
