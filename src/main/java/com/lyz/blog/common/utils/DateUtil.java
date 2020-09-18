package com.lyz.blog.common.utils;

import com.lyz.blog.common.constant.GlobalConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 功能说明：
 *
 * @author LYZ
 * @date 2020/4/1 14:36
 */
@Slf4j
public class DateUtil {

    /**
     * 将时间搓转换为 yyyy-MM
     * @param timestamp
     * @return
     */
    public static String timestampToYearMonth(Long timestamp, String dateFormat){
        String format = null;
        if(timestamp!=null && timestamp>0){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            format = simpleDateFormat.format(new Date(timestamp));
        }
        return format;
    }

    public static String timestampToYearMonthDay(Long timestamp, String dateFormat){
        String format = null;
        if(timestamp!=null && timestamp>0){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            format = simpleDateFormat.format(new Date(timestamp));
        }
        return format;
    }

    /**
     *
     * @param timestamp
     * @return
     */
    public static String getTimeByLong(Long timestamp, String rep){
        String format = null;
        if(timestamp!=null && timestamp>0){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(rep);
            format = simpleDateFormat.format(new Date(timestamp));
        }
        return format;
    }

    /**
     * 根据时间搓将年份减少
     * @param date
     * @param year 需要减少的年数
     * @return
     */
    public static String minusYear(String date, int year, String dateFormat){
        String format = null ;
        try {
            if(StringUtils.isNotEmpty(date)){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
                LocalDate localDate = Instant.ofEpochMilli(simpleDateFormat.parse(date).getTime()).atZone(ZoneOffset.ofHours(8)).toLocalDate();
                LocalDate minus = localDate.minus(year, ChronoUnit.YEARS);
//                LocalDate minus1 = minus.minus(year, ChronoUnit.MONTHS);
                Long milli = minus.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
                format = simpleDateFormat.format(milli);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format;
    }

    /**
     * 根据时间搓将月份份减少
     * @param date
     * @param month 需要减少的年数
     * @return
     */
    public static String minusMonth(String date, int month, String dateFormat){
        String format = null;
        try {
            if(StringUtils.isNotEmpty(date)){
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
                LocalDate localDate = Instant.ofEpochMilli(simpleDateFormat.parse(date).getTime()).atZone(ZoneOffset.ofHours(8)).toLocalDate();
                LocalDate minus = localDate.minus(month, ChronoUnit.MONTHS);
                Long milli = minus.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();
                format = simpleDateFormat.format(milli);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format;
    }

    /**
     * 根据时间、格式转换成时间搓
     * @param date
     * @param dateFormat
     * @return
     */
    public static long getTimeByString(String date, String dateFormat){
        long longTime = 0L;
        if(StringUtils.isNotEmpty(date)){
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
                longTime = simpleDateFormat.parse(date).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return longTime;
    }
    public static void main(String[] args) {
        String date = "2020/07/15 12:25";
        long timeByString = getTimeByString(date, GlobalConstant.DATE_FORMAT_YMD_HM);
        System.out.println(timeByString);
        String timeByLong = getTimeByLong(timeByString, GlobalConstant.DATE_FORMAT_YMD_HM);
        String timeByLong1 = getTimeByLong(1596152160000L, GlobalConstant.DATE_FORMAT_YMD_HMS);
//        String s = minusYear("2020-04", 1, "yyyy-MM");
        System.out.println(timeByLong);
    }
}
