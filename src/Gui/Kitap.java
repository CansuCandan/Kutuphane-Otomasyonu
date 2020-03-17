package Gui;

public class Kitap {
    private int id;
    private String kitapAdi;
    private String kitapTuru;
    private String kitapYazari;
    private String kitapTarihi;

    public Kitap(int id, String kitapAdi, String kitapTuru, String kitapYazari, String kitapTarihi) {
        this.id = id;
        this.kitapAdi = kitapAdi;
        this.kitapTuru = kitapTuru;
        this.kitapYazari = kitapYazari;
        this.kitapTarihi = kitapTarihi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getKitapTuru() {
        return kitapTuru;
    }

    public void setKitapTuru(String kitapTuru) {
        this.kitapTuru = kitapTuru;
    }

    public String getKitapYazari() {
        return kitapYazari;
    }

    public void setKitapYazari(String kitapYazari) {
        this.kitapYazari = kitapYazari;
    }

    public String getKitapTarihi() {
        return kitapTarihi;
    }

    public void setKitapTarihi(String kitapTarihi) {
        this.kitapTarihi = kitapTarihi;
    }
}
