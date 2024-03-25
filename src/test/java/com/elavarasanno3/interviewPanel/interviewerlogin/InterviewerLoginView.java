package com.elavarasanno3.interviewPanel.interviewerlogin;
import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.interviewpanel.InterviewPanelView;
import com.elavarasanno3.interviewPanel.managecandidate.ManageCandidateView;
import com.elavarasanno3.interviewPanel.model.Candidate;
import com.elavarasanno3.interviewPanel.model.Interviewer;

import java.util.ArrayList;
import java.util.Scanner;

public class InterviewerLoginView {
    Scanner in = new Scanner(System.in);
    String userName;
    String userPassword;
    Scanner scanner = new Scanner(System.in);
    private InterviewerLoginModel interviewerLoginModel;
    public InterviewerLoginView(){
        interviewerLoginModel = new InterviewerLoginModel(this);
    }
    public void proceedLogin(){
        System.out.print("\n----- Hii !! This is user's portal -----");
        System.out.print("\nEnter your name : ");
        userName = in.next();
        System.out.print("\nEnter your password to login : ");
        userPassword = in.next();
        interviewerLoginModel.validateInterviewer(userName,userPassword);
    }
    public void onLoginField(String alertMessage){
        System.out.println(alertMessage);
        checkForLogin();
    }
    private void checkForLogin(){
        System.out.println("Do you want to try again ?\nType YES or NO");
        String choice = in.next().toLowerCase();
        if(choice.equals("yes")){
            proceedLogin();
        }else if(choice.equals("no")) {
            System.out.println("---- Thanks you ----");
        }else{
            System.out.println("Invalid Choice Enter \n Enter a valid choice");
            checkForLogin();
        }
    }
    public void init(){
        new InterviewPanelView().init();
    }
    public void loginSuccess() {
        System.out.println("User login successful");
        System.out.println("-----Start the interview-----");
        init();
    }
}
