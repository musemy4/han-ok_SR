package com.ana.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ana.domain.AcmVO;

public interface AcmRegMapper {
	
	public List<AcmVO> getList();
	
	public void insert(AcmVO acm);//숙소등록
	
	public void insertSelectKey(AcmVO acm);//숙소등록
	
	public AcmVO read(String acmNum);
	
	public int delete(String acmNum);
	
	public int update(AcmVO acm);
	
	//public int updateDesc(AcmVO acm);//
	public int updateDesc(@Param("acmNum") String acmNum, @Param("acmDesc") String acmDesc);


}
