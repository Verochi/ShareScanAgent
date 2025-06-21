package com.xiaomi.push;

/* loaded from: classes19.dex */
public class av {
    private static volatile com.xiaomi.push.av a;
    private android.content.Context b;

    private av(android.content.Context context) {
        this.b = context;
    }

    public static com.xiaomi.push.av a(android.content.Context context) {
        if (a == null) {
            synchronized (com.xiaomi.push.av.class) {
                if (a == null) {
                    a = new com.xiaomi.push.av(context);
                }
            }
        }
        return a;
    }

    public final synchronized long a(java.lang.String str, java.lang.String str2) {
        try {
        } catch (java.lang.Throwable unused) {
            return 0L;
        }
        return this.b.getSharedPreferences(str, 4).getLong(str2, 0L);
    }

    public final synchronized void a(java.lang.String str, java.lang.String str2, long j) {
        android.content.SharedPreferences.Editor edit = this.b.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j);
        edit.commit();
    }

    public final synchronized void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.SharedPreferences.Editor edit = this.b.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    public final synchronized java.lang.String b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        try {
        } catch (java.lang.Throwable unused) {
            return str3;
        }
        return this.b.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
