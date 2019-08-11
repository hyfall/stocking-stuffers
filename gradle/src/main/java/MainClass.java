public class MainClass {

    public static void main(String [] args) {
        CreateUsers.start();
        DrawUsers.shuffleList();

        for (int i=0; i<CreateUsers.userList.size(); i++) {
            System.out.println("Name: " + CreateUsers.userList.get(i).getName());
            System.out.println("Buying For: " + CreateUsers.userList.get(i).getBuyingFor().getName());
        }

    }

}
