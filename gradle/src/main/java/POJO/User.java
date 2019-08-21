package POJO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
public class User {

    private String name;
    private String email;
    private String[] blockers;
    private User buyingFor;

    public User(String n, String e, String[] b){
        this.name = n;
        this.email = e;
        this.blockers = b;
    }

    /*@Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof User) {
            if(((User) obj).getName().equals(this.getName()) &&
                    ((User) obj).getEmail().equals(this.getEmail()) &&
                    compareBlockers(((User) obj).getBlockers(), this.getBlockers()) &&
                    ((User) obj).getBuyingFor() == this.getBuyingFor()) {
                return true;
            }
        }
        return false;
    }

    public static boolean compareBlockers(String[] user1, String[] user2) {
        if (user1.length != user2.length) {
                return false;
        } else {
            for (int i=0; i<user1.length; i++) {
                if (!(user1[i].equals(user2[i]))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }*/
}
