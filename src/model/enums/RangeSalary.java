package model.enums;

public enum RangeSalary {
    ONE_TO_FIVE("1 to 5"),
    FIVE_TO_TEN("5 to 10"),
    UP_TEN("UP 10");
    private String range;

    RangeSalary(String range) {
        this.range = range;
    }

    public String getRange() {
        return range;
    }
}
