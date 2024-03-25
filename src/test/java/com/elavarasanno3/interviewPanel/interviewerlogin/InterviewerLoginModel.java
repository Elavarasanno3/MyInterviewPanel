package com.elavarasanno3.interviewPanel.interviewerlogin;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.model.Interviewer;

import java.util.ArrayList;

public class InterviewerLoginModel {
    private InterviewerLoginView interviewerLoginView;
    InterviewerLoginModel(InterviewerLoginView interviewerLoginView){
        this.interviewerLoginView = interviewerLoginView;
    }
    public void validateInterviewer(String userName, String password) {
        if(isValidUserName(userName)){
            if(isValidPassword(password)){
                interviewerLoginView.loginSuccess();
            }else{
                interviewerLoginView.onLoginField("Invalid  Password");
            }
        }else{
            interviewerLoginView.onLoginField("Invalid Username");
        }
    }
    private boolean isValidUserName(String userName)     {
        ArrayList<Interviewer> interviewerList =  CompanyDatabase.getInstance().getInterviewerList();
        for(Interviewer user:interviewerList){
            if(user.getName().equals(userName)){
                return true;
            }
        }
        return false;
    }


    private boolean isValidPassword(String password) {
        ArrayList <Interviewer> interviewerList =  CompanyDatabase.getInstance().getInterviewerList();
        for(Interviewer user:interviewerList){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }


}
