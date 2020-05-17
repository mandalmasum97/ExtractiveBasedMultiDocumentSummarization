import java.lang.*;
import java.util.*;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.process.DocumentPreprocessor;

import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception 
    {
    	//reading a file
        FileReader fp = new FileReader();
        String s = fp.readfile();
        //System.out.println("The main text : \n");
       // System.out.println(s+"\n");
        
        //sentence segmentation
        Split sp = new Split();
        String sen[] = sp.SenSplit(s);
        
        Stopword st =new Stopword();
        Stemmer stem1=new Stemmer();
        Reader reader = new StringReader(s);
		  DocumentPreprocessor dp1 = new DocumentPreprocessor(reader);
		  
		  List<String> sentList=new ArrayList<>();
		  
		  for (List<HasWord> sentence : dp1) 
		  {
			  String line=sentence.toString();
			 // System.out.println(line);
		    // Comparable<String> sentenceString = Sentence.listToString(sentence);
		    
			sentList.add(line);
		  }      
        int senlen = sen.length;
        System.out.println("Number of sentence: "+senlen+"\n");
        System.out.println("The sentences are: \n");
        for(String m : sen)
            System.out.println(m);
        
        //word segmentation
        String word1[] = sp.WordSplit(s);
        int wordlen = word1.length;
        System.out.println("\n Number of words: "+wordlen);
       /* System.out.println("\nThe words are: \n");
        for(String m : word1)
            System.out.println(m);*/
        
        //removing stopwords
        Stopword stp=new Stopword();	
        String str=stp.stp(word1);
        
        //stemming
        Stemmer stemmer=new Stemmer();
        str=stemmer.foo(str);
        String word[] = sp.WordSplit(str);
        
        //finding out unique words
        WordFreq wfq = new WordFreq();
        Map<String, Integer> hm = wfq.wordfreq(word);
        System.out.println("\n The number of unique words: "+hm.size());
        System.out.println("\n The qnique words and their numbers of occurence: \n\n"+hm+"\n");
        
        //uniques words are put into the matrix
        HashsetArray ha = new HashsetArray();
        String mat[][]=ha.hashsetarray(senlen,hm);
        
        //calculating the word frequency in each sentence
        WordFreqMat wfqm = new WordFreqMat();
        String matr [][]=wfqm.wordfreqmat(hm,senlen,sen,mat);
        System.out.println("\n The word frequency table: \n");
        wfqm.printwordfreqmat(senlen,matr,hm);
        System.out.println("\n");
        
        //printing the matrix
        int wf[] = wfqm.wordfreqmatwf(sen,senlen,mat,hm);
        WordFreqTab wft = new WordFreqTab();
        wft.wordfreqtab(wf);
        
        //finding out its isfvalue
        IsfTab isft = new IsfTab();
        double isf[] = isft.isftab(wf,senlen);
        System.out.println("\n The Isf values : \n");
        isft.printisftab(isf);
        
      //System.out.println(isf2);
        
        
        //finding out its isftf value
        IsfTf ist = new IsfTf();
        String isftf[][] = ist.isftftab(senlen,hm,isf,matr,wf);
        System.out.println("\n The tf-isf  table: \n");
        ist.printisftf(senlen,hm,isftf);
        double[] tfisfvector = ist.tfisfvec(senlen,hm,isf,matr,wf);
        System.out.print("\n\ntfisf vector:\n");
        for(int i=0;i<tfisfvector.length;i++) {
        	System.out.print(tfisfvector[i]+"\t");
        }
        
        
        //cosine similarity
        CosineSemanticSimilarity cs = new CosineSemanticSimilarity();
        int x=hm.size();
        double[][] cosinetab=new double[senlen][senlen]; 
    	double[] nums1= new double[x];
		double[] nums2= new double[x];
        for(int i=1;i<=senlen;i++)
        {
        	for(int j=1;j<=senlen;j++)
        	{
        		/*if(i==j)
        			cosinetab[i-1][j-1]=1;
        		else*/
        	for (int k=1;k<=x; k++) 
        	{
        		    nums1[k-1] = Double.parseDouble(isftf[i][k]);
        		    nums2[k-1] = Double.parseDouble(isftf[j][k]);
        	}
            cosinetab[i-1][j-1]=cs.cosineSimilarity(nums1,nums2);
        	}
        }
        System.out.println();
        System.out.println("Cosine Similarity table:");
        for(int i=0;i<=senlen;i++)
        {
        	if(i>0)
        	for(int j=0;j<=senlen;j++)
        	{
        		if(j>0)
        			System.out.print(cosinetab[i-1][j-1]+"	");
        		else
        			System.out.print("Sentence"+i+"	");	
        	}
        	else
        	{
        		System.out.print("		");
        		for(int j=1;j<=senlen;j++)
            	{
        			System.out.print("Sentence"+j+"	");
            	}
        	}
    	System.out.println();
    	}
        //the unique words are put into another hashmap with index numbers.
       
        Map<Integer,String> hm2 = new HashMap<Integer,String>();
        uni u=new uni();
        hm2=u.Count(hm);
        
        //position hashmap
        System.out.println("\nhashmap with position");
        System.out.println(hm2);
        
        //freq of unique words hashmap
        System.out.println("\nhashmap with frequency value");
        System.out.println(hm); 
        
        System.out.println("\nmean value");
        //calculating mean
        mean m=new mean();
        double mn=0;
        mn=m.Mean(tfisfvector);
        System.out.println(mn);
         
        System.out.println("\nStandard deviaton value");
        //calculating standard deviation
        standard_dev dev=new standard_dev();
        double deviation=dev.st_dv(mn,tfisfvector);
        System.out.println(deviation);
        
        System.out.println("\nthreshold value");
        //calculating threshold
        double threshold=(mn+deviation)/2;
        System.out.println(threshold);
        
        //calculation of centroid
        Centroid cen=new Centroid();
        Map<String, Double> crd = new HashMap<String, Double>();
        crd=cen.cal(hm2,threshold,isf);
        System.out.println("the size of the centroid is: "+ crd.size());
        System.out.println("\nthe centroid words are:  \n");
        System.out.println(crd+"\n");
        
        //Calculate the similarity with the centroid.
        
        Map<String, Double> crd1 = new HashMap<String, Double>();
        crd1=crd;
		 Set<String> keys = hm.keySet();
		 for(String key: keys)
	        {
			 crd1.putIfAbsent(key,0.0);
           }
		 System.out.println(crd1+"\n\n");
		// System.out.println("Centroid score....\n\n\n");
      double[] centscore=new double[senlen]; 
    	double[] nums3= new double[x];
    	double[] nums4= new double[x];
    	//System.out.println(nums3);
    	//System.out.println(nums4);
    	Set<String> keys1 = crd1.keySet();
    	int i=0;
		 for(String key: keys1)
	        {
			 nums3[i]=crd1.get(key);
			 i++;
          }
		// for(int n=0;n<i;n++)
			// System.out.println(nums3[n]);
		// System.out.println("\n\n\n");
        for(int j=1;j<=senlen;j++)
        	{
        	
        	for (int k=1;k<=x; k++) 
        	{
        		    nums4[k-1] = Double.parseDouble(isftf[j][k]);
        		   // System.out.print(nums4[k-1]+"  ");
        		    //System.out.println(nums3[k-1]);
        	}
        	//System.out.println("\n\n\n");
            centscore[j-1]=cs.cosineSimilarity(nums3,nums4);
        	}
    	
    	System.out.println("\n\nThe centroid scores: ");
        for(int j=0;j<senlen;j++)
    	{
        	System.out.print ("s"+j);
       /* 	if(Double.isNaN(centscore[j]))
        	{
        		centscore[j]=0.0;
        	}*/
        	System.out.print ("  "+centscore[j]+" ");
    	}
        
        //The similarity with first scores
        double[] swfscore=new double[senlen];
    	for (int k=0;k<senlen; k++) 
    	{
    		   swfscore[k] =cosinetab[0][k];
    	}
	//System.out.println(swfscore);
        System.out.println("\n\nThe similarity with first scores: ");
        for(i=0;i<senlen;i++)
    	{
        	System.out.print ("  s"+i+" ");
        	System.out.print (swfscore[i]);
    	}
        //positional score
		 
        Position ps=new Position();
        double[] psn = new double[senlen];
        psn=ps.positional(senlen);
        System.out.println("\n\nThe positional scores: ");
        //System.out.println("\n"+psn);
        for(i=0;i<senlen;i++)
    	{
        	System.out.print ("  s"+i+" ");
        	System.out.print (psn[i]);
    	}
        
        //final score calculation
        Map<Integer, Double> fscore = new HashMap<Integer, Double>();
        double scr;
    	for (int k=0;k<senlen; k++) 
    	{
    		   scr=0.3*centscore[k]+0.1*psn[k]+0.0*swfscore[k];
    		   fscore.put(k+1,scr);
    	}
    	System.out.println("\n\nThe final scores: ");	
        System.out.println("\n"+fscore);
        sortmap smap=new sortmap();
        fscore=smap.sortHashMapByValues(fscore);
        System.out.println("\n"+fscore);
         System.out.println("\nEnter the required size of the summarized text in % : \n\n");
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        Set<Map.Entry<Integer,Double>> mapSet = fscore.entrySet();
        //Map.Entry<Integer,Double> elementAt5 = (Map.Entry<Integer,Double>) mapSet.toArray()[5];
        //System.out.println(elementAt5);
        int[] sumsen = new int[fscore.size()];
        int j=0;
        for(i=fscore.size()-1;i>fscore.size()-(fscore.size()*p/100)-1;i--)
        {
        	Map.Entry<Integer,Double> element = (Map.Entry<Integer,Double>) mapSet.toArray()[i]; 
        	//System.out.println("\n"+sen[element.getKey()-1]);
        	sumsen[j++]=element.getKey();
        	 
        }
       
        int n=j;
     System.out.println("Result sentences before sorting.");
        for(i=0;i<n;i++)
        {
        	System.out.println(sumsen[i]);
        }
        
        for (i = 0; i < n-1; i++)
            for (j = 0; j < n-i-1; j++)
                if (sumsen[j] > sumsen[j+1])
                {
                    // swap temp and arr[i]
                    int temp = sumsen[j];
                    sumsen[j] = sumsen[j+1];
                    sumsen[j+1] = temp;
                }
       System.out.println("\n\nThe generated sumarry is following.......!!\n\n\n ");
        //System.out.println(sentList);
    for(i=0;i<n;i++)
    {
    	//System.out.println(sumsen[i]);
    	//System.out.println(sentList.get(sumsen[i]-1));
    	System.out.println(sen[sumsen[i]-1]);
    }
    }
   }