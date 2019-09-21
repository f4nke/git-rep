package FACULTATIVE;

public enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;


    static void getWorkHours(Days days) {

        switch (days) {

            case MONDAY:
                System.out.println("Осталось 40 часов");
                break;

            case TUESDAY:
                System.out.println("Осталось 32 часов");
                break;

            case WEDNESDAY:
                System.out.println("Осталось 24 часов");
                break;

            case THURSDAY:
                System.out.println("Осталось 16 часов");
                break;

            case FRIDAY:
                System.out.println("Осталось 8 часов");
                break;

            case SUNDAY:
                System.out.println("Выходной");
                break;

            case SATURDAY:
                System.out.println("Выходной");
                break;
        }
    }
}


