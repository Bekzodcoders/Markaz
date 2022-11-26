package shift;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Group {

    public static int nextId;
    private int id;

    private String name;

    private ArrayList<Timetable> timetables = new ArrayList<>();

    private Scanner scannerInt = new Scanner(System.in);

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void show(){
        while(true){
            System.out.println("Name: " + name);
            System.out.println("Timetables: ");
            showTimetables();
            int i = chooseCommand();
            if(i==0){
                break;
            }
        }
    }

    private void showTimetables(){
        if(timetables.size()==0){
            System.out.println("Hali timetable qo'shilmagan");
        }
        for (Timetable timetable : timetables) {
            System.out.println(timetable.getId()+":" + timetable.getName() );
        }
    }

    private int chooseCommand(){
        while(true){
            System.out.println("1-timetable qo'shish");
            System.out.println("2-timetable ko'rish");
            System.out.println("0-orqaga");
            int order = scannerInt.nextInt();
            switch (order){
                case 1:
                    addTimetable();
                    break;
                case 2:
                    System.out.println("shift.Timetable id sini kiriting");
                    Timetable byId = findById(scannerInt.nextInt());
                    if(byId==null){
                        System.out.println("Bunday id li timetable mavjud emas");
                        continue;
                    }
                    byId.show();
                    break;
                case 0:
                    return 0;
                default:
                    System.out.println("Bunday buyruq mavjud emas");
            }
        }
    }

    private void addTimetable(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("shift.Timetable nomini kiriting:");
        Timetable timetable = new Timetable(
            Timetable.nextId++,
                scanner.nextLine(),
                new Date(),
                600000
        );
        timetables.add(timetable);
    }


    private Timetable findById(int id){
        for (Timetable timetable : timetables) {
            if(timetable.getId()==id){
                return timetable;
            }
        }
        return null;
    }

}

