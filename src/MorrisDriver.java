package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class MorrisDriver {
    //mfg, upccol, catnocol, desccol, ctnqtycol, listcol,netcol, specnetcol,umcol,skip
    public static Object[] data2 ={"Morris",1,5,7,6,9,64,64,8,0};

    public static void main(String[] args) throws IOException {
        CSVWriter writer= new CSVWriter("C:\\Users\\cmawe\\M&M Database\\Documents\\FinalMorris.csv");


        File file=new File("C:\\Users\\cmawe\\M&M Database\\Morris\\Morris 5-13-22.csv");
        
        
        BufferedReader reader= new BufferedReader(new FileReader(file));
        CSVParser parser= new CSVParser(writer, reader, (String)data2[0], (int)data2[1], (int)data2[2], (int)data2[3], (int)data2[4], (int)data2[5], (int)data2[6], (int)data2[7], (int)data2[8], (int)data2[9]);
        parser.readCSV();
        
        

        writer.writer.close();
    }
    
}
