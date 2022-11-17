import java.security.SecureRandom;
import java.sql.Array;
import java.util.*;

public class Fermer extends BaseHero {

    private boolean delivery;

    public Fermer(List<BaseHero> side, int x, int y) {
        super(String.format("Fermer #%d", ++Fermer.number),
                1, 1, 1, 0, new int[]{1}, 3);
        delivery = true;
        position = new PlayingField(x, y);
    }


    @Override
    public String getInfo() {
        return String.format("%s delivery: %b", super.getInfo(), delivery);
    }


}

