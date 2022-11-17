import java.util.List;

public class Druid extends BaseHero{
    public boolean magic;




    public Druid(List<BaseHero> band, int x, int y) {
        super(String.format("Druid#%d", ++Druid.number),
                30, 17, 12, 0, new int[]{-5, 0}, 9);
        position = new PlayingField(x, y);
        magic = true;
        super.setBand(band);
    }





    @Override
    public void step(List<BaseHero> side) {
        boolean flag = true;
        int cnt = 0;
        while (flag) {
            if (band.get(cnt++).health < band.get(cnt++).maxHealth) {
                band.get(cnt).health = band.get(cnt).health + 5;
                if (band.get(cnt).health > band.get(cnt).maxHealth) band.get(cnt).health = band.get(cnt).maxHealth;
                flag = false;
                System.out.println(band.get(cnt).getName() + " heald!");
                cnt = 0;
            }
            if (++cnt == band.size()) {
                flag = false;
                System.out.println(" Nobody to heal");
            }

        }
    }
    @Override
    public String getInfo() {
        return String.format("%s magic: %b", super.getInfo(),magic);
    }
}
