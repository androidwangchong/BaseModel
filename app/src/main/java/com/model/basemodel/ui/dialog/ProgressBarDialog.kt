package com.model.basemodel.ui.dialog

import android.content.DialogInterface
import android.view.KeyEvent
import android.view.animation.LinearInterpolator
import com.github.florent37.viewanimator.ViewAnimator
import com.model.basemodel.R
import kotlinx.android.synthetic.main.dialog_progress_bar.*


/**
 * BaseModel
 * Created by wangchong on 2017/7/27.
 */
class ProgressBarDialog(private val content: String) : BaseDialog() {
    override val layoutResId: Int = R.layout.dialog_progress_bar
    var viewAnimator: ViewAnimator? = null
    override fun initView() {
        this.isCancelable = false
        dialog.setOnKeyListener(object : DialogInterface.OnKeyListener {
            override fun onKey(dialog: DialogInterface, keyCode: Int, event: KeyEvent): Boolean {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    return true
                }
                return false
            }
        })
        viewAnimator = ViewAnimator
                .animate(image_view)
                .rotation(360f * 2)
                .duration(1000 * 2)
                .interpolator(object : LinearInterpolator() {

                })
                .repeatCount(10000)
                .start()

        title_text.text = content
    }

    override fun initData() {
    }

    override fun onDestroy() {
        viewAnimator?.cancel()
        super.onDestroy()
    }


}