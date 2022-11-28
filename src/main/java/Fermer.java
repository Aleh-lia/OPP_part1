import java.util.List;

public class Fermer extends BaseHero {

    private boolean delivery;

    public Fermer(List<BaseHero> side, int x, int y) {
        super("Fermer ", 5, 1, 1, 0, new int[]{1, 0}, 3);
        delivery = true;
        position = new  PlayingField(x, y);
    }


}
