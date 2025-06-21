package com.amap.api.location;

/* loaded from: classes12.dex */
public class AMapLocationQualityReport implements java.lang.Cloneable {
    public static final int GPS_STATUS_MODE_SAVING = 3;
    public static final int GPS_STATUS_NOGPSPERMISSION = 4;
    public static final int GPS_STATUS_NOGPSPROVIDER = 1;
    public static final int GPS_STATUS_OFF = 2;
    public static final int GPS_STATUS_OK = 0;
    private boolean b = false;
    private int c = 2;
    private int d = 0;
    private java.lang.String e = com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
    private long f = 0;
    private boolean g = false;
    com.amap.api.location.AMapLocationClientOption.AMapLocationMode a = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public com.amap.api.location.AMapLocationQualityReport m15clone() {
        com.amap.api.location.AMapLocationQualityReport aMapLocationQualityReport = new com.amap.api.location.AMapLocationQualityReport();
        try {
            super.clone();
        } catch (java.lang.Throwable unused) {
        }
        try {
            aMapLocationQualityReport.setGpsStatus(this.c);
            aMapLocationQualityReport.setGPSSatellites(this.d);
            aMapLocationQualityReport.setWifiAble(this.b);
            aMapLocationQualityReport.setNetUseTime(this.f);
            aMapLocationQualityReport.setNetworkType(this.e);
            aMapLocationQualityReport.setLocationMode(this.a);
            aMapLocationQualityReport.setInstallHighDangerMockApp(this.g);
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "AMapLocationQualityReport", "clone");
        }
        return aMapLocationQualityReport;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String getAdviseMessage() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        com.amap.api.location.AMapLocationClientOption.AMapLocationMode aMapLocationMode = this.a;
        if (aMapLocationMode != com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving) {
            int i = this.c;
            if (i != 0) {
                if (i == 1) {
                    str2 = "您的设备没有GPS模块或者GPS模块异常，无法进行GPS定位\n";
                } else if (i == 2) {
                    str2 = "您的设备关闭了GPS定位功能，开启GPS定位功能有助于提高定位的精确度\n";
                } else if (i == 3) {
                    str2 = "您的设备当前设置的定位模式不包含GPS定位，选择包含GPS模式的定位模式有助于提高定位的精确度\n";
                } else if (i == 4) {
                    str2 = "您的设置禁用了GPS定位权限，开启GPS定位权限有助于提高定位的精确度\n";
                }
                stringBuffer.append(str2);
            } else if (aMapLocationMode == com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors && this.d < 4) {
                str2 = "当前GPS信号弱，位置更新可能会延迟\n";
                stringBuffer.append(str2);
            }
        }
        if (this.a != com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            if (!"DISCONNECTED".equals(this.e)) {
                str = "2G".equals(this.e) ? "您的设备网络状态不太好，网络定位可能会有延迟\n" : "您的设备未连接到网络，无法进行网络定位\n";
                if (!this.b) {
                    stringBuffer.append("您的设备WIFI开关已关闭，打开WIFI开关有助于提高定位的成功率\n");
                }
            }
            stringBuffer.append(str);
            if (!this.b) {
            }
        }
        return stringBuffer.toString();
    }

    public int getGPSSatellites() {
        return this.d;
    }

    public int getGPSStatus() {
        return this.c;
    }

    public long getNetUseTime() {
        return this.f;
    }

    public java.lang.String getNetworkType() {
        return this.e;
    }

    public boolean isInstalledHighDangerMockApp() {
        return this.g;
    }

    public boolean isWifiAble() {
        return this.b;
    }

    public void setGPSSatellites(int i) {
        this.d = i;
    }

    public void setGpsStatus(int i) {
        this.c = i;
    }

    public void setInstallHighDangerMockApp(boolean z) {
        this.g = z;
    }

    public void setLocationMode(com.amap.api.location.AMapLocationClientOption.AMapLocationMode aMapLocationMode) {
        this.a = aMapLocationMode;
    }

    public void setNetUseTime(long j) {
        this.f = j;
    }

    public void setNetworkType(java.lang.String str) {
        this.e = str;
    }

    public void setWifiAble(boolean z) {
        this.b = z;
    }
}
