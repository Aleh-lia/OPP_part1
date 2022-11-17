import java.util.List;

public abstract class BaseHero implements Actions {
    protected static int number;
    protected String name;
    private int attack;
    private int def;
    private int shot;
    protected PlayingField damage;
    protected int health;
    protected int maxHealth;
    protected int speed;

    protected PlayingField position;
    private String status;
    protected int delivery;
    protected int magic;
    protected List<BaseHero> band;



    static {
        number = 0;
    }

    protected void setBand(List<BaseHero> band) {
        this.band = band;
    }

    public PlayingField getPosition() {
        return position;
    }


    public BaseHero(String name, int health) {
        this.name = name;
        this.health = this.maxHealth = health;
        status = "true";


    }

    public BaseHero(String name, int health, int attack,
                    int def, int shot, int[] damage, int speed) {
        this(name, health);
        this.attack = attack;
        this.def = def;
        this.damage = new PlayingField(damage[0], damage[1]);
        this.shot = shot;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }
    public PlayingField getDamage() {
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

    public String getStatus() {
        return status;
    }

    public int setShot(int shot) {
        if (shot < 1) return -1;
        if (shot > 32) return -2;
        this.shot = shot;
        return shot;
    }








//
   @Override
   public void step(List<BaseHero> side) {}


    @Override
    public String getInfo() {
        return String.format("%s: %s htlh: %d attk: %d def: %d shot: %d dmg: %d-%d speed: %d",
                this.getClass().getSimpleName(), name, health, attack,
                def, shot, damage.x, damage.y, speed);
    }



    @Override
    public void getDamaged(float damagePower) {health -= damagePower;}

    public String returnCondition() {
        return name +
                " H:" + Math.round(health) +
                " D:" + def +
                " A:" + attack +
                " Dmg:" + (int)(Math.abs((damage.x+damage.y)/2)) +
                (shot>0?" Shots:" + shot:"") + " " +
                status;
    }





}
