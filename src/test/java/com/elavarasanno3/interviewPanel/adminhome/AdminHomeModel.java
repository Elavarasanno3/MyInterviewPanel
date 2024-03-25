package com.elavarasanno3.interviewPanel.adminhome;

import com.elavarasanno3.interviewPanel.datalayer.CompanyDatabase;

public class AdminHomeModel {
    private AdminHomeView adminHomeView;
    AdminHomeModel(AdminHomeView adminHomeView){
        this.adminHomeView = adminHomeView;
    }

    public void changeAdminName(String newName) {
        CompanyDatabase.getInstance().admin.setName(newName);
        CompanyDatabase.getInstance().updateAdmin();
    }

    public void changeAdminPassword(String password) {
        CompanyDatabase.getInstance().admin.setPassword(password);
        CompanyDatabase.getInstance().updateAdmin();
    }
}
