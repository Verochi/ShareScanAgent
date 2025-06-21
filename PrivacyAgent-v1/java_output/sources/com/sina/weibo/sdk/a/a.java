package com.sina.weibo.sdk.a;

/* loaded from: classes19.dex */
public final class a {
    public java.lang.String c = "";

    /* renamed from: com.sina.weibo.sdk.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.weibo.ssosdk.VisitorLoginListener {
        public AnonymousClass1() {
        }

        @Override // com.weibo.ssosdk.VisitorLoginListener
        public final void handler(com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo) {
            if (visitorLoginInfo != null) {
                try {
                    com.sina.weibo.sdk.a.a.this.c = visitorLoginInfo.getAid();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.sina.weibo.sdk.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.weibo.ssosdk.VisitorLoginListener {
        public AnonymousClass2() {
        }

        @Override // com.weibo.ssosdk.VisitorLoginListener
        public final void handler(com.weibo.ssosdk.WeiboSsoSdk.VisitorLoginInfo visitorLoginInfo) {
            if (visitorLoginInfo != null) {
                try {
                    com.sina.weibo.sdk.a.a.this.c = visitorLoginInfo.getAid();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: com.sina.weibo.sdk.a.a$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.sina.weibo.sdk.a.a.this.c = com.weibo.ssosdk.WeiboSsoSdk.getInstance().visitorLogin().getAid();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.sina.weibo.sdk.a.a$a, reason: collision with other inner class name */
    public static class C0464a {
        private static final com.sina.weibo.sdk.a.a e = new com.sina.weibo.sdk.a.a();
    }

    public static void a(android.content.Context context, java.lang.String str) {
        com.weibo.ssosdk.WeiboSsoSdkConfig weiboSsoSdkConfig = new com.weibo.ssosdk.WeiboSsoSdkConfig();
        weiboSsoSdkConfig.setContext(context.getApplicationContext());
        weiboSsoSdkConfig.setAppKey(str);
        weiboSsoSdkConfig.setFrom("1478195010");
        weiboSsoSdkConfig.setWm("1000_0001");
        com.weibo.ssosdk.WeiboSsoSdk.initConfig(weiboSsoSdkConfig);
    }

    public static synchronized com.sina.weibo.sdk.a.a b() {
        com.sina.weibo.sdk.a.a aVar;
        synchronized (com.sina.weibo.sdk.a.a.class) {
            aVar = com.sina.weibo.sdk.a.a.C0464a.e;
        }
        return aVar;
    }

    public final synchronized void b(android.content.Context context, java.lang.String str) {
        a(context, str);
        try {
            com.weibo.ssosdk.WeiboSsoSdk.getInstance().visitorLogin(new com.sina.weibo.sdk.a.a.AnonymousClass1());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public final java.lang.String c(android.content.Context context, java.lang.String str) {
        a(context, str);
        try {
            com.weibo.ssosdk.WeiboSsoSdk.getInstance().visitorLogin(new com.sina.weibo.sdk.a.a.AnonymousClass2());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return this.c;
    }
}
