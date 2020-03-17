package Gui;

import Logic.AramaKeyEvent;
import Logic.ButtonIslemleri;
import Logic.MouseClicked;
import Model.Database;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainGui {

    public static Database data = null;
    KullaniciGui kullaniciGui = null;
    AdminGui adminGui = null;
    AdminSayfa adminSayfa = null;
    KullaniciSayfa kullaniciSayfa = null;
    MouseClicked mc = null;
    ButtonIslemleri Bi = null;
    KitaplarPanel kitaplarPanel = null;
    KitapligimPanel kitapligimPanel = null;
    IadelerimPanel iadelerimPanel = null;
    BilgilerimPanel bilgilerimPanel = null;
    KullaniciAnasayfa kullaniciAnasayfa = null;
    KayitGui kayitPanel = null;
    AramaKeyEvent Ke = null;

    JFrame jf = null;
    JPanel fixedPanel = null;

    Color renk = new Color(52, 73, 93);

    public MainGui() {
        data = new Database();
        getFixedPanel().add(getKullaniciGui().getKp()); //Bu kodları panelin içine almamız gerekmiyor mu burada sadece frame gösterilecek
        getFixedPanel().add(getAdminGui().getAp());
        getFixedPanel().add(getAdminSayfa().getKitapP());
        getFixedPanel().add(getKullaniciSayfa());
        getFixedPanel().add(getKayitPanel().getKayitPanel());
        getjf().setVisible(true);//Burada JFrame gosterilir.
    }

    public JFrame getjf() { //JFramenin ozellikleri burada belirlenir.
        if (jf == null) {
            jf = new JFrame("Giriş");
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.setLocation(0, 0);
            jf.setSize(1200, 800);
            jf.setResizable(false);   //Pencereyi sabitler
            jf.setContentPane(getFixedPanel());
        }
        return jf;
    }

    public void setjf(JFrame jf) {
        this.jf = jf;
    }

    public JPanel getFixedPanel() {
        if (fixedPanel == null) {
            fixedPanel = new JPanel();
            fixedPanel.setBackground(renk);
            fixedPanel.setLayout(null);

        }
        return fixedPanel;
    }

    public void setFixedPanel(JPanel fixedPanel) {
        this.fixedPanel = fixedPanel;
    }

    public KullaniciGui getKullaniciGui() {
        if (kullaniciGui == null) {
            kullaniciGui = new KullaniciGui(this);
        }
        return kullaniciGui;
    }

    public void setKullaniciGui(KullaniciGui kullaniciGui) {
        this.kullaniciGui = kullaniciGui;
    }

    public AdminGui getAdminGui() {
        if (adminGui == null) {
            adminGui = new AdminGui(this);
        }
        return adminGui;
    }

    public void setAdminGui(AdminGui adminGui) {
        this.adminGui = adminGui;
    }

    public KayitGui getKayitPanel() {
        if (kayitPanel == null) {
            kayitPanel = new KayitGui(this);
        }
        return kayitPanel;
    }

    public void setKayitPanel(KayitGui kayitPanel) {
        this.kayitPanel = kayitPanel;
    }

    public AdminSayfa getAdminSayfa() {
        if (adminSayfa == null) {
            adminSayfa = new AdminSayfa(this);
        }
        return adminSayfa;
    }

    public void setAdminSayfa(AdminSayfa adminSayfa) {
        this.adminSayfa = adminSayfa;
    }

    public KullaniciSayfa getKullaniciSayfa() {
        if (kullaniciSayfa == null) {
            kullaniciSayfa = new KullaniciSayfa(this);
        }
        return kullaniciSayfa;
    }

    public void setKullaniciSayfa(KullaniciSayfa kullaniciSayfa) {
        this.kullaniciSayfa = kullaniciSayfa;
    }

    public ButtonIslemleri getBi() {
        if (Bi == null) {
            Bi = new ButtonIslemleri(this);
        }
        return Bi;
    }

    public void setBi(ButtonIslemleri Bi) {
        this.Bi = Bi;
    }

    public KitaplarPanel getKitaplarPanel() {
        if (kitaplarPanel == null) {
            kitaplarPanel = new KitaplarPanel(this);
        }
        return kitaplarPanel;
    }

    public void setKitaplarPanel(KitaplarPanel kitaplarPanel) {
        this.kitaplarPanel = kitaplarPanel;
    }

    public KitapligimPanel getKitapligimPanel() {
        if (kitapligimPanel == null) {
            kitapligimPanel = new KitapligimPanel(this);
        }
        return kitapligimPanel;
    }

    public void setKitapligimPanel(KitapligimPanel kitapligimPanel) {
        this.kitapligimPanel = kitapligimPanel;
    }

    public IadelerimPanel getIadelerimPanel() {
        if (iadelerimPanel == null) {
            iadelerimPanel = new IadelerimPanel(this);
        }
        return iadelerimPanel;
    }

    public void setIadelerimPanel(IadelerimPanel iadelerimPanel) {
        this.iadelerimPanel = iadelerimPanel;
    }

    public BilgilerimPanel getBilgilerimPanel() {
        if (bilgilerimPanel == null) {
            bilgilerimPanel = new BilgilerimPanel(this);
        }
        return bilgilerimPanel;
    }

    public void setBilgilerimPanel(BilgilerimPanel bilgilerimPanel) {
        this.bilgilerimPanel = bilgilerimPanel;
    }

    public KullaniciAnasayfa getKullaniciAnasayfa() {
        if (kullaniciAnasayfa == null) {
            kullaniciAnasayfa = new KullaniciAnasayfa(this);
        }
        return kullaniciAnasayfa;
    }

    public void setKullaniciAnasayfa(KullaniciAnasayfa kullaniciAnasayfa) {
        this.kullaniciAnasayfa = kullaniciAnasayfa;
    }

    public AramaKeyEvent getKe() {
        if (Ke == null) {
            Ke = new AramaKeyEvent(this);
        }
        return Ke;
    }

    public void setKe(AramaKeyEvent Ke) {
        this.Ke = Ke;
    }

    public static Database getIs() {
        if (data == null) {
            data = new Database();
        }
        return data;
    }

    public static void setIs(Database is) {
        MainGui.data = is;
    }

    public MouseClicked getMc() {
        if (mc == null) {
            mc = new MouseClicked(this);
        }
        return mc;
    }

    public void setMc(MouseClicked mc) {
        this.mc = mc;
    }

}
