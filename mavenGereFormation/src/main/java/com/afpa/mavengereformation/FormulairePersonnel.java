/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afpa.mavengereformation;

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
public class FormulairePersonnel extends javax.swing.JDialog {
    
    /*public FormulairePersonnel() {
        try {
            initComponents();
            this.setVisible(true);
            this.setLocationRelativeTo(null);
            this.setTitle("Fiche personnel");
            
            // chargement des informations
            loadRecords();
        } catch (SQLException ex) {
            Logger.getLogger(FormulairePersonnel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    public FormulairePersonnel(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        this.setTitle("Fiche personnel");
        
        // chargement des informations
        loadRecords();
    }

    // DEBUT PARTIE AJOUTEEE
    boolean addRecord = false;

    private void clearChampsDeSaisie() {
        txtIdPersonnel.setText("");
        txtNomPersonnel.setText(""); 
        txtPrenomPersonnel.setText("");
        txtLoginPersonnel.setText("");
        txtMdpPersonnel.setText("");
        txtEmailPersonnel.setText("");
        cbRolePersonnel.setSelectedItem("");
    }

    private void addNew() throws SQLException {
        String sql_stmt = "INSERT INTO personnel (nom, prenom, login, mdp, email, role)";
        sql_stmt += " VALUES ('" + txtNomPersonnel.getText() + "','" + txtPrenomPersonnel.getText() + "','" + txtLoginPersonnel.getText() + "','" + txtMdpPersonnel.getText() + "','" + txtEmailPersonnel.getText() + "','" + cbRolePersonnel.getSelectedItem() + "')";

        JDBCConnect dbUtilities = new JDBCConnect();

        dbUtilities.ExecuteSQLStatement(sql_stmt);
    }

    private void updateRecord() throws SQLException {
        String sql_stmt = "UPDATE personnel SET nom = '" + txtNomPersonnel.getText() + "'";
        sql_stmt += ",prenom = '" + txtPrenomPersonnel.getText().toString() + "'";
        sql_stmt += ",login = '" + txtLoginPersonnel.getText() + "'";
        sql_stmt += ",mdp = '" + txtMdpPersonnel.getText() + "'";
        sql_stmt += ",email = '" + txtEmailPersonnel.getText() + "'";
        sql_stmt += ",role = '" + cbRolePersonnel.getSelectedItem() + "'";
        sql_stmt += " WHERE personnel_id = '" + txtIdPersonnel.getText() + "'"; //txtTelephoneStagiaire.getText()

        JDBCConnect dbUtilities = new JDBCConnect();

        dbUtilities.ExecuteSQLStatement(sql_stmt);
    }

    
    private void deleteRecord() throws SQLException {
        String sql_stmt = "DELETE FROM personnel WHERE personnel_id = '" + txtIdPersonnel.getText() + "'"; 

        JDBCConnect dbUtilities = new JDBCConnect();

        dbUtilities.ExecuteSQLStatement(sql_stmt);
    }
     
    private void loadRecords() throws SQLException {

        String sql_stmt = "SELECT * FROM personnel;";

        ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);

        tablePersonnel.setModel(tableModel);

        tablePersonnel.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            try {
                if (tablePersonnel.getSelectedRow() >= 0) {
                    Object idPersonnel = tablePersonnel.getValueAt(tablePersonnel.getSelectedRow(), 0);
                    Object nomPersonnel = tablePersonnel.getValueAt(tablePersonnel.getSelectedRow(), 1);
                    Object prenomPersonnel = tablePersonnel.getValueAt(tablePersonnel.getSelectedRow(), 2);
                    Object loginPersonnel = tablePersonnel.getValueAt(tablePersonnel.getSelectedRow(), 3);
                    Object mdpPersonnel = tablePersonnel.getValueAt(tablePersonnel.getSelectedRow(), 4);
                    Object emailPersonnel = tablePersonnel.getValueAt(tablePersonnel.getSelectedRow(), 5);
                    Object rolePersonnel = tablePersonnel.getValueAt(tablePersonnel.getSelectedRow(), 6);

                    txtIdPersonnel.setText(idPersonnel.toString());
                    txtNomPersonnel.setText(nomPersonnel.toString());
                    txtPrenomPersonnel.setText(prenomPersonnel.toString());
                    txtLoginPersonnel.setText(loginPersonnel.toString());
                    txtMdpPersonnel.setText(mdpPersonnel.toString());
                    txtEmailPersonnel.setText(emailPersonnel.toString());
                    cbRolePersonnel.setSelectedItem(rolePersonnel.toString());
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        tablePersonnel.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
    }

    // FIN PARTIE AJOUTEE
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPersonnel = new javax.swing.JPanel();
        lblNomPersonnel = new javax.swing.JLabel();
        lblPrenomPersonnel = new javax.swing.JLabel();
        lblAdressePersonnel = new javax.swing.JLabel();
        lblVillePersonnel = new javax.swing.JLabel();
        lblEmailPersonnel = new javax.swing.JLabel();
        lblTelephonePersonnel = new javax.swing.JLabel();
        txtNomPersonnel = new javax.swing.JTextField();
        txtPrenomPersonnel = new javax.swing.JTextField();
        txtLoginPersonnel = new javax.swing.JTextField();
        txtMdpPersonnel = new javax.swing.JTextField();
        txtEmailPersonnel = new javax.swing.JTextField();
        lblIdPersonnel = new javax.swing.JLabel();
        txtIdPersonnel = new javax.swing.JTextField();
        cbRolePersonnel = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePersonnel = new javax.swing.JTable();
        btnCreerPersonnel = new javax.swing.JButton();
        btnEditerPersonnel = new javax.swing.JButton();
        btnSupprimerPersonnel = new javax.swing.JButton();
        btnFermerPersonnel = new javax.swing.JButton();
        btnVersStagiaire = new javax.swing.JButton();
        btnVersFormation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelPersonnel.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulaire Personnel"));

        lblNomPersonnel.setText("Nom");

        lblPrenomPersonnel.setText("Prenom");

        lblAdressePersonnel.setText("Login");

        lblVillePersonnel.setText("Mdp");

        lblEmailPersonnel.setText("E-mail");

        lblTelephonePersonnel.setText("Role");

        lblIdPersonnel.setText("ID Personnel");

        txtIdPersonnel.setEnabled(false);

        cbRolePersonnel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "formateur", "secretaire" }));

        javax.swing.GroupLayout panelPersonnelLayout = new javax.swing.GroupLayout(panelPersonnel);
        panelPersonnel.setLayout(panelPersonnelLayout);
        panelPersonnelLayout.setHorizontalGroup(
            panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPersonnelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPersonnelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblIdPersonnel)
                        .addGap(58, 58, 58)
                        .addComponent(txtIdPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPersonnelLayout.createSequentialGroup()
                        .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPrenomPersonnel)
                            .addComponent(lblNomPersonnel)
                            .addComponent(lblAdressePersonnel)
                            .addComponent(lblVillePersonnel))
                        .addGap(39, 39, 39)
                        .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNomPersonnel, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(txtPrenomPersonnel)
                            .addComponent(txtLoginPersonnel)
                            .addComponent(txtMdpPersonnel))
                        .addGap(145, 145, 145)
                        .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTelephonePersonnel)
                            .addComponent(lblEmailPersonnel))
                        .addGap(58, 58, 58)
                        .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRolePersonnel, 0, 139, Short.MAX_VALUE)
                            .addComponent(txtEmailPersonnel))))
                .addGap(73, 73, 73))
        );
        panelPersonnelLayout.setVerticalGroup(
            panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonnelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomPersonnel)
                    .addComponent(lblEmailPersonnel)
                    .addComponent(txtNomPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmailPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPersonnelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelephonePersonnel)
                            .addComponent(cbRolePersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPersonnelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrenomPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrenomPersonnel))))
                .addGap(18, 18, 18)
                .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPersonnelLayout.createSequentialGroup()
                        .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIdPersonnel)
                            .addComponent(txtIdPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPersonnelLayout.createSequentialGroup()
                        .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdressePersonnel)
                            .addComponent(txtLoginPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addGroup(panelPersonnelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVillePersonnel)
                    .addComponent(txtMdpPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        tablePersonnel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablePersonnel);

        btnCreerPersonnel.setText("Créer personnel");
        btnCreerPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreerPersonnelActionPerformed(evt);
            }
        });

        btnEditerPersonnel.setText("Editer personnel");
        btnEditerPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditerPersonnelActionPerformed(evt);
            }
        });

        btnSupprimerPersonnel.setText("Supprimer");
        btnSupprimerPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerPersonnelActionPerformed(evt);
            }
        });

        btnFermerPersonnel.setText("Fermer");
        btnFermerPersonnel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerPersonnelActionPerformed(evt);
            }
        });

        btnVersStagiaire.setText("Fiche Stagiaire");

        btnVersFormation.setText("Fiche Formation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnCreerPersonnel)
                .addGap(37, 37, 37)
                .addComponent(btnEditerPersonnel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnSupprimerPersonnel)
                .addGap(48, 48, 48)
                .addComponent(btnFermerPersonnel)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPersonnel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(btnVersStagiaire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVersFormation)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVersStagiaire)
                    .addComponent(btnVersFormation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelPersonnel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreerPersonnel)
                    .addComponent(btnEditerPersonnel)
                    .addComponent(btnSupprimerPersonnel)
                    .addComponent(btnFermerPersonnel))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreerPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreerPersonnelActionPerformed
        try {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez vous ajouter cette personne dans la table personnel ?", "Confirmer l'enregistrement ?", JOptionPane.YES_NO_OPTION);
            addNew();
            loadRecords();
            clearChampsDeSaisie(); // on efface les champs avant de créer un nouveau stagiaire
            txtNomPersonnel.requestFocus(); // permet de positionner le curseur sur le 1er champs de saisie (ici Nom)
        } catch (SQLException ex) {
            Logger.getLogger(FormulairePersonnel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreerPersonnelActionPerformed

    private void btnEditerPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditerPersonnelActionPerformed
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
    }//GEN-LAST:event_btnEditerPersonnelActionPerformed

    private void btnSupprimerPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerPersonnelActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Souhaitez vous supprimer ce stagiaire ?", "Confirmation de suppression ?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                deleteRecord();

                loadRecords();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSupprimerPersonnelActionPerformed

    private void btnFermerPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerPersonnelActionPerformed
        System.exit(1);
    }//GEN-LAST:event_btnFermerPersonnelActionPerformed

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
            java.util.logging.Logger.getLogger(FormulairePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormulairePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormulairePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormulairePersonnel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormulairePersonnel dialog = new FormulairePersonnel(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormulairePersonnel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreerPersonnel;
    private javax.swing.JButton btnEditerPersonnel;
    private javax.swing.JButton btnFermerPersonnel;
    private javax.swing.JButton btnSupprimerPersonnel;
    private javax.swing.JButton btnVersFormation;
    private javax.swing.JButton btnVersStagiaire;
    private javax.swing.JComboBox<String> cbRolePersonnel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdressePersonnel;
    private javax.swing.JLabel lblEmailPersonnel;
    private javax.swing.JLabel lblIdPersonnel;
    private javax.swing.JLabel lblNomPersonnel;
    private javax.swing.JLabel lblPrenomPersonnel;
    private javax.swing.JLabel lblTelephonePersonnel;
    private javax.swing.JLabel lblVillePersonnel;
    private javax.swing.JPanel panelPersonnel;
    private javax.swing.JTable tablePersonnel;
    private javax.swing.JTextField txtEmailPersonnel;
    private javax.swing.JTextField txtIdPersonnel;
    private javax.swing.JTextField txtLoginPersonnel;
    private javax.swing.JTextField txtMdpPersonnel;
    private javax.swing.JTextField txtNomPersonnel;
    private javax.swing.JTextField txtPrenomPersonnel;
    // End of variables declaration//GEN-END:variables
}
