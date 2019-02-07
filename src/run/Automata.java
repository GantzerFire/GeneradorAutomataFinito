/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import ListClass.Grafo;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import retoautomata.Archivo;
import retoautomata.Thompson;
import retoautomata.expresionRegular;
import retoautomata.transLambda;

/**
 *
 * @author Felipe
 */
public class Automata extends javax.swing.JFrame {

    /**
     * Creates new form Automata
     */
    public Automata() {
        initComponents();
        this.setLocationRelativeTo(null);
        escribe.setEnabled(false);
        escribe.setToolTipText("Generar el programa del automata");
        jLabel6.setToolTipText("Tenga cuidado con los espacios y expresiones mal parentizadas, no es necesario incluir simbolo de fin de secuencia");
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new javax.swing.JTextField();
        geneAutomata = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMatriz = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        escribe = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        setMaximumSize(new java.awt.Dimension(720, 450));
        setMinimumSize(new java.awt.Dimension(720, 480));
        setPreferredSize(new java.awt.Dimension(720, 480));
        setResizable(false);
        getContentPane().setLayout(null);

        txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActionPerformed(evt);
            }
        });
        getContentPane().add(txt);
        txt.setBounds(20, 30, 267, 24);

        geneAutomata.setText("Generar AFD");
        geneAutomata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geneAutomataActionPerformed(evt);
            }
        });
        getContentPane().add(geneAutomata);
        geneAutomata.setBounds(372, 29, 110, 32);

        tblMatriz.setBackground(new java.awt.Color(0, 153, 153));
        tblMatriz.setBorder(new javax.swing.border.MatteBorder(null));
        tblMatriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblMatriz.setToolTipText("");
        jScrollPane1.setViewportView(tblMatriz);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(24, 106, 556, 237);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("MS PMincho", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Estado");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(24, 84, 39, 13);

        jLabel2.setFont(new java.awt.Font("MS Mincho", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Simbolo de entrada");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(141, 84, 126, 13);

        jLabel3.setFont(new java.awt.Font("MS Mincho", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Transicion");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(310, 84, 70, 13);

        jLabel4.setFont(new java.awt.Font("MS Mincho", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Aceptacion o rechazo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(438, 84, 140, 13);

        escribe.setText("Generar programa");
        escribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escribeActionPerformed(evt);
            }
        });
        getContentPane().add(escribe);
        escribe.setBounds(24, 379, 135, 32);

        jLabel6.setFont(new java.awt.Font("MS Gothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ingrese la expresion regular");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 10, 200, 13);

        jButton1.setText("Ayuda");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(370, 380, 110, 32);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fonndo.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 720, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void geneAutomataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geneAutomataActionPerformed
        Grafo building; 
        String [] muestra;
        String [] sim;
        ArrayList<String> trans = new ArrayList<>();
        Thompson thom = new Thompson(); 
        transLambda cierre = new transLambda();
        String expresion = txt.getText();  
        expresionRegular eP = new expresionRegular(thom, expresion);
        Stack e = eP.generarGrafos();
        building = (Grafo) e.pop();
        thom.AsigNum(building);
        muestra = cierre.cierreLambda(building);
        cierre.ordenaCierres(muestra);
        sim = eP.simEntrada(expresion);  
        trans = cierre.AFD(building, muestra, sim);
        String[][] tabla;
        tabla = cierre.AFDtabla(trans, sim, muestra);
        int n = tabla.length;
        int m = tabla[0].length;
        mostrarMatriz(tabla,n,m);
        escribe.setEnabled(true);
    }//GEN-LAST:event_geneAutomataActionPerformed

    private void escribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escribeActionPerformed
        Grafo building; 
        String [] muestra;
        String [] sim;
        ArrayList<String> trans = new ArrayList<>();
        Thompson thom = new Thompson(); 
        transLambda cierre = new transLambda();
        String expresion = txt.getText();  
        expresionRegular eP = new expresionRegular(thom, expresion);
        Stack e = eP.generarGrafos();
        building = (Grafo) e.pop();
        thom.AsigNum(building);
        muestra = cierre.cierreLambda(building);
        cierre.ordenaCierres(muestra);
        sim = eP.simEntrada(expresion);  
        trans = cierre.AFD(building, muestra, sim);
        String[][] tabla;
        tabla = cierre.AFDtabla(trans, sim, muestra);
        int n = tabla.length;
        int m = tabla[0].length;
        mostrarMatriz(tabla,n,m);
        Archivo obj = new Archivo();
        obj.programa(tabla);
        JOptionPane.showMessageDialog(null, "Se acaba de escribir en el archivo \"Programa.java\" alojado en el paquete \"run\" el programa correspondiente \na este automata que reconoce si una hilera pertenece o no al lenguaje descrito por el este.");
    }//GEN-LAST:event_escribeActionPerformed

    private void txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActionPerformed
    
    }//GEN-LAST:event_txtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
     Instrucciones ayuda = new Instrucciones();
     ayuda.setVisible(true);
     
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Automata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Automata().setVisible(true);
            }
        });
    }
    
    public void mostrarMatriz(String matriz[][], int n, int m){
        DefaultTableModel model = (DefaultTableModel)tblMatriz.getModel();
        tblMatriz.getTableHeader().setUI(null);
        model.setColumnCount(m);
        model.setRowCount(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tblMatriz.setValueAt(matriz[i][j], i, j);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton escribe;
    private javax.swing.JButton geneAutomata;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMatriz;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}
