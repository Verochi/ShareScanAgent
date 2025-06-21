package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class c {
    public static byte[] a(android.os.Bundle bundle, java.lang.String str) {
        try {
            byte[] byteArray = bundle.getByteArray(str);
            return byteArray == null ? new byte[0] : byteArray;
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.i("BundleUtil", "getByteArray exception" + e.getMessage());
            return new byte[0];
        }
    }

    public static java.lang.String b(android.os.Bundle bundle, java.lang.String str) {
        try {
            return bundle.getString(str);
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.i("BundleUtil", "getString exception" + e.getMessage());
            return null;
        }
    }

    public static java.lang.String c(android.os.Bundle bundle, java.lang.String str) {
        try {
            java.lang.String string = bundle.getString(str);
            return string == null ? "" : string;
        } catch (java.lang.Exception e) {
            com.huawei.hms.support.log.HMSLog.i("BundleUtil", "getString exception" + e.getMessage());
            return "";
        }
    }
}
