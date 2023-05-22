
package com.qinweizhao.basic.ftp.util;

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

/**
 * 输出内容
 * @ClassName: OutputUtil
 * @author: zhu
 * @date: 2018年8月22日 上午10:26:24
 *
 * @Copyright: 2018 www.yetech.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于元镁信息科技（上海）有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class OutputUtil {

	public static void SystemOutput(String str){
		String time  = DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss");
		System.out.println("["+time+"]: "+str);
	}
}

	