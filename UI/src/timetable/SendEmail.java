package timetable;

import java.util.*;
import javafx.scene.control.Alert;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class SendEmail{
    static DbDriver mail = new DbDriver();
    static boolean success = false;

    /**
     * 
     */
    public static void sendTT(){

        for(int i = 0; i<mail.getEmail().size();i++){
            try{

                String host ="smtp.gmail.com" ;
                String pass = "kaka10139";
                String to = mail.getEmail().get(i);
                String from = "cbrianbet@gmail.com";
                String subject = "New Timetable";
                String messageText = new AlgoDriver().getTimetable(new DbDriver().getIeoDepartment().get(i), 2);
                boolean sessionDebug = false;

                Properties props = System.getProperties();

                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.required", "true");

                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                Session mailSession = Session.getDefaultInstance(props, null);
                mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject); msg.setSentDate(new Date());
                msg.setText(messageText);

                Transport transport=mailSession.getTransport("smtp");
                transport.connect(host, from, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();

                success = true;
            }catch(Exception ex)
            {
                success  = false;

            }
        }
        if(success){
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("Success");
            al. setContentText("TimeTable sent Successfully");
            al.show();
        }else{
            Alert net = new Alert(Alert.AlertType.WARNING);
            net.setTitle("Warning!");
            net.setHeaderText("Internet Error!");
            net.setContentText("Please Check your internet Connection and Try again");
            net.show();
        }

    }
    public static void reqRequirements(){
        for(int i = 0; i<mail.getEmail().size();i++){
            try{
                String host ="smtp.gmail.com" ;
                String pass = "kaka10139";
                String to = mail.getEmail().get(i);
                String from = "cbrianbet@gmail.com";
                String subject = "Requesting for requirments for TimeTable";
                String messageText = "Hi!\nWe would like to request that you fill in"
                        + " the required fields from http://localhost/uts_web/ ."
                        + "These requirements are crusial to the Timetable making process."
                        + " Please make these available within the next week.";
                boolean sessionDebug = false;

                Properties props = System.getProperties();

                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", host);
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.required", "true");

                java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                Session mailSession = Session.getDefaultInstance(props, null);
                mailSession.setDebug(sessionDebug);
                Message msg = new MimeMessage(mailSession);
                msg.setFrom(new InternetAddress(from));
                InternetAddress[] address = {new InternetAddress(to)};
                msg.setRecipients(Message.RecipientType.TO, address);
                msg.setSubject(subject); msg.setSentDate(new Date());
                msg.setText(messageText);

                Transport transport=mailSession.getTransport("smtp");
                transport.connect(host, from, pass);
                transport.sendMessage(msg, msg.getAllRecipients());
                transport.close();

                success = true;
            }catch(Exception ex)
            {
                success = false;
            }
        }
        if(success){
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("Success");
            al. setContentText("Message sent Successfully");
            al.showAndWait();
        }else{
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Warning!");
            al. setContentText("Check Your Internet Connection And try again");
            al.showAndWait();
        }

    }
}