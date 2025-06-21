package com.vivo.push.d;

/* loaded from: classes19.dex */
final class u extends com.vivo.push.d.z {
    public u(com.vivo.push.o oVar) {
        super(oVar);
    }

    private void a(com.vivo.push.model.UPSNotificationMessage uPSNotificationMessage) {
        com.vivo.push.m.c(new com.vivo.push.d.w(this, uPSNotificationMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static android.content.Intent b(android.content.Intent intent, java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null && map.entrySet() != null) {
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                if (entry != null && entry.getKey() != null) {
                    intent.putExtra(entry.getKey(), entry.getValue());
                }
            }
        }
        return intent;
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        java.lang.String str;
        android.content.Intent parseUri;
        java.lang.String str2;
        com.vivo.push.b.p pVar = (com.vivo.push.b.p) oVar;
        com.vivo.push.model.InsideNotificationItem f = pVar.f();
        if (f == null) {
            com.vivo.push.util.p.d("OnNotificationClickTask", "current notification item is null");
            return;
        }
        com.vivo.push.model.UPSNotificationMessage a = com.vivo.push.util.q.a(f);
        boolean equals = this.a.getPackageName().equals(pVar.d());
        if (equals) {
            com.vivo.push.util.NotifyAdapterUtil.cancelNotify(this.a);
        }
        if (!equals) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "notify is " + a + " ; isMatch is " + equals);
            return;
        }
        com.vivo.push.b.x xVar = new com.vivo.push.b.x(1030L);
        java.util.HashMap<java.lang.String, java.lang.String> hashMap = new java.util.HashMap<>();
        hashMap.put("type", "2");
        hashMap.put(com.heytap.mcssdk.constant.b.c, java.lang.String.valueOf(pVar.e()));
        hashMap.put("platform", this.a.getPackageName());
        android.content.Context context = this.a;
        java.lang.String b = com.vivo.push.util.z.b(context, context.getPackageName());
        if (!android.text.TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        xVar.a(hashMap);
        com.vivo.push.e.a().a(xVar);
        com.vivo.push.util.p.d("OnNotificationClickTask", "notification is clicked by skip type[" + a.getSkipType() + "]");
        int skipType = a.getSkipType();
        boolean z = true;
        if (skipType == 1) {
            new java.lang.Thread(new com.vivo.push.d.v(this, this.a, a.getParams())).start();
            a(a);
            return;
        }
        if (skipType == 2) {
            java.lang.String skipContent = a.getSkipContent();
            if (!skipContent.startsWith("http://") && !skipContent.startsWith("https://")) {
                z = false;
            }
            if (z) {
                android.net.Uri parse = android.net.Uri.parse(skipContent);
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", parse);
                intent.setFlags(268435456);
                b(intent, a.getParams());
                try {
                    this.a.startActivity(intent);
                } catch (java.lang.Exception unused) {
                    str = "startActivity error : ".concat(java.lang.String.valueOf(parse));
                }
                a(a);
                return;
            }
            str = "url not legal";
            com.vivo.push.util.p.a("OnNotificationClickTask", str);
            a(a);
            return;
        }
        if (skipType == 3) {
            a(a);
            return;
        }
        if (skipType != 4) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "illegitmacy skip type error : " + a.getSkipType());
            return;
        }
        java.lang.String skipContent2 = a.getSkipContent();
        try {
            parseUri = android.content.Intent.parseUri(skipContent2, 1);
            str2 = parseUri.getPackage();
        } catch (java.lang.Exception e) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : ".concat(java.lang.String.valueOf(skipContent2)), e);
        }
        if (!android.text.TextUtils.isEmpty(str2) && !this.a.getPackageName().equals(str2)) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "open activity error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
            return;
        }
        java.lang.String packageName = parseUri.getComponent() == null ? null : parseUri.getComponent().getPackageName();
        if (!android.text.TextUtils.isEmpty(packageName) && !this.a.getPackageName().equals(packageName)) {
            com.vivo.push.util.p.a("OnNotificationClickTask", "open activity component error : local pkgName is " + this.a.getPackageName() + "; but remote pkgName is " + parseUri.getPackage());
            return;
        }
        parseUri.setSelector(null);
        parseUri.setPackage(this.a.getPackageName());
        parseUri.addFlags(335544320);
        b(parseUri, a.getParams());
        android.content.pm.ActivityInfo resolveActivityInfo = parseUri.resolveActivityInfo(this.a.getPackageManager(), 65536);
        if (resolveActivityInfo == null || resolveActivityInfo.exported) {
            this.a.startActivity(parseUri);
            a(a);
        } else {
            com.vivo.push.util.p.a("OnNotificationClickTask", "activity is not exported : " + resolveActivityInfo.toString());
        }
    }
}
