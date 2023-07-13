package DAL;

import common.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Message;
import model.MessageType;
import model.Response;

public class DALManager {

    IConnection objConnection;
    RecordsAdder objAdder;
    RecordsMapper objMapper;
    DBReader objReader;

    public DALManager() {
objConnection = new MySQLConnection("jdbc:mysql://localhost:3306/mydb", "root", "BasitIqbal@050");
//=======
//        objConnection = new MySQLConnection("jdbc:mysql://localhost:3306/mydb", "root", "Admin123$");
//>>>>>>> Stashed changes
        objAdder = new RecordsAdder();
        objMapper = new RecordsMapper();
        objReader=new DBReader();
        
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
    
//<<<<<<< Updated upstream
//    public void verifyUser(UserDTO objUser, Response objResponse){
//       System.out.println("hello i am in getUserResult in DAL Mangaer");
//         Connection dbConnection = objConnection.getConnection();
//         String query="SELECT * FROM user WHERE email= ? AND password= ?";
//         ResultSet result=objReader.getUserResultFromQuery(query, dbConnection,objUser, objResponse);
//         objMapper.getUser(result,objResponse);
//        
//    }
    public void verifyUser(UserDTO user, Response objResponse) {
        Connection connection = objConnection.getConnection();
        String query = "SELECT * FROM user WHERE email = ? AND password = ?";
        
        ResultSet resultSet = null;
        try {
            
            resultSet=objReader.getUserResultFromQuery(query, connection,user, objResponse);
            objMapper.getUser(resultSet,objResponse,user);
           
        } catch (Exception ex) {
            objResponse.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
//                
                if (connection != null) {
                    connection.close();
                }

            } catch (Exception ex) {
                objResponse.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));
            }
        }
    }
}
