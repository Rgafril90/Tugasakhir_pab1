package com.if4b.tugasakhir_pab1;

public class   ModelKaraoke {
    private String nama;
    private String detail;
    private String tempat;
    private String noTelp;
    private String foto;

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {this.nama = nama;}

    public String getTempat() {
        return tempat;
    }
    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getNoTelp() {
        return noTelp;
    }
    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
}
