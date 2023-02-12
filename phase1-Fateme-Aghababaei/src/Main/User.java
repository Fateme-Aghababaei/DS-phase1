package Main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    public ArrayList<Title> voted;

    public User(String username, String password) {
        this. username = username;
        this.password = password;
        voted = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String votedToString() {
        String votedStr = "";
        for (int i = 0; i < voted.size(); i++) {
            if (i == 0) {
                votedStr += voted.get(i).getTitleID();
            }
            else {
                votedStr += "," + voted.get(i).getTitleID();
            }
        }
        return votedStr;
    }

    public static void UpdateFile(ArrayList<User> users) throws IOException {
        FileWriter fileWriter = new FileWriter("Users.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (User u : users) {
            bufferedWriter.write(u.getUsername() + "\t" + u.getPassword() + "\t" + u.votedToString() + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }
}
