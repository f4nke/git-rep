package Lesson_1.Obstacle;

import Lesson_1.Obstacle.Obstacle;
import Lesson_1.Team.Competitor;

public class Water extends Obstacle {
    int length;

    public Water(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(length);
    }
}