public class Druid extends BaseHero{
    public boolean magic;




    public Druid() {
        super(String.format("Druid#%d", ++Druid.number),
                30, 17, 12, 0, new int[]{-5, 0}, 9);
    }

    @Override
    public String getInfo() {
        return String.format("%s magic: %b", super.getInfo(),magic);
    }
}
