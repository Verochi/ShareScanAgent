package com.umeng.umcrash;

/* loaded from: classes19.dex */
public class UMCustomLogInfoBuilder {
    public static final java.lang.String LINE_SEP = "\n";
    public static final java.lang.String LOG_KEY_AC = "k_ac";
    public static final java.lang.String LOG_KEY_CT = "k_ct";
    private static final java.lang.String LOG_KEY_STACK_FUNC = "stackFunc";
    private static final java.lang.String LOG_KEY_STACK_HASH = "stackHash";
    public static final java.lang.String LOG_SECTION_SEP = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";
    public static final java.lang.String LOG_TYPE = "exception";
    private java.lang.String stack;
    private java.util.Map<java.lang.String, java.lang.String> kvInfoMap = new java.util.HashMap(20);
    private java.util.List<java.lang.String> sectionList = new java.util.ArrayList(5);
    private com.uc.crashsdk.export.CustomLogInfo mCustomLogInfo = new com.uc.crashsdk.export.CustomLogInfo(new java.lang.StringBuffer(), "exception");

    public UMCustomLogInfoBuilder(java.lang.String str) {
        this.kvInfoMap.put(LOG_KEY_CT, "exception");
        this.kvInfoMap.put(LOG_KEY_AC, str);
    }

    public com.umeng.umcrash.UMCustomLogInfoBuilder addLogCat(boolean z) {
        this.mCustomLogInfo.mAddLogcat = z;
        return this;
    }

    public com.umeng.umcrash.UMCustomLogInfoBuilder addSection(java.lang.String str) {
        this.sectionList.add(str);
        return this;
    }

    public com.uc.crashsdk.export.CustomLogInfo build() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : this.kvInfoMap.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            stringBuffer.append(entry.getValue());
            stringBuffer.append("\n");
        }
        if (!android.text.TextUtils.isEmpty(this.stack)) {
            stringBuffer.append(this.stack);
            stringBuffer.append("\n");
        }
        for (java.lang.String str : this.sectionList) {
            stringBuffer.append(LOG_SECTION_SEP);
            stringBuffer.append("\n");
            stringBuffer.append(str);
            stringBuffer.append("\n");
        }
        com.uc.crashsdk.export.CustomLogInfo customLogInfo = this.mCustomLogInfo;
        customLogInfo.mData = stringBuffer;
        return customLogInfo;
    }

    public com.umeng.umcrash.UMCustomLogInfoBuilder put(java.lang.String str, java.lang.String str2) {
        if (!LOG_KEY_AC.equals(str) && !LOG_KEY_CT.equals(str)) {
            this.kvInfoMap.put(str, str2);
        }
        return this;
    }

    public com.umeng.umcrash.UMCustomLogInfoBuilder stack(java.lang.String str, java.lang.String str2) {
        if (str2 == null) {
            str2 = "";
        }
        this.stack = "Exception message:" + str2 + "\nBack traces starts.\n" + str + "Back traces ends.";
        return this;
    }

    public com.umeng.umcrash.UMCustomLogInfoBuilder stack(java.lang.Throwable th, java.lang.String str) {
        return stack(android.util.Log.getStackTraceString(th), str);
    }

    public com.umeng.umcrash.UMCustomLogInfoBuilder stackFunc(java.lang.String str) {
        this.kvInfoMap.put(LOG_KEY_STACK_FUNC, str);
        return this;
    }

    public com.umeng.umcrash.UMCustomLogInfoBuilder stackHash(java.lang.String str) {
        this.kvInfoMap.put(LOG_KEY_STACK_HASH, str);
        return this;
    }

    public com.umeng.umcrash.UMCustomLogInfoBuilder uploadNow(boolean z) {
        this.mCustomLogInfo.mUploadNow = z;
        return this;
    }
}
