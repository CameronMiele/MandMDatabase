package src;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CSVWriter {

    public final String file;
    public Writer writer;

    public CSVWriter(String file) throws IOException{
        this.file=file;
        this.writer= new FileWriter(this.file);
    }

    public void writeCol(String value) throws IOException{
        this.writer.write(value+",");
    }

    public void addNewLine() throws IOException{
        this.writer.write('\n');
    }
    
}
