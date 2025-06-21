package com.vivo.push.util;

/* loaded from: classes19.dex */
public final class n implements com.vivo.push.util.o {
    private static final java.lang.String a = "(" + android.os.Process.myPid() + ")";

    private void a(android.content.Context context, java.lang.String str, int i) {
        com.vivo.push.b.n nVar = new com.vivo.push.b.n();
        nVar.b(str);
        nVar.a(i);
        if (i > 0) {
            d("LogController", str);
        }
        if (!context.getPackageName().equals("com.vivo.pushservice")) {
            nVar.a(false);
            com.vivo.push.a.a.a(context, nVar, context.getPackageName());
        } else {
            nVar.a(true);
            java.util.Iterator<java.lang.String> it = com.vivo.push.e.a.a().b().iterator();
            while (it.hasNext()) {
                com.vivo.push.a.a.a(context, nVar, it.next());
            }
        }
    }

    private static boolean a() {
        com.vivo.push.util.p.a();
        return com.vivo.push.e.a.a().c();
    }

    @Override // com.vivo.push.util.o
    public final int a(java.lang.String str, java.lang.String str2) {
        return android.util.Log.e("VivoPush.".concat(java.lang.String.valueOf(str)), a + str2);
    }

    @Override // com.vivo.push.util.o
    public final int a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        return android.util.Log.e("VivoPush.".concat(java.lang.String.valueOf(str)), a + str2, th);
    }

    @Override // com.vivo.push.util.o
    public final int a(java.lang.String str, java.lang.Throwable th) {
        return android.util.Log.e("VivoPush.".concat(java.lang.String.valueOf(str)), android.util.Log.getStackTraceString(th));
    }

    @Override // com.vivo.push.util.o
    public final java.lang.String a(java.lang.Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }

    @Override // com.vivo.push.util.o
    public final void a(android.content.Context context, java.lang.String str) {
        if (a()) {
            a(context, str, 0);
        }
    }

    @Override // com.vivo.push.util.o
    public final int b(java.lang.String str, java.lang.String str2) {
        return android.util.Log.w("VivoPush.".concat(java.lang.String.valueOf(str)), a + str2);
    }

    @Override // com.vivo.push.util.o
    public final int b(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        if (!com.vivo.push.util.p.a()) {
            return -1;
        }
        return android.util.Log.i("VivoPush.".concat(java.lang.String.valueOf(str)), a + str2, th);
    }

    @Override // com.vivo.push.util.o
    public final void b(android.content.Context context, java.lang.String str) {
        if (a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.o
    public final int c(java.lang.String str, java.lang.String str2) {
        return android.util.Log.d("VivoPush.".concat(java.lang.String.valueOf(str)), a + str2);
    }

    @Override // com.vivo.push.util.o
    public final void c(android.content.Context context, java.lang.String str) {
        if (a()) {
            a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.o
    public final int d(java.lang.String str, java.lang.String str2) {
        if (!com.vivo.push.util.p.a()) {
            return -1;
        }
        return android.util.Log.i("VivoPush.".concat(java.lang.String.valueOf(str)), a + str2);
    }

    @Override // com.vivo.push.util.o
    public final int e(java.lang.String str, java.lang.String str2) {
        if (!com.vivo.push.util.p.a()) {
            return -1;
        }
        return android.util.Log.v("VivoPush.".concat(java.lang.String.valueOf(str)), a + str2);
    }
}
