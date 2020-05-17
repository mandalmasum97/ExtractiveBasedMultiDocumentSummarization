import java.util.Map;
import java.util.Set;

public class IsfTf {
    String[][] isftftab(int senlen,Map<String,Integer> hm,double isf[],String mat[][],int wf[]){
        String isftf[][]=new String[senlen+1][hm.size()+1];
        Set<String> kys = hm.keySet();
        int c1=1;
        for(String key: kys)
        {
            isftf[0][c1]=key;
            c1++;
        }
        isftf[0][0]="st/wd\t";
        for(int k=1;k<senlen+1;k++)
        {
            for(int n=1;n<hm.size()+1;n++)
            {
            	if(Double.parseDouble(mat[k][n])!=0.0)
                isftf[k][n]=Double.toString((Math.floor((isf[n-1])*(Double.parseDouble(mat[k][n]))*wf[n-1]*100)/100d));
            	else
            		isftf[k][n]=Double.toString(0.0);
            	//isftf[k][n]=Double.toString((Math.floor((isf[n-1])*wf[n-1]*100)/100d));
            }
        }
        return isftf;
    }
    double[] tfisfvec(int senlen,Map<String,Integer> hm,double isf[],String mat[][],int wf[])
    {
        double isftf[]=new double[wf.length];
       // Set<String> kys = hm.keySet();
        int c1=1;
        
       // isftf[0][0]="st/wd\t";
        for(int k=0;k<wf.length;k++)
        {
           
            	//if(Double.parseDouble(mat[k][n])!=0.0)
                isftf[k]=(((isf[k])*wf[k]));
            	
        }
        return isftf;
    }
    void printisftf(int senlen, Map<String,Integer> hm,String isftf[][]){
        int s1=1;
        for(int k=0;k<senlen+1;k++)
        {
            for(int n=0;n<hm.size()+1;n++)
            {
                if(n==0 && k!=0)
                {
                    System.out.print("sent"+s1+"\t\t");
                    s1++;
                }
                else
                    System.out.print(isftf[k][n]+"\t");
            }
            System.out.println();
        }
    }
}
