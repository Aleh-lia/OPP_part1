import java.util.List;

public abstract class BaseHero implements Actions {
    protected static int number;
    private String name;
    protected int attack;
    protected int defence;
    protected int shot;
    protected  PlayingField damage;
    protected float health;
    protected int maxHealth;
    private int speed;
    private String status;
    protected List<BaseHero> band;
    protected  PlayingField position;

    protected int count;
    
    static {
        number = 0;
    }

    protected float getDist(PlayingField dist){
        float dx = position.x - dist.x;
        float dy = position.y - dist.y;
        return (float) Math.sqrt(dx*dx + dy*dy);
    }



    /*    Проверка стоит ли на tmpV кто-нибудь   */
    protected static boolean chPlace(PlayingField tmpV, List<BaseHero> side, List<BaseHero> band) {
        for (int i = 0; i < side.size(); i++) {
            if (side.get(i).position.checkPlace(tmpV) && !side.get(i).getStatus().equals("Die")) return false;
        }

        for (int i = 0; i < band.size(); i++) {
            if (band.get(i).position.checkPlace(tmpV) && !side.get(i).getStatus().equals("Die")) return false;
        }
        return true;
    }


    protected void setBand(List<BaseHero> band){
        this.band = band;
    }

    protected PlayingField getPosition() {
        return position;
    }

    public BaseHero(String name, int health) {
        this.name = name;
        this.health = this.maxHealth = health;
        status = "stand";
        number++;
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


    public String getName() {
        return name;
    }
    protected String getStatus() {
        return status;
    }

    protected void setStatus(String status) { this.status = status; }


    protected void getDamaged(float damagePower) {
        health -= damagePower;

        if (health < 1) {
            int tmp = (int) Math.ceil(health / maxHealth);
            damagePower += maxHealth * (tmp);
            count += tmp - 1;
            if (count < 1) {
                count = 0;
                health = 0;
                status = "Die";
            } else {
                health = maxHealth;
            }

        }
    }
    @Override
    public String returnCondition() {
        return name + "x " + count + AnsiColors.ANSI_YELLOW +
                " H:" + Math.ceil(health) +
                " D:" + defence +
                " A:" + attack +
                " Dmg:" + (int)(Math.abs((damage.x+damage.y)/2)) +
                (shot>0?" Shots:" + shot:"") + " " + AnsiColors.ANSI_RESET +
                status ;
    }


    public float getSpeed() {
        return speed;
    }
}