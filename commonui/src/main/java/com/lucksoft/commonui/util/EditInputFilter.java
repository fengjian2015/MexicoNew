package com.lucksoft.commonui.util;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditInputFilter implements InputFilter {
    /**
     * 最大数字
     */
    //public static final int MAX_VALUE = 10000;

    /**
     * 小数点后的数字的位数
     */
    //public static final int PONTINT_LENGTH = 2;

    private double maxValue = 0;//最大值限制，0表示无限制
    private int maxLength = 0;//最大长度限制，0表示无限制
    private int integerLength = 0;//整数位数限制，0表示无限制
    private int decimalLength = 0;//小数位数限制，0表示无限制

    private boolean checkLength = true;//是否验证数据长度

    Pattern pattern = null;

    public EditInputFilter() {
        //pattern = Pattern.compile("[0-9]*");   //除数字外的其他的
    }

    public EditInputFilter(double maxValue, int maxLength, int integerLength, int decimalLength) {
        //pattern = Pattern.compile("[0-9]*");   //除数字外的其他的

        this.maxValue = maxValue;
        this.maxLength = maxLength;
        this.integerLength = integerLength;
        this.decimalLength = decimalLength;
    }

    public void setInputValues(String inputValues) {
        if (!TextUtils.isEmpty(inputValues)) {
            pattern = Pattern.compile(inputValues);
        }
    }

    public void setCheckLength(boolean checkLength) {
        this.checkLength = checkLength;
    }

    /**
     * source  新输入的字符串
     * start   新输入的字符串起始下标，一般为0
     * end     新输入的字符串终点下标，一般为source长度-1
     * dest    输入之前文本框内容
     * dstart  新输入的内容在原内容的起始坐标，一般为0
     * dend    新输入的内容在原内容的终点坐标，一般为dest长度-1
     */
    @Override
    public CharSequence filter(CharSequence src, int start, int end, Spanned dest, int dstart, int dend) {
        String oldtext = dest.toString();
        //System.out.println(oldtext);
        //验证删除等按键
        if ("".equals(src.toString())) {
            return null;
        }

        if (pattern != null) {
            //验证非数字或者小数点的情况
            Matcher m = pattern.matcher(src);
//            if (oldtext.contains(".")) {
//                //已经存在小数点的情况下，只能输入数字
//                if (!m.matches()) {
//                    return null;
//                }
//            } else {
//                //未输入小数点的情况下，可以输入小数点和数字
//                if (!m.matches() && !src.equals(".")) {
//                    return null;
//                }
//            }
            if (!m.matches()) {
                return dest.subSequence(dstart, dend);
            }
        }

        if (checkLength) {
            if (maxLength > 0) {
                if (oldtext.length() + src.toString().length() > maxLength) {
                    return dest.subSequence(dstart, dend);
                }
            }

            if (maxValue > 0) {
                //验证输入金额的大小
                if (!src.toString().equals("")) {
                    try {
                        double dold = Double.parseDouble(oldtext + src.toString());
                        if (dold > maxValue) {
                            //CustomerToast.showToast(RechargeActivity.this, "输入的最大金额不能大于MAX_VALUE");
                            return dest.subSequence(dstart, dend);
                        } else if (dold == maxValue) {
                            if (src.toString().equals(".")) {
                                //CustomerToast.showToast(RechargeActivity.this, "输入的最大金额不能大于MAX_VALUE");
                                return dest.subSequence(dstart, dend);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            if (integerLength > 0) {
                int index = oldtext.indexOf(".");
                if (index != -1) {
                    if (dstart <= index) {
                        //输入的是整数部分
                        if (index >= integerLength) {
                            return dest.subSequence(dstart, dend);
                        }

                        if (index + src.toString().length() > integerLength) {
                            return dest.subSequence(dstart, dend);
                        }
                    }
                } else {
                    if (!src.toString().equals(".")) {
                        if (oldtext.length() + src.toString().length() > integerLength) {
                            return dest.subSequence(dstart, dend);
                        }
                    }
                }
            }

            if (decimalLength > 0) {
                //验证小数位精度是否正确
                int index = oldtext.indexOf(".");
                if (index != -1) {
                    if (dstart > index) {
                        //输入的是小数部分
                        int len = oldtext.length() - index - 1 + src.toString().length();
                        //小数位只能2位
                        //if (len > PONTINT_LENGTH) {
                        //    CharSequence newText = dest.subSequence(dstart, dend);
                        //    return newText;
                        //}
                        if (len > decimalLength) {
                            CharSequence newText = dest.subSequence(dstart, dend);
                            return newText;
                        }
                    }
                }
            }
        }

        return dest.subSequence(dstart, dend) + src.toString();
    }
}

