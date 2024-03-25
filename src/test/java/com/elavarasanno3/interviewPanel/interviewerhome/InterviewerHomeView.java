package com.elavarasanno3.interviewPanel.interviewerhome;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.manageinterviewer.ManageInterviewerView;
import com.elavarasanno3.interviewPanel.model.Interviewer;

import java.util.ArrayList;
import java.util.Scanner;

public class InterviewerHomeView {
    private InterviewerHomeModel interviewerHomeModel;
    Scanner scanner = new Scanner(System.in);
    public InterviewerHomeView(){
        interviewerHomeModel = new InterviewerHomeModel(this);
    }
    public  void getInterviewerListDetails(){
        ArrayList<Interviewer> interviewerList = CompanyDatabase.getInstance().getInterviewerList();
        System.out.print("\n-----Interviewer Details-----");
        for(Interviewer interviewer : interviewerList){
            System.out.print("\n"+ interviewer.getId() +  " Interviewer name : " + interviewer.getName() + " \n   Email id : "+ interviewer.getEmailId()+"\n");
        }
    }

    public void init() {
        System.out.print("\n----Hello this is Manage Interviewer section ----");
        while(true){
            System.out.print("\n 1 --> Add Interviewer \n 2 --> Delete Interviewer\n 3 --> View Interviewer List \n 4 --> " +
                    "Update Interviewer\n 0 --> Exit\n");
            System.out.print("\nEnter your choice : ");
            String choice = scanner.next();

            switch (choice){
                case "1":
                    new ManageInterviewerView().initAdd();
                    break;
                case "2":
                    getInterviewerListDetails();
                    System.out.print("Enter the User Id to delete : ");
                    int userId = scanner.nextInt();
                    CompanyDatabase.getInstance().removeInterviewer(userId);
                    // need to work
                    break;
                case "3":
                    getInterviewerListDetails();
                    // need to work
                    break;
                case "4":
                    //need to work
                    getInterviewerListDetails();
                    System.out.print("\nEnter the id to update : ");
                    int updateId = scanner.nextInt();
                    new ManageInterviewerView().updateInterviewer(updateId);
                    break;
                case "0":
                    System.out.println("----Thanks You ----");
                    return;
                default:
                    System.out.println("--You entered an invalid choice--");
                    init();
                    return;
            }
        }
    }
}
