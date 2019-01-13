package com.fcteste.controller;

import com.fcteste.model.FilesJava;
import com.fcteste.view.ViewPrincipal;
import java.io.File;

/**
 *
 * @author Julio M. C. Dias
 */
public class ControllView {
    private static ControllView cView;
    private static ViewPrincipal vPrincipal;
    private FilesJava filesJ;
    
    
    public static void main(String args[]) {       
        cView = new ControllView();
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
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vPrincipal = new ViewPrincipal(cView);
                vPrincipal.setVisible(true);
            }
        });
 
    }

    
    public void analyzeProject(String directory){
        filesJ = new FilesJava(directory);
        filesJ.findFiles();
        for (File f : filesJ.getFiles()) {
            System.out.println(f.getAbsolutePath());
        }
    }
    
    public void cleanProject(){
        if(filesJ != null)
            filesJ.cleanArrayFiles();
    }
    
}
