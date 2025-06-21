package com.getui.gtc.extension.distribution.gbd.a.a;

/* loaded from: classes22.dex */
public class b implements com.getui.gtc.extension.distribution.gbd.a.a {
    private static final java.lang.String a = "GBD_RCLA";
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    private static volatile com.getui.gtc.extension.distribution.gbd.a.a.b e;
    private java.util.List<android.content.pm.PackageInfo> f = new java.util.ArrayList();

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.util.List<android.content.pm.PackageInfo>, java.lang.Object> {
        final /* synthetic */ java.lang.StringBuilder a;

        public AnonymousClass1(java.lang.StringBuilder sb) {
            this.a = sb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public java.lang.Object a(java.util.List<android.content.pm.PackageInfo> list) {
            for (android.content.pm.PackageInfo packageInfo : list) {
                try {
                    android.content.pm.PackageInfo a = com.getui.gtc.extension.distribution.gbd.n.k.a(packageInfo.packageName, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD);
                    this.a.append(packageInfo.packageName);
                    this.a.append("#");
                    this.a.append(packageInfo.versionName);
                    this.a.append("#");
                    this.a.append(packageInfo.versionCode);
                    this.a.append("#");
                    this.a.append(com.getui.gtc.extension.distribution.gbd.a.a.b.a(a));
                    if (com.getui.gtc.extension.distribution.gbd.d.d.cs) {
                        this.a.append("#");
                        this.a.append((java.lang.CharSequence) com.getui.gtc.extension.distribution.gbd.a.a.b.e(a));
                        this.a.append("#");
                        java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.l.a(a, com.getui.gtc.extension.distribution.gbd.a.a.b.g());
                        if (!android.text.TextUtils.isEmpty(a2)) {
                            this.a.append(a2);
                        }
                        this.a.append("#");
                        this.a.append((java.lang.CharSequence) com.getui.gtc.extension.distribution.gbd.a.a.b.f(a));
                    } else {
                        this.a.append("#");
                        this.a.append("#");
                        this.a.append("#");
                    }
                    this.a.append("#");
                    this.a.append(com.getui.gtc.extension.distribution.gbd.n.b.c(a));
                    this.a.append(",");
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
            }
            return null;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.b$2, reason: invalid class name */
    public class AnonymousClass2 implements com.getui.gtc.extension.distribution.gbd.g.c {
        public AnonymousClass2() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            try {
                if (obj == null) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.a.b.a, "al d f.");
                    com.getui.gtc.extension.distribution.gbd.a.a.b.this.a((byte[]) null);
                } else {
                    com.getui.gtc.extension.distribution.gbd.d.h.aL = false;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.a.b.a, "al d s.");
                    com.getui.gtc.extension.distribution.gbd.a.a.b.this.a((byte[]) obj);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.b$3, reason: invalid class name */
    public class AnonymousClass3 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String[], java.lang.Object> {
        public AnonymousClass3() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private java.lang.Object a2(java.lang.String[] strArr) {
            for (java.lang.String str : strArr) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                    android.content.pm.PackageInfo f = com.getui.gtc.extension.distribution.gbd.n.l.f(str);
                    if (f != null && (f.applicationInfo.flags & 1) == 0 && !com.getui.gtc.extension.distribution.gbd.a.a.b.a(com.getui.gtc.extension.distribution.gbd.a.a.b.this.f, f.packageName)) {
                        com.getui.gtc.extension.distribution.gbd.a.a.b.this.f.add(f);
                    }
                }
            }
            return null;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.Object a(java.lang.String[] strArr) {
            for (java.lang.String str : strArr) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                    android.content.pm.PackageInfo f = com.getui.gtc.extension.distribution.gbd.n.l.f(str);
                    if (f != null && (f.applicationInfo.flags & 1) == 0 && !com.getui.gtc.extension.distribution.gbd.a.a.b.a(com.getui.gtc.extension.distribution.gbd.a.a.b.this.f, f.packageName)) {
                        com.getui.gtc.extension.distribution.gbd.a.a.b.this.f.add(f);
                    }
                }
            }
            return null;
        }
    }

    private b() {
    }

    private static java.lang.String a(int i) {
        java.lang.String[] split;
        try {
            if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cu) && (split = com.getui.gtc.extension.distribution.gbd.d.d.cu.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) != null && split.length > 0 && split.length < 4) {
                if (split.length == 1) {
                    return i == 0 ? split[i] : "";
                }
                if (split.length == 2) {
                    if (i != 0 && i != 1) {
                        return "";
                    }
                    return split[i];
                }
                if (split.length == 3) {
                    return split[i];
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return "";
    }

    public static /* synthetic */ java.lang.String a(android.content.pm.PackageInfo packageInfo) {
        java.lang.String[] split;
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cr)) {
            return "";
        }
        java.lang.String[] split2 = com.getui.gtc.extension.distribution.gbd.d.d.cr.split(",");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : split2) {
            if (!android.text.TextUtils.isEmpty(str) && (split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) != null && split.length >= 2 && split.length <= 4 && a(split, packageInfo)) {
                sb.append(split[0]);
                sb.append("&");
            }
        }
        if (!android.text.TextUtils.isEmpty(sb) && sb.toString().endsWith("&")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private java.lang.String a(java.util.List<android.content.pm.PackageInfo> list, int i) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "package data, 254");
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C()));
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(format);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
        sb.append("|");
        a(list, sb);
        if (sb.toString().endsWith(",")) {
            sb = sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("|");
        sb.append(i);
        sb.append("|");
        sb.append(com.sensorsdata.sf.ui.view.UIProperty.action_android);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.b.o());
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.n.b.p());
        return sb.toString();
    }

    private void a(java.lang.String str) {
        java.util.List<android.content.pm.PackageInfo> list = this.f;
        if (list != null) {
            list.clear();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() <= com.getui.gtc.extension.distribution.gbd.d.d.ct) {
            b(str);
            return;
        }
        java.lang.String[] split = str.split("\\|");
        if (split.length >= 6) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(split[0]);
            sb.append("|");
            sb.append(split[1]);
            sb.append("|");
            sb.append(split[2]);
            sb.append("|");
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("|");
            sb2.append(split[split.length - 2]);
            sb2.append("|");
            sb2.append(split[split.length - 1]);
            java.lang.String[] split2 = str.substring(sb.toString().length(), str.length() - sb2.length()).split(",");
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            int length = (com.getui.gtc.extension.distribution.gbd.d.d.ct - sb.length()) - sb2.length();
            int i = 0;
            while (i < split2.length) {
                java.lang.String str2 = split2[i];
                if (sb3.length() + str2.length() <= length) {
                    sb3.append(str2);
                    sb3.append(",");
                    if (i != split2.length - 1) {
                        i++;
                    } else {
                        if (sb3.toString().endsWith(",")) {
                            sb3 = sb3.deleteCharAt(sb3.length() - 1);
                        }
                        sb4.append((java.lang.CharSequence) sb);
                        sb4.append((java.lang.CharSequence) sb3);
                        sb4.append((java.lang.CharSequence) sb2);
                        b(sb4.toString());
                        sb3.delete(0, sb3.length());
                    }
                } else {
                    if (sb3.toString().endsWith(",")) {
                        sb3 = sb3.deleteCharAt(sb3.length() - 1);
                    }
                    sb4.append((java.lang.CharSequence) sb);
                    sb4.append((java.lang.CharSequence) sb3);
                    sb4.append((java.lang.CharSequence) sb2);
                    if (!android.text.TextUtils.isEmpty(sb3)) {
                        b(sb4.toString());
                        sb3.delete(0, sb3.length());
                        i--;
                    }
                }
                sb4.delete(0, sb4.length());
                i++;
            }
        }
    }

    private void a(java.util.List<android.content.pm.PackageInfo> list, java.lang.StringBuilder sb) {
        if (list == null) {
            return;
        }
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.cw, "al", list, new com.getui.gtc.extension.distribution.gbd.a.a.b.AnonymousClass1(sb));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            java.lang.String f = com.getui.gtc.extension.distribution.gbd.n.b.f();
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "read form local fileName = ".concat(java.lang.String.valueOf(f)));
            bArr = com.getui.gtc.extension.distribution.gbd.n.i.a(f);
            if (bArr == null) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "read form local list = null");
                a(a(this.f, 2));
                return;
            }
        }
        java.lang.String[] split = new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.n.b(com.getui.gtc.extension.distribution.gbd.n.t.a(bArr, com.getui.gtc.extension.distribution.gbd.d.g.ad))).split("\\r");
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "rf local al len = " + split.length);
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "28 al-c start, 254");
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.b, split, new com.getui.gtc.extension.distribution.gbd.a.a.b.AnonymousClass3());
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, "28 al-c end, 254");
        if (this.f.isEmpty()) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "get from server size = 0");
            return;
        }
        java.lang.String a2 = a(this.f, 1);
        com.getui.gtc.extension.distribution.gbd.n.j.a("final data = ".concat(java.lang.String.valueOf(a2)));
        a(a2);
    }

    public static /* synthetic */ boolean a(java.util.List list, java.lang.String str) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((android.content.pm.PackageInfo) it.next()).packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(java.lang.String[] strArr, android.content.pm.PackageInfo packageInfo) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        android.os.Bundle bundle;
        android.content.pm.ServiceInfo[] serviceInfoArr;
        android.content.pm.ActivityInfo[] activityInfoArr;
        if (packageInfo == null) {
            return false;
        }
        try {
            str = strArr[0];
            str2 = strArr[1];
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "check compete error = ".concat(java.lang.String.valueOf(th)));
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String str4 = "";
        if (strArr.length == 3) {
            str4 = strArr[2];
            str3 = "";
        } else if (strArr.length == 4) {
            str4 = strArr[2];
            str3 = strArr[3];
        } else {
            str3 = "";
        }
        if (!android.text.TextUtils.isEmpty(str2) && (activityInfoArr = packageInfo.activities) != null) {
            java.lang.String[] split = str2.split("&");
            for (android.content.pm.ActivityInfo activityInfo : activityInfoArr) {
                for (java.lang.String str5 : split) {
                    if (str5.equals(activityInfo.name)) {
                        return true;
                    }
                }
            }
        }
        if (!android.text.TextUtils.isEmpty(str4) && (serviceInfoArr = packageInfo.services) != null) {
            java.lang.String[] split2 = str4.split("&");
            for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
                for (java.lang.String str6 : split2) {
                    if (str6.equals(serviceInfo.name)) {
                        return true;
                    }
                }
            }
        }
        if (!android.text.TextUtils.isEmpty(str3) && (bundle = packageInfo.applicationInfo.metaData) != null) {
            java.lang.String[] split3 = str3.split("&");
            java.util.Set<java.lang.String> keySet = bundle.keySet();
            if (keySet != null && keySet.size() > 0) {
                for (java.lang.String str7 : keySet) {
                    for (java.lang.String str8 : split3) {
                        if (str8.equals(str7)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static void b(java.lang.String str) {
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(com.getui.gtc.extension.distribution.gbd.d.g.aI)) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "instant r 254");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(str, com.getui.gtc.extension.distribution.gbd.d.g.aI);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "not instant r 254");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(str, com.getui.gtc.extension.distribution.gbd.d.g.aI);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "al data: type = 254 content = ".concat(java.lang.String.valueOf(str)));
    }

    private static boolean b(java.util.List<android.content.pm.PackageInfo> list, java.lang.String str) {
        java.util.Iterator<android.content.pm.PackageInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static java.lang.String d(android.content.pm.PackageInfo packageInfo) {
        java.lang.String[] split;
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cr)) {
            return "";
        }
        java.lang.String[] split2 = com.getui.gtc.extension.distribution.gbd.d.d.cr.split(",");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : split2) {
            if (!android.text.TextUtils.isEmpty(str) && (split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) != null && split.length >= 2 && split.length <= 4 && a(split, packageInfo)) {
                sb.append(split[0]);
                sb.append("&");
            }
        }
        if (!android.text.TextUtils.isEmpty(sb) && sb.toString().endsWith("&")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.StringBuilder e(android.content.pm.PackageInfo packageInfo) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (packageInfo != null) {
            try {
                android.content.pm.ServiceInfo[] serviceInfoArr = packageInfo.services;
                if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                    java.lang.String a2 = a(1);
                    if (com.getui.gtc.extension.distribution.gbd.d.d.cu.equals("*")) {
                        for (android.content.pm.ServiceInfo serviceInfo : serviceInfoArr) {
                            sb.append(serviceInfo.name);
                            sb.append("&");
                        }
                    } else if (!android.text.TextUtils.isEmpty(a2)) {
                        java.lang.String[] split = a2.split("&");
                        for (int i = 0; i < serviceInfoArr.length; i++) {
                            int length = split.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 < length) {
                                    if (serviceInfoArr[i].name.contains(split[i2])) {
                                        sb.append(serviceInfoArr[i].name);
                                        sb.append("&");
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "get as e = ".concat(java.lang.String.valueOf(th)));
            }
        }
        if (!android.text.TextUtils.isEmpty(sb) && sb.toString().endsWith("&")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb;
    }

    public static com.getui.gtc.extension.distribution.gbd.a.a.b f() {
        if (e == null) {
            synchronized (com.getui.gtc.extension.distribution.gbd.a.a.b.class) {
                if (e == null) {
                    e = new com.getui.gtc.extension.distribution.gbd.a.a.b();
                }
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static java.lang.StringBuilder f(android.content.pm.PackageInfo packageInfo) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (packageInfo != null) {
            try {
                android.content.pm.ActivityInfo[] activityInfoArr = packageInfo.activities;
                if (activityInfoArr != null && activityInfoArr.length > 0) {
                    java.lang.String a2 = a(0);
                    if (com.getui.gtc.extension.distribution.gbd.d.d.cu.equals("*")) {
                        for (android.content.pm.ActivityInfo activityInfo : activityInfoArr) {
                            sb.append(activityInfo.name);
                            sb.append("&");
                        }
                    } else if (!android.text.TextUtils.isEmpty(a2)) {
                        java.lang.String[] split = a2.split("&");
                        for (int i = 0; i < activityInfoArr.length; i++) {
                            int length = split.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 < length) {
                                    if (activityInfoArr[i].name.contains(split[i2])) {
                                        sb.append(activityInfoArr[i].name);
                                        sb.append("&");
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "get as e = ".concat(java.lang.String.valueOf(th)));
            }
        }
        if (!android.text.TextUtils.isEmpty(sb) && sb.toString().endsWith("&")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb;
    }

    public static /* synthetic */ java.lang.String g() {
        return a(2);
    }

    private static boolean h() {
        com.getui.gtc.extension.distribution.gbd.n.j.b("pre check 2818al-c , 254");
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.k, com.getui.gtc.extension.distribution.gbd.f.b.b);
    }

    private void i() {
        try {
            java.lang.String f = com.getui.gtc.extension.distribution.gbd.n.b.f();
            boolean z = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.aD > 86400000;
            boolean i = com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d);
            boolean z2 = com.getui.gtc.extension.distribution.gbd.d.h.aL;
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "d al, isC = " + i + ", need up = " + z2);
            if (!z || !i || (new java.io.File(f).exists() && !z2)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "al old file exist");
                a((byte[]) null);
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "start d al.");
            if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bR)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "al url empty,d cancel.");
                return;
            }
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.b(java.lang.System.currentTimeMillis());
            com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.a.a.b.AnonymousClass2(), 28, null);
            bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.bR;
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th.getMessage());
        }
    }

    private void j() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bR)) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "al url empty,d cancel.");
            return;
        }
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.b(java.lang.System.currentTimeMillis());
        com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.a.a.b.AnonymousClass2(), 28, null);
        bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.bR;
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "doSample");
            if (com.getui.gtc.extension.distribution.gbd.n.l.c(com.getui.gtc.extension.distribution.gbd.d.g.aI)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(a, "type 254 in type black list, return.");
                return;
            }
            java.util.List<android.content.pm.PackageInfo> list = this.f;
            if (list != null) {
                list.clear();
            }
            boolean z = true;
            try {
                for (android.content.pm.PackageInfo packageInfo : com.getui.gtc.extension.distribution.gbd.n.b.a()) {
                    if ((packageInfo.applicationInfo.flags & 1) == 0) {
                        this.f.add(packageInfo);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "third al size = " + this.f.size());
            boolean c2 = com.getui.gtc.extension.distribution.gbd.n.l.c(com.getui.gtc.extension.distribution.gbd.d.c.d);
            boolean a2 = com.getui.gtc.extension.distribution.gbd.n.l.a();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("isAdbModeSafe = ");
            sb.append(!c2);
            sb.append(", isAppDebug = ");
            sb.append(a2);
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, sb.toString());
            if (this.f.size() <= com.getui.gtc.extension.distribution.gbd.d.d.ch) {
                com.getui.gtc.extension.distribution.gbd.n.j.b("pre check 2818al-c , 254");
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                if (com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.k, com.getui.gtc.extension.distribution.gbd.f.b.b) && !c2 && !a2) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(a, "handle al with 1.8w");
                    try {
                        java.lang.String f = com.getui.gtc.extension.distribution.gbd.n.b.f();
                        if (java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.aD <= 86400000) {
                            z = false;
                        }
                        boolean i = com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d);
                        boolean z2 = com.getui.gtc.extension.distribution.gbd.d.h.aL;
                        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "d al, isC = " + i + ", need up = " + z2);
                        if (!z || !i || (new java.io.File(f).exists() && !z2)) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "al old file exist");
                            a((byte[]) null);
                            return;
                        }
                        com.getui.gtc.extension.distribution.gbd.n.j.a(a, "start d al.");
                        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bR)) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "al url empty,d cancel.");
                            return;
                        }
                        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                        com.getui.gtc.extension.distribution.gbd.f.a.b.b(java.lang.System.currentTimeMillis());
                        com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.a.a.b.AnonymousClass2(), 28, null);
                        bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.bR;
                        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
                        return;
                    } catch (java.lang.Throwable th2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(a, th2.getMessage());
                        return;
                    }
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, "handle al without 1.8w");
            a(a(this.f, 0));
        } catch (java.lang.Throwable th3) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(a, th3.getMessage());
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return com.getui.gtc.extension.distribution.gbd.d.g.aI;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String d() {
        return null;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String e() {
        return null;
    }
}
