import java.util.*;

public class Lesson1 {

    private static final int[] l = {0};
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String midl10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");
    private static final List<BaseHero> oneSquad = new ArrayList<>();
    private static final List<BaseHero> twoSquad = new ArrayList<>();

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }

    private static String getChar(int x, int y){
        String out = "| ";
        for (int cnt = 0; cnt < oneSquad.size(); cnt++) {
            if (oneSquad.get(cnt).getPosition().x == x && oneSquad.get(cnt).getPosition().y == y) {
                out = "|" + (Objects.equals(oneSquad.get(cnt).getStatus(), "Die"));

            } else if (twoSquad.get(cnt).getPosition().x == x && twoSquad.get(cnt).getPosition().y == y) {
                out = "|" +  (oneSquad.get(cnt).getStatus().equals("Die"));

            }
        }
        return out;
    }

    private static void tabSetter(int cnt, int max){
        int dif = max - cnt + 2;
        if (dif>0) System.out.printf("%"+ dif +"s", ":\t"); else System.out.print(":\t");
    }

    public static void init(){
        int x = 1;
        int y = 1;
        oneSquad.add(new Fermer(oneSquad, x++, y));
        oneSquad.add(new Outlaw(oneSquad, x++, y));
        oneSquad.add(new Sniper(oneSquad, x++, y));
        oneSquad.add(new Druid(oneSquad, x++, y));
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            switch (rnd.nextInt(4)){
                case 0:
                    oneSquad.add(new Fermer(oneSquad, x++, y));
                    break;
                case 1:
                    oneSquad.add(new Outlaw(oneSquad, x++, y));
                    break;
                case 2:
                    oneSquad.add(new Sniper(oneSquad, x++, y));
                    break;
                default:
                    oneSquad.add(new Druid(oneSquad, x++, y));
            }
        }

        x = 1;
        y = 10;

        twoSquad.add(new Fermer(twoSquad, x++, y));
        twoSquad.add(new Monk(twoSquad, x++, y));
        twoSquad.add(new Archer(twoSquad, x++, y));
        twoSquad.add(new Spearman(twoSquad, x++, y));
        for (int i = 0; i < 6; i++) {
            switch (rnd.nextInt(4)){
                case 0:
                    twoSquad.add(new Fermer(twoSquad, x++, y));
                    break;
                case 1:
                    twoSquad.add(new Monk(twoSquad, x++, y));
                    break;
                case 2:
                    twoSquad.add(new Archer(twoSquad, x++, y));
                    break;
                default:
                    twoSquad.add(new Spearman(twoSquad, x++, y));
            }
        }

    }

    public static void main(String[] args) {
        int step = 1;
        init();
        Scanner in = new Scanner(System.in);
        System.out.print("Press Enter to begin.");
        in.nextLine();

        while (true) {
            if (step == 1 ){
                System.out.print("First step");
            } else {
                System.out.print("Step:" + step);
            }
            step++;

            view();

            oneSquad.forEach((s) -> s.step(twoSquad));
            twoSquad.forEach((s) -> s.step(oneSquad));

            in.nextLine();
        }

    }

    private static void view() {
        oneSquad.forEach((v) -> l[0] = Math.max(l[0], v.returnCondition().length()));
        for (int i = 0; i < l[0]*2; i++) System.out.print("_");
        System.out.println("");
        System.out.print(top10 + "    ");
        System.out.print("OneSquad");
        for (int i = 0; i < l[0]-9; i++) System.out.print(" ");
        System.out.println(":\tTwoSquad");
        for (int i = 1; i < 11; i++) {
            System.out.print(getChar(1, i));
        }
        System.out.print("|    ");
        System.out.print(oneSquad.get(0).returnCondition());
        tabSetter(oneSquad.get(0).returnCondition().length(), l[0]);
        System.out.println(twoSquad.get(0).returnCondition());
        System.out.println(midl10);

        for (int i = 2; i < 9; i++) {
            for (int j = 1; j < 11; j++) {
                System.out.print(getChar(i, j));
            }
            System.out.print("|    ");
            System.out.print(oneSquad.get(i-1).returnCondition());
            tabSetter(oneSquad.get(i-1).returnCondition().length(), l[0]);

            System.out.println(twoSquad.get(i-1).returnCondition());
            System.out.println(midl10);
        }
        for (int j = 1; j < 11; j++) {
            System.out.print(getChar(10, j));
        }
        System.out.print("|    ");
        System.out.print(oneSquad.get(9).returnCondition());
        tabSetter(oneSquad.get(9).returnCondition().length(), l[0]);
        System.out.println(twoSquad.get(9).returnCondition());
        System.out.println(bottom10);
    }
}
