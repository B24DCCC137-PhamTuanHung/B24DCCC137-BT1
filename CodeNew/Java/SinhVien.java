public class SinhVien {
    private String maSv;
    private String hoTen;
    private int tuoi;

    private static int soLuong = 0;

    public SinhVien() {
        soLuong++; 
    }

    public void setThongTin(String maSv, String hoTen, int tuoi) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public void hienThiThongTin() {
        System.out.println("Mã SV: " + maSv);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Tuổi: " + tuoi);
    }

    public static void hienThiSoLuong() {
        System.out.println("Tổng số sinh viên: " + soLuong);
    }
}
