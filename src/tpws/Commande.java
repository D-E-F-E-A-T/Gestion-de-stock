/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpws;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mr SOFIANE
 */
public class Commande extends javax.swing.JFrame {

    /**
     * Creates new form com
     */
    public Commande() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
        setTitle("Gestion des commandes");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tf10 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        tf10.setEditable(false);
        tf10.setMinimumSize(new java.awt.Dimension(150, 20));
        tf10.setPreferredSize(new java.awt.Dimension(200, 20));
        jPanel4.add(tf10);

        jPanel3.add(jPanel4);

        jButton1.setText("Afficher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1);

        jButton2.setText("Ajouter une commande");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton2);

        jButton3.setText("Supprimer une commande");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton3);

        jButton5.setText("Recherche avancé");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton5);

        jButton4.setText("Accueil");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton4);

        jPanel3.add(jPanel7);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel9.setLayout(new java.awt.GridLayout(1, 2));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Commande"));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel8.setLayout(new java.awt.BorderLayout());

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°Commande", "N°Client", "Date de facture", "Montant Commande"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Lignes de commande"));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel13.setLayout(new java.awt.BorderLayout());

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°Commande", "N°Article", "Libellé", "Prix", "Quantité", "Mantant"
            }
        ));
        jScrollPane2.setViewportView(table2);

        jPanel13.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel13, java.awt.BorderLayout.LINE_START);

        jPanel14.setLayout(new java.awt.BorderLayout());

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Libellé"
            }
        ));
        jScrollPane3.setViewportView(table3);

        jPanel14.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel14, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel9.add(jPanel6);

        getContentPane().add(jPanel9, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DBC con = null;
        Statement stmt = null;
        try{
            con = new DBC();
            stmt=con.getConnection().createStatement();
            
            ResultSet resultat = stmt.executeQuery("SELECT * FROM commande");
            table1.setModel(DbUtils.resultSetToTableModel(resultat));
                                int i=0 ;
				while(resultat.next()){
				table1.setValueAt(resultat.getString("n_commande"), i, 0);
				table1.setValueAt(resultat.getString("n_client"), i, 1);
				table1.setValueAt(resultat.getString("date_facture"), i, 2);
				table1.setValueAt(resultat.getString("montant_com"), i, 3);
				i++;
				}
                                
       }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        DBC con = null;
        Statement stmt = null;
        try{
            con = new DBC();
            stmt=con.getConnection().createStatement();
            ResultSet resultat = stmt.executeQuery("SELECT * FROM ligne_commande WHERE ligne_commande.n_com = '"+table1.getValueAt(table1.getSelectedRow(), 0)+"' ");
            table2.setModel(DbUtils.resultSetToTableModel(resultat));
                                int i=0 ;
				while(resultat.next()){
				table2.setValueAt(resultat.getString("n_com"), i, 0);
				table2.setValueAt(resultat.getString("n_article"), i, 1);
				table2.setValueAt(resultat.getString("prix"), i, 2);
				table2.setValueAt(resultat.getString("qte"), i, 3);
                                table2.setValueAt(resultat.getString("montant"), i, 4);
				i++;
				}      
       }catch(Exception e){
            e.printStackTrace();
        }
        try{
            con = new DBC();
            stmt=con.getConnection().createStatement();
				ResultSet res = stmt.executeQuery("SELECT article.libelle FROM commande,ligne_commande,article WHERE commande.n_commande = ligne_commande.n_com AND ligne_commande.n_article = article.n_article AND ligne_commande.n_com = '"+table1.getValueAt(table1.getSelectedRow(), 0)+"'");
                                table3.setModel(DbUtils.resultSetToTableModel(res));
                                int i=0 ;
				while(res.next()){
                                table3.setValueAt(res.getString("libelle"), i, 1);
				i++;
				}
                          
       }catch(Exception e){
            e.printStackTrace();
        }
        try{
            con = new DBC();
            stmt=con.getConnection().createStatement();
				ResultSet res = stmt.executeQuery("SELECT nom FROM client WHERE n_client= '"+table1.getValueAt(table1.getSelectedRow(), 1)+"'");
				while(res.next()){
                                tf10.setText(res.getString("nom"));
				
				}
                          
       }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_table1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Ncommande ncommande = new Ncommande();
        ncommande.setVisible(true);        
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DBC con = null;
            Statement stmt = null;
        try{
            con = new DBC();
            stmt=con.getConnection().createStatement();
            stmt.executeUpdate("DELETE FROM commande WHERE n_commande='"+table1.getValueAt(table1.getSelectedRow(), 0)+"'");
            JOptionPane.showMessageDialog(null, "Client supprimé avec succès", "Information", JOptionPane.ERROR_MESSAGE);
            
            ResultSet resultat = stmt.executeQuery("SELECT * FROM commande");
            table1.setModel(DbUtils.resultSetToTableModel(resultat));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
                Login log = new Login();
        log.setVisible(true);        
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Ravance ravance = new Ravance();
        ravance.set(this);
        ravance.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(Commande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Commande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Commande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Commande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Commande().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTextField tf10;
    // End of variables declaration//GEN-END:variables
}
