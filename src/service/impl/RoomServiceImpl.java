package service.impl;

import java.util.Date;
import java.util.List;

import dao.RoomDao;
import entity.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import dao.CategoryDao;

import entity.Category;
import service.RoomService;

@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private RoomDao roomDao;

	@Transactional(readOnly=true)
	public List<Category> findAllCategories() {
		return categoryDao.selectAll();
	}

	@Override
	public List<Room> selectAllSpareRoom(Date sdate, Date edate, Integer rCid) {
		return roomDao.selectAllSpareRoom(sdate,edate,rCid);
	}

	@Override
	public List<Room> selectWholeRoom(Integer rCid, Date sdate, Date edate) {
		return roomDao.selectWholeRoom(rCid,sdate,edate);
	}


}
