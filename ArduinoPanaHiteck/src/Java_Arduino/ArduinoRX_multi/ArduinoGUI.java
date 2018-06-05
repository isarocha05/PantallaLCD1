package Java_Arduino.ArduinoRX_multi;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPortException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class ArduinoGUI extends javax.swing.JFrame implements ActionListener {

    PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    String msg;

    
        
        
    //Conexion de Java a Arduino
    public ArduinoGUI() {
        //manda indicador a la pantalla LCD
        initComponents();
        setLocationRelativeTo(null);
        
        //variables de calendar para la hora de sistema
        Calendar c = new GregorianCalendar();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int segu = c.get(Calendar.SECOND);
        int mint = c.get(Calendar.MINUTE);
        
        msg = Integer.toString(hora) + ":" + Integer.toString(mint);
        //conexion de Java a Arduino
        try {
            //Se inicia la comunicación con el Puerto Serie
            ino.arduinoTX("COM9", 9600);
        } catch (ArduinoException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CapturaTexto = new javax.swing.JTextField();
        comboMsg = new javax.swing.JComboBox<>();
        jbuttonOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CapturaTexto.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N

        comboMsg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hora", "Texto", "Temperatura" }));
        comboMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMsgActionPerformed(evt);
            }
        });

        jbuttonOk.setText("OK");
        jbuttonOk.setActionCommand("Enviar");
        jbuttonOk.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbuttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonOkActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel2.setText("Sensor de Temperatura y LCD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CapturaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbuttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CapturaTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jbuttonOk)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMsgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMsgActionPerformed

    private void jbuttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonOkActionPerformed
    String seleccion = (String) comboMsg.getSelectedItem();
    
    switch (seleccion){
        case "Hora":
             try {
            //manda el mensaje de la hora del sistema btenida anteriormente
            ino.sendData(msg);
            ino.sendData(" ");
            //System.out.println(msg);
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            break;
            
        case "Texto": 
               try {
            //envia al Arduino el texto que se escribio en el text anteriormente}
            ino.sendData(CapturaTexto.getText());
            ino.sendData(" ");
            CapturaTexto.setText("");
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            break; 
            
        case "Temperatura": 
              try {
            //manda al IDE de Arduino el dato 2 para que realice la actividad que se encuentra en el IDE
            ino.sendData("2");
        } catch (ArduinoException | SerialPortException ex) {
            Logger.getLogger(ArduinoGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
            break;
    
    }

        
    }//GEN-LAST:event_jbuttonOkActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArduinoGUI().setVisible(true);
                    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CapturaTexto;
    private javax.swing.JComboBox<String> comboMsg;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbuttonOk;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
    }
}
