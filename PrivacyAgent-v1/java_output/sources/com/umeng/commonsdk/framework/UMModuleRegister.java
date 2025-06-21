package com.umeng.commonsdk.framework;

/* loaded from: classes19.dex */
public class UMModuleRegister {
    public static final java.lang.String ANALYTICS = "analytics";
    public static final java.lang.String APPSTATUS = "appstatus";
    private static final int APPSTATUS_SWITCH_HIGH = 37136;
    private static final int APPSTATUS_SWITCH_LOW = 37121;
    public static final java.lang.String INNER = "internal";
    private static final int INNER_EVENT_VALUE_HIGH = 36864;
    private static final int INNER_EVENT_VALUE_LOW = 32769;
    public static final java.lang.String PROCESS = "process";
    private static final int PROCESS_EVENT_VALUE_HIGH = 37120;
    private static final int PROCESS_EVENT_VALUE_LOW = 36945;
    public static final java.lang.String PUSH = "push";
    private static final int PUSH_EVENT_VALUE_HIGH = 20480;
    private static final int PUSH_EVENT_VALUE_LOW = 16385;
    public static final java.lang.String SHARE = "share";
    private static final int SHARE_EVENT_VALUE_HIGH = 28672;
    private static final int SHARE_EVENT_VALUE_LOW = 24577;
    private static android.content.Context mModuleAppContext;
    private static java.util.HashMap<java.lang.String, com.umeng.commonsdk.framework.UMLogDataProtocol> mModuleMap;

    public static java.lang.String eventType2ModuleName(int i) {
        java.lang.String str = (i < PUSH_EVENT_VALUE_LOW || i > 20480) ? "analytics" : "push";
        if (i >= SHARE_EVENT_VALUE_LOW && i <= SHARE_EVENT_VALUE_HIGH) {
            str = "share";
        }
        if (i >= 32769 && i <= INNER_EVENT_VALUE_HIGH) {
            str = INNER;
        }
        if (i >= 36945 && i <= PROCESS_EVENT_VALUE_HIGH) {
            str = "process";
        }
        return (i < APPSTATUS_SWITCH_LOW || i > APPSTATUS_SWITCH_HIGH) ? str : APPSTATUS;
    }

    public static android.content.Context getAppContext() {
        return mModuleAppContext;
    }

    public static com.umeng.commonsdk.framework.UMLogDataProtocol getCallbackFromModuleName(java.lang.String str) {
        if (mModuleMap.containsKey(str)) {
            return mModuleMap.get(str);
        }
        return null;
    }

    public static void registerAppContext(android.content.Context context) {
        if (mModuleAppContext == null) {
            mModuleAppContext = context.getApplicationContext();
        }
    }

    public static boolean registerCallback(int i, com.umeng.commonsdk.framework.UMLogDataProtocol uMLogDataProtocol) {
        if (mModuleMap == null) {
            mModuleMap = new java.util.HashMap<>();
        }
        java.lang.String eventType2ModuleName = eventType2ModuleName(i);
        if (mModuleMap.containsKey(eventType2ModuleName)) {
            return true;
        }
        mModuleMap.put(eventType2ModuleName, uMLogDataProtocol);
        return true;
    }
}
