package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class ch extends com.baidu.mobads.sdk.internal.j {
    final /* synthetic */ com.baidu.mobads.sdk.internal.bz.c b;
    final /* synthetic */ android.os.Handler c;
    final /* synthetic */ com.baidu.mobads.sdk.internal.bz d;

    public ch(com.baidu.mobads.sdk.internal.bz bzVar, com.baidu.mobads.sdk.internal.bz.c cVar, android.os.Handler handler) {
        this.d = bzVar;
        this.b = cVar;
        this.c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    public java.lang.Object i() {
        com.baidu.mobads.sdk.internal.bt btVar;
        android.content.SharedPreferences m;
        com.baidu.mobads.sdk.internal.bt btVar2;
        android.content.SharedPreferences m2;
        com.baidu.mobads.sdk.internal.bt btVar3;
        android.content.SharedPreferences m3;
        try {
            try {
                synchronized (com.baidu.mobads.sdk.internal.bz.class) {
                    this.d.b(this.b, this.c);
                }
                m3 = this.d.m();
                android.content.SharedPreferences.Editor edit = m3.edit();
                edit.putString(com.baidu.mobads.sdk.internal.bz.d, this.d.a());
                edit.apply();
                return null;
            } catch (java.lang.Throwable th) {
                try {
                    java.lang.String str = "Load APK Failed: " + th.toString();
                    btVar2 = this.d.z;
                    btVar2.a(com.baidu.mobads.sdk.internal.bz.a, str);
                    this.d.b(false);
                    m2 = this.d.m();
                    android.content.SharedPreferences.Editor edit2 = m2.edit();
                    edit2.putString(com.baidu.mobads.sdk.internal.bz.d, this.d.a());
                    edit2.apply();
                    return null;
                } catch (java.lang.Throwable th2) {
                    try {
                        m = this.d.m();
                        android.content.SharedPreferences.Editor edit3 = m.edit();
                        edit3.putString(com.baidu.mobads.sdk.internal.bz.d, this.d.a());
                        edit3.apply();
                    } catch (java.lang.Throwable th3) {
                        btVar = this.d.z;
                        btVar.a(com.baidu.mobads.sdk.internal.bz.a, th3);
                    }
                    throw th2;
                }
            }
        } catch (java.lang.Throwable th4) {
            btVar3 = this.d.z;
            btVar3.a(com.baidu.mobads.sdk.internal.bz.a, th4);
            return null;
        }
    }
}
