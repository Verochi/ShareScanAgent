package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class af {
    private static volatile com.xiaomi.mipush.sdk.af a;

    /* renamed from: a, reason: collision with other field name */
    private android.content.Context f20a;

    /* renamed from: a, reason: collision with other field name */
    private java.util.List<com.xiaomi.mipush.sdk.x> f21a = new java.util.ArrayList();

    private af(android.content.Context context) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.f20a = applicationContext;
        if (applicationContext == null) {
            this.f20a = context;
        }
    }

    public static com.xiaomi.mipush.sdk.af a(android.content.Context context) {
        if (a == null) {
            synchronized (com.xiaomi.mipush.sdk.af.class) {
                if (a == null) {
                    a = new com.xiaomi.mipush.sdk.af(context);
                }
            }
        }
        return a;
    }

    public int a(java.lang.String str) {
        synchronized (this.f21a) {
            com.xiaomi.mipush.sdk.x xVar = new com.xiaomi.mipush.sdk.x();
            xVar.f60a = str;
            if (this.f21a.contains(xVar)) {
                for (com.xiaomi.mipush.sdk.x xVar2 : this.f21a) {
                    if (xVar2.equals(xVar)) {
                        return xVar2.a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized java.lang.String a(com.xiaomi.mipush.sdk.au auVar) {
        return this.f20a.getSharedPreferences("mipush_extra", 0).getString(auVar.name(), "");
    }

    public synchronized void a(com.xiaomi.mipush.sdk.au auVar, java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.f20a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(auVar.name(), str).commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m105a(java.lang.String str) {
        synchronized (this.f21a) {
            com.xiaomi.mipush.sdk.x xVar = new com.xiaomi.mipush.sdk.x();
            xVar.a = 0;
            xVar.f60a = str;
            if (this.f21a.contains(xVar)) {
                this.f21a.remove(xVar);
            }
            this.f21a.add(xVar);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m106a(java.lang.String str) {
        synchronized (this.f21a) {
            com.xiaomi.mipush.sdk.x xVar = new com.xiaomi.mipush.sdk.x();
            xVar.f60a = str;
            return this.f21a.contains(xVar);
        }
    }

    public void b(java.lang.String str) {
        synchronized (this.f21a) {
            com.xiaomi.mipush.sdk.x xVar = new com.xiaomi.mipush.sdk.x();
            xVar.f60a = str;
            if (this.f21a.contains(xVar)) {
                java.util.Iterator<com.xiaomi.mipush.sdk.x> it = this.f21a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.xiaomi.mipush.sdk.x next = it.next();
                    if (xVar.equals(next)) {
                        xVar = next;
                        break;
                    }
                }
            }
            xVar.a++;
            this.f21a.remove(xVar);
            this.f21a.add(xVar);
        }
    }

    public void c(java.lang.String str) {
        synchronized (this.f21a) {
            com.xiaomi.mipush.sdk.x xVar = new com.xiaomi.mipush.sdk.x();
            xVar.f60a = str;
            if (this.f21a.contains(xVar)) {
                this.f21a.remove(xVar);
            }
        }
    }
}
