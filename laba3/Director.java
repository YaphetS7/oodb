public class Director {

    private String name;
    private int experience;
    private Deputy deputer;

    public Director(String name, int experience, Deputy deputer) {
        this.name = name;
        this.experience = experience;
        this.deputer = deputer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Deputy getDeputer() {
        return deputer;
    }

    public void setDeputer(Deputy deputer) {
        this.deputer = deputer;
    }
}
