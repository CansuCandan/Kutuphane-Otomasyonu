package Gui;

import Model.Database;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class KitapligimPanel extends JPanel{

    MainGui mg = null;
    Database database = null;
    
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane scroll = null;
    JLabel kitapligimLabel = null;
    JTable kitapligimTable = null;
    JButton kitapCikarBtn = null;

    Font yazi = new Font("", Font.BOLD, 16);
    Font table = new Font("", Font.BOLD, 16);

    public KitapligimPanel(MainGui mg) {
        this.mg = mg;
        database = mg.data;
        setBounds(400, 0, 800, 800);
        add(getKitapligimTable());
        add(getKitapCikarBtn());
        add(getKitapligimLabel());
        add(getScroll());
        setLayout(null);
        setVisible(false);
    }

    public void kitapGoruntule() {
        model.setRowCount(0);
        ArrayList<Kitap> kitaplar = new ArrayList<Kitap>();

        kitaplar = database.KitapligimGetir();

        if (kitaplar != null) {
            for (Kitap kitap : kitaplar) {
                Object[] eklenecekKitap = {kitap.getId(), kitap.getKitapAdi(), kitap.getKitapTuru(), kitap.getKitapYazari(), kitap.getKitapTarihi()};

                model.addRow(eklenecekKitap);
            }
        }
    }

    public JTable getKitapligimTable() {
        if (kitapligimTable == null) {
            kitapligimTable = new JTable(model);
            ArrayList<Kitap> kitapGetir = database.KitapligimGetir();
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
            kitapligimTable.addMouseListener(mg.getMc());
        }
        return kitapligimTable;
    }

    public void setKitapligimTable(JTable kitapligimTable) {
        this.kitapligimTable = kitapligimTable;
    }

    public JButton getKitapCikarBtn() {
        if (kitapCikarBtn == null) {
            kitapCikarBtn = new JButton();
            kitapCikarBtn.setBounds(40, 560, 200, 40);
            kitapCikarBtn.setText("İADE ET");
            kitapCikarBtn.setFont(yazi);
            kitapCikarBtn.setBackground(Color.WHITE);
            kitapCikarBtn.addActionListener(mg.getBi());

        }
        return kitapCikarBtn;
    }

    public void setKitapCikarBtn(JButton kitapCikarBtn) {
        this.kitapCikarBtn = kitapCikarBtn;
    }

    public JLabel getKitapligimLabel() {
        if (kitapligimLabel == null) {
            kitapligimLabel = new JLabel();
            kitapligimLabel.setBounds(20, 700, 700, 50);
            kitapligimLabel.setFont(yazi);
            kitapligimLabel.setText("(*) İade etmek istediğiniz ürünü tablodan seçiniz ve 'İADE ET' butonunu tıklayınız.");

        }
        return kitapligimLabel;
    }

    public void setKitapligimLabel(JLabel kitapligimLabel) {
        this.kitapligimLabel = kitapligimLabel;
    }

    public JScrollPane getScroll() {
        if (scroll == null) {
            scroll = new JScrollPane(getKitapligimTable());
            scroll.setBounds(20, 20, 750, 500);
            scroll.setVisible(true);
            scroll.setFont(yazi);
        }
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

}
