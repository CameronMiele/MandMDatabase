package src;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner scan=new Scanner("../OriginalCSVFiles/A G MFG 2-15-2022.csv");
        CSVWriter writer= new CSVWriter("../Documents/FinalPriceSheet.csv");
        CSVParser ag= new CSVParser(writer, scan, "A&G", upcCol, catNoCol, 3, 4, 5, 6, 64, 7, 5);
        
        ag.readCSV(scan);
    }
    
}
