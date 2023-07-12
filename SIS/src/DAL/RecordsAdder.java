package DAL;

import common.UserDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Message;
import model.MessageType;
import model.Response;

public class RecordsAdder {


    public void saveUser(UserDTO objUser, Response objResponse, Connection dbConnection) {
        try {
            String query = "INSERT INTO user (username, email, password, role) VALUES (?, ?, ?,?)";
            PreparedStatement p = dbConnection.prepareStatement(query);
           
            p.setString(1, objUser.getUsername());
            p.setString(2, objUser.getEmail());
            p.setString(3, objUser.getPassword());            
            p.setString(4, objUser.getRole());
            int rowsInserted = p.executeUpdate();
            if (rowsInserted > 0) {
                objResponse.messagesList.add(new Message("User Saved successfully.", MessageType.Information));
            } else {
                objResponse.messagesList.add(new Message("Failed to add User.", MessageType.Error));
            }
        } catch (SQLException e) {
            System.out.println("Error while saving slot.");
            objResponse.messagesList.add(new Message("Failed to create user. Please contact support for assistance.", MessageType.Error));
            objResponse.messagesList.add(new Message(e.getMessage(), MessageType.Exception));
        }
    }
}
