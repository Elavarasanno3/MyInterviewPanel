package com.elavarasanno3.interviewPanel.interviewpanel;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.interviewerlogin.InterviewerLoginView;
import com.elavarasanno3.interviewPanel.model.Candidate;
import java.util.Scanner;

public class InterviewPanelView {
    private InterviewPanelModel interviewPanelModel;
    Scanner in = new Scanner(System.in);
    public InterviewPanelView (){
        interviewPanelModel = new InterviewPanelModel(this);
    }
    public void init(){
        Candidate candidate = CompanyDatabase.getInstance().getCandidateList().get(0);
        System.out.println("\n--------->Hello this is Interview Panel<---------");
        System.out.println("\n-- Time to conduct an Interview --");
        System.out.println("\nThe candidate name is :" + candidate.getName());
        System.out.println("\nEmail id :" + candidate.getEmail());
        System.out.println("\n\nQualification :" + candidate.getQualification());
        System.out.println("\nCan we start the exam : yes/no");
        System.out.println("\n\nif no then the candidate got rejected (Resume shortlist) ");
        System.out.println("\n--------->Any other key to exit<---------");
        String choice = in.next().toLowerCase();
        if(choice.equals("yes")){
            interviewPanelModel.startInterview(candidate);
        }else if(choice.equals("no")){
            init();
        }else{
            new InterviewerLoginView().init();
        }
    }
}
