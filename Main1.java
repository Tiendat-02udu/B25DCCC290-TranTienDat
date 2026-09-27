
class Student {

    private String mssv;
    private String name;
    private double diemCC;
    private double diemGK;
    private double diemCK;


    public Student(String mssv, String name, double diemCC, double diemGK, double diemCK) {
        this.mssv = mssv;
        this.name = name;

        this.diemCC = (diemCC >= 0 && diemCC <= 10) ? diemCC : 0;
        this.diemGK = (diemGK >= 0 && diemGK <= 10) ? diemGK : 0;
        this.diemCK = (diemCK >= 0 && diemCK <= 10) ? diemCK : 0;
    }


    public String getMssv() {
        return mssv;
    }

    public String getName() {
        return name;
    }

    public double getDiemCC() {
        return diemCC;
    }

    public double getDiemGK() {
        return diemGK;
    }

    public double getDiemCK() {
        return diemCK;
    }


    public void setDiemCC(double diemCC) {
        if (diemCC >= 0 && diemCC <= 10) {
            this.diemCC = diemCC;
        } else {
            System.out.println("Cảnh báo: Điểm chuyên cần không hợp lệ. Không cập nhật.");
        }
    }

    public void setDiemGK(double diemGK) {
        if (diemGK >= 0 && diemGK <= 10) {
            this.diemGK = diemGK;
        } else {
            System.out.println("Cảnh báo: Điểm giữa kỳ (" + diemGK + ") không hợp lệ. Bị chặn, không cập nhật.");
        }
    }

    public void setDiemCK(double diemCK) {
        if (diemCK >= 0 && diemCK <= 10) {
            this.diemCK = diemCK;
        } else {
            System.out.println("Cảnh báo: Điểm cuối kỳ không hợp lệ. Không cập nhật.");
        }
    }


    public double diemTrungBinh() {

        return (this.diemCC * 0.1) + (this.diemGK * 0.3) + (this.diemCK * 0.6);
    }
}


public class Main {
    public static void main(String[] args) {
        // Tạo 3 sinh viên với điểm khác nhau
        Student sv1 = new Student("SV001", "Nguyễn Văn A", 9.0, 8.0, 7.5);
        Student sv2 = new Student("SV002", "Trần Thị B", 10.0, 9.0, 9.5);
        Student sv3 = new Student("SV003", "Lê Văn C", 8.5, 6.5, 8.0);


        System.out.println("--- THÔNG TIN SINH VIÊN ---");
        inThongTin(sv1);
        inThongTin(sv2);
        inThongTin(sv3);


        System.out.println("\n--- TEST ĐIỀU KIỆN ĐẠT ---");


        System.out.println("1. Đổi điểm CK của SV1 thành 10.0 (Điểm SV2, SV3 không đổi)");
        sv1.setDiemCK(10.0);
        System.out.println("ĐTB mới của SV1: " + sv1.diemTrungBinh());
        System.out.println("ĐTB của SV2 vẫn là: " + sv2.diemTrungBinh());


        System.out.println("\n2. Thử cập nhật điểm GK không hợp lệ cho SV3 (Điểm GK hiện tại: " + sv3.getDiemGK() + ")");

        System.out.print("Thử gọi sv3.setDiemGK(-1): ");
        sv3.setDiemGK(-1);
        System.out.println("Điểm GK sau khi thử cập nhật -1: " + sv3.getDiemGK());

        System.out.print("Thử gọi sv3.setDiemGK(11): ");
        sv3.setDiemGK(11);
        System.out.println("Điểm GK sau khi thử cập nhật 11: " + sv3.getDiemGK());
    }


    public static void inThongTin(Student sv) {
        System.out.printf("MSSV: %s | Tên: %-15s | ĐTB: %.2f\n", sv.getMssv(), sv.getName(), sv.diemTrungBinh());
    }
}