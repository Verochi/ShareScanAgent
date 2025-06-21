package com.igexin.push.core.a.a;

import com.igexin.push.core.e.f.AnonymousClass1;
import com.igexin.push.core.e.f.AnonymousClass17;

/* loaded from: classes23.dex */
public final class c extends com.igexin.push.core.a.a {
    private static final java.lang.String b = "LoginResult";

    /* renamed from: com.igexin.push.core.a.a.c$1, reason: invalid class name */
    public class AnonymousClass1 extends com.igexin.push.g.d {
        public AnonymousClass1() {
        }

        @Override // com.igexin.push.g.d
        public final void b() {
            try {
                com.igexin.push.core.e.d a = com.igexin.push.core.e.d.a(com.igexin.push.core.e.l);
                org.json.JSONObject a2 = a.a();
                if (a2 == null) {
                    return;
                }
                java.util.Iterator<java.lang.String> keys = a2.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    org.json.JSONObject jSONObject = a2.getJSONObject(next);
                    com.igexin.c.a.c.a.a("LoginResult|send unFeedback taskid = ".concat(java.lang.String.valueOf(next)), new java.lang.Object[0]);
                    jSONObject.put("appid", com.igexin.push.core.e.a);
                    com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMultiBrandMessageAction(jSONObject, jSONObject.getString("multaid"));
                    keys.remove();
                }
                a.b();
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.b(com.igexin.push.core.a.a.c.b, "feedbackMultiBrandPushMessage exception :" + th.toString());
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private void d() {
        com.igexin.c.a.c.a.d.a().a("[LoginResult] Login successed with cid = " + com.igexin.push.core.e.A);
        com.igexin.push.d.c cVar = com.igexin.push.d.c.b.a;
        cVar.c = java.lang.System.currentTimeMillis();
        if (cVar.b) {
            com.igexin.c.a.c.a.a(com.igexin.push.d.c.a, "loginRsp| enter polling");
            cVar.e = new com.igexin.push.d.e();
            com.igexin.push.g.b.d.a.a.g();
            cVar.d = 0;
        } else {
            cVar.b();
        }
        com.igexin.c.a.c.a.a("loginRsp|" + com.igexin.push.core.e.A + "|success", new java.lang.Object[0]);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("isCidBroadcasted|");
        sb.append(com.igexin.push.core.e.v);
        com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
        if (!com.igexin.push.core.e.v) {
            com.igexin.push.core.l.a().c();
            com.igexin.push.core.e.v = true;
        }
        com.igexin.push.core.e.u = true;
        com.igexin.push.h.j.g();
        com.igexin.push.core.l.a().b();
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.g();
        if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.H)) {
            com.igexin.c.a.c.a.a("LoginResult device id is empty, get device id from server +++++", new java.lang.Object[0]);
            com.igexin.push.core.a.b.d();
            com.igexin.push.core.a.b.h();
        }
        com.igexin.push.core.c.a.a().a(true);
        long currentTimeMillis = java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Q;
        com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new java.lang.Object[0]);
        boolean z = currentTimeMillis - 86400000 > 0;
        boolean z2 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
        boolean z3 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
        boolean b2 = com.igexin.push.h.c.b(com.igexin.push.core.e.l);
        boolean z4 = com.igexin.push.core.e.J != b2;
        if (z4) {
            com.igexin.push.core.e.f a = com.igexin.push.core.e.f.a();
            if (com.igexin.push.core.e.J != b2) {
                com.igexin.push.core.e.J = b2 ? 1 : 0;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a.new AnonymousClass17(), false, true);
            }
        }
        com.igexin.c.a.c.a.a("LoginResult|PHONE_INFO_DATA_CHANGE= " + com.igexin.push.core.e.aM + ", isOverOneDay = " + z + ", isDeviceTokenDiff = " + z2 + ", isCidDiff = " + z3 + ", isNotificationEnableDiff= " + z4, new java.lang.Object[0]);
        if (com.igexin.push.core.e.aM || z || z2 || z3 || z4) {
            com.igexin.push.core.a.b.d().i();
        }
        com.igexin.push.core.c.a.a();
        com.igexin.push.core.c.a.b();
        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass1(), false, true);
        if (!com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
            com.igexin.push.core.e.B = com.igexin.push.core.e.A;
        }
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = com.igexin.push.core.b.V;
        obtain.obj = new java.lang.Object();
        com.igexin.push.core.d.a.a.a(obtain);
        com.igexin.sdk.router.GTBoater.getInstance().initialize();
        if (com.igexin.assist.sdk.a.a().c()) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.a.a.c.AnonymousClass1(), false, true);
        }
    }

    private static void e() {
        long currentTimeMillis = java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Q;
        com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new java.lang.Object[0]);
        boolean z = currentTimeMillis - 86400000 > 0;
        boolean z2 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
        boolean z3 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
        boolean b2 = com.igexin.push.h.c.b(com.igexin.push.core.e.l);
        boolean z4 = com.igexin.push.core.e.J != b2;
        if (z4) {
            com.igexin.push.core.e.f a = com.igexin.push.core.e.f.a();
            if (com.igexin.push.core.e.J != b2) {
                com.igexin.push.core.e.J = b2 ? 1 : 0;
                com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a.new AnonymousClass17(), false, true);
            }
        }
        com.igexin.c.a.c.a.a("LoginResult|PHONE_INFO_DATA_CHANGE= " + com.igexin.push.core.e.aM + ", isOverOneDay = " + z + ", isDeviceTokenDiff = " + z2 + ", isCidDiff = " + z3 + ", isNotificationEnableDiff= " + z4, new java.lang.Object[0]);
        if (com.igexin.push.core.e.aM || z || z2 || z3 || z4) {
            com.igexin.push.core.a.b.d().i();
        }
    }

    private static void f() {
        com.igexin.c.a.c.a.d.a().a("[LoginResult] Login " + com.igexin.push.core.e.A + " failed");
        com.igexin.c.a.c.a.a(b, "login failed, clear session or cid");
        com.igexin.c.a.c.a.a("LoginResult login failed, clear session or cid", new java.lang.Object[0]);
        com.igexin.push.core.e.f.a().b();
        com.igexin.push.core.k.a();
        com.igexin.push.core.k.c();
    }

    private static void g() {
        if (com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
            return;
        }
        com.igexin.push.core.e.B = com.igexin.push.core.e.A;
    }

    private void h() {
        if (com.igexin.assist.sdk.a.a().c()) {
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.a.a.c.AnonymousClass1(), false, true);
        }
    }

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(java.lang.Object obj) {
        if (obj instanceof com.igexin.push.d.c.k) {
            com.igexin.push.core.e.b(0L);
            if (!com.igexin.push.core.e.u) {
                com.igexin.push.c.c.a().d().e();
                if (((com.igexin.push.d.c.k) obj).b) {
                    com.igexin.c.a.c.a.d.a().a("[LoginResult] Login successed with cid = " + com.igexin.push.core.e.A);
                    com.igexin.push.d.c cVar = com.igexin.push.d.c.b.a;
                    cVar.c = java.lang.System.currentTimeMillis();
                    if (cVar.b) {
                        com.igexin.c.a.c.a.a(com.igexin.push.d.c.a, "loginRsp| enter polling");
                        cVar.e = new com.igexin.push.d.e();
                        com.igexin.push.g.b.d.a.a.g();
                        cVar.d = 0;
                    } else {
                        cVar.b();
                    }
                    com.igexin.c.a.c.a.a("loginRsp|" + com.igexin.push.core.e.A + "|success", new java.lang.Object[0]);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder("isCidBroadcasted|");
                    sb.append(com.igexin.push.core.e.v);
                    com.igexin.c.a.c.a.a(sb.toString(), new java.lang.Object[0]);
                    if (!com.igexin.push.core.e.v) {
                        com.igexin.push.core.l.a().c();
                        com.igexin.push.core.e.v = true;
                    }
                    com.igexin.push.core.e.u = true;
                    com.igexin.push.h.j.g();
                    com.igexin.push.core.l.a().b();
                    com.igexin.push.core.a.b.d();
                    com.igexin.push.core.a.b.g();
                    if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.H)) {
                        com.igexin.c.a.c.a.a("LoginResult device id is empty, get device id from server +++++", new java.lang.Object[0]);
                        com.igexin.push.core.a.b.d();
                        com.igexin.push.core.a.b.h();
                    }
                    com.igexin.push.core.c.a.a().a(true);
                    long currentTimeMillis = java.lang.System.currentTimeMillis() - com.igexin.push.core.e.Q;
                    com.igexin.c.a.c.a.a("LoginResult|lastAddphoneinfoTime: " + com.igexin.push.core.e.Q, new java.lang.Object[0]);
                    boolean z = currentTimeMillis - 86400000 > 0;
                    boolean z2 = !com.igexin.c.b.a.a(com.igexin.push.core.e.K, com.igexin.push.core.e.I);
                    boolean z3 = !com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B);
                    boolean b2 = com.igexin.push.h.c.b(com.igexin.push.core.e.l);
                    boolean z4 = com.igexin.push.core.e.J != b2;
                    if (z4) {
                        com.igexin.push.core.e.f a = com.igexin.push.core.e.f.a();
                        if (com.igexin.push.core.e.J != b2) {
                            com.igexin.push.core.e.J = b2 ? 1 : 0;
                            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) a.new AnonymousClass17(), false, true);
                        }
                    }
                    com.igexin.c.a.c.a.a("LoginResult|PHONE_INFO_DATA_CHANGE= " + com.igexin.push.core.e.aM + ", isOverOneDay = " + z + ", isDeviceTokenDiff = " + z2 + ", isCidDiff = " + z3 + ", isNotificationEnableDiff= " + z4, new java.lang.Object[0]);
                    if (com.igexin.push.core.e.aM || z || z2 || z3 || z4) {
                        com.igexin.push.core.a.b.d().i();
                    }
                    com.igexin.push.core.c.a.a();
                    com.igexin.push.core.c.a.b();
                    com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) com.igexin.push.core.e.f.a().new AnonymousClass1(), false, true);
                    if (!com.igexin.push.core.e.A.equals(com.igexin.push.core.e.B)) {
                        com.igexin.push.core.e.B = com.igexin.push.core.e.A;
                    }
                    android.os.Message obtain = android.os.Message.obtain();
                    obtain.what = com.igexin.push.core.b.V;
                    obtain.obj = new java.lang.Object();
                    com.igexin.push.core.d.a.a.a(obtain);
                    com.igexin.sdk.router.GTBoater.getInstance().initialize();
                    if (com.igexin.assist.sdk.a.a().c()) {
                        com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.core.a.a.c.AnonymousClass1(), false, true);
                    }
                } else {
                    com.igexin.c.a.c.a.d.a().a("[LoginResult] Login " + com.igexin.push.core.e.A + " failed");
                    com.igexin.c.a.c.a.a(b, "login failed, clear session or cid");
                    com.igexin.c.a.c.a.a("LoginResult login failed, clear session or cid", new java.lang.Object[0]);
                    com.igexin.push.core.e.f.a().b();
                    com.igexin.push.core.k.a();
                    com.igexin.push.core.k.c();
                }
            }
        }
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }
}
