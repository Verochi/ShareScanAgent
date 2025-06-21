package com.xiaomi.push;

/* loaded from: classes19.dex */
public enum gy {
    RegIdExpired(0),
    PackageUnregistered(1),
    Init(2);

    final int d;

    gy(int i) {
        this.d = i;
    }

    public static com.xiaomi.push.gy a(int i) {
        if (i == 0) {
            return RegIdExpired;
        }
        if (i == 1) {
            return PackageUnregistered;
        }
        if (i != 2) {
            return null;
        }
        return Init;
    }
}
