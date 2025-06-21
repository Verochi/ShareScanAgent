package com.tencent.mm.opensdk.modelmsg;

/* loaded from: classes19.dex */
public final class WXAppLaunchData {
    public static final java.lang.String ACTION_HANDLE_WXAPPLAUNCH = ".ACTION_HANDLE_WXAPPLAUNCH";
    public static final java.lang.String ACTION_HANDLE_WXAPP_RESULT = ".ACTION_HANDLE_WXAPP_RESULT";
    public static final java.lang.String ACTION_HANDLE_WXAPP_SHOW = ".ACTION_HANDLE_WXAPP_SHOW";
    public int launchType;
    public java.lang.String message;

    public static class Builder {
        public static com.tencent.mm.opensdk.modelmsg.WXAppLaunchData fromBundle(android.os.Bundle bundle) {
            com.tencent.mm.opensdk.modelmsg.WXAppLaunchData wXAppLaunchData = new com.tencent.mm.opensdk.modelmsg.WXAppLaunchData();
            wXAppLaunchData.launchType = bundle.getInt("_wxapplaunchdata_launchType");
            wXAppLaunchData.message = bundle.getString("_wxapplaunchdata_message");
            return wXAppLaunchData;
        }

        public static android.os.Bundle toBundle(com.tencent.mm.opensdk.modelmsg.WXAppLaunchData wXAppLaunchData) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("_wxapplaunchdata_launchType", wXAppLaunchData.launchType);
            bundle.putString("_wxapplaunchdata_message", wXAppLaunchData.message);
            return bundle;
        }
    }
}
