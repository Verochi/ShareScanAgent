package com.igexin.d;

/* loaded from: classes22.dex */
public class a implements java.lang.reflect.InvocationHandler {
    private static java.lang.String b = "ZxExecutor";
    private static volatile com.igexin.d.a c;
    public android.content.Context a;

    /* renamed from: com.igexin.d.a$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (com.igexin.d.a.c(com.igexin.d.a.this.a)) {
                    com.igexin.d.a aVar = com.igexin.d.a.this;
                    com.igexin.d.a.a(aVar, aVar.a);
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.d.a$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ java.lang.String c;

        public AnonymousClass2(android.content.Context context, java.lang.String str, java.lang.String str2) {
            this.a = context;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                java.lang.Class cls = (java.lang.Class) com.igexin.push.h.d.a(this.a, com.igexin.sdk.PushService.class).second;
                if (cls != null) {
                    android.content.Intent intent = new android.content.Intent(this.a, (java.lang.Class<?>) cls);
                    intent.putExtra("action", com.igexin.sdk.PushConsts.ACTION_BROADCAST_UPLOAD_TYPE253);
                    intent.putExtra("id", this.b);
                    intent.putExtra("aid", this.c);
                    com.igexin.push.h.c.a(this.a, intent);
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    private a() {
    }

    public static com.igexin.d.a a() {
        if (c == null) {
            synchronized (com.igexin.d.a.class) {
                if (c == null) {
                    com.igexin.d.a aVar = new com.igexin.d.a();
                    c = aVar;
                    return aVar;
                }
            }
        }
        return c;
    }

    public static /* synthetic */ void a(com.igexin.d.a aVar, android.content.Context context) {
        try {
            java.lang.String str = com.zx.sdk.api.ZXManager.TAG;
            java.lang.Object invoke = com.zx.sdk.api.ZXManager.class.getDeclaredMethod("newSDK", java.lang.String.class).invoke(com.zx.sdk.api.ZXManager.class, com.igexin.push.a.r);
            java.lang.reflect.Method declaredMethod = invoke.getClass().getDeclaredMethod("init", android.content.Context.class);
            java.lang.reflect.Method declaredMethod2 = invoke.getClass().getDeclaredMethod("allowPermissionDialog", java.lang.Boolean.TYPE);
            declaredMethod.invoke(invoke, context);
            declaredMethod2.invoke(invoke, java.lang.Boolean.FALSE);
            invoke.getClass().getDeclaredMethod("getZXID", com.zx.sdk.api.ZXIDListener.class).invoke(invoke, java.lang.reflect.Proxy.newProxyInstance(com.igexin.d.a.class.getClassLoader(), new java.lang.Class[]{com.zx.sdk.api.ZXIDListener.class}, aVar));
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private void a(java.lang.String str, java.lang.String str2, android.content.Context context) {
        com.igexin.b.a.a().a.execute(new com.igexin.d.a.AnonymousClass2(context, str, str2));
    }

    private void b(android.content.Context context) {
        this.a = context.getApplicationContext();
        com.igexin.b.a.a().b().schedule(new com.igexin.d.a.AnonymousClass1(), 2000L, java.util.concurrent.TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(android.content.Context context) {
        com.igexin.push.b.b bVar;
        android.database.Cursor cursor = null;
        try {
            bVar = new com.igexin.push.b.b(context);
        } catch (java.lang.Throwable th) {
            th = th;
            bVar = null;
        }
        try {
            cursor = bVar.a("config", new java.lang.String[]{"value"}, "id = 79");
            if (cursor == null || !cursor.moveToFirst()) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (java.lang.Throwable th2) {
                        com.igexin.c.a.c.a.a(th2);
                    }
                }
                bVar.close();
                return false;
            }
            boolean parseBoolean = java.lang.Boolean.parseBoolean(cursor.getString(0));
            try {
                cursor.close();
                bVar.close();
            } catch (java.lang.Throwable th3) {
                com.igexin.c.a.c.a.a(th3);
            }
            return parseBoolean;
        } catch (java.lang.Throwable th4) {
            th = th4;
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (java.lang.Throwable th5) {
                    com.igexin.c.a.c.a.a(th5);
                    throw th;
                }
            }
            if (bVar != null) {
                bVar.close();
            }
            throw th;
        }
    }

    private void d(android.content.Context context) {
        try {
            java.lang.String str = com.zx.sdk.api.ZXManager.TAG;
            java.lang.Object invoke = com.zx.sdk.api.ZXManager.class.getDeclaredMethod("newSDK", java.lang.String.class).invoke(com.zx.sdk.api.ZXManager.class, com.igexin.push.a.r);
            java.lang.reflect.Method declaredMethod = invoke.getClass().getDeclaredMethod("init", android.content.Context.class);
            java.lang.reflect.Method declaredMethod2 = invoke.getClass().getDeclaredMethod("allowPermissionDialog", java.lang.Boolean.TYPE);
            declaredMethod.invoke(invoke, context);
            declaredMethod2.invoke(invoke, java.lang.Boolean.FALSE);
            invoke.getClass().getDeclaredMethod("getZXID", com.zx.sdk.api.ZXIDListener.class).invoke(invoke, java.lang.reflect.Proxy.newProxyInstance(com.igexin.d.a.class.getClassLoader(), new java.lang.Class[]{com.zx.sdk.api.ZXIDListener.class}, this));
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #0 {all -> 0x009c, blocks: (B:2:0x0000, B:13:0x002f, B:15:0x0038, B:17:0x0045, B:19:0x0059, B:22:0x0082, B:23:0x0088, B:25:0x0015, B:28:0x001f), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    @Override // java.lang.reflect.InvocationHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) {
        char c2;
        try {
            java.lang.String name = method.getName();
            int hashCode = name.hashCode();
            if (hashCode != -530890460) {
                if (hashCode == 1116433148 && name.equals("onFailed")) {
                    c2 = 1;
                    if (c2 != 0) {
                        java.lang.Object obj2 = objArr[0];
                        com.igexin.c.a.c.a.b(b, " get zxid success ".concat(java.lang.String.valueOf(obj2)));
                        org.json.JSONObject jSONObject = (org.json.JSONObject) com.zx.sdk.api.ZXID.class.getDeclaredMethod("getAids", new java.lang.Class[0]).invoke(obj2, new java.lang.Object[0]);
                        com.igexin.b.a.a().a.execute(new com.igexin.d.a.AnonymousClass2(this.a, obj2.toString(), jSONObject instanceof org.json.JSONObject ? jSONObject.optString("venderAid", "") : ""));
                        return null;
                    }
                    if (c2 != 1) {
                        return null;
                    }
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (java.lang.Object obj3 : objArr) {
                        sb.append(obj3);
                        sb.append(",");
                    }
                    com.igexin.c.a.c.a.a("ZxExecutor | ", " get zxid failed code  msg = ".concat(java.lang.String.valueOf(sb)));
                    return null;
                }
                c2 = 65535;
                if (c2 != 0) {
                }
            } else {
                if (name.equals("onSuccess")) {
                    c2 = 0;
                    if (c2 != 0) {
                    }
                }
                c2 = 65535;
                if (c2 != 0) {
                }
            }
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }
}
