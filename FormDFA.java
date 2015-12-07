package DFAProject;


import java.net.MalformedURLException;
import java.net.URL;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author j23schoen
 */
public class FormDFA extends javax.swing.JFrame {

    private DFA project;
    private int dataLoadedCounter;
    /**
     * Creates new form FormDFA
     */
    public FormDFA() {
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputArea = new javax.swing.JTextArea();
        readDatabutton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        loadDataButton = new javax.swing.JButton();
        allStepsButton = new javax.swing.JButton();
        oneStepButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        urlSelectionBox = new javax.swing.JComboBox();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputArea.setColumns(20);
        inputArea.setRows(5);
        jScrollPane1.setViewportView(inputArea);

        readDatabutton.setText("read data");
        readDatabutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readDatabuttonActionPerformed(evt);
            }
        });

        outputArea.setColumns(20);
        outputArea.setRows(5);
        jScrollPane2.setViewportView(outputArea);

        loadDataButton.setText("load data");
        loadDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDataButtonActionPerformed(evt);
            }
        });

        allStepsButton.setText("all steps");
        allStepsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allStepsButtonActionPerformed(evt);
            }
        });

        oneStepButton.setText("one step");
        oneStepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneStepButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Output Area");

        urlSelectionBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a url", "http://raider.mountunion.edu/csc/CSC450/Spring2015/projects/dfa01a.txt", "http://raider.mountunion.edu/csc/CSC450/Spring2015/projects/dfa01b.txt", "http://raider.mountunion.edu/csc/CSC450/Spring2015/projects/dfa02a.txt", "http://raider.mountunion.edu/csc/CSC450/Spring2015/projects/dfa02b.txt" }));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jScrollPane2)
                        .add(43, 43, 43))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel1)
                            .add(jScrollPane1)
                            .add(urlSelectionBox, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, readDatabutton)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, loadDataButton)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(oneStepButton)
                            .add(allStepsButton))
                        .add(0, 0, Short.MAX_VALUE)))
                .add(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(readDatabutton)
                    .add(urlSelectionBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(loadDataButton)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 255, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(22, 22, 22)
                .add(jLabel1)
                .add(9, 9, 9)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 162, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(oneStepButton)
                        .add(19, 19, 19)
                        .add(allStepsButton)))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readDatabuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readDatabuttonActionPerformed
        // TODO add your handling code here:
        inputArea.setText("");
        outputArea.setText("");
        readDataFromURLandFillDataArea(urlSelectionBox.getSelectedItem().toString());
    }//GEN-LAST:event_readDatabuttonActionPerformed

    private void readDataFromURLandFillDataArea(String theURL)
    {
        String inputData = "";
        
        try {
            URL url = new URL(theURL);
            In fileInput = new In(url);
        
            if (fileInput.exists() )
            {
                System.out.println("fileInput.exists()   ");
                inputData = fileInput.readAll();

            }else
            {
                System.out.println("   NOT   fileInput.exists()   ");

                inputData = "could not find url:\n"+url+"\n\n";
                System.out.println(inputData);
                
            }
        } catch (MalformedURLException ex) {
            System.out.println("error trying to read URL");
        }
        
        //finally fill the dataArea with the data we have read from the URL
        inputArea.setText(inputData);
    }
    
    private void loadDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDataButtonActionPerformed
        // TODO add your handling code here:
        dataLoadedCounter = 0;
        if (inputArea.getText().equals(""))
        {
            
        }
        else
        {
            String theData[] = inputArea.getText().split("\n");
            project = new DFA(theData); 
            dataLoadedCounter = 1;
        }
        
        
    }//GEN-LAST:event_loadDataButtonActionPerformed

    private void oneStepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneStepButtonActionPerformed
        // TODO add your handling code here:
        String temp = "";
        if(dataLoadedCounter == 0){
            temp = "you must load the data before performing any steps.\n";
        }
        else{
            temp = project.oneStep();
        }
        
        outputArea.append(temp);
    }//GEN-LAST:event_oneStepButtonActionPerformed

    private void allStepsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allStepsButtonActionPerformed
        // TODO add your handling code here:
        String temp = "";
        if(dataLoadedCounter == 0){
            temp = "you must load the data before performing any steps.\n";
        }
        else{
           temp = project.allSteps(); 
        }
        
        outputArea.append(temp);
    }//GEN-LAST:event_allStepsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FormDFA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDFA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDFA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDFA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDFA().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allStepsButton;
    private javax.swing.JTextArea inputArea;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadDataButton;
    private javax.swing.JButton oneStepButton;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JButton readDatabutton;
    private javax.swing.JComboBox urlSelectionBox;
    // End of variables declaration//GEN-END:variables
}