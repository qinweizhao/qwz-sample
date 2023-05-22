package com.qinweizhao.basic.ftp.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


/**
 * Date日期公共类
 * 
 * @author json
 * 
 */
public class DateUtils {

	/**
	 * 返回当前日期Date类型
	 * 
	 * @return
	 */
	public static Date getCurDate() {
		return new Date();
	}

	/**
	 * Date日期类型转化为Timestamp类型 如果参数为空返回null
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getTimestamp(Date date) {
		if (date == null)
			return null;
		else {
			return new Timestamp(date.getTime());
		}
	}

	/**
	 * 获取当前Timestamp类型时间
	 * 
	 * @return
	 */
	public static Timestamp getCurTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 字符串日期转化为“yyy-MM-dd”格式的Date日期类型 如果字符串为null则返回null
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date formateDate(String dateStr) {
		if (dateStr == null || "".equals(dateStr.trim()))
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 字符串日期去除两端空白并返回Timestamp类型日期 如果为null或者“”则返回null
	 * 
	 * @param tsStr
	 * @return
	 */
	public static Timestamp formateTimeStamp(String tsStr) {
		if (tsStr == null || "".equals(tsStr.trim()))
			return null;
		try {
			Timestamp ts = Timestamp.valueOf(tsStr.trim());
			return ts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Date日期类型转化为“yyyy-MM-dd”格式的字符串日期 如果为空则返回null
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return dateStr;
	}

	/**
	 * Timestamp日期类型转化为“yyyy-MM-dd HH:mm:ss”格式的字符串日期 如果为空则返回null
	 * 
	 * @param ts
	 * @return
	 */
	public static String getTimestampStr(Timestamp ts) {
		if (ts == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String tsStr = sdf.format(ts);
		return tsStr;
	}
	
	public static String getTimestampStr(String str) {
		if (str == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String tsStr = sdf.format(str);
		return tsStr;
	}
	
	/**
	 * Timestamp日期类型转化为“MM-dd HH:mm”格式的字符串日期 如果为空则返回null
	 * 
	 * @param ts
	 * @return
	 */
	public static String formatTimestamp2Str(Timestamp ts) {
		if (ts == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		String tsStr = sdf.format(ts);
		return tsStr;
	}

	/**
	 * Date日期类型转化为“MM-dd HH:mm”格式的字符串日期 如果为空则返回null
	 * 
	 * @param ts
	 * @return
	 */
	public static String formatTimestamp2Str(Date ts) {
		if (ts == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		String tsStr = sdf.format(ts);
		return tsStr;
	}

	/**
	 * Date日期类型转化为“yyyy-MM-dd HH:mm:ss”格式的字符串日期 如果为空则返回null
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimestampStr(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String tsStr = sdf.format(date);
		return tsStr;
	}
	
	/**
	 * Date日期类型转化为“yyyy-MM-dd HH:mm:ss”格式的字符串日期 如果为空则返回null
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimestampStr2(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
		String tsStr = sdf.format(date);
		return tsStr;
	}
	
	
	/**
	 * 返回Date日期类型的起始时间，返回类型是Timestamp并包含秒表 2014-01-21 00:00:00.0
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getStartTimestampByDate(Date date) {
		if (date == null)
			return null;
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);
		return new Timestamp(c1.getTimeInMillis());

	}

	/**
	 * 返回Date日期类型的结束时间，返回类型是Timestamp并包含秒表 2014-01-21 23:59:59.999
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getEndTimestampByDate(Date date) {
		if (date == null)
			return null;
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date);
		c1.set(Calendar.HOUR_OF_DAY, 23);
		c1.set(Calendar.MINUTE, 59);
		c1.set(Calendar.SECOND, 59);
		c1.set(Calendar.MILLISECOND, 999);
		return new Timestamp(c1.getTimeInMillis());
	}

	/**
	 * 日期增加 并返回Date日期类型
	 * 
	 * @param curDate
	 * @param count
	 * @return
	 */
	public static Date dateAdd(Date curDate, Integer count) {
		if (curDate == null || count == null)
			return null;
		return new Date(curDate.getTime() + count * 24 * 60 * 60 * 1000);
	}
	/**
	 * 日期增加 并返回Timestamp日期类型
	 * 
	 * @param curTimestamp
	 * @param count
	 * @return
	 */
	public static Timestamp timeAddSecond(Timestamp curTimestamp, Integer count) {
		if (curTimestamp == null || count == null)
			return null;
		return new Timestamp(curTimestamp.getTime() + count * 1000);
	}

	/**
	 * 两个日期相差几个月
	 * 
	 * @param curDate
	 * @param oldDate
	 * @return
	 */
	public static int dateDiffMont(Date curDate, Date oldDate) {
		if (curDate == null || oldDate == null)
			return 0;
		if (oldDate.getTime() >= curDate.getTime()) {
			return 0;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(curDate);
		int curYear = c.get(Calendar.YEAR);
		int curMonth = c.get(Calendar.MONTH);

		c.setTime(oldDate);
		int oldYear = c.get(Calendar.YEAR);
		int oldMonth = c.get(Calendar.MONTH);

		int result;
		if (curYear == oldYear) {
			result = curMonth - oldMonth;// 两个日期相差几个月，即月份差
		} else {
			result = 12 * (curYear - oldYear) + curMonth - oldMonth;// 两个日期相差几个月，即月份差
		}
		return result;
	}

	/**
	 * 判断两个日期的大小 是返回true 否则返回false
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean compare(Date date1, Date date2) {
		if (date1 == null || date2 == null)
			return false;
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		c1.set(Calendar.HOUR_OF_DAY, 0);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);
		c2.set(Calendar.HOUR_OF_DAY, 0);
		c2.set(Calendar.MINUTE, 0);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);

		if (c1.getTimeInMillis() >= c2.getTimeInMillis())
			return true;
		else
			return false;

	}

	/**
	 * 返回当前日期当前月的第一天 返回类型是Timestamp 格式是“2014-01-01 00:00:00.0”
	 * 
	 * @param curDate
	 * @return
	 */
	public static Timestamp getFirstDayOfMonth(Date curDate) {
		if (curDate == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(curDate);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		System.out.println(new Timestamp(c.getTimeInMillis()));
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回当前日期下个月的第一天 返回类型是Timestamp 格式是“2014-02-01 00:00:00.0”
	 * 
	 * @param curDate
	 * @return
	 */
	public static Timestamp getFirstDayOfNextMonth(Date curDate) {
		if (curDate == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(curDate);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		c.add(Calendar.MONTH, 1);//
		System.out.println(new Timestamp(c.getTimeInMillis()));
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回指定年份的第一天 返回类型是Timestamp 格式是“2013-01-01 00:00:00.0”
	 * 
	 * @param yearStr
	 *            ("参数格式：2013")
	 * @return
	 */
	public static Timestamp getFirstDayOfYear(String yearStr) {
		if (yearStr == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, new Integer(yearStr));
		c.set(Calendar.MONTH, 0); //
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		System.out.println(new Timestamp(c.getTimeInMillis()));
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回指定年份的最后一天 返回类型是Timestamp 格式是“2013-12-31 23:59:59.999”
	 * 
	 * @param yearStr
	 *            ("参数格式：2013")
	 * @return
	 */
	public static Timestamp getLastDayOfYear(String yearStr) {
		if (yearStr == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, new Integer(yearStr));
		c.set(Calendar.MONTH, 11); //
		c.set(Calendar.DATE, 31);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		System.out.println(new Timestamp(c.getTimeInMillis()));
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回本季度的第一天 返回类型是Timestamp 格式是“2013-10-01 00:00:00.0”
	 * 
	 * @param yearStr
	 *            (例如参数：2013)
	 * @param qurStr
	 *            (例如第XX季度：4)
	 * @return
	 */
	public static Timestamp getFirstDayOfQuarter(String yearStr, String qurStr) {
		if (yearStr == null)
			return null;
		if (qurStr == null)
			return null;
		String qurTmp = "";
		if ("1".equals(qurStr))
			qurTmp = "0";
		else if ("2".equals(qurStr))
			qurTmp = "3";
		else if ("3".equals(qurStr))
			qurTmp = "6";
		else if ("4".equals(qurStr))
			qurTmp = "9";
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, new Integer(yearStr));
		c.set(Calendar.MONTH, new Integer(qurTmp)); //
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		System.out.println(new Timestamp(c.getTimeInMillis()));
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回指定年、月份的第一天 返回类型是Timestamp 格式是“2013-04-01 00:00:00.0”
	 * 
	 * @param yearStr
	 *            (例如参数：2013)
	 * @param monthStr
	 *            (例如参数：4)
	 * @return
	 */
	public static Timestamp getFirstDayOfMonth(String yearStr, String monthStr) {
		if (yearStr == null)
			return null;
		if (monthStr == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, new Integer(yearStr));
		c.set(Calendar.MONTH, new Integer(monthStr) - 1); //
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		System.out.println(new Timestamp(c.getTimeInMillis()));
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回当前日期的上个月的当前时间段 返回类型Timestamp 格式：”2013-12-21 12:15:45.096“
	 * 
	 * @param endTime
	 *            （例如参数：2014-01-21）
	 * @return
	 */
	public static Timestamp getFirstDayOfPreMonth(Timestamp endTime) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(endTime.getTime()));
		System.out.println(c.getTime());
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH) - 1;

		System.out.println(y);
		System.out.println(m);
		if (m == -1) {
			y = y - 1;
			m = 11;
		}
		c.set(Calendar.YEAR, y);
		c.set(Calendar.MONTH, m);
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回上一年的第一个月的第一天 返回类型Timestamp 格式：2013-01-01 00:00:00.0
	 * 
	 * @param curDate
	 * @return
	 */
	public static Timestamp getPrevYearFirstDayOfMonth(Date curDate) {
		if (curDate == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(curDate);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		c.add(Calendar.YEAR, -1);//
		System.out.println(new Timestamp(c.getTimeInMillis()));
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回上一年的第二个月的第一天 返回类型Timestamp 格式：2013-02-01 00:00:00.0
	 * 
	 * @param curDate
	 * @return
	 */
	public static Timestamp getPrevYearFirstDayOfNextMonth(Date curDate) {
		if (curDate == null)
			return null;
		Calendar c = Calendar.getInstance();
		c.setTime(curDate);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.DATE, 1);// 设为当前月的1号
		c.add(Calendar.MONTH, 1);//
		c.add(Calendar.YEAR, -1);//
		System.out.println(new Timestamp(c.getTimeInMillis()));
		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * 返回字符串日期 返回类型：string 参数类型：Timestamp 返回格式：yyyy.MM
	 * 
	 * @param tmp
	 * @return
	 */
	public static String cvtTimestampToStr(Timestamp tmp) {
		if (tmp == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM");
		String timeStr = sdf.format(new Date(tmp.getTime()));
		System.out.println(timeStr);
		return timeStr;
	}

	/**
	 * 返回字符串日期 返回类型：string 参数类型：Date 返回格式：yyyy.MM
	 * 
	 * @param tmp
	 * @return
	 */
	public static String cvtDateToStr(Date tmp) {
		if (tmp == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM");
		String timeStr = sdf.format(tmp);
		System.out.println(timeStr);
		return timeStr;
	}

	/**
	 * 返回两个日期相差多少秒 返回类型Integer 参数类型：Timestamp
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static Integer diffTimestamp4Second(Timestamp startTime,
			Timestamp endTime) {
		if (startTime == null || endTime == null)
			return 0;
		Integer diff = new Long(
				(endTime.getTime() - startTime.getTime()) / 1000).intValue();
		return diff;
	}
	/**
	 * 获取当前时间格式为yyyy-MM-dd HH:mm:ss的字符串
	 * @return
	 */
	public static String getCurrentYYYYMMDDHHMMSS() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		Date currTime = new Date();
		String thisTime = new String(formatter.format(currTime));
		return thisTime;
	}

	/**
	 *  获取当前时间格式为yyyy-MM-dd HH:mm:ss的字符串
	 * @param inputDate
	 * @return
	 */
	public static String getYYYYMMDDHHMMSS(Date inputDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String thisTime = new String(formatter.format(inputDate));
		return thisTime;
	}
	/**
	 *  获取当前时间格式为yyyy-MM-ddHHmmssSSS的字符串
	 * @return
	 */
	public static String getCurrentYYYYMMDDHHMMssSSS() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-ddHHmmssSSS", Locale.US);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		Date currTime = new Date();
		String thisTime = new String(formatter.format(currTime));
		return thisTime;
	}
/**
 * 获取当前时间格式为yyyyMMddHHmmssSSS的字符串
 * @return
 */
	public static String getCurrentYYYYMMDDHHMMssSSSFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.US);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		Date currTime = new Date();
		String thisTime = new String(formatter.format(currTime));
		return thisTime;
	}
	/**
	 * 获取当前时间格式为yyyy-MM-dd的字符串
	 * @return
	 */
	public static String getCurrentYYYYMMDD() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.US);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		Date currTime = new Date();
		String thisTime = new String(formatter.format(currTime));
		return thisTime;
	}
/**
 * 获取当前时间格式为yyyyMMddHHmmss的字符串
 * @return
 */
	public static String getCurrent_yyyyMMddHHmmss() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		Date currTime = new Date();
		String thisTime = new String(formatter.format(currTime));
		return thisTime;
	}
	public static void main(String[] args) {

		System.out.println(getCurrentYYYYMMDD());

	}

}
