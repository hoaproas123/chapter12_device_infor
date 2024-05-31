package com.example.platform1

import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import android.os.Build
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity()
{
    private val CHANNEL = "platformchannel.companyname.com/deviceinfo"
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler { call, result ->
            if (call.method == "getCaoThuBongRo") {
                val deviceInfo = getDeviceInfo()
                result.success(deviceInfo)
            } else {
                result.notImplemented()
            }
        }
    }
    private fun getDeviceInfo(): String {
        return ("\nDevice: " + Build.DEVICE
                + "\nManufacturer: " + Build.MANUFACTURER
                + "\nModel: " + Build.MODEL
                + "\nProduct: " + Build.PRODUCT
                + "\nVersion Release: " + Build.VERSION.RELEASE
                + "\nVersion SDK: " + Build.VERSION.SDK_INT
                + "\nFingerprint : " + Build.FINGERPRINT)
    }
    private fun getCaygaybongchay(): String{
        return ("Lấy cây gậy bóng chày")
    }
}
