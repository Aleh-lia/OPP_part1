public abstract class BaseHero implements Actions {
    protected static int number;
    protected String name;
    private int attack;
    private int def;
    private int shot;
    private int[] damage;
    private int health;
    protected int speed;
    protected int delivery;
    protected int magic;



    static {
        number = 0;
    }


    public BaseHero(String name, int health) {
        this.name = name;
        this.health = health;

    }

    public BaseHero(String name, int health, int attack,
                    int def, int shot, int[] damage, int speed) {
        this(name, health);
        this.attack = attack;
        this.def = def;
        this.damage = damage;
        this.shot = shot;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }
    public int[] getDamage() {
        return damage;
    }

    public int getAttack() {
        return attack;
    }
    public int getDef() {
        return def;
    }
    public int getHealth() {
        return health;
    }
    public int getSpeed() {
        return speed;
    }

    public int getShot() {
        return shot;
    }

    public int setShot(int shot) {
        if (shot < 1) return -1;
        if (shot > 32) return -2;
        this.shot = shot;
        return shot;
    }





//

    public String getInfo() {
        return String.format("%s: %s htlh: %d attk: %d def: %d shot: %d dmg: %d-%d speed: %d",
                this.getClass().getSimpleName(), name, health, attack,
                def, shot, damage[0], damage[1], speed);
    }


}
