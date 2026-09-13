package Javafiles.model;

public class Attendancerecord {

    private String studentId;
    private int totalClasses;
    private int attendedClasses;

    public Attendancerecord(String studentId,
            int totalClasses,
            int attendedClasses) {

        this.studentId = studentId;
        this.totalClasses = totalClasses;
        this.attendedClasses = attendedClasses;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void setTotalClasses(int totalClasses) {
        this.totalClasses = totalClasses;
    }

    public void setAttendedClasses(int attendedClasses) {
        this.attendedClasses = attendedClasses;
    }

    public double getAttendancePercentage() {

        if (totalClasses == 0) {
            return 0.0;
        }

        return ((double) attendedClasses / totalClasses) * 100;
    }

    public boolean isShortage() {
        return getAttendancePercentage() < 75.0;
    }

    @Override
    public String toString() {

        return "\nStudent ID       : " + studentId +
                "\nTotal Classes    : " + totalClasses +
                "\nAttended Classes : " + attendedClasses +
                String.format(
                        "\nAttendance       : %.2f%%",
                        getAttendancePercentage());
    }
}