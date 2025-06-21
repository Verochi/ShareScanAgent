package com.sensorsdata.analytics.android.sdk.util;

/* loaded from: classes19.dex */
public class SnapCache {
    private static volatile com.sensorsdata.analytics.android.sdk.util.SnapCache mSnapCache;

    @android.annotation.SuppressLint({"NewApi"})
    private final android.util.LruCache<java.lang.String, com.sensorsdata.analytics.android.sdk.util.SnapCache.ViewTempInfo> mLruViewInfo = new android.util.LruCache<>(64);

    @android.annotation.SuppressLint({"NewApi"})
    private final android.util.LruCache<java.lang.String, java.lang.String> mLruCanonicalName = new android.util.LruCache<>(64);

    public static class ViewTempInfo {
        public java.lang.String selectPath;
        public java.lang.String viewType;
    }

    private SnapCache() {
    }

    public static com.sensorsdata.analytics.android.sdk.util.SnapCache getInstance() {
        if (mSnapCache == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.util.SnapCache.class) {
                if (mSnapCache == null) {
                    mSnapCache = new com.sensorsdata.analytics.android.sdk.util.SnapCache();
                }
            }
        }
        return mSnapCache;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public java.lang.String getCanonicalName(java.lang.Class<?> cls) {
        if (cls == null) {
            return null;
        }
        java.lang.String str = this.mLruCanonicalName.get(cls.hashCode() + "");
        if (str == null) {
            str = cls.getCanonicalName();
            if (android.text.TextUtils.isEmpty(str)) {
                str = "Anonymous";
            }
            this.mLruCanonicalName.put(cls.hashCode() + "", str);
        }
        return str;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public java.lang.String getSelectPath(android.view.View view) {
        if (view == null) {
            return null;
        }
        com.sensorsdata.analytics.android.sdk.util.SnapCache.ViewTempInfo viewTempInfo = this.mLruViewInfo.get(view.hashCode() + "");
        if (viewTempInfo != null) {
            return viewTempInfo.selectPath;
        }
        return null;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public java.lang.String getViewId(android.view.View view) {
        return null;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public java.lang.String getViewText(android.view.View view) {
        return null;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public java.lang.String getViewType(android.view.View view) {
        if (view == null) {
            return null;
        }
        com.sensorsdata.analytics.android.sdk.util.SnapCache.ViewTempInfo viewTempInfo = this.mLruViewInfo.get(view.hashCode() + "");
        if (viewTempInfo != null) {
            return viewTempInfo.viewType;
        }
        return null;
    }

    @android.annotation.SuppressLint({"NewApi"})
    public void setSelectPath(android.view.View view, java.lang.String str) {
        if (view == null || str == null || str.equals("")) {
            return;
        }
        java.lang.String str2 = view.hashCode() + "";
        com.sensorsdata.analytics.android.sdk.util.SnapCache.ViewTempInfo viewTempInfo = this.mLruViewInfo.get(str2);
        if (viewTempInfo == null) {
            viewTempInfo = new com.sensorsdata.analytics.android.sdk.util.SnapCache.ViewTempInfo();
        }
        viewTempInfo.selectPath = str;
        this.mLruViewInfo.put(str2, viewTempInfo);
    }

    @android.annotation.SuppressLint({"NewApi"})
    public void setViewId(android.view.View view, java.lang.String str) {
    }

    @android.annotation.SuppressLint({"NewApi"})
    public void setViewText(android.view.View view, java.lang.String str) {
    }

    @android.annotation.SuppressLint({"NewApi"})
    public void setViewType(android.view.View view, java.lang.String str) {
        if (view == null || str == null) {
            return;
        }
        java.lang.String str2 = view.hashCode() + "";
        com.sensorsdata.analytics.android.sdk.util.SnapCache.ViewTempInfo viewTempInfo = this.mLruViewInfo.get(str2);
        if (viewTempInfo == null) {
            viewTempInfo = new com.sensorsdata.analytics.android.sdk.util.SnapCache.ViewTempInfo();
        }
        viewTempInfo.viewType = str;
        this.mLruViewInfo.put(str2, viewTempInfo);
    }
}
