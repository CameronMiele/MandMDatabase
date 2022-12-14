package src;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CSVWriter {

    public final String file;
    public Writer writer;

    public CSVWriter(String file) throws IOException{
        this.file=file;
        this.writer= new FileWriter(this.file,true);
        this.writer.flush();
    }

    public void writeCol(String value) throws IOException{
        this.writer.write(value+",");
        this.writer.flush();
    }
    public void writeCTN(String value) throws IOException{
        this.writer.write("\" "+value+"\""+",");
        this.writer.flush();
    }
    public void writeMAGUPC(String value) throws IOException{
        this.writer.write("722170"+value+",");
        this.writer.flush();
    }
    public void writeKleinUPC(String value) throws IOException{
        this.writer.write("0-92644"+value+",");
        this.writer.flush();
    }

    public void addNewLine() throws IOException{
        this.writer.write('\n');
        this.writer.flush();
    }
    
}
