package POJO;

public class User {

    private String name;
    private String email;
    private String blockers;
    private User buyingFor;


    public User(String n, String e) {
        this.name = n;
        this.email = e;
    }

    public User(String n, String e, String b){
        this.name = n;
        this.email = e;
        this.blockers = b;
    }
}
