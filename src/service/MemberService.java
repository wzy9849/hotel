package service;

import entity.Member;
import exception.DuplicateUsernameException;
import exception.NoUsernameException;
import exception.WrongOriginPwdException;
import exception.WrongPwdException;

public interface MemberService {
	public void regist(Member member)throws DuplicateUsernameException;
	public Member login(Member member)throws NoUsernameException, WrongPwdException;
	public void editMember(Member member);
	public void editPwd(Member member,String pwd,String newPwd)throws WrongOriginPwdException;
}
