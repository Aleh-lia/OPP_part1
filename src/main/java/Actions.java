import java.util.List;

public interface Actions {

    String getName();

    String getInfo();

    void step(List<BaseHero> side);

    String returnCondition();
    void getDamaged(float damagePower);

}