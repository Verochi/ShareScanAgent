package com.aliyun.player.nativeclass;

/* loaded from: classes.dex */
public class Options {
    private static final int FLAG_APPEND = 1;
    private static final int FLAG_REPLACE = 2;
    private java.util.Map<java.lang.String, java.lang.String> mOptions = new java.util.HashMap();

    public java.lang.String get(java.lang.String str) {
        return this.mOptions.get(str);
    }

    public void reset() {
        this.mOptions.clear();
    }

    public boolean set(java.lang.String str, java.lang.String str2, int i) {
        java.util.Map<java.lang.String, java.lang.String> map;
        if (this.mOptions.containsKey(str)) {
            if (i == 1) {
                map = this.mOptions;
                str2 = this.mOptions.get(str) + str2;
                map.put(str, str2);
                return true;
            }
            if (i != 2) {
                return false;
            }
        }
        map = this.mOptions;
        map.put(str, str2);
        return true;
    }
}
