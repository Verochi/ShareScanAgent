package com.umeng.umcrash;

/* loaded from: classes19.dex */
public interface IUMCrashCallbackWithType {

    public enum CrashType {
        CRASH_TYPE_NATIVE(1),
        CRASH_TYPE_JAVA(2),
        CRASH_TYPE_ANR(3),
        CRASH_TYPE_BLOCK(4),
        CRASH_TYPE_CUSTOM_LOG(5);

        int mType;

        CrashType(int i) {
            this.mType = i;
        }

        public int getType() {
            return this.mType;
        }
    }

    java.lang.String onCallback(com.umeng.umcrash.IUMCrashCallbackWithType.CrashType crashType);
}
