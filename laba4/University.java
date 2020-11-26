public class University {

    private int cntOfInstitutes;
    private String name;
    private int score;
    private Director director;


    public University(int cntOfInstitutes, String name, int score, Director director){
        this.cntOfInstitutes = cntOfInstitutes;
        this.name = name;
        this.score = score;
        this.director = director;
    }

    public University(){

    }

    public int getCntOfInstitutes() {
        return cntOfInstitutes;
    }

    public void setCntOfInstitutes(int cntOfInstitutes) {
        this.cntOfInstitutes = cntOfInstitutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
