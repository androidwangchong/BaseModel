package com.model.basemodel

import android.app.FragmentTransaction
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.model.basemodel.ui.activity.credit.CreditFragment
import com.model.basemodel.ui.activity.creditService.CreditServiceFragment
import com.model.basemodel.ui.activity.mine.MineFragment
import org.jetbrains.anko.find

/**
 * 主Activity
 */
class MainActivity : AppCompatActivity(), RadioGroup.OnCheckedChangeListener {


    lateinit var rd_group: RadioGroup
    lateinit var fl_container: FrameLayout
    lateinit var rd_menu_credit: RadioButton
    lateinit var rd_menu_service: RadioButton
    lateinit var rd_menu_mine: RadioButton
    var creditFragment: CreditFragment? = null
    var serviceFragment: CreditServiceFragment? = null
    var mineFragment: MineFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rd_group = find(R.id.rd_group)
        fl_container = find(R.id.fl_container)
        rd_menu_credit = find(R.id.rd_menu_credit)
        rd_menu_service = find(R.id.rd_menu_service)
        rd_menu_mine = find(R.id.rd_menu_mine)
        rd_group.setOnCheckedChangeListener(this)
        rd_menu_credit.isChecked = true
    }

    fun hideAllFragment(transaction: FragmentTransaction) {
        if (creditFragment != null) {
            transaction.hide(creditFragment)
        }
        if (serviceFragment != null) {
            transaction.hide(serviceFragment)
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val transaction: FragmentTransaction = getFragmentManager().beginTransaction()
        hideAllFragment(transaction)//隐藏所有Fragment
        when (checkedId) {
            R.id.rd_menu_credit -> {//选择信用模块
                if (creditFragment == null) {
                    creditFragment = CreditFragment()
                    transaction.add(R.id.fl_container, creditFragment)
                } else {
                    transaction.show(creditFragment)
                }
            }
            R.id.rd_menu_service -> {//选择服务模块
                if (serviceFragment == null) {
                    serviceFragment = CreditServiceFragment()
                    transaction.add(R.id.fl_container, serviceFragment)
                } else {
                    transaction.show(serviceFragment)
                }
            }
            R.id.rd_menu_mine -> {//选择我的模块
                if (mineFragment == null) {
                    mineFragment = MineFragment()
                    transaction.add(R.id.fl_container, mineFragment)
                } else {
                    transaction.show(mineFragment)
                }
            }
        }
        transaction.commit()
    }
}