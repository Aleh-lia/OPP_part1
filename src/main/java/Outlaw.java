public class Outlaw extends BaseHero {

    public Outlaw() {
        super(String.format("Outlaw#%d", ++Outlaw.number),
                10, 8, 3, 0, new int[]{2, 4}, 6);
    }

    @Override
    public String getName() {

        return "Out " + name;
    }

}
