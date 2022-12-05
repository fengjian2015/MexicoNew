package com.fly.ayudaconfiable.activity

import android.graphics.Color
import android.text.*
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.CompoundButton
import com.fly.ayudaconfiable.R
import com.fly.ayudaconfiable.databinding.ActivityLogin2Binding
import com.fly.ayudaconfiable.utils.Cons
import com.fly.ayudaconfiable.utils.MMKVCacheUtil
import com.fly.ayudaconfiable.utils.UiUtil

class Login2Activity : BaseActivity<ActivityLogin2Binding>(ActivityLogin2Binding::inflate) {

    override fun initView() {
        val spannableString = SpannableString(binding.ptv.text)
        UiUtil.tColorTextClick(spannableString,
            29,
            51,
            Color.parseColor("#F69800"),
            View.OnClickListener { view: View? ->
                if (MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_1) == null) return@OnClickListener
                BaseWebActivity.openWebView(this, MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_1), false,false)
            })
        UiUtil.tColorTextClick(spannableString,
            54,
            79,
            Color.parseColor("#F69800"),
            View.OnClickListener { view: View? ->
                if (MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_2) == null) return@OnClickListener
                BaseWebActivity.openWebView(this, MMKVCacheUtil.getString(Cons.KEY_PROTOCAL_2), false,false)
            })
        binding.ptv.text = spannableString
        binding.ptv.movementMethod = LinkMovementMethod.getInstance()

        binding.edtv.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(10))
        binding.edtv.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (binding.edtv.text.toString().startsWith("0")) {
                    binding.edtv.setText("")
                    return
                }
                if (binding.edtv.text.toString().contains(" ")) {
                    val txt: String = binding.edtv.text.toString().replace(" ".toRegex(), "")
                    binding.edtv.setText(txt)
                    binding.edtv.setSelection(txt.length)
                }
            }

            override fun afterTextChanged(editable: Editable) {
                checkButton()
            }
        })
        binding.pcb.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener {
                compoundButton: CompoundButton?, b: Boolean -> checkButton() })
        binding.btUpgrade.setOnClickListener {
            MMKVCacheUtil.putString(Cons.KEY_PHONE,binding.edtv.text.toString())
            startActivity(SMSActivity::class.java)
        }
        checkButton()

    }
    private fun checkButton() {
        if (!binding.pcb.isChecked) {
            binding.btUpgrade.background = resources.getDrawable(R.drawable.button_no)
            binding.btUpgrade.isClickable = false
            binding.btUpgrade.isEnabled = false
            return
        }
        if (TextUtils.isEmpty(binding.edtv.text) || binding.edtv.text.length != 10) {
            binding.btUpgrade.background = resources.getDrawable(R.drawable.button_no)
            binding.btUpgrade.isClickable = false
            binding.btUpgrade.isEnabled = false
            return
        }
        binding.btUpgrade.background = resources.getDrawable(R.drawable.button_ok)
        binding.btUpgrade.isClickable = true
        binding.btUpgrade.isEnabled = true
    }
}