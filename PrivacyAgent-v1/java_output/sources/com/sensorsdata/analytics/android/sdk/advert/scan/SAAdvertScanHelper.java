package com.sensorsdata.analytics.android.sdk.advert.scan;

/* loaded from: classes19.dex */
public class SAAdvertScanHelper {
    public static boolean scanHandler(android.app.Activity activity, android.net.Uri uri) {
        java.lang.String host = uri.getHost();
        com.sensorsdata.analytics.android.sdk.advert.scan.IAdvertScanListener channelDebugScanHelper = "channeldebug".equals(host) ? new com.sensorsdata.analytics.android.sdk.advert.scan.ChannelDebugScanHelper() : "adsScanDeviceInfo".equals(host) ? new com.sensorsdata.analytics.android.sdk.advert.scan.WhiteListScanHelper() : null;
        if (channelDebugScanHelper == null) {
            return false;
        }
        channelDebugScanHelper.handlerScanUri(activity, uri);
        return true;
    }
}
