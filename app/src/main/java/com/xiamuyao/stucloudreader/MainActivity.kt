package com.xiamuyao.stucloudreader

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.xiamuyao.stucloudreader.Util.CommonUtils
import com.xiamuyao.stucloudreader.Util.View.StatusBarUtil

import com.xiamuyao.stucloudreader.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        //初始化状态栏
        initStatusView()
        //如果不是kotlin其实这里需要初始化id
//        initid()
        StatusBarUtil.setColorNoTranslucentForDrawerLayout(activity = this@MainActivity, drawerLayout = drawer_layout,
                color = CommonUtils.getColor(R.color.colorTheme))

    }

    /**
     * 状态栏修改--沉浸式
     */
    fun initStatusView(): Unit {
        val layoutParams = view_status.layoutParams
        layoutParams.height = StatusBarUtil.getStatusBarHeight(this)
        view_status.layoutParams = layoutParams;
    }

//    fun initRxBus(): Unit {
//        val subscribe = com.xiamuyao.stucloudreader.http.rx.RxBus.get().toObservable(RxCodeConstants.JUMP_TYPE_TO_ONE, RxBusBaseMessage::class.java)
//                .subscribe({ integer -> mBinding.include.vpContent.currentItem = 0 })
//        addSubscription(subscribe)
//    }

}
