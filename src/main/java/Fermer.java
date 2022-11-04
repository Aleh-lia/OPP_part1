import java.security.SecureRandom;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;

public class Fermer extends BaseHero {

    private boolean delivery;

    public Fermer() {
        super(String.format("Fermer #%d", ++Fermer.number),
                1, 1, 1, 0, new int[]{1}, 3);
        delivery = true;
    }


    @Override
    public String getName() {
        return "Fer " + name;

    }

    @Override
    public String getInfo() {
        return String.format("%s delivery: %b", super.getInfo(), delivery);
    }


}

