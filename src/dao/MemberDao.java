package dao;

import entity.Member;

public interface MemberDao {
	//根据用户名查找用户
	public Member selectByUsername(String username);
	//注册用户
	public void insert(Member member);
	//修改信息
	public void update(Member member);
	//修改密码
	public void updatePwd(Member member);
}
