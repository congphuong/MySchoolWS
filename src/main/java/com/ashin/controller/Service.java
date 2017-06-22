package com.ashin.controller;

/**
 * Created by anluo on 6/3/2017.
 */

import com.ashin.DAO.*;
import com.ashin.model.*;
import com.ashin.security.JwtGetUserDetail;
import com.ashin.security.JwtUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Service {
    AccountDAO ad = new AccountDAO();
    NotifDAO nd = new NotifDAO();
    ScoreDAO sd = new ScoreDAO();
    ParentDAO pd = new ParentDAO();
    StudentDAO std = new StudentDAO();
    TeacherDAO td = new TeacherDAO();

    @RequestMapping(value = "notification/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Notification loadNotifById(@PathVariable int id) {
        return nd.view(id);
    }

    @RequestMapping(value = "notifications/receivers/{page}&{numPerPage}",method = RequestMethod.GET,headers ="Accept=application/json")
    public List<Notification> loadNotifByReceiver(@PathVariable int page,@PathVariable int numPerPage) {
        return nd.loadNotifPerPageReceiver(page,numPerPage,JwtGetUserDetail.getCurrentUserDetail().getUsername());
    }
    @RequestMapping(value = "notifications/senders/{page}&{numPerPage}",method = RequestMethod.GET,headers ="Accept=application/json")
    public List<Notification> loadNotifBySender(@PathVariable int page,@PathVariable int numPerPage) {
        return nd.loadNotifPerPageSender(page,numPerPage,JwtGetUserDetail.getCurrentUserDetail().getUsername());
    }

    @RequestMapping(value = "notification", method = RequestMethod.POST)
    public void postNo(@RequestBody Notification input) {
        nd.insert(input);
        System.out.println("succeed");
    }
    @RequestMapping(value = "notification/group", method = RequestMethod.POST)
    public void postGroupNo(@RequestBody GroupNotification input) {
        nd.insertGroup(input);
        System.out.println("succeed");
    }

    @RequestMapping(value = "notification/{id}", method = RequestMethod.PUT)
    public void updateNo(@PathVariable int id, @RequestBody Notification newnotif) {
        nd.update(id, newnotif);
        System.out.println("succeed");
    }

    @RequestMapping(value = "getScoreBoard/{idStudent}", method = RequestMethod.GET, headers = "Accept=application/json")
    public ArrayList<ScoreBoard> showScore(@PathVariable int idStudent) {
        return sd.showScore(idStudent);
    }

    @RequestMapping(value = "parents/{idparent}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Parent showParentInfor(@PathVariable int idparent) {
        return pd.showInformationParent(idparent);
    }

    @RequestMapping(value = "parentsbyclass/{idclass}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Parent> showParentInforByClass(@PathVariable int idclass) {
        return pd.showListParents(idclass);
    }

    @RequestMapping(value = "students/{idstudent}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Student showStudentInfor(@PathVariable int idstudent) {
        return std.showInformationStudent(idstudent);
    }

    @RequestMapping(value = "studentsbyclass/{idclass}", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Student> showStudentInforByClass(@PathVariable int idclass) {
        return std.showListStudent(idclass);
    }

    @RequestMapping(value = "teachers/{idteacher}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Teacher showTeacherInfor(@PathVariable int idteacher) {
        return td.showInformationTeacher(idteacher);
    }

    @RequestMapping(value = "updateToken", method = RequestMethod.PUT)
    public void updateToken(@RequestBody Account input) {
        ad.updateToken(input);
        System.out.println("succeed");
    }

    @RequestMapping(value = "getUserJWT", method = RequestMethod.GET, headers = "Accept=application/json")
    public JwtUser getUser() {
        return JwtGetUserDetail.getCurrentUserDetail();
    }
}
