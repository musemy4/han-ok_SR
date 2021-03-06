package com.ana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ana.domain.RomOptVO;
import com.ana.domain.RomVO;
import com.ana.mapper.RomOptMapper;
import com.ana.mapper.RomRegMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class RomRegServiceImpl implements RomRegService{
	@Setter(onMethod_= {@Autowired})
	private RomRegMapper mapper;
	@Setter(onMethod_= {@Autowired})
	private RomOptMapper omapper;
	
	
	@Override//뿌려주기
	public List<RomVO> getList(String acmNum) {
		System.out.println("service단에서"+acmNum);
		
		List<RomVO> lists=mapper.getList(acmNum);
		return lists;
	}
	
	
	@Transactional
	@Override
	public int register(RomVO rom, List<String> romOptArr) {
		
//		System.out.println("reg:"+rom.toString());
		mapper.insertSelectKey(rom);//객실추가
	
		RomOptVO vo = new RomOptVO();
		vo.setRomNum(rom.getRomNum());
//		System.out.println(rom.getRomNum()+"을 가져오자");
		
		for(int i=0;i<romOptArr.size();i++) {//그 객실에 대한 
			System.out.println("romOptMapper에 들어간다***"+i+"번째: "+romOptArr.get(i));
			vo.setRomOptcode(romOptArr.get(i));
			omapper.insert(vo);
		}
		
		
		return 1;//우선은 무조껀 성공이라 하자 07071233
	}


	@Override
	public RomVO get(String romNum) {
		RomVO vo = mapper.read(romNum); 
		return vo;
	}


	@Override
	public boolean remove(String romNum) {//객실 지우기
		omapper.delete(romNum);
		return mapper.remove(romNum)==1;
	}


	@Override
	public boolean modify(RomVO rom) {
		
		
		return mapper.modify(rom)==1;
	}

	
	
	
	

	

}
