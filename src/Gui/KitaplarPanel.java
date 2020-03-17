package Gui;

import Model.Database;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class KitaplarPanel extends JPanel {

    MainGui mg = null;
    Database database = null;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane scroll2 = null;

    JTextField araTextField = null;
    JTable kitaplarTable = null;
    JButton kitapEkleBtn = null;
    JLabel date = null;

    Font ara = new Font("", Font.BOLD, 16);
    Font table = new Font("", Font.BOLD, 16);
    Font yazi = new Font("", Font.BOLD, 16);

    public KitaplarPanel(MainGui mg) {
        this.mg = mg;
        database = mg.data;
        setBounds(405, 0, 800, 800);
        add(getAraTextField());
        add(getKitapEkleBtn());
        add(getKitaplarTable());
        add(getScroll2());
        add(getDate());
        setLayout(null);
        setVisible(true);

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

    public JTextField getAraTextField() {
        if (araTextField == null) {
            araTextField = new JTextField();
            araTextField.setBounds(30, 30, 500, 40);
            araTextField.setText("Aramak istediğiniz kitap adını giriniz...");
            araTextField.setFont(ara);
            araTextField.addKeyListener(mg.getKe());
        }
        return araTextField;
    }

    public void setAraTextField(JTextField araTextField) {
        this.araTextField = araTextField;
    }

    public JTable getKitaplarTable() {
        if (kitaplarTable == null) {
            kitaplarTable = new JTable(model);
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
            kitaplarTable.addMouseListener(mg.getMc());
        }
        return kitaplarTable;
    }

    public void setKitaplarTable(JTable kitaplarTable) {
        this.kitaplarTable = kitaplarTable;
    }

    public JButton getKitapEkleBtn() {
        if (kitapEkleBtn == null) {
            kitapEkleBtn = new JButton();
            kitapEkleBtn.setBounds(20, 90, 200, 40);
            kitapEkleBtn.setText("KİTAP EKLE");
            kitapEkleBtn.setFont(ara);
            kitapEkleBtn.setBackground(Color.WHITE);
            kitapEkleBtn.addActionListener(mg.getBi());
        }
        return kitapEkleBtn;
    }

    public void setKitapEkleBtn(JButton kitapEkleBtn) {
        this.kitapEkleBtn = kitapEkleBtn;
    }

    public JScrollPane getScroll2() {
        if (scroll2 == null) {
            scroll2 = new JScrollPane(getKitaplarTable());
            scroll2.setBounds(20, 170, 750, 550);
            scroll2.setVisible(true);
            scroll2.setFont(yazi);
        }
        return scroll2;
    }

    public void setScroll2(JScrollPane scroll2) {
        this.scroll2 = scroll2;
    }

    public JLabel getDate() {
        if (date == null) {
            date = new JLabel();
            date.setBounds(610, 40, 150, 30);
            String txtDate = new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(new Date());
            date.setText("TARİH : " + txtDate);
            date.setFont(yazi);
        }
        return date;
    }

    public void setDate(JLabel date) {
        this.date = date;
    }
}
