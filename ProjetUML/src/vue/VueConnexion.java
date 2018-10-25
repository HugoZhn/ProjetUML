/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controler.Controler;
import utilitaire.Libelle;

/**
 *
 * @author caoyang
 */
public class VueConnexion extends javax.swing.JFrame {
    
    Controler controler;
    
    /**
     * Creates new form Connexion
     */
    public VueConnexion(Boolean erreur) {        
        this.controler = new Controler();
        
        initComponents();
        dessinerConnexion(erreur);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenue = new javax.swing.JLabel();
        lblConnexion = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblMdp = new javax.swing.JLabel();
        btnValider = new java.awt.Button();
        btnInscrire = new java.awt.Button();
        lblErreur = new javax.swing.JLabel();
        pswMdp = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(663, 489));

        lblBienvenue.setText("jLabel1");

        lblConnexion.setText("jLabel2");

        txtEmail.setText("jTextField1");
        txtEmail.setPreferredSize(new java.awt.Dimension(130, 26));
        txtEmail.setSize(new java.awt.Dimension(130, 26));

        lblEmail.setText("jLabel4");

        lblMdp.setText("jLabel5");

        btnValider.setLabel("button1");
        btnValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValiderActionPerformed(evt);
            }
        });

        btnInscrire.setLabel("button2");
        btnInscrire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscrireActionPerformed(evt);
            }
        });

        lblErreur.setForeground(new java.awt.Color(255, 0, 0));
        lblErreur.setText("jLabel1");

        pswMdp.setText("jPasswordField1");
        pswMdp.setAutoscrolls(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblConnexion, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBienvenue)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(lblErreur))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnInscrire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail)
                            .addComponent(lblMdp))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pswMdp)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(btnValider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblBienvenue)
                .addGap(26, 26, 26)
                .addComponent(lblConnexion)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lblErreur, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMdp)
                            .addComponent(pswMdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)
                        .addComponent(btnInscrire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnValider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(138, 138, 138))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValiderActionPerformed
        Boolean adrNull = txtEmail.getText().equals("");
        Boolean mdpNull = pswMdp.getText().equals("");
        
        if(!mdpNull){
            if(!adrNull){
                this.dispose();
                this.controler.ConnValider(txtEmail.getText(), pswMdp.getText());  
            } else {
                lblErreur.setText(Libelle.ERR_EMAIL); 
            }
        } else {
            if(!adrNull){
                lblErreur.setText(Libelle.ERR_MDP);
            }else {                
                lblErreur.setText(Libelle.ERR_EMAIL_MDP_SAISIE);  
            }
        }        
    }//GEN-LAST:event_btnValiderActionPerformed

    private void btnInscrireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscrireActionPerformed
        this.dispose();
        this.controler.InscrireCompte();
    }//GEN-LAST:event_btnInscrireActionPerformed
    
    private void dessinerConnexion(Boolean erreur){
        lblBienvenue.setText(Libelle.BIENVENUE);
        lblConnexion.setText(Libelle.CONNEXION);
        
        lblErreur.setText(Libelle.VIDE);
        lblEmail.setText(Libelle.EMAIL);
        lblMdp.setText(Libelle.MDP);        
        txtEmail.setText("Yang@gmail.com");
        pswMdp.setText("y1234");
        
        btnInscrire.setLabel(Libelle.SINSCRIRE);
        btnValider.setLabel(Libelle.VALIDER);
        
        if(erreur){            
            lblErreur.setText(Libelle.ERR_EMAIL_MDP);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnInscrire;
    private java.awt.Button btnValider;
    private javax.swing.JLabel lblBienvenue;
    private javax.swing.JLabel lblConnexion;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblErreur;
    private javax.swing.JLabel lblMdp;
    private javax.swing.JPasswordField pswMdp;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
