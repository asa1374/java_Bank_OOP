package domain;

public class AdminBean {
	private String adminNum,name, pass, auth;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminNum() {
		return adminNum;
	}

	public void setAdminNum(String adminNum) {
		this.adminNum = adminNum;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	@Override
	public String toString() {
		return String.format("관리자정보 \n"
				+ "관리자번호 : %s\n"
				+ "관리자이름 : %s\n"
				+ "비밀번호 : %s\n"
				+ "권한직급 : %s",adminNum,name,pass,auth);
	}

	
}
