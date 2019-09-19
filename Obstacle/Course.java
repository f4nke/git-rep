package Lesson_1.Obstacle;


import Lesson_1.Team.Competitor;
import Lesson_1.Team.Team;

public class Course {

    private Obstacle[] course;

    //Obstacle[] course = {new Cross(80), new Wall(2), new Wall(1), new Cross(120)};

    public Course(Obstacle... course) {
        this.course = course;
    }

    public void pass(Team team) {
        for (Competitor c : team.getCompetitors()) {
            for (Obstacle o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }

        }
    }



}
