package shift;

public class TimetableStudent {

    private Student student;

    private int paid;

    private TimetableStudentLesson[] timetableStudentLessons = new TimetableStudentLesson[12];

    public TimetableStudent(Student student, int paid, TimetableStudentLesson[] timetableStudentLessons) {
        this.student = student;
        this.paid = paid;
        this.timetableStudentLessons = timetableStudentLessons;
    }

    public Student getStudent() {
        return student;
    }

    public String getStudentName(){
        return student.getFirstName()+" "+student.getLastName();
    }

    public String showStudentAttendace() {
        String s = "";
        for (TimetableStudentLesson timetableStudentLesson : timetableStudentLessons) {
            if(timetableStudentLesson.isAttendance()){
                s+=1;
            }else{
                s+=0;
            }
        }
        return s;
    }
}
