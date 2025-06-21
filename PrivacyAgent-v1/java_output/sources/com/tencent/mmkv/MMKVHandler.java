package com.tencent.mmkv;

/* loaded from: classes19.dex */
public interface MMKVHandler {
    void mmkvLog(com.tencent.mmkv.MMKVLogLevel mMKVLogLevel, java.lang.String str, int i, java.lang.String str2, java.lang.String str3);

    com.tencent.mmkv.MMKVRecoverStrategic onMMKVCRCCheckFail(java.lang.String str);

    com.tencent.mmkv.MMKVRecoverStrategic onMMKVFileLengthError(java.lang.String str);

    boolean wantLogRedirecting();
}
