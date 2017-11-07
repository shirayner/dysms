package com.ray.sms.aliyun.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**@desc  : 
 * 
 * @author: shirayner
 * @date  : 2017年11月7日 上午9:50:33
 */
public class CheckSumBuilderTest {
	private static final Logger logger = LogManager.getLogger(CheckSumBuilderTest.class);
	
	@Test
	public void testGetCheckSum() {
		int len=100000;
		String checkSum=null;
		
		for(int i=0;i<len;i++) {
			checkSum= CheckSumBuilder.getCheckSum();
	        logger.info("checkSum:"+checkSum);
		}
		

	}




}
