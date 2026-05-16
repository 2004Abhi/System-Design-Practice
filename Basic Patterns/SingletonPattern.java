import java.util.*;


class DatabaseConnection{
  public static DatabaseConnection connection;
  public static DatabaseConnection getConnection(){
    if(connection==null){
        connection=new DatabaseConnection();
    }
    return connection;
  }
  private DatabaseConnection(){}
}



public class SingletonPattern {
    
    public  void main(String[] args) {
      // DatabaseConnection dbConnection1=new DatabaseConnection();
      DatabaseConnection dbConnection1=DatabaseConnection.getConnection();
      //Try to get another connection
      DatabaseConnection dbConnection2=DatabaseConnection.getConnection();
      
      System.out.println(dbConnection1 == dbConnection2);
    }
}