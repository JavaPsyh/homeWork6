package tasks.clone.override;

public class Engine implements Cloneable{
    private String name;
    private String engineType;

    public Engine(String name, String engineType) {
        this.name = name;
        this.engineType = engineType;
    }

    public String getName() {
        return name;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public Engine clone() {
        return new Engine(this.getName(), this.getEngineType());
    }

    @Override
    public String toString() {
        return this.getName() + " and it is " + this.getEngineType() + " type of engine.";
    }
}
