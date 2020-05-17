import java.util.Map;
import java.util.Set;

public class HashsetArray {
    String[][] hashsetarray(int senlen,Map<String,Integer> hm){
        String mat[][]=new String[senlen+1][hm.size()+1];
        mat[0][0]="st/wds";
        int c1=1;
        Set<String> keys = hm.keySet();
        for(String key: keys)
        {
            mat[0][c1]=key;
            c1++;
        }
        return mat;
    }
}
