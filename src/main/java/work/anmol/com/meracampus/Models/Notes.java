package work.anmol.com.meracampus.Models;

/**
 * Created by anmol on 7/21/2015.
 */
public class Notes {

        String subjectName;
        String topic;
        String submittedBy;
        String description;

    public Notes(String topic,String description) {
        this.topic = topic;
        this.description = description;
    }

    public Notes(){
            this.subjectName="android";
            this.topic="listview";
            this.description="padh le sab";
            this.submittedBy="rachit sir";
        }

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getSubmittedBy() {
            return submittedBy;
        }

        public void setSubmittedBy(String submittedBy) {
            this.submittedBy = submittedBy;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


