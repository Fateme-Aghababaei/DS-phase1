/*
 * Created by JFormDesigner on Sun Oct 03 10:45:30 IRST 2021
 */

package Main.Forms;

import Main.User;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * @author Fateme
 */
public class LoginForm extends JFrame {
    MainForm previousFrame;
    ArrayList<User> users;

    public LoginForm(MainForm previousFrame, ArrayList<User> users) {
        this.previousFrame = previousFrame;
        this.users = users;
        initComponents();
    }

    private void btnCancelActionPerformed(ActionEvent e) {
        this.dispose();
        previousFrame.setVisible(true);
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        if (textFieldUsername.getText().trim().isEmpty() || textFieldPassword.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "username and password cannot be empty!");
            return;
        }
        for (User user : users) {
            if (textFieldUsername.getText().trim().equals(user.getUsername()) && textFieldPassword.getText().trim().equals(user.getPassword())) {
                previousFrame.loggedInUser = user;
                this.dispose();
                previousFrame.setVisible(true);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "username or password is incorrect!");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lblUsername = new JLabel();
        lblPassword = new JLabel();
        textFieldUsername = new JTextField();
        textFieldPassword = new JTextField();
        btnCancel = new JButton();
        btnLogin = new JButton();
        lblIMDb = new JLabel();

        //======== this ========
        setTitle("Login");
        setIconImage(new ImageIcon("E:\\Uni\\Data Structures\\Projects\\Phase 1\\phase1-Fateme-Aghababaei\\IMDbIcon.jpg").getImage());
        setResizable(false);
        Container contentPane = getContentPane();

        //---- lblUsername ----
        lblUsername.setText("Username :");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- lblPassword ----
        lblPassword.setText("Password :");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- textFieldUsername ----
        textFieldUsername.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- textFieldPassword ----
        textFieldPassword.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- btnCancel ----
        btnCancel.setText("Cancel");
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCancel.addActionListener(e -> btnCancelActionPerformed(e));

        //---- btnLogin ----
        btnLogin.setText("Login");
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnLogin.addActionListener(e -> btnLoginActionPerformed(e));

        //---- lblIMDb ----
        lblIMDb.setText("Login");
        lblIMDb.setForeground(Color.orange);
        lblIMDb.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
        lblIMDb.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(lblUsername)
                                .addComponent(lblPassword))
                            .addGap(63, 63, 63)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(131, 131, 131)
                            .addComponent(lblIMDb, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(82, 82, 82)
                            .addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(24, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
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
                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JButton btnCancel;
    private JButton btnLogin;
    private JLabel lblIMDb;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
