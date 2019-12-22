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
public class Log {

    private int id;
    private float timespent;
    private String courseId;
    private String note;
    private int userId;

    public Log(float timespent, String courseId, String note) {

        this.id = 1;
        this.timespent = timespent;
        this.courseId = courseId;
        this.note = note;

    }

    public Log() {
        this.id = 0;
        this.timespent = 0;

        this.note = "";
    }

    public float getTimeSpent() {
        return this.timespent;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String getNote() {
        return this.note;
    }

}
