package com.ss.android.downloadlib.bt;

/* loaded from: classes19.dex */
public class o {

    /* renamed from: com.ss.android.downloadlib.bt.o$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.addownload.z.t().vw(8, com.ss.android.downloadlib.addownload.z.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt.o$2, reason: invalid class name */
    public static class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ android.content.Intent wg;

        public AnonymousClass2(android.content.Context context, android.content.Intent intent) {
            this.vw = context;
            this.wg = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.vw.startActivity(this.wg);
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt.o$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.addownload.z.t().vw(12, com.ss.android.downloadlib.addownload.z.getContext(), null, "正在前往浏览器下载", null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt.o$4, reason: invalid class name */
    public static class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ android.content.Intent wg;

        public AnonymousClass4(android.content.Context context, android.content.Intent intent) {
            this.vw = context;
            this.wg = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.vw.startActivity(this.wg);
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt.o$5, reason: invalid class name */
    public static class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.downloadlib.addownload.wg.yl t;
        final /* synthetic */ android.content.Context vw;
        final /* synthetic */ java.lang.String wg;

        public AnonymousClass5(android.content.Context context, java.lang.String str, com.ss.android.downloadlib.addownload.wg.yl ylVar) {
            this.vw = context;
            this.wg = str;
            this.t = ylVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.downloadlib.wg.vw.vw(com.ss.android.downloadlib.bt.o.vw(this.vw, android.net.Uri.parse("market://details?id=" + this.wg)), this.t, true);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
                java.lang.Thread.sleep(x.optInt("m2_delay_millis", 1000));
                com.ss.android.downloadlib.vw.vw.vw.vw().vw(this.vw, true);
                com.ss.android.downloadlib.vw.vw.wg wgVar = new com.ss.android.downloadlib.vw.vw.wg();
                wgVar.vw = 1;
                wgVar.wg = 0;
                java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("v"), x.optString("s"));
                wgVar.t = java.lang.String.format(vw, this.wg);
                com.ss.android.downloadlib.vw.vw.vw.vw().vw(wgVar, (com.ss.android.downloadlib.vw.vw.v) null);
                com.ss.android.downloadlib.vw.vw.vw.vw().wg();
                com.ss.android.downloadlib.bt.o.wg(this.t, jSONObject, -1, 2, java.lang.String.format(vw, this.wg));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                com.ss.android.downloadlib.bt.o.wg(this.t, jSONObject, 1, 2, "market://details?id=" + this.wg);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt.o$6, reason: invalid class name */
    public static class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.downloadlib.addownload.wg.yl t;
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ android.content.Context wg;

        /* renamed from: com.ss.android.downloadlib.bt.o$6$1, reason: invalid class name */
        public class AnonymousClass1 implements com.ss.android.download.api.config.te {
            final /* synthetic */ org.json.JSONObject vw;

            public AnonymousClass1(org.json.JSONObject jSONObject) {
                this.vw = jSONObject;
            }

            /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
            @Override // com.ss.android.download.api.config.te
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void vw(java.lang.String str) {
                boolean z;
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.lang.String t = com.ss.android.downloadlib.bt.o.t(str);
                    if (!android.text.TextUtils.isEmpty(t)) {
                        java.lang.String v = com.ss.android.downloadlib.bt.o.v(t);
                        if (!android.text.TextUtils.isEmpty(v)) {
                            com.ss.android.downloadlib.bt.o.AnonymousClass6 anonymousClass6 = com.ss.android.downloadlib.bt.o.AnonymousClass6.this;
                            com.ss.android.downloadlib.bt.o.wg(anonymousClass6.wg, anonymousClass6.t, anonymousClass6.vw, v);
                            z = true;
                            if (z) {
                                com.ss.android.downloadlib.wg.vw.vw(com.ss.android.downloadlib.bt.o.vw(com.ss.android.downloadlib.bt.o.AnonymousClass6.this.wg, android.net.Uri.parse("market://details?id=" + com.ss.android.downloadlib.bt.o.AnonymousClass6.this.vw)), com.ss.android.downloadlib.bt.o.AnonymousClass6.this.t, true);
                                com.ss.android.downloadlib.bt.o.wg(com.ss.android.downloadlib.bt.o.AnonymousClass6.this.t, this.vw, 10, 9, "market://details?id=" + com.ss.android.downloadlib.bt.o.AnonymousClass6.this.vw);
                                return;
                            }
                            return;
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }

            @Override // com.ss.android.download.api.config.te
            public void vw(java.lang.Throwable th) {
                com.ss.android.downloadlib.wg.vw.vw(com.ss.android.downloadlib.bt.o.vw(com.ss.android.downloadlib.bt.o.AnonymousClass6.this.wg, android.net.Uri.parse("market://details?id=" + com.ss.android.downloadlib.bt.o.AnonymousClass6.this.vw)), com.ss.android.downloadlib.bt.o.AnonymousClass6.this.t, true);
                com.ss.android.downloadlib.bt.vl.vw(this.vw, "ttdownloader_message", th != null ? th.getMessage() : com.igexin.push.core.b.m);
                com.ss.android.downloadlib.bt.o.wg(com.ss.android.downloadlib.bt.o.AnonymousClass6.this.t, this.vw, 11, 9, "market://details?id=" + com.ss.android.downloadlib.bt.o.AnonymousClass6.this.vw);
            }
        }

        public AnonymousClass6(java.lang.String str, android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar) {
            this.vw = str;
            this.wg = context;
            this.t = ylVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                java.lang.String optString = x.optString("s");
                java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("bw"), optString);
                java.lang.String vw2 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("bx"), optString);
                java.lang.String vw3 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("by"), optString);
                android.net.Uri.Builder builder = new android.net.Uri.Builder();
                builder.scheme("https").authority(vw).appendPath(vw2).appendQueryParameter(vw3, this.vw);
                com.ss.android.downloadlib.addownload.z.v().vw("GET", builder.build().toString(), null, new com.ss.android.downloadlib.bt.o.AnonymousClass6.AnonymousClass1(jSONObject));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                com.ss.android.downloadlib.bt.o.wg(this.t, jSONObject, 4, 9, "market://details?id=" + this.vw);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.bt.o$7, reason: invalid class name */
    public static class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ com.ss.android.downloadlib.addownload.wg.yl t;
        final /* synthetic */ java.lang.String vw;
        final /* synthetic */ android.content.Context wg;

        /* renamed from: com.ss.android.downloadlib.bt.o$7$1, reason: invalid class name */
        public class AnonymousClass1 implements com.ss.android.download.api.config.te {
            final /* synthetic */ org.json.JSONObject vw;

            public AnonymousClass1(org.json.JSONObject jSONObject) {
                this.vw = jSONObject;
            }

            @Override // com.ss.android.download.api.config.te
            public void vw(java.lang.String str) {
                com.ss.android.downloadlib.bt.o.AnonymousClass7 anonymousClass7 = com.ss.android.downloadlib.bt.o.AnonymousClass7.this;
                com.ss.android.downloadlib.bt.o.wg(anonymousClass7.wg, anonymousClass7.vw, str, anonymousClass7.t, this.vw);
            }

            @Override // com.ss.android.download.api.config.te
            public void vw(java.lang.Throwable th) {
                com.ss.android.downloadlib.wg.vw.vw(com.ss.android.downloadlib.bt.o.vw(com.ss.android.downloadlib.bt.o.AnonymousClass7.this.wg, android.net.Uri.parse("market://details?id=" + com.ss.android.downloadlib.bt.o.AnonymousClass7.this.vw)), com.ss.android.downloadlib.bt.o.AnonymousClass7.this.t, true);
                com.ss.android.downloadlib.bt.vl.vw(this.vw, "ttdownloader_message", th != null ? th.getMessage() : com.igexin.push.core.b.m);
                com.ss.android.downloadlib.bt.o.wg(com.ss.android.downloadlib.bt.o.AnonymousClass7.this.t, this.vw, 7, 5, "market://details?id=" + com.ss.android.downloadlib.bt.o.AnonymousClass7.this.vw);
            }
        }

        public AnonymousClass7(java.lang.String str, android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar) {
            this.vw = str;
            this.wg = context;
            this.t = ylVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
            java.lang.String optString = x.optString("s");
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("x"), optString);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            com.ss.android.downloadlib.bt.vl.vw(jSONObject2, "t", "v");
            com.ss.android.downloadlib.bt.vl.vw(jSONObject2, "p", this.vw);
            byte[] bytes = jSONObject2.toString().getBytes();
            com.ss.android.downloadlib.addownload.z.v().vw(vw, com.ss.android.downloadlib.addownload.z.te().vw(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new com.ss.android.downloadlib.bt.o.AnonymousClass7.AnonymousClass1(jSONObject));
        }
    }

    private static void bt(android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str) {
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.bt.o.AnonymousClass7(str, context, ylVar));
    }

    private static void kz(android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.ss.android.downloadlib.activity.TTDelegateActivity.vw(str, ylVar.vw);
        } catch (java.lang.Exception unused) {
            com.ss.android.downloadlib.wg.vw.vw(vw(context, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), ylVar, true);
            wg(ylVar, jSONObject, 13, 10, "market://details?id=".concat(java.lang.String.valueOf(str)));
        }
    }

    private static void o(android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.ss.android.downloadlib.activity.TTDelegateActivity.vw(str, ylVar.vw, "need_comment");
        } catch (java.lang.Exception unused) {
            com.ss.android.downloadlib.wg.vw.vw(vw(context, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), ylVar, true);
            wg(ylVar, jSONObject, 9, 8, "market://details?id=".concat(java.lang.String.valueOf(str)));
        }
    }

    private static com.ss.android.downloadlib.addownload.wg.bt t(android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.ss.android.downloadlib.activity.JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("dl", true);
        intent.putExtra("p", str);
        intent.putExtra("id", ylVar.vw);
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", "com.heytap.browser");
        } else if (com.ss.android.downloadlib.bt.vl.yl(context, "com.android.browser")) {
            intent.putExtra("bk", "com.android.browser");
        } else {
            if (!com.ss.android.downloadlib.bt.vl.yl(context, "com.coloros.browser")) {
                return vw(context, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str))));
            }
            intent.putExtra("bk", "com.coloros.browser");
        }
        intent.putExtra("start_only_for_android", true);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.wg.bt(7, "am_kllk3");
        } catch (java.lang.Throwable unused) {
            wg(ylVar, jSONObject, 1, 3, "market://details?id=".concat(java.lang.String.valueOf(str)));
            return vw(context, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str))));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String t(java.lang.String str) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        java.lang.String group = matcher.find() ? matcher.group() : "";
        if (!group.equals(null) && group.length() > 0) {
            for (java.lang.String str2 : group.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (java.lang.String str3 : str2.split("\\s")) {
                        if (str3.startsWith("value")) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean t(@androidx.annotation.NonNull android.app.Activity activity, android.net.Uri uri) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        java.lang.String es = com.ss.android.socialbase.appdownloader.kz.yl.es();
        if (com.ss.android.downloadlib.bt.vl.yl(com.ss.android.downloadlib.addownload.z.getContext(), es)) {
            intent.setPackage(es);
        }
        if (!com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.addownload.z.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "start HM2");
            return false;
        }
    }

    public static boolean t(android.content.Context context, java.lang.String str) {
        if (context == null) {
            return false;
        }
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static com.ss.android.downloadlib.addownload.wg.bt v(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        try {
            android.net.Uri parse = android.net.Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=".concat(java.lang.String.valueOf(str)));
            android.content.Intent intent = new android.content.Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            if (!(context instanceof android.app.Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.wg.bt(5);
        } catch (java.lang.Exception unused) {
            return new com.ss.android.downloadlib.addownload.wg.bt(6, 14);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String v(java.lang.String str) {
        java.util.List<java.lang.String> pathSegments = android.net.Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    private static void v(android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str) {
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.bt.o.AnonymousClass5(context, str, ylVar));
    }

    public static com.ss.android.downloadlib.addownload.wg.bt vw(android.content.Context context, android.net.Uri uri) {
        android.content.Intent intent;
        if (!com.ss.android.socialbase.appdownloader.kz.yl.t() && (context == null || uri == null || !"market".equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.wg.bt(6, 12);
        }
        try {
            java.lang.String es = com.ss.android.socialbase.appdownloader.kz.yl.es();
            if (!com.ss.android.socialbase.appdownloader.kz.yl.k() || (!android.text.TextUtils.isEmpty(es) && com.ss.android.downloadlib.bt.vl.yl(context, es))) {
                intent = new android.content.Intent("android.intent.action.VIEW", uri);
            } else {
                es = "com.huawei.appmarket";
                android.net.Uri.Builder buildUpon = uri.buildUpon();
                buildUpon.scheme("market");
                intent = new android.content.Intent("android.intent.action.VIEW", buildUpon.build());
            }
            if (!com.ss.android.downloadlib.bt.vl.vw(context, intent)) {
                return new com.ss.android.downloadlib.addownload.wg.bt(6, 13);
            }
            if (com.ss.android.downloadlib.bt.vl.yl(context, es) && !com.ss.android.socialbase.appdownloader.kz.yl.bt()) {
                intent.setPackage(es);
            }
            if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof android.app.Activity)) {
                intent.addFlags(268435456);
            }
            if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.yl.t.vw().vw(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.wg.bt(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.wg.bt(5);
        } catch (java.lang.Exception unused) {
            return new com.ss.android.downloadlib.addownload.wg.bt(6, 14);
        }
    }

    public static com.ss.android.downloadlib.addownload.wg.bt vw(android.content.Context context, android.net.Uri uri, com.ss.android.downloadlib.addownload.wg.yl ylVar) {
        com.ss.android.downloadad.api.vw.wg wgVar;
        if (context == null || !com.ss.android.downloadlib.wg.es.vw(uri)) {
            return new com.ss.android.downloadlib.addownload.wg.bt(6, 12);
        }
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", uri);
            if (!com.ss.android.downloadlib.bt.vl.vw(context, intent)) {
                return new com.ss.android.downloadlib.addownload.wg.bt(6, 13);
            }
            java.lang.String es = com.ss.android.socialbase.appdownloader.kz.yl.es();
            if (com.ss.android.downloadlib.bt.vl.yl(context, es)) {
                intent.setPackage(es);
            }
            intent.addFlags(335544320);
            if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optInt("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.z.es().t)) {
                com.ss.android.downloadlib.yl.t.vw().vw(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.wg.bt(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            long optLong = com.ss.android.downloadlib.addownload.z.x().optLong("market_jump_delay", 1000L);
            if (optLong > 0 && ylVar != null && (wgVar = ylVar.yl) != null && !wgVar.ol()) {
                com.ss.android.downloadlib.bt.vw().wg().post(new com.ss.android.downloadlib.bt.o.AnonymousClass1());
            }
            com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.bt.o.AnonymousClass2(context, intent), optLong);
            return new com.ss.android.downloadlib.addownload.wg.bt(5);
        } catch (java.lang.Exception unused) {
            return new com.ss.android.downloadlib.addownload.wg.bt(6, 14);
        }
    }

    public static com.ss.android.downloadlib.addownload.wg.bt vw(android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.wg.bt(6, 11);
        }
        if (com.ss.android.socialbase.appdownloader.kz.yl.bt() && com.ss.android.downloadlib.bt.vl.yl(context, "com.sec.android.app.samsungapps")) {
            return v(context, str);
        }
        if (!ylVar.wg.isAd() || !ylVar.v.enableAM()) {
            return vw(context, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str))));
        }
        org.json.JSONArray optJSONArray = com.ss.android.downloadlib.addownload.z.x().optJSONArray("am_plans");
        if (com.ss.android.socialbase.appdownloader.kz.yl.yl() && com.ss.android.socialbase.appdownloader.kz.vw.vw(optJSONArray, "am_3")) {
            return wg(context, ylVar, str);
        }
        if (com.ss.android.socialbase.appdownloader.kz.yl.kz() && com.ss.android.socialbase.appdownloader.kz.vw.vw(optJSONArray, "am_2")) {
            v(context, ylVar, str);
            return new com.ss.android.downloadlib.addownload.wg.bt(7, "am_m2");
        }
        if (com.ss.android.socialbase.appdownloader.kz.yl.v() && com.ss.android.socialbase.appdownloader.kz.vw.vw(optJSONArray, "am_5")) {
            bt(context, ylVar, str);
            return new com.ss.android.downloadlib.addownload.wg.bt(7, "am_v1");
        }
        if (com.ss.android.socialbase.appdownloader.kz.yl.yl() && com.ss.android.socialbase.appdownloader.kz.vw.vw(optJSONArray, "am_7")) {
            com.ss.android.download.api.download.DownloadController downloadController = ylVar.v;
            if ((downloadController instanceof com.ss.android.downloadad.api.download.AdDownloadController) && ((com.ss.android.downloadad.api.download.AdDownloadController) downloadController).enableOppoAutoDownload()) {
                return t(context, ylVar, str);
            }
        }
        if (com.ss.android.socialbase.appdownloader.kz.yl.v() && com.ss.android.socialbase.appdownloader.kz.vw.vw(optJSONArray, "am_8") && com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.bt.vl.t(context, "com.bbk.appstore"), "8.7.2.0") >= 0) {
            o(context, ylVar, str);
            return new com.ss.android.downloadlib.addownload.wg.bt(7, "am_v2");
        }
        if ((com.ss.android.socialbase.appdownloader.kz.yl.vw() || com.ss.android.socialbase.appdownloader.kz.yl.wg()) && com.ss.android.socialbase.appdownloader.kz.vw.vw(optJSONArray, "am_9")) {
            yl(context, ylVar, str);
            return new com.ss.android.downloadlib.addownload.wg.bt(7, "am_hr");
        }
        if ((!com.ss.android.socialbase.appdownloader.kz.yl.vw() && !com.ss.android.socialbase.appdownloader.kz.yl.wg()) || !com.ss.android.socialbase.appdownloader.kz.vw.vw(optJSONArray, "am_10")) {
            return vw(context, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str))));
        }
        kz(context, ylVar, str);
        return new com.ss.android.downloadlib.addownload.wg.bt(7, "am_hr2");
    }

    public static com.ss.android.downloadlib.addownload.wg.bt vw(android.content.Context context, java.lang.String str) {
        return (context == null || android.text.TextUtils.isEmpty(str)) ? new com.ss.android.downloadlib.addownload.wg.bt(6, 11) : (com.ss.android.socialbase.appdownloader.kz.yl.bt() && com.ss.android.downloadlib.bt.vl.yl(context, "com.sec.android.app.samsungapps")) ? v(context, str) : vw(context, com.ss.android.download.api.t.vw.vw(str));
    }

    public static com.ss.android.downloadlib.addownload.wg.bt vw(android.content.Context context, java.lang.String str, com.ss.android.downloadad.api.vw.vw vwVar) {
        android.content.Intent bt = com.ss.android.downloadlib.bt.vl.bt(context, str);
        if (bt == null) {
            return new com.ss.android.downloadlib.addownload.wg.bt(4, 22);
        }
        if (android.os.Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.z.x().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.z.vl() != null && com.ss.android.downloadlib.addownload.z.vl().vw() && vwVar.k()) {
            com.ss.android.downloadlib.activity.TTDelegateActivity.wg(str, vwVar);
            return new com.ss.android.downloadlib.addownload.wg.bt(3);
        }
        bt.putExtra("start_only_for_android", true);
        try {
            context.startActivity(bt);
            return new com.ss.android.downloadlib.addownload.wg.bt(3);
        } catch (java.lang.Exception unused) {
            return new com.ss.android.downloadlib.addownload.wg.bt(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.wg.bt vw(@androidx.annotation.NonNull com.ss.android.downloadad.api.vw.wg wgVar, java.lang.String str, java.lang.String str2) {
        com.ss.android.downloadlib.addownload.wg.bt wg = wg(str, wgVar);
        return (com.ss.android.downloadlib.wg.kz.vw(wgVar) && wg.getType() == 2) ? vw(str2, wgVar) : wg;
    }

    public static com.ss.android.downloadlib.addownload.wg.bt vw(java.lang.String str, com.ss.android.downloadad.api.vw.vw vwVar) {
        return vw(com.ss.android.downloadlib.addownload.z.getContext(), str, vwVar);
    }

    public static void vw(@androidx.annotation.NonNull android.app.Activity activity, java.lang.String str, long j) {
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
        java.lang.String optString = x.optString("s");
        java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("ca"), optString);
        java.lang.String vw2 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("cc"), optString);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("market://details?id=");
        if (!android.text.TextUtils.isEmpty(vw) && !android.text.TextUtils.isEmpty(vw2)) {
            sb.append(str);
            sb.append("&");
            sb.append(vw);
            sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(vw2);
        }
        if (t(activity, android.net.Uri.parse(sb.toString()))) {
            wg(yl, jSONObject, -1, 10, "market://details?id=".concat(java.lang.String.valueOf(str)));
            com.ss.android.downloadlib.wg.vw.vw("am_hr2", jSONObject, yl, true);
        } else {
            wg(yl, jSONObject, 2, 10, "market://details?id=".concat(java.lang.String.valueOf(str)));
            com.ss.android.downloadlib.wg.vw.vw(vw((android.content.Context) activity, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), yl, true);
        }
    }

    public static void vw(@androidx.annotation.NonNull android.app.Activity activity, java.lang.String str, long j, java.lang.String str2) {
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
        java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("bv"), x.optString("s"));
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("market").authority(com.ss.android.download.api.constant.BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str);
        if (!android.text.TextUtils.isEmpty(vw)) {
            builder.appendQueryParameter(vw, str2);
        }
        if (vw(activity, builder.build())) {
            wg(yl, jSONObject, -1, 8, "market://details?id=".concat(java.lang.String.valueOf(str)));
            com.ss.android.downloadlib.wg.vw.vw("am_v2", jSONObject, yl, true);
        } else {
            wg(yl, jSONObject, 2, 8, "market://details?id=".concat(java.lang.String.valueOf(str)));
            com.ss.android.downloadlib.wg.vw.vw(vw((android.content.Context) activity, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), yl, true);
        }
    }

    public static void vw(@androidx.annotation.NonNull android.app.Activity activity, java.lang.String str, long j, java.lang.String str2, java.lang.String str3) {
        org.json.JSONObject jSONObject;
        try {
            jSONObject = new org.json.JSONObject(str3);
        } catch (org.json.JSONException unused) {
            jSONObject = new org.json.JSONObject();
        }
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        try {
            org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
            boolean vw = com.ss.android.socialbase.appdownloader.kz.vw.vw(x, activity, com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("bg"), x.optString("s")));
            java.util.HashMap<java.lang.String, java.lang.String> wg = com.ss.android.downloadlib.bt.vl.wg(new org.json.JSONObject(str2));
            if (vw && !wg.isEmpty() && vw(activity, str, wg)) {
                wg(yl, jSONObject, -1, 5, "market://details?id=".concat(java.lang.String.valueOf(str)));
                com.ss.android.downloadlib.wg.vw.vw("am_v1", jSONObject, yl, true);
            } else {
                wg(yl, jSONObject, vw ? wg.isEmpty() ? 1 : 2 : 3, 5, "market://details?id=".concat(java.lang.String.valueOf(str)));
                com.ss.android.downloadlib.wg.vw.vw(vw((android.content.Context) activity, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), yl, true);
            }
        } catch (java.lang.Exception unused2) {
            com.ss.android.downloadlib.wg.vw.vw(vw(com.ss.android.downloadlib.addownload.z.getContext(), android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), yl, true);
            wg(yl, jSONObject, 4, 5, "market://details?id=".concat(java.lang.String.valueOf(str)));
        }
    }

    public static void vw(android.content.Context context, java.lang.String str, long j, java.lang.String str2, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        try {
            org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
            java.lang.String optString = x.optString("s");
            java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("br"), optString);
            java.lang.String vw2 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("bs_1"), optString);
            java.lang.String vw3 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("bs_2"), optString);
            java.lang.String vw4 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("bs_3"), optString);
            java.lang.String vw5 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("bt"), optString);
            java.lang.String vw6 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString(com.aliyun.vod.log.struct.AliyunLogKey.KEY_BUCKET), optString);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.format("https://", new java.lang.Object[0]));
            sb.append(vw);
            sb.append(vw2);
            sb.append(vw3);
            sb.append(vw4);
            sb.append(vw5);
            sb.append(vw6);
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z) {
                sb.append("pkg=".concat(java.lang.String.valueOf(str)));
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "dl", java.lang.Boolean.valueOf(z));
            intent.setData(android.net.Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            long optLong = com.ss.android.downloadlib.addownload.z.x().optLong("oppo_browser_jump_delay", 1000L);
            if (optLong > 0) {
                com.ss.android.downloadlib.bt.vw().wg().post(new com.ss.android.downloadlib.bt.o.AnonymousClass3());
            }
            com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.bt.o.AnonymousClass4(context, intent), optLong);
            com.ss.android.downloadad.api.vw.wg wgVar = yl.yl;
            if (wgVar != null) {
                wgVar.n(true);
            }
            com.ss.android.downloadlib.wg.vw.vw("am_kllk3", jSONObject, yl, true);
            wg(yl, jSONObject, -1, 7, sb.toString());
        } catch (java.lang.Exception unused) {
            com.ss.android.downloadad.api.vw.wg wgVar2 = yl.yl;
            if (wgVar2 != null) {
                wgVar2.n(false);
            }
            com.ss.android.downloadlib.wg.vw.vw(vw(com.ss.android.downloadlib.addownload.z.getContext(), android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str))), yl), yl, true);
            wg(yl, jSONObject, 2, 7, "market://details?id=".concat(java.lang.String.valueOf(str)));
        }
    }

    public static void vw(android.content.Context context, java.lang.String str, long j, boolean z) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        try {
            org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
            java.lang.String optString = x.optString("s");
            java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString(com.anythink.expressad.d.a.b.w), optString);
            java.lang.String vw2 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString(com.anythink.expressad.d.a.b.da), optString);
            java.lang.String vw3 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString(com.aliyun.common.log.struct.AliyunLogKey.KEY_AUDIO_FORMAT), optString);
            boolean vw4 = com.ss.android.socialbase.appdownloader.kz.vw.vw(x, context, vw2);
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.format(vw, str, vw3, vw2));
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            java.lang.String es = com.ss.android.socialbase.appdownloader.kz.yl.es();
            if (com.ss.android.downloadlib.bt.vl.yl(context, es)) {
                intent.setPackage(es);
            }
            if (z) {
                sb.append(com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("ae"), optString));
            } else {
                intent.addFlags(335544320);
            }
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "mf", java.lang.Boolean.valueOf(vw4));
            com.ss.android.downloadlib.bt.vl.vw(jSONObject, "if", java.lang.Boolean.valueOf(z));
            intent.setData(android.net.Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            com.ss.android.downloadlib.wg.vw.vw("am_kllk2", jSONObject, yl, true);
            if (vw4) {
                wg(yl, jSONObject, -1, 3, sb.toString());
            } else {
                wg(yl, jSONObject, 3, 3, sb.toString());
            }
        } catch (java.lang.Exception unused) {
            com.ss.android.downloadlib.wg.vw.vw(vw(com.ss.android.downloadlib.addownload.z.getContext(), android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), yl, true);
            wg(yl, jSONObject, 2, 3, "market://details?id=".concat(java.lang.String.valueOf(str)));
        }
    }

    public static boolean vw(@androidx.annotation.NonNull android.app.Activity activity, android.net.Uri uri) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        java.lang.String es = com.ss.android.socialbase.appdownloader.kz.yl.es();
        if (com.ss.android.downloadlib.bt.vl.yl(com.ss.android.downloadlib.addownload.z.getContext(), es)) {
            intent.setPackage(es);
        }
        if (!com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.addownload.z.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "start v2");
            return false;
        }
    }

    private static boolean vw(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.util.HashMap<java.lang.String, java.lang.String> hashMap) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str))));
        intent.putExtra("start_only_for_android", true);
        intent.putExtra(com.huawei.hms.push.constant.RemoteMessageConst.MessageBody.PARAM, hashMap);
        java.lang.String es = com.ss.android.socialbase.appdownloader.kz.yl.es();
        if (com.ss.android.downloadlib.bt.vl.yl(com.ss.android.downloadlib.addownload.z.getContext(), es)) {
            intent.setPackage(es);
        }
        if (!com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.addownload.z.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "start v1");
            return false;
        }
    }

    public static boolean vw(android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str, org.json.JSONObject jSONObject, boolean z, int i) {
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(ylVar.q()));
        com.ss.android.downloadlib.v.vw.vw().wg("market_click_open", jSONObject, ylVar);
        com.ss.android.downloadlib.addownload.wg.bt vw = vw(context, android.net.Uri.parse(str));
        java.lang.String vw2 = com.ss.android.downloadlib.bt.vl.vw(vw.wg(), "open_market");
        int type = vw.getType();
        if (type == 5) {
            com.ss.android.downloadlib.wg.vw.vw(vw2, jSONObject, ylVar, true);
        } else {
            if (type == 6) {
                com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", java.lang.Integer.valueOf(vw.vw()));
                com.ss.android.downloadlib.bt.vl.vw(jSONObject, "download_scene", java.lang.Integer.valueOf(ylVar.q()));
                com.ss.android.downloadlib.v.vw.vw().wg("market_open_failed", jSONObject, ylVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        if (z) {
            com.ss.android.downloadlib.v.vw.vw().vw(ylVar.vw, i);
        }
        return true;
    }

    private static com.ss.android.downloadlib.addownload.wg.bt wg(android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str) {
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.ss.android.downloadlib.activity.JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", ylVar.vw);
        intent.putExtra("start_only_for_android", true);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.wg.bt(7, "am_kllk2");
        } catch (java.lang.Throwable unused) {
            wg(ylVar, jSONObject, 1, 3, "market://details?id=".concat(java.lang.String.valueOf(str)));
            return vw(context, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str))));
        }
    }

    public static com.ss.android.downloadlib.addownload.wg.bt wg(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.wg.bt(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.z.getContext();
        }
        android.content.Intent bt = com.ss.android.downloadlib.bt.vl.bt(context, str);
        if (bt == null) {
            return new com.ss.android.downloadlib.addownload.wg.bt(4, 22);
        }
        bt.putExtra("start_only_for_android", true);
        try {
            context.startActivity(bt);
            return new com.ss.android.downloadlib.addownload.wg.bt(3);
        } catch (java.lang.Exception unused) {
            return new com.ss.android.downloadlib.addownload.wg.bt(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.wg.bt wg(java.lang.String str, @androidx.annotation.NonNull com.ss.android.downloadad.api.vw.vw vwVar) {
        if (android.text.TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.wg.bt(2, 21);
        }
        android.content.Context context = com.ss.android.downloadlib.addownload.z.getContext();
        android.net.Uri parse = android.net.Uri.parse(str);
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        intent.putExtra("open_url", str);
        intent.putExtra("start_only_for_android", true);
        if (com.ss.android.socialbase.downloader.setting.DownloadSetting.obtainGlobal().optBugFix("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        if (!com.ss.android.downloadlib.bt.vl.wg(context, intent)) {
            return new com.ss.android.downloadlib.addownload.wg.bt(2, 24);
        }
        if (com.ss.android.downloadlib.addownload.z.x().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.z.vl() != null && com.ss.android.downloadlib.addownload.z.vl().vw() && android.os.Build.VERSION.SDK_INT >= 26 && vwVar.k()) {
            com.ss.android.downloadlib.activity.TTDelegateActivity.vw(str, vwVar);
        } else {
            try {
                com.ss.android.downloadlib.addownload.z.getContext().startActivity(intent);
            } catch (java.lang.Exception unused) {
                return new com.ss.android.downloadlib.addownload.wg.bt(2);
            }
        }
        return new com.ss.android.downloadlib.addownload.wg.bt(1);
    }

    public static void wg(@androidx.annotation.NonNull android.app.Activity activity, java.lang.String str, long j, java.lang.String str2) {
        com.ss.android.downloadlib.addownload.wg.yl yl = com.ss.android.downloadlib.addownload.wg.kz.vw().yl(j);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject x = com.ss.android.downloadlib.addownload.z.x();
        java.lang.String optString = x.optString("s");
        java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("bz"), optString);
        java.lang.String vw2 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("ca"), optString);
        java.lang.String vw3 = com.ss.android.socialbase.appdownloader.kz.t.vw(x.optString("cb"), optString);
        android.net.Uri.Builder builder = new android.net.Uri.Builder();
        builder.scheme("hiapplink").authority("com.huawei.appmarket");
        if (!android.text.TextUtils.isEmpty(vw)) {
            builder.appendQueryParameter(vw, str2);
        }
        if (!android.text.TextUtils.isEmpty(vw2) && !android.text.TextUtils.isEmpty(vw3)) {
            builder.appendQueryParameter(vw2, vw3);
        }
        if (wg(activity, builder.build())) {
            wg(yl, jSONObject, -1, 9, "market://details?id=".concat(java.lang.String.valueOf(str)));
            com.ss.android.downloadlib.wg.vw.vw("am_hr", jSONObject, yl, true);
        } else {
            wg(yl, jSONObject, 2, 9, "market://details?id=".concat(java.lang.String.valueOf(str)));
            com.ss.android.downloadlib.wg.vw.vw(vw((android.content.Context) activity, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), yl, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wg(android.content.Context context, @androidx.annotation.NonNull com.ss.android.downloadlib.addownload.wg.yl ylVar, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            com.ss.android.downloadlib.activity.TTDelegateActivity.wg(str, ylVar.vw, str2);
        } catch (java.lang.Exception unused) {
            com.ss.android.downloadlib.wg.vw.vw(vw(context, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), ylVar, true);
            wg(ylVar, jSONObject, 12, 9, "market://details?id=".concat(java.lang.String.valueOf(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wg(android.content.Context context, java.lang.String str, java.lang.String str2, @androidx.annotation.NonNull com.ss.android.downloadlib.addownload.wg.yl ylVar, @androidx.annotation.NonNull org.json.JSONObject jSONObject) {
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "ttdownloader_type", (java.lang.Object) 5);
        try {
            java.lang.String vw = com.ss.android.socialbase.appdownloader.kz.t.vw(new org.json.JSONObject(str2).optString("a"));
            if (!android.text.TextUtils.isEmpty(vw)) {
                com.ss.android.downloadlib.activity.TTDelegateActivity.vw(str, ylVar.vw, vw, jSONObject);
            } else {
                com.ss.android.downloadlib.wg.vw.vw(vw(context, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), ylVar, true);
                wg(ylVar, jSONObject, 5, 5, "market://details?id=".concat(java.lang.String.valueOf(str)));
            }
        } catch (java.lang.Exception unused) {
            com.ss.android.downloadlib.wg.vw.vw(vw(context, android.net.Uri.parse("market://details?id=".concat(java.lang.String.valueOf(str)))), ylVar, true);
            wg(ylVar, jSONObject, 6, 5, "market://details?id=".concat(java.lang.String.valueOf(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wg(com.ss.android.downloadlib.addownload.wg.yl ylVar, org.json.JSONObject jSONObject, int i, int i2, java.lang.String str) {
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "error_code", java.lang.Integer.valueOf(i));
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "ttdownloader_type", java.lang.Integer.valueOf(i2));
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, "rmu", str);
        com.ss.android.downloadlib.bt.vl.vw(jSONObject, com.ss.android.socialbase.appdownloader.kz.yl.es(), java.lang.Integer.valueOf(com.ss.android.downloadlib.bt.vl.wg(com.ss.android.downloadlib.addownload.z.getContext(), com.ss.android.socialbase.appdownloader.kz.yl.es())));
        com.ss.android.downloadlib.v.vw.vw().wg("am_result", jSONObject, ylVar);
    }

    public static boolean wg(@androidx.annotation.NonNull android.app.Activity activity, android.net.Uri uri) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        java.lang.String es = com.ss.android.socialbase.appdownloader.kz.yl.es();
        if (com.ss.android.downloadlib.bt.vl.yl(com.ss.android.downloadlib.addownload.z.getContext(), es)) {
            intent.setPackage(es);
        }
        if (!com.ss.android.downloadlib.bt.vl.vw(com.ss.android.downloadlib.addownload.z.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.yl.t.vw().vw(e, "start HM1");
            return false;
        }
    }

    private static void yl(android.content.Context context, com.ss.android.downloadlib.addownload.wg.yl ylVar, java.lang.String str) {
        com.ss.android.downloadlib.v.vw().vw(new com.ss.android.downloadlib.bt.o.AnonymousClass6(str, context, ylVar));
    }
}
