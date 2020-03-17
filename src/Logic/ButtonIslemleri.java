package Logic;

import Gui.MainGui;
import Model.Database;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ButtonIslemleri implements ActionListener {

    MainGui mg = null;
    Database database = null;
    DefaultTableModel model, model2;

    public ButtonIslemleri(MainGui mg) {
        this.mg = mg;
        database = mg.data;
        model = (DefaultTableModel) mg.getAdminSayfa().getTable().getModel();
    }

    Color btnrenk = new Color(51, 0, 173);

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == mg.getKullaniciGui().getAdmin()) {
            mg.getKullaniciGui().getKp().setVisible(false);
            mg.getAdminGui().getAp().setVisible(true);
        }
        if (ae.getSource() == mg.getAdminGui().getAdmin()) {
            mg.getAdminGui().getAp().setVisible(false);
            mg.getKullaniciGui().getKp().setVisible(true);
        }
        if (ae.getSource() == mg.getAdminGui().getjb()) {
            String adminAdi = mg.getAdminGui().getTextfield().getText();
            String adminPass = new String(mg.getAdminGui().getPass().getPassword());

            boolean checkLogin = database.adminGirisYap(adminAdi, adminPass);
            if (checkLogin == true) {
                mg.getAdminGui().getAp().setVisible(false);
                mg.getAdminSayfa().getKitapP().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Giris basarisiz");
            }

        }
        if (ae.getSource() == mg.getKullaniciGui().getjb()) {
            String email = mg.getKullaniciGui().getTextfield().getText();
            String kullaniciPass = new String(mg.getKullaniciGui().getPass().getPassword());

            boolean checkLogin = database.kullaniciGirisYap(email, kullaniciPass);
            if (checkLogin == true) {
                mg.getKullaniciGui().getKp().setVisible(false);
                mg.getKullaniciSayfa().setVisible(true);
                System.out.println("Kullanıcı Adı Sorgusu Yapılacak");
                mg.getKullaniciAnasayfa().getKullaniciAdi().setText(database.kullaniciAdigetir(email));
                String Bilgiler[] = new String[5];
                Bilgiler = database.kullaniciBilgiGetir(email);
                mg.getBilgilerimPanel().getTcTf().setText(Bilgiler[0]);
                mg.getBilgilerimPanel().getAdiTf().setText(Bilgiler[1]);
                mg.getBilgilerimPanel().getSoyadiTf().setText(Bilgiler[2]);
                mg.getBilgilerimPanel().getMailTf().setText(Bilgiler[3]);
                mg.getBilgilerimPanel().getSifrePf().setText(Bilgiler[4]);

            } else {
                JOptionPane.showMessageDialog(null, "Giris basarisiz");
            }
        }
        if (ae.getSource() == mg.getKullaniciAnasayfa().getBtnKitaplar()) {
            mg.getBilgilerimPanel().setVisible(false);
            mg.getIadelerimPanel().setVisible(false);
            mg.getKitapligimPanel().setVisible(false);
            mg.getKitaplarPanel().setVisible(true);
            mg.getAdminSayfa().kitapGoruntule();

        }

        if (ae.getSource() == mg.getKullaniciAnasayfa().getBtnKitapligim()) {
            mg.getBilgilerimPanel().setVisible(false);
            mg.getIadelerimPanel().setVisible(false);
            mg.getKitaplarPanel().setVisible(false);
            mg.getKitapligimPanel().setVisible(true);
            mg.getKitapligimPanel().kitapGoruntule();

        }
        if (ae.getSource() == mg.getKullaniciAnasayfa().getBtnIadeler()) {
            mg.getBilgilerimPanel().setVisible(false);
            mg.getKitaplarPanel().setVisible(false);
            mg.getKitapligimPanel().setVisible(false);
            mg.getIadelerimPanel().setVisible(true);
            mg.getIadelerimPanel().kitapGoruntule();
        }
        if (ae.getSource() == mg.getKullaniciAnasayfa().getBtnBilgilerim()) {

            mg.getKitapligimPanel().setVisible(false);
            mg.getKitaplarPanel().setVisible(false);
            mg.getIadelerimPanel().setVisible(false);
            mg.getBilgilerimPanel().setVisible(true);

        }
        if (ae.getSource() == mg.getKullaniciAnasayfa().getBtnCikis()) {
            System.exit(0);
        }
        if (ae.getSource() == mg.getKullaniciGui().getKayitOlBtn()) {
            mg.getAdminGui().getAp().setVisible(false);
            mg.getKullaniciGui().getKp().setVisible(false);
            mg.getKayitPanel().getKayitPanel().setVisible(true);
        }
        if (ae.getSource() == mg.getKayitPanel().getKayitBtn()) {
            String tc2 = mg.getKayitPanel().getKullaniciTc().getText().toString().trim();
            String ad2 = mg.getKayitPanel().getKullaniciAdi().getText().toString().trim();
            String soyad2 = mg.getKayitPanel().getKullaniciSoyadi().getText().toString().trim();
            String email2 = mg.getKayitPanel().getKullaniciEmail().getText().toString().trim();
            String sifre2 = mg.getKayitPanel().getKullaniciPass().getPassword().toString().trim();
            if (tc2.equals("") || ad2.equals("") || soyad2.equals("") || email2.equals("") || sifre2.equals("")) {
                JOptionPane.showMessageDialog(null, "Boş alan bırakmayınız..");
            } else {
                String tc = mg.getKayitPanel().getKullaniciTc().getText();
                String ad = mg.getKayitPanel().getKullaniciAdi().getText();
                String soyad = mg.getKayitPanel().getKullaniciSoyadi().getText();
                String email = mg.getKayitPanel().getKullaniciEmail().getText();
                String sifre = new String(mg.getKayitPanel().getKullaniciPass().getPassword());

                database.kullaniciEkle(tc, ad, soyad, email, sifre);
                JOptionPane.showMessageDialog(null, "Kaydınız Alınmıştır..");
                mg.getKayitPanel().getKullaniciTc().setText("");
                mg.getKayitPanel().getKullaniciAdi().setText("");
                mg.getKayitPanel().getKullaniciSoyadi().setText("");
                mg.getKayitPanel().getKullaniciEmail().setText("");
                mg.getKayitPanel().getKullaniciPass().setText("");
                mg.getKayitPanel().getKayitPanel().setVisible(false);
                mg.getKullaniciGui().getKp().setVisible(true);

            }
        }
        if (ae.getSource() == mg.getAdminSayfa().getKitapEkle()) {
            mg.getAdminSayfa().getMesajLabel().setText("");
            String ad2 = mg.getAdminSayfa().getTKitapAdiGir().getText().toString().trim();
            String turu2 = mg.getAdminSayfa().getTKitapTuruGir().getText().toString().trim();
            String yazari2 = mg.getAdminSayfa().getTKitapYazariGir().getText().toString().trim();
            String tarih2 = ((JTextField) mg.getAdminSayfa().getdateChoose().getDateEditor().getUiComponent()).getText().toString().trim();
            if (ad2.equals("") || turu2.equals("") || yazari2.equals("") || tarih2.equals("")) {
                JOptionPane.showMessageDialog(null, "Boş alan bırakmayınız..");
            } else {

                String ad = mg.getAdminSayfa().getTKitapAdiGir().getText();
                String turu = mg.getAdminSayfa().getTKitapTuruGir().getText();
                String yazari = mg.getAdminSayfa().getTKitapYazariGir().getText();
                String tarih = ((JTextField) mg.getAdminSayfa().getdateChoose().getDateEditor().getUiComponent()).getText();
                database.kitapEkle(ad, turu, yazari, tarih);
                mg.getAdminSayfa().kitapGoruntule();
                mg.getAdminSayfa().getMesajLabel().setText("Kitap başarıyla eklendi...");
                mg.getAdminSayfa().getTKitapAdiGir().setText("");
                mg.getAdminSayfa().getTKitapTuruGir().setText("");
                mg.getAdminSayfa().getTKitapYazariGir().setText("");
            }
        }

        if (ae.getSource() == mg.getAdminSayfa().getKitapSil()) {
            mg.getAdminSayfa().getMesajLabel().setText("");
            int selectedrow = mg.getAdminSayfa().getTable().getSelectedRow();
            if (selectedrow == -1) {
                if (model.getRowCount() == 0) {
                    mg.getAdminSayfa().getMesajLabel().setText("Kitaplar tablosu boş.");
                } else {
                    mg.getAdminSayfa().getMesajLabel().setText("Lütfen silinecek kitabı seçiniz...");
                }
            } else {
                int id = (int) model.getValueAt(selectedrow, 0);
                database.kitapSil(id);
                mg.getAdminSayfa().kitapGoruntule();
                mg.getAdminSayfa().getMesajLabel().setText("Kitap başarıyla silindi...");
            }
        }
        if (ae.getSource() == mg.getAdminSayfa().getKitapGüncelle()) {
            String ad = mg.getAdminSayfa().getTKitapAdiGir().getText();
            String turu = mg.getAdminSayfa().getTKitapTuruGir().getText();
            String yazari = mg.getAdminSayfa().getTKitapYazariGir().getText();
            String tarih = ((JTextField) mg.getAdminSayfa().getdateChoose().getDateEditor().getUiComponent()).getText();
            int selectedrow = mg.getAdminSayfa().getTable().getSelectedRow();

            if (selectedrow == -1) {//veri seçilmemiş veya tablo boş ise
                if (model.getRowCount() == 0)//tablomuz boş ise
                {
                    mg.getAdminSayfa().getMesajLabel().setText("Kitaplar tablosu boş.");
                } else {
                    mg.getAdminSayfa().getMesajLabel().setText("Lütfen veri seçiniz...");
                }
            } else {
                int id = (int) model.getValueAt(selectedrow, 0); // id almış olduk

                database.kitapGuncelle(id, ad, turu, yazari, tarih);
                mg.getAdminSayfa().kitapGoruntule();
                mg.getAdminSayfa().getMesajLabel().setText("Kitap başarıyla güncellendi...");
            }
            mg.getAdminSayfa().getTKitapAdiGir().setText("");
            mg.getAdminSayfa().getTKitapTuruGir().setText("");
            mg.getAdminSayfa().getTKitapYazariGir().setText("");
        }
        if (ae.getSource() == mg.getKitaplarPanel().getKitapEkleBtn()) {
            String ad = mg.getMc().dizi[0];
            String turu = mg.getMc().dizi[1];
            String yazari = mg.getMc().dizi[2];
            database.kitapligimaEkle(ad, turu, yazari);
        }
        if (ae.getSource() == mg.getKitapligimPanel().getKitapCikarBtn()) {
            int selectedrow = mg.getKitapligimPanel().getKitapligimTable().getSelectedRow();
            model2 = (DefaultTableModel) mg.getKitapligimPanel().getKitapligimTable().getModel();
            String ad = mg.getMc().dizi2[0];
            String turu = mg.getMc().dizi2[1];
            String yazari = mg.getMc().dizi2[2];
            database.kitapIadeEt(ad, turu, yazari);
            int id = (int) model2.getValueAt(selectedrow, 0);
            database.kitapligimdanSil(id);
            mg.getKitapligimPanel().kitapGoruntule();

        }
        if (ae.getSource() == mg.getBilgilerimPanel().getGuncelleBtn()) {
            String ad = mg.getBilgilerimPanel().getAdiTf().getText();
            String soyad = mg.getBilgilerimPanel().getSoyadiTf().getText();
            String email = mg.getBilgilerimPanel().getMailTf().getText();
            String tcno = mg.getBilgilerimPanel().getTcTf().getText();
            String parola = new String(mg.getBilgilerimPanel().getSifrePf().getPassword());
            database.kullaniciBilgileriGuncelle(tcno, ad, soyad, email, parola);
            mg.getKullaniciAnasayfa().getKullaniciAdi().setText(database.kullaniciAdigetir(email));
        }
        if (ae.getSource() == mg.getAdminSayfa().getCikisBtn()) {
            mg.getAdminSayfa().getKitapP().setVisible(false);
            mg.getKullaniciGui().getKp().setVisible(true);
            mg.getAdminGui().getTextfield().setText("");
            mg.getAdminGui().getPass().setText("");
        }

    }
}
