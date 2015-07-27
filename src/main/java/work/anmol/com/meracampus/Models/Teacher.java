package work.anmol.com.meracampus.Models;

/**
 * Created by anmol on 7/21/2015.
 */
public class Teacher {
    public  String name;
    public Teacher(){
        name="Mrs Madam";
    }

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
