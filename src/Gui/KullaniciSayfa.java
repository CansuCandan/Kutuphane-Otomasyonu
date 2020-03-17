package Gui;

import javax.swing.JPanel;

public class KullaniciSayfa extends JPanel{
    MainGui mg=null;
    
    public KullaniciSayfa(MainGui mg){
        this.mg=mg;
         setBounds(0, 0, 1200, 800);
         add(mg.getKullaniciAnasayfa());
         add(mg.getKitaplarPanel());
         add(mg.getKitapligimPanel());
         add(mg.getIadelerimPanel());
         add(mg.getBilgilerimPanel());
         setLayout(null);
         setVisible(false);
        
    }
}
