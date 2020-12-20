package service.impl;

import java.util.Date;

import exception.NoUsernameException;
import exception.WrongOriginPwdException;
import exception.WrongPwdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import service.MemberService;

import dao.MemberDao;
import entity.Member;
import exception.DuplicateUsernameException;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    public void regist(Member member) throws DuplicateUsernameException {
        Member m = memberDao.selectByUsername(member.getUsername());
        if (m != null) {
            throw new DuplicateUsernameException("用戶名已存在");
        }
        member.setRegtime(new Date());
        memberDao.insert(member);
    }

    @Transactional(readOnly = true)
    @Override
    public Member login(Member member) throws NoUsernameException, WrongPwdException {
        Member m = memberDao.selectByUsername(member.getUsername());
        if (m == null) {
            System.out.println("m不存在！");
			throw new NoUsernameException("该用户不存在");
        } else {

        }

        if (!m.getPwd().equals(member.getPwd())) {
            System.out.println("密码错误！");
            throw new WrongPwdException("密码错误");
        }
        return m;
    }


    @Override
    public void editMember(Member member) {
        memberDao.update(member);
    }

    @Override
    public void editPwd(Member member,String pwd,String newPwd) throws WrongOriginPwdException {
        if (!member.getPwd().equals(pwd)){
            System.out.println("初始密码错误！");
            throw new WrongOriginPwdException("初始密码错误！");
        }else{
            member.setPwd(newPwd);
            memberDao.updatePwd(member);
        }
    }
}
