import java.util.List;

public abstract class BaseHero implements Actions {
    protected static int number;
    private String name;
    private int attack;
    private int defence;
    private int shot;
    protected  PlayingField damage;
    protected float health;
    protected int maxHealth;
    private int speed;
    private String status;
    protected List<BaseHero> band;
    protected  PlayingField position;
    
    static {
        number = 0;
    }



    protected void setBand(List<BaseHero> band){
        this.band = band;
    }

    public  PlayingField getPosition() {
        return position;
    }

    public BaseHero(String name, int health) {
        this.name = name;
        this.health = this.maxHealth = health;
        this.health--;
        status = "stand";
    }

    public BaseHero(String name, int health, int attack, int protection,
                    int shot, int[] damage, int speed) {
        this(name, health);
        this.attack = attack;
        this.defence = protection;
        this.shot = shot;
        this.damage = new  PlayingField(damage[0], damage[1]);
        this.speed = speed;
    }

    @Override
    public void step(List<BaseHero> side) {}

    @Override
    public String getInfo() {
        return String.format("%s: %s  hlth: %d  attk: %d  protect: %d  shot: %d  dmg: %d-%d  speed: %d",
                this.getClass().getSimpleName(), name, health, attack, defence, shot, damage.x, damage.y, speed);
    }
    public String getName() {
        return name;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefence() {
        return defence;
    }
    public float getHealth() {
        return health;
    }
    public int getShot() {
        return shot;
    }
    public int getSpeed() {
        return speed;
    }
    public String getStatus() {
        return status;
    }

    public static int getNumber(){return number;}

    @Override
    public void strike(BaseHero hero) {}

    @Override
    public void getDamaged(float damagePower) {health -= damagePower;}

    @Override
    public boolean changePosition() {return false;}

    @Override
    public String indicateStatus() {return null;}
    @Override
    public String returnCondition() {
        return name +
                " H:" + Math.round(health) +
                " D:" + defence +
                " A:" + attack +
                " Dmg:" + (int)(Math.abs((damage.x+damage.y)/2)) +
                (shot>0?" Shots:" + shot:"") + " " +
                status;
    }

    public int setShot(int shot) {
        if (shot < 1) return -1;
        if (shot > 32) return -2;
        this.shot = shot;
        return shot;
    }

}