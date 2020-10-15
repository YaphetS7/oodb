public class Student implements Comparable<Student>{
    private String name;

    private String nOfGradebook;

    public String getnOfGradebook() {
        return nOfGradebook;
    }

    public void setnOfGradebook(String nOfGradebook) {
        this.nOfGradebook = nOfGradebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}