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

    public Log(String courseId, float timespent, String note) {

        this.id = 1;
        this.timespent = timespent;
        this.courseId = courseId;
        this.note = note;

    }

    public Log() {
        this.id = 1;
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

    public void setTimeSpent(float timespent) {
        this.timespent = timespent;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
       @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course:").append(getCourseId()).append("\t Time spent: ").append(getTimeSpent()).append("\t Note: ").append(getNote()).append("\n");
        return sb.toString();
    }

}
