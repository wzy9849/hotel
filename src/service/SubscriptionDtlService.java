package service;

import entity.SubscriptionDtl;
import exception.DuplicatedeleteFail;

import java.util.List;

public interface SubscriptionDtlService {
//    查询用户的预定房间
    public List<SubscriptionDtl> selectOrderRoom(Integer id);
//    删除用户的预定房间
    public void deleteOrderRoom(Integer id) throws DuplicatedeleteFail;
}
