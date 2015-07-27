package work.anmol.com.meracampus.Models;

/**
 * Created by anmol on 7/21/2015.
 */
public class Message {
    public  String message;
    boolean recived;

    public Message(String message, boolean recived) {
        this.message = message;
        this.recived = recived;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRecived() {
        return recived;
    }

    public void setRecived(boolean recived) {
        this.recived = recived;
    }
}
