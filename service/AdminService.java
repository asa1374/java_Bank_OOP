package service;

import java.util.ArrayList;

import domain.AdminBean;

public interface AdminService {
	//Create 
	public void createAdmin(String name,String pass,String auth);
	//read 
	public ArrayList<AdminBean> list();
	public ArrayList<AdminBean> findByAuth(String auth);
	public AdminBean findById(String adminNum);
	public int countAdmin();
	public boolean existAdmin(String adminNum,String pass);
	//update 
	public void updatePass(String adminNum,String pass,String newpass);
	public void updateAuth(String adminNum,String auth);
	//delete
	public void deleteAdmin(String adminNum,String pass);
	
}
