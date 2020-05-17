public class IsfTab {
    double[] isftab(int[] wf, int senlen){
        double isf[]=new double[wf.length];
        for(int k=0;k<isf.length;k++)
            isf[k]=Math.floor(Math.log(((double)(senlen))/((double)wf[k]))*100)/100d;
        return isf;
    }
    void printisftab(double isf[]){
        System.out.print("\nisfvalue \t");
        for(int k=0;k<isf.length;k++)
            System.out.print(isf[k]+"\t");
        System.out.println("\n");
    }
}
