package module03.exercise03;

public class Pet {

    private final String name; // WHY: identity—should not change after creation

    private boolean clean; // WHY: state toggled by the machine

    public Pet(String name) {
        this.name = name; // WHY: set immutable identity
        this.clean = false; // WHY: new pets start dirty by business rule
    }

    public String getName() {
        return name; // WHY: read-only access; field is final
    }

    public boolean isClean() {
        return clean; // WHY: expose cleanliness to machine/UI
    }

    public void setClean(boolean clean) {
        this.clean = clean; // WHY: machine updates cleanliness after bath
    }
}
