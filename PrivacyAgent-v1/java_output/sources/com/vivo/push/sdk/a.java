package com.vivo.push.sdk;

/* loaded from: classes19.dex */
public final class a extends com.vivo.push.q {
    private static com.vivo.push.sdk.a c;
    private static final java.util.List<java.lang.Integer> e = java.util.Arrays.asList(3);
    private java.lang.String d;
    private java.lang.String f = "";

    private a() {
    }

    public static synchronized com.vivo.push.sdk.a a() {
        com.vivo.push.sdk.a aVar;
        synchronized (com.vivo.push.sdk.a.class) {
            if (c == null) {
                c = new com.vivo.push.sdk.a();
            }
            aVar = c;
        }
        return aVar;
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers;
        if (android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        android.content.Intent intent = new android.content.Intent(str2);
        intent.setPackage(str);
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (java.lang.Exception e2) {
            com.vivo.push.util.p.a("CommandWorker", "error  " + e2.getMessage());
            return null;
        }
    }

    private boolean b(android.content.Intent intent) {
        java.lang.String stringExtra = intent.getStringExtra("security_avoid_pull");
        if (android.text.TextUtils.isEmpty(stringExtra)) {
            com.vivo.push.util.p.a("CommandWorker", "checkIntentIsSecurityTextUtils.isEmpty");
            return true;
        }
        try {
            java.lang.String b = com.vivo.push.util.a.a(this.a).b(stringExtra);
            if ("com.vivo.pushservice".equals(b)) {
                return true;
            }
            com.vivo.push.util.p.a("CommandWorker", "!decrypt.equals, so decrypt == ".concat(java.lang.String.valueOf(b)));
            return false;
        } catch (java.lang.Exception e2) {
            com.vivo.push.util.p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
            return false;
        }
    }

    private boolean c(android.content.Intent intent) {
        java.lang.String c2 = com.vivo.push.util.z.c(this.a, "com.vivo.pushservice");
        com.vivo.push.util.p.d("CommandWorker", " 配置的验签参数 = ".concat(java.lang.String.valueOf(c2)));
        if (!android.text.TextUtils.equals(c2, "1")) {
            return true;
        }
        java.lang.String stringExtra = intent.getStringExtra("security_avoid_pull_rsa");
        java.lang.String stringExtra2 = intent.getStringExtra("security_avoid_rsa_public_key");
        if (android.text.TextUtils.isEmpty(stringExtra) || android.text.TextUtils.isEmpty(stringExtra2)) {
            com.vivo.push.util.p.a("CommandWorker", "!decrypt.equals, so securityContent == " + stringExtra + " or publickKey isempty ");
            return false;
        }
        try {
            if (com.vivo.push.c.d.a(this.a).a().a("com.vivo.pushservice".getBytes("UTF-8"), com.vivo.push.util.u.a(stringExtra2), android.util.Base64.decode(stringExtra, 2))) {
                com.vivo.push.util.p.d("CommandWorker", " RSA验签通过  ");
                return true;
            }
        } catch (java.lang.Exception e2) {
            com.vivo.push.util.p.a("CommandWorker", "checkIntentIsSecurity Exception: " + e2.getMessage());
        }
        com.vivo.push.util.p.d("CommandWorker", " RSA验签 不通过  ");
        return false;
    }

    private int d(android.content.Intent intent) {
        java.lang.String stringExtra;
        if (!android.text.TextUtils.isEmpty(this.f) && this.f.contains("CommandService")) {
            if (!(intent != null && b(intent) && c(intent))) {
                com.vivo.push.util.p.a("CommandWorker", " !checkIntentIsSecurity(intent)");
                return 2151;
            }
        }
        java.lang.String packageName = this.a.getPackageName();
        try {
            stringExtra = intent.getStringExtra("command_type");
        } catch (java.lang.Exception e2) {
            com.vivo.push.util.p.a("CommandWorker", e2);
        }
        if (!android.text.TextUtils.isEmpty(stringExtra) && stringExtra.equals("reflect_receiver")) {
            int intExtra = intent.getIntExtra(com.heytap.mcssdk.constant.b.y, -1);
            if (intExtra < 0) {
                intExtra = intent.getIntExtra("method", -1);
            }
            if (e.contains(java.lang.Integer.valueOf(intExtra)) && com.vivo.push.util.t.c(this.a, packageName) && !com.vivo.push.util.t.c(this.a)) {
                com.vivo.push.util.p.a("CommandWorker", "METHOD_ON_MESSAGE is not support");
                return 2153;
            }
            java.lang.String action = intent.getAction();
            if (android.text.TextUtils.isEmpty(this.d)) {
                java.lang.String a = a(this.a, packageName, action);
                this.d = a;
                if (android.text.TextUtils.isEmpty(a)) {
                    com.vivo.push.util.p.d("CommandWorker", " reflectReceiver error: receiver for: " + action + " not found, package: " + packageName);
                    intent.setPackage(packageName);
                    this.a.sendBroadcast(intent);
                    return 2152;
                }
            }
            return 0;
        }
        com.vivo.push.util.p.a("CommandWorker", "commandTypeStr is not satisfy == ".concat(java.lang.String.valueOf(stringExtra)));
        return 2151;
    }

    public final void a(android.content.Intent intent) {
        if (intent != null && this.a != null) {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.obj = intent;
            a(obtain);
        } else {
            com.vivo.push.util.p.d("CommandWorker", " sendMessage error: intent : " + intent + ", mContext: " + this.a);
        }
    }

    public final void a(java.lang.String str) {
        this.f = str;
    }

    public final void b() {
        this.d = null;
    }

    @Override // com.vivo.push.q
    public final void b(android.os.Message message) {
        android.content.Context context;
        android.content.Intent intent = (android.content.Intent) message.obj;
        if (intent == null || (context = this.a) == null) {
            com.vivo.push.util.p.d("CommandWorker", " handleMessage error: intent : " + intent + ", mContext: " + this.a);
            return;
        }
        java.lang.String packageName = context.getPackageName();
        int d = d(intent);
        if (d <= 0) {
            try {
                java.lang.Class<?> cls = java.lang.Class.forName(this.d);
                java.lang.Object newInstance = cls.getConstructor(new java.lang.Class[0]).newInstance(new java.lang.Object[0]);
                java.lang.reflect.Method method = cls.getMethod("onReceive", android.content.Context.class, android.content.Intent.class);
                intent.setClassName(packageName, this.d);
                method.invoke(newInstance, com.vivo.push.util.ContextDelegate.getContext(this.a).getApplicationContext(), intent);
                return;
            } catch (java.lang.Exception e2) {
                com.vivo.push.util.p.b("CommandWorker", "reflect e: ", e2);
                return;
            }
        }
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(d);
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        android.os.Bundle extras = intent.getExtras();
        hashMap.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(extras != null ? extras.getLong("notify_id", 404000044642424832L) : 404000044642424832L));
        java.lang.String b = com.vivo.push.util.z.b(this.a, packageName);
        if (!android.text.TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        xVar.a(hashMap);
        com.vivo.push.e.a().a(xVar);
    }
}
