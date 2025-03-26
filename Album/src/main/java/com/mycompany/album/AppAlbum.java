/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.album;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.Timer;

/**
 *
 * @author aleja
 */
public class AppAlbum extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private GestorAlbumes gestorAlbumes;
    private Foto fotoActual;
    private Timer timer;
    private boolean loopInfinito = false;
    private boolean reproduccionManual = false;

    private void agregarAlbum() {
        String nombreAlbum = nombreAlbumField.getText();
        if (!nombreAlbum.isEmpty()) {
            Album album = new Album(nombreAlbum);
            gestorAlbumes.agregarAlbum(album);
            albumesComboBox.addItem(nombreAlbum);
            nombreAlbumField.setText("");
        }
    }

    private void seleccionarFotos() {
        String nombreAlbum = (String) albumesComboBox.getSelectedItem();
        if (nombreAlbum != null) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "jpg", "png"));
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();
                for (File file : files) {
                    for (Album album : gestorAlbumes.albumes) {
                        if (album.nombre.equals(nombreAlbum)) {
                            album.agregarFoto(file.getAbsolutePath());
                            break;
                        }
                    }
                }
            }
        }
    }

    private void reproducirAlbum() {
        String nombreAlbum = (String) albumesComboBox.getSelectedItem();
        if (nombreAlbum != null) {
            Album album = gestorAlbumes.albumes.stream()
                    .filter(a -> a.nombre.equals(nombreAlbum))
                    .findFirst().orElse(null);
            if (album != null && album.inicio != null) {
                fotoActual = album.inicio;
                mostrarFoto(fotoActual);
                if (!reproduccionManual) {
                    timer = new Timer(5000, e -> siguienteFoto());
                    timer.start();
                }
            }
        }
    }

    private void pausarAlbum() {
        if (timer != null) {
            if (timer.isRunning()) {
                timer.stop();
            } else {
                timer.start();
            }
        }
    }

    private void detenerAlbum() {
        if (timer != null) {
            timer.stop();
            timer = null;
        }
        fotoActual = null;
        fotoLabel.setIcon(null);
    }

    private void siguienteFoto() {
        if (fotoActual != null) {
            fotoActual = fotoActual.siguiente;
            mostrarFoto(fotoActual);
            if (fotoActual == fotoActual.anterior && !loopInfinito) {
                detenerAlbum();
            }
        }
    }

    private void anteriorFoto() {
        if (fotoActual != null) {
            fotoActual = fotoActual.anterior;
            mostrarFoto(fotoActual);
            if (fotoActual == fotoActual.siguiente && !loopInfinito) {
                detenerAlbum();
            }
        }
    }

    private void irPrimeraFoto() {
        if (fotoActual != null) {
            Album album = gestorAlbumes.albumes.stream()
                    .filter(a -> a.nombre.equals((String) albumesComboBox.getSelectedItem()))
                    .findFirst().orElse(null);
            if (album != null) {
                fotoActual = album.inicio;
                mostrarFoto(fotoActual);
            }
        }
    }

    private void irUltimaFoto() {
        if (fotoActual != null) {
            Album album = gestorAlbumes.albumes.stream()
                    .filter(a -> a.nombre.equals((String) albumesComboBox.getSelectedItem()))
                    .findFirst().orElse(null);
            if (album != null && album.inicio != null) {
                fotoActual = album.inicio.anterior;
                mostrarFoto(fotoActual);
            }
        }
    }

    private void mostrarFoto(Foto foto) {
        if (foto != null) {
            ImageIcon icon = new ImageIcon(foto.ruta);
            Image img = icon.getImage().getScaledInstance(fotoLabel.getWidth(), fotoLabel.getHeight(), Image.SCALE_SMOOTH);
            fotoLabel.setIcon(new ImageIcon(img));
        }
    }

    public AppAlbum() {
        initComponents();
        gestorAlbumes = new GestorAlbumes();
        gestorAlbumes.cargarAlbumes();
        for (Album album : gestorAlbumes.albumes) {
            albumesComboBox.addItem(album.nombre);
        }

        // Guardar álbumes al cerrar la aplicación
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                gestorAlbumes.guardarAlbumes();
                System.exit(0);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior1 = new javax.swing.JPanel();
        agregarAlbumButton = new javax.swing.JButton();
        seleccionarFotosButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombreAlbumField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panelInferior = new javax.swing.JPanel();
        albumesComboBox = new javax.swing.JComboBox<>();
        reproducirButton = new javax.swing.JButton();
        pausarButton = new javax.swing.JButton();
        detenerButton = new javax.swing.JButton();
        loopInfinitoButton = new javax.swing.JToggleButton();
        reproduccionManualButton = new javax.swing.JToggleButton();
        siguienteFotoButton = new javax.swing.JButton();
        anteriorFotoButton = new javax.swing.JButton();
        irPrimeraFotoButton = new javax.swing.JButton();
        irUltimaFotoButton = new javax.swing.JButton();
        fotoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Album");
        setResizable(false);

        panelSuperior1.setBackground(new java.awt.Color(70, 130, 180));

        agregarAlbumButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        agregarAlbumButton.setText("Agregar Album");
        agregarAlbumButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarAlbumButtonActionPerformed(evt);
            }
        });

        seleccionarFotosButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        seleccionarFotosButton.setText("Selccionar Fotos");
        seleccionarFotosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionarFotosButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre del Álbum:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Album de Imagenes");

        javax.swing.GroupLayout panelSuperior1Layout = new javax.swing.GroupLayout(panelSuperior1);
        panelSuperior1.setLayout(panelSuperior1Layout);
        panelSuperior1Layout.setHorizontalGroup(
            panelSuperior1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperior1Layout.createSequentialGroup()
                .addGroup(panelSuperior1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSuperior1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreAlbumField, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregarAlbumButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seleccionarFotosButton))
                    .addGroup(panelSuperior1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel2)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelSuperior1Layout.setVerticalGroup(
            panelSuperior1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperior1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSuperior1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarAlbumButton)
                    .addComponent(seleccionarFotosButton)
                    .addComponent(jLabel1)
                    .addComponent(nombreAlbumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        panelInferior.setBackground(new java.awt.Color(70, 130, 180));

        albumesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                albumesComboBoxActionPerformed(evt);
            }
        });

        reproducirButton.setText("▶ ");
        reproducirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reproducirButtonActionPerformed(evt);
            }
        });

        pausarButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        pausarButton.setText("II");
        pausarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausarButtonActionPerformed(evt);
            }
        });

        detenerButton.setText("∎ ");
        detenerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detenerButtonActionPerformed(evt);
            }
        });

        loopInfinitoButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        loopInfinitoButton.setText("Loop");
        loopInfinitoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loopInfinitoButtonActionPerformed(evt);
            }
        });

        reproduccionManualButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reproduccionManualButton.setText("Manual");
        reproduccionManualButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reproduccionManualButtonActionPerformed(evt);
            }
        });

        siguienteFotoButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        siguienteFotoButton.setText(">");
        siguienteFotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteFotoButtonActionPerformed(evt);
            }
        });

        anteriorFotoButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        anteriorFotoButton.setText("<");
        anteriorFotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorFotoButtonActionPerformed(evt);
            }
        });

        irPrimeraFotoButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        irPrimeraFotoButton.setText("<<");
        irPrimeraFotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irPrimeraFotoButtonActionPerformed(evt);
            }
        });

        irUltimaFotoButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        irUltimaFotoButton.setText(">>");
        irUltimaFotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                irUltimaFotoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(albumesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(irPrimeraFotoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anteriorFotoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(siguienteFotoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(irUltimaFotoButton))
                    .addGroup(panelInferiorLayout.createSequentialGroup()
                        .addComponent(reproducirButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pausarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detenerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loopInfinitoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reproduccionManualButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(albumesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reproducirButton)
                    .addComponent(pausarButton)
                    .addComponent(detenerButton)
                    .addComponent(loopInfinitoButton)
                    .addComponent(reproduccionManualButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(siguienteFotoButton)
                    .addComponent(anteriorFotoButton)
                    .addComponent(irPrimeraFotoButton)
                    .addComponent(irUltimaFotoButton))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        fotoLabel.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        fotoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelSuperior1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelInferior, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(fotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSuperior1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void agregarAlbumButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarAlbumButtonActionPerformed
        agregarAlbum();
    }//GEN-LAST:event_agregarAlbumButtonActionPerformed

    private void seleccionarFotosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionarFotosButtonActionPerformed
        seleccionarFotos();
    }//GEN-LAST:event_seleccionarFotosButtonActionPerformed

    private void albumesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_albumesComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_albumesComboBoxActionPerformed

    private void reproducirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reproducirButtonActionPerformed
        reproducirAlbum();
    }//GEN-LAST:event_reproducirButtonActionPerformed

    private void pausarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausarButtonActionPerformed
        pausarAlbum();
    }//GEN-LAST:event_pausarButtonActionPerformed

    private void detenerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detenerButtonActionPerformed
        detenerAlbum();
    }//GEN-LAST:event_detenerButtonActionPerformed

    private void loopInfinitoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loopInfinitoButtonActionPerformed

    }//GEN-LAST:event_loopInfinitoButtonActionPerformed

    private void reproduccionManualButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reproduccionManualButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reproduccionManualButtonActionPerformed

    private void siguienteFotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteFotoButtonActionPerformed
        siguienteFoto();
    }//GEN-LAST:event_siguienteFotoButtonActionPerformed

    private void anteriorFotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorFotoButtonActionPerformed
        anteriorFoto();
    }//GEN-LAST:event_anteriorFotoButtonActionPerformed

    private void irPrimeraFotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irPrimeraFotoButtonActionPerformed
        irPrimeraFoto();
    }//GEN-LAST:event_irPrimeraFotoButtonActionPerformed

    private void irUltimaFotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_irUltimaFotoButtonActionPerformed
        irUltimaFoto();
    }//GEN-LAST:event_irUltimaFotoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AppAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppAlbum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppAlbum().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarAlbumButton;
    private javax.swing.JComboBox<String> albumesComboBox;
    private javax.swing.JButton anteriorFotoButton;
    private javax.swing.JButton detenerButton;
    private javax.swing.JLabel fotoLabel;
    private javax.swing.JButton irPrimeraFotoButton;
    private javax.swing.JButton irUltimaFotoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JToggleButton loopInfinitoButton;
    private javax.swing.JTextField nombreAlbumField;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelSuperior1;
    private javax.swing.JButton pausarButton;
    private javax.swing.JToggleButton reproduccionManualButton;
    private javax.swing.JButton reproducirButton;
    private javax.swing.JButton seleccionarFotosButton;
    private javax.swing.JButton siguienteFotoButton;
    // End of variables declaration//GEN-END:variables
}
