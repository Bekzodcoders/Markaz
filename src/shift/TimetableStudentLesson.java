package shift;

public class TimetableStudentLesson {

    private Lesson lesson;

    private boolean attendance;

    public TimetableStudentLesson(Lesson lesson, boolean attendance) {
        this.lesson = lesson;
        this.attendance = attendance;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public boolean isAttendance() {
        return attendance;
    }
}
