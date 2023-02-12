/*
 * Created by JFormDesigner on Fri Oct 01 12:06:48 IRST 2021
 */

package Main.Forms;


import java.awt.event.*;
import Main.Title;
import Main.User;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.*;

/**
 * @author Fateme
 */
public class MainForm extends JFrame {
    ArrayList<User> users;
    public User loggedInUser;
    ArrayList<Title> titles;

    public MainForm(ArrayList<Title> titles, ArrayList<User> users) {
        this.users = users;
        this.loggedInUser = null;
        this.titles = titles;
        initComponents();
        FillTable();

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowActivated(WindowEvent e) {
                super.windowActivated(e);
                CheckUserLogin();
                FillTable();
            }
        });
    }

    private void CheckUserLogin() {
        if (loggedInUser != null) {
            lblUser.setText(String.format("<html>Username:<br>%s</html>", loggedInUser.getUsername()));
            btnLogin.setText("Logout");
            btnVote.setEnabled(true);
            btnSignUp.setEnabled(false);
        } else {
            lblUser.setText("");
            btnLogin.setText("Login");
            btnVote.setEnabled(false);
            btnSignUp.setEnabled(true);
        }
    }

    private void FillTable() {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        for (Title t : this.titles) {
            model.addRow(new Object[] {
                    t.getTitleID(),
                    t.getOrdering(),
                    t.getTitle(),
                    t.getRegion(),
                    t.getLanguage(),
                    t.getTypes(),
                    t.getAttributes(),
                    t.isOriginalTitle(),
                    t.getAverageRating(),
                    t.getNumVotes()
            });
        }
        for (int i = 0; i < tbl.getColumnCount(); i++) {
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tbl.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    private void btnLoginActionPerformed(ActionEvent e) {
        if (btnLogin.getText().equals("Login")) {
            LoginForm loginForm = new LoginForm(this, users);
            loginForm.setVisible(true);
            this.setVisible(false);
        }
        else if (btnLogin.getText().equals("Logout")) {
            if (JOptionPane.showConfirmDialog(this, "Do you want to log out?", "Logout", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                loggedInUser = null;
                lblUser.setText("");
                btnLogin.setText("Login");
                btnVote.setEnabled(false);
            }
        }

    }

    private void btnVoteActionPerformed(ActionEvent e) {
        VoteForm voteForm = new VoteForm(this, loggedInUser, titles, users);
        voteForm.setVisible(true);
        this.setVisible(false);
    }

    private void btnTop10ActionPerformed(ActionEvent e) {
        Top10Form top10Form = new Top10Form(this, titles);
        top10Form.setVisible(true);
        this.setVisible(false);
    }

    private void btnSignUpActionPerformed(ActionEvent e) {
        SignUpForm signUpForm = new SignUpForm(this, users);
        signUpForm.setVisible(true);
        this.setVisible(false);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        tbl = new JTable();
        lblIMDb = new JLabel();
        btnTop10 = new JButton();
        btnVote = new JButton();
        btnLogin = new JButton();
        lblUser = new JLabel();
        btnSignUp = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("IMDb");
        setIconImage(new ImageIcon("E:\\Uni\\Data Structures\\Projects\\Phase 1\\phase1-Fateme-Aghababaei\\IMDbIcon.jpg").getImage());
        setFont(new Font("Andalus", Font.BOLD, 14));
        setResizable(false);
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tbl ----
            tbl.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "ID", "Ordering", "Title", "Region", "Language", "Types", "Attributes", "Is Original Title", "Rating", "Num Votes"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, Integer.class, String.class, String.class, String.class, String.class, String.class, Boolean.class, Double.class, Integer.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, true, true, true, true, true, true, true, true, true
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = tbl.getColumnModel();
                cm.getColumn(1).setMinWidth(55);
                cm.getColumn(1).setMaxWidth(55);
                cm.getColumn(1).setPreferredWidth(55);
                cm.getColumn(2).setMinWidth(400);
                cm.getColumn(2).setMaxWidth(400);
                cm.getColumn(2).setPreferredWidth(400);
                cm.getColumn(3).setMinWidth(55);
                cm.getColumn(3).setMaxWidth(55);
                cm.getColumn(3).setPreferredWidth(55);
                cm.getColumn(4).setMinWidth(60);
                cm.getColumn(4).setMaxWidth(60);
                cm.getColumn(4).setPreferredWidth(60);
                cm.getColumn(7).setMinWidth(60);
                cm.getColumn(7).setMaxWidth(60);
                cm.getColumn(7).setPreferredWidth(60);
                cm.getColumn(8).setMinWidth(55);
                cm.getColumn(8).setMaxWidth(55);
                cm.getColumn(8).setPreferredWidth(55);
            }
            tbl.setFont(new Font("Tahoma", Font.BOLD, 14));
            tbl.setRowHeight(50);
            scrollPane1.setViewportView(tbl);
        }

        //---- lblIMDb ----
        lblIMDb.setText("IMDb");
        lblIMDb.setForeground(Color.orange);
        lblIMDb.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
        lblIMDb.setHorizontalAlignment(SwingConstants.CENTER);

        //---- btnTop10 ----
        btnTop10.setText("Top 10");
        btnTop10.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnTop10.addActionListener(e -> btnTop10ActionPerformed(e));

        //---- btnVote ----
        btnVote.setText("Vote");
        btnVote.setEnabled(false);
        btnVote.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnVote.addActionListener(e -> btnVoteActionPerformed(e));

        //---- btnLogin ----
        btnLogin.setText("Login");
        btnLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnLogin.addActionListener(e -> btnLoginActionPerformed(e));

        //---- lblUser ----
        lblUser.setFont(new Font("Tahoma", Font.BOLD, 14));

        //---- btnSignUp ----
        btnSignUp.setText("Sign Up");
        btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSignUp.addActionListener(e -> btnSignUpActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 1353, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTop10, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(btnVote, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(lblUser, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                    .addGap(22, 22, 22))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(686, 686, 686)
                    .addComponent(lblIMDb, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(771, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 312, Short.MAX_VALUE)
                            .addComponent(btnSignUp, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(btnVote, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54)
                            .addComponent(btnTop10, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(lblIMDb)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)))
                    .addGap(22, 22, 22))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable tbl;
    private JLabel lblIMDb;
    private JButton btnTop10;
    private JButton btnVote;
    private JButton btnLogin;
    private JLabel lblUser;
    private JButton btnSignUp;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
