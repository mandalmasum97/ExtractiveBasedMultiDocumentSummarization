public class Split {
    String[] SenSplit(String s){
        String a[] = s.split("[.?!]");
        return a;
    }
    String[] WordSplit(String s){
        String b[] = s.split("[\\W+]");
        return b;
    }
}