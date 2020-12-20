package service;

import entity.Reside;
import entity.Room;
import entity.SubscriptionDtl;
import exception.DuplicateInsertFail;
import exception.DuplicateReserveIsNull;
import vo.CreateSubDtlVo;

import java.util.List;

public interface


createSubscriptionDtlService {
    //    查询单个床位
    public List<Room> selectOneBedNo(CreateSubDtlVo creatSubDtlVo) throws DuplicateReserveIsNull;

    //    查询整个房间
    public List<Room> selectAllRoomNo(CreateSubDtlVo creatSubDtlVo) throws DuplicateReserveIsNull;

    //    添加整个房间
    public void insertAllRoomNo(SubscriptionDtl subscription_dtl, Reside reside) throws DuplicateInsertFail;
}
