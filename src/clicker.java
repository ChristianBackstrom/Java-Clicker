public class clicker {
    private int clicks;
    private int clicksPerSec;
    private int clicksPerClick;

    public clicker(){
        clicks = 0;
        clicksPerSec = 0;
        clicksPerClick = 1;
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
        if (clicks <= 1000){
            increaseCPS(10);
        }
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
