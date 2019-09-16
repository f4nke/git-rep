package Lesson_1.Team;

import Lesson_1.Team.Competitor;

import java.util.Arrays;


public class Team {
    private String name;
    Competitor[] competitors;




    public Team (String name, Competitor... competitors) {
        this.name = name;
        this.competitors = competitors;
    }
    public  Competitor[] getCompetitors() {
        return competitors;
    }
// метод вывода инфы о команде
           public void teamInfo() {
                   System.out.println("Список команды " + name + ":\n");
                   for (Competitor a : competitors) {
                       System.out.println(a + "\n");
                   }
           }
// метод вывода инфы об участниках, прощедших дистанци.
           public void passInfo() {

               for (Competitor a : competitors)
                   if(a.isOnDistance()) {
                       a.info();
                   }
                    else {
                       a.info();

                   }
               System.out.println();

               }





    }

