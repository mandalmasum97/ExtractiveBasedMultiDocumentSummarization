import java.util.Arrays;
import java.util.Map;

public class WordFreqMat {
    public String[][] wordfreqmat(Map<String, Integer> hm,int senlen,String sen[],String mat[][]){
        int p=0;
        int wf[]=new int[hm.size()];
        for(int k=0;k<senlen;k++)
        {
            Stemmer stm = new Stemmer();
            p++;
            String b[]=sen[k].split("[\\s+ -,]"); //hm,llen,l[k]
            String s =" ";
            s = s.trim()+" "+Arrays.toString(b);
            s = stm.foo(s);
            Split sp = new Split();
            String a[] = sp.WordSplit(s);
            for(int n=1;n<hm.size()+1;n++)
            {

                int ct=0;
                for(int m=0;m<a.length;m++)
                {
                    if(mat[0][n].equalsIgnoreCase(a[m]))
                        ct++;
                }
                mat[0+p][n]=Integer.toString(ct);
                //creating the array for the total number of times a word is present in every sentence.
                if(ct>0)
                    wf[n-1]++;
            }
        }
        return mat;
    }
    int[] wordfreqmatwf(String sen[],int senlen,String mat[][],Map<String,Integer> hm){
        int p=0;
        int wf[]=new int[hm.size()];
        for(int k=0;k<senlen;k++)
        {
            Stemmer stm = new Stemmer();
            p++;
            String b[]=sen[k].split("[\\s+ -,]"); //hm,llen,l[k]
            String s =" ";
            s = s.trim()+" "+Arrays.toString(b);
            s = stm.foo(s);
            Split sp = new Split();
            String a[] = sp.WordSplit(s);
            for(int n=1;n<hm.size()+1;n++)
            {

                int ct=0;
                for(int m=0;m<a.length;m++)
                {
                    if(mat[0][n].equalsIgnoreCase(a[m]))
                        ct++;
                }
                mat[0+p][n]=Integer.toString(ct);
                //creating the array for the total number of times a word is present in every sentence.
                if(ct>0)
                    wf[n-1]++;
            }
        }
        return wf;
    }

    void printwordfreqmat(int senlen,String matr[][],Map<String, Integer> hm){
        int s1=1;
        for(int k=0;k<senlen+1;k++)
        {
            for(int n=0;n<hm.size()+1;n++)
            {
                if(n==0 && k!=0)
                {
                    System.out.print("sent"+s1+"\t");
                    s1++;
                }
                else
                    System.out.print(matr[k][n]+"\t");
            }
            System.out.println();
        }
    }

}