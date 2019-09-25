package lessons8;

public enum Monthes {
    JANUARY(1),
    FEBRUARY(2),
    MARTH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGYST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private int mainCod;

    Monthes(int mainCod) {
        this.mainCod = mainCod;
    }

    public int getMainCod() {
        return mainCod;
    }

    public void setMainCod(int mainCod) {
        this.mainCod = mainCod;
    }
}
