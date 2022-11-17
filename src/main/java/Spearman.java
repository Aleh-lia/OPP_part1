import java.util.List;

public class Spearman extends BaseHero{
    public Spearman(List<BaseHero> side, int x, int y) {
        super(String.format("Spearman#%d", ++Spearman.number),
                10, 4, 5, 0, new int[]{1, 3}, 4);
        position = new PlayingField(x, y);
    }

    @Override
    public String getName() {
        return "Spe " + name;
    }
}
