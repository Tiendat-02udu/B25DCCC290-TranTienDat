import java.util.ArrayList;

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

    public String getMssv() { return mssv; }
    public String getName() { return name; }

    public double diemTrungBinh() {
        return (this.diemCC * 0.1) + (this.diemGK * 0.3) + (this.diemCK * 0.6);
    }
}

// Lớp Classroom có tên lớp và danh sách sinh viên
class Classroom {
    private String tenLop;
    private ArrayList<Student> danhSach;

    public Classroom(String tenLop) {
        this.tenLop = tenLop;
        this.danhSach = new ArrayList<>();
    }

    // Phương thức từ chối thêm nếu mssv đã tồn tại
    public void addStudent(Student s) {
        for (Student student : danhSach) {
            if (student.getMssv().equals(s.getMssv())) {
                throw new IllegalArgumentException("MSSV " + s.getMssv() + " đã tồn tại trong lớp!");
            }
        }
        danhSach.add(s);
    }

    // Phương thức xếp loại dựa trên điểm trung bình
    public String xepLoai(Student s) {
        double dtb = s.diemTrungBinh();
        if (dtb >= 8.0) return "Giỏi";
        if (dtb >= 6.5) return "Khá";
        if (dtb >= 5.0) return "Trung bình";
        return "Yếu";
    }

    // Phương thức in bảng điểm và sĩ số
    public void inBangDiem() {
        System.out.println("--- BẢNG ĐIỂM LỚP " + tenLop + " ---");
        for (Student s : danhSach) {
            System.out.printf("MSSV: %s | Tên: %-15s | ĐTB: %.2f | Xếp loại: %s\n",
                    s.getMssv(), s.getName(), s.diemTrungBinh(), xepLoai(s));
        }
        System.out.println("-> Sĩ số lớp: " + danhSach.size());
    }
}

public class Main3 {
    public static void main(String[] args) {
        Classroom myClass = new Classroom("D24CQCN01-B");

        Student sv1 = new Student("SV001", "Nguyễn Văn A", 9.0, 8.0, 7.5);  // ĐTB: ~7.8 (Khá)
        Student sv2 = new Student("SV002", "Trần Thị B", 10.0, 9.0, 9.5);   // ĐTB: 9.4 (Giỏi)
        Student sv3 = new Student("SV003", "Lê Văn C", 4.0, 5.0, 4.5);      // ĐTB: 4.6 (Yếu)

        // Sinh viên này cố tình để trùng MSSV với sv1
        Student sv4 = new Student("SV001", "Kẻ Mạo Danh", 10.0, 10.0, 10.0);

        // Thêm các sinh viên hợp lệ
        myClass.addStudent(sv1);
        myClass.addStudent(sv2);
        myClass.addStudent(sv3);

        // Thử thêm sinh viên có MSSV trùng và bắt lỗi bằng try-catch
        System.out.println("--- THỬ THÊM SINH VIÊN TRÙNG MSSV ---");
        try {
            myClass.addStudent(sv4);
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        System.out.println("\nChương trình vẫn chạy tiếp tục sau khi bắt lỗi...\n");

        // In bảng điểm
        myClass.inBangDiem();
    }
}