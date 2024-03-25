package com.elavarasanno3.interviewPanel.mainlogin;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.interviewerhome.InterviewerHomeView;
import com.elavarasanno3.interviewPanel.interviewerlogin.InterviewerLoginView;
import com.elavarasanno3.interviewPanel.login.LoginView;

import java.util.Scanner;

public class MainLoginView {
    private MainLoginModel mainLoginModel;
    Scanner scanner = new Scanner(System.in);
    public MainLoginView(){
        CompanyDatabase.getInstance().initialInterviewer();
        CompanyDatabase.getInstance().initialCandidate();
        CompanyDatabase.getInstance().initialCredentials();
        CompanyDatabase.getInstance().initialAdmin();
        CompanyDatabase.getInstance().initialCompany();

        mainLoginModel = new MainLoginModel(this);
    }
    public void init(){
        while(true){
            System.out.println("\n 1 --> ADMIN LOGIN \n 2 --> INTERVIEWER LOGIN\n 0 --> EXIT ");
            System.out.print("\nEnter your choice : ");
            String choice = scanner.next();
            switch (choice){
                case "1":
                    new LoginView().init();
                    break;
                case "2":
                    if(!(CompanyDatabase.getInstance().getInterviewerList().isEmpty())){
                        new InterviewerLoginView().proceedLogin();
                    }else{
                        System.out.println("No users added.... first add users");
                        init();
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Enter valid choice : ");
                    init();
            }
        }

    }
}
