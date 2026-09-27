class Student {
    private static int counter = 0;
    private String mssv;
    private String name;
    private double diemCC;
    private double diemGK;
    private double diemCK;
    private String email;
    private String sdt;

    public Student(String name, double diemCC, double diemGK, double diemCK) {
        counter++;
        this.mssv = String.format("B21DCCN%03d", counter);
        this.name = name;
        this.diemCC = (diemCC >= 0 && diemCC <= 10) ? diemCC : 0;
        this.diemGK = (diemGK >= 0 && diemGK <= 10) ? diemGK : 0;
        this.diemCK = (diemCK >= 0 && diemCK <= 10) ? diemCK : 0;
    }

    public Student capNhatEmail(String email) {
        this.email = email;
        return this;
    }

    public Student capNhatSdt(String sdt) {
        this.sdt = sdt;
        return this;
    }

    public static int getTotalStudents() {
        return counter;
    }

    public String getMssv() { return mssv; }
    public String getName() { return name; }
    public double getDiemCC() { return diemCC; }
    public double getDiemGK() { return diemGK; }
    public double getDiemCK() { return diemCK; }

    public void setDiemCC(double diemCC) {
        if (diemCC >= 0 && diemCC <= 10) this.diemCC = diemCC;
    }

    public void setDiemGK(double diemGK) {
        if (diemGK >= 0 && diemGK <= 10) this.diemGK = diemGK;
    }

    public void setDiemCK(double diemCK) {
        if (diemCK >= 0 && diemCK <= 10) this.diemCK = diemCK;
    }

    public double diemTrungBinh() {
        return (this.diemCC * 0.1) + (this.diemGK * 0.3) + (this.diemCK * 0.6);
    }
}

public class Main2 {
    public static void main(String[] args) {
        Student sv1 = new Student("Lan", 8, 7.5, 9);
        sv1.capNhatEmail("lan@ptit.edu.vn").capNhatSdt("0912345678");

        Student sv2 = new Student("Hieu", 9.0, 8.5, 8.0);
        Student sv3 = new Student("Quynh", 10.0, 9.0, 9.5);

        System.out.println(sv1.getMssv());
        System.out.println(sv2.getMssv());
        System.out.println(sv3.getMssv());
        System.out.println(Student.getTotalStudents());
    }
}