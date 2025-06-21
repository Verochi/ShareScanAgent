package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class js {
    public long a;
    public java.lang.String b;
    public int d;
    public long e;
    public short g;
    public boolean h;
    public int c = -113;
    public long f = 0;

    public js(boolean z) {
        this.h = z;
    }

    public static long a(java.lang.String str) {
        long j;
        if (str == null || str.length() == 0) {
            return 0L;
        }
        int i = 0;
        long j2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long charAt = str.charAt(length);
            if (charAt < 48 || charAt > 57) {
                long j3 = 97;
                if (charAt < 97 || charAt > 102) {
                    j3 = 65;
                    if (charAt < 65 || charAt > 70) {
                        if (charAt != 58 && charAt != 124) {
                            return 0L;
                        }
                    }
                }
                j = (charAt - j3) + 10;
            } else {
                j = charAt - 48;
            }
            j2 += j << i;
            i += 4;
        }
        if (i != 48) {
            return 0L;
        }
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.amap.api.mapcore.util.js clone() {
        com.amap.api.mapcore.util.js jsVar = new com.amap.api.mapcore.util.js(this.h);
        jsVar.a = this.a;
        jsVar.b = this.b;
        jsVar.c = this.c;
        jsVar.d = this.d;
        jsVar.e = this.e;
        jsVar.f = this.f;
        jsVar.g = this.g;
        jsVar.h = this.h;
        return jsVar;
    }

    public final java.lang.String toString() {
        return "AmapWifi{mac=" + this.a + ", ssid='" + this.b + "', rssi=" + this.c + ", frequency=" + this.d + ", timestamp=" + this.e + ", lastUpdateUtcMills=" + this.f + ", freshness=" + ((int) this.g) + ", connected=" + this.h + '}';
    }
}
