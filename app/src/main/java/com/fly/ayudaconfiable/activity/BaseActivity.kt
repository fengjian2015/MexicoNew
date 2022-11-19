package com.fly.ayudaconfiable.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.fly.ayudaconfiable.R
import com.fly.ayudaconfiable.utils.SoftKeyboardUtils
import com.fly.ayudaconfiable.utils.ToastUtil
import com.gyf.immersionbar.ImmersionBar


abstract class BaseActivity<VB : ViewBinding>(
    private val inflate: (LayoutInflater) -> VB
) : AppCompatActivity() {

    lateinit var binding: VB
    var immersionBar: ImmersionBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        initBar()
        initView()
    }

    abstract fun initView()

    private fun initBar() {
        immersionBar = ImmersionBar
            .with(this)
            .fitsSystemWindows(true)
            .statusBarColor(R.color.c_bg)
            .statusBarDarkFont(true)
            .keyboardEnable(true)
        immersionBar?.let {
            it.init()
        }
    }

    override fun finish() {
        super.finish()
        SoftKeyboardUtils.hideSoftKeyboard(this)
    }

    open fun showMsg(msg: String?) {
        //ToastUtil.show(this, msg);
        ToastUtil.show(msg)
    }

    open fun startActivity(clz: Class<*>?) {
        startActivity(Intent(this@BaseActivity, clz))
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        if (ev.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (isShouldHideInput(v, ev)) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm?.hideSoftInputFromWindow(v!!.windowToken, 0)
            }
            return super.dispatchTouchEvent(ev)
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        return if (window.superDispatchTouchEvent(ev)) {
            true
        } else onTouchEvent(ev)
    }

    /**
     * 点击 EditText 以外的区域 ，自动收起软键盘
     *
     * @param v
     * @param event
     * @return
     */
    open fun isShouldHideInput(v: View?, event: MotionEvent): Boolean {
        if (v != null && v is EditText) {
            val leftTop = intArrayOf(0, 0)
            v.getLocationInWindow(leftTop)
            val left = leftTop[0]
            val top = leftTop[1]
            val bottom = top + v.getHeight()
            val right = left + v.getWidth()
            return !(event.x > left && event.x < right && event.y > top && event.y < bottom)
        }
        return false
    }

    /**
     * 右补位，左对齐
     *
     * @param oriStr 原字符串
     * @param len    目标字符串长度
     * @param alexin 补位字符
     * @return 目标字符串
     */
    open fun padRight(oriStr: String, len: Int, alexin: Char): String? {
        var str = String()
        val strlen = oriStr.length
        if (strlen < len) {
            for (i in 0 until len - strlen) {
                str = str + alexin
            }
        }
        str = str + oriStr
        return str
    }

    open fun isLetter(c: Char): Boolean {
        val k = 0x80
        return if (c.code / k == 0) true else false
    }

    /**
     * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
     *
     * @param s 需要得到长度的字符串
     * @return int 得到的字符串长度
     */
    open fun RealyLength(s: String?): Int {
        if (s == null) {
            return 0
        }
        val c = s.toCharArray()
        var len = 0
        for (i in c.indices) {
            len++
            if (!isLetter(c[i])) {
                len++
            }
        }
        return len
    }

}
