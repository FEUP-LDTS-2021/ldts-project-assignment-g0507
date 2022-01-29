package asciibreaker.model;

import asciibreaker.gui.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BrickGenerator {
    protected List<Brick> bricks;

    public BrickGenerator(){
        bricks = new ArrayList<>();
    }

    public void generateLvl1(){
        Random obj = new Random();
        for(int i = 1; i < Config.TERMINAL_WIDTH - 3; i=i+2)
        {
            for(int j = Config.TERMINAL_HEIGHT - 1; j > Config.TERMINAL_HEIGHT - 6; j--)
            {
                int rand_num = obj.nextInt(0xffffff + 1);
                String color = String.format("#%06x", rand_num);
                bricks.add(new Brick(new Position(i, j),new Position(i+2, j), color));
            }
        }
    }
}
