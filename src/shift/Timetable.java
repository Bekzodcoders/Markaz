package shift;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Timetable {

    public static int nextId;
    private int id;
    private String name;
    private Date startedDate;
    private int price;

    private ArrayList<TimetableStudent> timetableStudents = new ArrayList<>();

    private Scanner scannerInt = new Scanner(System.in);
    private Scanner scannerStr = new Scanner(System.in);

    public Timetable(int id, String name, Date startedDate, int price) {
        this.id = id;
        this.name = name;
        this.startedDate = startedDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public int getPrice() {
        return price;
    }


    public void show() {
        while (true) {
            System.out.println(id + ": " + name);
            System.out.println("Students:");
            showStudents();
            System.out.println("1- shift.Student qo'shish");
            System.out.println("0 - orqaga");
            switch (scannerInt.nextInt()) {
                case 1:
                    addStudent();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Bunday buyruq yo'q");
            }
        }
    }

    private void addStudent() {
        System.out.println("Firstname:");
        String firstName = scannerStr.nextLine();
        System.out.println("LastName:");
        String lastName = scannerStr.nextLine();
        Student student = new Student(1, firstName, lastName);
        timetableStudents.add(new TimetableStudent(
                student,
                100,
                generateTimetableStudentLesson()
        ));
    }

    private TimetableStudentLesson[] generateTimetableStudentLesson() {
        TimetableStudentLesson[] timetableStudentLessons = new TimetableStudentLesson[12];
        for (int i = 0; i < timetableStudentLessons.length; i++) {
            timetableStudentLessons[i] = new TimetableStudentLesson(
                    new Lesson((i + 1), (i + 1) + "-lesson"),
                    false
            );
        }
        return timetableStudentLessons;
    }


    private void showStudents() {
        if (timetableStudents.size() == 0) {
            System.out.println("Hali student mavjud emas");
        }
        for (TimetableStudent timetableStudent : timetableStudents) {
            System.out.println(timetableStudent.getStudentName() +" "+ timetableStudent.showStudentAttendace());
        }
    }
}
