/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studytracker.domain;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author dell
 */
public class Log {

    private int id;
    private float timespent;
    private LocalDate date;
    private String note;
    //course
    //user

    public Log(int id, float timespent, Date date, String note) {

        this.id = id;
        this.timespent = timespent;
        this.date = LocalDate.now();
        this.note = note;

    }

    public Log() {
        this.id = 0;
        this.timespent = 0;
        this.date = LocalDate.now();
        this.note = "";
    }

}
