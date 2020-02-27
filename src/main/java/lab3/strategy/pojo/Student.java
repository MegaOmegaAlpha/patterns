package lab3.strategy.pojo;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String lastName;
    private List<Subject> subjectList;

    public Student(String lastName, List<Subject> subjectList) {
        this.lastName = lastName;
        this.subjectList = subjectList;
    }

    public Student() {
        subjectList = new ArrayList<>();
        lastName = "";
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
