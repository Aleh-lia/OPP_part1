import java.util.List;

public class Pikeman extends BaseHero {
    
    public Pikeman(List<BaseHero> band, int x, int y) {
        super(String.format("Pikeman#%d", ++Pikeman.number), 10, 4, 5, 0, new int[]{1, 3}, 4);
        position = new  PlayingField(x, y);
        super.setBand(band);
    }

}
