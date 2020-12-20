package service.impl;

import java.util.Iterator;
import java.util.List;

import entity.SubscriptionDtl;
import exception.DuplicatedeleteFail;
import exception.ManagerDuplicateReserveIsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import service.SubscriptionDtlService;
import service.SubscriptionService;
import util.SubscriptionNoUtil;
import constant.Constant;
import dao.SubscriptionDao;
import entity.Subscription;
import vo.ManagerQueryVo;


@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionDao subscriptionDao;
    @Autowired
    private SubscriptionDtlService subscriptionDtlService;

//    客房预定，新建订单
    @Override
    public void create(Subscription subscription) {
        subscription.setNo(SubscriptionNoUtil.getSubscriptionNo());
        subscription.setStatus(Constant.SUBSCRIPTION_STATUS_UNCONFIRMED);
        subscriptionDao.insert(subscription);
    }

//    查询所有未确认订单
    @Transactional(readOnly=true)
    @Override
    public List<Subscription> findStatusUnconfirmed(Integer mid, String status) {
        return subscriptionDao.selectStatusUnconfirmed(mid, status);
    }

//  查询历史订单
    @Transactional(readOnly = true)
    @Override
    public List<Subscription> findHistorySubscription(Integer mid) {
        return subscriptionDao.selectHistorySubscription(mid);
    }

//    根据id查询订单
    @Transactional(readOnly=true)
    @Override
    public Subscription findById(Integer id) {
        return subscriptionDao.selectById(id);
    }

//  删除单项订单
    @Override
    public void deleteOneItem(Integer id) throws DuplicatedeleteFail {
        List<SubscriptionDtl> list = subscriptionDtlService.selectOrderRoom(id);
        Iterator<SubscriptionDtl> iterator = list.iterator();
        while (iterator.hasNext()) {
            SubscriptionDtl subscription_dtl = iterator.next();
            subscriptionDtlService.deleteOrderRoom(subscription_dtl.getId());
        }
        subscriptionDao.deleteOneItem(id);
        /*Integer exits = subscriptionDao.selectById(id);
        if(exits == 1 ){
            throw new DuplicatedeleteFail("删除失败");
        }*/
    }



//  修改订单信息
    @Override
    public void edit(Subscription subscription) {
        subscriptionDao.update(subscription);
    }


    //管理员查询订单
    @Override
    public List<Subscription> selectBySubscriptionCriteria(ManagerQueryVo managerQueryVo) throws ManagerDuplicateReserveIsNull {
        List<Subscription> list = subscriptionDao.selectBySubscriptionCriteria(managerQueryVo);
        if(list.size()<=0){
            throw new ManagerDuplicateReserveIsNull("查无此单！");
        }
        return list;
    }


    //管理员订单号查询
    @Override
    public List<Subscription> selectUserRoomDetail(String no) {
        List<Subscription> subscriptions = subscriptionDao.selectUserRoomDetail(no);
        return subscriptions;
    }


}
