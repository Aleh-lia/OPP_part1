public class Archer extends BaseHero{
    public int health;
    private float speed;

    public void setHealth(int health) {
        this.health = health;
    }

    public Archer() {
        super(String.format("Archer#%d", ++Archer.number),
                10 , 6, 3, 16, new int[]{2, 3}, 4);

    }

    @Override
    public String getName() {
        return "Arch " + name;
    }



}
