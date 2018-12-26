package service;

import domain.MemberBean;
/**
 * @author Lee Chang Jun
 * @date 2018. 12. 26.
 * @desc 은행 회원 서비스
 */
public interface MemberService {
	//가입받기
	public MemberBean newMember(String id,String pass,String name, String ssn);
	//Read 찾기, count, 로그인
	public MemberBean[] findAll();
	public MemberBean[] findByName(String name);
	public MemberBean findById(String id);
	public int count();
	public boolean existMember(String id,String pw);
	//pass update
	public void passUpdate(String id,String pw, String newpw);
	//회원 delete
	public void memberDelete(String id,String pw);
}
