package com.google.android.gms.common.internal;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public final class GmsLogger {
    public final java.lang.String a;

    @androidx.annotation.Nullable
    public final java.lang.String b;

    public GmsLogger(@androidx.annotation.RecentlyNonNull java.lang.String str) {
        this(str, null);
    }

    public GmsLogger(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        com.google.android.gms.common.internal.Preconditions.checkNotNull(str, "log tag cannot be null");
        com.google.android.gms.common.internal.Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.a = str;
        if (str2 == null || str2.length() <= 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
    }

    public final java.lang.String a(java.lang.String str) {
        java.lang.String str2 = this.b;
        return str2 == null ? str : str2.concat(str);
    }

    public final java.lang.String b(java.lang.String str, java.lang.Object... objArr) {
        java.lang.String format = java.lang.String.format(str, objArr);
        java.lang.String str2 = this.b;
        return str2 == null ? format : str2.concat(format);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final boolean canLog(@androidx.annotation.RecentlyNonNull int i) {
        return android.util.Log.isLoggable(this.a, i);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public final boolean canLogPii() {
        return false;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void d(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        if (canLog(3)) {
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void d(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
        if (canLog(3)) {
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void e(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        if (canLog(6)) {
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void e(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
        if (canLog(6)) {
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void efmt(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.Object... objArr) {
        if (canLog(6)) {
            b(str2, objArr);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void i(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        if (canLog(4)) {
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void i(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
        if (canLog(4)) {
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void pii(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        if (canLogPii()) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            if (" PII_LOG".length() != 0) {
                valueOf.concat(" PII_LOG");
            }
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void pii(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
        if (canLogPii()) {
            java.lang.String valueOf = java.lang.String.valueOf(str);
            if (" PII_LOG".length() != 0) {
                valueOf.concat(" PII_LOG");
            }
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void v(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        if (canLog(2)) {
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void v(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
        if (canLog(2)) {
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void w(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2) {
        if (canLog(5)) {
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void w(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
        if (canLog(5)) {
            a(str2);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void wfmt(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.Object... objArr) {
        if (canLog(5)) {
            b(str2, objArr);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public final void wtf(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String str2, @androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
        if (canLog(7)) {
            a(str2);
            android.util.Log.wtf(str, a(str2), th);
        }
    }
}
