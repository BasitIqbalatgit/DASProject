
package model;

import dsa.linklist.Node;
import dsa.linklist.LinkedList;

/**
 *
 * @author fawad
 */
public class Response {
    public LinkedList<Message> messagesList;
    public Response(){ 
        messagesList = new LinkedList<>();
    }
    

    

    public boolean isSuccessfull() {
        return !messagesList.hasError();
    }
}
