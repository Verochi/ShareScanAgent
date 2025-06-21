package com.igexin.c.a.c.a;

/* loaded from: classes22.dex */
public final class c extends android.os.Handler implements android.content.ServiceConnection {
    public static final java.lang.String a = "SERVER_LOG";
    private static final java.lang.String c = "LogController";
    public com.igexin.c.a.c.a.b b;
    private android.os.Messenger d;
    private android.os.Messenger e;

    public static class a {
        private static final com.igexin.c.a.c.a.c a = new com.igexin.c.a.c.a.c((byte) 0);

        private a() {
        }
    }

    private c() {
        super(android.os.Looper.getMainLooper());
        this.b = new com.igexin.c.a.c.a.a();
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public static com.igexin.c.a.c.a.c a() {
        return com.igexin.c.a.c.a.c.a.a;
    }

    private void a(android.content.Context context, com.igexin.sdk.IUserLoggerInterface iUserLoggerInterface) {
        if (iUserLoggerInterface == null) {
            com.igexin.c.a.c.a.e.a(c, "user logger register parameter can not be null!");
            return;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        a(applicationContext);
        this.b.a(iUserLoggerInterface);
        this.b.a();
        a("[LogController] Sdk version = " + com.igexin.sdk.PushManager.getInstance().getVersion(applicationContext));
    }

    public final void a(android.content.Context context) {
        com.igexin.c.a.c.a.a("try to bind log server", new java.lang.Object[0]);
        try {
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.igexin.push.core.ServiceManager.getInstance().b(context));
            intent.setType(a);
            context.bindService(intent, this, 1);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.e.a(c, "bind service error = " + e.toString());
        }
    }

    public final void a(java.lang.String str) {
        com.igexin.c.a.c.a.b bVar = this.b;
        if (bVar != null) {
            bVar.a(str);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        if (message.what == 2) {
            java.lang.String string = message.getData().getString(com.igexin.c.a.c.a.d.d);
            if (android.text.TextUtils.isEmpty(string)) {
                return;
            }
            if (!string.contains("\n")) {
                this.b.a(string);
                return;
            }
            for (java.lang.String str : string.split("\n")) {
                this.b.a(str);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.igexin.c.a.c.a.a("remote log service connected ", new java.lang.Object[0]);
        try {
            this.e = new android.os.Messenger(iBinder);
            if (this.d == null) {
                this.d = new android.os.Messenger(this);
            }
            android.os.Message obtain = android.os.Message.obtain();
            obtain.replyTo = this.d;
            obtain.what = 1;
            this.e.send(obtain);
        } catch (java.lang.Exception e) {
            com.igexin.c.a.c.a.a(c, "Client sent Message to Service error = ".concat(java.lang.String.valueOf(e)));
            a("Client sent Message to Service error = ".concat(java.lang.String.valueOf(e)));
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
        this.e = null;
    }
}
