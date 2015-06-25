/**  
 * Copyright © 2015公司名字. All rights reserved.
 *
 * @Title: L.java
 * @Prject: WorkUtils
 * @Package: com.utils.utils
 * @Description: TODO
 * @author: rxy  
 * @date: 2015年5月29日 上午10:03:50
 * @version: V1.0  
 */
package com.adv.viewpageradv;

import android.util.Log;

/**
 * @ClassName: L
 * @Description: Log统一管理类
 * @author: rxy
 * @date: 2015年5月29日 上午10:03:50
 */
public class L {

	private L() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	/**
	 * 是否需要打印Log，可在application的oncreate中初始化
	 * */
//	public static boolean isDebug = true;

	private static final String TAG = "mylog";

	// 使用默认tag的函数
	public static void i(String msg,boolean isDebug) {
		if (isDebug)
			Log.i(TAG, msg);
	}

	public static void d(String msg,boolean isDebug) {
		if (isDebug)
			Log.d(TAG, msg);
	}

	public static void e(String msg,boolean isDebug) {
		if (isDebug)
			Log.e(TAG, msg);
	}

	public static void v(String msg,boolean isDebug) {
		if (isDebug)
			Log.v(TAG, msg);
	}

	// 传入自定义tag的函数
	public static void i(String tag, String msg,boolean isDebug) {
		if (isDebug)
			Log.i(tag, msg);
	}

	public static void d(String tag, String msg,boolean isDebug) {
		if (isDebug)
			Log.d(tag, msg);
	}

	public static void e(String tag, String msg,boolean isDebug) {
		if (isDebug)
			Log.e(tag, msg);
	}

	public static void v(String tag, String msg,boolean isDebug) {
		if (isDebug)
			Log.v(tag, msg);
	}
}
