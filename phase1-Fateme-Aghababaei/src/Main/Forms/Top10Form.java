/*
 * Created by JFormDesigner on Mon Oct 04 22:52:39 IRST 2021
 */

package Main.Forms;

import Main.Title;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author Fateme
 */
public class Top10Form extends JFrame {
    JFrame previousFrame;
    ArrayList<Title> sortTitles;

    public Top10Form(JFrame previousFrame, ArrayList<Title> titles) {
        this.previousFrame = previousFrame;
        this.sortTitles = new ArrayList<>(titles);
        sortTitles.sort((o1, o2) -> {
            if (o1.getAverageRating() > o2.getAverageRating()) return -1;
            else if (o1.getAverageRating() < o2.getAverageRating()) return 1;
            return 0;
        });

        initComponents();

        DefaultTableModel model = (DefaultTableModel) tbl.getModel();

        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        for (int i = 0; i < 10; i++) {
            model.addRow(new Object[] {
                    i + 1,
                    sortTitles.get(i).getTitleID(),
                    sortTitles.get(i).getTitle(),
                    sortTitles.get(i).getAverageRating(),
                    sortTitles.get(i).getNumVotes()
            });
        }
        for (int i = 0; i < tbl.getColumnCount(); i++) {
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
            cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            tbl.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
    }

    private void btnBackActionPerformed(ActionEvent e) {
        this.dispose();
        previousFrame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        lblIMDb = new JLabel();
        scrollPane1 = new JScrollPane();
        tbl = new JTable();
        btnBack = new JButton();

        //======== this ========
        setTitle("Top 10");
        setIconImage(new ImageIcon("E:\\Uni\\Data Structures\\Projects\\Phase 1\\phase1-Fateme-Aghababaei\\IMDbIcon.jpg").getImage());
        setResizable(false);
        Container contentPane = getContentPane();

        //---- lblIMDb ----
        lblIMDb.setText("Top 10");
        lblIMDb.setForeground(Color.orange);
        lblIMDb.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
        lblIMDb.setHorizontalAlignment(SwingConstants.CENTER);

        //======== scrollPane1 ========
        {

            //---- tbl ----
            tbl.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                },
                new String[] {
                    " Rank", "ID", "Title", "Rating", "Num Votes"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class, String.class, String.class, Double.class, Integer.class
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
            });
            {
                TableColumnModel cm = tbl.getColumnModel();
                cm.getColumn(0).setMinWidth(50);
                cm.getColumn(0).setMaxWidth(50);
                cm.getColumn(0).setPreferredWidth(50);
                cm.getColumn(2).setMinWidth(350);
                cm.getColumn(2).setMaxWidth(350);
                cm.getColumn(2).setPreferredWidth(350);
            }
            tbl.setFont(new Font("Tahoma", Font.BOLD, 14));
            tbl.setRowHeight(50);
            scrollPane1.setViewportView(tbl);
        }

        //---- btnBack ----
        btnBack.setText("Back");
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBack.addActionListener(e -> btnBackActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(360, 360, 360)
                    .addComponent(lblIMDb, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 364, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(50, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(361, 361, 361))
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 742, GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(lblIMDb)
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel lblIMDb;
    private JScrollPane scrollPane1;
    private JTable tbl;
    private JButton btnBack;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
