package pac.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageObject {
    private String status ;
    private String name ;
    private String message ;
    private String date ;


    public MessageObject(String status, String name, String message) {
        this.status = status;
        this.name = name;
        this.message = message;
        this.date = getCurrentTimeUsingDate() ;
    }

    public static String getCurrentTimeUsingDate() {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        return formattedDate ;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        this.date = getCurrentTimeUsingDate();
    }

    public MessageObject() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
