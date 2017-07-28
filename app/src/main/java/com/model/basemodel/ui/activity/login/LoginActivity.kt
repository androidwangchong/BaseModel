package com.model.basemodel.ui.activity.login

import android.view.View
import com.jaeger.library.StatusBarUtil
import com.jakewharton.rxbinding2.view.RxView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.model.basemodel.R
import com.model.basemodel.ui.activity.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.textChangedListener
import java.util.concurrent.TimeUnit
import android.R.attr.editable


/**
 * BaseModel
 * Created by wangchong on 2017/7/27.
 */
class LoginActivity : BaseActivity() {
    override val title: String = ""
    override val layoutResId: Int = R.layout.activity_login
    var isVerificationLogin: Boolean = true

    override fun initView() {
        StatusBarUtil.setTransparent(this@LoginActivity)

        clickEvent()

    }

    override fun initData() {
    }

    fun clickEvent() {
        //关闭activity
        close_icon.onClick {
            finish()
        }
        //切换登录方式
        RxView.clicks(top_right_button).throttleFirst(1, TimeUnit.SECONDS)
                .subscribe {
                    when (isVerificationLogin) {
                        true -> {
                            top_right_button.text = "快捷登录"
                            password_edit_layout.visibility = View.VISIBLE
                            verification_code_edit_layout.visibility = View.GONE
                        }
                        false -> {
                            top_right_button.text = "账号密码登录"
                            password_edit_layout.visibility = View.GONE
                            verification_code_edit_layout.visibility = View.VISIBLE
                        }
                    }
                    isVerificationLogin = !isVerificationLogin
                }
        //清除手机号码
        phone_num_tip.onClick {
            phone_num_edit.setText("")
        }


        RxTextView.afterTextChangeEvents(phone_num_edit).subscribe({
            textViewAfterTextChangeEvent ->
//            val text = textViewAfterTextChangeEvent.editable().toString()
//            if (replaceTime(text).length() > 0) {
//                verification_code_et.setText("")
//                password_et.setText("")
//                phoneEditTextLeng = true
//                if (StringUtil.replaceTime(text).length() === 11 && countDownTime == 60 &&
//                        StringUtil.isMobile(StringUtil.replaceTime(phone_num_et.getText().toString()))) {
//                    setVerificationCodeBtnEnableAndBg(true, R.color.look_report_details_color)
//                } else {
//                    setVerificationCodeBtnEnableAndBg(false, R.color.text_light_gray)
//                }
//                if (passwordEditTextLeng && verificationEditTextLeng) {
//                    setLoginBtnEnableAndBg(true, verification_button)
//                }
//            } else {
//                phoneEditTextLeng = false
//                setVerificationCodeBtnEnableAndBg(false, R.color.text_light_gray)
//                setLoginBtnEnableAndBg(false, verification_button_disable)
//            }
        })
    }


    override fun finish() {
        super.finish()
        this.overridePendingTransition(0, R.anim.activity_close)
    }
}