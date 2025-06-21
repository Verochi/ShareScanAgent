package com.bytedance.pangle.plugin;

/* loaded from: classes12.dex */
final class b {
    private static final com.bytedance.pangle.i a = com.bytedance.pangle.i.a();

    /* renamed from: com.bytedance.pangle.plugin.b$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.bytedance.pangle.a.a.InterfaceC0264a {
        final /* synthetic */ java.io.File a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ int c;
        final /* synthetic */ java.lang.StringBuffer d;

        public AnonymousClass1(java.io.File file, java.lang.String str, int i, java.lang.StringBuffer stringBuffer) {
            this.a = file;
            this.b = str;
            this.c = i;
            this.d = stringBuffer;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0264a
        public final void a() {
            com.bytedance.pangle.plugin.b.a(this.a, this.b, this.c, this.d);
        }
    }

    /* renamed from: com.bytedance.pangle.plugin.b$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.bytedance.pangle.a.a.InterfaceC0264a {
        final /* synthetic */ java.io.File a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ int c;
        final /* synthetic */ java.lang.StringBuffer d;
        final /* synthetic */ boolean[] e;

        /* renamed from: com.bytedance.pangle.plugin.b$2$1, reason: invalid class name */
        public class AnonymousClass1 implements com.bytedance.pangle.a.a.InterfaceC0264a {
            final /* synthetic */ java.util.Map a;

            public AnonymousClass1(java.util.Map map) {
                this.a = map;
            }

            @Override // com.bytedance.pangle.a.a.InterfaceC0264a
            public final void a() {
                com.bytedance.pangle.plugin.b.AnonymousClass2 anonymousClass2 = com.bytedance.pangle.plugin.b.AnonymousClass2.this;
                com.bytedance.pangle.plugin.b.a(anonymousClass2.b, anonymousClass2.c, this.a, anonymousClass2.d);
            }
        }

        /* renamed from: com.bytedance.pangle.plugin.b$2$2, reason: invalid class name and collision with other inner class name */
        public class C02702 implements com.bytedance.pangle.a.a.InterfaceC0264a {
            final /* synthetic */ boolean[] a;

            public C02702(boolean[] zArr) {
                this.a = zArr;
            }

            @Override // com.bytedance.pangle.a.a.InterfaceC0264a
            public final void a() {
                boolean[] zArr = this.a;
                com.bytedance.pangle.plugin.b.AnonymousClass2 anonymousClass2 = com.bytedance.pangle.plugin.b.AnonymousClass2.this;
                zArr[0] = com.bytedance.pangle.plugin.b.h(anonymousClass2.a, anonymousClass2.b, anonymousClass2.c, anonymousClass2.d);
            }
        }

        public AnonymousClass2(java.io.File file, java.lang.String str, int i, java.lang.StringBuffer stringBuffer, boolean[] zArr) {
            this.a = file;
            this.b = str;
            this.c = i;
            this.d = stringBuffer;
            this.e = zArr;
        }

        @Override // com.bytedance.pangle.a.a.InterfaceC0264a
        public final void a() {
            java.util.Map f = com.bytedance.pangle.plugin.b.f(this.a, this.b, this.c, this.d);
            com.bytedance.pangle.plugin.b.c(this.a, this.b, this.c, this.d);
            com.bytedance.pangle.plugin.b.a(com.bytedance.pangle.plugin.b.g(this.a, this.b, this.c, this.d), this.b, this.c, this.d);
            if (com.bytedance.pangle.util.i.f() || com.bytedance.pangle.util.i.b()) {
                boolean[] zArr = {false};
                com.bytedance.pangle.a.a.a(new com.bytedance.pangle.plugin.b.AnonymousClass2.AnonymousClass1(f), new com.bytedance.pangle.plugin.b.AnonymousClass2.C02702(zArr));
                this.e[0] = com.bytedance.pangle.plugin.b.a(this.b, this.c, zArr[0], this.d);
            } else {
                com.bytedance.pangle.plugin.b.a(this.b, this.c, f, this.d);
                this.e[0] = com.bytedance.pangle.plugin.b.a(this.b, this.c, false, this.d);
                com.bytedance.pangle.plugin.b.a(this.b, this.c);
            }
        }
    }

    public static class a extends java.io.IOException {
        private a(java.lang.String str) {
            super(str);
        }

        public /* synthetic */ a(java.lang.String str, byte b) {
            this(str);
        }

        private a(java.lang.String str, java.lang.Throwable th) {
            super(str, th);
        }

        public /* synthetic */ a(java.lang.String str, java.lang.Throwable th, byte b) {
            this(str, th);
        }
    }

    public static /* synthetic */ void a(java.io.File file, java.lang.String str, int i, java.lang.StringBuffer stringBuffer) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            try {
                if (com.bytedance.pangle.g.e.a(file.getAbsolutePath(), str)) {
                } else {
                    throw new java.lang.RuntimeException("安装包签名校验失败[1]");
                }
            } catch (java.lang.Exception e) {
                a(com.bytedance.pangle.c.b.f, com.bytedance.pangle.c.b.a.u, str, i, -1L, null);
                a.a(1100, -3, str, i, e);
                throw new com.bytedance.pangle.plugin.b.a(e.getMessage(), e, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkSignature cost:");
            stringBuffer.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(com.alipay.sdk.m.u.i.b);
        }
    }

    public static /* synthetic */ void a(java.lang.String str, int i) {
        try {
            if (com.bytedance.pangle.util.i.e() || com.bytedance.pangle.util.i.g()) {
                com.bytedance.pangle.util.l.a().b(str, i, false);
                com.bytedance.pangle.e.b.a(com.bytedance.pangle.Zeus.getAppApplication()).edit().putInt(str, i).apply();
                com.bytedance.pangle.e.f.a();
            }
        } catch (java.lang.Exception e) {
            a(com.bytedance.pangle.c.b.f, com.bytedance.pangle.c.b.a.z, str, i, -1L, null);
            throw new com.bytedance.pangle.plugin.b.a("dexOpt2失败", e, (byte) 0);
        }
    }

    private static void a(java.lang.String str, int i, @androidx.annotation.NonNull java.lang.String str2, int i2, long j, java.lang.String str3) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        try {
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.MonitorConstants.STATUS_CODE, com.bytedance.pangle.log.b.a(java.lang.Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.b.a(str2));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.b.a(java.lang.Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", java.lang.Integer.valueOf(com.bytedance.pangle.log.b.b(java.lang.Long.valueOf(j))));
            jSONObject2.putOpt("message", com.bytedance.pangle.log.b.a(str3));
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        com.bytedance.pangle.c.b.a().a(str, jSONObject, jSONObject3, jSONObject2);
    }

    public static /* synthetic */ void a(java.lang.String str, int i, java.util.Map map, java.lang.StringBuffer stringBuffer) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.d.b.a(new java.io.File(com.bytedance.pangle.d.c.b(str, i)), new java.io.File(com.bytedance.pangle.d.c.d(str, i)), str, (java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>>) map);
            } catch (java.lang.Exception e) {
                a(com.bytedance.pangle.c.b.f, com.bytedance.pangle.c.b.a.x, str, i, -1L, com.bytedance.pangle.log.b.a((java.lang.Object) e));
                a.a(1100, -7, str, i, e);
                throw new com.bytedance.pangle.plugin.b.a("安装包动态库拷贝失败", e, (byte) 0);
            }
        } finally {
            stringBuffer.append("copySo cost:");
            stringBuffer.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(com.alipay.sdk.m.u.i.b);
        }
    }

    public static /* synthetic */ void a(java.lang.String str, java.lang.String str2, int i, java.lang.StringBuffer stringBuffer) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int a2 = new com.bytedance.pangle.res.a.c().a(new java.io.File(str), false, sb);
        stringBuffer.append(a2 == 100 ? "modifyRes" : "noModifyRes");
        stringBuffer.append(" cost:");
        stringBuffer.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(com.alipay.sdk.m.u.i.b);
        if (a2 == 100 || a2 == 200) {
            return;
        }
        java.lang.String sb2 = sb.toString();
        a(com.bytedance.pangle.c.b.f, com.bytedance.pangle.c.b.a.B, str2, i, -1L, sb2);
        a.a(1100, -2, str2, i, null);
        throw new com.bytedance.pangle.plugin.b.a("modifyRes failed. result = " + a2 + ", errorLog = " + sb2, (byte) 0);
    }

    public static boolean a(java.io.File file, java.lang.String str, int i) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("useOpt;");
        boolean[] zArr = {false};
        try {
            com.bytedance.pangle.i iVar = a;
            iVar.a(1000, 0, str, i, null);
            com.bytedance.pangle.log.a a2 = com.bytedance.pangle.log.a.a(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "PluginInstaller", "install:".concat(java.lang.String.valueOf(str)));
            a(com.bytedance.pangle.c.b.e, com.bytedance.pangle.c.b.a.r, str, i, -1L, null);
            int b = com.bytedance.pangle.util.l.a().b(str, i, "install");
            int b2 = com.bytedance.pangle.util.l.a().b(str, i, "load");
            int removeApkEntryFlag = com.bytedance.pangle.GlobalParam.getInstance().getRemoveApkEntryFlag(str);
            if (b > 3 || b2 > 3) {
                removeApkEntryFlag = 0;
            }
            android.content.SharedPreferences.Editor edit = com.bytedance.pangle.util.l.a().a.edit();
            edit.putInt("remove_entry_flag_" + str + "_" + i, removeApkEntryFlag);
            edit.apply();
            com.bytedance.pangle.util.l.a().c(str, i, false);
            com.bytedance.pangle.util.g.a(com.bytedance.pangle.d.c.a(str, i));
            com.bytedance.pangle.a.a.a(new com.bytedance.pangle.plugin.b.AnonymousClass1(file, str, i, stringBuffer), new com.bytedance.pangle.plugin.b.AnonymousClass2(file, str, i, stringBuffer, zArr));
            com.bytedance.pangle.util.g.a(file);
            a(com.bytedance.pangle.c.b.f, com.bytedance.pangle.c.b.a.f302s, str, i, a2.a(), stringBuffer.toString());
            a2.a("success");
            iVar.a(1100, 0, str, i, null);
            return true;
        } catch (java.lang.Throwable th) {
            if (th instanceof com.bytedance.pangle.plugin.b.a) {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed.", th);
            } else {
                com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_INSTALL, "PluginInstaller " + str + " install failed unknown error.", th);
                a(com.bytedance.pangle.c.b.f, com.bytedance.pangle.c.b.a.t, str, i, -1L, stringBuffer.toString());
                a.a(1100, -1, str, i, th);
            }
            if (zArr[0]) {
                com.bytedance.pangle.util.l.a().a(str, i, "install");
            }
            return false;
        }
    }

    public static /* synthetic */ boolean a(java.lang.String str, int i, boolean z, java.lang.StringBuffer stringBuffer) {
        int b = com.bytedance.pangle.util.l.a().b(str, i);
        boolean z2 = (b & 1) != 0;
        boolean z3 = (b & 2) != 0;
        if (!z2 && !z3) {
            stringBuffer.append("removeEntry skip;");
            return false;
        }
        boolean z4 = z && z2;
        java.lang.String b2 = com.bytedance.pangle.d.c.b(str, i);
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        boolean a2 = com.bytedance.pangle.util.b.b.a(b2, z4, z3, str, i, 1);
        stringBuffer.append("removeEntry cost:");
        stringBuffer.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
        stringBuffer.append(com.alipay.sdk.m.u.i.b);
        return a2;
    }

    public static /* synthetic */ void c(java.io.File file, java.lang.String str, int i, java.lang.StringBuffer stringBuffer) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            try {
                android.content.pm.PackageInfo packageInfo = com.bytedance.pangle.Zeus.getAppApplication().getPackageManager().getPackageInfo(com.bytedance.pangle.Zeus.getAppApplication().getPackageName(), 4096);
                android.content.pm.PackageInfo packageArchiveInfo = com.bytedance.pangle.Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 4096);
                java.util.List asList = java.util.Arrays.asList(packageInfo.requestedPermissions);
                java.lang.String[] strArr = packageArchiveInfo.requestedPermissions;
                if (strArr != null && strArr.length > 0) {
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    for (java.lang.String str2 : packageArchiveInfo.requestedPermissions) {
                        if (!asList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        com.bytedance.pangle.log.ZeusLogger.w("PluginInstaller", "The following permissions are declared in the plugin but not in the host: ".concat(java.lang.String.valueOf(arrayList)));
                        if (com.bytedance.pangle.GlobalParam.getInstance().checkPermission()) {
                            throw new com.bytedance.pangle.plugin.b.a("The following permissions are declared in the plugin but not in the host: ".concat(java.lang.String.valueOf(arrayList)), (byte) 0);
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                a(com.bytedance.pangle.c.b.f, com.bytedance.pangle.c.b.a.v, str, i, -1L, null);
                a.a(1100, -4, str, i, e);
                throw new com.bytedance.pangle.plugin.b.a("安装包权限校验失败", e, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkPermissions cost:");
            stringBuffer.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(com.alipay.sdk.m.u.i.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>> f(java.io.File file, java.lang.String str, int i, java.lang.StringBuffer stringBuffer) {
        if (!com.bytedance.pangle.GlobalParam.getInstance().checkMatchHostAbi()) {
            return null;
        }
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            try {
                com.bytedance.pangle.util.e<java.lang.Boolean, java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>>> a2 = com.bytedance.pangle.d.b.a(file);
                boolean booleanValue = a2.a.booleanValue();
                java.util.Map<java.lang.String, java.util.List<java.util.zip.ZipEntry>> map = a2.b;
                if (booleanValue) {
                    return map;
                }
                throw new com.bytedance.pangle.plugin.b.a("插件包包含so不符合宿主ABI类型", (byte) 0);
            } catch (java.lang.Exception e) {
                a(com.bytedance.pangle.c.b.f, com.bytedance.pangle.c.b.a.A, str, i, -1L, null);
                a.a(1100, -5, str, i, e);
                throw new com.bytedance.pangle.plugin.b.a("插件包包含so不符合宿主ABI类型", e, (byte) 0);
            }
        } finally {
            stringBuffer.append("checkMatchHostAbi cost:");
            stringBuffer.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(com.alipay.sdk.m.u.i.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.String g(java.io.File file, java.lang.String str, int i, java.lang.StringBuffer stringBuffer) {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.String b = com.bytedance.pangle.d.c.b(str, i);
        try {
            try {
                com.bytedance.pangle.util.h.a(file.getAbsolutePath(), b);
                return b;
            } catch (java.lang.Exception e) {
                a(com.bytedance.pangle.c.b.f, com.bytedance.pangle.c.b.a.w, str, i, -1L, null);
                a.a(1100, -6, str, i, e);
                throw new com.bytedance.pangle.plugin.b.a("安装包拷贝失败", e, (byte) 0);
            }
        } finally {
            stringBuffer.append("copyApk cost:");
            stringBuffer.append(java.lang.System.currentTimeMillis() - currentTimeMillis);
            stringBuffer.append(com.alipay.sdk.m.u.i.b);
        }
    }

    /*  JADX ERROR: Types fix failed
        java.lang.NullPointerException
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x023b: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:92:0x023b */
    /* JADX WARN: Not initialized variable reg: 17, insn: 0x023f: MOVE (r9 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:88:0x023f */
    public static boolean h(java.io.File r21, java.lang.String r22, int r23, java.lang.StringBuffer r24) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.plugin.b.h(java.io.File, java.lang.String, int, java.lang.StringBuffer):boolean");
    }
}
