package com.model.basemodel.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.wifi.WifiInfo
import android.net.wifi.WifiManager
import android.os.Build
import android.os.PowerManager
import android.provider.Settings

import java.io.File
import java.net.NetworkInterface
import java.util.Collections

/**
 * <pre>
 * author: Blankj
 * blog  : http://blankj.com
 * time  : 2016/8/1
 * desc  : 设备相关工具类
</pre> *
 */
class DeviceUtils private constructor() {

    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {

        /**
         * 判断设备是否root

         * @return the boolean`true`: 是<br></br>`false`: 否
         */
        val isDeviceRooted: Boolean
            get() {
                val su = "su"
                val locations = arrayOf("/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/")
                for (location in locations) {
                    if (File(location + su).exists()) {
                        return true
                    }
                }
                return false
            }

        /**
         * 获取设备系统版本号

         * @return 设备系统版本号
         */
        val sdkVersion: Int
            get() = Build.VERSION.SDK_INT


        /**
         * 获取设备AndroidID

         * @return AndroidID
         */
        val androidID: String
            @SuppressLint("HardwareIds")
            get() = Settings.Secure.getString(Utils.getContext().contentResolver, Settings.Secure.ANDROID_ID)

        /**
         * 获取设备MAC地址
         *
         * 需添加权限 `<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>`
         *
         * 需添加权限 `<uses-permission android:name="android.permission.INTERNET"/>`

         * @return MAC地址
         */
        val macAddress: String
            get() {
                var macAddress = macAddressByWifiInfo
                if ("02:00:00:00:00:00" != macAddress) {
                    return macAddress
                }
                macAddress = macAddressByNetworkInterface
                if ("02:00:00:00:00:00" != macAddress) {
                    return macAddress
                }
                macAddress = macAddressByFile
                if ("02:00:00:00:00:00" != macAddress) {
                    return macAddress
                }
                return "please open wifi"
            }

        /**
         * 获取设备MAC地址
         *
         * 需添加权限 `<uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>`

         * @return MAC地址
         */
        private val macAddressByWifiInfo: String
            @SuppressLint("HardwareIds")
            get() {
                try {
                    @SuppressLint("WifiManagerLeak")
                    val wifi = Utils.getContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
                    if (wifi != null) {
                        val info = wifi.connectionInfo
                        if (info != null) return info.macAddress
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                return "02:00:00:00:00:00"
            }

        /**
         * 获取设备MAC地址
         *
         * 需添加权限 `<uses-permission android:name="android.permission.INTERNET"/>`

         * @return MAC地址
         */
        private val macAddressByNetworkInterface: String
            get() {
                try {
                    val nis = Collections.list(NetworkInterface.getNetworkInterfaces())
                    for (ni in nis) {
                        if (!ni.name.equals("wlan0", ignoreCase = true)) continue
                        val macBytes = ni.hardwareAddress
                        if (macBytes != null && macBytes.size > 0) {
                            val res1 = StringBuilder()
                            for (b in macBytes) {
                                res1.append(String.format("%02x:", b))
                            }
                            return res1.deleteCharAt(res1.length - 1).toString()
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                return "02:00:00:00:00:00"
            }

        /**
         * 获取设备MAC地址

         * @return MAC地址
         */
        private val macAddressByFile: String
            get() {
                var result: ShellUtils.CommandResult = ShellUtils.execCmd("getprop wifi.interface", false)
                if (result.result == 0) {
                    val name = result.successMsg
                    if (name != null) {
                        result = ShellUtils.execCmd("cat /sys/class/net/$name/address", false)
                        if (result.result == 0) {
                            if (result.successMsg != null) {
                                return result.successMsg
                            }
                        }
                    }
                }
                return "02:00:00:00:00:00"
            }

        /**
         * 获取设备厂商
         *
         * 如Xiaomi

         * @return 设备厂商
         */

        val manufacturer: String
            get() = Build.MANUFACTURER

        /**
         * 获取设备型号
         *
         * 如MI2SC

         * @return 设备型号
         */
        val model: String
            get() {
                var model: String? = Build.MODEL
                if (model != null) {
                    model = model.trim { it <= ' ' }.replace("\\s*".toRegex(), "")
                } else {
                    model = ""
                }
                return model
            }

        /**
         * 关机
         *
         * 需要root权限或者系统权限 `<android:sharedUserId="android.uid.system"/>`
         */
        fun shutdown() {
            ShellUtils.execCmd("reboot -p", true)
            val intent = Intent("android.intent.action.ACTION_REQUEST_SHUTDOWN")
            intent.putExtra("android.intent.extra.KEY_CONFIRM", false)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            Utils.getContext().startActivity(intent)
        }

        /**
         * 重启
         *
         * 需要root权限或者系统权限 `<android:sharedUserId="android.uid.system"/>`

         */
        fun reboot() {
            ShellUtils.execCmd("reboot", true)
            val intent = Intent(Intent.ACTION_REBOOT)
            intent.putExtra("nowait", 1)
            intent.putExtra("interval", 1)
            intent.putExtra("window", 0)
            Utils.getContext().sendBroadcast(intent)
        }

        /**
         * 重启
         *
         * 需系统权限 `<android:sharedUserId="android.uid.system"/>`

         * @param reason  传递给内核来请求特殊的引导模式，如"recovery"
         */
        fun reboot(reason: String) {
            val mPowerManager = Utils.getContext().getSystemService(Context.POWER_SERVICE) as PowerManager
            try {
                mPowerManager.reboot(reason)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        /**
         * 重启到recovery
         *
         * 需要root权限
         */
        fun reboot2Recovery() {
            ShellUtils.execCmd("reboot recovery", true)
        }

        /**
         * 重启到bootloader
         *
         * 需要root权限
         */
        fun reboot2Bootloader() {
            ShellUtils.execCmd("reboot bootloader", true)
        }
    }
}
