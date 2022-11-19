/**
 * 
 */
package com.fly.ayudaconfiable.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;


public class ToastUtil {
	private static Context gcontext;
	private static Toast toast;
	private static View view;
	private int height = 0;
	private int width = 0;
	private static String oldMsg;
	private static long oneTime = 0;
	private static long twoTime = 0;

	private volatile static ToastUtil mSingleton = null;

	private ToastUtil () {}

	public static ToastUtil getInstance() {
		if (mSingleton == null) {
			synchronized (ToastUtil.class) {
				if (mSingleton == null) {
					mSingleton = new ToastUtil();
				}
			}
		}
		return mSingleton;
	}

	public void setContent(Context mContent) {
		gcontext = mContent;
	}

	public static void show(String msg) {
		showToast(msg, 900); //
	}

	public static void show1200(String info) {
		showToast(info, 1200);
	}

	public static void showLongToast(CharSequence msg) {
		showToast(msg, Toast.LENGTH_LONG);
	}

	public static void showLongToast(int resId) {
		showToast(resId, Toast.LENGTH_LONG);
	}

	public static void show(String msg, int duration) {
		showToast(msg, duration);
	}

	public static void showToast( String s) {
		if (toast == null) {
			toast = Toast.makeText(gcontext, s, Toast.LENGTH_SHORT);
			toast.show();
			oneTime = System.currentTimeMillis();
		} else {
			twoTime = System.currentTimeMillis();
			if (s.equals(oldMsg)) {
				if (twoTime - oneTime > Toast.LENGTH_SHORT) {
					toast.show();
				}
			} else {
				oldMsg = s;
				toast.setText(s);
				toast.show();
			}
		}
		oneTime = twoTime;
	}

	private static void showToast(CharSequence msg, int duration) {
		try {
			if (gcontext == null) {
				Log.e("error", " 没有初始化 ，获取全局 ");
				//gcontext = NewNakeApplication.getInstance().getApplicationContext();//new ToastUtil();
				return;
			}
			getToast(gcontext);
			toast.setText(msg);
			toast.setDuration(duration);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} catch (Exception e) {
			LogUtils.e(e.getMessage());
		}
	}

	/*
	 *
	 *
	 */
	private static void showToast(int resId, int duration) {
		try {
			if (gcontext == null) {
				LogUtils.e("未初始化Application");
				return;
			}
			if (resId == 0) {
				return;
			}
			getToast(gcontext);
			toast.setText(resId);
			toast.setDuration(duration);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		} catch (Exception e) {
			LogUtils.e(e.getMessage());
		}
	}

	@SuppressLint("ShowToast")
	private static void getToast(Context context) {
		if (toast == null) {
			if (gcontext != null) {
				toast = new Toast(gcontext);
			} else {
				toast = new Toast(context);
			}
		}
		if (view == null) {
			if (gcontext != null) {
				view = Toast.makeText(gcontext, "", Toast.LENGTH_SHORT).getView();
			} else {
				view = Toast.makeText(context, "", Toast.LENGTH_SHORT).getView();
			}
		}
		toast.setView(view);
	}

	public static void cancelToast() {
		if (toast != null) {
			toast.cancel();
		}
	}
}
