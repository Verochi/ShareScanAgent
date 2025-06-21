package com.huawei.hms.base.log;

/* loaded from: classes22.dex */
public class a {
    public java.lang.String b;
    public int a = 4;
    public com.huawei.hms.base.log.b c = new com.huawei.hms.base.log.e();

    public com.huawei.hms.base.log.b a() {
        return this.c;
    }

    public final com.huawei.hms.base.log.c a(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        com.huawei.hms.base.log.c cVar = new com.huawei.hms.base.log.c(8, this.b, i, str);
        cVar.a((com.huawei.hms.base.log.c) str2);
        cVar.a(th);
        return cVar;
    }

    public void a(int i, java.lang.String str, java.lang.String str2) {
        if (a(i)) {
            com.huawei.hms.base.log.c a = a(i, str, str2, null);
            this.c.a(a.c() + a.a(), i, str, str2);
        }
    }

    public void a(android.content.Context context, int i, java.lang.String str) {
        this.a = i;
        this.b = str;
        this.c.a(context, "HMSCore");
    }

    public void a(com.huawei.hms.base.log.b bVar) {
        this.c = bVar;
    }

    public void a(java.lang.String str, java.lang.String str2) {
        com.huawei.hms.base.log.c a = a(4, str, str2, null);
        this.c.a(a.c() + '\n' + a.a(), 4, str, str2);
    }

    public boolean a(int i) {
        return i >= this.a;
    }

    public void b(int i, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (a(i)) {
            com.huawei.hms.base.log.c a = a(i, str, str2, th);
            java.lang.String str3 = a.c() + a.a();
            this.c.a(str3, i, str, str2 + '\n' + android.util.Log.getStackTraceString(th));
        }
    }
}
