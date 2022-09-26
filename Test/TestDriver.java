package Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import src.CSVWriter;
import src.CSVParser;

public class TestDriver {
//mfg, upccol, catnocol, desccol, ctnqtycol, listcol,netcol, specnetcol,umcol,skip
    public static Object[] data = {"Morris",1,5,7,13,9,64,64,8,0};


    public static void main(String[] args) throws IOException {
        CSVWriter writer= new CSVWriter("C:\\Users\\cmawe\\M&M Database\\Documents\\FinalPriceSheet.csv");
        File folder= new File("C:\\Users\\cmawe\\M&M Database\\Test\\test.csv");
        //File[] files= new File[folder.listFiles().length];
        //for(int i=0;i<folder.listFiles().length;i++){
          //  File file= new File(folder.listFiles()[i].toString());
            //files[i]=file;
        //}
        //for(int j=0;j<files.length-1;j++){
            Scanner scan= new Scanner(folder);
            CSVParser parser= new CSVParser(writer, scan, (String)data[0], (int)data[1], (int)data[2], (int)data[3], (int)data[4], (int)data[5], (int)data[6], (int)data[7], (int)data[8], (int)data[9]);
            parser.readCSV();
            scan.close();
           
       
    }
}
