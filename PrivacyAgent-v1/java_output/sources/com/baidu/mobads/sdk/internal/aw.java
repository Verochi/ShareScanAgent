package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class aw extends com.baidu.mobads.sdk.internal.ay.a {
    public static final java.lang.String a = "local";
    private static final int b = 4000;
    private static final int c = 23;
    private static final int d = 5;
    private static final java.util.regex.Pattern e = java.util.regex.Pattern.compile("(\\$\\d+)+$");
    private static final char f = 9556;
    private static final char g = 9562;
    private static final char h = 9567;
    private static final char i = 9553;
    private static final java.lang.String j = "════════════════════════════════════════════";
    private static final java.lang.String k = "------------------------------------------";
    private static final java.lang.String l = "╔════════════════════════════════════════════════════════════════════════════════════════";
    private static final java.lang.String m = "╚════════════════════════════════════════════════════════════════════════════════════════";
    private static final java.lang.String n = "╟------------------------------------------------------------------------------------";

    private static void a(int i2, java.lang.String str, java.lang.String str2) {
        if (i2 == 7) {
            android.util.Log.wtf(str, str2);
        } else {
            android.util.Log.println(i2, str, str2);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay.a
    @androidx.annotation.NonNull
    public java.lang.String a() {
        return "local";
    }

    public java.lang.String a(java.lang.StackTraceElement stackTraceElement) {
        java.lang.String className = stackTraceElement.getClassName();
        java.util.regex.Matcher matcher = e.matcher(className);
        if (matcher.find()) {
            className = matcher.replaceAll("");
        }
        java.lang.String substring = className.substring(className.lastIndexOf(46) + 1);
        return (substring.length() <= 23 || android.os.Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
    }

    @Override // com.baidu.mobads.sdk.internal.ay.a
    public void a(int i2, java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        int min;
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("当前线程：");
            sb.append(java.lang.Thread.currentThread().getName());
            sb.append(";  ");
            sb.append("调用位置：");
            sb.append(c());
            sb.append(";  ");
            sb.append("打印消息：");
            if (str2.length() <= 4000) {
                sb.append(str2);
                a(i2, str, sb.toString());
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int length = str2.length();
            int i3 = 0;
            while (i3 < length) {
                int indexOf = str2.indexOf(10, i3);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = java.lang.Math.min(indexOf, i3 + 4000);
                    arrayList.add(str2.substring(i3, min));
                    if (min >= indexOf) {
                        break;
                    } else {
                        i3 = min;
                    }
                }
                i3 = min + 1;
            }
            for (java.lang.String str3 : (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()])) {
                a(i2, str, sb.toString() + str3);
            }
        } catch (java.lang.Throwable th2) {
            a(6, str, th2.toString());
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay.a
    public final java.lang.String b() {
        java.lang.String b2 = super.b();
        if (b2 != null) {
            return b2;
        }
        java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().getStackTrace();
        return stackTrace.length <= 5 ? "" : a(stackTrace[5]);
    }

    public java.lang.String c() {
        java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
        boolean z = false;
        int i2 = 0;
        for (java.lang.StackTraceElement stackTraceElement : stackTrace) {
            java.lang.String className = stackTraceElement.getClassName();
            java.util.regex.Matcher matcher = e.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (!className.equals(com.baidu.mobads.sdk.internal.ay.class.getName()) && !className.equals(com.baidu.mobads.sdk.internal.bt.class.getName())) {
                if (z) {
                    break;
                }
            } else {
                z = true;
            }
            i2++;
        }
        return "   (" + stackTrace[i2].getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTrace[i2].getLineNumber() + ")# " + stackTrace[i2].getMethodName();
    }
}
