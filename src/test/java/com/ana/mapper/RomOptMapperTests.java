package com.ana.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ana.domain.AcmVO;
import com.ana.domain.Criteria;
import com.ana.domain.RomOptVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class RomOptMapperTests {
	
	@Setter(onMethod_= @Autowired)
	private RomOptMapper mapper;
	

	
	@Test
	public void testInsert() {
		List<String> romOptArr= new ArrayList();
		romOptArr.add("WE");
		romOptArr.add("DT");
		
		RomOptVO vo = new RomOptVO();
		vo.setRomNum("A01R01");
		for(int i=0;i<romOptArr.size();i++) {
			vo.setRomOptcode(romOptArr.get(i));
			mapper.insert(vo);
		}
	}
	
	
	

	/*acmname      |acmcity |acmdistr |acmdetailaddr |repphone    |
	bizregnum  |checkintime |checkouttime |acmregdate            |
	acmupdatedate         |phone2     |acmfax      |acmemail     |acmdesc*/

}
