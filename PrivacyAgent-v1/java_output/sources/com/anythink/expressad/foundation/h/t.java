package com.anythink.expressad.foundation.h;

/* loaded from: classes12.dex */
public final class t extends com.anythink.expressad.foundation.h.g {
    public static final java.lang.String a = "SameTools";
    static java.util.List<java.lang.String> b;
    private static char[] c = {'A', 'p', 'p', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'i', 'c', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'i', 'o', 'n', 'I', 'n', 'f', 'o'};
    private static char[] d = {'.', 'X'};
    private static int e = 0;
    private static int f = 1;
    private static int g = 2;
    private static int h = 3;
    private static int i = 0;
    private static int j = 7;
    private static int k = 14;
    private static int l = 19;
    private static int m = 16;
    private static int n = 26;
    private static int o = 1;

    public static double a(java.lang.Double d2) {
        try {
            java.lang.String format = new java.text.DecimalFormat("0.00", java.text.DecimalFormatSymbols.getInstance(java.util.Locale.US)).format(d2);
            if (com.anythink.expressad.foundation.h.w.b(format)) {
                return java.lang.Double.parseDouble(format);
            }
            return 0.0d;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public static int a() {
        int i2 = o;
        o = i2 + 1;
        return i2;
    }

    public static int a(int i2) {
        if ((i2 > 100 && i2 < 199) || i2 == 2) {
            return 1;
        }
        if ((i2 <= 200 || i2 >= 299) && i2 != 4) {
            return (i2 <= 500 || i2 >= 599) ? -1 : 5;
        }
        return 2;
    }

    public static int a(android.content.Context context, float f2) {
        float f3 = 2.5f;
        if (context != null) {
            try {
                float f4 = context.getResources().getDisplayMetrics().density;
                if (f4 != 0.0f) {
                    f3 = f4;
                }
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static int a(java.lang.Object obj) {
        if (obj == null) {
            return 0;
        }
        try {
            if (obj instanceof java.lang.String) {
                return java.lang.Integer.parseInt((java.lang.String) obj);
            }
            return 0;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return 0;
        }
    }

    public static synchronized java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String sb;
        synchronized (com.anythink.expressad.foundation.h.t.class) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder(str2);
            try {
                sb2.append(a(str2, context, str));
            } catch (java.lang.Exception unused) {
            }
            sb = sb2.toString();
        }
        return sb;
    }

    private static synchronized java.lang.String a(java.lang.String str, android.content.Context context, java.lang.String str2) {
        java.lang.StringBuilder sb;
        java.lang.String sb2;
        synchronized (com.anythink.expressad.foundation.h.t.class) {
            try {
                java.util.Set<java.lang.String> queryParameterNames = android.net.Uri.parse(str).getQueryParameterNames();
                sb = (queryParameterNames == null || queryParameterNames.size() <= 0) ? new java.lang.StringBuilder("?rtins_type=") : new java.lang.StringBuilder("&rtins_type=");
            } catch (java.lang.Exception unused) {
                sb = new java.lang.StringBuilder("&rtins_type=");
            }
            try {
                if (b(str2, context) != null) {
                    sb.append(1);
                } else {
                    sb.append(2);
                }
            } catch (java.lang.Exception unused2) {
                sb.append(0);
            }
            sb2 = sb.toString();
        }
        return sb2;
    }

    public static java.util.List<java.lang.String> a(org.json.JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                java.lang.String optString = jSONArray.optString(i2);
                if (com.anythink.expressad.foundation.h.w.b(optString)) {
                    arrayList.add(optString);
                }
            }
            return arrayList;
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static void a(android.view.View view) {
        if (view == null) {
            return;
        }
        try {
            view.setSystemUiVisibility(4102);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized boolean a(android.content.Context context, java.lang.String str) {
        boolean z;
        synchronized (com.anythink.expressad.foundation.h.t.class) {
            z = false;
            if (context != null) {
                if (!android.text.TextUtils.isEmpty(str)) {
                    try {
                        if (b(str, context) != null) {
                            z = true;
                        }
                    } catch (java.lang.Exception unused) {
                    }
                }
            }
        }
        return z;
    }

    public static boolean a(com.anythink.expressad.foundation.d.c cVar) {
        if (cVar != null) {
            try {
                return cVar.N() == 1;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static <T extends java.lang.String> boolean a(T t) {
        return t == null || t.length() == 0;
    }

    public static boolean a(java.lang.String str, android.content.Context context) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private static boolean a(java.util.List list) {
        return list == null || list.isEmpty();
    }

    private static <T> boolean a(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static double b(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return 0.0d;
            }
            return java.lang.Double.parseDouble(str);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public static int b(android.content.Context context, float f2) {
        android.content.res.Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f2 * resources.getDisplayMetrics().density) + 0.5f);
    }

    private static java.lang.Object b(java.lang.String str, android.content.Context context) {
        try {
            return java.lang.Class.forName(java.lang.String.valueOf(b(e))).getMethod(java.lang.String.valueOf(b(g)), java.lang.String.class, java.lang.Integer.TYPE).invoke(java.lang.Class.forName(java.lang.String.valueOf(b(f))).getMethod(java.lang.String.valueOf(b(h)), new java.lang.Class[0]).invoke(context, new java.lang.Object[0]), str, 8192);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static boolean b() {
        return android.os.Looper.getMainLooper().getThread() == java.lang.Thread.currentThread();
    }

    public static boolean b(android.content.Context context) {
        try {
            return ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static boolean b(java.util.List list) {
        return !(list == null || list.isEmpty());
    }

    private static <T> boolean b(T[] tArr) {
        return !(tArr == null || tArr.length == 0);
    }

    private static final char[] b(int i2) {
        java.lang.StringBuilder sb;
        if (i2 == 0) {
            sb = new java.lang.StringBuilder();
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOf(com.anythink.expressad.foundation.h.s.b, j)));
            sb.append(d[i]);
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(com.anythink.expressad.foundation.h.s.b, j, k)));
            sb.append(d[i]);
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(com.anythink.expressad.foundation.h.s.b, k, m)));
            sb.append(d[i]);
            sb.append(java.lang.String.valueOf(com.anythink.expressad.foundation.h.r.c));
        } else if (i2 == 1) {
            sb = new java.lang.StringBuilder();
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOf(com.anythink.expressad.foundation.h.s.b, j)));
            sb.append(d[i]);
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(com.anythink.expressad.foundation.h.s.b, j, k)));
            sb.append(d[i]);
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(com.anythink.expressad.foundation.h.s.b, l, n)));
        } else if (i2 == 2) {
            sb = new java.lang.StringBuilder();
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(com.anythink.expressad.foundation.h.s.b, m, l)));
            sb.append(java.lang.String.valueOf(c));
        } else if (i2 != 3) {
            sb = null;
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(com.anythink.expressad.foundation.h.s.b, m, l)));
            sb.append(java.lang.String.valueOf(com.anythink.expressad.foundation.h.r.c));
        }
        return sb.toString().toCharArray();
    }

    public static float c(android.content.Context context) {
        if (context == null) {
            return 2.5f;
        }
        try {
            float f2 = context.getResources().getDisplayMetrics().density;
            if (f2 == 0.0f) {
                return 2.5f;
            }
            return f2;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 2.5f;
        }
    }

    public static java.lang.String c(java.lang.String str) {
        try {
            return com.anythink.expressad.foundation.h.w.b(str) ? java.net.URLEncoder.encode(str, "utf-8") : "";
        } catch (java.lang.Throwable th) {
            th.getMessage();
            return "";
        }
    }

    public static int d(android.content.Context context) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(java.lang.Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
            if (parse == null) {
                return false;
            }
            java.lang.String queryParameter = parse.getQueryParameter(com.anythink.expressad.a.z);
            if (android.text.TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("1");
        } catch (java.lang.Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    public static int e(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return k(context).heightPixels;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(java.lang.String str) {
        boolean z;
        int i2;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                android.net.Uri parse = android.net.Uri.parse(str);
                if (parse == null) {
                    return false;
                }
                java.lang.String queryParameter = parse.getQueryParameter(com.anythink.expressad.a.C);
                if (android.text.TextUtils.isEmpty(queryParameter)) {
                    queryParameter = parse.getQueryParameter(com.anythink.expressad.a.B);
                }
                try {
                    try {
                        if (!android.text.TextUtils.isEmpty(queryParameter)) {
                            try {
                                i2 = java.lang.Integer.parseInt(queryParameter);
                            } catch (java.lang.Exception unused) {
                                i2 = -1;
                            }
                            if (i2 % 2 == 0) {
                                z = true;
                                if (android.text.TextUtils.isEmpty(parse.getQueryParameter(com.anythink.expressad.a.X))) {
                                    return true;
                                }
                                return z;
                            }
                        }
                        if (android.text.TextUtils.isEmpty(parse.getQueryParameter(com.anythink.expressad.a.X))) {
                        }
                    } catch (java.lang.Exception e2) {
                        e = e2;
                        e.getMessage();
                        return false;
                    }
                } catch (java.lang.Throwable unused2) {
                    return z;
                }
                z = false;
            } catch (java.lang.Exception e3) {
                e = e3;
                z = false;
            }
        } catch (java.lang.Throwable unused3) {
            return false;
        }
    }

    public static int f(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return k(context).widthPixels;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean f(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
            if (parse == null) {
                return false;
            }
            java.lang.String queryParameter = parse.getQueryParameter(com.anythink.expressad.a.Z);
            if (android.text.TextUtils.isEmpty(queryParameter)) {
                return false;
            }
            return queryParameter.equals("0");
        } catch (java.lang.Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    public static int g(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int g(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            android.net.Uri parse = android.net.Uri.parse(str);
            if (parse == null) {
                return -1;
            }
            java.lang.String queryParameter = parse.getQueryParameter(com.anythink.expressad.a.C);
            if (android.text.TextUtils.isEmpty(queryParameter)) {
                queryParameter = parse.getQueryParameter(com.anythink.expressad.a.B);
            }
            if (android.text.TextUtils.isEmpty(queryParameter)) {
                return -1;
            }
            try {
                return java.lang.Integer.parseInt(queryParameter);
            } catch (java.lang.Exception unused) {
                return -1;
            }
        } catch (java.lang.Exception e2) {
            e2.getMessage();
            return -1;
        }
    }

    public static int h(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private static <T extends java.lang.String> boolean h(T t) {
        return t != null && t.length() > 0;
    }

    public static int i(android.content.Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM) != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM));
            }
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
        return 0;
    }

    private static boolean i(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                android.net.Uri parse = android.net.Uri.parse(str);
                if (parse != null) {
                    return !android.text.TextUtils.isEmpty(parse.getQueryParameter(com.anythink.expressad.a.C));
                }
                return false;
            } catch (java.lang.Exception e2) {
                e2.getMessage();
                return false;
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public static int j(android.content.Context context) {
        if (context == null) {
            return 0;
        }
        try {
            android.content.pm.PackageInfo currentWebViewPackage = android.os.Build.VERSION.SDK_INT >= 26 ? android.webkit.WebView.getCurrentWebViewPackage() : context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.foundation.b.a.b().e();
            com.anythink.expressad.d.a b2 = com.anythink.expressad.d.b.b();
            if (b2 == null) {
                com.anythink.expressad.d.b.a();
                b2 = com.anythink.expressad.d.b.c();
            }
            if (currentWebViewPackage == null || android.text.TextUtils.isEmpty(currentWebViewPackage.versionName) || !currentWebViewPackage.versionName.equals("77.0.3865.92")) {
                return b2.P();
            }
            return 5;
        } catch (java.lang.Exception unused) {
            return 0;
        }
    }

    private static android.util.DisplayMetrics k(android.content.Context context) {
        if (context == null) {
            return null;
        }
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        try {
            ((android.view.WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }
}
