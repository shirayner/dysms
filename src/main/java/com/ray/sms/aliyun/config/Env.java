package com.ray.sms.aliyun.config;

/**@desc  : 阿里大于短信服务 接入配置
 * 
 * @author: shirayner
 * @date  : 2017年11月6日 下午6:27:53
 */
public class Env {

	//1. 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
	public static final String ACCESSKEY_ID = "LTAIysLddrUm845l";
	public static final String ACCESSKEY_SECRET = "MhjTxvbJe8S4j8xaVE9fnJzaAxhD7i";

	
	//2.产品名称:云通信短信API产品,开发者无需替换
	public static final String PRODUCT = "Dysmsapi";
	//产品域名,开发者无需替换
	public static final String DOMAIN = "dysmsapi.aliyuncs.com";
	
	
	//3.短信签名和模板
	public static final String SIGN_NAME  = "石锐";
	public static final String TEMPLATE_CODE  = "SMS_109545099";




}
