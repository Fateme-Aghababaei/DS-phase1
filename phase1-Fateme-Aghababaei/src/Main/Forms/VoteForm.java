/*
 * Created by JFormDesigner on Mon Oct 04 13:37:10 IRST 2021
 */

package Main.Forms;

import Main.Title;
import Main.User;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Fateme
 */
public class VoteForm extends JFrame {
    JFrame previousFrame;
    User user;
    ArrayList<Title> titles;
    ArrayList<User> users;

    public VoteForm(JFrame previousFrame, User user, ArrayList<Title> titles, ArrayList<User> users) {
        this.previousFrame = previousFrame;
        this.user = user;
        this.titles = titles;
        this.users = users;
        initComponents();

        for (Title t : this.titles) {
            if (user.voted.contains(t))
                continue;
            comboTitle.addItem(t.getTitle());
        }

        if (comboTitle.getItemCount() > 0)
            comboTitle.setSelectedIndex(0);
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        this.dispose();
        previousFrame.setVisible(true);
    }

    private void btnVoteActionPerformed(ActionEvent e) {
        if (comboTitle.getSelectedItem() == null) return;
        for (Title t : this.titles) {
            if (comboTitle.getSelectedItem().toString().equals(t.getTitle())) {
                int rate = Integer.parseInt(spinner1.getValue().toString());
                double currentRate = t.getAverageRating();
                int num = t.getNumVotes();
                double newRate = ((currentRate * num) + rate) / (num + 1);
                DecimalFormat d = new DecimalFormat("#.#");
                newRate = Double.parseDouble(d.format(newRate));
                t.setAverageRating(newRate);
                t.setNumVotes(num + 1);

                user.voted.add(t);
                comboTitle.removeItemAt(comboTitle.getSelectedIndex());

                try {
                    saveToFile();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                try {
                    User.UpdateFile(users);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                if (comboTitle.getItemCount() > 0)
                    comboTitle.setSelectedIndex(0);

                break;
            }
        }
    }

    private void saveToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("title.ratings.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("tconst\taverageRating\tnumVotes");
        for (Title t : titles) {
            bufferedWriter.newLine();
            bufferedWriter.write(String.format("%s\t%.1f\t%d", t.getTitleID(), t.getAverageRating(), t.getNumVotes()));
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lblIMDb = new JLabel();
        lblTitle = new JLabel();
        lblRating = new JLabel();
        comboTitle = new JComboBox();
        spinner1 = new JSpinner();
        btnCancel = new JButton();
        btnVote = new JButton();

        //======== this ========
        setTitle("Vote");
        setIconImage(new ImageIcon("E:\\Uni\\Data Structures\\Projects\\Phase 1\\phase1-Fateme-Aghababaei\\IMDbIcon.jpg").getImage());
        setResizable(false);
        Container contentPane = getContentPane();

        //---- lblIMDb ----
        lblIMDb.setText("Vote");
        lblIMDb.setForeground(Color.orange);
        lblIMDb.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
        lblIMDb.setHorizontalAlignment(SwingConstants.CENTER);

        //---- lblTitle ----
        lblTitle.setText("Title :");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- lblRating ----
        lblRating.setText("Rating :");
        lblRating.setHorizontalAlignment(SwingConstants.CENTER);
        lblRating.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- comboTitle ----
        comboTitle.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- spinner1 ----
        spinner1.setFont(new Font("Tahoma", Font.BOLD, 14));
        spinner1.setModel(new SpinnerNumberModel(1, 1, 10, 1));

        //---- btnCancel ----
        btnCancel.setText("Cancel");
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.addActionListener(e -> btnCancelActionPerformed(e));

        //---- btnVote ----
        btnVote.setText("Vote");
        btnVote.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnVote.addActionListener(e -> btnVoteActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(196, 196, 196)
                            .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(btnVote, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(comboTitle, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)))
                    .addGap(15, 15, 15)
                    .addComponent(lblRating, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblIMDb, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                    .addGap(263, 263, 263))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(lblIMDb)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRating, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinner1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboTitle, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnVote, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(28, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lblIMDb;
    private JLabel lblTitle;
    private JLabel lblRating;
    private JComboBox comboTitle;
    private JSpinner spinner1;
    private JButton btnCancel;
    private JButton btnVote;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
