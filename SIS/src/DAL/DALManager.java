package DAL;

import common.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
       // objConnection = new MySQLConnection("jdbc:mysql://localhost:3306/mydb", "root", "BasitIqbal@050");
//=======
        objConnection = new MySQLConnection("jdbc:mysql://localhost:3306/mydb", "root", "Admin123$");
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
    
//    public void verifyUser(UserDTO objUser, Response objResponse){
//       System.out.println("hello i am in getUserResult in DAL Mangaer");
//         Connection dbConnection = objConnection.getConnection();
//         String query="SELECT * FROM user WHERE email= ? AND password= ?";
//         ResultSet result=objReader.getUserResultFromQuery(query, dbConnection,objUser, objResponse);
//         objMapper.getUser(result,objResponse);
//        
//    }
    public void verifyUser(UserDTO user, Response responseObj) {
        Connection connection = objConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String query = "SELECT * FROM user WHERE email = ? AND password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user.setRole(resultSet.getString(4));
                responseObj.messagesList.add(new Message("Successfully Login", MessageType.Information));
            } else {
                responseObj.messagesList.add(new Message("Invalid credentials check your username and password", MessageType.Error));
            }
        } catch (Exception ex) {
            responseObj.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));

        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (Exception ex) {
                responseObj.messagesList.add(new Message(ex.getMessage(), MessageType.Exception));
            }
        }
    }
}
