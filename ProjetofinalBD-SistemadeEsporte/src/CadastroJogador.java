public class CadastroJogador extends javax.swing.JDialog {
private javax.swing.JPanel contentPane;
private javax.swing.JButton buttonOK;
private javax.swing.JButton buttonCancel;

public CadastroJogador(){
setContentPane(contentPane);
setModal(true);
getRootPane().setDefaultButton(buttonOK);

buttonOK.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(java.awt.event.ActionEvent e){onOK();}});

buttonCancel.addActionListener(new java.awt.event.ActionListener(){public void actionPerformed(java.awt.event.ActionEvent e){onCancel();}});

 // call onCancel() when cross is clicked
setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
addWindowListener(new java.awt.event.WindowAdapter() {
  public void windowClosing(java.awt.event.WindowEvent e) {
   onCancel();
  }
});

 // call onCancel() on ESCAPE
contentPane.registerKeyboardAction(  new java.awt.event.ActionListener() {    public void actionPerformed(java.awt.event.ActionEvent e) {      onCancel();
    }  },  javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0),  javax.swing.JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);}

private void onOK(){
 // add your code here
dispose();
}

private void onCancel(){
 // add your code here if necessary
dispose();
}

public static void main(String[] args){
CadastroJogador dialog = new CadastroJogador();
dialog.pack();
dialog.setVisible(true);
System.exit(0);
}
}
