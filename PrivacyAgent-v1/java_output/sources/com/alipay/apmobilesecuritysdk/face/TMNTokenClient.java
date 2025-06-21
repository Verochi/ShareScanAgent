package com.alipay.apmobilesecuritysdk.face;

/* loaded from: classes.dex */
public class TMNTokenClient {
    public static com.alipay.apmobilesecuritysdk.face.TMNTokenClient a;
    public android.content.Context b;

    /* renamed from: com.alipay.apmobilesecuritysdk.face.TMNTokenClient$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.util.Map a;
        public final /* synthetic */ com.alipay.apmobilesecuritysdk.face.TMNTokenClient.InitResultListener b;
        public final /* synthetic */ java.lang.String c;

        public AnonymousClass1(java.util.Map map, com.alipay.apmobilesecuritysdk.face.TMNTokenClient.InitResultListener initResultListener, java.lang.String str) {
            this.a = map;
            this.b = initResultListener;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int a = new com.alipay.apmobilesecuritysdk.a.a(com.alipay.apmobilesecuritysdk.face.TMNTokenClient.this.b).a(this.a);
            com.alipay.apmobilesecuritysdk.face.TMNTokenClient.InitResultListener initResultListener = this.b;
            if (initResultListener == null) {
                return;
            }
            if (a != 0) {
                initResultListener.onResult("", a);
            } else {
                this.b.onResult(com.alipay.apmobilesecuritysdk.a.a.a(com.alipay.apmobilesecuritysdk.face.TMNTokenClient.this.b, this.c), 0);
            }
        }
    }

    public interface InitResultListener {
        void onResult(java.lang.String str, int i);
    }

    public TMNTokenClient(android.content.Context context) {
        this.b = null;
        if (context == null) {
            throw new java.lang.IllegalArgumentException("TMNTokenClient initialization error: context is null.");
        }
        this.b = context;
    }

    public static com.alipay.apmobilesecuritysdk.face.TMNTokenClient getInstance(android.content.Context context) {
        if (a == null) {
            synchronized (com.alipay.apmobilesecuritysdk.face.TMNTokenClient.class) {
                if (a == null) {
                    a = new com.alipay.apmobilesecuritysdk.face.TMNTokenClient(context);
                }
            }
        }
        return a;
    }

    public void intiToken(java.lang.String str, java.lang.String str2, java.lang.String str3, com.alipay.apmobilesecuritysdk.face.TMNTokenClient.InitResultListener initResultListener) {
        if (com.alipay.sdk.m.z.a.a(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (com.alipay.sdk.m.z.a.a(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.alipay.sdk.m.l.b.g, com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper.getUtdid(this.b));
        hashMap.put("tid", "");
        hashMap.put("userId", "");
        hashMap.put("appName", str);
        hashMap.put("appKeyClient", str2);
        hashMap.put("appchannel", "openapi");
        hashMap.put("sessionId", str3);
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new com.alipay.apmobilesecuritysdk.face.TMNTokenClient.AnonymousClass1(hashMap, initResultListener, str));
    }
}
