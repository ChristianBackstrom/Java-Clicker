public class clicker {
    private int clicks;
    private int clicksPerSec;
    private int clicksPerClick;
    private int priceRange;

    public clicker(){
        clicks = 0;
        clicksPerSec = 0;
        clicksPerClick = 1;
        priceRange = 1;
    }

    public void increaseCPC(int i){
        clicksPerClick += i;
    }

    public void increaseCPS(int i){
        clicksPerSec += i;
    }

    public void increaseClicks(){
        clicks += clicksPerClick;
    }

    public void inreaseTenCPS(){
        if (clicks >= priceRange()){
            clicks -= priceRange();
            priceRange++;
            increaseCPS(10);
        }
    }

    public int priceRange(){
        return priceRange*priceRange;
    }

    public int getClicks() {
        return clicks;
    }

    public int getClicksPerSec() {
        return clicksPerSec;
    }

    public int getClicksPerClick() {
        return clicksPerClick;
    }
}
