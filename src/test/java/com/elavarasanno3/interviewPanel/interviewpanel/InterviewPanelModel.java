package com.elavarasanno3.interviewPanel.interviewpanel;



import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.model.Candidate;

import java.util.Scanner;

public class InterviewPanelModel {
    Scanner in = new Scanner(System.in);
    private InterviewPanelView interviewPanelView;
    InterviewPanelModel (InterviewPanelView interviewPanelView){
        this.interviewPanelView = interviewPanelView;
    }


    public void startInterview(Candidate candidate) {
        System.out.println("/n_____________________Interview finished____________________ : ");
        int count = 4;
        int random =(int)((Math.random()*count))+1;
        switch (random){
            case 1 :
                System.out.println("\n\n<-------->Rejected in aptitude round<--------->");
                break;
            case 2 :
                System.out.println("\n\n<-------->Rejected in basic programming round<-------->");
                break;
            case 3 :
                System.out.println("\n\n<-------->Rejected in advanced programming round<--------->");
                break;
            case 4 :
                System.out.println("\n\n<-------->Congrats You are selected<-------->");
        }
        CompanyDatabase.getInstance().getCandidateList().remove(0);
        System.out.println("__________________________________________________________________");
        System.out.println("\nDo you want to interview next candidate : YES OR NO ");
        String choice = in.next().toLowerCase();
        if(choice.equals("yes")) {
            interviewPanelView.init();
        }
    }
}
