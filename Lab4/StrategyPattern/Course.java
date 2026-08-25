public class Course {
    private String title;
    private String instructor;
    private String[] students;
    private Sort srt;

    public Course(Sort st){
        this.srt = st;
    }

    public void coursesort() {
        srt.sort();
    }
    
    public void setSortStrategy(Sort st) {
        this.srt = st;
    }
}