import java.util.*;

interface DataSource{
  public void writeData();
  public void readData();
}

class FileDataSource implements DataSource{
  @Override
  public void writeData(){
    System.out.println("Data is written to file");
  }
  
  @Override
  public void readData(){
    System.out.println("Data is read from file");
  }
}

class DataSourceDecorator implements DataSource{
  private DataSource wrappee;
  public DataSourceDecorator(DataSource d){
    this.wrappee=d;
  }
  
  @Override
  public void writeData(){
    wrappee.writeData();
  }
  
  @Override
  public void readData(){
    wrappee.readData();
  }
}

class DataSourceEncryptionDecorator extends DataSourceDecorator{
  public DataSourceEncryptionDecorator(DataSource d){
    super(d);
  }
  
  private void encryptionHelper(){
    System.out.println("Data is encrypted");
  }
  
  @Override
  public void writeData(){
    encryptionHelper();
  }
  
}

class DataSourceCompressionDecorator extends DataSourceDecorator{
  public DataSourceCompressionDecorator(DataSource d){
    super(d);
  }
  
  private void compressionHelper(){
    System.out.println("Data is compressed");
  }
  
  @Override
  public void writeData(){
    compressionHelper();
  }
}

public class DecoratorPattern {
    
    public  void main(String[] args) {
      // // Basic FileDataSource 
      // DataSource source1=new FileDataSource();
      // source1.writeData();
      // source1.readData();
      
      // // FIleDataSource + Encryption
      
      // DataSource source2=new FileDataSource();
      // source2=new DataSourceEncryptionDecorator(source2);
      // source2.writeData();
      // source2.readData();
      
      // FIleDataSource + Compression + Encryption
      
      DataSource source3=new FileDataSource();
      source3=new DataSourceCompressionDecorator(source3);
      //source3=new DataSourceEncryptionDecorator(source3);
      source3.writeData();
      source3.readData();
      
    }
}