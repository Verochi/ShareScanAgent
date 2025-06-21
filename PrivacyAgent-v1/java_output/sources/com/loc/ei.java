package com.loc;

/* loaded from: classes23.dex */
public final class ei {
    public long a;
    public java.lang.String b;
    public int d;
    public long e;
    public short g;
    public boolean h;
    public int c = -113;
    public long f = 0;

    public ei(boolean z) {
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

    public static java.lang.String a(long j) {
        if (j < 0 || j > 281474976710655L) {
            return null;
        }
        return com.loc.eq.a(com.loc.eq.a(j), com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.loc.ei clone() {
        com.loc.ei eiVar = new com.loc.ei(this.h);
        eiVar.a = this.a;
        eiVar.b = this.b;
        eiVar.c = this.c;
        eiVar.d = this.d;
        eiVar.e = this.e;
        eiVar.f = this.f;
        eiVar.g = this.g;
        eiVar.h = this.h;
        return eiVar;
    }

    public final java.lang.String a() {
        return this.h + "#" + this.a;
    }

    public final java.lang.String toString() {
        return "AmapWifi{mac=" + this.a + ", ssid='" + this.b + "', rssi=" + this.c + ", frequency=" + this.d + ", timestamp=" + this.e + ", lastUpdateUtcMills=" + this.f + ", freshness=" + ((int) this.g) + ", connected=" + this.h + '}';
    }
}
