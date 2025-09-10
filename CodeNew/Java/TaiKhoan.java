import java.util.ArrayList;
import java.util.Scanner;

public class TaiKhoan {
    private String soTaiKhoan;
    private String tenTaiKhoan;
    private double soDu;
    private static double laiSuatNam = 0.05; 

    public TaiKhoan(String soTaiKhoan, String tenTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.tenTaiKhoan = tenTaiKhoan;
        this.soDu = soDu;
    }

    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Nạp " + soTien + " thành công vào tài khoản " + soTaiKhoan);
        }
    }

    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rút " + soTien + " thành công từ tài khoản " + soTaiKhoan);
        } else {
            System.out.println("Số dư không đủ!");
        }
    }

    public void LaiHangThang() {
        double lai = soDu * (laiSuatNam / 12);
        soDu += lai;
    }

    public void hienThiThongTin() {
        System.out.println("STK: " + soTaiKhoan + ", Chủ TK: " + tenTaiKhoan + ", Số dư: " + soDu);
    }

    public static void setLaiSuat(double laiSuat) {
        laiSuatNam = laiSuat;
    }

    public double getSoDu() {
        return soDu;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public static ArrayList<TaiKhoan> timTheoSoTaiKhoan(ArrayList<TaiKhoan> danhSach, String soTK) {
        ArrayList<TaiKhoan> ketQua = new ArrayList<>();
        for (TaiKhoan tk : danhSach) {
            if (tk.getSoTaiKhoan().equals(soTK)) {
                ketQua.add(tk);
            }
        }

        ketQua.sort((a, b) -> Double.compare(b.getSoDu(), a.getSoDu()));

        return ketQua;
    }
    public static void main(String[] args) {
        ArrayList<TaiKhoan> danhSach = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        TaiKhoan tk1 = new TaiKhoan("123", "Nguyen Van A", 1000);
        TaiKhoan tk2 = new TaiKhoan("234", "Le Thi B", 2000);
        TaiKhoan tk3 = new TaiKhoan("456", "Tran Van C", 1500); 

        danhSach.add(tk1);
        danhSach.add(tk2);
        danhSach.add(tk3);

        tk1.napTien(500);
        tk2.rutTien(1000);

        for (TaiKhoan tk : danhSach) {
            tk.LaiHangThang();
        }

        System.out.println("\nDanh sách tài khoản:");
        for (TaiKhoan tk : danhSach) {
            tk.hienThiThongTin();
        }

        System.out.print("\nNhập số tài khoản cần tìm: ");
        String soTKCanTim = sc.nextLine();

        ArrayList<TaiKhoan> ketQua = TaiKhoan.timTheoSoTaiKhoan(danhSach, soTKCanTim);

        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy tài khoản nào có số " + soTKCanTim);
        } else {
            System.out.println("\nKết quả tìm kiếm:");
            for (TaiKhoan tk : ketQua) {
                tk.hienThiThongTin();
            }
        }

        sc.close();
    }
}
