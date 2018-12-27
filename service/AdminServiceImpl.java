package service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import domain.AdminBean;
public class AdminServiceImpl implements AdminService{
	private HashMap<String,AdminBean> map;
	private int seq;
	
	public AdminServiceImpl() {
		map = new HashMap<>();
		seq = 1000;
	}
	
	@Override
	public void createAdmin(String name, String pass, String auth) {
		AdminBean admin = new AdminBean();
		admin.setAdminNum(String.valueOf(seq));
		admin.setAuth(auth);
		admin.setName(name);
		admin.setPass(pass);
		map.put(admin.getAdminNum(), admin);
		seq++;
	}

	@Override
	public ArrayList<AdminBean> list() {
		ArrayList<AdminBean> list = new ArrayList<>();
		list.addAll(map.values());
		return list;
	}

	@Override
	public ArrayList<AdminBean> findByAuth(String auth) {
		ArrayList<AdminBean> list = new ArrayList<>();
		Set<String> set = map.keySet();
		/**
		 * for each loop 이라고 합니다.
		 * Set은 인덱스가 없어요...
		 * 그래서 int i=0 이런식으로 못돌립니다.
		 * 그래서 아래처럼 for를 돌립니다. 
		 * */
		for(String key : set) {
			if(auth.equals(map.get(key).getAuth())) {
				list.add(map.get(key));
			}
		}
		return list;
	}

	@Override
	public AdminBean findById(String adminNum) {
		return map.get(adminNum);
	}

	@Override
	public int countAdmin() {
		return map.size();
	}

	@Override
	public boolean existAdmin(String adminNum, String pass) {
		boolean exist = false;
		if(map.containsKey(adminNum)&&map.get(adminNum).getPass().equals(pass)) {
			exist = true;
		}
		return exist;
	}

	@Override
	public void updatePass(String adminNum, String pass, String newpass) {
		if(map.containsKey(adminNum)&&map.get(adminNum).getPass().equals(pass)) {
			map.get(adminNum).setPass(newpass);
		}
	}

	@Override
	public void updateAuth(String adminNum, String auth) {
		if(map.containsKey(adminNum)) {
			map.get(adminNum).setAuth(auth);
		}
	}

	@Override
	public void deleteAdmin(String adminNum, String pass) {
		map.remove(adminNum);
	}

}
