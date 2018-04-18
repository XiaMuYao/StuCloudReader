package com.xiamuyao.stucloudreader.app

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.content.res.Resources
import android.support.multidex.MultiDexApplication

import com.example.http.HttpUtils
import com.squareup.leakcanary.LeakCanary
import com.xiamuyao.stucloudreader.Util.DebugUtil

@SuppressLint("Registered")
/**
 * Created by jingbin on 2016/11/22.
 */

class CloudReaderApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
        instance = this
        HttpUtils.getInstance().init(this, DebugUtil.DEBUG)

        initTextSize()
    }

    /**
     * 使其系统更改字体大小无效
     */
    private fun initTextSize() {
        val res = resources
        val config = Configuration()
        config.setToDefaults()
        res.updateConfiguration(config, res.displayMetrics)
    }

    companion object {

        var instance: CloudReaderApplication? = null
            private set
    }

}
