package com.fly.ayudaconfiable.utils

import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import com.fly.ayudaconfiable.MyApplication
import com.fly.ayudaconfiable.bean.InstallationInfo

object InstallationUtil {
    fun getInstallationInfos() :ArrayList<InstallationInfo>{
        var installationInfos = ArrayList<InstallationInfo>()
        val allApps: List<PackageInfo> =
            MyApplication.application.packageManager.getInstalledPackages(PackageManager.GET_ACTIVITIES and PackageManager.GET_SERVICES)
        for (appInfo in allApps){
            var installationInfoBean = InstallationInfo()
            installationInfoBean.appName = appInfo.applicationInfo.loadLabel(MyApplication.application.packageManager).toString()
            installationInfoBean.version = appInfo.versionName
            installationInfoBean.packageName = appInfo.packageName
            installationInfoBean.installationTime =
                DateTool.getTimeFromLong(DateTool.FMT_DATE_TIME1,appInfo.firstInstallTime).toString()
            installationInfoBean.lastUpdateTime =
                DateTool.getTimeFromLong(DateTool.FMT_DATE_TIME,appInfo.lastUpdateTime).toString()
            installationInfoBean.is_system = if ((appInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM) == 0){
                "0"
            }else{
                "1"
            }
            installationInfos.add(installationInfoBean)
        }
        return installationInfos
    }
}