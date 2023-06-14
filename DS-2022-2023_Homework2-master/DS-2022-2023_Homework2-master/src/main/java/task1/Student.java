package task1;

import java.util.Date;
public class Student implements Comparable<Student> {
    private int id;
    private String fullName;
    private Date dateOfBirth;
    private String universityName;
    private String departmentCode;
    private String departmentName;
    private int yearOfEnrollment;

    public Student(int id, String fullName, Date dateOfBirth, String universityName, String departmentCode, String departmentName, Integer yearOfEnrollment) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.universityName = universityName;
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.yearOfEnrollment = yearOfEnrollment;
    }

    public void setId(int id) {
        this.id=id;
    }
    public void setFullName(String fullName) {
        this.fullName=fullName;
    }
    public void  setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth=dateOfBirth;
    }
    public void setUniversityName(String universityName){this.universityName=universityName;}
    public void setDepartmentCode(String departmentCode){this.departmentCode=departmentCode;}
    public void setDepartmentName(String departmentName){this.departmentName=departmentName;}
    public void setyearOfEnrollment(Integer yearOfEnrollment){this.yearOfEnrollment=yearOfEnrollment;}

    public String getFullName(){
        return this.fullName;
    }
    public String getUniversityName(){
        return this.universityName;
    }
    public String getDepartmentCode() {
        return this.departmentCode;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    public int getId() {
        return this.id;
    }
    public int getYearOfEnrollment() {
        return this.yearOfEnrollment;
    }
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.id, o.id);
    }
    @Override
    public String toString() {
        return "Student ID: " + id +
                "\nName and Surname: " + fullName +
                "\nDate of Birth: " + dateOfBirth +
                "\nUniversity Name: " + universityName +
                "\nDepartment Code: " + departmentCode +
                "\nDepartment Name: " + departmentName +
                "\nYear of Enrolment: " + yearOfEnrollment;
    }
}