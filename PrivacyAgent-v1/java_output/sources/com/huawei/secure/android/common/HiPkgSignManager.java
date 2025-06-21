package com.huawei.secure.android.common;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public abstract class HiPkgSignManager {
    @java.lang.Deprecated
    public static boolean doCheckArchiveApk(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.doCheckArchiveApk(context, str, str2, str3);
    }

    @java.lang.Deprecated
    public static boolean doCheckInstalled(android.content.Context context, java.lang.String str, java.lang.String str2) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.doCheckInstalled(context, str, str2);
    }

    @java.lang.Deprecated
    public static byte[] getInstalledAPPSignature(android.content.Context context, java.lang.String str) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getInstalledAPPSignature(context, str);
    }

    @java.lang.Deprecated
    public static java.lang.String getInstalledAppHash(android.content.Context context, java.lang.String str) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getInstalledAppHash(context, str);
    }

    @java.lang.Deprecated
    public static byte[] getUnInstalledAPPSignature(android.content.Context context, java.lang.String str) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getUnInstalledAPPSignature(context, str);
    }

    @java.lang.Deprecated
    public static java.lang.String getUnInstalledAppHash(android.content.Context context, java.lang.String str) {
        return com.huawei.secure.android.common.sign.HiPkgSignManager.getUnInstalledAppHash(context, str);
    }
}
