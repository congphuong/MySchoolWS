package com.ashin.controller;

import com.ashin.DAO.*;
import com.ashin.model.Account;
import com.ashin.model.MessageResult;
import com.ashin.model.Student;
import com.ashin.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by anluo on 6/10/2017.
 */
@RestController
public class KhuongService {
    private AccountDAO accountDAO = new AccountDAO();

    //--------register--------
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public MessageResult register(@RequestBody Account account) {
//        AccountDAO ad = new AccountDAO();
//        MessageResult messageResult = new MessageResult();
//        //check username is identical
//        if (!ad.checkUserExist(account.getUsername())) {
//            //tao mot account moi
//            ad.register(account);
//            messageResult.setSuccess(true);
//            messageResult.setMessage("Register is sucessful.Wellcome");
//        } else {
//            messageResult.setSuccess(false);
//            messageResult.setMessage("Register Fail");
//        }
//        return messageResult;
//    }

    //------login----
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public MessageResult login(@RequestBody User user) {
//        MessageResult messageResult = new MessageResult();
//        AccountDAO ad = new AccountDAO();
//        //check username,password is correct?
//        if (ad.checkAccount(user.getUsername(), user.getPassword()) == true) {
//            messageResult.setSuccess(true);
//            messageResult.setMessage("Login sucess.Wellcome");
//        } else {
//            messageResult.setSuccess(false);
//            messageResult.setMessage("Your username or password is incorrect. Please try again.");
//        }
//        return messageResult;
//    }

    //----change password----
    @RequestMapping(value = "/changepw/{newPw}", method = RequestMethod.PUT)
    public MessageResult changepw(@RequestBody User user, @PathVariable String newPw) {
        MessageResult messageResult = new MessageResult();
        // check user name exist
        if (accountDAO.checkUserExist(user.getUsername())) {
            // check old pass map with current password in database
            if (accountDAO.checkAccount(user.getUsername(), user.getPassword())) {
                // if yes, update new password
                accountDAO.changePasswd(user.getUsername(), user.getPassword(), newPw);
                messageResult.setSuccess(true);
                messageResult.setMessage("Change Password is successful");

            } else {
                messageResult.setSuccess(false);
                messageResult.setMessage("Pass is not valid");
            }
        } else {
            messageResult.setSuccess(false);
            messageResult.setMessage("Error username not exist");
        }
        return messageResult;
    }


    //----view list Students----
    @RequestMapping(value = "/viewListStudents/{idClass}", method = RequestMethod.GET)
    public ArrayList<Student> getListStudent(@PathVariable int idClass) {
        StudentDAO studentDAO = new StudentDAO();
        return studentDAO.showListStudent(idClass);
    }

    //-----view list Parents---
    @RequestMapping(value = "viewListParents/{idClass}", method = RequestMethod.GET)
    public ArrayList<Parent> getListParents(@PathVariable int idClass) {
        ParentDAO parentDAO = new ParentDAO();
        return parentDAO.showListParents(idClass);
    }

    //------view TestSChedule----
    @RequestMapping(value = "/viewTestSchedule/{semester}/{idClass}", method = RequestMethod.GET)
    public ArrayList<TestSchedule> getTestSchedule(@PathVariable int semester, @PathVariable int idClass) {
        TestScheDAO testSchDAO = new TestScheDAO();
        return testSchDAO.showTestSchedule(semester, idClass);
    }

    //-----view Schedule-----
    @RequestMapping(value = "/viewSchedule/{idClass}/{semester}/{weekday}", method = RequestMethod.GET)
    public ArrayList<Schedule> getSchedule(@PathVariable int idClass, @PathVariable int semester, @PathVariable int weekday) {
        ScheDAO scheDAO = new ScheDAO();
        return scheDAO.showSchedule(idClass, semester, weekday);
    }


}
