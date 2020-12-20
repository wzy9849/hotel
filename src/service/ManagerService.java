package service;

import entity.Manager;
import exception.DuplicateUpdateFailException;
import exception.DuplicateUsernameNoExistException;

public interface ManagerService {
    //	登录
    public Manager login(Manager member) throws DuplicateUsernameNoExistException;

    public void saveUserOrder(Integer id, String status, String remark) throws DuplicateUpdateFailException;
}
