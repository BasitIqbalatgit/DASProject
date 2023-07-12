package DAL;

import common.UserDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import model.Message;
import model.MessageType;
import model.Response;

public class DALManager {

    IConnection objConnection;
    RecordsAdder objAdder;
    RecordsMapper objMapper;
    DBReader objReader;

    public DALManager() {
//<<<<<<< Updated upstream
        objConnection = new MySQLConnection("jdbc:mysql://localhost:3306/mydb", "root", "BasitIqbal@050");
//=======
//        objConnection = new MySQLConnection("jdbc:mysql://localhost:3306/mydb", "root", "Admin123$");
//>>>>>>> Stashed changes
        objAdder = new RecordsAdder();
    }

    public void saveUser(UserDTO objUser, Response objResponse) {
        try {
            Connection dbConnection = objConnection.getConnection();
            objAdder.saveUser(objUser, objResponse, dbConnection);
        } catch (Exception e) {
            objResponse.messagesList.add(new Message("Ooops! Failed to create User, Please contact support that there an issue while saving new user.", MessageType.Error));
            objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n" + e.getStackTrace(), MessageType.Exception));
        }
    }
    
    public void verifyUser(UserDTO objUser, Response objResponse){
       System.out.println("hello i am in getUserResult in DAL Mangaer");
         Connection dbConnection = objConnection.getConnection();
         String query="SELECT * FROM user WHERE email= ? and password= ?";
         ResultSet result=objReader.getUserResultFromQuery(query, dbConnection,objUser, objResponse);
         objMapper.getUser(result,objResponse);
        
    }
}
