package com.fcteste.controller;

import com.fcteste.model.AnalyzerFiles;
import com.fcteste.model.CreateFileCSV;
import com.fcteste.model.FilesJava;
import com.fcteste.view.ViewMain;
import com.fcteste.view.ViewProgressBar;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Julio M. C. Dias
 */
public class ControllView {

    private static ControllView cView;
    private static ViewMain vMain;
    private FilesJava filesJ;
    private AnalyzerFiles analyFiles;
    private final CreateFileCSV cfCSV;
    private ViewProgressBar vPBar;

    public ControllView() {
        cfCSV = new CreateFileCSV();
    }

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
                vMain.setLocationRelativeTo(null);
                vMain.setVisible(true);
            }
        });

    }

    public void analyzeProject(String directory) {
        analyFiles = new AnalyzerFiles();
        filesJ = new FilesJava(directory);

        new Thread(new Runnable() {
            @Override
            public void run() {
                filesJ.findFiles();
                analyFiles.applyAnaly(filesJ);
            }
        }).start();

        vPBar = new ViewProgressBar(vMain, true, filesJ, analyFiles);
        vPBar.setLocationRelativeTo(null);
        vPBar.setVisible(true);
        for (File f : filesJ.getFiles()) {
            vMain.getDlm().addElement(f.toString().replace(directory, ""));
        }
        vMain.setjTFArquivos(filesJ.getFiles().size());
    }

    public void cleanProject() {
        if (filesJ != null) {
            filesJ.cleanArrayFiles();
        }
        if (analyFiles != null) {
            analyFiles.cleanArrayFiles();
        }
        vMain.getDlm().clear();
        cleanFiled();
        vMain.setjTFArquivos(0);
    }

    public void selectionFiles() {
        cleanFiled();
        int listFilesSelected[] = vMain.getjListArq().getSelectedIndices();
        int[] listjTF = new int[6];

        if (listFilesSelected != null && analyFiles != null) {
            for (int fileSele : listFilesSelected) {
                listjTF[0] += analyFiles.getListCAnalyzer().get(fileSele).count.getMethod();
                listjTF[1] += analyFiles.getListCAnalyzer().get(fileSele).count.getMethodCall();
                listjTF[2] += analyFiles.getListCAnalyzer().get(fileSele).count.getLineNumber();
                listjTF[3] += analyFiles.getListCAnalyzer().get(fileSele).count.getOperator();
                listjTF[4] += analyFiles.getListCAnalyzer().get(fileSele).count.getOperatorOnly();
                listjTF[5] += analyFiles.getListCAnalyzer().get(fileSele).count.getOperating();
            }
            vMain.setjTFQtMetodos(listjTF[0]);
            vMain.setjTFLinComando(listjTF[1]);
            vMain.setjTFLinTotal(listjTF[2]);
            vMain.setjTFOperadoresTotais(listjTF[3]);
            vMain.setjTFOperadoresUni((listFilesSelected.length > 1) ? -1 : listjTF[4]);
            vMain.setjTFOperandos(listjTF[5]);

        }

    }

    public void creatCSV() {

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setDialogTitle("Salvar projeto CSV");
        chooser.setSelectedFile(new File("projeto.csv"));

        FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("csv files (*.csv)", "CSV");
        // add filters
        chooser.addChoosableFileFilter(csvFilter);
        chooser.setFileFilter(csvFilter);

        chooser.setAcceptAllFileFilterUsed(false);  // disable the "All files" option.
        if (chooser.showSaveDialog(vMain) == JFileChooser.APPROVE_OPTION) {
            cfCSV.creatFileCSV(chooser.getSelectedFile(), analyFiles.getListCAnalyzer());
        }
    }

    private void cleanFiled() {
        vMain.setjTFQtMetodos(0);
        vMain.setjTFLinComando(0);
        vMain.setjTFLinTotal(0);
        vMain.setjTFOperadoresTotais(0);
        vMain.setjTFOperadoresUni(0);
        vMain.setjTFOperandos(0);
    }
}
