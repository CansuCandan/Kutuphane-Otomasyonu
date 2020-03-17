package Logic;

import Gui.MainGui;
import Model.Database;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class MouseClicked implements MouseListener {

    Database database = null;
    MainGui mg = null;
    DefaultTableModel model, model2 = null;

    String[] dizi = new String[4];
    String[] dizi2 = new String[4];
    String ad, tur, yazar;

    public MouseClicked(MainGui mg) {
        this.mg = mg;
        database = mg.data;
    }

    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == mg.getAdminSayfa().getTable()) {

            model = (DefaultTableModel) mg.getAdminSayfa().getTable().getModel();
            int selectedrow = mg.getAdminSayfa().getTable().getSelectedRow();
            mg.getAdminSayfa().getTKitapAdiGir().setText(model.getValueAt(selectedrow, 1).toString());
            mg.getAdminSayfa().getTKitapTuruGir().setText(model.getValueAt(selectedrow, 2).toString());
            mg.getAdminSayfa().getTKitapYazariGir().setText(model.getValueAt(selectedrow, 3).toString());
            ((JTextField) mg.getAdminSayfa().getdateChoose().getDateEditor().getUiComponent()).getText();
        }
        if (me.getSource() == mg.getKitaplarPanel().getKitaplarTable()) {
            model = (DefaultTableModel) mg.getAdminSayfa().getTable().getModel();
            int selectedrow2 = mg.getKitaplarPanel().getKitaplarTable().getSelectedRow();
            dizi[0] = model.getValueAt(selectedrow2, 1).toString();
            dizi[1] = model.getValueAt(selectedrow2, 2).toString();
            dizi[2] = model.getValueAt(selectedrow2, 3).toString();
        }
        if (me.getSource() == mg.getKitapligimPanel().getKitapligimTable()) {
            model2 = (DefaultTableModel) mg.getKitapligimPanel().getKitapligimTable().getModel();
            int selectedrow3 = mg.getKitapligimPanel().getKitapligimTable().getSelectedRow();
            dizi2[0] = model2.getValueAt(selectedrow3, 1).toString();
            dizi2[1] = model2.getValueAt(selectedrow3, 2).toString();
            dizi2[2] = model2.getValueAt(selectedrow3, 3).toString();
        }

    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
