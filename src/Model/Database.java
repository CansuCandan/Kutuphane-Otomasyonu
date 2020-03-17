package Model;

import Business.Islemler;
import Gui.Kitap;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    public static final String kullanici_adi = "root";
    public static final String parola = "";

    public static final String db_adi = "kutuphane";

    public static final String host = "localhost";
    public static final int port = 3306;

    private Connection connection = null; //Direk database baglantisi yapmamizi sagliyor.
    private Statement statement = null;   //SQL sorgularini calistirmak icin gerekli olan class.
    private PreparedStatement preparedstatement = null;

    public Database() {
        String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_adi;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadi..");
        }

        try {
            connection = DriverManager.getConnection(url, Database.kullanici_adi, Database.parola); //Kullanici adi ve parolayi alarak veritabanina baglantiyi sagliyor.
            System.out.println("Baglandi..");

        } catch (SQLException ex) {
            System.out.println("Baglanamadi..");
        }

    }

    public ArrayList<Kitap> KitaplariGetir() {

        ArrayList<Kitap> cikti = new ArrayList<Kitap>();

        try {
            statement = connection.createStatement();
            String sorgu = "Select * From kitap_tablosu";
            ResultSet rs = statement.executeQuery(sorgu);

            while (rs.next()) {
                int id = rs.getInt("id");
                String kitapAdi = rs.getString("kitap_adi");
                String kitapTuru = rs.getString("kitap_turu");
                String kitapYazari = rs.getString("yazari");
                String kitapBasim = rs.getString("basim_tarihi");

                cikti.add(new Kitap(id, kitapAdi, kitapTuru, kitapYazari, kitapBasim));
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Kitap> KitapligimGetir() {

        ArrayList<Kitap> cikti = new ArrayList<Kitap>();

        try {
            statement = connection.createStatement();
            String sorgu = "Select * From kitapligim_tablosu";
            ResultSet rs = statement.executeQuery(sorgu);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String kitapAdi = rs.getString("kitap_adi");
                String kitapTuru = rs.getString("kitap_turu");
                String kitapYazari = rs.getString("kitap_yazari");
                String kitapBasim = rs.getString("basim_tarihi");
                String kitapAlim = rs.getString("alim_tarihi");

                cikti.add(new Kitap(id, kitapAdi, kitapTuru, kitapYazari, kitapBasim));
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Kitap> IadeEttiklerimGetir() {

        ArrayList<Kitap> cikti = new ArrayList<Kitap>();

        try {
            statement = connection.createStatement();
            String sorgu = "Select * From iade_tablosu";
            ResultSet rs = statement.executeQuery(sorgu);

            while (rs.next()) {
                int id = rs.getInt("id");
                String kitapAdi = rs.getString("kitap_adi");
                String kitapTuru = rs.getString("kitap_turu");
                String kitapYazari = rs.getString("kitap_yazari");
                String kitapBasim = rs.getString("basim_tarihi");
                String kitapIade = rs.getString("iade_tarihi");

                cikti.add(new Kitap(id, kitapAdi, kitapTuru, kitapYazari, kitapBasim));
            }
            return cikti;
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void kitapligimaEkle(String ad, String turu, String yazari) {
        String sorgu = "Insert Into kitapligim_tablosu(kitap_adi,kitap_turu,kitap_yazari) values (?,?,?)";
        try {
            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setString(1, ad);
            preparedstatement.setString(2, turu);
            preparedstatement.setString(3, yazari);

            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kitapIadeEt(String ad, String turu, String yazari) {
        String sorgu = "Insert Into iade_tablosu(kitap_adi,kit"
                + "ap_turu,kitap_yazari) values (?,?,?)";
        try {
            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setString(1, ad);
            preparedstatement.setString(2, turu);
            preparedstatement.setString(3, yazari);

            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kitapEkle(String ad, String turu, String yazari, String tarih) {
        String sorgu = "Insert Into kitap_tablosu(kitap_adi,kitap_turu,yazari,basim_tarihi) values (?,?,?,?)";
        try {
            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setString(1, ad);
            preparedstatement.setString(2, turu);
            preparedstatement.setString(3, yazari);
            preparedstatement.setString(4, tarih);

            preparedstatement.executeUpdate(); //Insert islemi oldugu icin kullanılır.
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kitapGuncelle(int id, String ad, String turu, String yazari, String tarih) {
        String sorgu = "Update kitap_tablosu set kitap_adi=?, kitap_turu=?, yazari=?, basim_tarihi=? WHERE id=?";

        try {
            preparedstatement = connection.prepareStatement(sorgu);

            preparedstatement.setString(1, ad);
            preparedstatement.setString(2, turu);
            preparedstatement.setString(3, yazari);
            preparedstatement.setString(4, tarih);
            preparedstatement.setInt(5, id);

            preparedstatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kitapSil(int id) {
        String sorgu = "Delete from kitap_tablosu where id=?";

        try {
            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setInt(1, id);

            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean adminGirisYap(String adminAdi, String adminPass) {

        String sorgu = "Select * From admin_tablosu where admin_adi = ? and parola = ? ";
        try {

            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setString(1, adminAdi);
            preparedstatement.setString(2, adminPass);

            ResultSet rs = preparedstatement.executeQuery();

            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean kullaniciGirisYap(String email, String kullaniciPass) {
        String sorgu = "Select * From kullanici_tablosu where email = ? and parola = ? ";
        try {

            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setString(1, email);
            preparedstatement.setString(2, kullaniciPass);

            ResultSet rs = preparedstatement.executeQuery();
            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public String kullaniciAdigetir(String email) {
        String sorgu = "Select ad From kullanici_tablosu where email = ?";
        try {

            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setString(1, email);

            ResultSet rs = preparedstatement.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getString(1));
                return rs.getString(1);
            } else {
                return "Null Else";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String[] kullaniciBilgiGetir(String email) {
        String bilgiler[] = new String[5];
        String sorgu = "Select tcno,ad,soyad,email,parola From kullanici_tablosu where email = ?";
        try {

            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setString(1, email);

            ResultSet rs = preparedstatement.executeQuery();
            if (rs.next()) {
                bilgiler[0] = rs.getString("tcno");
                bilgiler[1] = rs.getString("ad");
                bilgiler[2] = rs.getString("soyad");
                bilgiler[3] = rs.getString("email");
                bilgiler[4] = rs.getString("parola");
                return bilgiler;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void kullaniciBilgileriGuncelle(String tcno, String ad, String soyad, String email, String parola) {
        String sorgu = "Update kullanici_tablosu set tcno = ? , ad = ? , soyad = ? , parola = ? WHERE email= ? ";
        try {
            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setString(1, tcno);
            preparedstatement.setString(2, ad);
            preparedstatement.setString(3, soyad);
            preparedstatement.setString(4, parola);
            preparedstatement.setString(5, email);
            preparedstatement.executeUpdate();

        } catch (SQLException ex) {

        }
    }

    public void kullaniciEkle(String tc, String ad, String soyad, String email, String sifre) {
        String sorgu = "Insert Into kullanici_tablosu(tcno,ad,soyad,email,parola) values (?,?,?,?,?)";
        try {
            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setString(1, tc);
            preparedstatement.setString(2, ad);
            preparedstatement.setString(3, soyad);
            preparedstatement.setString(4, email);
            preparedstatement.setString(5, sifre);

            preparedstatement.executeUpdate(); //Insert islemi oldugu icin kullanılır.
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void kitapligimdanSil(int id) {
        String sorgu = "Delete from kitapligim_tablosu where ID=?";

        try {
            preparedstatement = connection.prepareStatement(sorgu);
            preparedstatement.setInt(1, id);

            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
