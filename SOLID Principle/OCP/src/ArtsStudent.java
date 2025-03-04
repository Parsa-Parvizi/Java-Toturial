public class ArtsStudent extends Student {
    public ArtsStudent(String name,
                       String regNumber,
                       double score,
                       String dept) {
        super(name, regNumber, score);
        this.department = dept;
    }
}
