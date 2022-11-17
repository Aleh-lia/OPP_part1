import java.util.List;

public class Sniper extends BaseHero{
    public Sniper(List<BaseHero> side, int x, int y){
        super(String.format("Sniper#%d", ++Sniper.number),
                15, 12, 10, 32, new int[]{8, 10},  9);
        position = new PlayingField(x, y);
    }

    @Override
    public String getName() {

        return "Snip " + name;
    }



}
