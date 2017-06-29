package com.ashin.controller;


import com.ashin.DAO.*;
import com.ashin.model.*;
import com.ashin.security.JwtGetUserDetail;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by trile on 6/3/2017.
 */
@RestController
public class TriService {

    private CommentDAO commentDAO = new CommentDAO();
    private TopicDAO topicDAO = new TopicDAO();
    private RegisterDAO registerDAO = new RegisterDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();
    private static final String SUCCESS_RESULT = "SUCCESS";
    private static final String FAILURE_RESULT = "FAILURE";

    @RequestMapping(value = "comments/getCommentByTopic/{id}/{offset}/{numPages}", method = RequestMethod.GET)
    public ArrayList<Comment> getCommentByPage(@PathVariable int id, @PathVariable int offset, @PathVariable int numPages) {
        commentDAO.setPages(numPages);
        ArrayList<Comment> comments = commentDAO.getCommentPerOffset(id, offset);
        return comments;
    }

    @RequestMapping(value = "comments/addComment", method = RequestMethod.POST)
    public String addComment(@RequestBody Comment cmt) {
        cmt.setUserID(JwtGetUserDetail.getCurrentUserDetail().getUsername());
        int result = commentDAO.addComment1(cmt);
        if (result == 1) {
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @RequestMapping(value = "comments/editComment", method = RequestMethod.PUT)
    public String editComment(@RequestBody Comment cmt) throws SQLException {
        int result = commentDAO.editComment(cmt);
        if (result == 1) {
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @RequestMapping(value = "comments/delComment", method = RequestMethod.DELETE)
    public Comment delComment(@RequestBody Comment cmt) throws SQLException {
        Comment result = commentDAO.deleteComment(cmt);
        return result;
    }

    @RequestMapping(value = "topics/getByClass/{idClass}/{maxid}/{numPages}", method = RequestMethod.GET)
    public ArrayList<Topic> getTopicPerPage(@PathVariable int idClass,@PathVariable int maxid, @PathVariable int numPages) {
        ArrayList<Topic> result = topicDAO.getTopicPerPage(idClass, maxid, numPages);
        return result;
    }

    @RequestMapping(value = "topics/{idClass}/{idTopic}", method = RequestMethod.GET)
    public Topic getTopic(@PathVariable int idClass, @PathVariable int idTopic) {
        Topic topic = topicDAO.getATopic(idClass, idTopic);
        return topic;
    }


    @RequestMapping(value = "topics/createTopic", method = RequestMethod.POST)
    public String createTopic(@RequestBody Topic topic) {
        int result = topicDAO.createTopic(topic);
        if (result == 1) {
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @RequestMapping(value = "topics/editTopic", method = RequestMethod.PUT)
    public String editTopic(@RequestBody Topic topic) throws SQLException {
        int result = topicDAO.editTopic(topic);
        if (result == 1) {
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @RequestMapping(value = "topics/delTopic", method = RequestMethod.DELETE)
    public String delComment(@RequestBody Topic topic) throws SQLException {
        int result = topicDAO.deleteTopic(topic);
        if (result == 1) {
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

    @RequestMapping(value = "getClassTeach/{idTeacher}", method = RequestMethod.GET)
    public ArrayList<TeacherClass> getClassTeach(@PathVariable int idTeacher){
        ArrayList<TeacherClass> result = teacherDAO.getListClasses(idTeacher);
        return result;
    }
    @RequestMapping(value = "/viewTestScheduleTeacher/{semester}/{idTeacher}", method = RequestMethod.GET)
    public ArrayList<TestSchedule> getTestSchedule(@PathVariable int semester, @PathVariable int idTeacher) {
        TestScheDAO testSchDAO = new TestScheDAO();
        return testSchDAO.showTeacherOnTestSche(semester, idTeacher);
    }
    @RequestMapping(value = "/viewTeacherSchedule/{idTeacher}/{semester}/{weekday}", method = RequestMethod.GET)
    public ArrayList<Schedule> getSchedule(@PathVariable int idTeacher, @PathVariable int semester, @PathVariable int weekday) {
        ScheDAO scheDAO = new ScheDAO();
        return scheDAO.showTeacherSchedule(idTeacher, semester, weekday);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@RequestBody UserRegister userRegister){
        int result = registerDAO.addUser(userRegister);
        if(result==1){
            return SUCCESS_RESULT;
        }
        return FAILURE_RESULT;
    }

}
