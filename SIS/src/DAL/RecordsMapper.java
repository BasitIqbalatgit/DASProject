/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import common.UserDTO;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Message;
import model.MessageType;
import model.Response;

/**
 *
 * @author CUI
 */
public class RecordsMapper {
    public RecordsMapper(){}

    
//     ArrayList<UserDTO> getSlots(ResultSet rs) {
//        ArrayList<SlotsDTO> emplist = new ArrayList<>();
//        try{
//        while (rs.next())
//            {
//                SlotsDTO objSlots=new SlotsDTO(); 
//                
//                objSlots.slotsName=rs.getString(1);
//                objSlots.startTime=rs.getString(2);
//                objSlots.endTime=(rs.getString(3));
//                objSlots.duration=(rs.getString(4));   
//                emplist.add(objSlots);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return emplist;
//    }
    
    
    
     void getUser(ResultSet rs, Response objResponse, UserDTO user) {
    
    try {
        if (rs.next()) {
            user.setUsername(rs.getString(1));
            user.setEmail(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setRole(rs.getString(4));
        }
    } catch (SQLException e) {
        objResponse.messagesList.add(new Message("unable to MAP "+e.getMessage(),MessageType.Error));
        
        e.printStackTrace();
    }
}
    
}

