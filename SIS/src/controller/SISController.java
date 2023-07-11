/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Message;
import model.MessageType;
import model.Response;
import model.UserDTO;

/**
 *
 * @author fawad
 */
public class SISController {
    public void verifyUser(UserDTO user,Response res){
         if (user.getUsername().equals("fawad")&&user.getPassword().equals("root")) {
             user.setRole("faculty");
         }else if(user.getUsername().equals("basit")&&user.getPassword().equals("root")){
             user.setRole("faculty");
         }else{
             res.messagesList.addAtEnd(new Message("Invalid credentials.", MessageType.Error));
         }
    }
}
