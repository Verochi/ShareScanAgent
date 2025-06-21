package com.igexin.push.core;

/* loaded from: classes23.dex */
public final class l extends android.os.Handler implements android.content.ServiceConnection {
    private static final java.lang.String a = "MsgServerSender";
    private static volatile com.igexin.push.core.l c = null;
    private static final int e = 1;
    private static final int f = 2;
    private static android.content.Context h;
    private final java.util.concurrent.ConcurrentLinkedQueue<android.content.Intent> b;
    private final com.igexin.push.core.l.a d;
    private volatile android.os.Messenger g;
    private java.util.concurrent.atomic.AtomicBoolean i;

    public final class a {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 0;
        static final int e = 1;
        final android.os.Handler f;

        /* renamed from: com.igexin.push.core.l$a$1, reason: invalid class name */
        public class AnonymousClass1 extends android.os.Handler {
            final /* synthetic */ com.igexin.push.core.l a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(android.os.Looper looper, com.igexin.push.core.l lVar) {
                super(looper);
                this.a = lVar;
            }

            @Override // android.os.Handler
            public final void handleMessage(android.os.Message message) {
                if (message == null) {
                    return;
                }
                try {
                    int i = message.what;
                    boolean z = true;
                    if (i == 1) {
                        if (com.igexin.push.core.l.this.a((android.os.IBinder) message.obj)) {
                            removeMessages(2);
                            removeMessages(3);
                            removeMessages(1);
                            com.igexin.push.core.l.a(com.igexin.push.core.l.this);
                            return;
                        }
                        return;
                    }
                    if (i == 2 || i == 3) {
                        com.igexin.push.core.l lVar = com.igexin.push.core.l.this;
                        if (message.arg1 != 0) {
                            z = false;
                        }
                        com.igexin.push.core.l.a(lVar, z);
                    }
                } catch (java.lang.Throwable th) {
                    com.igexin.push.core.l.this.i.set(false);
                    com.igexin.c.a.c.a.a(th);
                }
            }
        }

        public a() {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("GTIS-HANDLER");
            handlerThread.start();
            this.f = new com.igexin.push.core.l.a.AnonymousClass1(handlerThread.getLooper(), com.igexin.push.core.l.this);
        }

        private android.os.Handler a() {
            return this.f;
        }
    }

    private l() {
        super(android.os.Looper.getMainLooper());
        this.i = new java.util.concurrent.atomic.AtomicBoolean(false);
        com.igexin.push.core.l.a aVar = new com.igexin.push.core.l.a();
        this.d = aVar;
        this.b = new java.util.concurrent.ConcurrentLinkedQueue<>();
        android.os.Message.obtain(aVar.f, 3, 1, 0).sendToTarget();
    }

    public static com.igexin.push.core.l a() {
        if (c == null) {
            synchronized (com.igexin.push.core.l.class) {
                if (c == null) {
                    c = new com.igexin.push.core.l();
                }
            }
        }
        return c;
    }

    private void a(int i) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10008);
        bundle.putInt("pid", i);
        a(bundle);
    }

    public static void a(android.content.Context context) {
        if (context == null) {
            return;
        }
        h = context.getApplicationContext();
        com.igexin.push.core.ServiceManager.b = context.getApplicationContext();
    }

    private void a(android.content.Intent intent) {
        if (intent == null) {
            return;
        }
        if (this.g == null) {
            com.igexin.c.a.c.a.a(a, "realSend, remoteMessenger is null");
            com.igexin.c.a.c.a.a("MsgServerSender|realSend, remoteMessenger is null", new java.lang.Object[0]);
        }
        android.os.Bundle extras = intent.getExtras();
        if (extras == null || extras.get("action") == null || !(extras.get("action") instanceof java.lang.Integer)) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|realSend action = ".concat(java.lang.String.valueOf(extras.getInt("action"))), new java.lang.Object[0]);
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 1;
        obtain.obj = intent;
        try {
            this.g.send(obtain);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("MsgServerSender|realSend iservice error = " + e2.toString(), new java.lang.Object[0]);
            if (e2 instanceof android.os.DeadObjectException) {
                android.os.Message.obtain(this.d.f, 2, 0, 0).sendToTarget();
            }
        }
    }

    public static /* synthetic */ void a(com.igexin.push.core.l lVar) {
        while (!lVar.b.isEmpty()) {
            android.content.Intent poll = lVar.b.poll();
            if (poll != null) {
                lVar.a(poll);
            }
        }
    }

    public static /* synthetic */ void a(com.igexin.push.core.l lVar, boolean z) {
        if (z && lVar.g != null) {
            lVar.g = null;
        }
        if (lVar.i.get()) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|try to bind iservice", new java.lang.Object[0]);
        try {
            lVar.i.set(true);
            if (com.igexin.push.core.e.l == null) {
                com.igexin.push.core.e.l = h;
            }
            android.content.Intent intent = new android.content.Intent(com.igexin.push.core.e.l, (java.lang.Class<?>) com.igexin.push.core.ServiceManager.getInstance().c(com.igexin.push.core.e.l));
            intent.setType(com.igexin.push.core.e.l.getPackageName());
            com.igexin.push.core.e.l.bindService(intent, lVar, 1);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.e.a(a, "bind iservice error = " + th.toString());
            com.igexin.c.a.c.a.a(th);
            lVar.i.set(false);
        }
    }

    private void a(com.igexin.sdk.message.GTPopupMessage gTPopupMessage) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.setClassLoader(com.igexin.sdk.message.GTPopupMessage.class.getClassLoader());
        bundle.putInt("action", com.igexin.sdk.PushConsts.ACTION_POPUP_CLICKED);
        bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_POPUP_CLICKED, gTPopupMessage);
        a(bundle);
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j) {
        java.lang.String str5 = com.igexin.push.core.e.a;
        if (str5 != null && str5.equals(str)) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("action", 10010);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_CMD_MSG, new com.igexin.sdk.message.FeedbackCmdMessage(str2, str3, str4, j, 10006));
            a(bundle);
        }
        android.content.Intent d = d();
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putInt("action", 10006);
        bundle2.putString("appid", str);
        bundle2.putString("taskid", str2);
        bundle2.putString("actionid", str3);
        bundle2.putString("result", str4);
        bundle2.putLong("timestamp", j);
        d.putExtras(bundle2);
        com.igexin.push.core.e.l.sendBroadcast(d, com.igexin.push.core.e.ac);
    }

    private static void a(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr) {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(com.igexin.push.core.b.J.concat(java.lang.String.valueOf(str3)));
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10001);
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("appid", str3);
        bundle.putString("payloadid", str2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str);
        bundle.putString(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, com.igexin.push.core.e.g);
        bundle.putByteArray("payload", bArr);
        intent.putExtras(bundle);
        intent.setPackage(com.igexin.push.core.e.l.getPackageName());
        com.igexin.push.core.e.l.sendBroadcast(intent, com.igexin.push.core.e.ac);
    }

    private void a(boolean z) {
        if (z && this.g != null) {
            this.g = null;
        }
        if (this.i.get()) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|try to bind iservice", new java.lang.Object[0]);
        try {
            this.i.set(true);
            if (com.igexin.push.core.e.l == null) {
                com.igexin.push.core.e.l = h;
            }
            android.content.Intent intent = new android.content.Intent(com.igexin.push.core.e.l, (java.lang.Class<?>) com.igexin.push.core.ServiceManager.getInstance().c(com.igexin.push.core.e.l));
            intent.setType(com.igexin.push.core.e.l.getPackageName());
            com.igexin.push.core.e.l.bindService(intent, this, 1);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.e.a(a, "bind iservice error = " + th.toString());
            com.igexin.c.a.c.a.a(th);
            this.i.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(android.os.IBinder iBinder) {
        if (iBinder == null) {
            return false;
        }
        try {
            this.g = new android.os.Messenger(iBinder);
            this.i.set(false);
            return true;
        } finally {
            this.i.set(false);
        }
    }

    private void b(android.content.Intent intent) {
        if (this.g != null) {
            a(intent);
        } else {
            this.b.add(intent);
            android.os.Message.obtain(this.d.f, 2, 1, 0).sendToTarget();
        }
    }

    private void b(com.igexin.sdk.message.GTPopupMessage gTPopupMessage) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", com.igexin.sdk.PushConsts.ACTION_POPUP_SHOW);
        bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_POPUP_SHOW, gTPopupMessage);
        a(bundle);
    }

    private void b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10011);
        bundle.putSerializable("notification_arrived", new com.igexin.sdk.message.GTNotificationMessage(str, str2, str3, str4, str5, str6, str7));
        a(bundle);
    }

    @android.annotation.TargetApi(12)
    public static android.content.Intent d() {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(com.igexin.push.core.b.J + com.igexin.push.core.e.a);
        intent.setPackage(com.igexin.push.core.e.l.getPackageName());
        return intent;
    }

    private void e() {
        this.g = null;
    }

    private void f() {
        if (this.i.get()) {
            return;
        }
        com.igexin.c.a.c.a.a("MsgServerSender|try to bind iservice", new java.lang.Object[0]);
        try {
            this.i.set(true);
            if (com.igexin.push.core.e.l == null) {
                com.igexin.push.core.e.l = h;
            }
            android.content.Intent intent = new android.content.Intent(com.igexin.push.core.e.l, (java.lang.Class<?>) com.igexin.push.core.ServiceManager.getInstance().c(com.igexin.push.core.e.l));
            intent.setType(com.igexin.push.core.e.l.getPackageName());
            com.igexin.push.core.e.l.bindService(intent, this, 1);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.e.a(a, "bind iservice error = " + th.toString());
            com.igexin.c.a.c.a.a(th);
            this.i.set(false);
        }
    }

    private void g() {
        android.os.Message obtain = android.os.Message.obtain();
        obtain.what = 2;
        try {
            this.g.send(obtain);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a("MsgServerSender|send clent to iservice error = " + e2.toString(), new java.lang.Object[0]);
            if (e2 instanceof android.os.DeadObjectException) {
                android.os.Message.obtain(this.d.f, 2, 0, 0).sendToTarget();
            }
        }
    }

    private void h() {
        while (!this.b.isEmpty()) {
            android.content.Intent poll = this.b.poll();
            if (poll != null) {
                a(poll);
            }
        }
    }

    private void i() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", com.igexin.sdk.PushConsts.ACTION_NOTIFICATION_ENABLE);
        a(bundle);
    }

    private static java.lang.Class j() {
        return com.igexin.push.core.ServiceManager.getInstance().c(com.igexin.push.core.e.l);
    }

    public final void a(android.os.Bundle bundle) {
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(java.lang.String.valueOf(bundle.getInt("action")));
        intent.putExtras(bundle);
        b(intent);
    }

    public final void a(java.lang.String str) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10013);
        bundle.putString(com.igexin.sdk.PushConsts.KEY_DEVICE_TOKEN, str);
        a(bundle);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_CMD_MSG, new com.igexin.sdk.message.SetTagCmdMessage(str, str2, 10009));
        a(bundle);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_CMD_MSG, new com.igexin.sdk.message.QueryTagCmdMessage(str, str2, str3, 10012));
        a(bundle);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        byte[] msgExtra;
        com.igexin.c.a.c.a.a("startapp|broadcastPayload", new java.lang.Object[0]);
        if (str4 != null) {
            msgExtra = str4.getBytes();
        } else {
            com.igexin.push.core.a.b.d();
            com.igexin.push.extension.mod.PushTaskBean pushTaskBean = com.igexin.push.core.e.ah.get(com.igexin.push.core.a.b.a(str, str2));
            msgExtra = pushTaskBean != null ? pushTaskBean.getMsgExtra() : null;
        }
        if (msgExtra == null) {
            com.igexin.c.a.c.a.a("startapp|broadcast|payload is empty!", new java.lang.Object[0]);
            return;
        }
        new java.lang.String(msgExtra);
        com.igexin.c.a.c.a.a("startapp|broadcast|payload = " + new java.lang.String(msgExtra), new java.lang.Object[0]);
        java.lang.String str5 = com.igexin.push.core.e.a;
        if (str5 != null && str5.equals(str3)) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("action", 10001);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_MESSAGE_DATA, new com.igexin.sdk.message.GTTransmitMessage(str, str2, str2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str, msgExtra));
            a(bundle);
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction(com.igexin.push.core.b.J.concat(java.lang.String.valueOf(str3)));
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putInt("action", 10001);
        bundle2.putString("taskid", str);
        bundle2.putString("messageid", str2);
        bundle2.putString("appid", str3);
        bundle2.putString("payloadid", str2 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + str);
        bundle2.putString(me.leolin.shortcutbadger.impl.NewHtcHomeBadger.PACKAGENAME, com.igexin.push.core.e.g);
        bundle2.putByteArray("payload", msgExtra);
        intent.putExtras(bundle2);
        intent.setPackage(com.igexin.push.core.e.l.getPackageName());
        com.igexin.push.core.e.l.sendBroadcast(intent, com.igexin.push.core.e.ac);
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10012);
        bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_NOTIFICATION_CLICKED, new com.igexin.sdk.message.GTNotificationMessage(str, str2, str3, str4, str5, str6, str7));
        a(bundle);
    }

    public final void b() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10007);
        bundle.putBoolean(com.igexin.sdk.PushConsts.KEY_ONLINE_STATE, com.igexin.push.core.e.u);
        a(bundle);
        try {
            android.content.Intent d = d();
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putInt("action", 10007);
            bundle2.putBoolean(com.igexin.sdk.PushConsts.KEY_ONLINE_STATE, com.igexin.push.core.e.u);
            d.putExtras(bundle2);
            com.igexin.push.core.e.l.sendBroadcast(d, com.igexin.push.core.e.ac);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    public final void b(java.lang.String str, java.lang.String str2) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_CMD_MSG, new com.igexin.sdk.message.BindAliasCmdMessage(str, str2, 10010));
        a(bundle);
    }

    public final void c() {
        com.igexin.c.a.c.a.b(a, "broadcastClientId|" + com.igexin.push.core.e.A);
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10002);
        bundle.putString(com.igexin.sdk.PushConsts.KEY_CLIENT_ID, com.igexin.push.core.e.A);
        a(bundle);
        android.content.Intent d = d();
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putInt("action", 10002);
        bundle2.putString(com.igexin.sdk.PushConsts.KEY_CLIENT_ID, com.igexin.push.core.e.A);
        d.putExtras(bundle2);
        com.igexin.push.core.e.l.sendBroadcast(d, com.igexin.push.core.e.ac);
    }

    public final void c(java.lang.String str, java.lang.String str2) {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("action", 10010);
        bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_CMD_MSG, new com.igexin.sdk.message.UnBindAliasCmdMessage(str, str2, 10011));
        a(bundle);
    }

    @Override // android.os.Handler
    public final void handleMessage(android.os.Message message) {
        int i = message.what;
        super.handleMessage(message);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        com.igexin.c.a.c.a.a("MsgServerSender|remote iservice connected ", new java.lang.Object[0]);
        android.os.Message.obtain(this.d.f, 1, iBinder).sendToTarget();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(android.content.ComponentName componentName) {
        com.igexin.c.a.c.a.a("MsgServerSender|remote iservice disConnected ~~~", new java.lang.Object[0]);
        this.i.set(false);
        this.g = null;
    }
}
