package Gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BilgilerimPanel extends JPanel {

    MainGui mg = null;
    
    DefaultTableModel model = new DefaultTableModel();
    JLabel tc,adi,soyadi,mail,sifre=null;
    JTextField tcTf,adiTf,soyadiTf,mailTf=null;
    JPasswordField sifrePf=null;
    JButton guncelleBtn=null;
    
    Font yazi = new Font("", Font.BOLD, 16);

    public BilgilerimPanel(MainGui mg) {
        this.mg = mg;
        setBounds(400, 0, 800, 800);
        add(getTc());
        add(getTcTf());
        add(getAdi());
        add(getAdiTf());
        add(getSoyadi());
        add(getSoyadiTf());
        add(getMail());
        add(getMailTf());
        add(getSifre());
        add(getSifrePf());
        add(getGuncelleBtn());
        setLayout(null);
        setVisible(false);
    }

    public JLabel getTc() {
        if (tc == null) {
            tc = new JLabel();
            tc.setText("TC Numaranız :");
            tc.setBounds(220, 150, 150, 25);
            tc.setFont(yazi);
        }
        return tc;
    }

    public void setTc(JLabel tc) {
        this.tc = tc;
    }

    public JLabel getAdi() {
        if (adi == null) {
            adi = new JLabel();
            adi.setText("Adınız :");
            adi.setBounds(220, 200, 150, 25);
            adi.setFont(yazi);
        }
        return adi;
    }

    public void setAdi(JLabel adi) {
        this.adi = adi;
    }

    public JLabel getSoyadi() {
        if (soyadi == null) {
            soyadi = new JLabel();
            soyadi.setText("Soyadınız :");
            soyadi.setBounds(220, 250, 150, 25);
            soyadi.setFont(yazi);
        }
        return soyadi;
    }

    public void setSoyadi(JLabel soyadi) {
        this.soyadi = soyadi;
    }

    public JLabel getMail() {
        if (mail == null) {
            mail = new JLabel();
            mail.setText("Email :");
            mail.setBounds(220, 300, 150, 25);
            mail.setFont(yazi);
        }
        return mail;
    }

    public void setMail(JLabel mail) {
        this.mail = mail;
    }

    public JLabel getSifre() {
        if (sifre == null) {
            sifre = new JLabel();
            sifre.setText("Şifreniz :");
            sifre.setBounds(220, 350, 150, 25);
            sifre.setFont(yazi);
        }
        return sifre;
    }

    public void setSifre(JLabel sifre) {
        this.sifre = sifre;
    }

    public JTextField getTcTf() {
        if (tcTf == null) {
            tcTf = new JTextField();
            tcTf.setBounds(370, 150, 225, 35);
            tcTf.setFont(yazi);

        }
        return tcTf;
    }

    public void setTcTf(JTextField tcTf) {
        this.tcTf = tcTf;
    }

    public JTextField getAdiTf() {
        if (adiTf == null) {
            adiTf = new JTextField();
            adiTf.setBounds(370, 200, 225, 35);
            adiTf.setFont(yazi);
        }
        return adiTf;
    }

    public void setAdiTf(JTextField adiTf) {
        this.adiTf = adiTf;
    }

    public JTextField getSoyadiTf() {
        if (soyadiTf == null) {
            soyadiTf = new JTextField();
            soyadiTf.setBounds(370, 250, 225, 35);
            soyadiTf.setFont(yazi);
        }
        return soyadiTf;
    }

    public void setSoyadiTf(JTextField soyadiTf) {
        this.soyadiTf = soyadiTf;
    }

    public JTextField getMailTf() {
        if (mailTf == null) {
            mailTf = new JTextField();
            mailTf.setBounds(370, 300, 225, 35);
            mailTf.setFont(yazi);
        }
        return mailTf;
    }

    public void setMailTf(JTextField mailTf) {
        this.mailTf = mailTf;
    }

    public JPasswordField getSifrePf() {
        if (sifrePf == null) {
            sifrePf = new JPasswordField();
            sifrePf.setBounds(370, 350, 225, 35);
            sifrePf.setFont(yazi);
        }
        return sifrePf;
    }

    public void setSiftePf(JPasswordField sifrePf) {
        this.sifrePf = sifrePf;
    }

    public JButton getGuncelleBtn() {
        if (guncelleBtn == null) {
            guncelleBtn = new JButton("KAYDET");
            guncelleBtn.setBackground(Color.white);
            guncelleBtn.setBounds(400, 425, 180, 40);
            guncelleBtn.setFont(yazi);
            guncelleBtn.addActionListener(mg.getBi());
        }
        return guncelleBtn;
    }

    public void setGuncelleBtn(JButton guncelleBtn) {
        this.guncelleBtn = guncelleBtn;
    }

}
