package Gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class KullaniciAnasayfa extends JPanel {

    MainGui mg = null;

    JLabel hosgeldiniz = null;
    JLabel kullaniciadi = null;
    JButton btnKitaplar, btnKitapligim, btnIadeler, btnBilgilerim, btnCikis = null;

    Color btnrenk = new Color(49, 106, 217);
    Color sayfalar = new Color(51, 0, 173);
    Color renk2 = new Color(245, 245, 245);
    Font hosgeldinizYazisi = new Font("", Font.BOLD, 24);
    Font btn = new Font("", Font.BOLD, 20);

    public KullaniciAnasayfa(MainGui mg) {
        this.mg = mg;
        setBounds(0, 0, 400, 800);
        setBackground(sayfalar);
        add(getHosgeldiniz());
        add(getBtnKitaplar());
        add(getBtnKitapligim());
        add(getBtnIadeler());
        add(getBtnBilgilerim());
        add(getBtnCikis());
        add(getKullaniciAdi());
        setLayout(null);

    }

    public JLabel getKullaniciAdi() {
        if (kullaniciadi == null) {
            kullaniciadi = new JLabel("", SwingConstants.CENTER);
            kullaniciadi.setText("");
            kullaniciadi.setBounds(115, 130, 200, 25);
            kullaniciadi.setForeground(Color.getHSBColor(251, 100, 78));
            kullaniciadi.setFont(new Font("", Font.BOLD, 24));

        }
        return kullaniciadi;
    }

    public void setKullaniciAdi(JLabel kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    public JLabel getHosgeldiniz() {
        if (hosgeldiniz == null) {
            hosgeldiniz = new JLabel("", SwingConstants.CENTER);
            hosgeldiniz.setText("HOŞGELDİNİZ");
            hosgeldiniz.setBounds(115, 100, 200, 25);
            hosgeldiniz.setForeground(renk2);
            hosgeldiniz.setFont(hosgeldinizYazisi);

        }
        return hosgeldiniz;
    }

    public void setHosgeldiniz(JLabel hosgeldiniz) {
        this.hosgeldiniz = hosgeldiniz;
    }

    public JButton getBtnKitaplar() {
        if (btnKitaplar == null) {
            btnKitaplar = new JButton("Kitaplar");
            btnKitaplar.setBounds(0, 250, 400, 50);
            btnKitaplar.setBorder(null);
            btnKitaplar.setForeground(renk2);
            btnKitaplar.setBackground(btnrenk);
            btnKitaplar.setFont(btn);
            btnKitaplar.addActionListener(mg.getBi());
        }
        return btnKitaplar;
    }

    public void setBtnKitaplar(JButton btnKitaplar) {
        this.btnKitaplar = btnKitaplar;
    }

    public JButton getBtnKitapligim() {
        if (btnKitapligim == null) {
            btnKitapligim = new JButton("Kitaplığım");
            btnKitapligim.setBounds(0, 310, 400, 50);
            btnKitapligim.setBorder(null);
            btnKitapligim.setForeground(renk2);
            btnKitapligim.setBackground(btnrenk);
            btnKitapligim.setFont(btn);
            btnKitapligim.addActionListener(mg.getBi());
        }
        return btnKitapligim;
    }

    public void setBtnKitapligim(JButton btnKitapligim) {
        this.btnKitapligim = btnKitapligim;
    }

    public JButton getBtnIadeler() {
        if (btnIadeler == null) {
            btnIadeler = new JButton("İadelerim");
            btnIadeler.setBounds(0, 370, 400, 50);
            btnIadeler.setBorder(null);
            btnIadeler.setForeground(renk2);
            btnIadeler.setBackground(btnrenk);
            btnIadeler.setFont(btn);
            btnIadeler.addActionListener(mg.getBi());
        }
        return btnIadeler;
    }

    public void setBtnIadeler(JButton btnIadeler) {
        this.btnIadeler = btnIadeler;
    }

    public JButton getBtnBilgilerim() {
        if (btnBilgilerim == null) {
            btnBilgilerim = new JButton("Bilgilerim");
            btnBilgilerim.setBounds(0, 430, 400, 50);
            btnBilgilerim.setBorder(null);
            btnBilgilerim.setForeground(renk2);
            btnBilgilerim.setBackground(btnrenk);
            btnBilgilerim.setFont(btn);
            btnBilgilerim.addActionListener(mg.getBi());
        }
        return btnBilgilerim;
    }

    public void setBtnBilgilerim(JButton btnBilgilerim) {
        this.btnBilgilerim = btnBilgilerim;
    }

    public JButton getBtnCikis() {
        if (btnCikis == null) {
            btnCikis = new JButton("Çıkış");
            btnCikis.setBounds(0, 490, 400, 50);
            btnCikis.setBorder(null);
            btnCikis.setForeground(renk2);
            btnCikis.setBackground(btnrenk);
            btnCikis.setFont(btn);
            btnCikis.addActionListener(mg.getBi());
        }
        return btnCikis;
    }

    public void setBtnCikis(JButton btnCikis) {
        this.btnCikis = btnCikis;
    }

}
