package com.getui.gtc.extension.distribution.gbd.n.a;

/* loaded from: classes22.dex */
public final class d {
    private static final java.lang.String c = "GBD_EC";
    public boolean a;
    public boolean b;
    private int d;
    private boolean e;
    private org.json.JSONObject f;
    private org.json.JSONObject g;
    private org.json.JSONObject h;
    private java.lang.String i;

    public interface a {
        void a();
    }

    public static class b {
        private static final com.getui.gtc.extension.distribution.gbd.n.a.d a = new com.getui.gtc.extension.distribution.gbd.n.a.d((byte) 0);

        private b() {
        }
    }

    private d() {
        this.a = true;
        this.b = false;
    }

    public /* synthetic */ d(byte b2) {
        this();
    }

    public static synchronized com.getui.gtc.extension.distribution.gbd.n.a.d a() {
        com.getui.gtc.extension.distribution.gbd.n.a.d dVar;
        synchronized (com.getui.gtc.extension.distribution.gbd.n.a.d.class) {
            dVar = com.getui.gtc.extension.distribution.gbd.n.a.d.b.a;
        }
        return dVar;
    }

    private void b(android.content.Context context) {
        try {
            if (!com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, com.anythink.china.common.d.a)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "no ph p.");
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.l.a(true);
            if (android.text.TextUtils.isEmpty(a2)) {
                return;
            }
            java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.n.a.f.a(context);
            java.lang.String a4 = com.getui.gtc.extension.distribution.gbd.n.a.f.a();
            jSONObject.put("level0", a2);
            jSONObject.put("level1", a3);
            jSONObject.put("level2", a4);
            this.g = jSONObject;
            if (!android.text.TextUtils.isEmpty(a3) && !a3.equals(a2)) {
                this.d++;
            } else {
                if (android.text.TextUtils.isEmpty(a4) || a4.equals(a2)) {
                    return;
                }
                this.d++;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private boolean b() {
        return this.a;
    }

    private void c(android.content.Context context) {
        if (com.getui.gtc.extension.distribution.gbd.n.a.f.b(context).size() == 0) {
            this.d++;
        }
    }

    private boolean c() {
        return this.b;
    }

    private void d() {
        try {
            if (com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.BLUETOOTH") && com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.BLUETOOTH_ADMIN")) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                android.bluetooth.BluetoothAdapter defaultAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter == null) {
                    this.d++;
                    jSONObject.put("enable", false);
                    jSONObject.put("name", "");
                    jSONObject.put("address", "");
                } else {
                    jSONObject.put("enable", true);
                    jSONObject.put("name", defaultAdapter.getName());
                    jSONObject.put("address", defaultAdapter.getAddress());
                    if (defaultAdapter.getName() == null || defaultAdapter.getAddress() == null) {
                        this.d++;
                    }
                }
                this.f = jSONObject;
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0086 A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0005, B:7:0x0044, B:11:0x006f, B:13:0x0086, B:14:0x0090, B:16:0x00a7, B:17:0x00bb, B:19:0x00cc, B:21:0x00d0, B:24:0x00d5, B:29:0x00aa, B:31:0x00b2, B:34:0x0089, B:37:0x0060, B:39:0x0066, B:42:0x0037), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a7 A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0005, B:7:0x0044, B:11:0x006f, B:13:0x0086, B:14:0x0090, B:16:0x00a7, B:17:0x00bb, B:19:0x00cc, B:21:0x00d0, B:24:0x00d5, B:29:0x00aa, B:31:0x00b2, B:34:0x0089, B:37:0x0060, B:39:0x0066, B:42:0x0037), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cc A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0005, B:7:0x0044, B:11:0x006f, B:13:0x0086, B:14:0x0090, B:16:0x00a7, B:17:0x00bb, B:19:0x00cc, B:21:0x00d0, B:24:0x00d5, B:29:0x00aa, B:31:0x00b2, B:34:0x0089, B:37:0x0060, B:39:0x0066, B:42:0x0037), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d0 A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0005, B:7:0x0044, B:11:0x006f, B:13:0x0086, B:14:0x0090, B:16:0x00a7, B:17:0x00bb, B:19:0x00cc, B:21:0x00d0, B:24:0x00d5, B:29:0x00aa, B:31:0x00b2, B:34:0x0089, B:37:0x0060, B:39:0x0066, B:42:0x0037), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d5 A[Catch: all -> 0x00db, TRY_LEAVE, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0005, B:7:0x0044, B:11:0x006f, B:13:0x0086, B:14:0x0090, B:16:0x00a7, B:17:0x00bb, B:19:0x00cc, B:21:0x00d0, B:24:0x00d5, B:29:0x00aa, B:31:0x00b2, B:34:0x0089, B:37:0x0060, B:39:0x0066, B:42:0x0037), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0005, B:7:0x0044, B:11:0x006f, B:13:0x0086, B:14:0x0090, B:16:0x00a7, B:17:0x00bb, B:19:0x00cc, B:21:0x00d0, B:24:0x00d5, B:29:0x00aa, B:31:0x00b2, B:34:0x0089, B:37:0x0060, B:39:0x0066, B:42:0x0037), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0089 A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0005, B:7:0x0044, B:11:0x006f, B:13:0x0086, B:14:0x0090, B:16:0x00a7, B:17:0x00bb, B:19:0x00cc, B:21:0x00d0, B:24:0x00d5, B:29:0x00aa, B:31:0x00b2, B:34:0x0089, B:37:0x0060, B:39:0x0066, B:42:0x0037), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060 A[Catch: all -> 0x00db, TRY_ENTER, TryCatch #0 {all -> 0x00db, blocks: (B:3:0x0005, B:7:0x0044, B:11:0x006f, B:13:0x0086, B:14:0x0090, B:16:0x00a7, B:17:0x00bb, B:19:0x00cc, B:21:0x00d0, B:24:0x00d5, B:29:0x00aa, B:31:0x00b2, B:34:0x0089, B:37:0x0060, B:39:0x0066, B:42:0x0037), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e() {
        java.lang.reflect.Method method;
        java.lang.String str;
        int i;
        boolean z;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String a2;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            method = java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class);
            method.setAccessible(true);
            str = (java.lang.String) method.invoke(null, "gsm.version.baseband");
            jSONObject.put("baseband", str);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            i = 1;
        } else {
            if (str.contains("1.0.0.0")) {
                i = 0;
                z = true;
                str2 = (java.lang.String) method.invoke(null, "ro.product.board");
                jSONObject.put("board", str2);
                if (!android.text.TextUtils.isEmpty(str2)) {
                    i++;
                } else if (str2.contains(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM) || str2.contains("goldfish")) {
                    z = true;
                }
                str3 = (java.lang.String) method.invoke(null, "ro.board.platform");
                jSONObject.put("platform", str3);
                if (!android.text.TextUtils.isEmpty(str3)) {
                    i++;
                } else if (str3.contains(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM)) {
                    z = true;
                }
                str4 = (java.lang.String) method.invoke(null, "ro.build.flavor");
                jSONObject.put("flavor", str4);
                if (!android.text.TextUtils.isEmpty(str4)) {
                    i++;
                } else if (str4.contains("vbox") || str3.contains("sdk_gphone")) {
                    z = true;
                }
                a2 = com.getui.gtc.extension.distribution.gbd.n.a.f.a("cat /proc/self/cgroup");
                jSONObject.put("cgroup", a2);
                if (android.text.TextUtils.isEmpty(a2)) {
                    i++;
                }
                if (z) {
                    this.e = true;
                }
                if (i >= 2) {
                    this.d++;
                }
                this.h = jSONObject;
            }
            i = 0;
        }
        z = false;
        str2 = (java.lang.String) method.invoke(null, "ro.product.board");
        jSONObject.put("board", str2);
        if (!android.text.TextUtils.isEmpty(str2)) {
        }
        str3 = (java.lang.String) method.invoke(null, "ro.board.platform");
        jSONObject.put("platform", str3);
        if (!android.text.TextUtils.isEmpty(str3)) {
        }
        str4 = (java.lang.String) method.invoke(null, "ro.build.flavor");
        jSONObject.put("flavor", str4);
        if (!android.text.TextUtils.isEmpty(str4)) {
        }
        a2 = com.getui.gtc.extension.distribution.gbd.n.a.f.a("cat /proc/self/cgroup");
        jSONObject.put("cgroup", a2);
        if (android.text.TextUtils.isEmpty(a2)) {
        }
        if (z) {
        }
        if (i >= 2) {
        }
        this.h = jSONObject;
    }

    private void f() {
        java.lang.String d = com.getui.gtc.extension.distribution.gbd.n.a.f.d();
        this.i = d;
        if (d.contains("intel") || this.i.contains("amd")) {
            this.d++;
        }
    }

    private void g() {
        if (com.getui.gtc.extension.distribution.gbd.n.a.g.a().b()) {
            this.d++;
        }
    }

    private org.json.JSONObject h() {
        return this.f;
    }

    private org.json.JSONObject i() {
        return this.g;
    }

    private org.json.JSONObject j() {
        return this.h;
    }

    private java.lang.String k() {
        return this.i;
    }

    private static boolean l() {
        java.lang.String str = android.os.Build.FINGERPRINT;
        if (!str.contains("generic") && !str.contains("unknown") && !str.contains("generic_x86") && !str.contains("vbox")) {
            java.lang.String str2 = android.os.Build.MODEL;
            if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || android.os.Build.MANUFACTURER.contains("Genymotion")) {
                return true;
            }
            java.lang.String str3 = android.os.Build.HARDWARE;
            if (!"goldfish".equals(str3) && !"ranchu".equals(str3)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x012d A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109), top: B:28:0x00d9, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0158 A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109), top: B:28:0x00d9, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017b A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109), top: B:28:0x00d9, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a0 A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109), top: B:28:0x00d9, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a4 A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109), top: B:28:0x00d9, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01a8 A[Catch: all -> 0x01ae, TRY_LEAVE, TryCatch #2 {all -> 0x01ae, blocks: (B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109), top: B:28:0x00d9, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01be A[Catch: all -> 0x01fd, TryCatch #1 {all -> 0x01fd, blocks: (B:4:0x0002, B:26:0x00d3, B:50:0x01b2, B:52:0x01be, B:53:0x01c3, B:55:0x01d1, B:57:0x01e0, B:59:0x01ea, B:60:0x01ef, B:62:0x01f3, B:64:0x01f8, B:72:0x01db, B:91:0x01af, B:107:0x00d0, B:109:0x0070, B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109, B:23:0x0073, B:25:0x007d, B:92:0x0085, B:95:0x0095, B:97:0x00b4, B:99:0x00ba, B:100:0x00bc, B:101:0x00c0, B:103:0x00c6, B:105:0x00cc, B:7:0x000b, B:9:0x0015, B:12:0x0020, B:14:0x002b, B:15:0x006c, B:17:0x0044, B:19:0x0061, B:21:0x0067), top: B:3:0x0002, outer: #0, inners: #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ea A[Catch: all -> 0x01fd, TryCatch #1 {all -> 0x01fd, blocks: (B:4:0x0002, B:26:0x00d3, B:50:0x01b2, B:52:0x01be, B:53:0x01c3, B:55:0x01d1, B:57:0x01e0, B:59:0x01ea, B:60:0x01ef, B:62:0x01f3, B:64:0x01f8, B:72:0x01db, B:91:0x01af, B:107:0x00d0, B:109:0x0070, B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109, B:23:0x0073, B:25:0x007d, B:92:0x0085, B:95:0x0095, B:97:0x00b4, B:99:0x00ba, B:100:0x00bc, B:101:0x00c0, B:103:0x00c6, B:105:0x00cc, B:7:0x000b, B:9:0x0015, B:12:0x0020, B:14:0x002b, B:15:0x006c, B:17:0x0044, B:19:0x0061, B:21:0x0067), top: B:3:0x0002, outer: #0, inners: #2, #3, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017e A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109), top: B:28:0x00d9, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015b A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109), top: B:28:0x00d9, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0130 A[Catch: all -> 0x01ae, TryCatch #2 {all -> 0x01ae, blocks: (B:29:0x00d9, B:33:0x0116, B:35:0x012d, B:36:0x0141, B:38:0x0158, B:39:0x0164, B:41:0x017b, B:42:0x018f, B:44:0x01a0, B:46:0x01a4, B:48:0x01a8, B:73:0x017e, B:75:0x0186, B:78:0x015b, B:81:0x0130, B:83:0x0138, B:86:0x0109), top: B:28:0x00d9, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean a(android.content.Context context) {
        org.json.JSONObject jSONObject;
        java.lang.String d;
        java.lang.reflect.Method method;
        java.lang.String str;
        int i;
        boolean z;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String a2;
        int i2;
        try {
            this.a = false;
            this.b = false;
            this.d = 0;
            this.e = false;
            try {
                if (com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.BLUETOOTH") && com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, "android.permission.BLUETOOTH_ADMIN")) {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    android.bluetooth.BluetoothAdapter defaultAdapter = android.bluetooth.BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter == null) {
                        this.d++;
                        jSONObject2.put("enable", false);
                        jSONObject2.put("name", "");
                        jSONObject2.put("address", "");
                    } else {
                        jSONObject2.put("enable", true);
                        jSONObject2.put("name", defaultAdapter.getName());
                        jSONObject2.put("address", defaultAdapter.getAddress());
                        if (defaultAdapter.getName() == null || defaultAdapter.getAddress() == null) {
                            this.d++;
                        }
                    }
                    this.f = jSONObject2;
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            try {
                if (com.getui.gtc.extension.distribution.gbd.n.l.a(com.getui.gtc.extension.distribution.gbd.d.c.d, com.anythink.china.common.d.a)) {
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                    java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.n.l.a(true);
                    if (!android.text.TextUtils.isEmpty(a3)) {
                        java.lang.String a4 = com.getui.gtc.extension.distribution.gbd.n.a.f.a(context);
                        java.lang.String a5 = com.getui.gtc.extension.distribution.gbd.n.a.f.a();
                        jSONObject3.put("level0", a3);
                        jSONObject3.put("level1", a4);
                        jSONObject3.put("level2", a5);
                        this.g = jSONObject3;
                        if (!android.text.TextUtils.isEmpty(a4) && !a4.equals(a3)) {
                            i2 = this.d;
                        } else if (!android.text.TextUtils.isEmpty(a5) && !a5.equals(a3)) {
                            i2 = this.d;
                        }
                        this.d = i2 + 1;
                    }
                } else {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "no ph p.");
                }
            } catch (java.lang.Throwable th2) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
            }
            jSONObject = new org.json.JSONObject();
            try {
                method = java.lang.Class.forName("android.os.SystemProperties").getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class);
                method.setAccessible(true);
                str = (java.lang.String) method.invoke(null, "gsm.version.baseband");
                jSONObject.put("baseband", str);
            } catch (java.lang.Throwable th3) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th3);
            }
        } catch (java.lang.Throwable th4) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th4);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            i = 1;
        } else if (str.contains("1.0.0.0")) {
            i = 0;
            z = true;
            str2 = (java.lang.String) method.invoke(null, "ro.product.board");
            jSONObject.put("board", str2);
            if (!android.text.TextUtils.isEmpty(str2)) {
                i++;
            } else if (str2.contains(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM) || str2.contains("goldfish")) {
                z = true;
            }
            str3 = (java.lang.String) method.invoke(null, "ro.board.platform");
            jSONObject.put("platform", str3);
            if (!android.text.TextUtils.isEmpty(str3)) {
                i++;
            } else if (str3.contains(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM)) {
                z = true;
            }
            str4 = (java.lang.String) method.invoke(null, "ro.build.flavor");
            jSONObject.put("flavor", str4);
            if (!android.text.TextUtils.isEmpty(str4)) {
                i++;
            } else if (str4.contains("vbox") || str3.contains("sdk_gphone")) {
                z = true;
            }
            a2 = com.getui.gtc.extension.distribution.gbd.n.a.f.a("cat /proc/self/cgroup");
            jSONObject.put("cgroup", a2);
            if (android.text.TextUtils.isEmpty(a2)) {
                i++;
            }
            if (z) {
                this.e = true;
            }
            if (i >= 2) {
                this.d++;
            }
            this.h = jSONObject;
            if (com.getui.gtc.extension.distribution.gbd.n.a.f.b(context).size() == 0) {
                this.d++;
            }
            d = com.getui.gtc.extension.distribution.gbd.n.a.f.d();
            this.i = d;
            if (!d.contains("intel") || this.i.contains("amd")) {
                this.d++;
            }
            if (com.getui.gtc.extension.distribution.gbd.n.a.g.a().b()) {
                this.d++;
            }
            this.a = !this.e || this.d >= 2;
            this.b = true;
        } else {
            i = 0;
        }
        z = false;
        str2 = (java.lang.String) method.invoke(null, "ro.product.board");
        jSONObject.put("board", str2);
        if (!android.text.TextUtils.isEmpty(str2)) {
        }
        str3 = (java.lang.String) method.invoke(null, "ro.board.platform");
        jSONObject.put("platform", str3);
        if (!android.text.TextUtils.isEmpty(str3)) {
        }
        str4 = (java.lang.String) method.invoke(null, "ro.build.flavor");
        jSONObject.put("flavor", str4);
        if (!android.text.TextUtils.isEmpty(str4)) {
        }
        a2 = com.getui.gtc.extension.distribution.gbd.n.a.f.a("cat /proc/self/cgroup");
        jSONObject.put("cgroup", a2);
        if (android.text.TextUtils.isEmpty(a2)) {
        }
        if (z) {
        }
        if (i >= 2) {
        }
        this.h = jSONObject;
        if (com.getui.gtc.extension.distribution.gbd.n.a.f.b(context).size() == 0) {
        }
        d = com.getui.gtc.extension.distribution.gbd.n.a.f.d();
        this.i = d;
        if (!d.contains("intel")) {
        }
        this.d++;
        if (com.getui.gtc.extension.distribution.gbd.n.a.g.a().b()) {
        }
        this.a = !this.e || this.d >= 2;
        this.b = true;
        return this.a;
    }
}
