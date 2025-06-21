package com.huawei.hms.hatool;

/* loaded from: classes22.dex */
public class b1 extends com.huawei.hms.hatool.f {
    public static java.lang.String c() {
        java.lang.String str;
        java.lang.String str2 = "";
        try {
            java.lang.String str3 = (java.lang.String) java.lang.Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            try {
                com.huawei.hms.hatool.y.c("hmsSdk", "getUDID success");
                return str3;
            } catch (android.util.AndroidRuntimeException unused) {
                str2 = str3;
                str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                return str2;
            } catch (java.lang.ClassNotFoundException unused2) {
                str2 = str3;
                str = "getUDID method invoke failed";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                return str2;
            } catch (java.lang.IllegalAccessException unused3) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal AccessException";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                return str2;
            } catch (java.lang.IllegalArgumentException unused4) {
                str2 = str3;
                str = "getUDID method invoke failed : Illegal ArgumentException";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                return str2;
            } catch (java.lang.NoSuchMethodException unused5) {
                str2 = str3;
                str = "getUDID method invoke failed : NoSuchMethodException";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                return str2;
            } catch (java.lang.reflect.InvocationTargetException unused6) {
                str2 = str3;
                str = "getUDID method invoke failed : InvocationTargetException";
                com.huawei.hms.hatool.y.f("hmsSdk", str);
                return str2;
            }
        } catch (android.util.AndroidRuntimeException unused7) {
        } catch (java.lang.ClassNotFoundException unused8) {
        } catch (java.lang.IllegalAccessException unused9) {
        } catch (java.lang.IllegalArgumentException unused10) {
        } catch (java.lang.NoSuchMethodException unused11) {
        } catch (java.lang.reflect.InvocationTargetException unused12) {
        }
    }

    public static android.util.Pair<java.lang.String, java.lang.String> e(android.content.Context context) {
        if (com.huawei.hms.hatool.q0.a(context, com.anythink.china.common.d.a)) {
            com.huawei.hms.hatool.y.f("hmsSdk", "getMccAndMnc() Pair value is empty");
            return new android.util.Pair<>("", "");
        }
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService(com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager != null && telephonyManager.getSimState() == 5) {
            java.lang.String networkOperator = telephonyManager.getNetworkOperator();
            return (android.text.TextUtils.isEmpty(networkOperator) || android.text.TextUtils.equals(networkOperator, com.igexin.push.core.b.m)) ? new android.util.Pair<>("", "") : networkOperator.length() > 3 ? new android.util.Pair<>(networkOperator.substring(0, 3), networkOperator.substring(3)) : new android.util.Pair<>("", "");
        }
        return new android.util.Pair<>("", "");
    }
}
