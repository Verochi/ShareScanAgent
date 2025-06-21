package cn.fly.verify;

/* loaded from: classes.dex */
public class ft {
    private static android.os.Handler a;

    /* renamed from: cn.fly.verify.ft$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(android.os.Message message) {
            cn.fly.verify.ft.b(message);
            return false;
        }
    }

    public static final class a {
        public final android.os.Message a;
        public final android.os.Handler.Callback b;

        public a(android.os.Message message, android.os.Handler.Callback callback) {
            this.a = message;
            this.b = callback;
        }
    }

    private static android.os.Message a(android.os.Message message, android.os.Handler.Callback callback) {
        android.os.Message message2 = new android.os.Message();
        message2.obj = new cn.fly.verify.ft.a(message, callback);
        return message2;
    }

    private static synchronized void a() {
        synchronized (cn.fly.verify.ft.class) {
            if (a == null) {
                b();
            }
        }
    }

    public static boolean a(int i, android.os.Handler.Callback callback) {
        a();
        return a.sendMessage(b(i, callback));
    }

    private static android.os.Message b(int i, android.os.Handler.Callback callback) {
        android.os.Message message = new android.os.Message();
        message.what = i;
        return a(message, callback);
    }

    private static void b() {
        a = new android.os.Handler(android.os.Looper.getMainLooper(), new cn.fly.verify.ft.AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(android.os.Message message) {
        cn.fly.verify.ft.a aVar = (cn.fly.verify.ft.a) message.obj;
        android.os.Message message2 = aVar.a;
        android.os.Handler.Callback callback = aVar.b;
        if (callback != null) {
            callback.handleMessage(message2);
        }
    }
}
