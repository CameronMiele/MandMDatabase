package src;


import java.io.BufferedReader;
import java.io.IOException;

public class CSVParser {

    public final BufferedReader reader;
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

    public CSVParser(CSVWriter csvwriter, BufferedReader reader, String mfg, int upcCol, int catNoCol, int descCol, int ctnQtyCol, int listCol, int netCol, int specNetCol, int umCol, int skip){
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
        this.reader=reader;
    }

    
    public void readCSV() throws IOException{
        String nextLine=reader.readLine();
        for(int i=0;i<this.skip;i++){
            nextLine=reader.readLine();

        }
        while(nextLine!=null){
            //(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)
            // -1
            nextLine=reader.readLine();
            if(nextLine==null){
                break;
            }
            String[] tokens= nextLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)",-1);
                   
            if(tokens.length<=4){
                continue;
            }
            else{
                this.csvwriter.writeCol(this.mfg);
                parseUPC(tokens);
                parseCatNoCol(tokens);
                parseDescCol(tokens);
                parseCtnQtyCol(tokens);
                parseUmCol(tokens);
                parseListCol(tokens);
                parseNetCol(tokens);
                parseSpecNetCol(tokens);
                this.csvwriter.addNewLine();
            }
        }
        
    }
    public void parseUPC(String[] tokens) throws IOException{
        if(this.upcCol==64){
            this.csvwriter.writeCol("");
        }else{
            if(tokens.length<=this.upcCol){
                this.csvwriter.writeCol("");
            }else{
                if(this.mfg=="Mag-Bit"){
                    this.csvwriter.writeMAGUPC(tokens[this.upcCol]);
                }
                if(this.mfg=="Klein"){
                    this.csvwriter.writeKleinUPC(tokens[this.upcCol]);
                }
                else{
                    this.csvwriter.writeCol(tokens[this.upcCol]);
                }
            }
        }
    }
    public void parseCatNoCol(String[] tokens) throws IOException{
        if(this.catNoCol==64){
            this.csvwriter.writeCol("");
        }else{
            this.csvwriter.writeCol(tokens[this.catNoCol]);
        }
    }
    public void parseDescCol(String[] tokens) throws IOException{
        if(this.descCol==64){
            this.csvwriter.writeCol("");
        }else{
            try{
                this.csvwriter.writeCol(tokens[this.descCol]);
            }catch (ArrayIndexOutOfBoundsException e){

            }
        }
    }
    public void parseCtnQtyCol(String[] tokens) throws IOException{
        if(this.ctnQtyCol==64){
            this.csvwriter.writeCol("");
        }else{
            if(tokens.length<=this.ctnQtyCol){
                this.csvwriter.writeCol("");
            }else{
                this.csvwriter.writeCTN(tokens[this.ctnQtyCol]);
            }
        }
    }
    public void parseUmCol(String[] tokens) throws IOException{
        if(this.umCol==64){
            this.csvwriter.writeCol("");
        }else if(this.umCol==128){
            this.csvwriter.writeCol("c");
        }else if(this.umCol==256){
            this.csvwriter.writeCol("e");
        }else{
            //try{
                this.csvwriter.writeCol(tokens[this.umCol]);
            //}catch (ArrayIndexOutOfBoundsException e){}
        }
    }
    public void parseListCol(String[] tokens) throws IOException{
        if(this.listCol==64){
            this.csvwriter.writeCol("");
        }else{
            if(tokens.length<=this.listCol){
                this.csvwriter.writeCol("");
            }else{
                this.csvwriter.writeCol(tokens[this.listCol]);
            }
        }
    }
    public void parseNetCol(String[] tokens) throws IOException{
        if(this.netCol==64){
            this.csvwriter.writeCol("");
        }else{
            this.csvwriter.writeCol(tokens[this.netCol]);
        }
    }
    public void parseSpecNetCol(String[] tokens) throws IOException{
        if(this.specNetCol==64){
            this.csvwriter.writeCol("");
        }else{
            this.csvwriter.writeCol(tokens[this.specNetCol]);
        }
    }
    
    
}
