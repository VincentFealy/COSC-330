public class Main {
    public static void main(String[] args) {
        Course course = new Course(new BubbleSort());
        course.coursesort();
        
        // User can alternate sorting algorithm without modifying existing class library
        course.setSortStrategy(new MergeSort());
        course.coursesort();
    }
}