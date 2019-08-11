package POJO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof User) {
            if(((User) obj).getName().equals(this.getName()) &&
                    ((User) obj).getEmail().equals(this.getEmail()) &&
                    ((User) obj).getBlockers() == this.getBlockers() &&
                    ((User) obj).getBuyingFor() == this.getBuyingFor()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}
