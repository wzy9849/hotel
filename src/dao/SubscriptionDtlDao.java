package dao;

import entity.SubscriptionDtl;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface SubscriptionDtlDao {
    //    查询用户的预定房间
    public List<SubscriptionDtl> selectOrderRoom(Integer id);
    //    删除用户的预定房间
    public void deleteOrderRoom(@Param("id") Integer id);
    //    查询用户的预定房间是否删除成功
    public int sDeleteOrderRoom(Integer id);
    //     删除reside表中的数据
    public void rDeleteOrderRoom(Integer id);
    //    查询reside表用户的预定房间是否删除成功
    public Integer selectRidesIsExist(Integer id);

}
