package work.anmol.com.meracampus.Models;

/**
 * Created by anmol on 7/21/2015.
 */
public class Chat {
    public String name,message,date;

    public Chat(String name, String message, String date) {
        this.name = name;
        this.message = message;
        this.date = date;
    }
    public Chat() {
        this.name = "Anmol";
        this.message = "hey";
        this.date = "19-2-15";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
