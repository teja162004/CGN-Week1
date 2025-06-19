interface Course {
    void displayCourseDetails();
}

class JavaCourse implements Course {
    public void displayCourseDetails() {
        System.out.println("Java Course: OOP, Collections, Streams");
    }
}

class PythonCourse implements Course {
    public void displayCourseDetails() {
        System.out.println("Python Course: Basics, Data Science, AI");
    }
}

class CourseFactory {
    public static Course getCourse(String type) {
        if (type.equalsIgnoreCase("Java")) {
            return new JavaCourse();
        } else if (type.equalsIgnoreCase("Python")) {
            return new PythonCourse();
        } else {
            throw new IllegalArgumentException("Unknown course type");
        }
    }
}

public class FactoryMethodPattern {
    public static void main(String[] args) {
        Course java = CourseFactory.getCourse("Java");
        Course python = CourseFactory.getCourse("Python");

        java.displayCourseDetails();
        python.displayCourseDetails();
    }
}

