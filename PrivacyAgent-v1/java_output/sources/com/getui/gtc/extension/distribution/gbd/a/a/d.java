package com.getui.gtc.extension.distribution.gbd.a.a;

/* loaded from: classes22.dex */
public final class d implements com.getui.gtc.extension.distribution.gbd.a.a {
    private static final java.lang.String c = "GBD_124";
    private static final int d = 30000;
    private static final java.lang.String e = "unlock";
    private static final java.lang.String f = "lock";
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 1;
    private static final int k = -1;
    private static final int l = 1;
    private static final int m = 2;
    private static com.getui.gtc.extension.distribution.gbd.a.a.d p;
    public long a = 0;
    public long b = 0;
    private boolean n = true;
    private int o = -1;
    private android.content.Context q;

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.d$1, reason: invalid class name */
    public class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<android.content.Context, java.util.List<java.lang.String>> {
        public AnonymousClass1() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.util.List<java.lang.String> a2(android.content.Context context) {
            android.content.Intent intent;
            java.util.List<android.app.ActivityManager.RecentTaskInfo> recentTasks = ((android.app.ActivityManager) context.getSystemService("activity")).getRecentTasks(10, 1);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<android.app.ActivityManager.RecentTaskInfo> it = recentTasks.iterator();
            while (it.hasNext()) {
                intent = it.next().baseIntent;
                arrayList.add(intent.getComponent().getPackageName());
            }
            return arrayList;
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.util.List<java.lang.String> a(android.content.Context context) {
            android.content.Intent intent;
            java.util.List<android.app.ActivityManager.RecentTaskInfo> recentTasks = ((android.app.ActivityManager) context.getSystemService("activity")).getRecentTasks(10, 1);
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<android.app.ActivityManager.RecentTaskInfo> it = recentTasks.iterator();
            while (it.hasNext()) {
                intent = it.next().baseIntent;
                arrayList.add(intent.getComponent().getPackageName());
            }
            return arrayList;
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.d$2, reason: invalid class name */
    public class AnonymousClass2 implements com.getui.gtc.extension.distribution.gbd.f.j<android.content.Context, java.util.List<android.app.ActivityManager.RunningServiceInfo>> {
        public AnonymousClass2() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.util.List<android.app.ActivityManager.RunningServiceInfo> a2(android.content.Context context) {
            return ((android.app.ActivityManager) context.getSystemService("activity")).getRunningServices(2000);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.util.List<android.app.ActivityManager.RunningServiceInfo> a(android.content.Context context) {
            return ((android.app.ActivityManager) context.getSystemService("activity")).getRunningServices(2000);
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.d$3, reason: invalid class name */
    public class AnonymousClass3 implements com.getui.gtc.extension.distribution.gbd.f.j<java.io.File, java.io.File[]> {

        /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.d$3$1, reason: invalid class name */
        public class AnonymousClass1 implements java.io.FileFilter {
            public AnonymousClass1() {
            }

            @Override // java.io.FileFilter
            public final boolean accept(java.io.File file) {
                return file != null && file.isDirectory();
            }
        }

        public AnonymousClass3() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private java.io.File[] a2(java.io.File file) {
            return file.listFiles(new com.getui.gtc.extension.distribution.gbd.a.a.d.AnonymousClass3.AnonymousClass1());
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.io.File[] a(java.io.File file) {
            return file.listFiles(new com.getui.gtc.extension.distribution.gbd.a.a.d.AnonymousClass3.AnonymousClass1());
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.d$4, reason: invalid class name */
    public class AnonymousClass4 implements com.getui.gtc.extension.distribution.gbd.f.j<java.io.File[], java.lang.String> {
        public AnonymousClass4() {
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static java.lang.String a2(java.io.File[] fileArr) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (fileArr != null && fileArr.length > 0) {
                for (java.io.File file : fileArr) {
                    java.lang.String name = file.getName();
                    android.content.pm.PackageInfo a = com.getui.gtc.extension.distribution.gbd.n.l.a(name, 0);
                    if (a != null && !android.text.TextUtils.isEmpty(name)) {
                        java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.w.a().a(name, (a.applicationInfo.flags & 1) != 0);
                        if (!"error".equals(a2)) {
                            sb.append(name + "&" + a2 + "&" + com.getui.gtc.extension.distribution.gbd.a.a.d.a(a) + ",");
                        }
                    }
                }
            }
            return sb.toString();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ java.lang.String a(java.io.File[] fileArr) {
            java.io.File[] fileArr2 = fileArr;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (fileArr2 != null && fileArr2.length > 0) {
                for (java.io.File file : fileArr2) {
                    java.lang.String name = file.getName();
                    android.content.pm.PackageInfo a = com.getui.gtc.extension.distribution.gbd.n.l.a(name, 0);
                    if (a != null && !android.text.TextUtils.isEmpty(name)) {
                        java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.w.a().a(name, (a.applicationInfo.flags & 1) != 0);
                        if (!"error".equals(a2)) {
                            sb.append(name + "&" + a2 + "&" + com.getui.gtc.extension.distribution.gbd.a.a.d.a(a) + ",");
                        }
                    }
                }
            }
            return sb.toString();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.a.a.d$5, reason: invalid class name */
    public class AnonymousClass5 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, java.lang.String> {
        final /* synthetic */ boolean a;

        public AnonymousClass5(boolean z) {
            this.a = z;
        }

        private java.lang.String a() {
            org.json.JSONObject jSONObject;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.util.List<android.content.pm.PackageInfo> a = com.getui.gtc.extension.distribution.gbd.n.b.a();
            java.util.HashMap hashMap = new java.util.HashMap();
            for (android.content.pm.PackageInfo packageInfo : a) {
                hashMap.put(packageInfo.packageName, packageInfo);
            }
            try {
                jSONObject = this.a ? new org.json.JSONObject(com.getui.gtc.extension.distribution.gbd.d.h.f325s) : new org.json.JSONObject();
            } catch (java.lang.Throwable unused) {
                jSONObject = new org.json.JSONObject();
            }
            java.util.Iterator<java.lang.String> keys = jSONObject.keys();
            while (true) {
                if (!keys.hasNext()) {
                    break;
                }
                java.lang.String next = keys.next();
                java.lang.String a2 = com.getui.gtc.extension.distribution.gbd.n.w.a().a(jSONObject.optString(next), next, false);
                if (!"error".equals(a2)) {
                    sb.append(next + "&" + a2 + "&" + (hashMap.containsKey(next) ? com.getui.gtc.extension.distribution.gbd.a.a.d.a((android.content.pm.PackageInfo) hashMap.get(next)) : -1) + ",");
                }
            }
            for (android.content.pm.PackageInfo packageInfo2 : a) {
                java.lang.String str = packageInfo2.packageName;
                if (!jSONObject.has(str)) {
                    java.lang.String a3 = com.getui.gtc.extension.distribution.gbd.n.w.a().a("", str, (packageInfo2.applicationInfo.flags & 1) != 0);
                    if (!"error".equals(a3)) {
                        sb.append(str + "&" + a3 + "&" + (hashMap.containsKey(str) ? com.getui.gtc.extension.distribution.gbd.a.a.d.a((android.content.pm.PackageInfo) hashMap.get(str)) : -1) + ",");
                    }
                }
            }
            return sb.toString();
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* bridge */ /* synthetic */ java.lang.String a(java.lang.String str) {
            return a();
        }
    }

    private d(android.content.Context context) {
        this.q = context;
        g();
    }

    public static /* synthetic */ int a(android.content.pm.PackageInfo packageInfo) {
        if (packageInfo == null) {
            return -1;
        }
        return (packageInfo.applicationInfo.flags & 2097152) == 0 ? 1 : 0;
    }

    private static java.lang.String a(java.util.List<java.lang.String> list, int i2) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList<java.lang.String> arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        if (list == null || list.size() == 0) {
            return "";
        }
        for (java.lang.String str : list) {
            if (!arrayList2.contains(str)) {
                arrayList2.add(str);
            }
        }
        for (java.lang.String str2 : arrayList2) {
            if (str2.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                java.lang.String[] split = str2.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                if (split.length == 2) {
                    if (arrayList3.contains(split[0])) {
                        int i3 = 0;
                        while (true) {
                            if (i3 < arrayList.size()) {
                                java.lang.String str3 = (java.lang.String) arrayList.get(i3);
                                if (str3.contains(split[0] + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                                    arrayList.set(i3, str3 + "&" + split[1]);
                                    break;
                                }
                                i3++;
                            }
                        }
                    } else {
                        arrayList3.add(split[0]);
                    }
                }
            }
            arrayList.add(str2);
        }
        int min = java.lang.Math.min(arrayList.size(), i2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i4 = 0; i4 < min; i4++) {
            try {
                java.lang.String str4 = (java.lang.String) arrayList.get(i4);
                sb.append(str4);
                if (str4.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                    str4 = str4.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[0];
                }
                long j2 = 0;
                long longValue = com.getui.gtc.extension.distribution.gbd.d.h.G.containsKey(str4) ? com.getui.gtc.extension.distribution.gbd.d.h.G.get(str4).longValue() : 0L;
                if (longValue <= com.getui.gtc.extension.distribution.gbd.n.l.C()) {
                    j2 = longValue;
                }
                sb.append("#");
                sb.append(j2);
                if (i4 < min - 1) {
                    sb.append(",");
                }
            } catch (java.lang.Throwable th) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            }
        }
        return sb.toString();
    }

    private static java.util.List<java.lang.String> a(java.util.List<android.app.ActivityManager.RecentTaskInfo> list) {
        android.content.Intent intent;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<android.app.ActivityManager.RecentTaskInfo> it = list.iterator();
        while (it.hasNext()) {
            intent = it.next().baseIntent;
            arrayList.add(intent.getComponent().getPackageName());
        }
        return arrayList;
    }

    public static void a(java.lang.String str) {
        com.getui.gtc.extension.distribution.gbd.n.j.a(c, "recent app data: type = 124content = ".concat(java.lang.String.valueOf(str)));
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "save type = 124");
        if (com.getui.gtc.extension.distribution.gbd.n.l.d(124)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "instant r 124");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().a(str, 124);
        } else {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "not instant r 124");
            com.getui.gtc.extension.distribution.gbd.f.a.a.a().b(str, 124);
        }
    }

    private boolean a(int i2) {
        return (i2 >= 16 && com.getui.gtc.extension.distribution.gbd.n.l.a(this.q, "android.permission.READ_EXTERNAL_STORAGE")) || com.getui.gtc.extension.distribution.gbd.n.l.a(this.q, com.anythink.china.common.d.b);
    }

    private static int b(android.content.pm.PackageInfo packageInfo) {
        if (packageInfo == null) {
            return -1;
        }
        return (packageInfo.applicationInfo.flags & 2097152) == 0 ? 1 : 0;
    }

    private static java.lang.String b(java.util.List<java.lang.String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i2 = 0;
        for (java.lang.String str : list) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
                com.getui.gtc.extension.distribution.gbd.n.j.a(c, "recent a:".concat(java.lang.String.valueOf(str)));
                if (i2 != 0) {
                    sb.append(",");
                }
                sb.append(str);
                i2++;
                if (i2 >= 10) {
                    break;
                }
            }
        }
        return sb.toString();
    }

    private static boolean b(java.lang.String str) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.contains(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)) {
                str = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR)[0];
            }
            java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.bt.split("\\|");
            if (split.length != 4) {
                return false;
            }
            java.lang.String[] split2 = split[0].split(",");
            java.lang.String[] split3 = split[1].split(",");
            java.lang.String[] split4 = split[2].split(",");
            java.lang.String[] split5 = split[3].split(",");
            if (split2.length > 0 && !split2[0].equals("none")) {
                for (java.lang.String str2 : split2) {
                    if (str.startsWith(str2)) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (split3.length > 0 && !split3[0].equals("none")) {
                for (java.lang.String str3 : split3) {
                    if (str.contains(str3)) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = true;
            if (split4.length > 0 && !split4[0].equals("none")) {
                for (java.lang.String str4 : split4) {
                    if (!str.contains(str4)) {
                        z3 = false;
                        break;
                    }
                }
            }
            z3 = true;
            if (split5.length > 0 && !split5[0].equals("none")) {
                for (java.lang.String str5 : split5) {
                    if (str.endsWith(str5)) {
                        z4 = false;
                        break;
                    }
                }
            }
            z4 = true;
            return z && z2 && z3 && z4;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return false;
        }
    }

    private static /* synthetic */ java.util.List c(java.util.List list) {
        android.content.Intent intent;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            intent = ((android.app.ActivityManager.RecentTaskInfo) it.next()).baseIntent;
            arrayList.add(intent.getComponent().getPackageName());
        }
        return arrayList;
    }

    public static com.getui.gtc.extension.distribution.gbd.a.a.d f() {
        if (p == null) {
            p = new com.getui.gtc.extension.distribution.gbd.a.a.d(com.getui.gtc.extension.distribution.gbd.d.c.d);
        }
        return p;
    }

    private void g() {
        try {
            if ("*".equals(com.getui.gtc.extension.distribution.gbd.d.d.au)) {
                this.n = false;
                return;
            }
            if (!android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.au) && !"none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.au)) {
                for (java.lang.String str : com.getui.gtc.extension.distribution.gbd.d.d.au.split(",")) {
                    java.lang.String[] split = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                    if (split != null && split.length >= 3) {
                        if (com.getui.gtc.extension.distribution.gbd.n.l.w().equalsIgnoreCase(split[0])) {
                            boolean z = true;
                            java.lang.String[] split2 = split[1].split("&");
                            java.lang.String str2 = split[2];
                            if (split2 != null && split2.length == 2 && !android.text.TextUtils.isEmpty(str2)) {
                                int parseInt = java.lang.Integer.parseInt(split2[0]);
                                int parseInt2 = java.lang.Integer.parseInt(split2[1]);
                                int i2 = android.os.Build.VERSION.SDK_INT;
                                if (i2 < parseInt || i2 > parseInt2) {
                                    z = false;
                                }
                                java.lang.String lowerCase = com.getui.gtc.extension.distribution.gbd.n.l.z().toLowerCase();
                                if (!z) {
                                    continue;
                                } else {
                                    if ("*".equals(str2)) {
                                        this.n = false;
                                        return;
                                    }
                                    for (java.lang.String str3 : str2.split("&")) {
                                        if (lowerCase.contains(str3.toLowerCase())) {
                                            this.n = false;
                                            return;
                                        }
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.av)) {
                return;
            }
            if ("none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.av)) {
                this.n = false;
                return;
            }
            for (java.lang.String str4 : com.getui.gtc.extension.distribution.gbd.d.d.av.split(",")) {
                if (com.getui.gtc.extension.distribution.gbd.n.l.e(str4)) {
                    this.n = false;
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private void h() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "unlock.");
            if (com.getui.gtc.extension.distribution.gbd.n.l.c(124)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "type 124 in type black list, return.");
                return;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            this.a = currentTimeMillis;
            if (currentTimeMillis - this.b >= com.getui.gtc.extension.distribution.gbd.d.d.cj * 1000) {
                java.lang.String a = a(1, 0);
                if (android.text.TextUtils.isEmpty(a)) {
                    return;
                }
                a(a);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private void i() {
        try {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "lock.");
            if (com.getui.gtc.extension.distribution.gbd.n.l.c(124)) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "type 124 in type black list, return.");
                return;
            }
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            this.b = currentTimeMillis;
            if (currentTimeMillis - this.a >= com.getui.gtc.extension.distribution.gbd.d.d.cj * 1000) {
                java.lang.String a = a(2, 0);
                if (android.text.TextUtils.isEmpty(a)) {
                    return;
                }
                a(a);
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    private java.util.List<java.lang.String> j() {
        com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
        return (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.a(true, com.getui.gtc.extension.distribution.gbd.f.b.c, this.q, new com.getui.gtc.extension.distribution.gbd.a.a.d.AnonymousClass1());
    }

    private java.util.List<java.lang.String> k() {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "proc disable : above7.0");
                return null;
            }
            boolean z = com.getui.gtc.extension.distribution.gbd.d.d.ap;
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.util.List<java.lang.String> list = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.a(z, com.getui.gtc.extension.distribution.gbd.f.b.d, "", new com.getui.gtc.extension.distribution.gbd.n.v.AnonymousClass1());
            if (list != null && !list.isEmpty() && (list.size() != 1 || !list.get(0).equals(this.q.getPackageName()))) {
                java.util.Iterator<java.lang.String> it = list.iterator();
                while (it.hasNext()) {
                    if (!b(it.next())) {
                        it.remove();
                    }
                }
                return list;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "running = null");
            return null;
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private java.lang.String l() {
        java.lang.Long valueOf;
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "rsl dc disable : above8.0");
            return "";
        }
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.util.List list = (java.util.List) com.getui.gtc.extension.distribution.gbd.f.c.a(com.getui.gtc.extension.distribution.gbd.d.d.ap, com.getui.gtc.extension.distribution.gbd.f.b.e, this.q, new com.getui.gtc.extension.distribution.gbd.a.a.d.AnonymousClass2());
            if (list != null && !list.isEmpty()) {
                java.util.HashMap hashMap = new java.util.HashMap();
                java.util.HashMap hashMap2 = new java.util.HashMap();
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "rsl " + list.size());
                if (list.size() > 200) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "rsl > 200, cut.");
                    list = list.subList(0, 200);
                }
                java.util.Iterator it = list.iterator();
                while (true) {
                    long j2 = -1;
                    if (!it.hasNext()) {
                        break;
                    }
                    android.app.ActivityManager.RunningServiceInfo runningServiceInfo = (android.app.ActivityManager.RunningServiceInfo) it.next();
                    java.lang.String packageName = runningServiceInfo.service.getPackageName();
                    java.lang.String className = runningServiceInfo.service.getClassName();
                    if (!android.text.TextUtils.isEmpty(packageName) && !android.text.TextUtils.isEmpty(className)) {
                        long C = (com.getui.gtc.extension.distribution.gbd.n.l.C() - android.os.SystemClock.elapsedRealtime()) + runningServiceInfo.activeSince;
                        if (C > 0) {
                            j2 = C;
                        }
                        if (hashMap2.containsKey(packageName)) {
                            if (((java.lang.Long) hashMap2.get(packageName)).longValue() > j2) {
                                valueOf = java.lang.Long.valueOf(j2);
                            }
                            if (hashMap.containsKey(packageName)) {
                                java.util.ArrayList arrayList = new java.util.ArrayList();
                                arrayList.add(className);
                                hashMap.put(packageName, arrayList);
                            } else {
                                ((java.util.List) hashMap.get(packageName)).add(className);
                            }
                        } else {
                            valueOf = java.lang.Long.valueOf(j2);
                        }
                        hashMap2.put(packageName, valueOf);
                        if (hashMap.containsKey(packageName)) {
                        }
                    }
                }
                if (hashMap.isEmpty()) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "rs empty.");
                    return "";
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (java.util.Map.Entry entry : hashMap.entrySet()) {
                    java.lang.String str = (java.lang.String) entry.getKey();
                    java.util.List list2 = (java.util.List) entry.getValue();
                    if (com.getui.gtc.extension.distribution.gbd.d.d.ce || !com.getui.gtc.extension.distribution.gbd.n.l.m(str)) {
                        sb.append(str);
                        java.lang.Long l2 = (java.lang.Long) hashMap2.get(str);
                        java.lang.Long valueOf2 = java.lang.Long.valueOf(l2 != null ? l2.longValue() : -1L);
                        if (com.getui.gtc.extension.distribution.gbd.n.l.A()) {
                            sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                            java.util.Iterator it2 = list2.iterator();
                            while (it2.hasNext()) {
                                sb.append((java.lang.String) it2.next());
                                sb.append("&");
                            }
                            if (sb.toString().endsWith("&")) {
                                sb.deleteCharAt(sb.length() - 1);
                            }
                            sb.append("#");
                            sb.append(valueOf2);
                        } else {
                            sb.append("#");
                            sb.append(valueOf2);
                        }
                        sb.append(",");
                    }
                }
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                return sb.toString();
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "rsl empty.");
            return "";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    private java.lang.String m() {
        java.lang.String str;
        try {
            this.o = -1;
            java.io.File file = com.getui.gtc.extension.distribution.gbd.d.c.i;
            if (this.n && file != null) {
                char c2 = 1;
                if (com.getui.gtc.extension.distribution.gbd.n.x.a(1, 2)) {
                    com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                    java.io.File[] fileArr = (java.io.File[]) com.getui.gtc.extension.distribution.gbd.h.a.a(true, com.getui.gtc.extension.distribution.gbd.f.b.f, file, new com.getui.gtc.extension.distribution.gbd.a.a.d.AnonymousClass3());
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    boolean z = (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.h.f325s) || "none".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.h.f325s)) ? false : true;
                    boolean a = a(com.getui.gtc.extension.distribution.gbd.d.h.h);
                    int i2 = android.os.Build.VERSION.SDK_INT;
                    boolean z2 = i2 < 29;
                    boolean z3 = i2 == 29;
                    boolean z4 = fileArr != null && fileArr.length > 0;
                    if (!(com.getui.gtc.extension.distribution.gbd.d.g.p.equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.P) || ("both".equalsIgnoreCase(com.getui.gtc.extension.distribution.gbd.d.d.P) && a && (z2 || (z3 && z4))))) {
                        java.lang.String[] split = com.getui.gtc.extension.distribution.gbd.d.d.cP.split(",");
                        java.util.HashMap hashMap = new java.util.HashMap();
                        int length = split.length;
                        int i3 = 0;
                        while (i3 < length) {
                            java.lang.String[] split2 = split[i3].split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                            if (split2.length >= 2) {
                                hashMap.put(split2[0], new java.util.ArrayList(java.util.Arrays.asList(split2[c2].split("&"))));
                            }
                            i3++;
                            c2 = 1;
                        }
                        java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.d.d.cQ.split(",")));
                        com.getui.gtc.extension.distribution.gbd.n.w a2 = com.getui.gtc.extension.distribution.gbd.n.w.a();
                        a2.a = hashMap;
                        a2.b = arrayList;
                        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "use new sd24.");
                        this.o = 2;
                        com.getui.gtc.extension.distribution.gbd.f.c unused2 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                        str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.h.a.a(true, com.getui.gtc.extension.distribution.gbd.f.b.f, "", new com.getui.gtc.extension.distribution.gbd.a.a.d.AnonymousClass5(z));
                        if (str == null) {
                            str = "";
                        }
                    } else {
                        if (!z4) {
                            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "no a d dir list.");
                            return "";
                        }
                        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "use old sd24.");
                        this.o = 1;
                        com.getui.gtc.extension.distribution.gbd.f.c unused3 = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
                        str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(true, "pi", fileArr, new com.getui.gtc.extension.distribution.gbd.a.a.d.AnonymousClass4());
                        if (str == null) {
                            str = "";
                        }
                    }
                    sb.append(str);
                    if (sb.toString().endsWith(",")) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    java.lang.String sb2 = sb.toString();
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "sd running data: ".concat(java.lang.String.valueOf(sb2)));
                    return sb2;
                }
            }
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "sd running: not enable.");
            return "";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    private static java.lang.String n() {
        try {
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.Long>> map = com.getui.gtc.extension.distribution.gbd.n.w.a().c;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.String str : map.keySet()) {
                java.util.Map<java.lang.String, java.lang.Long> map2 = map.get(str);
                sb.append(str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                for (java.lang.String str2 : map2.keySet()) {
                    sb.append(str2 + "#" + map2.get(str2).longValue() + "&");
                }
                if (sb.toString().endsWith("&")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(",");
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "error";
        }
    }

    private java.lang.String o() {
        try {
            java.lang.String w = com.getui.gtc.extension.distribution.gbd.n.l.w();
            java.lang.String x = com.getui.gtc.extension.distribution.gbd.n.l.x();
            java.lang.String z = com.getui.gtc.extension.distribution.gbd.n.l.z();
            int i2 = com.getui.gtc.extension.distribution.gbd.d.h.h;
            return w + "," + x + "," + z + "," + i2 + "," + this.q.getApplicationInfo().targetSdkVersion + "," + (a(i2) ? 1 : 0);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "error";
        }
    }

    public final java.lang.String a(int i2, int i3) {
        try {
            com.getui.gtc.extension.distribution.gbd.f.a.b.a();
            if (!com.getui.gtc.extension.distribution.gbd.f.a.b.d()) {
                com.getui.gtc.extension.distribution.gbd.n.j.a(c, "enable = false return");
                return null;
            }
            com.getui.gtc.extension.distribution.gbd.n.j.a(c, "package data, 124");
            java.util.List<java.lang.String> k2 = k();
            java.lang.String format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault()).format(new java.util.Date(com.getui.gtc.extension.distribution.gbd.n.l.C()));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(format);
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.d.c.e);
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.d.c.a);
            sb.append("|");
            if (i2 != 0) {
                sb.append(i2);
            }
            sb.append("|");
            if (i3 != 0) {
                sb.append(i3);
            }
            sb.append("|");
            sb.append("|");
            sb.append(b((java.util.List<java.lang.String>) null));
            sb.append("|");
            sb.append(a(k2, com.getui.gtc.extension.distribution.gbd.d.d.v));
            sb.append("|");
            sb.append(com.sensorsdata.sf.ui.view.UIProperty.action_android);
            sb.append("|");
            sb.append(l());
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.n.l.b("124"));
            sb.append("|");
            sb.append(m());
            sb.append("|");
            sb.append("|");
            sb.append(o());
            sb.append("|");
            sb.append("|");
            sb.append("|");
            sb.append(this.o);
            sb.append("|");
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (currentTimeMillis - com.getui.gtc.extension.distribution.gbd.d.h.aU > com.getui.gtc.extension.distribution.gbd.d.d.cD * 1000) {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "match 24al interval.");
                com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                com.getui.gtc.extension.distribution.gbd.d.h.aU = currentTimeMillis;
                com.getui.gtc.extension.distribution.gbd.f.a.b.a(312, java.lang.String.valueOf(currentTimeMillis));
                sb.append(com.getui.gtc.extension.distribution.gbd.d.h.u);
                sb.append("|");
                sb.append(com.getui.gtc.extension.distribution.gbd.n.b.n());
            } else {
                com.getui.gtc.extension.distribution.gbd.n.j.b(c, "not match 24al interval.");
                sb.append("|");
            }
            sb.append("|");
            sb.append(n());
            sb.append("|");
            sb.append(com.getui.gtc.extension.distribution.gbd.n.l.C() - android.os.SystemClock.elapsedRealtime());
            return sb.toString();
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return null;
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void a() {
        com.getui.gtc.extension.distribution.gbd.n.j.b(c, "doSample");
        if (com.getui.gtc.extension.distribution.gbd.n.l.c(124)) {
            com.getui.gtc.extension.distribution.gbd.n.j.b(c, "type 124 in type black list, return.");
            return;
        }
        try {
            if (com.getui.gtc.extension.distribution.gbd.n.l.e(this.q)) {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (currentTimeMillis - this.a >= com.getui.gtc.extension.distribution.gbd.d.d.bm * 1000) {
                    com.getui.gtc.extension.distribution.gbd.n.j.b(c, "collect type24 timer.");
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a();
                    com.getui.gtc.extension.distribution.gbd.d.h.r = currentTimeMillis;
                    com.getui.gtc.extension.distribution.gbd.f.a.b.a(183, java.lang.String.valueOf(currentTimeMillis));
                    java.lang.String a = a(0, 1);
                    if (android.text.TextUtils.isEmpty(a)) {
                        return;
                    }
                    a(a);
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final void b() {
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final int c() {
        return 124;
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String d() {
        return "* * * * *";
    }

    @Override // com.getui.gtc.extension.distribution.gbd.a.a
    public final java.lang.String e() {
        return "* 00 * * *";
    }
}
