import java.util.List;

public class Monk extends BaseHero {

    private boolean magic;

    public Monk(List<BaseHero> band, int x, int y) {
        super(String.format("Monk#%d", ++Monk.number), 30, 12, 7, 0, new int[]{-4, 0}, 5);
        magic = true;
        position = new  PlayingField(x, y);
        super.setBand(band);
    }


    @Override
    public void step(List<BaseHero> side) {
        boolean flag = true;
        int cnt = 0;
        while (flag){
            if (band.get(cnt).health < band.get(cnt).maxHealth*2){
                band.get(cnt).getDamaged(damage.x);
                if (band.get(cnt).health > band.get(cnt).maxHealth*2) band.get(cnt).health = band.get(cnt).maxHealth;
                flag = false;
                cnt = 0;
            }
            if (++cnt == band.size()) flag = false;
        }
    }

    @Override
    public String getInfo() {
        return String.format("%s  magic: %b", super.getInfo(), magic);
    }



}
