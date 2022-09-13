package src;

import java.io.IOException;
import java.util.Scanner;


public class CSVParser {

    public final Scanner scan;
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

    public CSVParser(CSVWriter csvwriter, Scanner scan, String mfg, int upcCol, int catNoCol, int descCol, int ctnQtyCol, int listCol, int netCol, int specNetCol, int umCol, int skip){
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
        this.scan=scan;
    }

    
    public void readCSV() throws IOException{
        for(int i=0;i<this.skip;i++){
            scan.nextLine();
        }
        while(scan.hasNext()){
            String[] tokens= scan.nextLine().split(",");
            if(tokens.length<=3){
                this.csvwriter.writeCol("");
                continue;
            }
            for(int i=0;i<tokens.length;i++){
                this.csvwriter.writeCol(this.mfg);
                if(this.upcCol==64){
                    this.csvwriter.writeCol("");
                }else{
                    if(tokens.length<this.upcCol){
                        this.csvwriter.writeCol("value");
                    }else{
                        this.csvwriter.writeCol(tokens[this.upcCol]);
                    }
                }
                if(this.catNoCol==64){
                    this.csvwriter.writeCol("");
                }else{
                    if(tokens.length<=this.catNoCol){
                        this.csvwriter.writeCol("value");
                    }else{
                        this.csvwriter.writeCol(tokens[this.catNoCol]);
                    }
                }
                if(this.descCol==64){
                    this.csvwriter.writeCol("");
                }else{
                    if(tokens.length<=this.descCol){
                        this.csvwriter.writeCol("value");
                    }else{
                        this.csvwriter.writeCol(tokens[this.descCol]);
                    }
                }
                if(this.ctnQtyCol==64){
                    this.csvwriter.writeCol("");
                }else{
                    if(tokens.length<=this.ctnQtyCol){
                        this.csvwriter.writeCol("");
                    }else{
                        this.csvwriter.writeCol(tokens[this.ctnQtyCol]);
                    }
                }
                if(this.umCol==64){
                    this.csvwriter.writeCol("");
                }else if(this.umCol==128){
                    this.csvwriter.writeCol("c");
                }else if(this.umCol==256){
                    this.csvwriter.writeCol("e");
                }else{
                    if(tokens.length<=this.umCol){
                        this.csvwriter.writeCol("value");
                    }else{
                        this.csvwriter.writeCol(tokens[this.umCol]);
                    }
                }
                if(this.listCol==64){
                    this.csvwriter.writeCol("");
                }else{
                    if(tokens.length<=this.listCol){
                        this.csvwriter.writeCol("value");
                    }else{
                        this.csvwriter.writeCol(tokens[this.listCol]);
                    }
                }
                if(this.specNetCol==64){
                    this.csvwriter.writeCol("");
                }else{
                    this.csvwriter.writeCol(tokens[this.specNetCol]);
                }
                this.csvwriter.addNewLine();
            }
           
        }
    }
    
    
}
