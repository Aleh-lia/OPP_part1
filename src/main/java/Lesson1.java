import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lesson1 {
    public static void main(String[] args) {
        List<BaseHero> oneSquad = new ArrayList<>();
        List<BaseHero> twoSquad = new ArrayList<>();

        oneSquad.add(new Fermer());
        oneSquad.add(new Outlaw());
        oneSquad.add(new Sniper());

        oneSquad.add(new Druid());
        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            switch (rnd.nextInt(4)) {
                case 0:
                    oneSquad.add(new Fermer());
                    break;
                case 1:
                    oneSquad.add(new Outlaw());
                    break;
                case 2:
                    oneSquad.add(new Sniper());
                    break;
                case 3:
                    oneSquad.add(new Druid());
            }
        }

        twoSquad.add(new Fermer());
        twoSquad.add(new Monk());
        twoSquad.add(new Archer());
        twoSquad.add(new Spearman());
        for (int i = 0; i <= 4; i++) {
            switch (rnd.nextInt(4)) {
                case 0:
                    twoSquad.add(new Fermer());
                    break;
                case 1:
                    twoSquad.add(new Monk());
                    break;
                case 2:
                    twoSquad.add(new Archer());
                    break;
                case 3:
                    twoSquad.add(new Spearman());
            }
        }


        System.out.println("oneSquad");
        oneSquad.forEach(n -> System.out.println(n.getName()) );
        System.out.println();
        System.out.println("twoSquad");
        twoSquad.forEach(n -> System.out.println(n.getName()));




    }
}
