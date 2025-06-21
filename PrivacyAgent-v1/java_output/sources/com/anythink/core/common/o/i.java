package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class i {
    public static final java.lang.String a = "CommonUtils";
    public static char[] b = {'a', 'n', 'd', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT, 'o', 'i', 'd', 'c', 'o', 'n', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'e', 'n', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'p', 'm', 'g', 'e', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'C', 'o', 'n', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'e', 'x', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP};
    private static char[] d = {'A', 'p', 'p', com.aliyun.svideo.editor.guide.customView.MultiLamp.LEFT, 'i', 'c', 'a', com.aliyun.svideo.editor.guide.customView.MultiLamp.TOP, 'i', 'o', 'n', 'I', 'n', 'f', 'o'};
    private static char[] e = {'.', 'X'};
    private static int f = 0;
    private static int g = 1;
    private static int h = 2;
    private static int i = 3;
    private static int j = 0;
    private static int k = 7;
    private static int l = 14;
    private static int m = 19;
    private static int n = 16;
    private static int o = 26;
    public static char[] c = {'P', 'a', 'c', 'k', 'a', 'g', 'e', 'M', 'a', 'n', 'a', 'g', 'e', com.aliyun.svideo.editor.guide.customView.MultiLamp.RIGHT};
    private static final java.util.regex.Pattern p = java.util.regex.Pattern.compile("(?i)((?:http|https|ftp|file)://|(?:inline|data|about|javascript):|(?:.*:.*@))(.*)");

    /* renamed from: com.anythink.core.common.o.i$1, reason: invalid class name */
    public class AnonymousClass1 implements android.view.View.OnSystemUiVisibilityChangeListener {
        final /* synthetic */ android.view.View a;

        public AnonymousClass1(android.view.View view) {
            this.a = view;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public final void onSystemUiVisibilityChange(int i) {
            if ((i & 2) == 0) {
                com.anythink.core.common.o.i.a(this.a);
            }
        }
    }

    public static int a(android.content.Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context == null) {
            context = com.anythink.core.common.b.o.a().f();
        }
        if (context == null) {
            return -1;
        }
        return context.getResources().getIdentifier("anythink_".concat(java.lang.String.valueOf(str)), str2, context.getPackageName());
    }

    public static java.lang.String a(java.lang.Object[] objArr) {
        int length;
        if (objArr == null || objArr.length - 1 == -1) {
            return "";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i2 = 0;
        while (true) {
            sb.append(java.lang.String.valueOf(objArr[i2]));
            if (i2 == length) {
                return sb.toString();
            }
            sb.append(",");
            i2++;
        }
    }

    private static void a(android.app.Activity activity) {
        android.view.Window window = activity.getWindow();
        if (window != null) {
            android.view.View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(4870);
            decorView.setOnSystemUiVisibilityChangeListener(new com.anythink.core.common.o.i.AnonymousClass1(decorView));
        }
    }

    public static void a(android.view.View view) {
        view.setSystemUiVisibility(4870);
    }

    public static boolean a() {
        android.security.NetworkSecurityPolicy networkSecurityPolicy;
        boolean isCleartextTrafficPermitted;
        android.security.NetworkSecurityPolicy networkSecurityPolicy2;
        boolean isCleartextTrafficPermitted2;
        try {
            int i2 = android.os.Build.VERSION.SDK_INT;
            if (i2 >= 24) {
                networkSecurityPolicy2 = android.security.NetworkSecurityPolicy.getInstance();
                isCleartextTrafficPermitted2 = networkSecurityPolicy2.isCleartextTrafficPermitted("http://www.toponad.com");
                return isCleartextTrafficPermitted2;
            }
            if (i2 < 23) {
                return true;
            }
            networkSecurityPolicy = android.security.NetworkSecurityPolicy.getInstance();
            isCleartextTrafficPermitted = networkSecurityPolicy.isCleartextTrafficPermitted();
            return isCleartextTrafficPermitted;
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean a(android.content.Context context) {
        try {
            android.net.NetworkInfo activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isAvailable()) {
                    return true;
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    public static synchronized boolean a(android.content.Context context, java.lang.String str) {
        boolean z;
        synchronized (com.anythink.core.common.o.i.class) {
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

    private static final char[] a(int i2) {
        java.lang.StringBuilder sb;
        if (i2 == 0) {
            sb = new java.lang.StringBuilder();
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOf(b, k)));
            sb.append(e[j]);
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(b, k, l)));
            sb.append(e[j]);
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(b, l, n)));
            sb.append(e[j]);
            sb.append(java.lang.String.valueOf(c));
        } else if (i2 == 1) {
            sb = new java.lang.StringBuilder();
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOf(b, k)));
            sb.append(e[j]);
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(b, k, l)));
            sb.append(e[j]);
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(b, m, o)));
        } else if (i2 == 2) {
            sb = new java.lang.StringBuilder();
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(b, n, m)));
            sb.append(java.lang.String.valueOf(d));
        } else if (i2 != 3) {
            sb = null;
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(java.lang.String.valueOf(java.util.Arrays.copyOfRange(b, n, m)));
            sb.append(java.lang.String.valueOf(c));
        }
        return sb.toString().toCharArray();
    }

    public static java.lang.String[] a(org.json.JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            java.lang.String[] strArr = new java.lang.String[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                strArr[i2] = jSONArray.optString(i2);
            }
            return strArr;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static int b(android.content.Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static int b(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = str + "_" + str2;
        try {
            for (java.lang.Class<?> cls : java.lang.Class.forName(context.getPackageName() + ".R").getClasses()) {
                if (cls.getSimpleName().equals("styleable")) {
                    for (java.lang.reflect.Field field : cls.getFields()) {
                        if (field.getName().equals(str3)) {
                            return ((java.lang.Integer) field.get(null)).intValue();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return 0;
    }

    private static android.view.View.OnSystemUiVisibilityChangeListener b(android.view.View view) {
        return new com.anythink.core.common.o.i.AnonymousClass1(view);
    }

    private static java.lang.Object b(java.lang.String str, android.content.Context context) {
        try {
            return java.lang.Class.forName(java.lang.String.valueOf(a(f))).getMethod(java.lang.String.valueOf(a(h)), java.lang.String.class, java.lang.Integer.TYPE).invoke(java.lang.Class.forName(java.lang.String.valueOf(a(g))).getMethod(java.lang.String.valueOf(a(i)), new java.lang.Class[0]).invoke(context, new java.lang.Object[0]), str, 8192);
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static <T extends java.lang.String> boolean b(T t) {
        return t != null && t.length() > 0;
    }

    private static int[] b(android.content.Context context, java.lang.String str) {
        try {
            for (java.lang.reflect.Field field : java.lang.Class.forName(context.getPackageName() + ".R$styleable").getFields()) {
                if (field.getName().equals(str)) {
                    return (int[]) field.get(null);
                }
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static java.util.Map<java.lang.String, java.lang.Object> c(java.lang.String str) {
        java.util.HashMap hashMap = new java.util.HashMap();
        try {
            if (!android.text.TextUtils.isEmpty(str)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    java.lang.String next = keys.next();
                    hashMap.put(next, jSONObject.opt(next));
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return hashMap;
    }

    public static boolean c(android.content.Context context) {
        return context != null && context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean d(java.lang.String str) {
        return p.matcher(str.toLowerCase()).matches();
    }
}
