/*
 * Created by JFormDesigner on Tue Oct 05 19:55:06 IRST 2021
 */

package Main.Forms;

import Main.User;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Fateme
 */
public class SignUpForm extends JFrame {
    JFrame previousFrame;
    ArrayList<User> users;

    public SignUpForm(JFrame previousFrame, ArrayList<User> users) {
        this.previousFrame = previousFrame;
        this.users = users;
        initComponents();
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        this.dispose();
        previousFrame.setVisible(true);
    }

    private void btnSignUpActionPerformed(ActionEvent e) {
        for (User u : users) {
            if (u.getUsername().equals(textFieldUsername.getText())) {
                JOptionPane.showMessageDialog(this, "This username is already taken!");
                return;
            }
        }
        users.add(new User(textFieldUsername.getText(), textFieldPassword.getText()));
        JOptionPane.showMessageDialog(this,"Account created. Please login to your account!");

        try {
            User.UpdateFile(users);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        this.dispose();
        previousFrame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lblIMDb = new JLabel();
        lblUsername = new JLabel();
        lblPassword = new JLabel();
        textFieldPassword = new JTextField();
        textFieldUsername = new JTextField();
        btnCancel = new JButton();
        btnSignUp = new JButton();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();

        //---- lblIMDb ----
        lblIMDb.setText("Sign Up");
        lblIMDb.setForeground(Color.orange);
        lblIMDb.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
        lblIMDb.setHorizontalAlignment(SwingConstants.CENTER);

        //---- lblUsername ----
        lblUsername.setText("Username :");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- lblPassword ----
        lblPassword.setText("Password :");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- textFieldPassword ----
        textFieldPassword.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- textFieldUsername ----
        textFieldUsername.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- btnCancel ----
        btnCancel.setText("Cancel");
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.addActionListener(e -> btnCancelActionPerformed(e));

        //---- btnSignUp ----
        btnSignUp.setText("Sign Up");
        btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSignUp.addActionListener(e -> btnSignUpActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(36, 36, 36)
                                    .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(lblUsername)
                                        .addComponent(lblPassword))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(textFieldUsername, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldPassword, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(lblIMDb, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(37, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(lblIMDb)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblUsername)
                        .addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPassword)
                        .addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lblIMDb;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField textFieldPassword;
    private JTextField textFieldUsername;
    private JButton btnCancel;
    private JButton btnSignUp;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
