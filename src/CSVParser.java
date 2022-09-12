package src;

import java.io.IOException;
import java.util.Scanner;


public class CSVParser {

    public final String file_name;
    public final int skip;
    public final int upcCol;
    public final int catNoCol;
    public final int descCol;
    public final int ctnQtyCol;
    public final int listCol;
    public final int netCol;
    public final int specNetCol;
    public final int umCol;
    public final String mfg;
    public final CSVWriter csvwriter;

    public CSVParser(CSVWriter csvwriter, String file_name, String mfg, int upcCol, int catNoCol, int descCol, int ctnQtyCol, int listCol, int netCol, int specNetCol, int umCol, int skip){
        this.file_name=file_name;
        this.mfg=mfg;
        this.upcCol=upcCol;
        this.catNoCol=catNoCol;
        this.descCol=descCol;
        this.ctnQtyCol=ctnQtyCol;
        this.listCol=listCol;
        this.netCol=netCol;
        this.specNetCol=specNetCol;
        this.umCol=umCol;
        this.skip=skip;
        this.csvwriter=csvwriter;
    }

    
    public void readCSV(Scanner scan) throws IOException{
        for(int i=0;i<this.skip;i++){
            scan.nextLine();
        }
        while(scan.hasNext()){
            String[] tokens= scan.nextLine().split(",");
            for(int i=0;i<tokens.length;i++){
                this.csvwriter.writeCol(this.mfg);
                this.csvwriter.writeCol(tokens[this.upcCol]);
                this.csvwriter.writeCol(tokens[this.catNoCol]);
                this.csvwriter.writeCol(tokens[this.descCol]);
                this.csvwriter.writeCol(tokens[this.ctnQtyCol]);
                this.csvwriter.writeCol(tokens[this.umCol]);
                this.csvwriter.writeCol(tokens[this.listCol]);
                this.csvwriter.writeCol(tokens[specNetCol]);
                
            }
            this.csvwriter.addNewLine();
        }
    }
    
    public static void main(String[] args) {
        Scanner scan= new Scanner(file_name);
        readCSV(scan);
    }
}
