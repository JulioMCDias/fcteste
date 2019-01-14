package com.fcteste.controller;

import com.fcteste.model.AnalyzerFiles;
import com.fcteste.model.FilesJava;
import com.fcteste.view.ViewMain;
import java.io.File;

/**
 *
 * @author Julio M. C. Dias
 */
public class ControllView {
    private static ControllView cView;
    private static ViewMain vMain;
    private FilesJava filesJ;
    private AnalyzerFiles analyFiles;
    
    
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
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                vMain = new ViewMain(cView);
                vMain.setVisible(true);
            }
        });
 
    }

    
    public void analyzeProject(String directory){
        analyFiles = new AnalyzerFiles();
        filesJ = new FilesJava(directory);
        filesJ.findFiles();
        for (File f : filesJ.getFiles()) {
            vMain.getDlm().addElement(f.toString().replace(directory, ""));
        }
        analyFiles.applyAnaly(filesJ);
    }
    
    public void cleanProject(){
        if(filesJ != null)
            filesJ.cleanArrayFiles();
        if(analyFiles != null)
            analyFiles.cleanArrayFiles();
        vMain.getDlm().clear();
    }
    
    
    public void selectionFiles(){
        cleanFiled();
        int listFilesSelected[] = vMain.getjListArq().getSelectedIndices();
        if(listFilesSelected != null && !analyFiles.getListCAnalyzer().isEmpty()){
            for (int fileSele : listFilesSelected) {
                vMain.setjTFLinBrancas(analyFiles.getListCAnalyzer().get(fileSele).count.getLineBlank());
                //vMain.setjTFLinComando(analyFiles.getListCAnalyzer().get(fileSele).count.getLineComand());
                vMain.setjTFLinTotal(analyFiles.getListCAnalyzer().get(fileSele).count.getLineAll());
                vMain.setjTFOperadoresTotais(analyFiles.getListCAnalyzer().get(fileSele).count.getOperator());
                vMain.setjTFOperadoresUni(analyFiles.getListCAnalyzer().get(fileSele).count.getOperatorOnly());
                vMain.setjTFOperandos(analyFiles.getListCAnalyzer().get(fileSele).count.getOperating());
            }
        }
        
    }
    
    private void cleanFiled(){
        vMain.setjTFLinBrancas(0);
        vMain.setjTFLinComando(0);
        vMain.setjTFLinTotal(0);
        vMain.setjTFOperadoresTotais(0);
        vMain.setjTFOperadoresUni(0);
        vMain.setjTFOperandos(0);
    }
}
