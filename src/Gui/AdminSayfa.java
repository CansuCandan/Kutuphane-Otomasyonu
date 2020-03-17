package Gui;

import Model.Database;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javafx.scene.control.DatePicker;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class AdminSayfa {

    MainGui mg = null;
    Database database = null;

    JScrollPane scroll = null;
    DefaultTableModel model = new DefaultTableModel();
    DatePicker datePicker = null;
    com.toedter.calendar.JDateChooser dateChoose = null;
    JPanel kitapPanel = null;
    JTable kitapTable = null;
    JButton kitapEkle, kitapSil, kitapGuncelle, cikisBtn = null;
    JLabel kitapAdi, kitapTuru, kitapYazar, LtarihChoose, mesajLabel = null;
    JTextField kitapAdiGir, kitapTuruGir, kitapYazariGir, araTextField = null;

    Font yazi = new Font("", Font.BOLD, 16);
    Font btn = new Font("", Font.BOLD, 18);
    Font baslik = new Font("", Font.BOLD, 16);
    Font ara = new Font("", Font.PLAIN, 16);
    Color renk = new Color(52, 73, 93);
    Color sayfalar = new Color(51, 0, 173);

    public AdminSayfa(MainGui mg) {
        this.mg = mg;
        database = mg.data;
    }

    public void kitapGoruntule() {
        model.setRowCount(0);
        ArrayList<Kitap> kitaplar = new ArrayList<Kitap>();

        kitaplar = database.KitaplariGetir();

        if (kitaplar != null) {
            for (Kitap kitap : kitaplar) {
                Object[] eklenecekKitap = {kitap.getId(), kitap.getKitapAdi(), kitap.getKitapTuru(), kitap.getKitapYazari(), kitap.getKitapTarihi()};

                model.addRow(eklenecekKitap);
            }
        }
    }

    public JPanel getKitapP() {
        if (kitapPanel == null) {
            kitapPanel = new JPanel();
            kitapPanel.setBounds(0, 0, 1200, 800);
            kitapPanel.setBackground(sayfalar);
            kitapPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            kitapPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            kitapPanel.add(getTable());
            kitapPanel.add(getLKitapAdi());
            kitapPanel.add(getLKitapTuru());
            kitapPanel.add(getTKitapAdiGir());
            kitapPanel.add(getTKitapTuruGir());
            kitapPanel.add(getTKitapYazariGir());
            kitapPanel.add(getLKitapYazari());
            kitapPanel.add(getKitapEkle());
            kitapPanel.add(getKitapGüncelle());
            kitapPanel.add(getKitapSil());
            kitapPanel.add(getdateChoose());
            kitapPanel.add(getLtarihChoose());
            kitapPanel.add(getAraTextField());
            kitapPanel.add(getScroll());
            kitapPanel.add(getMesajLabel());
            kitapPanel.add(getCikisBtn());
            kitapPanel.setLayout(null);
            kitapPanel.setVisible(false);
        }
        return kitapPanel;
    }

    public void setKitapPanel(JPanel kitapPanel) {
        this.kitapPanel = kitapPanel;
    }

    public JTable getTable() {

        if (kitapTable == null) {
            kitapTable = new JTable(model);
            kitapTable.setBounds(20, 420, 800, 400);
            ArrayList<Kitap> kitapGetir = database.KitaplariGetir();
            Object row[] = new Object[5];
            model.addColumn("ID");
            model.addColumn("Kitap Adı");
            model.addColumn("Kitap Türü");
            model.addColumn("Kitap Yazari");
            model.addColumn("Basım Tarihi");
            for (int i = 0; i < kitapGetir.size(); i++) {
                row[0] = kitapGetir.get(i).getId();
                row[1] = kitapGetir.get(i).getKitapAdi();
                row[2] = kitapGetir.get(i).getKitapTuru();
                row[3] = kitapGetir.get(i).getKitapYazari();
                row[4] = kitapGetir.get(i).getKitapTarihi();

                model.addRow(row);
            }
            kitapTable.addMouseListener(mg.getMc());

        }
        return kitapTable;

    }

    public void setKitapTable(JTable kitapTable) {
        this.kitapTable = kitapTable;
    }

    public JTextField getAraTextField() {
        if (araTextField == null) {
            araTextField = new JTextField("Aramak istediğiniz kitap adını giriniz...");
            araTextField.setBounds(80, 20, 400, 30);
            araTextField.setFont(ara);
            araTextField.addKeyListener(mg.getKe());
        }
        return araTextField;
    }

    public void setAraTextField(JTextField araTextField) {
        this.araTextField = araTextField;
    }

    public JLabel getLKitapAdi() {
        if (kitapAdi == null) {
            kitapAdi = new JLabel("Kitap Adı:");
            kitapAdi.setBounds(70, 100, 200, 50);
            kitapAdi.setForeground(Color.WHITE);
            kitapAdi.setFont(baslik);
        }
        return kitapAdi;
    }

    public void setKitapAdi(JLabel kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public JTextField getTKitapAdiGir() {
        if (kitapAdiGir == null) {
            kitapAdiGir = new JTextField(12);
            kitapAdiGir.setBounds(190, 108, 200, 32);
            kitapAdiGir.setEditable(true);  //true ise kullanici yazi yazabilir. false olursa yazi yazamaz 
        }
        return kitapAdiGir;
    }

    public void setKitapAdiGir(JTextField kitapAdiGir) {
        this.kitapAdiGir = kitapAdiGir;
    }

    public JLabel getLKitapTuru() {
        if (kitapTuru == null) {
            kitapTuru = new JLabel("Kitap Türü:");
            kitapTuru.setBounds(70, 165, 200, 50);
            kitapTuru.setForeground(Color.WHITE);  //Yazının rengini değiştirmek için kullanılır.
            kitapTuru.setFont(baslik);
        }
        return kitapTuru;
    }

    public void setKitapTuru(JLabel kitapTuru) {
        this.kitapTuru = kitapTuru;
    }

    public JTextField getTKitapTuruGir() {
        if (kitapTuruGir == null) {
            kitapTuruGir = new JTextField(12);
            kitapTuruGir.setBounds(190, 171, 200, 32);
            kitapTuruGir.setEditable(true);  //true ise kullanici yazi yazabilir. false olursa yazi yazamaz 
        }
        return kitapTuruGir;
    }

    public void setKitapTuruGir(JTextField kitapTuruGir) {
        this.kitapTuruGir = kitapTuruGir;
    }

    public JLabel getLKitapYazari() {
        if (kitapYazar == null) {
            kitapYazar = new JLabel("Kitap Yazarı:");
            kitapYazar.setBounds(70, 225, 200, 50);
            kitapYazar.setForeground(Color.WHITE);  //Yazının rengini değiştirmek için kullanılır.
            kitapYazar.setFont(baslik);
        }
        return kitapYazar;
    }

    public void setKitapYazar(JLabel kitapYazar) {
        this.kitapYazar = kitapYazar;
    }

    public JTextField getTKitapYazariGir() {
        if (kitapYazariGir == null) {
            kitapYazariGir = new JTextField(12);
            kitapYazariGir.setBounds(190, 231, 200, 32);
            kitapYazariGir.setEditable(true);  //true ise kullanici yazi yazabilir. false olursa yazi yazamaz 
        }
        return kitapYazariGir;
    }

    public void setKitapYazariGir(JTextField kitapYazariGir) {
        this.kitapYazariGir = kitapYazariGir;
    }

    public JLabel getLtarihChoose() {
        if (LtarihChoose == null) {
            LtarihChoose = new JLabel("Basım Tarihi:");
            LtarihChoose.setBounds(70, 294, 200, 50);
            LtarihChoose.setForeground(Color.WHITE);  //Yazının rengini değiştirmek için kullanılır.
            LtarihChoose.setFont(baslik);
        }
        return LtarihChoose;
    }

    public void setLtarihChoose(JLabel LtarihChoose) {
        this.LtarihChoose = LtarihChoose;
    }

    public com.toedter.calendar.JDateChooser getdateChoose() {
        if (dateChoose == null) {
            dateChoose = new com.toedter.calendar.JDateChooser();
            dateChoose.setBounds(190, 302, 200, 32);
        }
        return dateChoose;
    }

    public void setDateChoose(JDateChooser dateChoose) {
        this.dateChoose = dateChoose;
    }

    public JButton getKitapEkle() {
        if (kitapEkle == null) {
            kitapEkle = new JButton("Kitap Ekle");
            kitapEkle.setBounds(935, 100, 200, 35); //(x,y,h,w)X,Y Boşluk bırakır, H,W Yükseklik ve Genişlik verir.
            kitapEkle.setBackground(Color.WHITE);
            kitapEkle.setFont(btn);
            kitapEkle.addActionListener(mg.getBi());
        }
        return kitapEkle;
    }

    public void setKitapEkle(JButton kitapEkle) {
        this.kitapEkle = kitapEkle;
    }

    public JButton getKitapSil() {
        if (kitapSil == null) {
            kitapSil = new JButton("Kitap Sil");
            kitapSil.setBounds(935, 180, 200, 35); //(x,y,h,w)X,Y Boşluk bırakır, H,W Yükseklik ve Genişlik verir.
            kitapSil.setBackground(Color.WHITE);
            kitapSil.setFont(btn);
            kitapSil.addActionListener(mg.getBi());
        }
        return kitapSil;
    }

    public void setKitapSil(JButton kitapSil) {
        this.kitapSil = kitapSil;
    }

    public JButton getKitapGüncelle() {
        if (kitapGuncelle == null) {
            kitapGuncelle = new JButton("Kitap Güncelle");
            kitapGuncelle.setBounds(935, 260, 200, 35); //(x,y,h,w)X,Y Boşluk bırakır, H,W Yükseklik ve Genişlik verir.
            kitapGuncelle.setBackground(Color.WHITE);
            kitapGuncelle.setFont(btn);
            kitapGuncelle.addActionListener(mg.getBi());
        }
        return kitapGuncelle;
    }

    public void setKitapGuncelle(JButton kitapGuncelle) {
        this.kitapGuncelle = kitapGuncelle;
    }

    public JScrollPane getScroll() {
        if (scroll == null) {
            scroll = new JScrollPane(getTable());
            scroll.setBounds(70, 400, 1060, 350);
            scroll.setVisible(true);
            scroll.setFont(yazi);
        }
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JLabel getMesajLabel() {
        if (mesajLabel == null) {
            mesajLabel = new JLabel();
            mesajLabel.setBounds(80, 330, 300, 50);
            mesajLabel.setForeground(Color.YELLOW);  //Yazının rengini değiştirmek için kullanılır.
            mesajLabel.setFont(baslik);
        }
        return mesajLabel;
    }

    public void setMesajLabel(JLabel mesajLabel) {
        this.mesajLabel = mesajLabel;
    }

    public JButton getCikisBtn() {
        if (cikisBtn == null) {
            cikisBtn = new JButton("Geri");
            cikisBtn.setBounds(985, 340, 100, 30);
            cikisBtn.setBackground(Color.WHITE);
            cikisBtn.setFont(btn);
            cikisBtn.addActionListener(mg.getBi());
        }
        return cikisBtn;
    }

    public void setCikisBtn(JButton cikisBtn) {
        this.cikisBtn = cikisBtn;
    }

}
