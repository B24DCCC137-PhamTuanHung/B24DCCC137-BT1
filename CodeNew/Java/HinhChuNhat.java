public class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public double ChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    public double DienTich() {
        return chieuDai * chieuRong;
    }

    public void ThongTin() {
        System.out.println("Hình chữ nhật: dài = " + chieuDai + ", rộng = " + chieuRong);
        System.out.println("Chu vi: " + ChuVi());
        System.out.println("Diện tích: " + DienTich());
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        HinhChuNhat hcn1 = new HinhChuNhat(5, 3);
        HinhChuNhat hcn2 = new HinhChuNhat(10, 4);
        HinhChuNhat hcn3 = new HinhChuNhat(7.5, 4.2);

        hcn1.ThongTin();
        hcn2.ThongTin();
        hcn3.ThongTin();
    }
}
