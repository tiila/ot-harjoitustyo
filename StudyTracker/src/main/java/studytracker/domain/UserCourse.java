/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.domain;

/**
 *
 * @author dell
 */
public class UserCourse {

    private int id;
    private int userId;
    private String courseId;

    public UserCourse() {
        this.id = 0;
        this.userId = 0;
        this.courseId = "";

    }

    public UserCourse(int id, int userId, String courseId) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;

    }

    public UserCourse(int userId, String courseId) {
        this.id = 0;
        this.userId = userId;
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return courseId;
    }

}
