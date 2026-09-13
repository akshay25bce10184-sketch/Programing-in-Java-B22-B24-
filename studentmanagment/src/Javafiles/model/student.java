package Javafiles.model;

public class student {

    private String studentId;
    private String name;
    private String rollNumber;
    private String course;
    private int semester;

    public student(String studentId, String name,
            String rollNumber, String course,
            int semester) {

        this.studentId = studentId;
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
        this.semester = semester;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getCourse() {
        return course;
    }

    public int getSemester() {
        return semester;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", course='" + course + '\'' +
                ", semester=" + semester +
                '}';
    }
}