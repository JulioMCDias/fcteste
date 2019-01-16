package com.fcteste.controller;

import com.fcteste.model.AnalyzerFiles;
import com.fcteste.model.CreateFileCSV;
import com.fcteste.model.FilesJava;
import com.fcteste.view.ViewMain;
import com.fcteste.view.ViewProgressBar;
import java.io.File;
import java.io.Serializable;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.SAVE_DIALOG;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Julio M. C. Dias
 */
public class ControllView implements Serializable {

    private static final long serialVersionUID = 1L;
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

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            vMain = new ViewMain(cView);
            vMain.setLocationRelativeTo(null);
            vMain.setVisible(true);
        });

    }

    public void analyzeProject(String directory) {
        analyFiles = new AnalyzerFiles();
        filesJ = new FilesJava(directory);

        new Thread(() -> {
            filesJ.findFiles();
            analyFiles.applyAnaly(filesJ);
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

        if (analyFiles != null) {
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
        if (analyFiles != null && filesJ != null) {
            JFileChooser chooser = new JFileChooser() {
                @Override
                public void approveSelection() {
                    File f = getSelectedFile();
                    if (f.exists() && getDialogType() == SAVE_DIALOG) {
                        int result = JOptionPane.showConfirmDialog(this, "O arquivo já existe, deseja sobrescrever?", "Arquivo existente", JOptionPane.YES_NO_CANCEL_OPTION);
                        switch (result) {
                            case JOptionPane.YES_OPTION:
                                super.approveSelection();
                                return;
                            case JOptionPane.NO_OPTION:
                                return;
                            case JOptionPane.CLOSED_OPTION:
                                return;
                            case JOptionPane.CANCEL_OPTION:
                                cancelSelection();
                                return;
                        }
                    }
                    super.approveSelection();
                }

            };
            //chooser.setCurrentDirectory(new java.io.File("."));
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setDialogTitle("Salvar projeto CSV");
            chooser.setSelectedFile(new File("projeto.csv"));

            FileNameExtensionFilter csvFilter = new FileNameExtensionFilter("csv files (*.csv)", "CSV");
            // add filters
            chooser.addChoosableFileFilter(csvFilter);
            chooser.setFileFilter(csvFilter);

            chooser.setAcceptAllFileFilterUsed(false);  // disable the "All files" option.
            if (chooser.showSaveDialog(vMain) == JFileChooser.APPROVE_OPTION) {
                cfCSV.creatFileCSV(chooser.getSelectedFile(), analyFiles.getListCAnalyzer(), filesJ.getFilesName());
            }
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
