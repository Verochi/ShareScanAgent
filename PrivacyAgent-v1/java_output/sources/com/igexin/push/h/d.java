package com.igexin.push.h;

/* loaded from: classes23.dex */
public final class d {
    static long a = 0;
    static java.util.HashMap<java.lang.String, java.lang.Object> b = new java.util.HashMap<>();
    private static final java.lang.String c = "ro.miui.ui.version.name";
    private static final java.lang.String d = "ro.miui.ui.version.code";
    private static final java.lang.String e = "GT";
    private static volatile java.lang.Boolean f;
    private static java.lang.String g;
    private static android.content.pm.PackageInfo h;

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0238, code lost:
    
        if (r11 == false) goto L121;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0276  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static android.content.Intent a(java.lang.String str) throws java.net.URISyntaxException {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.StringBuilder sb;
        int i;
        int i2 = 0;
        try {
            boolean startsWith = str.startsWith("android-app:");
            int lastIndexOf = str.lastIndexOf("#");
            try {
                if (lastIndexOf == -1) {
                    if (!startsWith) {
                        return new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
                    }
                } else if (!str.startsWith("#Intent;", lastIndexOf)) {
                    if (!startsWith) {
                        return d(str);
                    }
                    lastIndexOf = -1;
                }
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
                if (lastIndexOf >= 0) {
                    str2 = str.substring(0, lastIndexOf);
                    lastIndexOf += 8;
                } else {
                    str2 = str;
                }
                if (intent.getExtras() == null) {
                    intent.putExtras(new android.os.Bundle());
                }
                android.os.Bundle extras = intent.getExtras();
                android.content.Intent intent2 = intent;
                boolean z = false;
                java.lang.String str4 = null;
                boolean z2 = false;
                while (true) {
                    if (lastIndexOf < 0 || str.startsWith("end", lastIndexOf)) {
                        break;
                    }
                    int indexOf = str.indexOf(61, lastIndexOf);
                    if (indexOf < 0) {
                        indexOf = lastIndexOf - 1;
                    }
                    int indexOf2 = str.indexOf(59, lastIndexOf);
                    java.lang.String decode = indexOf < indexOf2 ? android.net.Uri.decode(str.substring(indexOf + 1, indexOf2)) : "";
                    if (str.startsWith("action=", lastIndexOf)) {
                        intent2.setAction(decode);
                        if (!z) {
                            z2 = true;
                        }
                    } else if (str.startsWith("category=", lastIndexOf)) {
                        intent2.addCategory(decode);
                    } else if (str.startsWith("type=", lastIndexOf)) {
                        intent2.setType(decode);
                    } else if (str.startsWith("launchFlags=", lastIndexOf)) {
                        intent2.setFlags(java.lang.Integer.decode(decode).intValue());
                        intent2.setFlags((~(67 | 128)) & intent2.getFlags());
                    } else if (str.startsWith("package=", lastIndexOf)) {
                        intent2.setPackage(decode);
                    } else if (str.startsWith("component=", lastIndexOf)) {
                        intent2.setComponent(android.content.ComponentName.unflattenFromString(decode));
                    } else if (str.startsWith("scheme=", lastIndexOf)) {
                        if (z) {
                            intent2.setData(android.net.Uri.parse(decode + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR));
                        } else {
                            str4 = decode;
                        }
                    } else if (str.startsWith("sourceBounds=", lastIndexOf)) {
                        intent2.setSourceBounds(android.graphics.Rect.unflattenFromString(decode));
                    } else if (indexOf2 == lastIndexOf + 3 && str.startsWith("SEL", lastIndexOf)) {
                        intent2 = new android.content.Intent();
                        z = true;
                    } else {
                        java.lang.String decode2 = android.net.Uri.decode(str.substring(lastIndexOf + 2, indexOf));
                        if (str.startsWith("S.", lastIndexOf)) {
                            extras.putString(decode2, decode);
                        } else if (str.startsWith("B.", lastIndexOf)) {
                            extras.putBoolean(decode2, java.lang.Boolean.parseBoolean(decode));
                        } else if (str.startsWith("b.", lastIndexOf)) {
                            extras.putByte(decode2, java.lang.Byte.parseByte(decode));
                        } else if (str.startsWith("c.", lastIndexOf)) {
                            extras.putChar(decode2, decode.charAt(0));
                        } else if (str.startsWith("d.", lastIndexOf)) {
                            extras.putDouble(decode2, java.lang.Double.parseDouble(decode));
                        } else if (str.startsWith("f.", lastIndexOf)) {
                            extras.putFloat(decode2, java.lang.Float.parseFloat(decode));
                        } else if (str.startsWith("i.", lastIndexOf)) {
                            extras.putInt(decode2, java.lang.Integer.parseInt(decode));
                        } else if (str.startsWith("l.", lastIndexOf)) {
                            extras.putLong(decode2, java.lang.Long.parseLong(decode));
                        } else {
                            if (!str.startsWith("s.", lastIndexOf)) {
                                throw new java.net.URISyntaxException(str, "unknown EXTRA type", lastIndexOf);
                            }
                            extras.putShort(decode2, java.lang.Short.parseShort(decode));
                        }
                    }
                    lastIndexOf = indexOf2 + 1;
                }
                intent2.putExtras(extras);
                if (!z) {
                    intent = intent2;
                } else if (intent.getPackage() == null) {
                    intent.setSelector(intent2);
                }
                if (str2 != null) {
                    if (str2.startsWith("intent:")) {
                        str2 = str2.substring(7);
                        if (str4 != null) {
                            sb = new java.lang.StringBuilder();
                            sb.append(str4);
                            sb.append(':');
                            sb.append(str2);
                            str2 = sb.toString();
                        }
                        if (str2.length() > 0) {
                            try {
                                intent.setData(android.net.Uri.parse(str2));
                            } catch (java.lang.IllegalArgumentException e2) {
                                throw new java.net.URISyntaxException(str, e2.getMessage());
                            }
                        }
                    } else {
                        if (str2.startsWith("android-app:")) {
                            if (str2.charAt(12) == '/' && str2.charAt(13) == '/') {
                                int indexOf3 = str2.indexOf(47, 14);
                                if (indexOf3 < 0) {
                                    intent.setPackage(str2.substring(14));
                                } else {
                                    intent.setPackage(str2.substring(14, indexOf3));
                                    int i3 = indexOf3 + 1;
                                    if (i3 < str2.length()) {
                                        int indexOf4 = str2.indexOf(47, i3);
                                        if (indexOf4 >= 0) {
                                            str4 = str2.substring(i3, indexOf4);
                                            if (indexOf4 >= str2.length() || (indexOf3 = str2.indexOf(47, (i = indexOf4 + 1))) < 0) {
                                                indexOf3 = indexOf4;
                                            } else {
                                                str3 = str2.substring(i, indexOf3);
                                                if (str4 != null) {
                                                    if (!z2) {
                                                        intent.setAction("android.intent.action.MAIN");
                                                    }
                                                } else if (str3 == null) {
                                                    sb = new java.lang.StringBuilder();
                                                    sb.append(str4);
                                                    sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                                                    str2 = sb.toString();
                                                } else {
                                                    str2 = str4 + "://" + str3 + str2.substring(indexOf3);
                                                }
                                            }
                                        } else {
                                            str4 = str2.substring(i3);
                                        }
                                    }
                                    str3 = null;
                                    if (str4 != null) {
                                    }
                                }
                            }
                            str2 = "";
                        }
                        if (str2.length() > 0) {
                        }
                    }
                }
                return intent;
            } catch (java.lang.IndexOutOfBoundsException unused) {
                i2 = lastIndexOf;
                throw new java.net.URISyntaxException(str, "illegal Intent URI format", i2);
            }
        } catch (java.lang.IndexOutOfBoundsException unused2) {
        }
    }

    public static android.util.Pair<android.content.pm.ServiceInfo, java.lang.Class> a(android.content.Context context, java.lang.Class cls) {
        try {
            if (h == null) {
                h = context.getPackageManager().getPackageInfo(context.getPackageName(), android.os.Build.VERSION.SDK_INT >= 24 ? com.badlogic.gdx.graphics.GL20.GL_GREATER : 4);
            }
            android.content.pm.ServiceInfo[] serviceInfoArr = h.services;
            if (serviceInfoArr != null && serviceInfoArr.length > 0) {
                int length = serviceInfoArr.length;
                for (int i = 0; i < length; i++) {
                    android.content.pm.ServiceInfo serviceInfo = serviceInfoArr[i];
                    try {
                        java.lang.Class<?> cls2 = java.lang.Class.forName(serviceInfo.name);
                        if (cls2 != cls && cls.isAssignableFrom(cls2)) {
                            com.igexin.c.a.c.a.b("GT", cls.getSimpleName() + " child is " + cls2.getSimpleName());
                            return android.util.Pair.create(serviceInfo, cls2);
                        }
                    } catch (java.lang.Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            com.igexin.c.a.c.a.c.a().a(" findGtImplClassInManifest error = " + th2.toString());
        }
        return android.util.Pair.create(null, null);
    }

    private static java.lang.String a(android.content.Context context) {
        try {
            android.content.Intent launchIntentForPackage = context.getApplicationContext().getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            return (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) ? "" : launchIntentForPackage.getComponent().getClassName();
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    public static java.lang.String a(android.content.pm.ApplicationInfo applicationInfo) {
        try {
            java.lang.String string = applicationInfo.metaData.getString(com.igexin.push.core.b.a);
            if (android.text.TextUtils.isEmpty(string)) {
                string = applicationInfo.packageName;
            }
            java.lang.Class<?> cls = java.lang.Class.forName(string + ".BuildConfig");
            return (java.lang.String) cls.getField("GETUI_APPID").get(cls);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a("get cf error|" + e2.toString(), new java.lang.Object[0]);
            return "";
        }
    }

    public static java.util.HashMap<java.lang.String, java.lang.Object> a() {
        try {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (currentTimeMillis - a < 2000) {
                return b;
            }
            java.util.HashMap<java.lang.String, java.lang.Object> hashMap = b;
            java.lang.Boolean bool = java.lang.Boolean.FALSE;
            hashMap.put("isPause", bool);
            b.put("isTranslucent", bool);
            a = currentTimeMillis;
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ActivityThread");
            android.app.Activity activity = null;
            java.lang.Object invoke = cls.getMethod("currentActivityThread", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            android.util.ArrayMap arrayMap = (android.util.ArrayMap) declaredField.get(invoke);
            if (arrayMap.size() <= 0) {
                return b;
            }
            java.lang.Boolean bool2 = null;
            for (java.lang.Object obj : arrayMap.values()) {
                java.lang.Class<?> cls2 = obj.getClass();
                java.lang.reflect.Field declaredField2 = cls2.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                android.app.Activity activity2 = (android.app.Activity) declaredField2.get(obj);
                java.lang.reflect.Field declaredField3 = cls2.getDeclaredField("paused");
                declaredField3.setAccessible(true);
                boolean z = declaredField3.getBoolean(obj);
                bool2 = java.lang.Boolean.valueOf(bool2 == null ? z : bool2.booleanValue() && z);
                if (!z) {
                    activity = activity2;
                }
            }
            boolean z2 = activity != null ? activity.getTheme().obtainStyledAttributes(new int[]{android.R.attr.windowIsTranslucent}).getBoolean(0, false) : false;
            b.put("isPause", java.lang.Boolean.valueOf(java.lang.Boolean.TRUE.equals(bool2)));
            b.put("isTranslucent", java.lang.Boolean.valueOf(z2));
            return b;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return b;
        }
    }

    public static synchronized boolean a(int i) {
        synchronized (com.igexin.push.h.d.class) {
            try {
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            if (com.igexin.push.core.e.l == null) {
                return false;
            }
            java.lang.String str = com.igexin.push.core.e.G;
            if (com.igexin.assist.util.AssistUtils.BRAND_HW.equalsIgnoreCase(str) || com.igexin.assist.util.AssistUtils.BRAND_HON.equalsIgnoreCase(str)) {
                ((java.lang.Integer) com.igexin.push.h.o.b(com.igexin.push.core.e.l, com.igexin.push.h.o.h, 0)).intValue();
                com.igexin.push.h.o.a(com.igexin.push.core.e.l, com.igexin.push.h.o.h, java.lang.Integer.valueOf(i));
                android.os.Bundle bundle = new android.os.Bundle();
                bundle.putString("package", com.igexin.push.core.e.g);
                bundle.putString("class", a(com.igexin.push.core.e.l));
                bundle.putInt("badgenumber", i);
                android.net.Uri parse = android.net.Uri.parse("content://com.huawei.android.launcher.settings/badge/");
                android.net.Uri parse2 = android.net.Uri.parse("content://com.hihonor.android.launcher.settings/badge/");
                if (android.text.TextUtils.isEmpty(com.igexin.push.core.e.l.getContentResolver().getType(parse))) {
                    parse = parse2;
                }
                com.igexin.push.core.e.l.getContentResolver().call(parse, "change_badge", (java.lang.String) null, bundle);
                return true;
            }
            return false;
        }
    }

    public static boolean a(java.lang.String... strArr) {
        for (int i = 0; i < 5; i++) {
            if (android.text.TextUtils.isEmpty(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    private static boolean b() {
        boolean z;
        try {
            if (f != null) {
                return f.booleanValue();
            }
            java.lang.String c2 = c("ro.miui.ui.version.name");
            java.lang.String c3 = c("ro.miui.ui.version.code");
            if (!"Xiaomi".equalsIgnoreCase(com.igexin.push.core.e.G) && android.text.TextUtils.isEmpty(c2) && android.text.TextUtils.isEmpty(c3)) {
                z = false;
                java.lang.Boolean valueOf = java.lang.Boolean.valueOf(z);
                f = valueOf;
                return valueOf.booleanValue();
            }
            z = true;
            java.lang.Boolean valueOf2 = java.lang.Boolean.valueOf(z);
            f = valueOf2;
            return valueOf2.booleanValue();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public static boolean b(int i) {
        try {
            if (com.igexin.push.core.e.l == null || !com.igexin.assist.util.AssistUtils.BRAND_VIVO.equalsIgnoreCase(com.igexin.push.core.e.G)) {
                return false;
            }
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", com.igexin.push.core.e.l.getPackageName());
            android.content.Intent launchIntentForPackage = com.igexin.push.core.e.l.getPackageManager().getLaunchIntentForPackage(com.igexin.push.core.e.l.getPackageName());
            if (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) {
                return false;
            }
            ((java.lang.Integer) com.igexin.push.h.o.b(com.igexin.push.core.e.l, com.igexin.push.h.o.i, 0)).intValue();
            com.igexin.push.h.o.a(com.igexin.push.core.e.l, com.igexin.push.h.o.i, java.lang.Integer.valueOf(i));
            intent.putExtra(com.vivo.push.PushClientConstants.TAG_CLASS_NAME, launchIntentForPackage.getComponent().getClassName());
            intent.putExtra("notificationNum", i);
            intent.addFlags(16777216);
            com.igexin.push.core.e.l.sendBroadcast(intent);
            return true;
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    public static boolean b(java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(g)) {
                g = c();
                com.igexin.c.a.c.a.b("GT", " gtcVersion = " + g);
            }
            java.lang.String[] split = g.split("\\.");
            java.lang.String[] split2 = str.split("\\.");
            if (split.length == 4 && split2.length == 4) {
                for (int i = 0; i < 3; i++) {
                    int parseInt = java.lang.Integer.parseInt(split2[i]);
                    int parseInt2 = java.lang.Integer.parseInt(split[i]);
                    if (parseInt2 != parseInt) {
                        return parseInt2 < parseInt;
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return false;
    }

    private static java.lang.String c() {
        try {
            java.lang.reflect.Field declaredField = com.getui.gtc.BuildConfig.class.getDeclaredField("VERSION_NAME");
            declaredField.setAccessible(true);
            return ((java.lang.String) declaredField.get(null)).substring(4);
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return "";
        }
    }

    private static java.lang.String c(java.lang.String str) {
        java.io.BufferedReader bufferedReader;
        java.io.BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.Runtime.getRuntime().exec("getprop ".concat(java.lang.String.valueOf(str))).getInputStream()), 1024);
            try {
                java.lang.String readLine = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (java.io.IOException e2) {
                    com.igexin.c.a.c.a.a(e2);
                }
                return readLine;
            } catch (java.lang.Exception unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (java.io.IOException e3) {
                        com.igexin.c.a.c.a.a(e3);
                    }
                }
                return null;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException e4) {
                        com.igexin.c.a.c.a.a(e4);
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused2) {
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public static boolean c(int i) {
        try {
            if (com.igexin.push.core.e.l == null || !com.igexin.assist.util.AssistUtils.BRAND_OPPO.equalsIgnoreCase(com.igexin.push.core.e.G)) {
                return false;
            }
            ((java.lang.Integer) com.igexin.push.h.o.b(com.igexin.push.core.e.l, com.igexin.push.h.o.j, 0)).intValue();
            com.igexin.push.h.o.a(com.igexin.push.core.e.l, com.igexin.push.h.o.j, java.lang.Integer.valueOf(i));
            android.content.Intent intent = new android.content.Intent("com.oppo.unsettledevent");
            intent.putExtra("packageName", com.igexin.push.core.e.l.getPackageName());
            intent.putExtra("number", i);
            intent.putExtra("upgradeNumber", i);
            java.util.List<android.content.pm.ResolveInfo> queryBroadcastReceivers = com.igexin.push.core.e.l.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
                com.igexin.push.core.e.l.sendBroadcast(intent);
                return true;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("app_badge_count", i);
            com.igexin.push.core.e.l.getContentResolver().call(android.net.Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (java.lang.String) null, bundle);
            return true;
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            return false;
        }
    }

    private static android.content.Intent d(java.lang.String str) throws java.net.URISyntaxException {
        boolean z;
        int i;
        java.lang.String str2;
        int lastIndexOf = str.lastIndexOf(35);
        if (lastIndexOf < 0) {
            return new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(str));
        }
        int i2 = lastIndexOf + 1;
        boolean z2 = true;
        if (str.regionMatches(i2, "action(", 0, 7)) {
            int i3 = i2 + 7;
            int indexOf = str.indexOf(41, i3);
            str2 = str.substring(i3, indexOf);
            i = indexOf + 1;
            z = true;
        } else {
            z = false;
            i = i2;
            str2 = null;
        }
        android.content.Intent intent = new android.content.Intent(str2);
        int i4 = 33;
        if (str.regionMatches(i, "categories(", 0, 11)) {
            int i5 = i + 11;
            int indexOf2 = str.indexOf(41, i5);
            while (i5 < indexOf2) {
                int indexOf3 = str.indexOf(33, i5);
                if (indexOf3 < 0 || indexOf3 > indexOf2) {
                    indexOf3 = indexOf2;
                }
                if (i5 < indexOf3) {
                    intent.addCategory(str.substring(i5, indexOf3));
                }
                i5 = indexOf3 + 1;
            }
            i = indexOf2 + 1;
            z = true;
        }
        if (str.regionMatches(i, "type(", 0, 5)) {
            int i6 = i + 5;
            int indexOf4 = str.indexOf(41, i6);
            intent.setType(str.substring(i6, indexOf4));
            i = indexOf4 + 1;
            z = true;
        }
        if (str.regionMatches(i, "launchFlags(", 0, 12)) {
            int i7 = i + 12;
            int indexOf5 = str.indexOf(41, i7);
            intent.setFlags(java.lang.Integer.decode(str.substring(i7, indexOf5)).intValue());
            intent.setFlags((~(67 | 128)) & intent.getFlags());
            i = indexOf5 + 1;
            z = true;
        }
        if (str.regionMatches(i, "component(", 0, 10)) {
            int i8 = i + 10;
            int indexOf6 = str.indexOf(41, i8);
            int indexOf7 = str.indexOf(33, i8);
            if (indexOf7 >= 0 && indexOf7 < indexOf6) {
                intent.setComponent(new android.content.ComponentName(str.substring(i8, indexOf7), str.substring(indexOf7 + 1, indexOf6)));
            }
            i = indexOf6 + 1;
            z = true;
        }
        if (str.regionMatches(i, "extras(", 0, 7)) {
            int i9 = i + 7;
            int indexOf8 = str.indexOf(41, i9);
            int i10 = -1;
            if (indexOf8 == -1) {
                throw new java.net.URISyntaxException(str, "EXTRA missing trailing ')'", i9);
            }
            if (intent.getExtras() == null) {
                intent.putExtras(new android.os.Bundle());
            }
            android.os.Bundle extras = intent.getExtras();
            while (i9 < indexOf8) {
                int indexOf9 = str.indexOf(61, i9);
                int i11 = i9 + 1;
                if (indexOf9 <= i11 || i9 >= indexOf8) {
                    throw new java.net.URISyntaxException(str, "EXTRA missing '='", i9);
                }
                char charAt = str.charAt(i9);
                java.lang.String substring = str.substring(i11, indexOf9);
                int i12 = indexOf9 + 1;
                int indexOf10 = str.indexOf(i4, i12);
                if (indexOf10 == i10 || indexOf10 >= indexOf8) {
                    indexOf10 = indexOf8;
                }
                if (i12 >= indexOf10) {
                    throw new java.net.URISyntaxException(str, "EXTRA missing '!'", i12);
                }
                java.lang.String substring2 = str.substring(i12, indexOf10);
                if (charAt == 'B') {
                    extras.putBoolean(substring, java.lang.Boolean.parseBoolean(substring2));
                } else if (charAt == 'S') {
                    extras.putString(substring, android.net.Uri.decode(substring2));
                } else if (charAt == 'f') {
                    extras.putFloat(substring, java.lang.Float.parseFloat(substring2));
                } else if (charAt == 'i') {
                    extras.putInt(substring, java.lang.Integer.parseInt(substring2));
                } else if (charAt == 'l') {
                    extras.putLong(substring, java.lang.Long.parseLong(substring2));
                } else {
                    if (charAt != 's') {
                        switch (charAt) {
                            case 'b':
                                extras.putByte(substring, java.lang.Byte.parseByte(substring2));
                                break;
                            case 'c':
                                extras.putChar(substring, android.net.Uri.decode(substring2).charAt(0));
                                break;
                            case 'd':
                                try {
                                    extras.putDouble(substring, java.lang.Double.parseDouble(substring2));
                                    break;
                                } catch (java.lang.NumberFormatException unused) {
                                    throw new java.net.URISyntaxException(str, "EXTRA value can't be parsed", indexOf10);
                                }
                            default:
                                throw new java.net.URISyntaxException(str, "EXTRA has unknown type", indexOf10);
                        }
                        throw new java.net.URISyntaxException(str, "EXTRA value can't be parsed", indexOf10);
                    }
                    extras.putShort(substring, java.lang.Short.parseShort(substring2));
                }
                char charAt2 = str.charAt(indexOf10);
                if (charAt2 == ')') {
                    intent.putExtras(extras);
                } else {
                    if (charAt2 != '!') {
                        throw new java.net.URISyntaxException(str, "EXTRA missing '!'", indexOf10);
                    }
                    i9 = indexOf10 + 1;
                    i10 = -1;
                    i4 = 33;
                }
            }
            intent.putExtras(extras);
        } else {
            z2 = z;
        }
        intent.setData(z2 ? android.net.Uri.parse(str.substring(0, lastIndexOf)) : android.net.Uri.parse(str));
        if (intent.getAction() != null) {
            return intent;
        }
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }
}
