package dao;

import entity.Room;

import java.util.Date;
import java.util.List;

public interface RoomDao {
    public List<Room> selectAllRoom();
    public List<Room> selectAllSpareRoom(Date sdate, Date edate, Integer rCid);
    public List<Room> selectWholeRoom(Integer rCid,Date sdate,Date edate);
}
