package dao;

import entity.Subscription;
import vo.ManagerQueryVo;

import java.util.List;

public interface SubscriptionDao {
    //新建订单
    public void insert(Subscription subscription);

    //根据用户id查询未确认订单
    public List<Subscription> selectStatusUnconfirmed(Integer mid, String status);

    //根据用户id查询历史订单
    public List<Subscription> selectHistorySubscription(Integer mid);

    //根据id查询订单
    public Subscription selectById(Integer id);

    //修改订单联系人信息
    public void update(Subscription subscription);

    //    单个删除
    public void deleteOneItem(Integer id);



    //    管理员查询
    List<Subscription> selectBySubscriptionCriteria(ManagerQueryVo managerQueryVo);
    //    管理员查询用户住房详细信息
    public List<Subscription> selectUserRoomDetail(String no);
}
