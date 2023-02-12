package Main;

import Main.Forms.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class IMDb_Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Title> titles = new ArrayList<>();

        ArrayList<User> users = new ArrayList<>();

//        Reading Titles From File
        FileReader akasReader = new FileReader("title.akas.txt");
        BufferedReader akasBr = new BufferedReader(akasReader);
        akasBr.readLine();

        FileReader rateReader = new FileReader("title.ratings.txt");
        BufferedReader rateBr = new BufferedReader(rateReader);
        rateBr.readLine();

        try {
            while (true) {
                String[] s1 = akasBr.readLine().split("\t");
                ArrayList<String> types = new ArrayList<>(Arrays.asList(s1[5].split(" ")));
                boolean isOriginalTitle = s1[7].equals("1");

                String[] s2 = rateBr.readLine().split("\t");

                Title title = new Title(s1[0], Integer.parseInt(s1[1]), s1[2], s1[3], s1[4], types, s1[6], isOriginalTitle, Double.parseDouble(s2[1]), Integer.parseInt(s2[2]));
                titles.add(title);
            }
        } catch (Exception ignored) {
        }

        akasBr.close();
        akasReader.close();
        rateBr.close();
        rateReader.close();

//        Reading Users From File
        FileReader userReader = new FileReader("Users.txt");
        BufferedReader userBr = new BufferedReader(userReader);

        try {
            while (true) {
                String[] u1 = userBr.readLine().split("\t");
                User newUser = new User(u1[0], u1[1]);
                if (u1.length == 3) {
                    String[] votes = u1[2].split(",");
                    for (String vote : votes) {
                        for (Title t : titles) {
                            if (t.getTitleID().equals(vote)) {
                                newUser.voted.add(t);
                                break;
                            }
                        }
                    }
                }
                users.add(newUser);
            }
        } catch (Exception ignored) {}

        userReader.close();
        userBr.close();


//        Forms
        SwingUtilities.invokeLater(() -> {
            MainForm mainForm = new MainForm(titles, users);
            mainForm.setVisible(true);
        });
    }
}
