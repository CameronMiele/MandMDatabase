package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {

    //mfg, upccol, catnocol, desccol, ctnqtycol, listcol,netcol, specnetcol,umcol,skip
    //@TODO Make 128=c
    //@TODO Make 256=e
    //Mag-bit upc +722170
    //Kiddie: used std package price for net

    public static Object[][] data = {{"A&G",64,2,3,4,7,6,64,5,1},
                                    {"Allied Moulded",1,0,6,4,2,3,64,128,1},
                                    {"Arlington",3,1,2,4,6,64,64,128,5},
                                    {"Broan-Nutone",5,0,1,2,3,4,64,64,2},
                                    {"Cooper Wiring",11,0,1,8,2,3,64,256,6},
                                    {"Edison Fuses",4,0,9,2,7,8,64,256,7},
                                    {"GB",12,0,1,4,2,64,64,3,1},
                                    {"Greaves",64,0,2,3,4,1,64,256,4},
                                    {"Intermatic",3,1,2,9,10,64,64,256,2},
                                    {"Kiddie",4,1,2,5,7,64,64,256,5},
                                    {"Klein",1,0,2,3,6,9,64,5,12},
                                    {"Lutron",3,0,2,64,5,6,64,256,1},
                                    {"Mag-Bit",8,0,1,7,2,3,64,256,7},
                                    {"Morris",1,5,7,13,9,64,64,8,4},
                                    {"PECO",6,1,2,5,3,64,64,128,7},
                                    {"Selecta",1,0,2,64,4,64,64,3,7},
                                    {"Siemens",64,1,64,2,5,6,64,256,6},
                                    {"Topaz",2,1,3,7,5,4,64,256,10}};

    public static void main(String[] args) throws IOException {
        CSVWriter writer= new CSVWriter("C:\\Users\\cmawe\\M&M Database\\Documents\\FinalPriceSheet.csv");
        File folder= new File("C:\\Users\\cmawe\\M&M Database\\OriginalCSVFiles");
        File[] files= new File[folder.listFiles().length];
        for(int i=0;i<folder.listFiles().length;i++){
            File file= new File(folder.listFiles()[i].toString());
            files[i]=file;
        }
        for(int j=0;j<files.length-1;j++){
            BufferedReader reader= new BufferedReader(new FileReader(files[j]));
            CSVParser parser= new CSVParser(writer, reader, (String)data[j][0], (int)data[j][1], (int)data[j][2], (int)data[j][3], (int)data[j][4], (int)data[j][5], (int)data[j][6], (int)data[j][7], (int)data[j][8], (int)data[j][9]);
            parser.readCSV();
            reader.close();
        }      
        writer.writer.close();
    }   
}
