public class Deputy {

    private int cntOfSubordinates;
    private String name;
    private int experience;

    public Deputy(int cntOfSubordinates, String name, int experience) {
        this.cntOfSubordinates = cntOfSubordinates;
        this.name = name;
        this.experience = experience;
    }

    public int getCntOfSubordinates() {
        return cntOfSubordinates;
    }

    public void setCntOfSubordinates(int cntOfSubordinates) {
        this.cntOfSubordinates = cntOfSubordinates;
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

}
