package com.model.basemodel.ui.activity.base

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.WindowManager
import android.widget.TextView
import com.jaeger.library.StatusBarUtil
import com.model.basemodel.R
import com.model.basemodel.ui.dialog.ProgressBarDialog
import de.greenrobot.event.EventBus
import org.jetbrains.anko.AnkoLogger

/**
 * BaseModel
 * Created by wangchong on 2017/7/13.
 */
abstract class BaseActivity : IBase, AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        val toolbar = findViewById(R.id.toolbar) as? Toolbar
        toolbar?.setNavigationOnClickListener {
            onBack()
        }
        val toolbar_title = findViewById(R.id.toolbar_title) as? TextView
        toolbar_title?.text = title

        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        StatusBarUtil.setColor(this@BaseActivity, ContextCompat.getColor(this@BaseActivity, R.color.colorPrimary))
        getIntentMessageData()
        initView()
        initData()
    }

    open fun onBack() {
        finish()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    abstract val title: String
    abstract val layoutResId: Int
    abstract fun getIntentMessageData()
    abstract override fun initView()
    abstract override fun initData()

    open fun onEvent(event: Any) {

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }


    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }

    override fun getResources(): Resources {
        val resources = super.getResources()
        val configuration = Configuration()
        configuration.setToDefaults()
        resources.updateConfiguration(configuration,
                resources.displayMetrics)
        return resources
    }

    var progress_bar_dialog: ProgressBarDialog? = null

    fun showProgressBarDialog(text: String) {
        progress_bar_dialog = ProgressBarDialog(text)
        progress_bar_dialog?.show(fragmentManager, "progress_bar_dialog")
    }

    fun hideProgressBarDialog() {
        progress_bar_dialog?.dismiss()
    }


}
