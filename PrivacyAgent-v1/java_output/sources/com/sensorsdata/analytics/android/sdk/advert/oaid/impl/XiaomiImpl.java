package com.sensorsdata.analytics.android.sdk.advert.oaid.impl;

/* loaded from: classes19.dex */
public class XiaomiImpl implements com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID {
    private static final java.lang.String TAG = "SA.OAIDFactory";
    private final android.content.Context mContext;
    private java.lang.Class<?> mIdProviderClass;
    private java.lang.Object mIdProviderImpl;

    @android.annotation.SuppressLint({"PrivateApi"})
    public XiaomiImpl(android.content.Context context) {
        this.mContext = context;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            this.mIdProviderClass = cls;
            this.mIdProviderImpl = cls.newInstance();
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
        }
    }

    private java.lang.String getOAID() throws java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        return (java.lang.String) this.mIdProviderClass.getMethod("getOAID", android.content.Context.class).invoke(this.mIdProviderImpl, this.mContext);
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public java.lang.String getRomOAID() {
        if (this.mIdProviderClass == null || this.mIdProviderImpl == null) {
            return null;
        }
        try {
            return getOAID();
        } catch (java.lang.Throwable th) {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, th);
            return null;
        }
    }

    @Override // com.sensorsdata.analytics.android.sdk.advert.oaid.IRomOAID
    public boolean isSupported() {
        return this.mIdProviderImpl != null;
    }
}
