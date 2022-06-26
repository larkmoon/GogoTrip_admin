package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.ProductVO;

@Repository
@Mapper
public interface ProductMapper {
	public void insert(ProductVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(ProductVO obj) throws Exception;
	
	public ProductVO select(int id) throws Exception;
	public List<ProductVO> selectall() throws Exception;
	
	// for delete: buydetail.pid -> null
	public List<Integer> selectUpdlist(int id) throws Exception;
	public void nullBD(int id) throws Exception;
	
}