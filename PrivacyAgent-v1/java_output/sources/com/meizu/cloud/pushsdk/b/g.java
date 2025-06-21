package com.meizu.cloud.pushsdk.b;

/* loaded from: classes23.dex */
public class g extends com.meizu.cloud.pushsdk.b.h<com.meizu.cloud.pushsdk.b.f> implements com.meizu.cloud.pushsdk.b.f {
    private static com.meizu.cloud.pushsdk.b.g a;
    private boolean b;

    private g(com.meizu.cloud.pushsdk.b.f fVar) {
        super(fVar);
        this.b = false;
    }

    public static com.meizu.cloud.pushsdk.b.g b() {
        if (a == null) {
            synchronized (com.meizu.cloud.pushsdk.b.g.class) {
                if (a == null) {
                    a = new com.meizu.cloud.pushsdk.b.g(new com.meizu.cloud.pushsdk.b.b());
                }
            }
        }
        return a;
    }

    public void a(android.content.Context context) {
        a(context, (java.lang.String) null);
    }

    public void a(android.content.Context context, java.lang.String str) {
        if (this.b) {
            return;
        }
        this.b = true;
        b((context.getApplicationInfo().flags & 2) != 0);
        if (str == null) {
            if (android.os.Build.VERSION.SDK_INT >= 29) {
                str = com.meizu.cloud.pushsdk.util.MzSystemUtils.getDocumentsPath(context) + "/pushSdk/" + context.getPackageName();
            } else {
                str = android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/pushSdk/" + context.getPackageName();
            }
        }
        a(str);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(java.lang.String str) {
        c().a(str);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(java.lang.String str, java.lang.String str2) {
        c().a(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        c().a(str, str2, th);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void a(boolean z) {
        c().a(z);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public boolean a() {
        return c().a();
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(java.lang.String str, java.lang.String str2) {
        c().b(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void b(boolean z) {
        c().b(z);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void c(java.lang.String str, java.lang.String str2) {
        c().c(str, str2);
    }

    @Override // com.meizu.cloud.pushsdk.b.f
    public void d(java.lang.String str, java.lang.String str2) {
        c().d(str, str2);
    }
}
