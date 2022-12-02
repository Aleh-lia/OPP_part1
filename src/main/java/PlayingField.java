public class  PlayingField {
    public float x;
    public float y;

    public  PlayingField(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkPlace(PlayingField place) {
        if (place.x == x && place.y == y) return true;
        return false;
    }
}