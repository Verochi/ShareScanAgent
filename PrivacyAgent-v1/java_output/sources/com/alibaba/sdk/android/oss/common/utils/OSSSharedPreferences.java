package com.alibaba.sdk.android.oss.common.utils;

/* loaded from: classes.dex */
public class OSSSharedPreferences {
    private static com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences sInstance;
    private android.content.SharedPreferences mSp;

    private OSSSharedPreferences(android.content.Context context) {
        this.mSp = context.getSharedPreferences("oss_android_sdk_sp", 0);
    }

    public static com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences instance(android.content.Context context) {
        if (sInstance == null) {
            synchronized (com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences.class) {
                if (sInstance == null) {
                    sInstance = new com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences(context);
                }
            }
        }
        return sInstance;
    }

    public boolean contains(java.lang.String str) {
        return this.mSp.contains(str);
    }

    public java.lang.String getStringValue(java.lang.String str) {
        return this.mSp.getString(str, "");
    }

    public void removeKey(java.lang.String str) {
        android.content.SharedPreferences.Editor edit = this.mSp.edit();
        edit.remove(str);
        edit.commit();
    }

    public void setStringValue(java.lang.String str, java.lang.String str2) {
        android.content.SharedPreferences.Editor edit = this.mSp.edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
