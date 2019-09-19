package Lesson_1.Obstacle;

import Lesson_1.Obstacle.Obstacle;
import Lesson_1.Team.Competitor;

public class Cross extends Obstacle {
    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}