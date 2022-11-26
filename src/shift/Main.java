package shift;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Group> groups = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerStr = new Scanner(System.in);
        System.out.println("O'quv markazi dasturiga xush kelibsiz");
        while(true){
            System.out.println("Guruxlar: ");
            if(groups.size()==0){
                System.out.println("Guruxlar hali yuq");
            }
            for (Group group : groups) {
                System.out.println(group.getId()+": " + group.getName());
            }
            System.out.println("1- gurux qo'shish");
            System.out.println("2- guruxni ko'rish");
            switch (scannerInt.nextInt()){
                case 1:
                    System.out.println("Gurux nomini kiriting:");
                    Group group = new Group(
                            Group.nextId++,
                            scannerStr.nextLine()
                    );
                    groups.add(group);
                    break;
                case 2:
                    while(true){
                        System.out.print("Guruxni id sini kiritign:");
                        Group byId = findById(scannerInt.nextInt());
                        if(byId==null){
                            continue;
                        }
                        byId.show();
                    }
                default:
                    System.out.println("Bunday buyruq yo'q");
            }
        }


    }

    static Group findById(int id){
        for (Group group : groups) {
            if(group.getId()==id){
                return group;
            }
        }
        System.out.println("Bunday id li gurux mavjud emas");
        return null;
    }


}