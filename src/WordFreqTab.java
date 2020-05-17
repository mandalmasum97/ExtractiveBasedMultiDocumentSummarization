public class WordFreqTab {
    void wordfreqtab(int wf[]){
        System.out.print("sentfreq\t");
        for(int k=0;k<wf.length;k++)
            System.out.print("\t"+wf[k]);
        System.out.println();
    }
}
