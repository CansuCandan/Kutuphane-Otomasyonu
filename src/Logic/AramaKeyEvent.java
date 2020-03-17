package Logic;

import Gui.MainGui;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class AramaKeyEvent implements KeyListener {

    MainGui mg = null;
    DefaultTableModel model;

    public AramaKeyEvent(MainGui mg) {
        this.mg = mg;
        model = (DefaultTableModel) mg.getAdminSayfa().getTable().getModel();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getSource().equals(mg.getAdminSayfa().getAraTextField())) {
            String ara = mg.getAdminSayfa().getAraTextField().getText();
            dinamikAra(ara);
        }
        if (ke.getSource().equals(mg.getKitaplarPanel().getAraTextField())) {
            String ara = mg.getKitaplarPanel().getAraTextField().getText();
            dinamikAra2(ara);
        }

    }

    public void dinamikAra(String ara) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        mg.getAdminSayfa().getTable().setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(ara));
    }

    public void dinamikAra2(String ara) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        mg.getKitaplarPanel().getKitaplarTable().setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(ara));
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

}
