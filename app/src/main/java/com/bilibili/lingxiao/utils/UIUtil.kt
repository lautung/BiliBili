package com.bilibili.lingxiao.utils

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

object UIUtil {
    var mContext :Context? = null
    fun init(context: Context) {
        mContext = context
    }
    fun getContext() :Context{
        return mContext!!
    }
    fun getScreenWidth(context: Context): Int {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.widthPixels
    }

    fun getScreenHeight(context: Context): Int {
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val outMetrics = DisplayMetrics()
        wm.defaultDisplay.getMetrics(outMetrics)
        return outMetrics.heightPixels
    }

    /**
     * 获取屏幕dpi
     */
    fun getDensityString(): String {
        val displayMetrics = getContext().getResources().getDisplayMetrics()
        when (displayMetrics.densityDpi) {
            DisplayMetrics.DENSITY_LOW -> return "ldpi"
            DisplayMetrics.DENSITY_MEDIUM -> return "mdpi"
            DisplayMetrics.DENSITY_HIGH -> return "hdpi"
            DisplayMetrics.DENSITY_XHIGH -> return "xhdpi"
            DisplayMetrics.DENSITY_XXHIGH,
            DisplayMetrics.DENSITY_440,
            DisplayMetrics.DENSITY_420,
            DisplayMetrics.DENSITY_400 -> return "xxhdpi"
            DisplayMetrics.DENSITY_XXXHIGH -> return "xxxhdpi"
            DisplayMetrics.DENSITY_TV -> return "tvdpi"
            //else -> return displayMetrics.densityDpi.toString()
            else -> return "xxxhdpi"
        }
    }
}