package com.xiaomi.push;

/* loaded from: classes19.dex */
public enum gq {
    MISC_CONFIG(1),
    PLUGIN_CONFIG(2);

    public final int c;

    gq(int i) {
        this.c = i;
    }

    public static com.xiaomi.push.gq a(int i) {
        if (i == 1) {
            return MISC_CONFIG;
        }
        if (i != 2) {
            return null;
        }
        return PLUGIN_CONFIG;
    }
}
