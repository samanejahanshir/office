package model.enums;

public enum Degree {
    BACHELOR(0,"Bachelor"),
    PHD(1,"Phd"),
    UNKNOWN(2,"Unknown");
    private int index;
    private  String title;

    Degree(int index, String title) {
        this.index = index;
        this.title = title;
    }

    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }
    public static Degree getDegree(String title){
        for (Degree value : Degree.values()) {
            if(value.title.equals(title)){
                return value;
            }
        }
        return Degree.UNKNOWN;
    }
}
