package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class s extends com.anythink.expressad.foundation.h.f {
    public static boolean a = false;
    public static char[] b = {'a', 'n', 'd', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 'o', 'i', 'd', 'c', 'o', 'n', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'e', 'n', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'p', 'm', 'g', 'e', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'C', 'o', 'n', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'e', 'x', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP};
    private static final java.lang.String c = "SDKUtil";

    public static class a {
        public static final java.lang.String a = "com.android.vending";
        public static final java.lang.String b = "market";
        public static final java.lang.String c = "play.google.com";
        public static final java.lang.String d = "market.android.com";
        public static final java.lang.String e = "google.com";
        public static final java.lang.String f = "market://";
        public static final java.lang.String g = "details?id=";
        public static final java.lang.String h = "market://details?id=com.package.name";

        private static android.content.Intent a() {
            return new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(h));
        }

        private static java.util.List<android.content.pm.ResolveInfo> a(android.content.Context context) {
            try {
                return context.getPackageManager().queryIntentActivities(a(), 0);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public static boolean a(android.content.Context context, java.lang.String str, com.anythink.expressad.out.p.c cVar) {
            try {
                if (!b(str)) {
                    str = c(str) ? "market://".concat(java.lang.String.valueOf(str.substring(str.indexOf(g)))) : null;
                }
                if (android.text.TextUtils.isEmpty(str)) {
                    return false;
                }
                android.content.Intent a2 = a();
                a2.setData(android.net.Uri.parse(str));
                a2.addFlags(268435456);
                context.startActivity(a2);
                com.anythink.expressad.foundation.h.s.a(cVar);
                return true;
            } catch (java.lang.Throwable th) {
                android.util.Log.getStackTraceString(th);
                return false;
            }
        }

        public static boolean a(java.lang.String str) {
            return b(str) || c(str);
        }

        private static boolean b(android.content.Context context) {
            java.util.List<android.content.pm.ResolveInfo> a2 = a(context);
            return a2 != null && a2.size() > 0;
        }

        public static boolean b(java.lang.String str) {
            try {
                if (android.text.TextUtils.isEmpty(str)) {
                    return false;
                }
                return android.net.Uri.parse(str).getScheme().equals("market");
            } catch (java.lang.Throwable th) {
                android.util.Log.getStackTraceString(th);
                return false;
            }
        }

        private static boolean c(java.lang.String str) {
            try {
                if (!android.text.TextUtils.isEmpty(str)) {
                    android.net.Uri parse = android.net.Uri.parse(str);
                    if (parse.getHost().equals("play.google.com")) {
                        return true;
                    }
                    return parse.getHost().equals("market.android.com");
                }
            } catch (java.lang.Throwable th) {
                android.util.Log.getStackTraceString(th);
            }
            return false;
        }

        private static java.lang.String d(java.lang.String str) {
            if (b(str)) {
                return str;
            }
            if (c(str)) {
                return "market://".concat(java.lang.String.valueOf(str.substring(str.indexOf(g))));
            }
            return null;
        }
    }

    private static java.lang.String a() {
        return com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.AD_ANYTHINK_700);
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String sb;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.io.File a2 = com.anythink.expressad.foundation.g.c.d.a(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_IMG);
        if (android.text.TextUtils.isEmpty(str)) {
            sb = "";
        } else if (str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) == -1) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(str.hashCode());
            sb = sb2.toString();
        } else {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(str.hashCode() + str.substring(str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1).hashCode());
            sb = sb3.toString();
        }
        return new java.io.File(a2, sb).getAbsolutePath();
    }

    public static void a(android.content.Context context, java.lang.String str, com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.out.p.c cVar2) {
        if (context == null) {
            return;
        }
        if (a) {
            a(context, str, cVar2);
            return;
        }
        try {
            int i = com.anythink.expressad.activity.ATCommonActivity.n;
            android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.anythink.expressad.activity.ATCommonActivity.class);
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            if (com.anythink.expressad.foundation.h.s.a.b(str)) {
                str = "https://play.google.com/store/apps/details?id=".concat(java.lang.String.valueOf(str.replace("market://details?id=", "")));
            }
            intent.putExtra("url", str);
            intent.setFlags(268435456);
            intent.putExtra("mvcommon", cVar);
            context.startActivity(intent);
        } catch (java.lang.Exception unused) {
            a(context, str, cVar2);
        }
    }

    public static void a(android.content.Context context, java.lang.String str, com.anythink.expressad.out.p.c cVar) {
        if (str == null || context == null) {
            return;
        }
        try {
            if (com.anythink.expressad.foundation.h.s.a.b(str)) {
                str = "https://play.google.com/store/apps/details?id=".concat(java.lang.String.valueOf(str.replace("market://details?id=", "")));
            }
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
            intent.addFlags(268435456);
            android.content.pm.ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null) {
                android.content.pm.ActivityInfo activityInfo = resolveActivity.activityInfo;
                intent.setClassName(activityInfo.packageName, activityInfo.name);
            }
            context.startActivity(intent);
            a(cVar);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            try {
                android.content.Intent intent2 = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
                intent2.addFlags(268468224);
                context.startActivity(intent2);
                a(cVar);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(com.anythink.expressad.out.p.c cVar) {
        if (cVar instanceof com.anythink.expressad.out.p.e) {
            ((com.anythink.expressad.out.p.e) cVar).c();
        }
    }

    private static java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) == -1) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str.hashCode());
            return sb.toString();
        }
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(str.hashCode() + str.substring(str.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) + 1).hashCode());
        return sb2.toString();
    }

    private static void b(android.content.Context context, java.lang.String str, com.anythink.expressad.out.p.c cVar) {
        try {
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
            intent.addFlags(268435456);
            java.util.List<android.content.pm.ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            boolean z = queryIntentActivities.size() > 0;
            if (!str.startsWith("market://")) {
                if (str.startsWith("https://play.google.com/")) {
                    b(context, "market://details?id=".concat(java.lang.String.valueOf(str.replace("https://play.google.com/store/apps/details?id=", ""))), cVar);
                }
            } else {
                if (!z) {
                    a(context, "https://play.google.com/store/apps/details?id=".concat(java.lang.String.valueOf(str.replace("market://details?id=", ""))), cVar);
                    return;
                }
                java.util.Iterator<android.content.pm.ResolveInfo> it = queryIntentActivities.iterator();
                while (it.hasNext()) {
                    if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                        intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
                        break;
                    }
                }
                try {
                    context.startActivity(intent);
                    a(cVar);
                } catch (java.lang.Exception unused) {
                    a(context, "https://play.google.com/store/apps/details?id=".concat(java.lang.String.valueOf(str.replace("market://details?id=", ""))), cVar);
                }
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }
}
