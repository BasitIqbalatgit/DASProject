
package model;

import linklist.node.Node;
import linklist.node.LinkedList;

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
