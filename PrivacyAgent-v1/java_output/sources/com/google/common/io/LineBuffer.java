package com.google.common.io;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
abstract class LineBuffer {
    public java.lang.StringBuilder a = new java.lang.StringBuilder();
    public boolean b;

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(char[] cArr, int i, int i2) throws java.io.IOException {
        int i3;
        int i4;
        if (this.b && i2 > 0) {
            if (c(cArr[i] == '\n')) {
                i3 = i + 1;
                i4 = i + i2;
                int i5 = i3;
                while (i3 < i4) {
                    char c = cArr[i3];
                    if (c == '\n') {
                        this.a.append(cArr, i5, i3 - i5);
                        c(true);
                    } else if (c != '\r') {
                        i3++;
                    } else {
                        this.a.append(cArr, i5, i3 - i5);
                        this.b = true;
                        int i6 = i3 + 1;
                        if (i6 < i4) {
                            if (c(cArr[i6] == '\n')) {
                                i3 = i6;
                            }
                        }
                    }
                    i5 = i3 + 1;
                    i3++;
                }
                this.a.append(cArr, i5, i4 - i5);
            }
        }
        i3 = i;
        i4 = i + i2;
        int i52 = i3;
        while (i3 < i4) {
        }
        this.a.append(cArr, i52, i4 - i52);
    }

    public void b() throws java.io.IOException {
        if (this.b || this.a.length() > 0) {
            c(false);
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final boolean c(boolean z) throws java.io.IOException {
        d(this.a.toString(), this.b ? z ? "\r\n" : "\r" : z ? "\n" : "");
        this.a = new java.lang.StringBuilder();
        this.b = false;
        return z;
    }

    public abstract void d(java.lang.String str, java.lang.String str2) throws java.io.IOException;
}
