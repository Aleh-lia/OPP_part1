import java.util.List;

public class Outlaw extends BaseHero {

    public Outlaw(List<BaseHero> side, int x, int y) {
        super(String.format("Outlaw#%d", ++Outlaw.number),
                10, 8, 3, 0, new int[]{2, 4}, 6);
        position = new PlayingField(x, y);
    }

    @Override
    public String getName() {

        return "Out " + name;
    }

}
