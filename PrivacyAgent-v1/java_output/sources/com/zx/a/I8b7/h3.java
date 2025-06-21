package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class h3 {
    public static final java.util.concurrent.atomic.AtomicBoolean e = new java.util.concurrent.atomic.AtomicBoolean(false);
    public com.zx.module.base.ZXModule a = null;
    public final com.zx.a.I8b7.y0 b;
    public final com.zx.a.I8b7.q2 c;
    public final com.zx.a.I8b7.p2 d;

    public class a implements com.zx.module.context.ContextHolder {
        public final /* synthetic */ android.content.Context a;

        public a(com.zx.a.I8b7.h3 h3Var, android.content.Context context) {
            this.a = context;
        }

        @Override // com.zx.module.context.ContextHolder
        public java.lang.Object getContext() {
            return this.a;
        }
    }

    public class b implements com.zx.module.base.Callback {
        public final /* synthetic */ com.zx.sdk.api.SAIDCallback a;

        public b(com.zx.a.I8b7.h3 h3Var, com.zx.sdk.api.SAIDCallback sAIDCallback) {
            this.a = sAIDCallback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(java.lang.String str) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.a.onFailed(i, jSONObject.optString("msg"));
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r2.a(th);
                com.zx.sdk.api.SAIDCallback sAIDCallback = this.a;
                if (sAIDCallback != null) {
                    sAIDCallback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    public class c implements com.zx.module.base.Callback {
        public final /* synthetic */ com.zx.sdk.api.Callback a;

        public c(com.zx.a.I8b7.h3 h3Var, com.zx.sdk.api.Callback callback) {
            this.a = callback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(java.lang.String str) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.a.onFailed(i, jSONObject.optString("data"));
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r2.a(th);
                com.zx.sdk.api.Callback callback = this.a;
                if (callback != null) {
                    callback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    public class d implements com.zx.module.base.Callback {
        public final /* synthetic */ com.zx.sdk.api.Callback a;

        public d(com.zx.a.I8b7.h3 h3Var, com.zx.sdk.api.Callback callback) {
            this.a = callback;
        }

        @Override // com.zx.module.base.Callback
        public void callback(java.lang.String str) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                int i = jSONObject.getInt("code");
                if (i == 0) {
                    this.a.onSuccess(jSONObject.getString("data"));
                } else {
                    this.a.onFailed(i, jSONObject.optString("data"));
                }
            } catch (java.lang.Throwable th) {
                com.zx.a.I8b7.r2.a(th);
                com.zx.sdk.api.Callback callback = this.a;
                if (callback != null) {
                    callback.onFailed(10000, th.getMessage());
                }
            }
        }
    }

    public static class e {
        public static final com.zx.a.I8b7.h3 a = new com.zx.a.I8b7.h3();
    }

    public h3() {
        com.zx.a.I8b7.y0 y0Var = new com.zx.a.I8b7.y0();
        this.b = y0Var;
        com.zx.a.I8b7.q2 q2Var = new com.zx.a.I8b7.q2();
        this.c = q2Var;
        com.zx.a.I8b7.p2 p2Var = new com.zx.a.I8b7.p2();
        this.d = p2Var;
        y0Var.a("MESSAGE_ON_ZXID_CHANGED", q2Var);
        y0Var.a("MESSAGE_ON_ZXID_RECEIVED", p2Var);
        try {
            a(com.zx.a.I8b7.m3.a);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXModule init failed: "));
        }
    }

    @com.zx.module.annotation.Java2C.Method2C
    public native java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, com.zx.sdk.api.SAIDCallback sAIDCallback) throws com.zx.module.exception.ZXModuleInvokeException, org.json.JSONException;

    public void a() throws com.zx.a.I8b7.i2 {
        try {
            this.a.start();
        } catch (java.lang.Exception e2) {
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("Raised exception in start: ");
            a2.append(e2.getMessage());
            throw new com.zx.a.I8b7.i2(a2.toString(), e2);
        }
    }

    public void a(android.content.Context context) throws com.zx.a.I8b7.i2 {
        try {
            if (e.getAndSet(true)) {
                return;
            }
            this.a = com.zx.a.I8b7.v.a.a.a(context);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("version", "3.3.4.43514");
            this.a.invoke("setSDKVersion", jSONObject.toString());
            this.a.onCreate(new com.zx.a.I8b7.h3.a(this, context));
            this.a.setMessageListener(this.b);
        } catch (java.lang.Exception e2) {
            e.set(false);
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("Raised exception while initializing: ");
            a2.append(e2.getMessage());
            throw new com.zx.a.I8b7.i2(a2.toString(), e2);
        }
    }

    @com.zx.module.annotation.Java2C.Method2C
    public native void a(java.lang.String str, com.zx.sdk.api.Callback callback) throws com.zx.module.exception.ZXModuleInvokeException, org.json.JSONException;

    public void a(java.lang.String str, com.zx.sdk.api.ZXIDListener zXIDListener) throws com.zx.a.I8b7.i2 {
        if (zXIDListener != null) {
            try {
                com.zx.a.I8b7.p2 p2Var = this.d;
                p2Var.getClass();
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.util.LinkedList<com.zx.sdk.api.ZXIDListener> linkedList = p2Var.a.get(str);
                    if (linkedList == null) {
                        linkedList = new java.util.LinkedList<>();
                    }
                    linkedList.add(zXIDListener);
                    p2Var.a.put(str, linkedList);
                }
            } catch (java.lang.Exception e2) {
                com.zx.a.I8b7.r2.a(e2);
                java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("Raised exception while getZXID: nested exception is ");
                a2.append(e2.getMessage());
                throw new com.zx.a.I8b7.i2(a2.toString(), e2);
            }
        }
        a();
    }

    @com.zx.module.annotation.Java2C.Method2C
    public native void a(boolean z) throws com.zx.module.exception.ZXModuleInvokeException, org.json.JSONException;

    @com.zx.module.annotation.Java2C.Method2C
    public native void b(java.lang.String str, com.zx.sdk.api.Callback callback) throws com.zx.module.exception.ZXModuleInvokeException, org.json.JSONException;
}
