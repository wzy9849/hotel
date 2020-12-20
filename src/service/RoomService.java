package service;

import java.util.Date;
import java.util.List;

import entity.Category;
import entity.Room;


public interface RoomService {
	/**
	 * 设施与价格
	 * @return 封装了所有房间类型的房间类型对象
	 */
	public List<Category> findAllCategories();

	public List<Room> selectAllSpareRoom(Date sdate, Date edate, Integer rCid);


	public List<Room> selectWholeRoom(Integer rCid, Date sdate, Date edate);

}
