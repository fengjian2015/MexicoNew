package com.fly.ayudaconfiable.utils;

import android.text.TextUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Administrator on 2018/9/4.
 */

public class TimeUtil {
    static StringBuilder sb = new StringBuilder();
    static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds   精确到秒的字符串
     * @param formatStr
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty()) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 获取日期时间
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String getDate(int year, int month, int day) {
        String date;
        if (month < 9) {
            if (day < 10) {
                date = year + "-0" + (month + 1) + "-0" + day;
            } else {
                date = year + "-0" + (month + 1) + "-" + day;
            }
        } else {
            if (day < 10) {
                date = year + "-" + (month + 1) + "-0" + day;
            } else {
                date = year + "-" + (month + 1) + "-" + day;
            }
        }
        return date;
    }

    public static String getYearByLong(long date) {
        if (date == 0) {
            return "";
        }
        String s = Long.toString(date);
        sb.setLength(0);
        sb.append(s);
        //20190730140000
        sb.insert(4, "-");
        //2019-0730140000
        sb.insert(7, "-");
        return sb.toString();
    }

    public static String getTimeByLong(long date) {
        if (date == 0) {
            return "";
        }
        String s = Long.toString(date);
        sb.setLength(0);
        sb.append(s);
        //20190730140000
        sb.insert(4, "-");
        //2019-0730140000
        sb.insert(7, "-");
        //2019-07-30140000
        sb.insert(10, " ");
        //2019-07-30 140000
        sb.insert(13, ":");
        sb.insert(16, ":");
        return sb.toString();
    }

    public static String getTimeByLong2(long date) {
        String s = Long.toString(date);
        /** 需要年月日时分 20190717000000 */
        if (s.length() > 12) {
            s = s.substring(0, 12);

            sb.setLength(0);
            sb.append(s);
            //20190730140000
            sb.insert(4, "-");
            //2019-0730140000
            sb.insert(7, "-");
            //2019-07-30140000
            sb.insert(10, " ");
            //2019-07-30 140000
            sb.insert(13, ":");
            return sb.toString();
        }
        return "";
    }

    public static String getTimeByLong3(long date) {
        String s = Long.toString(date);
        /** 需要时分 20190717000000 */
        if (s.length() > 12) {
            s = s.substring(8, 12);
            sb.setLength(0);
            sb.append(s);
            //20190730140000
            sb.insert(2, ":");
            return sb.toString();
        }
        return "";
    }

    public static String getTimeByString(String date) {
        /** 需要年月日时分 20190717000000 */
        if (date.length() > 12) {
            date = date.substring(0, 12);

            sb.setLength(0);
            sb.append(date);
            //20190730140000
            sb.insert(4, "/");
            //2019-0730140000
            sb.insert(7, "/");
            //2019-07-30140000
            sb.insert(10, " ");
            //2019-07-30 140000
            sb.insert(13, ":");
            return sb.toString();
        }
        return "";
    }

    public static String getTime(long date) {
        String s = Long.toString(date);
        if (s.length() < 6) {
            return "error";
        }
        /** 只要年月日 20190717000000 */
        if (s.length() > 8) {
            s = s.substring(0, 8);
        }
        sb.setLength(0);
        sb.append(s);
        //20190730140000
        sb.insert(4, "-");
        //2019-0730140000
        sb.insert(7, "-");
        //2019-07-30140000
        sb.insert(10, " ");
        return sb.toString();
    }

    public static String getMemBirthday(int BirthdayYear, int BirthdayMonth, int BirthdayDay) {
        //"BirthdayYear":2012,"BirthdayMonth":2,"BirthdayDay":8
        String year = Integer.toString(BirthdayYear);
        String month = Integer.toString(BirthdayMonth);
        String day = Integer.toString(BirthdayDay);

        if (BirthdayYear == 0) {
            year = "000" + year;
        }

        if (BirthdayMonth < 10) {
            month = "0" + month;
        }

        if (BirthdayDay < 10) {
            day = "0" + day;
        }

        return year + "-" + month + "-" + day;
    }

    public static String timeToShow(boolean isMonth, String selectTime) {
        sb.setLength(0);
        if (TextUtils.isEmpty(selectTime)) {
            return "";
        }
        String[] strarr = selectTime.split(",");
        if (strarr == null) {
            return "";
        }
        if (isMonth) {
            sb.append("每月");
            for (String day : strarr) {
                sb.append(day + "号、");
            }
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append("每");
            for (String day : strarr) {
                if (day.equals("0")) {
                    sb.append("周日、");
                } else if (day.equals("1")) {
                    sb.append("周一、");
                } else if (day.equals("2")) {
                    sb.append("周二、");
                } else if (day.equals("3")) {
                    sb.append("周三、");
                } else if (day.equals("4")) {
                    sb.append("周四、");
                } else if (day.equals("5")) {
                    sb.append("周五、");
                } else if (day.equals("6")) {
                    sb.append("周六、");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String[] getPastDate(int past, boolean getToday, boolean justGetToday) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date todayDate = calendar.getTime();

        int count = 1;
        if (getToday) {
            count = 2;
        }

        String[] result = new String[count];

        if (justGetToday) {
            String todayDateStr = format.format(todayDate);

            result[0] = todayDateStr;
        } else {
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
            Date pastDate = calendar.getTime();
            String pastDateStr = format.format(pastDate);
            //Log.e(null, result);

            result[0] = pastDateStr;

            if (getToday) {
                String todayDateStr = format.format(todayDate);

                result[1] = todayDateStr;
            }
        }

        return result;
    }

    /**
     * 获取过去/未来第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past, String dateTime, SimpleDateFormat format) {
        Calendar calendar = Calendar.getInstance();

        if (dateTime == null || dateTime.length() == 0) {
            //date = calendar.getTime();//获取当前时间
        } else {
            try {
                Date date = format.parse(dateTime);
                calendar.setTime(date);//calendar.setTime(new Date(date.getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date pastDate = calendar.getTime();
        String pastDateStr = format.format(pastDate);

        return pastDateStr;
    }

    /**
     * 获取过去第几月的日期
     *
     * @param past
     * @return
     */
    public static String[] getPastMonthDate(int past, boolean getToday) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");

        if (past != 0) {
            calendar.add(Calendar.MONTH, -past);
        }

        //得到一个月最后一天日期(31/30/29/28)
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        //按你的要求设置时间
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), maxDay, 23, 59, 59);

        Date pastDate = calendar.getTime();
        String pastDateStr = format.format(pastDate);
        //Log.e(null, result);

        String[] result = new String[2];
        result[0] = pastDateStr + "-01";
        result[1] = pastDateStr + String.format("-%02d", maxDay);
        return result;
    }

    public static String YMDHMS(long time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        String times = sdr.format(new Date(lcc * 1000L));
        return times;
    }

    /**
     * 时间戳转特定格式时间
     *
     * @param dataFormat 时间格式
     * @param timeStamp  时间毫秒数
     * @return
     */
    public static String formatDataMsec(long timeStamp, String dataFormat) {
        if (timeStamp == 0) {
            return "";
        }
        SimpleDateFormat format = new SimpleDateFormat(dataFormat);
        return format.format(new Date(timeStamp));
    }

    public static Date getPointDate() {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);//把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); //这个时间就是日期往后推一天的结果
        return date;
    }

    public static int getDayofWeek(String dateTime, SimpleDateFormat dateFormat) {
        Calendar cal = Calendar.getInstance();
        if (dateTime == null || dateTime.length() == 0) {
            cal.setTime(new Date(System.currentTimeMillis()));
        } else {
            //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

            if (dateFormat != null) {
                Date date;
                try {
                    date = dateFormat.parse(dateTime);
                } catch (ParseException e) {
                    date = null;
                    e.printStackTrace();
                }
                if (date != null) {
                    cal.setTime(new Date(date.getTime()));
                }
            }
        }
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public static String getWeekText(int dayOfWeek, String dateTime, SimpleDateFormat dateFormat) {
        String week = "";
        if (dayOfWeek == -1) {
            dayOfWeek = getDayofWeek(dateTime, dateFormat);
        }

        switch (dayOfWeek) {
            case 1:
                week = "星期日";
                break;
            case 2:
                week = "星期一";
                break;
            case 3:
                week = "星期二";
                break;
            case 4:
                week = "星期三";
                break;
            case 5:
                week = "星期四";
                break;
            case 6:
                week = "星期五";
                break;
            case 7:
                week = "星期六";
                break;
        }
        return week;
    }

    /**
     * 获取两个日期之间的间隔天数
     *
     * @return
     */
    public static int getDateGapCount(Date startDate, Date endDate, String startDateStr, String endDateStr, SimpleDateFormat dateFormat) {
        if (startDate == null || endDate == null) {
            if (dateFormat != null) {
                try {
                    if (startDateStr != null) {
                        startDate = dateFormat.parse(startDateStr);
                    }

                    if (endDateStr != null) {
                        endDate = dateFormat.parse(endDateStr);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }
}
