package DAL;

import common.UserDTO;
import java.sql.Connection;
import model.Message;
import model.MessageType;
import model.Response;

public class DALManager {

    IConnection objConnection;
    RecordsAdder objAdder;

    public DALManager() {
//<<<<<<< Updated upstream
//        objConnection = new MySQLConnection("jdbc:mysql://localhost:3306/mydb", "root", "BasitIqbal@050");
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
            objResponse.messagesList.addAtEnd(new Message("Ooops! Failed to create Slots, Please contact support that there an issue while saving new Slots.", MessageType.Error));
            objResponse.messagesList.addAtEnd(new Message(e.getMessage() + "\n Stack Track:\n" + e.getStackTrace(), MessageType.Exception));
        }
    }
}
