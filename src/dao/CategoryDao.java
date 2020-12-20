package dao;

import java.util.List;

import entity.Category;


public interface CategoryDao {
	/**
	 * 查询所有房间类型
	 * @return 封装了所有房间类型的房间类型对象
	 */
	public List<Category> selectAll();
}
