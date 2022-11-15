/*
 작성자 : 이혜리, 윤채민
기능 : 조교가 제보된 불편사항을 확인하는 기능
 */
package cmsSuggestionPackage;

import cms.ConnectDB.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 이혜리, 윤채민
 */
public class CheckSuggestionPage extends javax.swing.JFrame {

    /**
     * Creates new form CheckWarningPage
     */
    public CheckSuggestionPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        suggest_table = new javax.swing.JTable();
        s_button = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        suggest_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "제보 번호", "제보자", "실습실 번호", "제보 제목", "제보 내용"
            }
        ));
        jScrollPane1.setViewportView(suggest_table);

        s_button.setText("제보 조회");
        s_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(s_button)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(s_button)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int check = 0; // 제보 조회 횟수를 1회로 제한
    private void s_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_buttonActionPerformed
        // TODO add your handling code here:
        if (check != -1) {
            DefaultTableModel model = (DefaultTableModel) suggest_table.getModel();

            ConnectDB db = new ConnectDB();
            Connection conn = null;
            Statement st = null;
            ResultSet rs = null;

            try {
                conn = db.getConnection();
                st = conn.createStatement();

                rs = st.executeQuery(("select * from suggestion"));

                ArrayList num_list = new ArrayList<String>();
                ArrayList id_list = new ArrayList<String>();
                ArrayList class_list = new ArrayList<String>();
                ArrayList title_list = new ArrayList<String>();
                ArrayList content_list = new ArrayList<String>();

                while (rs.next()) {
                    num_list.add(rs.getString("suggest_num"));
                    id_list.add(rs.getString("id"));
                    class_list.add(rs.getString("class_num"));
                    title_list.add(rs.getString("title"));
                    content_list.add(rs.getString("content"));
                }

                Object[] tableline = num_list.toArray();

                for (int i = 0; i < tableline.length; i++) {
                    ArrayList arr = new ArrayList<>();

                    arr.add(num_list.get(i));
                    arr.add(id_list.get(i));
                    arr.add(class_list.get(i));
                    arr.add(title_list.get(i));
                    arr.add(content_list.get(i));

                    model.addRow(new Object[]{arr.get(0), arr.get(1), arr.get(2), arr.get(3), arr.get(4)});

                }
                check = -1;

                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "제보 조회는 1회만 가능합니다.");
        }
    }//GEN-LAST:event_s_buttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CheckSuggestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckSuggestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckSuggestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckSuggestionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckSuggestionPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton s_button;
    protected static javax.swing.JTable suggest_table;
    // End of variables declaration//GEN-END:variables
}