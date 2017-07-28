package com.model.basemodel.ui.widget

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.model.basemodel.R
import org.jetbrains.anko.imageResource
import android.R.string.cancel
import android.R.attr.rotation
import com.github.florent37.viewanimator.ViewAnimator


class Toaster {


    companion object {
        internal var mToast: Toast? = null

        val FORBID = 0
        val PROMPT = 1
        val SUCCESSFUL = 2

        fun imageText(context: Context, imageIdex: Int, subtitle_text: String, title_text: String = "") {
            val v = LayoutInflater.from(context).inflate(R.layout.eplay_toast, null)
            val title = v.findViewById(R.id.title_text) as TextView
            val subtitleTitle = v.findViewById(R.id.subtitle_text) as TextView
            val image_view = v.findViewById(R.id.image_view) as ImageView
            subtitleTitle.text = subtitle_text
            if (TextUtils.isEmpty(title_text)) {
                title.visibility = View.GONE
            } else {
                title.visibility = View.VISIBLE
                title.text = title_text
            }
            when (imageIdex) {
                FORBID -> {
                    //禁止
                    image_view.imageResource = R.mipmap.icon_minus_alt
                }
                PROMPT -> {
                    //感叹号提示
                    image_view.imageResource = R.mipmap.icon_info
                }
                SUCCESSFUL -> {
                    //成功
                    image_view.imageResource = R.mipmap.icon_check_alt
                }

            }
            if (mToast == null) {
                mToast = Toast(context)
            } else {
                mToast?.duration = Toast.LENGTH_LONG
            }
            mToast?.setGravity(Gravity.CENTER, 0, 0)
            mToast?.duration = Toast.LENGTH_LONG
            mToast?.view = v
            if (mToast != null) {
                mToast?.show()
            }

        }

        internal var topToast: Toast? = null

        fun showTop(context: Context, imageIdex: Int, title_text: String) {
            val v = LayoutInflater.from(context).inflate(R.layout.base_toast, null)
            val title = v.findViewById(R.id.title_text) as TextView
            title.text = title_text
            if (topToast == null) {
                topToast = Toast(context)
            } else {
                topToast?.duration = Toast.LENGTH_LONG
            }
            topToast?.setGravity(Gravity.TOP, 0, 0)
            topToast?.duration = Toast.LENGTH_LONG
            topToast?.view = v
            if (topToast != null) {
                topToast?.show()
            }
        }

        internal var toast: Toast? = null

        fun showCenter(paramContext: Context, text: String) {
            if (toast == null) {
                toast = Toast.makeText(paramContext, text, Toast.LENGTH_LONG)
            } else {
                toast?.setText(text)
                toast?.duration = Toast.LENGTH_LONG
            }
            toast?.setGravity(Gravity.CENTER, 0, 0)
            toast?.show()
        }

        private fun show(paramContext: Context,
                         paramCharSequence: CharSequence, paramInt: Int) {
            Toast.makeText(paramContext, paramCharSequence, paramInt).show()
        }

        fun showShort(paramContext: Context, paramInt: Int) {
            show(paramContext, paramContext.getString(paramInt), Toast.LENGTH_SHORT)
        }

        fun showShort(paramContext: Context, paramString: String) {
            show(paramContext, paramString, Toast.LENGTH_SHORT)
        }

        fun showLong(paramContext: Context, paramInt: Int) {
            show(paramContext, paramContext.getString(paramInt), Toast.LENGTH_LONG)
        }

        fun showLong(paramContext: Context, paramString: String) {
            show(paramContext, paramString, Toast.LENGTH_LONG)
        }

        fun showTaostOnUiThread(activity: Activity,
                                s: Any) {
            activity.runOnUiThread {
                // TODO Auto-generated method stub
                show(activity, s.toString(), Toast.LENGTH_SHORT)
            }
        }
    }

}
