package com.example.spingboottext.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static final String DATE_12_AMFM="yyyy-MM-dd KK:mm:ss a";//12小时年月日时分秒 上午/下午
    public static final String DATE_24="yyyy-MM-dd HH:mm:ss";//年月日时分秒
    public static String dateToString(Date time, String dateFormat){
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat(dateFormat);
        String ctime = formatter.format(time);

        return ctime;
    }

    public static Date getDateNoTime(String date){
        Date dt=null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                if(date!=null&&date.equals("")==false)
                    dt = df.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return dt;
    }
}
