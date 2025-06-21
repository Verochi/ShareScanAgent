package com.alipay.apmobilesecuritysdk.face;

/* loaded from: classes.dex */
public class APSecuritySdk {
    public static com.alipay.apmobilesecuritysdk.face.APSecuritySdk a;
    public static java.lang.Object c = new java.lang.Object();
    public android.content.Context b;

    /* renamed from: com.alipay.apmobilesecuritysdk.face.APSecuritySdk$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public final /* synthetic */ java.util.Map a;
        public final /* synthetic */ com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener b;

        public AnonymousClass1(java.util.Map map, com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener initResultListener) {
            this.a = map;
            this.b = initResultListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            new com.alipay.apmobilesecuritysdk.a.a(com.alipay.apmobilesecuritysdk.face.APSecuritySdk.this.b).a(this.a);
            com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener initResultListener = this.b;
            if (initResultListener != null) {
                initResultListener.onResult(com.alipay.apmobilesecuritysdk.face.APSecuritySdk.this.getTokenResult());
            }
        }
    }

    public interface InitResultListener {
        void onResult(com.alipay.apmobilesecuritysdk.face.APSecuritySdk.TokenResult tokenResult);
    }

    public class TokenResult {
        public java.lang.String apdid;
        public java.lang.String apdidToken;
        public java.lang.String clientKey;
        public java.lang.String umidToken;

        public TokenResult() {
        }
    }

    public APSecuritySdk(android.content.Context context) {
        this.b = context;
    }

    public static com.alipay.apmobilesecuritysdk.face.APSecuritySdk getInstance(android.content.Context context) {
        if (a == null) {
            synchronized (c) {
                if (a == null) {
                    a = new com.alipay.apmobilesecuritysdk.face.APSecuritySdk(context);
                }
            }
        }
        return a;
    }

    public static java.lang.String getUtdid(android.content.Context context) {
        return com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper.getUtdid(context);
    }

    public java.lang.String getApdidToken() {
        java.lang.String a2 = com.alipay.apmobilesecuritysdk.a.a.a(this.b, "");
        if (com.alipay.sdk.m.z.a.a(a2)) {
            initToken(0, new java.util.HashMap(), null);
        }
        return a2;
    }

    public java.lang.String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public java.lang.String getSdkVersion() {
        return "3.4.0.202206130311";
    }

    public synchronized com.alipay.apmobilesecuritysdk.face.APSecuritySdk.TokenResult getTokenResult() {
        com.alipay.apmobilesecuritysdk.face.APSecuritySdk.TokenResult tokenResult;
        tokenResult = new com.alipay.apmobilesecuritysdk.face.APSecuritySdk.TokenResult();
        try {
            tokenResult.apdidToken = com.alipay.apmobilesecuritysdk.a.a.a(this.b, "");
            tokenResult.clientKey = com.alipay.apmobilesecuritysdk.e.h.f(this.b);
            tokenResult.apdid = com.alipay.apmobilesecuritysdk.a.a.a(this.b);
            tokenResult.umidToken = com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper.getSecurityToken(this.b);
            if (com.alipay.sdk.m.z.a.a(tokenResult.apdid) || com.alipay.sdk.m.z.a.a(tokenResult.apdidToken) || com.alipay.sdk.m.z.a.a(tokenResult.clientKey)) {
                initToken(0, new java.util.HashMap(), null);
            }
        } catch (java.lang.Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i, java.util.Map<java.lang.String, java.lang.String> map, com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i);
        java.lang.String b = com.alipay.apmobilesecuritysdk.e.h.b(this.b);
        java.lang.String c2 = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (com.alipay.sdk.m.z.a.b(b) && !com.alipay.sdk.m.z.a.a(b, c2)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.b);
            com.alipay.apmobilesecuritysdk.e.d.a(this.b);
            com.alipay.apmobilesecuritysdk.e.g.a(this.b);
            com.alipay.apmobilesecuritysdk.e.i.h();
        }
        if (!com.alipay.sdk.m.z.a.a(b, c2)) {
            com.alipay.apmobilesecuritysdk.e.h.c(this.b, c2);
        }
        java.lang.String a2 = com.alipay.sdk.m.z.a.a(map, com.alipay.sdk.m.l.b.g, "");
        java.lang.String a3 = com.alipay.sdk.m.z.a.a(map, "tid", "");
        java.lang.String a4 = com.alipay.sdk.m.z.a.a(map, "userId", "");
        if (com.alipay.sdk.m.z.a.a(a2)) {
            a2 = com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper.getUtdid(this.b);
        }
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(com.alipay.sdk.m.l.b.g, a2);
        hashMap.put("tid", a3);
        hashMap.put("userId", a4);
        hashMap.put("appName", "");
        hashMap.put("appKeyClient", "");
        hashMap.put("appchannel", "");
        hashMap.put("rpcVersion", "8");
        com.alipay.apmobilesecuritysdk.f.b.a().a(new com.alipay.apmobilesecuritysdk.face.APSecuritySdk.AnonymousClass1(hashMap, initResultListener));
    }
}
