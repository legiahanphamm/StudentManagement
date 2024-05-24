package data;

public class Student {

    private String id, name;
    public int yob;
    public double gpa;

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", yob=" + yob + ", gpa=" + gpa + '}';
    }

    public void showProfile() {
        System.out.printf("|%-6s|%-20s|%4d|%4.1f|",
                id, name, yob, gpa);
    }
}
