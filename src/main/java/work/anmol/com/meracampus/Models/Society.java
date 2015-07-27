package work.anmol.com.meracampus.Models;

/**
 * Created by anmol on 7/21/2015.
 */
public class Society {
    public  String socName;
    public  String socMessage;

    public Society(String socName, String socMessage) {
        this.socName = socName;
        this.socMessage = socMessage;
    }
    public Society() {
        this.socName = "MUGD";
        this.socMessage = "event Connect Delhi soon";
    }

    public String getSocName() {
        return socName;
    }

    public void setSocName(String socName) {
        this.socName = socName;
    }

    public String getSocMessage() {
        return socMessage;
    }

    public void setSocMessage(String socMessage) {
        this.socMessage = socMessage;
    }
}
