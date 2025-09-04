package module07.exercise02;

public enum NumberType {

    LANDLINE_NO_DDD("Landline without DDD"),
    LANDLINE_WITH_DDD("Landline with DDD"),
    LANDLINE_WITH_DDD_INTL("Landline with DDD - Internacional"),
    MOBILE_NO_DDD("Mobile without DDD"),
    MOBILE_WITH_DDD("Mobile with DDD"),
    MOBILE_WITH_DDD_INTL("Mobile with DDD - Internacional");

    private final String label;

    NumberType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
