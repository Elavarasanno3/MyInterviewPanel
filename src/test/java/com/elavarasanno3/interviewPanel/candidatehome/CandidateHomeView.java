package com.elavarasanno3.interviewPanel.candidatehome;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;
import com.elavarasanno3.interviewPanel.managecandidate.ManageCandidateView;
import com.elavarasanno3.interviewPanel.model.Candidate;

import java.util.ArrayList;
import java.util.Scanner;

public class CandidateHomeView {
    private CandidateHomeModel candidateHomeModel;
    public CandidateHomeView(){
        candidateHomeModel = new CandidateHomeModel(this);
    }
    Scanner scanner = new Scanner(System.in);
    public void getBookListDetails(){
        ArrayList<Candidate> candidateList = CompanyDatabase.getInstance().getCandidateList();
        for(Candidate candidate : candidateList){
            System.out.print("\n----------Candidate Details : \n_______________________________________");
            System.out.print("\n"+candidate.getId() +  " --  candidate name : " + candidate.getName());
            System.out.print("\n -- Candidate email : " +candidate.getEmail());
            System.out.print("\n -- Candidate qualification : "+ candidate.getQualification());
        }
    }
    public void init(){
        while(true) {
            System.out.print("\n 1 --> Add Candidate \n 2 --> Delete Candidate\n 3 --> View Candidate List \n 4 --> " +
                    "Update Candidate\n 5 --> Search Candidate\n 0 --> Exit\n");
            System.out.print("\nEnter your choice : ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    new ManageCandidateView().initAdd();
                    break;
                case "2":
                    getBookListDetails();
                    System.out.print("\nEnter Book id to delete : ");
                    int bookId = scanner.nextInt();
                    new ManageCandidateView().deleteCandidate(bookId);
                    break;
                case "3":
                    getBookListDetails();
                    // need to work
                    break;
                case "4":
                    getBookListDetails();
                    System.out.print("\nEnter the id to update : ");
                    int updateId = scanner.nextInt();
                    new ManageCandidateView().updateCandidate(updateId);
                    break;
                    //need to work
                case "5":
                    System.out.print("\nEnter name to search : ");
                    String searchId = scanner.nextLine();
                    new ManageCandidateView().searchCandidate(searchId);
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
