package Gui;

import Model.Database;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class KayitGui {

    Database database = null;
    MainGui mg = null;
    JPanel kayitPanel = null;
    JFrame kayitFrame = null;
    JButton kayitBtn = null;
    JLabel labelTc, labelAd, labelSoyad, labelMail, labelSifre = null;
    JTextField kullaniciAdi, kullaniciSoyadi, kullaniciTc, kullaniciEmail = null;
    JPasswordField kullaniciPass = null;

    Font labelText = new Font("", Font.BOLD, 18);
    Color labelColor = new Color(255, 255, 255);
    Color renk = new Color(52, 73, 93);

    public KayitGui(MainGui mg) {
        this.mg = mg;
        database = mg.data;
    }

    public JPanel getKayitPanel() {
        if (kayitPanel == null) {
            kayitPanel = new JPanel();
            kayitPanel.setLayout(null);
            kayitPanel.setBounds(300, 100, 600, 550);
            kayitPanel.setBackground(renk);
            kayitPanel.add(getKullaniciTc());
            kayitPanel.add(getKullaniciAdi());
            kayitPanel.add(getKullaniciSoyadi());
            kayitPanel.add(getKullaniciPass());
            kayitPanel.add(getKullaniciEmail());
            kayitPanel.add(getLabelTc());
            kayitPanel.add(getLabelAd());
            kayitPanel.add(getLabelSoyad());
            kayitPanel.add(getLabelMail());
            kayitPanel.add(getLabelSifre());
            kayitPanel.add(getKayitBtn());
            kayitPanel.setBorder(BorderFactory.createEmptyBorder(28, 28, 28, 28));
            kayitPanel.setBorder(BorderFactory.createLineBorder(Color.white));
            kayitPanel.setVisible(false);

        }
        return kayitPanel;
    }

    public void setKayitPanel(JPanel kayitPanel) {
        this.kayitPanel = kayitPanel;
    }

    public JLabel getLabelTc() {
        if (labelTc == null) {
            labelTc = new JLabel();
            labelTc.setBounds(90, 70, 200, 40);
            labelTc.setText("TC Numarası : ");
            labelTc.setForeground(labelColor);
            labelTc.setFont(labelText);
        }
        return labelTc;
    }

    public void setLabelTc(JLabel labelTc) {
        this.labelTc = labelTc;
    }

    public JTextField getKullaniciTc() {
        if (kullaniciTc == null) {
            kullaniciTc = new JTextField(12);
            kullaniciTc.setBounds(280, 78, 200, 40);
            kullaniciTc.setEditable(true);
        }
        return kullaniciTc;
    }

    public void setKullaniciTc(JTextField kullaniciTc) {
        this.kullaniciTc = kullaniciTc;
    }

    public JLabel getLabelAd() {
        if (labelAd == null) {
            labelAd = new JLabel();
            labelAd.setBounds(90, 130, 200, 40);
            labelAd.setText("Ad :");
            labelAd.setForeground(labelColor);
            labelAd.setFont(labelText);

        }
        return labelAd;
    }

    public void setLabelAd(JLabel labelAd) {
        this.labelAd = labelAd;
    }

    public JTextField getKullaniciAdi() {
        if (kullaniciAdi == null) {
            kullaniciAdi = new JTextField(12);
            kullaniciAdi.setBounds(280, 138, 200, 40);
            kullaniciAdi.setEditable(true);
        }
        return kullaniciAdi;
    }

    public void setKullaniciAdi(JTextField kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public JLabel getLabelSoyad() {
        if (labelSoyad == null) {
            labelSoyad = new JLabel();
            labelSoyad.setBounds(90, 190, 200, 40);
            labelSoyad.setText("Soyad :");
            labelSoyad.setForeground(labelColor);
            labelSoyad.setFont(labelText);
        }
        return labelSoyad;
    }

    public void setLabelSoyad(JLabel labelSoyad) {
        this.labelSoyad = labelSoyad;
    }

    public JTextField getKullaniciSoyadi() {
        if (kullaniciSoyadi == null) {
            kullaniciSoyadi = new JTextField(12);
            kullaniciSoyadi.setBounds(280, 198, 200, 40);
            kullaniciSoyadi.setEditable(true);
        }
        return kullaniciSoyadi;
    }

    public void setKullaniciSoyadi(JTextField kullaniciSoyadi) {
        this.kullaniciSoyadi = kullaniciSoyadi;
    }

    public JLabel getLabelMail() {
        if (labelMail == null) {
            labelMail = new JLabel();
            labelMail.setBounds(90, 250, 200, 40);
            labelMail.setText("Mail Adresi :");
            labelMail.setForeground(labelColor);
            labelMail.setFont(labelText);
        }
        return labelMail;
    }

    public void setLabelMail(JLabel labelMail) {
        this.labelMail = labelMail;
    }

    public JTextField getKullaniciEmail() {
        if (kullaniciEmail == null) {
            kullaniciEmail = new JTextField(12);
            kullaniciEmail.setBounds(280, 258, 200, 40);
            kullaniciEmail.setEditable(true);
        }
        return kullaniciEmail;
    }

    public void setKullaniciEmail(JTextField kullaniciEmail) {
        this.kullaniciEmail = kullaniciEmail;
    }

    public JLabel getLabelSifre() {
        if (labelSifre == null) {
            labelSifre = new JLabel();
            labelSifre.setBounds(90, 310, 200, 40);
            labelSifre.setText("Şifre :");
            labelSifre.setForeground(labelColor);
            labelSifre.setFont(labelText);
        }
        return labelSifre;
    }

    public void setLabelSifre(JLabel labelSifre) {
        this.labelSifre = labelSifre;
    }

    public JPasswordField getKullaniciPass() {
        if (kullaniciPass == null) {
            kullaniciPass = new JPasswordField(12);
            kullaniciPass.setBounds(280, 318, 200, 40);
            kullaniciPass.setEditable(true);
        }
        return kullaniciPass;
    }

    public void setKullaniciPass(JPasswordField kullaniciPass) {
        this.kullaniciPass = kullaniciPass;
    }

    public JButton getKayitBtn() {
        if (kayitBtn == null) {
            kayitBtn = new JButton();
            kayitBtn.setBounds(200, 400, 200, 40);
            kayitBtn.setText("KAYIT OL");
            kayitBtn.setForeground(Color.BLACK);
            kayitBtn.setFont(labelText);
            kayitBtn.setBackground(Color.WHITE);
            kayitBtn.addActionListener(mg.getBi());
        }
        return kayitBtn;
    }

    public void setKayitBtn(JButton kayitBtn) {
        this.kayitBtn = kayitBtn;
    }

}
