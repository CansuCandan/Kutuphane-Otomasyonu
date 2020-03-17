package Gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class KullaniciGui {

    MainGui mg = null;

    JPanel kullaniciPanel = null;
    JButton loginButton, adminButton, kayitOlBtn = null;
    JLabel userLabel, passLabel = null;
    JTextField userText = null;
    JPasswordField pass = null;

    Color renk = new Color(52, 73, 93);
    Color renk2 = new Color(245, 245, 245);
    Font baslik = new Font("", Font.BOLD, 18);
    Font btn = new Font("", Font.BOLD, 20);

    public KullaniciGui(MainGui mg) {
        this.mg = mg;
    }

    public JPanel getKp() {
        if (kullaniciPanel == null) {
            kullaniciPanel = new JPanel();
            kullaniciPanel.setBounds(350, 100, 500, 430);
            kullaniciPanel.setBackground(renk);
            kullaniciPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            kullaniciPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            kullaniciPanel.add(getjb());
            kullaniciPanel.add(getAdmin());
            kullaniciPanel.add(getjl());
            kullaniciPanel.add(getjl2());
            kullaniciPanel.add(getTextfield());
            kullaniciPanel.add(getPass());
            kullaniciPanel.add(getKayitOlBtn());
            kullaniciPanel.setLayout(null);
            kullaniciPanel.setVisible(true);

        }

        return kullaniciPanel;
    }

    public void setKp(JPanel kp) {
        this.kullaniciPanel = kp;
    }

    public JLabel getjl() {
        if (userLabel == null) {
            userLabel = new JLabel("Email :");
            userLabel.setBounds(140, 80, 200, 50);
            userLabel.setForeground(Color.WHITE);  //Yazının rengini değiştirmek için kullanılır.
            userLabel.setFont(baslik);

        }
        return userLabel;
    }

    public void setjl(JLabel jl) {
        this.userLabel = jl;

    }

    public JTextField getTextfield() {
        if (userText == null) {
            userText = new JTextField(12);
            userText.setBounds(220, 85, 200, 40);
            userText.setEditable(true);  //true ise kullanici yazi yazabilir. false olursa yazi yazamaz 
        }
        return userText;
    }

    public void setTextfield(JTextField tf) {
        this.userText = tf;
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
        if (adminButton == null) {
            adminButton = new JButton("Admin Giriş");
            adminButton.setBounds(370, 350, 120, 30);
            adminButton.setBackground(Color.WHITE);
            adminButton.addActionListener(mg.getBi());//Butona event eklenir

        }
        return adminButton;
    }

    public void setAdminButton(JButton adminButton) {
        this.adminButton = adminButton;
    }

    public JLabel getjl2() {
        if (passLabel == null) {
            passLabel = new JLabel("Şifreniz:");
            passLabel.setBounds(140, 160, 200, 50);
            passLabel.setForeground(Color.WHITE);  //Yazının rengini değiştirmek için kullanılır.
            passLabel.setFont(baslik);
        }
        return passLabel;
    }

    public void setjl2(JLabel jl2) {
        this.passLabel = jl2;
    }

    public JPasswordField getPass() {
        if (pass == null) {
            pass = new JPasswordField(12);
            pass.setBounds(220, 163, 200, 40);
            pass.setEditable(true);  //true ise kullanici yazi yazabilir. false olursa yazi yazamaz 
        }
        return pass;
    }

    public void setPass(JPasswordField pass) {
        this.pass = pass;
    }

    public JButton getKayitOlBtn() {
        if (kayitOlBtn == null) {
            kayitOlBtn = new JButton("Kayıt Ol");
            kayitOlBtn.setBounds(70, 350, 120, 30);
            kayitOlBtn.setBackground(Color.WHITE);
            kayitOlBtn.addActionListener(mg.getBi());

        }
        return kayitOlBtn;
    }

    public void setKayitOlBtn(JButton kayitOlBtn) {
        this.kayitOlBtn = kayitOlBtn;
    }

}
