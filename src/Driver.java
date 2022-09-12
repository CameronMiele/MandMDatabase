package src;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        CSVWriter writer= new CSVWriter(file);
        CSVParser ag= new CSVParser(file_name, mfg, upcCol, catNoCol, descCol, ctnQtyCol, listCol, netCol, specNetCol, umCol, skip);
        Scanner scan=new Scanner(file_name)
        ag.readCSV(scan);
    }
    
}
