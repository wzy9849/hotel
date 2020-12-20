package dao;

import entity.Reside;
import entity.Room;
import entity.SubscriptionDtl;
import vo.CreateSubDtlVo;

import java.util.List;

public interface createSubscriptionDtlDao {
//    查询单个床位
    public List<Room> selectOneBedNo(CreateSubDtlVo creatSubDtlVo);
//    查询整个房间
    public List<Room> selectAllRoomNo(CreateSubDtlVo creatSubDtlVo);
//    添加整个房间
    public Integer insertAllRoomNo(SubscriptionDtl subscriptionDtl);
    public Integer insertReside(Reside reside);
}
