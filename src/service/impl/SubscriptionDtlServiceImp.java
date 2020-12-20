package service.impl;

import dao.SubscriptionDtlDao;
import entity.SubscriptionDtl;
import exception.DuplicatedeleteFail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.SubscriptionDtlService;

import java.util.List;

@Service
@Transactional(propagation= Propagation.REQUIRED,rollbackFor=Exception.class)
public class SubscriptionDtlServiceImp implements SubscriptionDtlService {
    @Autowired
    private SubscriptionDtlDao subscriptionDtlDao;

    @Override
//    查询用户订单
    @Transactional(readOnly = true)
    public List<SubscriptionDtl> selectOrderRoom(Integer id) {
        List<SubscriptionDtl> list = subscriptionDtlDao.selectOrderRoom(id);
        return list;
    }

//    删除订单房间
    @Override
    public void deleteOrderRoom(Integer id) throws DuplicatedeleteFail {
        subscriptionDtlDao.rDeleteOrderRoom(id);
        Integer flag2= subscriptionDtlDao.selectRidesIsExist(id);
        if(flag2 == 1){
            throw new DuplicatedeleteFail("删除失败");
        }else {
            subscriptionDtlDao.deleteOrderRoom(id);
            Integer falg = subscriptionDtlDao.sDeleteOrderRoom(id);
            if (falg == 1) {
                throw new DuplicatedeleteFail("删除失败");
            }
        }
    }
}
