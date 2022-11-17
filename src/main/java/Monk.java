import java.util.List;

public class Monk extends BaseHero{
    public boolean magic;


    public Monk(List<BaseHero> band, int x, int y) {
        super(String.format("Monk #%d", ++Monk.number),
                30, 12, 7, 0, new int[]{-4, 0}, 5);
        position = new PlayingField(x, y);
        magic = true;
        super.setBand(band);
    }


    @Override
    public String getInfo() {
        return String.format("%s magic: %b", super.getInfo(),magic);
    }
}
