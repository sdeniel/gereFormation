/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gereformation;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author sdeniel
 */
public class FormulaireStagiaire extends javax.swing.JDialog {

    public FormulaireStagiaire(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        
        // chargement des informations
        loadRecords();
    }

    // DEBUT PARTIE AJOUTEEE
    boolean addRecord = false;

    private void clearChampsDeSaisie() {
        txtIdStagiaire.setText("");
        txtNomStagiaire.setText(""); // setSelectedItem(""); pour du combobox
        txtPrenomStagiaire.setText("");
        txtAdresseStagiaire.setText("");
        txtVilleStagiaire.setText("");
        txtEmailStagiaire.setText("");
        txtTelephoneStagiaire.setText("");
    }

    private void addNew() throws SQLException {
        String sql_stmt = "INSERT INTO stagiaire (nom, prenom, adresse, ville, email, telephone)";
        sql_stmt += " VALUES ('" + txtNomStagiaire.getText() + "','" + txtPrenomStagiaire.getText() + "','" + txtAdresseStagiaire.getText() + "','" + txtVilleStagiaire.getText() + "','" + txtEmailStagiaire.getText() + "','" + txtTelephoneStagiaire.getText() + "')";

        JDBCConnect dbUtilities = new JDBCConnect();

        dbUtilities.ExecuteSQLStatement(sql_stmt);
    }

    private void updateRecord() throws SQLException {
        String sql_stmt = "UPDATE stagiaire SET nom = '" + txtNomStagiaire.getText() + "'";
        sql_stmt += ",prenom = '" + txtPrenomStagiaire.getText().toString() + "'";
        sql_stmt += ",adresse = '" + txtAdresseStagiaire.getText() + "'";
        sql_stmt += ",ville = '" + txtVilleStagiaire.getText() + "'";
        sql_stmt += ",email = '" + txtEmailStagiaire.getText() + "'";
        sql_stmt += ",telephone = '" + txtTelephoneStagiaire.getText() + "'";
        sql_stmt += " WHERE stagiaire_id = '" + txtIdStagiaire.getText() + "'"; //txtTelephoneStagiaire.getText()

        JDBCConnect dbUtilities = new JDBCConnect();

        dbUtilities.ExecuteSQLStatement(sql_stmt);
    }

    
    private void deleteRecord() throws SQLException {
        String sql_stmt = "DELETE FROM stagiaire WHERE stagiaire_id = '" + txtIdStagiaire.getText() + "'"; // txtEmployeeId.getText()

        JDBCConnect dbUtilities = new JDBCConnect();

        dbUtilities.ExecuteSQLStatement(sql_stmt);
    }
     
    private void loadRecords() throws SQLException {

        String sql_stmt = "SELECT * FROM stagiaire;";

        ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);

        tableStagiaire.setModel(tableModel);

        tableStagiaire.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            try {
                if (tableStagiaire.getSelectedRow() >= 0) {
                    Object idStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 0);
                    Object nomStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 1);
                    Object prenomStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 2);
                    Object adresseStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 3);
                    Object villeStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 4);
                    Object emailStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 5);
                    Object telephoneStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 6);

                    txtIdStagiaire.setText(idStagiaire.toString());
                    txtNomStagiaire.setText(nomStagiaire.toString());
                    txtPrenomStagiaire.setText(prenomStagiaire.toString());
                    txtAdresseStagiaire.setText(adresseStagiaire.toString());
                    txtVilleStagiaire.setText(villeStagiaire.toString());
                    txtEmailStagiaire.setText(emailStagiaire.toString());
                    txtTelephoneStagiaire.setText(telephoneStagiaire.toString());
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        tableStagiaire.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
    }

    // FIN PARTIE AJOUTEE
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelStagiaire = new javax.swing.JPanel();
        lblNomStagiaire = new javax.swing.JLabel();
        lblPrenomStagiaire = new javax.swing.JLabel();
        lblAdresseStagiaire = new javax.swing.JLabel();
        lblVilleStagiaire = new javax.swing.JLabel();
        lblEmailStagiaire = new javax.swing.JLabel();
        lblTelephoneStagiaire = new javax.swing.JLabel();
        txtNomStagiaire = new javax.swing.JTextField();
        txtPrenomStagiaire = new javax.swing.JTextField();
        txtAdresseStagiaire = new javax.swing.JTextField();
        txtVilleStagiaire = new javax.swing.JTextField();
        txtEmailStagiaire = new javax.swing.JTextField();
        txtTelephoneStagiaire = new javax.swing.JTextField();
        lblIdStagiaire = new javax.swing.JLabel();
        txtIdStagiaire = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStagiaire = new javax.swing.JTable();
        btnCreerStagiaire = new javax.swing.JButton();
        btnEditerStagiaire = new javax.swing.JButton();
        btnSupprimerStagiaire = new javax.swing.JButton();
        btnFermerStagiaire = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelStagiaire.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulaire Stagiaire"));

        lblNomStagiaire.setText("Nom");

        lblPrenomStagiaire.setText("Prenom");

        lblAdresseStagiaire.setText("Adresse");

        lblVilleStagiaire.setText("Ville");

        lblEmailStagiaire.setText("E-mail");

        lblTelephoneStagiaire.setText("Téléphone");

        lblIdStagiaire.setText("ID Stagiaire");

        txtIdStagiaire.setEnabled(false);

        javax.swing.GroupLayout panelStagiaireLayout = new javax.swing.GroupLayout(panelStagiaire);
        panelStagiaire.setLayout(panelStagiaireLayout);
        panelStagiaireLayout.setHorizontalGroup(
            panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStagiaireLayout.createSequentialGroup()
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelStagiaireLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIdStagiaire))
                    .addGroup(panelStagiaireLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblVilleStagiaire)
                            .addComponent(lblAdresseStagiaire)
                            .addComponent(lblPrenomStagiaire)
                            .addComponent(lblNomStagiaire))
                        .addGap(63, 63, 63)
                        .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtAdresseStagiaire, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(txtNomStagiaire, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrenomStagiaire, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVilleStagiaire))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTelephoneStagiaire)
                            .addComponent(lblEmailStagiaire))))
                .addGap(58, 58, 58)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEmailStagiaire)
                    .addComponent(txtTelephoneStagiaire)
                    .addComponent(txtIdStagiaire, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addGap(102, 102, 102))
        );
        panelStagiaireLayout.setVerticalGroup(
            panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStagiaireLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomStagiaire)
                    .addComponent(lblEmailStagiaire)
                    .addComponent(txtNomStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrenomStagiaire)
                    .addComponent(lblTelephoneStagiaire)
                    .addComponent(txtPrenomStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephoneStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdresseStagiaire)
                    .addComponent(txtAdresseStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdStagiaire)
                    .addComponent(txtIdStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVilleStagiaire)
                    .addComponent(txtVilleStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        tableStagiaire.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableStagiaire);

        btnCreerStagiaire.setText("Créer ligne");
        btnCreerStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreerStagiaireActionPerformed(evt);
            }
        });

        btnEditerStagiaire.setText("Editer ligne");
        btnEditerStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditerStagiaireActionPerformed(evt);
            }
        });

        btnSupprimerStagiaire.setText("Supprimer");
        btnSupprimerStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerStagiaireActionPerformed(evt);
            }
        });

        btnFermerStagiaire.setText("Fermer");
        btnFermerStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerStagiaireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnCreerStagiaire)
                .addGap(72, 72, 72)
                .addComponent(btnEditerStagiaire)
                .addGap(73, 73, 73)
                .addComponent(btnSupprimerStagiaire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnFermerStagiaire)
                .addGap(75, 75, 75))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelStagiaire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreerStagiaire)
                    .addComponent(btnEditerStagiaire)
                    .addComponent(btnSupprimerStagiaire)
                    .addComponent(btnFermerStagiaire))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreerStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreerStagiaireActionPerformed
        try {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez vous ajouter ce stagiaire ?", "Confirmer l'enregistrement ?", JOptionPane.YES_NO_OPTION);
            addNew();
            loadRecords();
            clearChampsDeSaisie(); // on efface les champs avant de créer un nouveau stagiaire
            txtNomStagiaire.requestFocus(); // permet de positionner le curseur sur le 1er champs de saisie (ici Nom)
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireStagiaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreerStagiaireActionPerformed

    private void btnEditerStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditerStagiaireActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez vous éditer ce stagiaire ?", "Confirmer la sauvegarde d'édition ?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                if (addRecord == true) {
                    addNew();
                } else {
                    updateRecord();
                }

                addRecord = false;

                loadRecords();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }        
    }//GEN-LAST:event_btnEditerStagiaireActionPerformed

    private void btnSupprimerStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerStagiaireActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Souhaitez vous supprimer ce stagiaire ?", "Confirmation de suppression ?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                deleteRecord();

                loadRecords();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSupprimerStagiaireActionPerformed

    private void btnFermerStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerStagiaireActionPerformed
        System.exit(1);
    }//GEN-LAST:event_btnFermerStagiaireActionPerformed

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
            java.util.logging.Logger.getLogger(FormulaireStagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormulaireStagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormulaireStagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormulaireStagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormulaireStagiaire dialog = new FormulaireStagiaire(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormulaireStagiaire.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreerStagiaire;
    private javax.swing.JButton btnEditerStagiaire;
    private javax.swing.JButton btnFermerStagiaire;
    private javax.swing.JButton btnSupprimerStagiaire;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdresseStagiaire;
    private javax.swing.JLabel lblEmailStagiaire;
    private javax.swing.JLabel lblIdStagiaire;
    private javax.swing.JLabel lblNomStagiaire;
    private javax.swing.JLabel lblPrenomStagiaire;
    private javax.swing.JLabel lblTelephoneStagiaire;
    private javax.swing.JLabel lblVilleStagiaire;
    private javax.swing.JPanel panelStagiaire;
    private javax.swing.JTable tableStagiaire;
    private javax.swing.JTextField txtAdresseStagiaire;
    private javax.swing.JTextField txtEmailStagiaire;
    private javax.swing.JTextField txtIdStagiaire;
    private javax.swing.JTextField txtNomStagiaire;
    private javax.swing.JTextField txtPrenomStagiaire;
    private javax.swing.JTextField txtTelephoneStagiaire;
    private javax.swing.JTextField txtVilleStagiaire;
    // End of variables declaration//GEN-END:variables
}
