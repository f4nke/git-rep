package Lesson_1.marathon;

import Lesson_1.Obstacle.*;
import Lesson_1.Team.*;

public class Main {
    public static void main(String[] args) {
        Course a = new Course (new Cross(100), new Wall(10), new Water(100));
        Team b = new Team ("Команда", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"), new Human("Vlad"));
        a.pass(b);
        b.passInfo();
    }
}


//    Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
//    Obstacle[] course = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};
//        for (Competitor c : competitors) {
//                for (Obstacle o : course) {
//                o.doIt(c);
//                if (!c.isOnDistance()) break;
//                }
//                }
//                for (Competitor c : competitors) {
//                c.info();
//                }