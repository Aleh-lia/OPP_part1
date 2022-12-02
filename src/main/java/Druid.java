import java.util.List;

public class Druid extends BaseHero {
   
    private boolean magic;

    public Druid(List<BaseHero> band, int x, int y, int cnt) {
        super("Druid ", 30, 17, 12, 0, new int[]{-2, 0}, 9);
        count = cnt;
        magic = true;
        position = new  PlayingField(x, y);
        super.setBand(band);
    }

    @Override
    public void step(List<BaseHero> side) {
        if (getStatus().equals("Die")) return;
        boolean flag = true;
        int cnt = 0;
        while (flag){
            if (!band.get(cnt).getStatus().equals("Die") && band.get(cnt).health < band.get(cnt).maxHealth){
                band.get(cnt).getDamaged(damage.x * count);
                setStatus("held: " + (cnt + 1));
                if (band.get(cnt).health > band.get(cnt).maxHealth) band.get(cnt).health = band.get(cnt).maxHealth;
                flag = false;
                cnt = 0;
                return;
            }
            if (++cnt == band.size()) flag = false;
        }
    }



}
