import java.util.List;

public class Pikeman extends BaseHero {
    
    public Pikeman(List<BaseHero> band, int x, int y, int cnt) {
        super("Pikeman ", 20, 4, 5, 0, new int[]{2, 4}, 4);
        count = cnt;
        position = new  PlayingField(x, y);
        super.setBand(band);
    }
    @Override
    public void step(List<BaseHero> side) {
        if (getStatus().equals("Die")) return;
        float dist = Integer.MAX_VALUE;
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < side.size(); i++) {
            float tmpDist = getDist(side.get(i).getPosition());
            if (!side.get(i).getStatus().equals("Die") && dist > tmpDist) {
                dist = tmpDist;
                index = i;
                flag = true;
            }
        }
        if (dist < 2 & flag) {
            setStatus("attack: " + (index + 1));
            int dA = attack - side.get(index).defence;
            float dDam = (dA < 0) ? damage.x : ((damage.x + dA) <= damage.y ? (damage.x + dA) : damage.y);
            side.get(index).getDamaged(dDam * count);
        } else if(flag) {
            PlayingField tmpV = new PlayingField(position.x, position.y);
            if (Math.abs(position.y - side.get(index).position.y) > 1) {
                if (position.y > side.get(index).position.y){
                    setStatus("step y");
                    tmpV.y--;
                    if (chPlace(tmpV,side,band)) {
                        position.y--;
                        return;
                    }
                }
                else {
                    setStatus("step y");
                    tmpV.y++;
                    if (chPlace(tmpV,side,band)) {
                        position.y++;
                        return;
                    }
                }
                return;

            }
            if (Math.abs(position.x - side.get(index).position.x) > 1) {
                if (position.x > side.get(index).position.x) {
                    setStatus("step x");
                    tmpV.x--;
                    if (chPlace(tmpV, side, band)) {
                        position.x--;
                        return;
                    }

                }
                else {
                    setStatus("step x");
                    tmpV.x++;
                    if (chPlace(tmpV, side, band)) {
                        position.x++;
                        return;
                    }
                }
            }
        }
        setStatus("stand");

    }

}
