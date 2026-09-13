package Javafiles.model;

public class PerformanceRecord {

    private String studentId;
    private String subject;
    private double marks;

    public PerformanceRecord(String studentId,
            String subject,
            double marks) {
        this.studentId = studentId;
        this.subject = subject;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B+";
        } else if (marks >= 60) {
            return "B";
        } else if (marks >= 50) {
            return "C";
        } else if (marks >= 40) {
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public String toString() {
        return "\nSubject : " + subject +
                "\nMarks   : " + String.format("%.2f", marks) +
                "\nGrade   : " + getGrade();
    }
}
