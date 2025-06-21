package com.google.android.gms.common.logging;

@com.google.android.gms.common.annotation.KeepForSdk
/* loaded from: classes22.dex */
public class Logger {
    public final java.lang.String a;
    public final java.lang.String b;
    public final com.google.android.gms.common.internal.GmsLogger c;
    public final int d;

    public Logger(java.lang.String str, java.lang.String str2) {
        this.b = str2;
        this.a = str;
        this.c = new com.google.android.gms.common.internal.GmsLogger(str);
        int i = 2;
        while (7 >= i && !android.util.Log.isLoggable(this.a, i)) {
            i++;
        }
        this.d = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Logger(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.String... strArr) {
        this(str, r8);
        java.lang.String sb;
        if (strArr.length == 0) {
            sb = "";
        } else {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append('[');
            for (java.lang.String str2 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str2);
            }
            sb2.append(']');
            sb2.append(' ');
            sb = sb2.toString();
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void d(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Throwable th, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (isLoggable(3)) {
            format(str, objArr);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void d(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (isLoggable(3)) {
            format(str, objArr);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void e(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Throwable th, @androidx.annotation.Nullable java.lang.Object... objArr) {
        format(str, objArr);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void e(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        format(str, objArr);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.String format(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = java.lang.String.format(java.util.Locale.US, str, objArr);
        }
        return this.b.concat(str);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public java.lang.String getTag() {
        return this.a;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void i(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        format(str, objArr);
    }

    @androidx.annotation.RecentlyNonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    public boolean isLoggable(@androidx.annotation.RecentlyNonNull int i) {
        return this.d <= i;
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void v(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Throwable th, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (isLoggable(2)) {
            format(str, objArr);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void v(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        if (isLoggable(2)) {
            format(str, objArr);
        }
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void w(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.Nullable java.lang.Object... objArr) {
        format(str, objArr);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void wtf(@androidx.annotation.RecentlyNonNull java.lang.String str, @androidx.annotation.RecentlyNonNull java.lang.Throwable th, @androidx.annotation.Nullable java.lang.Object... objArr) {
        android.util.Log.wtf(this.a, format(str, objArr), th);
    }

    @com.google.android.gms.common.annotation.KeepForSdk
    public void wtf(@androidx.annotation.RecentlyNonNull java.lang.Throwable th) {
        android.util.Log.wtf(this.a, th);
    }
}
