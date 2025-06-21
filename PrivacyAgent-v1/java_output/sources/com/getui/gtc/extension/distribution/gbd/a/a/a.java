package com.getui.gtc.extension.distribution.gbd.a.a;

/* loaded from: classes22.dex */
public final class a implements com.getui.gtc.extension.distribution.gbd.a.a {
    private static final java.lang.String d = "GBD_RALA";
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 0;
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = 3;
    private static com.getui.gtc.extension.distribution.gbd.a.a.a l;
    private int m = 0;
    final java.util.List<android.content.pm.PackageInfo> a = new java.util.ArrayList();
    final java.util.List<android.content.pm.PackageInfo> b = new java.util.ArrayList();
    java.util.List<java.lang.String> c = new java.util.ArrayList();

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.util.List<android.content.pm.PackageInfo>, java.lang.String> {
        public AnonymousClass1() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public java.lang.String a(java.util.List<android.content.pm.PackageInfo> list) {
            boolean z;
            int i;
            java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.h.u.split("&");
            com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.a.a.d, "active 24 old al = " + com.getui.gtc.extension.distribution.gbd.d.h.u);
            java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(split));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) com.getui.gtc.extension.distribution.gbd.d.c.d.getSystemService("appops");
            android.content.pm.PackageManager packageManager = com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageManager();
            java.lang.String packageName = com.getui.gtc.extension.distribution.gbd.d.c.d.getPackageName();
            for (android.content.pm.PackageInfo packageInfo : list) {
                try {
                    java.lang.String str = packageInfo.packageName;
                    if (com.getui.gtc.extension.distribution.gbd.n.l.a(str)) {
                        com.getui.gtc.extension.distribution.gbd.a.a.a.this.c.add(str);
                    }
                    if (!arrayList.contains(str)) {
                        sb.append("&");
                        sb.append(str);
                    }
                    sb2.append(str);
                    sb2.append("#");
                    java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                    sb2.append(com.getui.gtc.extension.distribution.gbd.n.l.i(str));
                    sb2.append("#");
                    sb2.append(packageInfo.versionName);
                    sb2.append("#");
                    sb2.append(packageInfo.versionCode);
                    sb2.append("#");
                    sb2.append(com.getui.gtc.extension.distribution.gbd.n.b.a(packageInfo));
                    sb2.append("#");
                    sb2.append(com.getui.gtc.extension.distribution.gbd.n.l.a(packageInfo));
                    sb2.append("#");
                    sb2.append("#");
                    sb2.append("#");
                    sb2.append(packageInfo.lastUpdateTime);
                    sb2.append("#");
                    int i2 = 1;
                    if (!((packageInfo.applicationInfo.flags & 2) > 0)) {
                        i2 = 0;
                    }
                    sb2.append(i2);
                    sb2.append("#");
                    if (com.getui.gtc.extension.distribution.gbd.d.d.u) {
                        sb2.append(com.getui.gtc.extension.distribution.gbd.n.l.o(str).replace(",", "$"));
                    }
                    sb2.append("#");
                    z = com.getui.gtc.extension.distribution.gbd.d.d.j;
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
                if (z && appOpsManager != null && packageManager != null && packageName != null) {
                    i = packageName.equals(packageInfo.packageName) ? com.getui.gtc.extension.distribution.gbd.n.l.m(com.getui.gtc.extension.distribution.gbd.d.c.d) : com.getui.gtc.extension.distribution.gbd.n.l.a(z, packageInfo, appOpsManager, packageManager);
                    sb2.append(i);
                    sb2.append("#");
                    sb2.append(com.getui.gtc.extension.distribution.gbd.n.b.c(packageInfo));
                    sb2.append(",");
                }
                i = -1;
                sb2.append(i);
                sb2.append("#");
                sb2.append(com.getui.gtc.extension.distribution.gbd.n.b.c(packageInfo));
                sb2.append(",");
            }
            if (!android.text.TextUtils.isEmpty(sb)) {
                com.getui.gtc.extension.distribution.gbd.d.h.u += sb.substring(android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.u) ? 1 : 0);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.a.a.d, "24 new al to db form 28 = " + com.getui.gtc.extension.distribution.gbd.d.h.u);
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.f(com.getui.gtc.extension.distribution.gbd.d.h.u);
            return sb2.toString();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.getui.gtc.extension.distribution.gbd.g.c {
        public AnonymousClass2() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            try {
                if (obj == null) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.a.a.d, "al d f.");
                    com.getui.gtc.extension.distribution.gbd.a.a.a.this.a((byte[]) null);
                } else {
                    com.getui.gtc.extension.distribution.gbd.d.h.aL = false;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.a.a.d, "al d s.");
                    com.getui.gtc.extension.distribution.gbd.a.a.a.this.a((byte[]) obj);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.a$3, reason: invalid class name */
    public class AnonymousClass3 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String[], java.lang.Object> {
        public AnonymousClass3() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private java.lang.Object a2(java.lang.String[] strArr) {
            for (java.lang.String str : strArr) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    android.content.pm.PackageInfo a = com.getui.gtc.extension.distribution.gbd.n.l.a(str, com.getui.gtc.extension.distribution.gbd.d.d.j ? 4096 : 0);
                    if (a != null && (a.applicationInfo.flags & 1) == 0 && !com.getui.gtc.extension.distribution.gbd.a.a.a.a(com.getui.gtc.extension.distribution.gbd.a.a.a.this.a, a.packageName)) {
                        com.getui.gtc.extension.distribution.gbd.a.a.a.this.a.add(a);
                    }
                }
            }
            return null;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.Object a(java.lang.String[] strArr) {
            for (java.lang.String str : strArr) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    android.content.pm.PackageInfo a = com.getui.gtc.extension.distribution.gbd.n.l.a(str, com.getui.gtc.extension.distribution.gbd.d.d.j ? 4096 : 0);
                    if (a != null && (a.applicationInfo.flags & 1) == 0 && !com.getui.gtc.extension.distribution.gbd.a.a.a.a(com.getui.gtc.extension.distribution.gbd.a.a.a.this.a, a.packageName)) {
                        com.getui.gtc.extension.distribution.gbd.a.a.a.this.a.add(a);
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.a$4, reason: invalid class name */
    public class AnonymousClass4 implements com.getui.gtc.extension.distribution.gbd.g.c {
        public AnonymousClass4() {
        }

        @Override // com.getui.gtc.extension.distribution.gbd.g.c
        public final void a(java.lang.Object obj) {
            try {
                if (obj == null) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.a.a.d, "niche al d f.");
                    com.getui.gtc.extension.distribution.gbd.a.a.a.this.b((byte[]) null);
                } else {
                    com.getui.gtc.extension.distribution.gbd.d.h.aO = false;
                    com.getui.gtc.extension.distribution.gbd.n.j.a(com.getui.gtc.extension.distribution.gbd.a.a.a.d, "niche al d s.");
                    com.getui.gtc.extension.distribution.gbd.a.a.a.this.b((byte[]) obj);
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.a$5, reason: invalid class name */
    public class AnonymousClass5 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String[], java.lang.Object> {
        public AnonymousClass5() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private java.lang.Object a2(java.lang.String[] strArr) {
            for (java.lang.String str : strArr) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                    android.content.pm.PackageInfo f = com.getui.gtc.extension.distribution.gbd.n.l.f(str);
                    if (f != null && (f.applicationInfo.flags & 1) == 0 && !com.getui.gtc.extension.distribution.gbd.a.a.a.a(com.getui.gtc.extension.distribution.gbd.a.a.a.this.b, f.packageName)) {
                        com.getui.gtc.extension.distribution.gbd.a.a.a.this.b.add(f);
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
                    if (f != null && (f.applicationInfo.flags & 1) == 0 && !com.getui.gtc.extension.distribution.gbd.a.a.a.a(com.getui.gtc.extension.distribution.gbd.a.a.a.this.b, f.packageName)) {
                        com.getui.gtc.extension.distribution.gbd.a.a.a.this.b.add(f);
                    }
                }
            }
            return null;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.a$6, reason: invalid class name */
    public class AnonymousClass6 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String[], java.lang.String> {
        public AnonymousClass6() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.String a2(java.lang.String[] strArr) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.String str : strArr) {
                if (com.getui.gtc.extension.distribution.gbd.n.b.b(str)) {
                    sb.append(str);
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.String a(java.lang.String[] strArr) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.String str : strArr) {
                if (com.getui.gtc.extension.distribution.gbd.n.b.b(str)) {
                    sb.append(str);
                    sb.append(",");
                }
            }
            return sb.toString();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.a$7, reason: invalid class name */
    public class AnonymousClass7 implements com.getui.gtc.extension.distribution.gbd.f.j<java.util.List<android.content.pm.PackageInfo>, java.lang.String> {
        public AnonymousClass7() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public java.lang.String a(java.util.List<android.content.pm.PackageInfo> list) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (android.content.pm.PackageInfo packageInfo : list) {
                try {
                    if (com.getui.gtc.extension.distribution.gbd.n.l.a(packageInfo.packageName)) {
                        com.getui.gtc.extension.distribution.gbd.a.a.a.this.c.add(packageInfo.packageName);
                    }
                    sb.append(packageInfo.packageName);
                    sb.append("#");
                    java.lang.String str = packageInfo.packageName;
                    java.lang.String str2 = com.getui.gtc.extension.distribution.gbd.d.c.a;
                    sb.append(com.getui.gtc.extension.distribution.gbd.n.l.i(str));
                    sb.append("#");
                    sb.append(packageInfo.versionName);
                    sb.append("#");
                    sb.append(packageInfo.versionCode);
                    sb.append("#");
                    sb.append(com.getui.gtc.extension.distribution.gbd.n.b.a(packageInfo));
                    sb.append("#");
                    sb.append(com.getui.gtc.extension.distribution.gbd.n.l.a(packageInfo));
                    sb.append("#");
                    sb.append("#");
                    sb.append("#");
                    sb.append(packageInfo.lastUpdateTime);
                    sb.append("#");
                    int i = 1;
                    if (!((packageInfo.applicationInfo.flags & 2) > 0)) {
                        i = 0;
                    }
                    sb.append(i);
                    sb.append("#");
                    if (com.getui.gtc.extension.distribution.gbd.d.d.u) {
                        sb.append(com.getui.gtc.extension.distribution.gbd.n.l.o(packageInfo.packageName).replace(",", "$"));
                    }
                    sb.append("#");
                    sb.append(com.getui.gtc.extension.distribution.gbd.n.b.c(packageInfo));
                    sb.append(",");
                } catch (java.lang.Throwable th) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                }
            }
            return sb.toString();
        }
    }

    private a() {
    }

    private static int a(boolean z, android.content.pm.PackageInfo packageInfo, android.app.AppOpsManager appOpsManager, android.content.pm.PackageManager packageManager, java.lang.String str) {
        if (!z || packageInfo == null || appOpsManager == null || packageManager == null || str == null) {
            return -1;
        }
        return str.equals(packageInfo.packageName) ? com.getui.gtc.extension.distribution.gbd.n.l.m(com.getui.gtc.extension.distribution.gbd.d.c.d) : com.getui.gtc.extension.distribution.gbd.n.l.a(z, packageInfo, appOpsManager, packageManager);
    }

    private java.lang.String a(int i2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "niche al start， 128");
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(true, "al", this.b, new com.getui.gtc.extension.distribution.gbd.a.a.a.AnonymousClass7());
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "niche al end， 128");
        if (!android.text.TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (sb.toString().endsWith(",")) {
            sb = sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("|");
        sb.append(i2);
        return sb.toString();
    }

    private void a(java.util.List<android.content.pm.PackageInfo> list, int i2, int i3) {
        java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C()));
        if (this.c == null) {
            this.c = new java.util.ArrayList();
        }
        this.c.clear();
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "package data, 128");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(format);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
        sb.append("|");
        sb.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
        sb.append("|");
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "third24 al start， 128");
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(true, "al", list, new com.getui.gtc.extension.distribution.gbd.a.a.a.AnonymousClass1());
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "third24 al end， 128");
        if (!android.text.TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (sb.toString().endsWith(",")) {
            sb = sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("|");
        sb.append(i2);
        sb.append("|");
        sb.append(com.sensorsdata.sf.ui.view.UIProperty.action_android);
        sb.append("|");
        sb.append("|||");
        sb.append("|");
        sb.append("|");
        sb.append(m());
        sb.append("|");
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "niche al start， 128");
        com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        java.lang.String str2 = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(true, "al", this.b, new com.getui.gtc.extension.distribution.gbd.a.a.a.AnonymousClass7());
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "niche al end， 128");
        if (!android.text.TextUtils.isEmpty(str2)) {
            sb2.append(str2);
        }
        if (sb2.toString().endsWith(",")) {
            sb2 = sb2.deleteCharAt(sb2.length() - 1);
        }
        sb2.append("|");
        sb2.append(i3);
        sb.append(sb2.toString());
        b(sb.toString());
    }

    private static boolean a(java.lang.String str) {
        return com.getui.gtc.extension.distribution.gbd.n.b.b(str);
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

    private static /* synthetic */ int b(boolean z, android.content.pm.PackageInfo packageInfo, android.app.AppOpsManager appOpsManager, android.content.pm.PackageManager packageManager, java.lang.String str) {
        if (!z || packageInfo == null || appOpsManager == null || packageManager == null || str == null) {
            return -1;
        }
        return str.equals(packageInfo.packageName) ? com.getui.gtc.extension.distribution.gbd.n.l.m(com.getui.gtc.extension.distribution.gbd.d.c.d) : com.getui.gtc.extension.distribution.gbd.n.l.a(z, packageInfo, appOpsManager, packageManager);
    }

    private void b(java.lang.String str) {
        java.util.List<java.lang.String> list = this.c;
        if (list != null && !list.isEmpty()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.Iterator<java.lang.String> it = this.c.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append("&");
            }
            if (sb.toString().endsWith("&")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            java.lang.String sb2 = sb.toString();
            if (!android.text.TextUtils.isEmpty(sb2)) {
                com.getui.gtc.extension.distribution.gbd.d.h.y = sb2;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(187, com.getui.gtc.extension.distribution.gbd.n.ad.a(sb2.getBytes()));
            }
        }
        java.util.List<android.content.pm.PackageInfo> list2 = this.a;
        if (list2 != null) {
            list2.clear();
        }
        java.util.List<android.content.pm.PackageInfo> list3 = this.b;
        if (list3 != null) {
            list3.clear();
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() <= com.getui.gtc.extension.distribution.gbd.d.d.ct) {
            c(str);
            return;
        }
        java.lang.String[] split = str.split("\\|");
        if (split.length >= 6) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(split[0]);
            sb3.append("|");
            sb3.append(split[1]);
            sb3.append("|");
            sb3.append(split[2]);
            sb3.append("|");
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append("|");
            sb4.append(split[split.length - 2]);
            sb4.append("|");
            sb4.append(split[split.length - 1]);
            sb4.append("|");
            sb4.append("|||");
            sb4.append("|");
            java.lang.String[] split2 = str.substring(sb3.toString().length(), str.length() - sb4.length()).split(",");
            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
            java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "pkgList size = " + split2.length);
            int length = (com.getui.gtc.extension.distribution.gbd.d.d.ct - sb3.length()) - sb4.length();
            int i2 = 0;
            while (i2 < split2.length) {
                java.lang.String str2 = split2[i2];
                if (sb5.length() + str2.length() <= length) {
                    sb5.append(str2);
                    sb5.append(",");
                    if (i2 != split2.length - 1) {
                        i2++;
                    } else {
                        if (sb5.toString().endsWith(",")) {
                            sb5 = sb5.deleteCharAt(sb5.length() - 1);
                        }
                        sb6.append((java.lang.CharSequence) sb3);
                        sb6.append((java.lang.CharSequence) sb5);
                        sb6.append((java.lang.CharSequence) sb4);
                        c(sb6.toString());
                        sb5.delete(0, sb5.length());
                    }
                } else {
                    if (sb5.toString().endsWith(",")) {
                        sb5 = sb5.deleteCharAt(sb5.length() - 1);
                    }
                    sb6.append((java.lang.CharSequence) sb3);
                    sb6.append((java.lang.CharSequence) sb5);
                    sb6.append((java.lang.CharSequence) sb4);
                    if (!android.text.TextUtils.isEmpty(sb5)) {
                        c(sb6.toString());
                        sb5.delete(0, sb5.length());
                        i2--;
                    }
                }
                sb6.delete(0, sb6.length());
                i2++;
            }
        }
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

    private static void c(java.lang.String str) {
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(128)) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "instant r 128");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(str, 128);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "not instant r 128");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(str, 128);
        }
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "al data: type = 128 content = ".concat(java.lang.String.valueOf(str)));
    }

    public static synchronized com.getui.gtc.extension.distribution.gbd.a.a.a f() {
        com.getui.gtc.extension.distribution.gbd.a.a.a aVar;
        synchronized (com.getui.gtc.extension.distribution.gbd.a.a.a.class) {
            if (l == null) {
                l = new com.getui.gtc.extension.distribution.gbd.a.a.a();
            }
            aVar = l;
        }
        return aVar;
    }

    private static boolean g() {
        com.getui.gtc.extension.distribution.gbd.n.j.b("pre check 2818al-c , 128");
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.k, com.getui.gtc.extension.distribution.gbd.f.b.b);
    }

    private static boolean h() {
        com.getui.gtc.extension.distribution.gbd.n.j.b("pre check niche18al-c, 128");
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.cL, com.getui.gtc.extension.distribution.gbd.f.b.b);
    }

    private void i() {
        try {
            java.lang.String f2 = com.getui.gtc.extension.distribution.gbd.n.b.f();
            boolean z = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.aD > 86400000;
            boolean i2 = com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d);
            boolean z2 = com.getui.gtc.extension.distribution.gbd.d.h.aL;
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "d al, isC = " + i2 + ", need up = " + z2);
            if (!z || !i2 || (new java.io.File(f2).exists() && !z2)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "apl old file exist");
                a((byte[]) null);
                return;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "start d al.");
            if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bR)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "al url empty,d cancel.");
                this.m = 2;
                k();
            } else {
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.f.a.b.b(java.lang.System.currentTimeMillis());
                com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.a.a.a.AnonymousClass2(), 28, null);
                bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.bR;
                com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, th.getMessage());
        }
    }

    private void j() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bR)) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "al url empty,d cancel.");
            this.m = 2;
            k();
        } else {
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            com.getui.gtc.extension.distribution.gbd.f.a.b.b(java.lang.System.currentTimeMillis());
            com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.a.a.a.AnonymousClass2(), 28, null);
            bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.bR;
            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
        }
    }

    private void k() {
        if (!h()) {
            a(this.a, this.m, 0);
            return;
        }
        try {
            boolean z = java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.aW > 86400000;
            boolean i2 = com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d);
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "d niche al, isNetworkConnected = ".concat(java.lang.String.valueOf(i2)));
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "niche al need up = " + com.getui.gtc.extension.distribution.gbd.d.h.aO);
            if (i2 && z && com.getui.gtc.extension.distribution.gbd.d.h.aO) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "start d niche al.");
                l();
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "niche al old file exist");
                b((byte[]) null);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, th.getMessage());
        }
    }

    private void l() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cM)) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "niche al url empty,d cancel.");
            a(this.a, this.m, 2);
            return;
        }
        com.getui.gtc.extension.distribution.gbd.f.a.b.a();
        com.getui.gtc.extension.distribution.gbd.f.a.b.d(java.lang.System.currentTimeMillis());
        com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.a.a.a.AnonymousClass4(), 29, com.getui.gtc.extension.distribution.gbd.d.h.aX);
        bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.cM;
        com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
    }

    private java.lang.String m() {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.cJ) || com.getui.gtc.extension.distribution.gbd.d.d.cJ.equals("none")) {
            return "";
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.cJ.split(",");
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(true, "pi", split, new com.getui.gtc.extension.distribution.gbd.a.a.a.AnonymousClass6());
            if (!android.text.TextUtils.isEmpty(str)) {
                sb.append(str);
            }
            if (android.text.TextUtils.isEmpty(sb)) {
                return "";
            }
            if (sb.toString().endsWith(",")) {
                sb = sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(th);
            return "";
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void a() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "doSample");
            if (com.getui.gtc.extension.distribution.gbd.n.l.c(128)) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "type 128 in type black list, return.");
                return;
            }
            java.util.List<android.content.pm.PackageInfo> list = this.a;
            if (list != null) {
                list.clear();
            }
            java.util.List<android.content.pm.PackageInfo> list2 = this.b;
            if (list2 != null) {
                list2.clear();
            }
            boolean z = true;
            try {
                for (android.content.pm.PackageInfo packageInfo : com.getui.gtc.extension.distribution.gbd.n.b.a()) {
                    if ((packageInfo.applicationInfo.flags & 1) == 0) {
                        this.a.add(packageInfo);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "third al size = " + this.a.size());
            boolean c = com.getui.gtc.extension.distribution.gbd.n.l.c(com.getui.gtc.extension.distribution.gbd.d.c.d);
            boolean a = com.getui.gtc.extension.distribution.gbd.n.l.a();
            java.lang.StringBuilder sb = new java.lang.StringBuilder("isAdbModeSafe = ");
            sb.append(!c);
            sb.append(", isAppDebug = ");
            sb.append(a);
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, sb.toString());
            if (this.a.size() <= com.getui.gtc.extension.distribution.gbd.d.d.ch) {
                com.getui.gtc.extension.distribution.gbd.n.j.b("pre check 2818al-c , 128");
                com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                if (com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.k, com.getui.gtc.extension.distribution.gbd.f.b.b) && !c && !a) {
                    com.getui.gtc.extension.distribution.gbd.n.j.a(d, "handle al with 18w");
                    try {
                        java.lang.String f2 = com.getui.gtc.extension.distribution.gbd.n.b.f();
                        if (java.lang.System.currentTimeMillis() - com.getui.gtc.extension.distribution.gbd.d.h.aD <= 86400000) {
                            z = false;
                        }
                        boolean i2 = com.getui.gtc.extension.distribution.gbd.n.l.i(com.getui.gtc.extension.distribution.gbd.d.c.d);
                        boolean z2 = com.getui.gtc.extension.distribution.gbd.d.h.aL;
                        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "d al, isC = " + i2 + ", need up = " + z2);
                        if (!z || !i2 || (new java.io.File(f2).exists() && !z2)) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "apl old file exist");
                            a((byte[]) null);
                            return;
                        }
                        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "start d al.");
                        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.bR)) {
                            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "al url empty,d cancel.");
                            this.m = 2;
                            k();
                            return;
                        } else {
                            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                            com.getui.gtc.extension.distribution.gbd.f.a.b.b(java.lang.System.currentTimeMillis());
                            com.getui.gtc.extension.distribution.gbd.g.a.b bVar = new com.getui.gtc.extension.distribution.gbd.g.a.b(new com.getui.gtc.extension.distribution.gbd.a.a.a.AnonymousClass2(), 28, null);
                            bVar.e = com.getui.gtc.extension.distribution.gbd.d.d.bR;
                            com.getui.gtc.extension.distribution.gbd.l.a.C0311a.a.a(new com.getui.gtc.extension.distribution.gbd.g.a(bVar));
                            return;
                        }
                    } catch (java.lang.Throwable th2) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th2);
                        com.getui.gtc.extension.distribution.gbd.n.j.a(d, th2.getMessage());
                        return;
                    }
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "handle al without 18w");
            this.m = 0;
            k();
        } catch (java.lang.Throwable th3) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, th3.getMessage());
        }
    }

    public final void a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            java.lang.String f2 = com.getui.gtc.extension.distribution.gbd.n.b.f();
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "read form local fileName = ".concat(java.lang.String.valueOf(f2)));
            bArr = com.getui.gtc.extension.distribution.gbd.n.i.a(f2);
            if (bArr == null) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "read form local list = null");
                this.m = 2;
                k();
            }
        }
        java.lang.String[] split = new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.n.b(com.getui.gtc.extension.distribution.gbd.n.t.a(bArr, com.getui.gtc.extension.distribution.gbd.d.g.ad))).split("\\r");
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "rf local al len = " + split.length);
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "28 al-c start");
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.b, split, new com.getui.gtc.extension.distribution.gbd.a.a.a.AnonymousClass3());
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "28 al-c end");
        this.m = 1;
        k();
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    public final void b(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            java.lang.String h2 = com.getui.gtc.extension.distribution.gbd.n.b.h();
            com.getui.gtc.extension.distribution.gbd.n.j.a(d, "read form local niche fileName = ".concat(java.lang.String.valueOf(h2)));
            bArr = com.getui.gtc.extension.distribution.gbd.n.i.a(h2);
            if (bArr == null) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(d, "read form local niche list = null");
                a(this.a, this.m, 2);
                return;
            }
        }
        java.lang.String[] split = new java.lang.String(com.getui.gtc.extension.distribution.gbd.n.n.b(com.getui.gtc.extension.distribution.gbd.n.t.a(bArr, com.getui.gtc.extension.distribution.gbd.d.g.ad))).split("\\r");
        com.getui.gtc.extension.distribution.gbd.n.j.a(d, "rf local niche al len = " + split.length);
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "niche al-c start");
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.b, split, new com.getui.gtc.extension.distribution.gbd.a.a.a.AnonymousClass5());
        com.getui.gtc.extension.distribution.gbd.n.j.b(d, "niche al-c end");
        a(this.a, this.m, 1);
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return 128;
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
