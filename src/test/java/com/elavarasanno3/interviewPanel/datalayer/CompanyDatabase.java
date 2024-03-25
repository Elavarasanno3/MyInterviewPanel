package com.elavarasanno3.interviewPanel.datalayer;
import java.io.File;
import java.io.IOException;

import com.elavarasanno3.interviewPanel.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;

public class CompanyDatabase {
	private static CompanyDatabase companyDatabase;
	ObjectMapper mapper = new ObjectMapper();
	private ArrayList<Candidate> candidateList = new ArrayList<>();
	private ArrayList <Interviewer> interviewerList = new ArrayList<>();

	public Credentials credentials = new Credentials();
	public Company company = new Company();
	public Admin admin = new Admin();


	public void setCompany(Company company) {
		this.company = company;
	}
	public Company getCompany(){
		return company;
	}

	private String readFile(String filePath) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();  // To store file contents

		try (Scanner scanner = new Scanner(new File(filePath))) {
			while (scanner.hasNextLine()) {
				sb.append(scanner.nextLine()).append("\n");  // Add newline for each line
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("File not found: " + filePath);
		}

		return sb.toString();
	}
	public void initialInterviewer(){
		File jsonFile = new File("src/test/java/com/elavarasanno3/interviewPanel/data/interviewer.json");
		try {
			if (jsonFile.length() == 0) {
				return;
			}
			interviewerList = mapper.readValue(jsonFile, new TypeReference<ArrayList<Interviewer>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	public void initialCandidate(){
		File jsonFile = new File("src/test/java/com/elavarasanno3/interviewPanel/data/candidate.json");
		try {
			if (jsonFile.length() == 0) {
				return;
			}
			candidateList = mapper.readValue(jsonFile, new TypeReference<ArrayList<Candidate>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialCredentials(){
		String jsonString = null;
		try {
			jsonString = readFile("src/test/java/com/elavarasanno3/interviewPanel/data/credentials.json");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		if(!(jsonString.isEmpty())){
			try {
				credentials = mapper.readValue(jsonString, Credentials.class);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public void initialAdmin(){
		String jsonString = null;
		try {
			jsonString = readFile("src/test/java/com/elavarasanno3/interviewPanel/data/admin.json");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		if(!(jsonString.isEmpty())){
			try {
				admin = mapper.readValue(jsonString, Admin.class);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public void initialCompany(){
		String jsonString = null;
		try {
			jsonString = readFile("src/test/java/com/elavarasanno3/interviewPanel/data/company.json");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		if(!(jsonString.isEmpty())){
			try {
				company = mapper.readValue(jsonString, Company.class);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}
	}
	public ArrayList<Interviewer> getInterviewerList(){
		return interviewerList;
	}
	public static CompanyDatabase getInstance(){
		if(companyDatabase == null){
			companyDatabase = new CompanyDatabase();
		}
		return companyDatabase;
	}

	public void removeInterviewer(int id){
		if(!interviewerList.isEmpty()){
			System.out.println("Interviwer " + interviewerList.get(id-1).getName()+" removed Successfully");
			interviewerList.remove(id-1);
			try {
				mapper.writeValue(new File("src/test/java/com/elavarasanno3/interviewPanel/data/interviewer.json"), interviewerList);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println("User list is Empty.");
		}
	}
	public ArrayList<Candidate> getCandidateList(){
		return candidateList;
	}
	public void removeCandidate(int id){
		if(!candidateList.isEmpty()){
			System.out.println("Book " + candidateList.get(id-1).getName()+" removed Successfully");
			candidateList.remove(id-1);
				try {
					mapper.writeValue(new File("src/test/java/com/elavarasanno3/interviewPanel/data/candidate.json"), candidateList);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}else{
			System.out.println("Candidate list is empty.");
		}

	}
	public boolean insertBook(Candidate candidate) {
		boolean hasBook = false;
		for (Candidate addedCandidate : candidateList) {
			if (addedCandidate.getName().equals(candidate.getName())) {
				hasBook = true;
				break;
			}
		}
		if (hasBook) {
			return false;
		} else {
			candidateList.add(candidate);
			try {
				mapper.writeValue(new File("src/test/java/com/elavarasanno3/interviewPanel/data/candidate.json"), candidateList);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("JSON user json created successfully: ");
			
			return true;
		}
	}

	public boolean insertInterviewer(Interviewer interviewer) {
		boolean hasUser = false;
		for (Interviewer addedInterviewer : interviewerList) {
			if (addedInterviewer.getEmailId().equals(interviewer.getEmailId())) {
				hasUser = true;
				break;
			}
		}
		if (hasUser) {
			return false;
		} else {
			interviewerList.add(interviewer);
			interviewer.setId(credentials.getInterviewerId());
			credentials.setInterviewerId(credentials.getInterviewerId()+1);
			CompanyDatabase.getInstance().updateCredentials(credentials);
			try {
				mapper.writeValue(new File("src/test/java/com/elavarasanno3/interviewPanel/data/interviewer.json"), interviewerList);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("JSON user json created successfully: ");
			return true;
		}
	}


	public void updateInterviewer() {
		try {
			mapper.writeValue(new File("src/test/java/com/elavarasanno3/interviewPanel/data/interviewer.json"), interviewerList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void updateCredentials(Credentials credentials) {
		try {
			mapper.writeValue(new File("src/test/java/com/elavarasanno3/interviewPanel/data/credentials.json"), credentials);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void updateCandidate() {
		try {
			mapper.writeValue(new File("src/test/java/com/elavarasanno3/interviewPanel/data/candidate.json"), candidateList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void updateCompany(){
		try {
			mapper.writeValue(new File("src/test/java/com/elavarasanno3/interviewPanel/data/company.json"), company);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void updateAdmin(){
		try {
			mapper.writeValue(new File("src/test/java/com/elavarasanno3/interviewPanel/data/admin.json"), admin);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

