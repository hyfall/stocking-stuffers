import POJO.User;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

public class EmailUsers {

    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 465;
    private static final boolean SSL_FLAG = true;
    private static String sendUsername = "unknown";
    private static String sendPassword = "unknown";

    public static void setUp() {
        String fileName = "gradle/src/main/resources/secrets.properties";
        Properties props = new Properties();

        try {
            FileInputStream input = new FileInputStream(fileName);
            props.load(input);
            sendUsername = props.getProperty("email");
            sendPassword = props.getProperty("password");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void cycleList(ArrayList<User> users) {
        for (int i=0; i<users.size(); i++) {
            sendEmail(users.get(i));
        }
    }

    public static void sendEmail(User sendingTo) {

        String toAddress =  sendingTo.getEmail();
        String subject = sendingTo.getName() + "'s stocking person";
        String message = "Hello from the Stocking Stuffer app. This is the automatically generated person that " +
                "you're buying for this year.\n Your Name: "+ sendingTo.getName() + "\n Your stocking person: " +
                sendingTo.getBuyingFor().getName();

        try {
            Email email = new SimpleEmail();
            email.setHostName(HOST);
            email.setSmtpPort(PORT);
            email.setAuthenticator(new DefaultAuthenticator(sendUsername, sendPassword));
            email.setSSLOnConnect(SSL_FLAG);
            email.setFrom(sendUsername);
            email.setSubject(subject);
            email.setMsg(message);
            email.addTo(toAddress);
            email.send();
        }catch(Exception ex){
            System.out.println("Unable to send email");
            System.out.println(ex);
        }
    }

}
