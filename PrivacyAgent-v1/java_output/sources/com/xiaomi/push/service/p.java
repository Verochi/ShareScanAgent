package com.xiaomi.push.service;

/* loaded from: classes19.dex */
public final class p {
    public static long a;
    private static final java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.hh>> b = new java.util.LinkedList<>();
    private static java.util.concurrent.ExecutorService c = java.util.concurrent.Executors.newCachedThreadPool();
    private static volatile com.xiaomi.push.service.w d;

    public static class a implements java.util.concurrent.Callable<android.graphics.Bitmap> {
        private java.lang.String a;
        private android.content.Context b;
        private boolean c;

        public a(java.lang.String str, android.content.Context context, boolean z) {
            this.b = context;
            this.a = str;
            this.c = z;
        }

        @Override // java.util.concurrent.Callable
        public final /* synthetic */ android.graphics.Bitmap call() {
            if (android.text.TextUtils.isEmpty(this.a)) {
                com.xiaomi.channel.commonutils.logger.b.a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.a.startsWith(com.alipay.sdk.m.l.a.q)) {
                return com.xiaomi.push.service.z.a(this.b, this.a, this.c).a;
            }
            android.graphics.Bitmap a = com.xiaomi.push.service.z.a(this.b, this.a);
            if (a != null) {
                return a;
            }
            com.xiaomi.channel.commonutils.logger.b.a("Failed get online picture/icon resource");
            return a;
        }
    }

    public static class b {
        android.app.Notification a;
        long b = 0;
    }

    public static class c {
        public java.lang.String a;
        public long b = 0;
        public boolean c = false;
    }

    private static int a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, com.anythink.expressad.foundation.h.i.c, str);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.app.PendingIntent a(android.content.Context context, com.xiaomi.push.hh hhVar, java.lang.String str, byte[] bArr, int i, int i2, boolean z) {
        android.content.Intent intent;
        java.lang.String protocol;
        int i3 = d(hhVar) ? 1000 : b(hhVar) ? 3000 : -1;
        com.xiaomi.push.gx gxVar = hhVar.h;
        java.lang.String str2 = gxVar != null ? gxVar.a : "";
        boolean b2 = b(hhVar);
        if (gxVar == null || android.text.TextUtils.isEmpty(gxVar.g)) {
            if (b2) {
                intent = new android.content.Intent();
                intent.setComponent(new android.content.ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            } else {
                intent = new android.content.Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
                intent.setComponent(new android.content.ComponentName(str, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            }
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(java.lang.String.valueOf(i));
            intent.addCategory(java.lang.String.valueOf(str2));
            intent.putExtra("notification_click_button", i2);
            intent.putExtra("messageId", str2);
            intent.putExtra("eventMessageType", i3);
            if (b2 || !z) {
                a(context, intent, hhVar, gxVar, str2, i2);
                return android.os.Build.VERSION.SDK_INT >= 31 ? android.app.PendingIntent.getService(context, 0, intent, 167772160) : android.app.PendingIntent.getService(context, 0, intent, 134217728);
            }
            android.content.Intent intent2 = new android.content.Intent();
            intent2.setComponent(a(str));
            intent2.addFlags(276824064);
            intent2.putExtra("mipush_serviceIntent", intent);
            intent2.addCategory(java.lang.String.valueOf(i));
            intent2.addCategory(java.lang.String.valueOf(str2));
            intent2.addCategory(java.lang.String.valueOf(i2));
            a(context, intent2, hhVar, gxVar, str2, i2);
            try {
                java.lang.reflect.Method declaredMethod = intent2.getClass().getDeclaredMethod("addMiuiFlags", java.lang.Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(intent2, 2);
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("insert flags error ".concat(java.lang.String.valueOf(e)));
            }
            return android.os.Build.VERSION.SDK_INT >= 31 ? android.app.PendingIntent.getActivity(context, 0, intent2, 167772160) : android.app.PendingIntent.getActivity(context, 0, intent2, 134217728);
        }
        android.content.Intent intent3 = new android.content.Intent("android.intent.action.VIEW");
        intent3.setData(android.net.Uri.parse(gxVar.g));
        try {
            protocol = new java.net.URL(gxVar.g).getProtocol();
        } catch (java.net.MalformedURLException unused) {
            com.xiaomi.channel.commonutils.logger.b.a("meet URL exception : " + gxVar.g);
            intent3.setPackage(str);
        }
        if (!com.alipay.sdk.m.l.a.q.equals(protocol) && !"https".equals(protocol)) {
            intent3.setPackage(str);
            intent3.addFlags(268435456);
            intent3.putExtra("messageId", str2);
            intent3.putExtra("eventMessageType", i3);
            return android.os.Build.VERSION.SDK_INT < 31 ? android.app.PendingIntent.getActivity(context, 0, intent3, 167772160) : android.app.PendingIntent.getActivity(context, 0, intent3, 134217728);
        }
        com.xiaomi.push.service.ab.a(context, str, intent3);
        intent3.addFlags(268435456);
        intent3.putExtra("messageId", str2);
        intent3.putExtra("eventMessageType", i3);
        if (android.os.Build.VERSION.SDK_INT < 31) {
        }
    }

    private static android.app.PendingIntent a(android.content.Context context, java.lang.String str, com.xiaomi.push.hh hhVar, byte[] bArr, int i, int i2) {
        java.util.Map<java.lang.String, java.lang.String> map = hhVar.h.j;
        if (map == null) {
            return null;
        }
        boolean a2 = a(context, hhVar, str);
        if (a2) {
            return a(context, hhVar, str, bArr, i, i2, a2);
        }
        android.content.Intent c2 = c(context, str, map, i2);
        if (c2 != null) {
            return android.app.PendingIntent.getActivity(context, 0, c2, android.os.Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
        }
        return null;
    }

    private static android.content.ComponentName a(java.lang.String str) {
        return new android.content.ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0137  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.content.Intent a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i) {
        android.content.Intent launchIntentForPackage;
        java.lang.String str2;
        android.content.Intent intent;
        android.content.Intent intent2;
        if (map == null) {
            return null;
        }
        if (i != 0) {
            return c(context, str, map, i);
        }
        if (!map.containsKey("notify_effect")) {
            return null;
        }
        java.lang.String str3 = map.get("notify_effect");
        java.lang.String str4 = map.get("intent_flag");
        int i2 = -1;
        try {
            if (!android.text.TextUtils.isEmpty(str4)) {
                i2 = java.lang.Integer.parseInt(str4);
            }
        } catch (java.lang.NumberFormatException e) {
            com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e.getMessage());
        }
        if (com.xiaomi.push.service.an.a.equals(str3)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (java.lang.Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
            }
        } else {
            if (com.xiaomi.push.service.an.b.equals(str3)) {
                if (map.containsKey("intent_uri")) {
                    java.lang.String str5 = map.get("intent_uri");
                    if (str5 != null) {
                        try {
                            intent2 = android.content.Intent.parseUri(str5, 1);
                            try {
                                intent2.setPackage(str);
                            } catch (java.net.URISyntaxException e3) {
                                e = e3;
                                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                launchIntentForPackage = intent2;
                                if (launchIntentForPackage != null) {
                                }
                                return null;
                            }
                        } catch (java.net.URISyntaxException e4) {
                            e = e4;
                            intent2 = null;
                        }
                        launchIntentForPackage = intent2;
                    }
                } else if (map.containsKey("class_name")) {
                    java.lang.String str6 = map.get("class_name");
                    intent = new android.content.Intent();
                    intent.setComponent(new android.content.ComponentName(str, str6));
                }
                launchIntentForPackage = null;
            } else {
                if (com.xiaomi.push.service.an.c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                    java.lang.String trim = str2.trim();
                    if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                        trim = "http://".concat(trim);
                    }
                    try {
                        java.lang.String protocol = new java.net.URL(trim).getProtocol();
                        if (com.alipay.sdk.m.l.a.q.equals(protocol) || "https".equals(protocol)) {
                            intent = new android.content.Intent("android.intent.action.VIEW");
                            try {
                                intent.setData(android.net.Uri.parse(trim));
                                com.xiaomi.push.service.ab.a(context, str, intent);
                            } catch (java.net.MalformedURLException e5) {
                                e = e5;
                                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                launchIntentForPackage = intent;
                                if (launchIntentForPackage != null) {
                                }
                                return null;
                            }
                        }
                    } catch (java.net.MalformedURLException e6) {
                        e = e6;
                        intent = null;
                    }
                }
                launchIntentForPackage = null;
            }
            launchIntentForPackage = intent;
        }
        if (launchIntentForPackage != null) {
            if (i2 >= 0) {
                launchIntentForPackage.setFlags(i2);
            }
            launchIntentForPackage.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (android.os.Build.VERSION.SDK_INT >= 30 && !com.xiaomi.push.iu.a(context) && com.xiaomi.push.service.an.c.equals(str3)) {
                    return launchIntentForPackage;
                }
                com.xiaomi.channel.commonutils.logger.b.a("not resolve activity:".concat(java.lang.String.valueOf(launchIntentForPackage)));
            } catch (java.lang.Exception e7) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e7.getMessage());
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static android.content.Intent a(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        android.content.Intent launchIntentForPackage;
        android.content.Intent intent;
        android.content.Intent intent2;
        java.lang.String str6 = map.get(str2);
        if (android.text.TextUtils.isEmpty(str6)) {
            return null;
        }
        if (com.xiaomi.push.service.an.a.equals(str6)) {
            try {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (java.lang.Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
            }
        } else {
            if (com.xiaomi.push.service.an.b.equals(str6)) {
                if (map.containsKey(str3)) {
                    java.lang.String str7 = map.get(str3);
                    if (str7 != null) {
                        try {
                            intent2 = android.content.Intent.parseUri(str7, 1);
                        } catch (java.net.URISyntaxException e2) {
                            e = e2;
                            intent2 = null;
                        }
                        try {
                            intent2.setPackage(str);
                        } catch (java.net.URISyntaxException e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                            launchIntentForPackage = intent2;
                            if (launchIntentForPackage != null) {
                            }
                            return null;
                        }
                        launchIntentForPackage = intent2;
                    }
                } else if (map.containsKey(str4)) {
                    java.lang.String str8 = map.get(str4);
                    intent = new android.content.Intent();
                    intent.setComponent(new android.content.ComponentName(str, str8));
                }
                launchIntentForPackage = null;
            } else {
                if (com.xiaomi.push.service.an.c.equals(str6)) {
                    java.lang.String str9 = map.get(str5);
                    if (!android.text.TextUtils.isEmpty(str9)) {
                        java.lang.String trim = str9.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://".concat(trim);
                        }
                        try {
                            java.lang.String protocol = new java.net.URL(trim).getProtocol();
                            if (com.alipay.sdk.m.l.a.q.equals(protocol) || "https".equals(protocol)) {
                                intent = new android.content.Intent("android.intent.action.VIEW");
                                try {
                                    intent.setData(android.net.Uri.parse(trim));
                                    com.xiaomi.push.service.ab.a(context, str, intent);
                                } catch (java.net.MalformedURLException e4) {
                                    e = e4;
                                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                    launchIntentForPackage = intent;
                                    if (launchIntentForPackage != null) {
                                    }
                                    return null;
                                }
                            }
                        } catch (java.net.MalformedURLException e5) {
                            e = e5;
                            intent = null;
                        }
                    }
                }
                launchIntentForPackage = null;
            }
            launchIntentForPackage = intent;
        }
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                    return launchIntentForPackage;
                }
                if (android.os.Build.VERSION.SDK_INT >= 30 && !com.xiaomi.push.iu.a(context) && com.xiaomi.push.service.an.c.equals(str6)) {
                    return launchIntentForPackage;
                }
                com.xiaomi.channel.commonutils.logger.b.a("not resolve activity:" + launchIntentForPackage + "for buttons");
            } catch (java.lang.Exception e6) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e6.getMessage());
            }
        }
        return null;
    }

    public static android.graphics.Bitmap a(android.graphics.drawable.Drawable drawable) {
        if (drawable instanceof android.graphics.drawable.BitmapDrawable) {
            return ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private static android.widget.RemoteViews a(android.content.Context context, com.xiaomi.push.hh hhVar) {
        java.util.Map<java.lang.String, java.lang.String> map;
        com.xiaomi.push.gx gxVar = hhVar.h;
        java.lang.String a2 = a(hhVar);
        if (gxVar != null && (map = gxVar.j) != null) {
            java.lang.String str = map.get("layout_name");
            java.lang.String str2 = map.get("layout_value");
            if (!android.text.TextUtils.isEmpty(str) && !android.text.TextUtils.isEmpty(str2)) {
                try {
                    android.content.res.Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", a2);
                    if (identifier == 0) {
                        return null;
                    }
                    android.widget.RemoteViews remoteViews = new android.widget.RemoteViews(a2, identifier);
                    try {
                        org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
                        if (jSONObject.has("text")) {
                            org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            java.util.Iterator<java.lang.String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                java.lang.String next = keys.next();
                                java.lang.String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", a2);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has("image")) {
                            org.json.JSONObject jSONObject3 = jSONObject.getJSONObject("image");
                            java.util.Iterator<java.lang.String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                java.lang.String next2 = keys2.next();
                                java.lang.String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a2);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, com.anythink.expressad.foundation.h.i.c, a2);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            org.json.JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            java.util.Iterator<java.lang.String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                java.lang.String next3 = keys3.next();
                                java.lang.String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a2);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new java.text.SimpleDateFormat(string3).format(new java.util.Date(java.lang.System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (org.json.JSONException e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                        return null;
                    }
                } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x007d, code lost:
    
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007b, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0059, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x052c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x06cf  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0741  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0421  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x04cf  */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v20 */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.xiaomi.push.service.p.b a(android.content.Context context, com.xiaomi.push.hh hhVar, byte[] bArr, android.widget.RemoteViews remoteViews, android.app.PendingIntent pendingIntent, int i) {
        java.lang.Object obj;
        java.lang.String str;
        java.lang.String str2;
        com.xiaomi.push.gx gxVar;
        java.lang.String str3;
        com.xiaomi.push.dr drVar;
        com.xiaomi.push.dr drVar2;
        java.util.Map<java.lang.String, java.lang.String> map;
        java.lang.String str4;
        java.lang.String a2;
        int a3;
        boolean z;
        android.graphics.drawable.Icon createWithResource;
        int a4;
        int i2;
        java.lang.String a5;
        boolean z2;
        android.graphics.Bitmap b2;
        java.lang.String str5;
        boolean z3;
        boolean z4;
        long currentTimeMillis;
        com.xiaomi.push.service.p.b bVar;
        com.xiaomi.push.gx gxVar2;
        int i3;
        java.lang.Object a6;
        int i4;
        char c2;
        boolean z5;
        android.graphics.Bitmap a7;
        int i5;
        java.lang.Object b3;
        java.lang.StringBuilder sb;
        java.lang.String a8;
        java.lang.CharSequence charSequence;
        com.xiaomi.push.service.p.b bVar2 = new com.xiaomi.push.service.p.b();
        com.xiaomi.push.gx gxVar3 = hhVar.h;
        java.lang.String a9 = a(hhVar);
        java.util.Map<java.lang.String, java.lang.String> map2 = gxVar3.j;
        java.lang.CharSequence charSequence2 = gxVar3.d;
        java.lang.CharSequence charSequence3 = gxVar3.e;
        if (map2 != null) {
            int intValue = java.lang.Float.valueOf((context.getResources().getDisplayMetrics().widthPixels / context.getResources().getDisplayMetrics().density) + 0.5f).intValue();
            if (intValue <= 320) {
                java.lang.CharSequence charSequence4 = (java.lang.String) map2.get("title_short");
                if (!android.text.TextUtils.isEmpty(charSequence4)) {
                    charSequence2 = charSequence4;
                }
                charSequence = (java.lang.String) map2.get("description_short");
            } else if (intValue > 360) {
                java.lang.CharSequence charSequence5 = (java.lang.String) map2.get("title_long");
                if (!android.text.TextUtils.isEmpty(charSequence5)) {
                    charSequence2 = charSequence5;
                }
                charSequence = (java.lang.String) map2.get("description_long");
            }
        }
        java.lang.CharSequence[] charSequenceArr = {charSequence2, charSequence3};
        if (remoteViews == null) {
            if (map2 == null || !map2.containsKey("notification_style_type")) {
                obj = "notification_style_type";
                str = "4";
                str2 = "3";
                gxVar = gxVar3;
                str3 = null;
                drVar = new com.xiaomi.push.dr(context);
            } else {
                java.lang.CharSequence charSequence6 = charSequenceArr[1];
                java.lang.String a10 = a(hhVar);
                java.util.Map<java.lang.String, java.lang.String> map3 = hhVar.h.j;
                java.lang.String str6 = map3.get("notification_style_type");
                com.xiaomi.push.dr b4 = (!com.xiaomi.push.iu.a(context) || d == null) ? null : d.b();
                if (b4 != null) {
                    b4.a(map3);
                    drVar = b4;
                } else if ("2".equals(str6)) {
                    drVar = new com.xiaomi.push.dr(context);
                    android.graphics.Bitmap b5 = android.text.TextUtils.isEmpty(map3.get("notification_bigPic_uri")) ? null : b(context, map3.get("notification_bigPic_uri"), false);
                    if (b5 == null) {
                        com.xiaomi.channel.commonutils.logger.b.a("can not get big picture.");
                        str4 = null;
                    } else {
                        android.app.Notification.BigPictureStyle bigPictureStyle = new android.app.Notification.BigPictureStyle(drVar);
                        bigPictureStyle.bigPicture(b5);
                        bigPictureStyle.setSummaryText(charSequence6);
                        str4 = null;
                        bigPictureStyle.bigLargeIcon((android.graphics.Bitmap) null);
                        drVar.setStyle(bigPictureStyle);
                    }
                    str3 = str4;
                    obj = "notification_style_type";
                    str = "4";
                    str2 = "3";
                    gxVar = gxVar3;
                } else if ("1".equals(str6)) {
                    drVar = new com.xiaomi.push.dr(context);
                    drVar.setStyle(new android.app.Notification.BigTextStyle().bigText(charSequence6));
                } else if ("4".equals(str6) && com.xiaomi.push.iu.a()) {
                    com.xiaomi.push.dq dqVar = new com.xiaomi.push.dq(context, a10);
                    if (!android.text.TextUtils.isEmpty(map3.get("notification_banner_image_uri"))) {
                        android.graphics.Bitmap b6 = b(context, map3.get("notification_banner_image_uri"), false);
                        if (dqVar.e && b6 != null) {
                            if (b6.getWidth() != 984 || 184 > b6.getHeight() || b6.getHeight() > 1678) {
                                com.xiaomi.channel.commonutils.logger.b.a("colorful notification banner image resolution error, must belong to [984*184, 984*1678]");
                            } else {
                                dqVar.a = b6;
                            }
                        }
                    }
                    if (!android.text.TextUtils.isEmpty(map3.get("notification_banner_icon_uri"))) {
                        android.graphics.Bitmap b7 = b(context, map3.get("notification_banner_icon_uri"), false);
                        if (dqVar.e && b7 != null) {
                            dqVar.b = b7;
                        }
                    }
                    dqVar.a(map3);
                    drVar = dqVar;
                } else {
                    if ("3".equals(str6) && com.xiaomi.push.iu.a()) {
                        com.xiaomi.push.ds dsVar = new com.xiaomi.push.ds(context, i, a10);
                        if (android.text.TextUtils.isEmpty(map3.get("notification_colorful_button_text"))) {
                            obj = "notification_style_type";
                            str = "4";
                            str2 = "3";
                            gxVar = gxVar3;
                            str3 = null;
                            map = map3;
                        } else {
                            str3 = null;
                            obj = "notification_style_type";
                            str = "4";
                            str2 = "3";
                            gxVar = gxVar3;
                            map = map3;
                            android.app.PendingIntent a11 = a(context, a10, hhVar, bArr, i, 4);
                            if (a11 != null) {
                                dsVar.a(map.get("notification_colorful_button_text"), a11).b(map.get("notification_colorful_button_bg_color"));
                            }
                        }
                        if (!android.text.TextUtils.isEmpty(map.get("notification_colorful_bg_color"))) {
                            dsVar.c(map.get("notification_colorful_bg_color"));
                        } else if (!android.text.TextUtils.isEmpty(map.get("notification_colorful_bg_image_uri"))) {
                            android.graphics.Bitmap b8 = b(context, map.get("notification_colorful_bg_image_uri"), false);
                            if (dsVar.e && b8 != null) {
                                if (b8.getWidth() != 984 || b8.getHeight() < 177 || b8.getHeight() > 207) {
                                    com.xiaomi.channel.commonutils.logger.b.a("colorful notification bg image resolution error, must [984*177, 984*207]");
                                } else {
                                    dsVar.a = b8;
                                }
                            }
                        }
                        dsVar.a(map);
                        drVar2 = dsVar;
                    } else {
                        obj = "notification_style_type";
                        str = "4";
                        str2 = "3";
                        gxVar = gxVar3;
                        str3 = null;
                        drVar2 = new com.xiaomi.push.dr(context);
                    }
                    drVar = drVar2;
                }
            }
            com.xiaomi.push.dr drVar3 = drVar;
            a(drVar3, context, hhVar.f, hhVar, bArr, i);
            drVar3.setContentTitle(charSequenceArr[0]);
            drVar3.setContentText(charSequenceArr[1]);
            long currentTimeMillis2 = java.lang.System.currentTimeMillis();
            drVar3.setWhen(currentTimeMillis2);
            a2 = a(map2, "notification_show_when");
            if (android.text.TextUtils.isEmpty(a2)) {
                drVar3.setShowWhen(java.lang.Boolean.parseBoolean(a2));
            } else if (android.os.Build.VERSION.SDK_INT >= 24) {
                drVar3.setShowWhen(true);
            }
            drVar3.setContentIntent(pendingIntent);
            a3 = a(context, a9, "mipush_notification");
            int a12 = a(context, a9, "mipush_small_notification");
            if (a3 > 0 || a12 <= 0) {
                if (!com.xiaomi.push.iu.a(context)) {
                    java.lang.String a13 = a(map2, "fcm_icon_uri");
                    java.lang.String a14 = a(map2, "fcm_icon_color");
                    if (!android.text.TextUtils.isEmpty(a13) && !android.text.TextUtils.isEmpty(a14) && (a4 = a(context, a9, a13)) > 0) {
                        drVar3.setSmallIcon(a4);
                        drVar3.a(a14);
                        z = true;
                        if (!z) {
                            if (android.os.Build.VERSION.SDK_INT >= 23) {
                                createWithResource = android.graphics.drawable.Icon.createWithResource(a9, com.xiaomi.push.service.ab.a(context, a9));
                                drVar3.setSmallIcon(createWithResource);
                            } else {
                                int a15 = a(context, a9, "mipush_notification");
                                int a16 = a(context, a9, "mipush_small_notification");
                                if (a15 <= 0) {
                                    a15 = a16 > 0 ? a16 : context.getApplicationInfo().icon;
                                }
                                if (a15 == 0) {
                                    a15 = context.getApplicationInfo().logo;
                                }
                                drVar3.setSmallIcon(a15);
                            }
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            } else {
                drVar3.setLargeIcon(a(context.getResources().getDrawable(a3)));
                drVar3.setSmallIcon(a12);
            }
            i2 = android.os.Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                if (map2 == null) {
                    b3 = str3;
                    i5 = 1;
                } else {
                    i5 = 1;
                    b3 = b(context, map2.get("notification_small_icon_uri"), true);
                }
                if (b3 != null) {
                    java.lang.Object[] objArr = new java.lang.Object[i5];
                    objArr[0] = b3;
                    java.lang.Object a17 = com.xiaomi.push.aj.a("android.graphics.drawable.Icon", "createWithBitmap", objArr);
                    if (a17 != null) {
                        java.lang.Object[] objArr2 = new java.lang.Object[i5];
                        objArr2[0] = a17;
                        com.xiaomi.push.aj.a((java.lang.Object) drVar3, "setSmallIcon", objArr2);
                        android.os.Bundle bundle = new android.os.Bundle();
                        bundle.putBoolean("miui.isGrayscaleIcon", i5);
                        drVar3.addExtras(bundle);
                        drVar3.a(a(map2, "notification_small_icon_color"));
                    } else {
                        sb = new java.lang.StringBuilder("failed te get small icon with url:");
                        a8 = map2.get("notification_small_icon_uri");
                    }
                } else {
                    sb = new java.lang.StringBuilder("failed to get small icon url:");
                    a8 = a(map2, "notification_small_icon_uri");
                }
                sb.append(a8);
                com.xiaomi.channel.commonutils.logger.b.a(sb.toString());
                drVar3.a(a(map2, "notification_small_icon_color"));
            }
            a5 = a(map2, "__dynamic_icon_uri");
            boolean z6 = (java.lang.Boolean.parseBoolean(a(map2, "__adiom")) && com.xiaomi.push.iu.a()) ? false : true;
            if (!android.text.TextUtils.isEmpty(a5) && z6) {
                if (a5.startsWith(com.alipay.sdk.m.l.a.q)) {
                    a7 = com.xiaomi.push.service.z.a(context, a5);
                } else {
                    com.xiaomi.push.service.z.b a18 = com.xiaomi.push.service.z.a(context, a5, true);
                    a7 = a18.a;
                    bVar2.b = a18.b;
                }
                if (a7 != null) {
                    drVar3.setLargeIcon(a7);
                    z2 = true;
                    b2 = map2 == null ? str3 : b(context, map2.get("notification_large_icon_uri"), true);
                    if (b2 != null) {
                        drVar3.setLargeIcon(b2);
                    }
                    if (map2 != null || i2 < 24) {
                        str5 = str3;
                        z3 = false;
                        z4 = false;
                    } else {
                        str5 = map2.get("notification_group");
                        boolean parseBoolean = java.lang.Boolean.parseBoolean(map2.get("notification_is_summary"));
                        boolean parseBoolean2 = java.lang.Boolean.parseBoolean(map2.get("notification_group_disable_default"));
                        if (android.text.TextUtils.isEmpty(str5) && (com.xiaomi.push.iu.a() || !parseBoolean2)) {
                            str5 = a(hhVar);
                        }
                        com.xiaomi.push.aj.a((java.lang.Object) drVar3, "setGroupSummary", java.lang.Boolean.valueOf(parseBoolean));
                        java.lang.String str7 = map2.get(obj);
                        if ("com.xiaomi.xmsf".equals(context.getPackageName()) && (str.equals(str7) || str2.equals(str7))) {
                            str5 = a(hhVar) + "_custom_" + currentTimeMillis2;
                            z4 = parseBoolean;
                            z3 = true;
                        } else {
                            z4 = parseBoolean;
                            z3 = false;
                        }
                    }
                    drVar3.setAutoCancel(true);
                    currentTimeMillis = java.lang.System.currentTimeMillis();
                    if (map2 != null && map2.containsKey(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TICKER)) {
                        drVar3.setTicker(map2.get(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TICKER));
                    }
                    if (currentTimeMillis - a > 10000) {
                        a = currentTimeMillis;
                        gxVar2 = gxVar;
                        i3 = gxVar2.f;
                        if (e(context, a9)) {
                            i3 = context.getSharedPreferences("pref_notify_type", 0).getInt(a9, Integer.MAX_VALUE);
                        }
                        drVar3.setDefaults(i3);
                        if (map2 != null && (i3 & 1) != 0) {
                            java.lang.String str8 = map2.get("sound_uri");
                            if (!android.text.TextUtils.isEmpty(str8)) {
                                bVar = bVar2;
                                if (str8.startsWith("android.resource://".concat(java.lang.String.valueOf(a9)))) {
                                    drVar3.setDefaults(i3 ^ 1);
                                    drVar3.setSound(android.net.Uri.parse(str8));
                                }
                            }
                        }
                        bVar = bVar2;
                    } else {
                        bVar = bVar2;
                        gxVar2 = gxVar;
                        i3 = -100;
                    }
                    if (map2 == null && i2 >= 26) {
                        com.xiaomi.push.service.aa a19 = com.xiaomi.push.service.aa.a(context, a9);
                        if (c(map2) > 0) {
                            com.xiaomi.push.aj.a((java.lang.Object) drVar3, "setTimeoutAfter", java.lang.Long.valueOf(r0 * 1000));
                        }
                        com.xiaomi.push.service.x.a(gxVar2);
                        java.lang.String str9 = map2.get("channel_id");
                        if (!android.text.TextUtils.isEmpty(str9) || context.getApplicationInfo().targetSdkVersion >= 26) {
                            java.lang.String e = !android.text.TextUtils.isEmpty(map2.get("channel_name")) ? map2.get("channel_name") : com.xiaomi.push.ga.e(context, a9);
                            int d2 = d(map2);
                            int i6 = gxVar2.f;
                            java.lang.String str10 = map2.get("channel_description");
                            java.lang.String str11 = map2.get("sound_uri");
                            java.lang.String str12 = map2.get("channel_perm");
                            if (com.xiaomi.push.iu.a(context)) {
                                java.lang.String str13 = map2.get("notification_top_repeat");
                                if (android.text.TextUtils.isEmpty(str13)) {
                                    z5 = false;
                                } else {
                                    z5 = java.lang.Boolean.parseBoolean(str13);
                                    com.xiaomi.channel.commonutils.logger.b.c("top notification' repeat is ".concat(java.lang.String.valueOf(z5)));
                                }
                                if (z5) {
                                    int max = java.lang.Math.max(0, com.xiaomi.push.jd.a(map2.get("notification_top_period"), 0));
                                    int max2 = java.lang.Math.max(0, com.xiaomi.push.jd.a(map2.get("notification_top_frequency"), 0));
                                    if (max <= 0 || max2 > max) {
                                        com.xiaomi.channel.commonutils.logger.b.d("set top notification failed - period:" + max + " frequency:" + max2);
                                    } else {
                                        drVar3.setPriority(2);
                                        android.os.Bundle bundle2 = new android.os.Bundle();
                                        bundle2.putLong("mipush_org_when", currentTimeMillis2);
                                        bundle2.putBoolean("mipush_n_top_flag", true);
                                        if (max2 > 0) {
                                            bundle2.putInt("mipush_n_top_fre", max2);
                                        }
                                        bundle2.putInt("mipush_n_top_prd", max);
                                        drVar3.addExtras(bundle2);
                                    }
                                }
                            }
                            com.xiaomi.push.aj.a((java.lang.Object) drVar3, "setChannelId", com.xiaomi.push.service.x.a(a19, str9, e, str10, i6, d2, str11, str12));
                            if (i3 == -100 && com.xiaomi.push.service.ab.a(map2)) {
                                com.xiaomi.push.service.ab.a(drVar3, z4);
                            }
                            if ("pulldown".equals(com.xiaomi.push.service.ab.a((java.lang.Object) map2)) && com.xiaomi.push.service.ab.a(map2) && java.util.Objects.equals(map2.get("pull_down_pop_type"), "0")) {
                                com.xiaomi.push.service.ab.a(drVar3, z4);
                            }
                            if ("tts".equals(com.xiaomi.push.service.ab.a((java.lang.Object) map2)) && com.xiaomi.push.service.ab.a(map2)) {
                                com.xiaomi.push.service.ab.a(drVar3, z4);
                            }
                        }
                        java.lang.String str14 = map2.get("background_color");
                        if (!android.text.TextUtils.isEmpty(str14)) {
                            try {
                                int parseInt = java.lang.Integer.parseInt(str14);
                                drVar3.setOngoing(true);
                                drVar3.setColor(parseInt);
                                com.xiaomi.push.aj.a((java.lang.Object) drVar3, "setColorized", java.lang.Boolean.TRUE);
                            } catch (java.lang.Exception e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                            }
                        }
                    } else if (map2 != null && i2 < 26) {
                        com.xiaomi.push.aj.a((java.lang.Object) drVar3, "setPriority", java.lang.Integer.valueOf(e(map2)));
                    }
                    if (str5 != null) {
                        if (!z3) {
                            com.xiaomi.push.service.y.a();
                            if (com.xiaomi.push.service.y.b() && com.xiaomi.push.service.y.a(context)) {
                                long currentTimeMillis3 = java.lang.System.currentTimeMillis();
                                android.os.Bundle extras = drVar3.getExtras();
                                extras.putString("push_src_group_name", str5);
                                extras.putLong("push_src_group_time", currentTimeMillis3);
                                c2 = 0;
                                i4 = 1;
                                str5 = java.lang.String.format("pushmask_%s_%s", java.lang.Long.valueOf(currentTimeMillis3), str5);
                                java.lang.Object[] objArr3 = new java.lang.Object[i4];
                                objArr3[c2] = str5;
                                com.xiaomi.push.aj.a((java.lang.Object) drVar3, "setGroup", objArr3);
                            }
                        }
                        i4 = 1;
                        c2 = 0;
                        java.lang.Object[] objArr32 = new java.lang.Object[i4];
                        objArr32[c2] = str5;
                        com.xiaomi.push.aj.a((java.lang.Object) drVar3, "setGroup", objArr32);
                    }
                    if (com.xiaomi.push.iu.d() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                        com.xiaomi.push.aj.a("miui.util.NotificationHelper", "setTargetPkg", context, drVar3, a(hhVar));
                    }
                    android.app.Notification notification = drVar3.getNotification();
                    if (z2 && com.xiaomi.push.iu.a() && (a6 = com.xiaomi.push.aj.a(notification, "extraNotification")) != null) {
                        com.xiaomi.push.aj.a(a6, "setCustomizedIcon", java.lang.Boolean.TRUE);
                    }
                    if (map2 != null) {
                        if (notification.extras == null) {
                            notification.extras = new android.os.Bundle();
                        }
                        if (!android.text.TextUtils.isEmpty(map2.get("enable_keyguard"))) {
                            com.xiaomi.push.service.ab.b(notification, java.lang.Boolean.parseBoolean(map2.get("enable_keyguard")));
                        }
                        if (!android.text.TextUtils.isEmpty(map2.get("enable_float"))) {
                            com.xiaomi.push.service.ab.a(notification, java.lang.Boolean.parseBoolean(map2.get("enable_float")));
                        }
                        if (!android.text.TextUtils.isEmpty(map2.get("float_small_win")) && "0".equals(map2.get("float_small_win")) && com.xiaomi.push.ga.h(context, a9)) {
                            com.xiaomi.push.service.ab.a(notification, false);
                        }
                        int a20 = com.xiaomi.push.jd.a(map2.get("section_is_prr"), -1);
                        int a21 = com.xiaomi.push.jd.a(map2.get("section_prr_cl"), -1);
                        if (a20 >= 0 && a21 >= 0) {
                            com.xiaomi.push.service.ab.a(notification, a20, a21);
                        }
                    }
                    com.xiaomi.push.service.p.b bVar3 = bVar;
                    bVar3.a = notification;
                    return bVar3;
                }
            }
            z2 = false;
            if (map2 == null) {
            }
            if (b2 != null) {
            }
            if (map2 != null) {
            }
            str5 = str3;
            z3 = false;
            z4 = false;
            drVar3.setAutoCancel(true);
            currentTimeMillis = java.lang.System.currentTimeMillis();
            if (map2 != null) {
                drVar3.setTicker(map2.get(com.huawei.hms.push.constant.RemoteMessageConst.Notification.TICKER));
            }
            if (currentTimeMillis - a > 10000) {
            }
            if (map2 == null) {
            }
            if (map2 != null) {
                com.xiaomi.push.aj.a((java.lang.Object) drVar3, "setPriority", java.lang.Integer.valueOf(e(map2)));
            }
            if (str5 != null) {
            }
            if (com.xiaomi.push.iu.d()) {
                com.xiaomi.push.aj.a("miui.util.NotificationHelper", "setTargetPkg", context, drVar3, a(hhVar));
            }
            android.app.Notification notification2 = drVar3.getNotification();
            if (z2) {
                com.xiaomi.push.aj.a(a6, "setCustomizedIcon", java.lang.Boolean.TRUE);
            }
            if (map2 != null) {
            }
            com.xiaomi.push.service.p.b bVar32 = bVar;
            bVar32.a = notification2;
            return bVar32;
        }
        drVar = new com.xiaomi.push.dr(context);
        drVar.setCustomContentView(remoteViews);
        obj = "notification_style_type";
        str = "4";
        str2 = "3";
        gxVar = gxVar3;
        str3 = null;
        com.xiaomi.push.dr drVar32 = drVar;
        a(drVar32, context, hhVar.f, hhVar, bArr, i);
        drVar32.setContentTitle(charSequenceArr[0]);
        drVar32.setContentText(charSequenceArr[1]);
        long currentTimeMillis22 = java.lang.System.currentTimeMillis();
        drVar32.setWhen(currentTimeMillis22);
        a2 = a(map2, "notification_show_when");
        if (android.text.TextUtils.isEmpty(a2)) {
        }
        drVar32.setContentIntent(pendingIntent);
        a3 = a(context, a9, "mipush_notification");
        int a122 = a(context, a9, "mipush_small_notification");
        if (a3 > 0) {
        }
        if (!com.xiaomi.push.iu.a(context)) {
        }
        z = false;
        if (!z) {
        }
        i2 = android.os.Build.VERSION.SDK_INT;
        if (i2 >= 23) {
        }
        a5 = a(map2, "__dynamic_icon_uri");
        if (java.lang.Boolean.parseBoolean(a(map2, "__adiom"))) {
        }
        if (!android.text.TextUtils.isEmpty(a5)) {
            if (a5.startsWith(com.alipay.sdk.m.l.a.q)) {
            }
            if (a7 != null) {
            }
        }
        z2 = false;
        if (map2 == null) {
        }
        if (b2 != null) {
        }
        if (map2 != null) {
        }
        str5 = str3;
        z3 = false;
        z4 = false;
        drVar32.setAutoCancel(true);
        currentTimeMillis = java.lang.System.currentTimeMillis();
        if (map2 != null) {
        }
        if (currentTimeMillis - a > 10000) {
        }
        if (map2 == null) {
        }
        if (map2 != null) {
        }
        if (str5 != null) {
        }
        if (com.xiaomi.push.iu.d()) {
        }
        android.app.Notification notification22 = drVar32.getNotification();
        if (z2) {
        }
        if (map2 != null) {
        }
        com.xiaomi.push.service.p.b bVar322 = bVar;
        bVar322.a = notification22;
        return bVar322;
    }

    public static com.xiaomi.push.service.p.c a(android.content.Context context, com.xiaomi.push.hh hhVar, byte[] bArr) {
        java.util.Map<java.lang.String, java.lang.String> map;
        int i;
        int i2;
        java.lang.String str;
        com.xiaomi.push.service.p.c cVar = new com.xiaomi.push.service.p.c();
        com.xiaomi.push.ga.a a2 = com.xiaomi.push.ga.a(context, a(hhVar), true);
        com.xiaomi.push.gx gxVar = hhVar.h;
        if (gxVar != null) {
            i = gxVar.i;
            map = gxVar.j;
        } else {
            map = null;
            i = 0;
        }
        java.lang.String a3 = a(hhVar);
        if (!android.text.TextUtils.isEmpty(a3)) {
            i += (a3.hashCode() / 10) * 10;
        }
        int i3 = i;
        if (com.xiaomi.push.iu.a(context) && a2 == com.xiaomi.push.ga.a.NOT_ALLOWED) {
            if (gxVar != null) {
                com.xiaomi.push.dp.a(context.getApplicationContext()).a(hhVar.f, g(hhVar), gxVar.a, "10:" + a(hhVar));
            }
            str = "Do not notify because user block " + a(hhVar) + "‘s notification";
        } else {
            if (com.xiaomi.push.iu.a(context) && d != null) {
                com.xiaomi.push.service.w wVar = d;
                a(hhVar);
                if (wVar.a()) {
                    if (gxVar != null) {
                        com.xiaomi.push.dp.a(context.getApplicationContext()).a(hhVar.f, g(hhVar), gxVar.a, "14:" + a(hhVar));
                    }
                    str = "Do not notify because card notification is canceled or sequence incorrect";
                }
            }
            android.widget.RemoteViews a4 = a(context, hhVar);
            java.lang.String str2 = hhVar.f;
            android.app.PendingIntent a5 = a(context, hhVar, str2, bArr, i3, 0, a(context, hhVar, str2));
            if (a5 != null) {
                com.xiaomi.push.service.p.b a6 = a(context, hhVar, bArr, a4, a5, i3);
                cVar.b = a6.b;
                cVar.a = a(hhVar);
                android.app.Notification notification = a6.a;
                if (com.xiaomi.push.iu.a()) {
                    if (!android.text.TextUtils.isEmpty(gxVar.a)) {
                        notification.extras.putString("message_id", gxVar.a);
                    }
                    notification.extras.putString("local_paid", hhVar.e);
                    com.xiaomi.push.service.ab.a(map, notification.extras, "msg_busi_type");
                    com.xiaomi.push.service.ab.a(map, notification.extras, "disable_notification_flags");
                    java.util.Map<java.lang.String, java.lang.String> map2 = gxVar.k;
                    java.lang.String str3 = map2 == null ? null : map2.get("score_info");
                    if (!android.text.TextUtils.isEmpty(str3)) {
                        notification.extras.putString("score_info", str3);
                    }
                    notification.extras.putString("pushUid", a(gxVar.j, "n_stats_expose"));
                    notification.extras.putString("eventMessageType", java.lang.String.valueOf(d(hhVar) ? 1000 : b(hhVar) ? 3000 : -1));
                    notification.extras.putString(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, a(hhVar));
                }
                java.util.Map<java.lang.String, java.lang.String> map3 = gxVar.j;
                java.lang.String str4 = map3 != null ? map3.get("message_count") : null;
                if (com.xiaomi.push.iu.a() && str4 != null) {
                    try {
                        com.xiaomi.push.service.ab.a(notification, java.lang.Integer.parseInt(str4));
                    } catch (java.lang.NumberFormatException e) {
                        com.xiaomi.push.dp.a(context.getApplicationContext()).b(hhVar.f, g(hhVar), gxVar.a, "8");
                        com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. ".concat(java.lang.String.valueOf(e)));
                    }
                }
                java.lang.String a7 = a(hhVar);
                if (!com.xiaomi.push.iu.d() && com.xiaomi.push.iu.a(context)) {
                    com.xiaomi.push.service.ab.a(notification, a7);
                }
                com.xiaomi.push.service.aa a8 = com.xiaomi.push.service.aa.a(context, a7);
                com.xiaomi.push.iu.a(context);
                if (com.xiaomi.push.iu.a(context) && d != null && d.c()) {
                    com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
                    i2 = i3;
                } else {
                    i2 = i3;
                    a8.a(i2, notification);
                    cVar.c = true;
                    com.xiaomi.channel.commonutils.logger.b.a("notification: " + gxVar.a + " is notifyied");
                }
                if (com.xiaomi.push.iu.a() && com.xiaomi.push.iu.a(context)) {
                    com.xiaomi.push.service.y a9 = com.xiaomi.push.service.y.a();
                    if (com.xiaomi.push.service.y.b()) {
                        if (com.xiaomi.push.service.y.a(context)) {
                            try {
                                com.xiaomi.push.service.y.a(context, i2, notification);
                            } catch (java.lang.Exception e2) {
                                com.xiaomi.channel.commonutils.logger.b.a("group notify handle restore error ".concat(java.lang.String.valueOf(e2)));
                            }
                        }
                        if (com.xiaomi.push.service.y.b(context)) {
                            try {
                                a9.b(context, i2, notification);
                            } catch (java.lang.Exception e3) {
                                com.xiaomi.channel.commonutils.logger.b.a("group notify handle auto error ".concat(java.lang.String.valueOf(e3)));
                            }
                        }
                    }
                    java.lang.String str5 = gxVar.a;
                    if (com.xiaomi.push.iu.a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
                        com.xiaomi.push.service.bg.a(context, a7, i2, str5, notification);
                    }
                }
                if (b(hhVar)) {
                    com.xiaomi.push.dp.a(context.getApplicationContext()).a(hhVar.f, g(hhVar), gxVar.a, 3002, null);
                }
                if (d(hhVar)) {
                    com.xiaomi.push.dp.a(context.getApplicationContext()).a(hhVar.f, g(hhVar), gxVar.a, 1002, null);
                }
                if (android.os.Build.VERSION.SDK_INT < 26) {
                    java.lang.String str6 = gxVar.a;
                    com.xiaomi.push.m a10 = com.xiaomi.push.m.a(context);
                    int c2 = c(gxVar.j);
                    if (c2 > 0 && !android.text.TextUtils.isEmpty(str6)) {
                        java.lang.String concat = "n_timeout_".concat(java.lang.String.valueOf(str6));
                        a10.a(concat);
                        a10.a((com.xiaomi.push.m.a) new com.xiaomi.push.service.q(concat, a8, i2), c2);
                    }
                }
                android.util.Pair<java.lang.Integer, com.xiaomi.push.hh> pair = new android.util.Pair<>(java.lang.Integer.valueOf(i2), hhVar);
                java.util.LinkedList<android.util.Pair<java.lang.Integer, com.xiaomi.push.hh>> linkedList = b;
                synchronized (linkedList) {
                    linkedList.add(pair);
                    if (linkedList.size() > 100) {
                        linkedList.remove();
                    }
                }
                return cVar;
            }
            if (gxVar != null) {
                com.xiaomi.push.dp.a(context.getApplicationContext()).a(hhVar.f, g(hhVar), gxVar.a, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            }
            str = "The click PendingIntent is null. ";
        }
        com.xiaomi.channel.commonutils.logger.b.a(str);
        return cVar;
    }

    public static java.lang.String a(com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.gx gxVar;
        java.util.Map<java.lang.String, java.lang.String> map;
        if ("com.xiaomi.xmsf".equals(hhVar.f) && (gxVar = hhVar.h) != null && (map = gxVar.j) != null) {
            java.lang.String str = map.get("miui_package_name");
            if (!android.text.TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hhVar.f;
    }

    public static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map, int i) {
        java.lang.String format = i == 0 ? "notify_effect" : b(map) ? java.lang.String.format("cust_btn_%s_ne", java.lang.Integer.valueOf(i)) : i == 1 ? "notification_style_button_left_notify_effect" : i == 2 ? "notification_style_button_mid_notify_effect" : i == 3 ? "notification_style_button_right_notify_effect" : i == 4 ? "notification_colorful_button_notify_effect" : null;
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    private static java.lang.String a(java.util.Map<java.lang.String, java.lang.String> map, java.lang.String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static void a(android.content.Context context, android.content.Intent intent, com.xiaomi.push.hh hhVar, com.xiaomi.push.gx gxVar, java.lang.String str, int i) {
        if (hhVar == null || gxVar == null || android.text.TextUtils.isEmpty(str)) {
            return;
        }
        java.lang.String a2 = a(gxVar.j, i);
        if (android.text.TextUtils.isEmpty(a2)) {
            return;
        }
        if (com.xiaomi.push.service.an.a.equals(a2) || com.xiaomi.push.service.an.b.equals(a2) || com.xiaomi.push.service.an.c.equals(a2)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", hhVar.e);
            if (!android.text.TextUtils.isEmpty(hhVar.f)) {
                intent.putExtra(com.huawei.hms.support.hianalytics.HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, hhVar.f);
            }
            intent.putExtra("job_key", a(gxVar.j, "jobkey"));
            intent.putExtra(i + "_target_component", b(context, hhVar.f, gxVar.j, i));
        }
    }

    public static void a(android.content.Context context, java.lang.String str, int i) {
        a(context, str, i, -1);
    }

    public static void a(android.content.Context context, java.lang.String str, int i, int i2) {
        boolean z;
        if (context == null || android.text.TextUtils.isEmpty(str) || i < -1) {
            return;
        }
        com.xiaomi.push.service.aa a2 = com.xiaomi.push.service.aa.a(context, str);
        java.util.List<android.service.notification.StatusBarNotification> c2 = a2.c();
        if (com.xiaomi.push.jd.a(c2)) {
            return;
        }
        java.util.LinkedList linkedList = new java.util.LinkedList();
        int i3 = 0;
        if (i == -1) {
            z = true;
        } else {
            i3 = ((str.hashCode() / 10) * 10) + i;
            z = false;
        }
        java.util.Iterator<android.service.notification.StatusBarNotification> it = c2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            android.service.notification.StatusBarNotification next = it.next();
            if (!android.text.TextUtils.isEmpty(java.lang.String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    a2.a(id);
                } else if (i3 == id) {
                    com.xiaomi.push.service.bz.a(context, next, i2);
                    linkedList.add(next);
                    a2.a(id);
                    break;
                }
            }
        }
        a(context, (java.util.LinkedList<? extends java.lang.Object>) linkedList);
    }

    public static void a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        if (context == null || android.text.TextUtils.isEmpty(str) || android.text.TextUtils.isEmpty(str2) || android.text.TextUtils.isEmpty(str3)) {
            return;
        }
        com.xiaomi.push.service.aa a2 = com.xiaomi.push.service.aa.a(context, str);
        java.util.List<android.service.notification.StatusBarNotification> c2 = a2.c();
        if (com.xiaomi.push.jd.a(c2)) {
            return;
        }
        java.util.LinkedList linkedList = new java.util.LinkedList();
        for (android.service.notification.StatusBarNotification statusBarNotification : c2) {
            android.app.Notification notification = statusBarNotification.getNotification();
            if (notification != null && !android.text.TextUtils.isEmpty(java.lang.String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                java.lang.String a3 = com.xiaomi.push.service.ab.a(notification);
                java.lang.String b2 = com.xiaomi.push.service.ab.b(notification);
                if (!android.text.TextUtils.isEmpty(a3) && !android.text.TextUtils.isEmpty(b2) && a(a3, str2) && a(b2, str3)) {
                    linkedList.add(statusBarNotification);
                    a2.a(id);
                }
            }
        }
        a(context, (java.util.LinkedList<? extends java.lang.Object>) linkedList);
    }

    public static void a(android.content.Context context, java.util.LinkedList<? extends java.lang.Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        com.xiaomi.push.service.bc.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    @android.annotation.TargetApi(16)
    private static void a(com.xiaomi.push.dr drVar, android.content.Context context, java.lang.String str, com.xiaomi.push.hh hhVar, byte[] bArr, int i) {
        android.app.PendingIntent a2;
        android.app.PendingIntent a3;
        android.app.PendingIntent a4;
        android.app.PendingIntent a5;
        java.util.Map<java.lang.String, java.lang.String> map = hhVar.h.j;
        if (android.text.TextUtils.equals("3", map.get("notification_style_type")) || android.text.TextUtils.equals("4", map.get("notification_style_type"))) {
            return;
        }
        if (b(map)) {
            for (int i2 = 1; i2 <= 3; i2++) {
                java.lang.String str2 = map.get(java.lang.String.format("cust_btn_%s_n", java.lang.Integer.valueOf(i2)));
                if (!android.text.TextUtils.isEmpty(str2) && (a5 = a(context, str, hhVar, bArr, i, i2)) != null) {
                    drVar.addAction(0, str2, a5);
                }
            }
            return;
        }
        if (!android.text.TextUtils.isEmpty(map.get("notification_style_button_left_name")) && (a4 = a(context, str, hhVar, bArr, i, 1)) != null) {
            drVar.addAction(0, map.get("notification_style_button_left_name"), a4);
        }
        if (!android.text.TextUtils.isEmpty(map.get("notification_style_button_mid_name")) && (a3 = a(context, str, hhVar, bArr, i, 2)) != null) {
            drVar.addAction(0, map.get("notification_style_button_mid_name"), a3);
        }
        if (android.text.TextUtils.isEmpty(map.get("notification_style_button_right_name")) || (a2 = a(context, str, hhVar, bArr, i, 3)) == null) {
            return;
        }
        drVar.addAction(0, map.get("notification_style_button_right_name"), a2);
    }

    private static boolean a(android.content.Context context, com.xiaomi.push.hh hhVar, java.lang.String str) {
        com.xiaomi.push.gx gxVar;
        if (hhVar != null && (gxVar = hhVar.h) != null && gxVar.j != null && !android.text.TextUtils.isEmpty(str)) {
            return java.lang.Boolean.parseBoolean(hhVar.h.j.get("use_clicked_activity")) && com.xiaomi.push.service.ch.a(context, a(str));
        }
        com.xiaomi.channel.commonutils.logger.b.a("should clicked activity params are null.");
        return false;
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && java.util.Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(android.content.Context context, java.lang.String str, boolean z) {
        return com.xiaomi.push.iu.a() && !z && a(context, str);
    }

    private static boolean a(com.xiaomi.push.gx gxVar) {
        if (gxVar == null) {
            return false;
        }
        java.lang.String str = gxVar.a;
        return !android.text.TextUtils.isEmpty(str) && str.length() == 22 && "satuigmo".indexOf(str.charAt(0)) >= 0;
    }

    private static boolean a(java.lang.String str, java.lang.String str2) {
        return android.text.TextUtils.isEmpty(str) || str2.contains(str);
    }

    public static boolean a(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    private static int b(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i) {
        android.content.ComponentName a2;
        android.content.Intent a3 = a(context, str, map, i);
        if (a3 == null || (a2 = com.xiaomi.push.service.ch.a(context, a3)) == null) {
            return 0;
        }
        return a2.hashCode();
    }

    private static android.graphics.Bitmap b(android.content.Context context, java.lang.String str, boolean z) {
        android.graphics.Bitmap bitmap;
        java.util.concurrent.Future submit = c.submit(new com.xiaomi.push.service.p.a(str, context, z));
        try {
            try {
                bitmap = (android.graphics.Bitmap) submit.get(180L, java.util.concurrent.TimeUnit.SECONDS);
                if (bitmap == null) {
                }
            } finally {
                submit.cancel(true);
            }
        } catch (java.lang.InterruptedException | java.util.concurrent.ExecutionException | java.util.concurrent.TimeoutException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            submit.cancel(true);
            bitmap = null;
        }
        return bitmap;
    }

    public static void b(android.content.Context context, java.lang.String str) {
        a(context, str, -1, -1);
    }

    public static void b(android.content.Context context, java.lang.String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    public static boolean b(com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.gx gxVar = hhVar.h;
        return a(gxVar) && gxVar.l;
    }

    private static boolean b(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map != null) {
            return "6".equals(map.get("notification_style_type"));
        }
        com.xiaomi.channel.commonutils.logger.b.a("meta extra is null");
        return false;
    }

    private static int c(java.util.Map<java.lang.String, java.lang.String> map) {
        java.lang.String str = map == null ? null : map.get("timeout");
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    private static android.content.Intent c(android.content.Context context, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map, int i) {
        if (b(map)) {
            return a(context, str, map, java.lang.String.format("cust_btn_%s_ne", java.lang.Integer.valueOf(i)), java.lang.String.format("cust_btn_%s_iu", java.lang.Integer.valueOf(i)), java.lang.String.format("cust_btn_%s_ic", java.lang.Integer.valueOf(i)), java.lang.String.format("cust_btn_%s_wu", java.lang.Integer.valueOf(i)));
        }
        if (i == 1) {
            return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
        }
        if (i == 2) {
            return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        if (i == 3) {
            return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
        }
        if (i != 4) {
            return null;
        }
        return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
    }

    public static void c(android.content.Context context, java.lang.String str) {
        if (!com.xiaomi.push.iu.a(context) || d == null) {
            return;
        }
        android.text.TextUtils.isEmpty(str);
    }

    public static boolean c(com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.gx gxVar = hhVar.h;
        return a(gxVar) && gxVar.h == 1 && !b(hhVar);
    }

    private static int d(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return 3;
        }
        java.lang.String str = map.get("channel_importance");
        if (android.text.TextUtils.isEmpty(str)) {
            return 3;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("importance=".concat(java.lang.String.valueOf(str)));
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: ".concat(java.lang.String.valueOf(e)));
            return 3;
        }
    }

    public static void d(android.content.Context context, java.lang.String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean d(com.xiaomi.push.hh hhVar) {
        com.xiaomi.push.gx gxVar = hhVar.h;
        return a(gxVar) && gxVar.h == 0 && !b(hhVar);
    }

    private static int e(java.util.Map<java.lang.String, java.lang.String> map) {
        if (map == null) {
            return 0;
        }
        java.lang.String str = map.get("notification_priority");
        if (android.text.TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            com.xiaomi.channel.commonutils.logger.b.c("priority=".concat(java.lang.String.valueOf(str)));
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: ".concat(java.lang.String.valueOf(e)));
            return 0;
        }
    }

    public static boolean e(android.content.Context context, java.lang.String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static boolean e(com.xiaomi.push.hh hhVar) {
        return hhVar.a == com.xiaomi.push.gk.Registration;
    }

    public static boolean f(com.xiaomi.push.hh hhVar) {
        return b(hhVar) || d(hhVar) || c(hhVar);
    }

    public static java.lang.String g(com.xiaomi.push.hh hhVar) {
        return b(hhVar) ? "E100002" : d(hhVar) ? "E100000" : c(hhVar) ? "E100001" : e(hhVar) ? "E100003" : "";
    }
}
