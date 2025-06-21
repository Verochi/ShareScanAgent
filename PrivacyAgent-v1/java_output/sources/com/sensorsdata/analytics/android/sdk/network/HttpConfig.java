package com.sensorsdata.analytics.android.sdk.network;

/* loaded from: classes19.dex */
public class HttpConfig implements java.io.Serializable {
    private static final java.lang.String TAG = "SA." + com.sensorsdata.analytics.android.sdk.network.HttpConfig.class.getSimpleName();
    private int connectionTimeout = 30000;
    private int readTimeout = 30000;

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public void setConnectionTimeout(int i) {
        if (i >= 1000) {
            this.connectionTimeout = i;
        } else {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "connectionTimeout minimum value is 1000ms");
            this.connectionTimeout = 1000;
        }
    }

    public void setReadTimeout(int i) {
        if (i >= 1000) {
            this.readTimeout = i;
        } else {
            com.sensorsdata.analytics.android.sdk.SALog.i(TAG, "readTimeout minimum value is 1000ms");
            this.readTimeout = 1000;
        }
    }
}
