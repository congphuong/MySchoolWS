package com.ashin.controller;


import com.ashin.model.Comment;
import com.ashin.DAO.CommentDAO;
import com.ashin.model.Topic;
import com.ashin.DAO.TopicDAO;
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
    private static final String SUCCESS_RESULT = "SUCCESS";
    private static final String FAILURE_RESULT = "FAILURE";

    @RequestMapping(value = "comments", method = RequestMethod.GET)
    public ArrayList<Comment> getAllComment() {
        return commentDAO.getComments();
    }

    @RequestMapping(value = "comments/{id}", method = RequestMethod.GET)
    public Comment getComment(@PathVariable int id) {
        Comment cmt = commentDAO.getCmt(id);
        return cmt;
    }

    @RequestMapping(value = "comments/getCommentByTopic/{id}", method = RequestMethod.GET)
    public ArrayList<Comment> getCommentByTopic(@PathVariable int id) {
        ArrayList<Comment> results = commentDAO.getCommentByTopic(id);
        return results;
    }

    @RequestMapping(value = "comments/getCommentByTopic/{id}/{page}/{numPages}", method = RequestMethod.GET)
    public ArrayList<Comment> getCommentByPage(@PathVariable int id, @PathVariable int page, @PathVariable int numPages) {
        commentDAO.setPages(numPages);
        ArrayList<Comment> comments = commentDAO.getCommentPerPage(id, page);
        return comments;
    }

    @RequestMapping(value = "comments/addComment", method = RequestMethod.POST)
    public String addComment(@RequestBody Comment cmt) {
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

    @RequestMapping(value = "topics", method = RequestMethod.GET)
    public ArrayList<Topic> getAllTopics() {
        return topicDAO.getTopics();
    }

    @RequestMapping(value = "topics/getByClass/{id}", method = RequestMethod.GET)
    public ArrayList<Topic> getTopicOfClass(@PathVariable int id) {
        ArrayList<Topic> result = topicDAO.getTopicsByClass(id);
        return result;
    }

    @RequestMapping(value = "topics/getByClass/{id}/{page}/{numPages}", method = RequestMethod.GET)
    public ArrayList<Topic> getTopicPerPage(@PathVariable int id, @PathVariable int page, @PathVariable int numPages) {
        topicDAO.setPage(numPages);
        ArrayList<Topic> result = topicDAO.getTopicPerPage(id, page);
        return result;
    }

    @RequestMapping(value = "topics/{id}", method = RequestMethod.GET)
    public Topic getTopic(@PathVariable int id) {
        Topic topic = topicDAO.getATopic(id);
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
    public Topic delComment(@RequestBody Topic topic) throws SQLException {
        Topic result = topicDAO.deleteTopic(topic);
        return result;
    }
}
