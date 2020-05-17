import java.io.*;
import java.lang.*;
public class FileReader {
    String readfile()throws Exception{
        File file = new File("C:\\Users\\acer\\eclipse-workspace\\Project\\src\\Paragraph.txt");
       // BufferedReader br = new BufferedReader(new java.io.FileReader(file));
        
        Reader reader =new InputStreamReader(new FileInputStream(file),"UTF-8");
        		BufferedReader fin = new BufferedReader(reader);
        		//String onedoc="";
        
        
        
        String st="",s="";
        while ((st = fin.readLine()) != null)
            s=s+st;
        fin.close();
        return s;
    }
}

