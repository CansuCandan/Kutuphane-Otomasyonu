package Gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminGui {

    MainGui mg = null;

    public AdminGui(MainGui mg) {
        this.mg = mg;
    }

    JPanel adminPanel = null;
    JButton loginButton, geriButton = null;
    JLabel adminLabel, adminPassLabel = null;
    JTextField adminText = null;
    JPasswordField adminPassText = null;

    Color renk = new Color(52, 73, 93);
    Color renk2 = new Color(245, 245, 245);
    Font baslik = new Font("", Font.BOLD, 18);
    Font btn = new Font("", Font.BOLD, 20);

    public JPanel getAp() {
        if (adminPanel == null) {
            adminPanel = new JPanel();
            adminPanel.setBounds(350, 100, 500, 430);
            adminPanel.setBackground(renk);
            adminPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            adminPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            adminPanel.add(getjb());
            adminPanel.add(getAdmin());
            adminPanel.add(getjl());
            adminPanel.add(getjl2());
            adminPanel.add(getTextfield());
            adminPanel.add(getPass());
            adminPanel.setLayout(null);
            adminPanel.setVisible(false);
        }

        return adminPanel;
    }

    public void setAp(JPanel ap) {
        this.adminPanel = ap;
    }

    public void setTextfield(JTextField tf) {
        this.adminText = tf;
    }

    public JLabel getjl() {
        if (adminLabel == null) {
            adminLabel = new JLabel("Kullanıcı Adınız:");
            adminLabel.setBounds(70, 80, 200, 50);
            adminLabel.setForeground(Color.WHITE);  //Yazının rengini değiştirmek için kullanılır.
            adminLabel.setFont(baslik);

        }
        return adminLabel;
    }

    public void setjl(JLabel jl) {
        this.adminLabel = jl;

    }

    public JTextField getTextfield() {
        if (adminText == null) {
            adminText = new JTextField(12);
            adminText.setBounds(220, 85, 200, 40);
            adminText.setEditable(true);  //true ise kullanici yazi yazabilir. false olursa yazi yazamaz 
        }
        return adminText;
    }

    public JButton getjb() {
        if (loginButton == null) {
            loginButton = new JButton("Giriş");
            loginButton.setBounds(250, 250, 150, 45); //(x,y,h,w)X,Y Boşluk bırakır, H,W Yükseklik ve Genişlik verir.
            loginButton.setBackground(Color.WHITE);
            loginButton.setFont(btn);
            loginButton.addActionListener(mg.getBi());

        }
        return loginButton;
    }

    public void setjb(JButton jb) {
        this.loginButton = jb;
    }

    public JButton getAdmin() {
        if (geriButton == null) {
            geriButton = new JButton("Geri");
            geriButton.setBounds(370, 350, 120, 30);
            geriButton.setBackground(Color.WHITE);
            geriButton.addActionListener(mg.getBi());

        }
        return geriButton;
    }

    public void setGeriButton(JButton geriButton) {
        this.geriButton = geriButton;
    }

    public JLabel getjl2() {
        if (adminPassLabel == null) {
            adminPassLabel = new JLabel("Şifreniz:");
            adminPassLabel.setBounds(140, 160, 200, 50);
            adminPassLabel.setForeground(Color.WHITE);
            adminPassLabel.setFont(baslik);
        }
        return adminPassLabel;
    }

    public void setAdminPassLabel(JLabel adminPassLabel) {
        this.adminPassLabel = adminPassLabel;
    }

    public JPasswordField getPass() {
        if (adminPassText == null) {
            adminPassText = new JPasswordField(12);
            adminPassText.setBounds(220, 163, 200, 40);
            adminPassText.setEditable(true);
        }
        return adminPassText;
    }

    public void setAdminPassText(JPasswordField adminPassText) {
        this.adminPassText = adminPassText;
    }
}
