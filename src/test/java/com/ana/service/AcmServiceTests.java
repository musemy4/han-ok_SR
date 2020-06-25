package com.ana.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ana.domain.AcmVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AcmServiceTests {
	
	@Setter(onMethod_= {@Autowired})
	private AcmService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	//@Test
	public void testRegister() {
		AcmVO acm = new AcmVO();
		acm.setAcmName("새로 추가한 숙소");
		acm.setAcmCity("새로운 숙소 시");
		acm.setAcmDistr("새로운 숙소 동");
		acm.setAcmDetailaddr("새로운 숙소 상세주소");
		acm.setRepPhone(8212341234L);
		acm.setBizRegnum(56785678L);
		acm.setCheckinTime("AM11");
		acm.setCheckoutTime("PM04");
		
		service.register(acm);
		
		log.info("생성된 숙소의 번호: " + acm.getAcmNum());
	}
	
	//@Test
	public void testGetList() {
		service.getList().forEach(acm->log.info(acm));
	}
	
	@Test
	public void testGet() {
		log.info(service.get("A7"));
	}
	
	@Test
	public void testDelete() {
		//게시물의 존재 여부를 확인하고 테스트할 것
		log.info("REMOVE RESULT: " + service.remove("A2"));
	}
	
	@Test
	public void testUpdate() {
		AcmVO acm = service.get("A6");
		
		if(acm == null) {
			return;
		}
		
		acm.setAcmName("숙소이름 수정합니다. ");
		log.info("MODIFY RESULT: "+service.modify(acm));
	}
	
}
