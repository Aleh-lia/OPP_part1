import java.util.List;

public class Archer extends BaseHero {
    
    public Archer(List<BaseHero> band, int x, int y) {
        super(String.format("Archer#%d", ++Archer.number), 10, 6, 3, 16, new int[]{2, 3}, 4);
        position = new  PlayingField(x, y);
        super.setBand(band);
    }

    @Override
    public void step(List<BaseHero> side) {
        boolean flag = true;
        int cnt = 0;

        float tmpH = side.get(0).health, index = 0;
        for (int i = 1; i < side.size(); i++) {
            if (tmpH > side.get(i).health) {
                tmpH = side.get(i).health;
                index = i;
            }
        }
        band.get(cnt).getDamaged((damage.x+damage.y)/2);
    }

}
