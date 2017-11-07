package com.ray.sms.aliyun.service;

import org.junit.Test;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.ray.sms.aliyun.util.CheckSumBuilder;

/**@desc  : 阿里大于短信验证码测试类
 * 
 * @author: shirayner
 * @date  : 2017年11月6日 下午7:41:46
 */
public class ShortMessageServiceTest {

	@Test
	public void testsms() throws ClientException, InterruptedException {
		//1.准备好请求参数：phoneNumber、TemplateParam
		//String phoneNumber="17621619597";
		String phoneNumber="18621956473";
		String code=CheckSumBuilder.getCheckSum();

		//2.调用接口，发短信
		SendSmsResponse response = ShortMessageService.sendSms(phoneNumber,code);
		
		//3.获取发送结果
		System.out.println("短信接口返回的数据----------------");
		System.out.println("Code=" + response.getCode());
		System.out.println("Message=" + response.getMessage());
		System.out.println("RequestId=" + response.getRequestId());
		System.out.println("BizId=" + response.getBizId());

		Thread.sleep(3000L);

		//查明细
		if(response.getCode() != null && response.getCode().equals("OK")) {
			QuerySendDetailsResponse querySendDetailsResponse = ShortMessageService.querySendDetails(response.getBizId(),phoneNumber);
			System.out.println("短信明细查询接口返回数据----------------");
			System.out.println("Code=" + querySendDetailsResponse.getCode());
			System.out.println("Message=" + querySendDetailsResponse.getMessage());
			int i = 0;
			for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
			{
				System.out.println("SmsSendDetailDTO["+i+"]:");
				System.out.println("Content=" + smsSendDetailDTO.getContent());
				System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
				System.out.println("OutId=" + smsSendDetailDTO.getOutId());
				System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
				System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
				System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
				System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
				System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
			}
			System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
			System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
		}

	}
}
