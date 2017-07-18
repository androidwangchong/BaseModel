package com.model.basemodel.util

import android.os.Environment
import android.os.StatFs
import java.io.File


/**
 * SD卡相关的辅助类
 *
 * 创建时间： 2017/7/18.
 * 作者：WangZhuang
 * 功能描述：
 */
object SDCardUtils {
    /**
     * 判断SDCard是否可用

     * @return
     */
    fun isSDCardEnable(): Boolean {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)

    }

    /**
     * 获取SD卡路径

     * @return
     */
    fun getSDCardPath(): String {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator
    }

    /**
     * 获取SD卡的剩余容量 单位byte

     * @return
     */
    fun getSDCardAllSize(): Long {
        if (isSDCardEnable()) {
            val stat = StatFs(getSDCardPath())
            // 获取空闲的数据块的数量
            val availableBlocks = stat.availableBlocks.toLong() - 4
            // 获取单个数据块的大小（byte）
            val freeBlocks = stat.availableBlocks.toLong()
            return freeBlocks * availableBlocks
        }
        return 0
    }

    /**
     * 获取指定路径所在空间的剩余可用容量字节数，单位byte

     * @param filePath
     * *
     * @return 容量字节 SDCard可用空间，内部存储可用空间
     */
    fun getFreeBytes(filePath: String): Long {
        var filePath = filePath
        // 如果是sd卡的下的路径，则获取sd卡可用容量
        if (filePath.startsWith(getSDCardPath())) {
            filePath = getSDCardPath()
        } else {// 如果是内部存储的路径，则获取内存存储的可用容量
            filePath = Environment.getDataDirectory().getAbsolutePath()
        }
        val stat = StatFs(filePath)
        val availableBlocks = stat.availableBlocks.toLong() - 4
        return stat.blockSize * availableBlocks
    }

    /**
     * 获取系统存储路径

     * @return
     */
    fun getRootDirectoryPath(): String {
        return Environment.getRootDirectory().getAbsolutePath()
    }
}