package com.sensorsdata.analytics.android.sdk.visual.utils;

/* loaded from: classes19.dex */
public class FlutterUtils {
    private static final java.lang.String FLUTTER_ACTION = "android.intent.action.FLUTTER_VISUALIZED";
    private static final java.lang.String FLUTTER_EXTRA = "visualizedChanged";

    private static void sendFlutterBroadcast(java.lang.String str) {
        android.content.Context context = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance().getSAContextManager().getContext();
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(FLUTTER_ACTION);
        intent.putExtra(FLUTTER_EXTRA, str);
        context.sendBroadcast(intent);
    }

    public static void visualizedConnectionStatusChanged() {
        sendFlutterBroadcast("visualizedConnectionStatusChanged");
    }

    public static void visualizedPropertiesConfigChanged() {
        sendFlutterBroadcast("visualizedPropertiesConfigChanged");
    }
}
