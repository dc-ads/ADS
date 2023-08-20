/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

class ConversionMethod {
    private String De;
    private String Para;
    private float valor = 0.0f;
    
    public ConversionMethod(float valor, String De, String Para) {
        this.valor = valor;
        this.De = De;
        this.Para = Para;
    }
    
    public float convert() {
        switch (De) {
            case "Celsius":
                switch (Para) {
                    case "Fahrenheit":
                        return valor * 9/5 + 32;
                    case "Kelvin":
                        return valor + 273.15f;
                }
                break;
            case "Fahrenheit":
                switch (Para) {
                    case "Celsius":
                        return (valor - 32) * 5/9;
                    case "Kelvin":
                        return (valor - 32) * 5/9 + 273.15f;
                }
                break;
            case "Kelvin":
                switch (Para) {
                    case "Fahrenheit":
                        return valor * 9/5 - 459.67f;
                    case "Celsius":
                        return valor - 273.15f;
                }
                break;
        }
        return valor;
    }
    
    public float getValue() {
        return valor;
    }
}

/**
 *
 * @author IFTM
 */
public class ConversorTemperatura extends javax.swing.JFrame {

    /**
     * Creates new form ConversorTemperatura
     */
    public ConversorTemperatura() {
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

        ComBoxDe = new javax.swing.JComboBox<>();
        ComBoxPara = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnConverter = new javax.swing.JButton();
        valueOutput = new javax.swing.JTextField();
        valueInput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ComBoxDe.setEditable(true);
        ComBoxDe.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ComBoxDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Celsius", "Fahrenheit", "Kelvin" }));
        ComBoxDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComBoxDeActionPerformed(evt);
            }
        });

        ComBoxPara.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ComBoxPara.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Celsius", "Fahrenheit", "Kelvin" }));
        ComBoxPara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComBoxParaActionPerformed(evt);
            }
        });

        jLabel1.setText("Converter De:");

        jLabel2.setText("Converter Para:");

        BtnConverter.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnConverter.setText("Converter");
        BtnConverter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConverterActionPerformed(evt);
            }
        });

        valueOutput.setEditable(false);
        valueOutput.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valueOutput.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        valueOutput.setEnabled(false);

        valueInput.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        valueInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComBoxDe, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComBoxPara, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(valueOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(BtnConverter, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComBoxPara, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComBoxDe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(BtnConverter, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComBoxDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComBoxDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComBoxDeActionPerformed

    private void ComBoxParaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComBoxParaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComBoxParaActionPerformed

    private void BtnConverterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConverterActionPerformed
        ConversionMethod conversionMethod = new ConversionMethod(
            Float.parseFloat(valueInput.getText().toString()),
            ComBoxDe.getSelectedItem().toString(),
            ComBoxPara.getSelectedItem().toString()
        );
        
        float result = conversionMethod.convert();
        valueOutput.setText(Float.toString(result));
    }//GEN-LAST:event_BtnConverterActionPerformed

    private void valueInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valueInputActionPerformed

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
            java.util.logging.Logger.getLogger(ConversorTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConversorTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConversorTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConversorTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConversorTemperatura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConverter;
    private javax.swing.JComboBox<String> ComBoxDe;
    private javax.swing.JComboBox<String> ComBoxPara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField valueInput;
    private javax.swing.JTextField valueOutput;
    // End of variables declaration//GEN-END:variables
}
