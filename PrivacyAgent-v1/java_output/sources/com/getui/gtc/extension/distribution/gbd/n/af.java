package com.getui.gtc.extension.distribution.gbd.n;

/* loaded from: classes22.dex */
public final class af {
    private static final java.lang.String a = "Unique_U";

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.af$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.getui.gtc.extension.distribution.gbd.f.j<java.util.ArrayList<java.lang.String>, java.lang.String> {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public java.lang.String a(java.util.ArrayList<java.lang.String> arrayList) {
            java.nio.file.Path path;
            java.nio.file.attribute.BasicFileAttributes readAttributes;
            java.nio.file.attribute.FileTime creationTime;
            long millis;
            java.nio.file.attribute.FileTime lastAccessTime;
            long millis2;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (com.getui.gtc.extension.distribution.gbd.n.x.a(1, 1)) {
                java.util.Iterator<java.lang.String> it = arrayList.iterator();
                while (it.hasNext()) {
                    java.lang.String next = it.next();
                    try {
                        path = new java.io.File(this.a + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + next).toPath();
                        readAttributes = java.nio.file.Files.readAttributes(path, (java.lang.Class<java.nio.file.attribute.BasicFileAttributes>) java.nio.file.attribute.BasicFileAttributes.class, new java.nio.file.LinkOption[0]);
                        creationTime = readAttributes.creationTime();
                        millis = creationTime.toMillis();
                        lastAccessTime = readAttributes.lastAccessTime();
                        millis2 = lastAccessTime.toMillis();
                        sb.append(next + "#" + com.getui.gtc.extension.distribution.gbd.n.b.a(com.getui.gtc.extension.distribution.gbd.n.l.a(next, 0)) + "#" + millis + "#" + millis2);
                        sb.append(",");
                    } catch (java.lang.Throwable th) {
                        com.getui.gtc.extension.distribution.gbd.n.j.a(th);
                    }
                }
            }
            return sb.toString();
        }
    }

    /* renamed from: com.getui.gtc.extension.distribution.gbd.n.af$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.getui.gtc.extension.distribution.gbd.f.j<java.lang.String, android.content.pm.PackageInfo> {
        private static android.content.pm.PackageInfo a() {
            java.lang.String str;
            java.lang.String lowerCase = com.getui.gtc.extension.distribution.gbd.n.l.w().toLowerCase();
            lowerCase.hashCode();
            switch (lowerCase) {
                case "blackshark":
                case "xiaomi":
                case "redmi":
                    str = "com.android.deskclock";
                    break;
                case "oneplus":
                    str = "net.oneplus.launcher";
                    break;
                case "huawei":
                case "honor":
                case "hua_wei":
                    str = "com.huawei.appmarket";
                    break;
                case "iqoo":
                case "vivo":
                    str = "com.bbk.launcher2";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            return com.getui.gtc.extension.distribution.gbd.n.k.a(str, 0);
        }

        @Override // com.getui.gtc.extension.distribution.gbd.f.j
        public final /* synthetic */ android.content.pm.PackageInfo a(java.lang.String str) {
            java.lang.String str2;
            java.lang.String lowerCase = com.getui.gtc.extension.distribution.gbd.n.l.w().toLowerCase();
            lowerCase.hashCode();
            switch (lowerCase) {
                case "blackshark":
                case "xiaomi":
                case "redmi":
                    str2 = "com.android.deskclock";
                    break;
                case "oneplus":
                    str2 = "net.oneplus.launcher";
                    break;
                case "huawei":
                case "honor":
                case "hua_wei":
                    str2 = "com.huawei.appmarket";
                    break;
                case "iqoo":
                case "vivo":
                    str2 = "com.bbk.launcher2";
                    break;
                default:
                    str2 = "unknown";
                    break;
            }
            return com.getui.gtc.extension.distribution.gbd.n.k.a(str2, 0);
        }
    }

    private static java.lang.String a() {
        if (!a(com.getui.gtc.extension.distribution.gbd.d.g.l)) {
            return "";
        }
        java.lang.String w = com.getui.gtc.extension.distribution.gbd.n.l.w();
        if (!com.igexin.assist.util.AssistUtils.BRAND_HON.equalsIgnoreCase(w) && !com.igexin.assist.util.AssistUtils.BRAND_HW.equalsIgnoreCase(w)) {
            return "";
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.huawei.telephony.HuaweiTelephonyManager");
            return (java.lang.String) cls.getMethod("getIccATR", new java.lang.Class[0]).invoke(cls.getMethod("getDefault", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]), new java.lang.Object[0]);
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    private static boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(com.getui.gtc.extension.distribution.gbd.d.d.ac) || android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.d.d.ac.split(",")).contains(str);
        com.getui.gtc.extension.distribution.gbd.n.j.b(a, str + ": " + contains);
        return contains;
    }

    @android.annotation.TargetApi(26)
    private static java.lang.String b() {
        if (android.os.Build.VERSION.SDK_INT < 26 || !com.getui.gtc.extension.distribution.gbd.n.x.a(1, 2)) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.lang.String absolutePath = com.getui.gtc.extension.distribution.gbd.d.c.i.getAbsolutePath();
            java.util.ArrayList arrayList = new java.util.ArrayList(java.util.Arrays.asList(com.getui.gtc.extension.distribution.gbd.d.d.Q.split(",")));
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            java.lang.String str = (java.lang.String) com.getui.gtc.extension.distribution.gbd.f.c.a(a(com.getui.gtc.extension.distribution.gbd.d.g.n), "pi", arrayList, new com.getui.gtc.extension.distribution.gbd.n.af.AnonymousClass1(absolutePath));
            if (!android.text.TextUtils.isEmpty(str)) {
                sb.append(str);
                if (sb.toString().endsWith(",")) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
        }
        return sb.toString();
    }

    private static java.lang.String b(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "blackshark":
            case "xiaomi":
            case "redmi":
                return "com.android.deskclock";
            case "oneplus":
                return "net.oneplus.launcher";
            case "huawei":
            case "honor":
            case "hua_wei":
                return "com.huawei.appmarket";
            case "iqoo":
            case "vivo":
                return "com.bbk.launcher2";
            default:
                return "unknown";
        }
    }

    private static java.lang.String c() {
        try {
            com.getui.gtc.extension.distribution.gbd.f.c unused = com.getui.gtc.extension.distribution.gbd.f.c.a.a;
            android.content.pm.PackageInfo packageInfo = (android.content.pm.PackageInfo) com.getui.gtc.extension.distribution.gbd.f.c.a(a(com.getui.gtc.extension.distribution.gbd.d.g.m), "pi", "", new com.getui.gtc.extension.distribution.gbd.n.af.AnonymousClass2());
            return packageInfo != null ? com.getui.gtc.extension.distribution.gbd.n.b.b(packageInfo) : "";
        } catch (java.lang.Throwable th) {
            com.getui.gtc.extension.distribution.gbd.n.j.a(th);
            return "";
        }
    }

    private static /* synthetic */ java.lang.String c(java.lang.String str) {
        str.hashCode();
        switch (str) {
            case "blackshark":
            case "xiaomi":
            case "redmi":
                return "com.android.deskclock";
            case "oneplus":
                return "net.oneplus.launcher";
            case "huawei":
            case "honor":
            case "hua_wei":
                return "com.huawei.appmarket";
            case "iqoo":
            case "vivo":
                return "com.bbk.launcher2";
            default:
                return "unknown";
        }
    }
}
