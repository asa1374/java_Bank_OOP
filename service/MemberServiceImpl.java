package service;
import domain.MemberBean;
/**
 * @author Lee Chang Jun
 * @date 2018. 12. 26.
 * @desc 멤버기능 구현
 */
public class MemberServiceImpl implements MemberService{
	private MemberBean[] beans;
	private int count,same;
	public MemberServiceImpl(){
		beans = new MemberBean[5];
		count = 0;
	}
	@Override
	public MemberBean newMember(String id, String pass, String name, String ssn) {
		MemberBean bean = new MemberBean();
		bean.setId(id);
		bean.setName(name);
		bean.setPass(pass);
		bean.setSsn(ssn);
		beans[count] = bean;
		count++;
		return bean;
	}

	@Override
	public MemberBean[] findAll() {
		return beans;
	}

	@Override
	public MemberBean[] findByName(String name) {
		for(int i=0;i<count;i++) {
			if(beans[i].getName().equals(name)) {
				same++;
			}
		}
		System.out.println(same);
		MemberBean[] members = new MemberBean[same];
		for(int i=0,j=0;i<count;i++) {
			if(beans[i].getName().equals(name)) {
				members[j] = beans[i];
				j++;
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		MemberBean bean = new MemberBean();
		for(int i=0;i<count;i++) {
			if(beans[i].getId().equals(id)) {
				bean = beans[i];
				break;
			}
		}
		return bean;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public boolean existMember(String id, String pw) {
		boolean login = false;
		for(int i=0;i<count;i++) {
			if(beans[i].getId().equals(id)&&beans[i].getId().equals(pw)) {
				login = true;
				break;
			}
		}
		return login;
	}

	@Override
	public void passUpdate(String id,String pw, String newpw) {
		for(int i=0;i<count;i++) {
			if(existMember(id,pw)) {
				beans[i].setPass(newpw);
				break;
			}
		}
	}

	@Override
	public void memberDelete(String id,String pw) {
		for(int i=0;i<count;i++) {
			if(existMember(id,pw)) {
				beans[i] = beans[count-1];
				beans[count-1] = null;
				count--;
				break;
			}
		}
	}

}
