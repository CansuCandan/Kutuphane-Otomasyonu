package Gui;

import Model.Database;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class IadelerimPanel extends JPanel {

    MainGui mg = null;
    Database database = null;
    DefaultTableModel model = new DefaultTableModel();
    JScrollPane scroll = null;
    JTable iadelerimTable = null;

    Font yazi = new Font("", Font.BOLD, 16);
    Font table = new Font("", Font.BOLD, 16);

    public IadelerimPanel(MainGui mg) {
        this.mg = mg;
        database = mg.data;
        setBounds(400, 0, 800, 800);
        add(getIadelerimTable());
        add(getScroll());
        setLayout(null);
        setVisible(false);
    }

    public void kitapGoruntule() {
        model.setRowCount(0);
        ArrayList<Kitap> kitaplar = new ArrayList<Kitap>();

        kitaplar = database.IadeEttiklerimGetir();

        if (kitaplar != null) {
            for (Kitap kitap : kitaplar) {
                Object[] eklenecekKitap = {kitap.getId(), kitap.getKitapAdi(), kitap.getKitapTuru(), kitap.getKitapYazari(), kitap.getKitapTarihi()};

                model.addRow(eklenecekKitap);
            }
        }

    }

    public JTable getIadelerimTable() {
        if (iadelerimTable == null) {
            iadelerimTable = new JTable(model);
            ArrayList<Kitap> kitapGetir = database.IadeEttiklerimGetir();
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
            iadelerimTable.addMouseListener(mg.getMc());
        }
        return iadelerimTable;
    }

    public void setIadelerimTable(JTable iadelerimTable) {
        this.iadelerimTable = iadelerimTable;
    }

    public JScrollPane getScroll() {
        if (scroll == null) {
            scroll = new JScrollPane(getIadelerimTable());
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
