package service;

import java.util.List;

import entity.Subscription;
import exception.DuplicatedeleteFail;
import exception.ManagerDuplicateReserveIsNull;
import vo.ManagerQueryVo;

public interface SubscriptionService {
//	创建新订单
	public void create(Subscription subscription);
//	查询未确认订单
	public List<Subscription> findStatusUnconfirmed(Integer mid, String status);
//	查询历史订单
	public List<Subscription> findHistorySubscription(Integer mid);
//	根据id查询订单
	public Subscription findById(Integer id);
//	删除单个订单
	public void deleteOneItem(Integer id) throws DuplicatedeleteFail;
//	编辑联系人信息
	public void edit(Subscription subscription);



	//    管理员查询
	public  List<Subscription> selectBySubscriptionCriteria(ManagerQueryVo managerQueryVo)throws ManagerDuplicateReserveIsNull;
	//    管理员查询用户住房详细信息
	public List<Subscription> selectUserRoomDetail(String no);
}
