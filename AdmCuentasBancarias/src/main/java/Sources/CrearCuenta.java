
package Sources;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author aleja
 */
public class CrearCuenta extends javax.swing.JFrame {
    List<Cuentas> listac = new ArrayList<>();
    
    public CrearCuenta() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCrearC = new javax.swing.JButton();
        cbTipocuenta = new javax.swing.JComboBox<>();
        cbMoneda = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 204)));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crear Cuenta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel1)
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        btnCrearC.setBackground(new java.awt.Color(0, 102, 204));
        btnCrearC.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnCrearC.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearC.setText("Crear Cuenta");
        btnCrearC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCActionPerformed(evt);
            }
        });

        cbTipocuenta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbTipocuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Monetaria", "Ahorro" }));
        cbTipocuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipocuentaActionPerformed(evt);
            }
        });

        cbMoneda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbMoneda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quetzales", "Dolares" }));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setText("Tipo de Cuenta:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setText("Moneda:");

        lbNumero.setBackground(new java.awt.Color(255, 255, 255));
        lbNumero.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        lbNumero.setForeground(new java.awt.Color(153, 0, 0));
        lbNumero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNumero.setText("Numero de cuenta");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("No. Cuenta:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTipocuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMoneda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTipocuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMoneda, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumero)
                    .addComponent(jLabel6))
                .addGap(40, 40, 40)
                .addComponent(btnCrearC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbTipocuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipocuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipocuentaActionPerformed

    private void btnCrearCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCActionPerformed
        //Numero random
        Random rand = new Random();
            String numero = "";
            for (int i = 0; i < 10; i++) {
               numero += rand.nextInt(9);
            }
            lbNumero.setText(numero);
        
        //Obtener datos
        Cuentas c = new Cuentas();
        c.TipoCuenta = cbTipocuenta.getSelectedItem().toString();
        c.Moneda = cbMoneda.getSelectedItem().toString();
        c.NoCuenta = lbNumero.getText();
        listac.add(c); 
        crearArchivo(c);
    }//GEN-LAST:event_btnCrearCActionPerformed

    public void crearArchivo(Cuentas temp){
        //Fecha 
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
 
        //Crear archivo
        String nuevo = "Cuentas.csv";
        try ( FileWriter fw = new FileWriter(nuevo, true)) {
            fw.write(dateTime + "," + temp.NoCuenta + "," + temp.TipoCuenta + "," + temp.Moneda + "\n");

        } catch (IOException ex) {
            JFrame jFrame = new JFrame();
            JOptionPane.showMessageDialog(jFrame, "Ocurrio un error.");
        }
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Cuenta agregada exitosamente!");
        
        JFrame jFrame1 = new JFrame();
        JOptionPane.showMessageDialog(jFrame1, "Su numero de cuenta es: " +  temp.NoCuenta);
    } 
    public void llenarListaC(List<Cuentas> l) {
        listac = l;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearC;
    private javax.swing.JComboBox<String> cbMoneda;
    private javax.swing.JComboBox<String> cbTipocuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbNumero;
    // End of variables declaration//GEN-END:variables
}
