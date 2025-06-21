package androidx.constraintlayout.motion.widget;

/* loaded from: classes.dex */
public class Debug {
    public static void dumpLayoutParams(android.view.ViewGroup.LayoutParams layoutParams, java.lang.String str) {
        java.lang.StackTraceElement stackTraceElement = new java.lang.Throwable().getStackTrace()[1];
        java.lang.String str2 = ".(" + stackTraceElement.getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ") " + str + "  ";
        java.lang.System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + str2 + "  " + layoutParams.getClass().getName());
        for (java.lang.reflect.Field field : layoutParams.getClass().getFields()) {
            try {
                java.lang.Object obj = field.get(layoutParams);
                java.lang.String name = field.getName();
                if (name.contains("To") && !obj.toString().equals("-1")) {
                    java.lang.System.out.println(str2 + "       " + name + " " + obj);
                }
            } catch (java.lang.IllegalAccessException unused) {
            }
        }
        java.lang.System.out.println(" <<<<<<<<<<<<<<<<< dump " + str2);
    }

    public static void dumpLayoutParams(android.view.ViewGroup viewGroup, java.lang.String str) {
        java.lang.StackTraceElement stackTraceElement = new java.lang.Throwable().getStackTrace()[1];
        java.lang.String str2 = ".(" + stackTraceElement.getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ") " + str + "  ";
        int childCount = viewGroup.getChildCount();
        java.lang.System.out.println(str + " children " + childCount);
        for (int i = 0; i < childCount; i++) {
            android.view.View childAt = viewGroup.getChildAt(i);
            java.lang.System.out.println(str2 + "     " + getName(childAt));
            android.view.ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            for (java.lang.reflect.Field field : layoutParams.getClass().getFields()) {
                try {
                    java.lang.Object obj = field.get(layoutParams);
                    if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                        java.lang.System.out.println(str2 + "       " + field.getName() + " " + obj);
                    }
                } catch (java.lang.IllegalAccessException unused) {
                }
            }
        }
    }

    public static void dumpPoc(java.lang.Object obj) {
        java.lang.StackTraceElement stackTraceElement = new java.lang.Throwable().getStackTrace()[1];
        java.lang.String str = ".(" + stackTraceElement.getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ")";
        java.lang.Class<?> cls = obj.getClass();
        java.lang.System.out.println(str + "------------- " + cls.getName() + " --------------------");
        for (java.lang.reflect.Field field : cls.getFields()) {
            try {
                java.lang.Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof java.lang.Integer) || !obj2.toString().equals("-1")) && ((!(obj2 instanceof java.lang.Integer) || !obj2.toString().equals("0")) && ((!(obj2 instanceof java.lang.Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof java.lang.Float) || !obj2.toString().equals("0.5")))))) {
                    java.lang.System.out.println(str + "    " + field.getName() + " " + obj2);
                }
            } catch (java.lang.IllegalAccessException unused) {
            }
        }
        java.lang.System.out.println(str + "------------- " + cls.getSimpleName() + " --------------------");
    }

    public static java.lang.String getActionType(android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        for (java.lang.reflect.Field field : android.view.MotionEvent.class.getFields()) {
            try {
                if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && field.getType().equals(java.lang.Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (java.lang.IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static java.lang.String getCallFrom(int i) {
        java.lang.StackTraceElement stackTraceElement = new java.lang.Throwable().getStackTrace()[i + 2];
        return ".(" + stackTraceElement.getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ")";
    }

    public static java.lang.String getLoc() {
        java.lang.StackTraceElement stackTraceElement = new java.lang.Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static java.lang.String getLocation() {
        java.lang.StackTraceElement stackTraceElement = new java.lang.Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ")";
    }

    public static java.lang.String getLocation2() {
        java.lang.StackTraceElement stackTraceElement = new java.lang.Throwable().getStackTrace()[2];
        return ".(" + stackTraceElement.getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ")";
    }

    public static java.lang.String getName(android.content.Context context, int i) {
        if (i == -1) {
            return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        try {
            return context.getResources().getResourceEntryName(i);
        } catch (java.lang.Exception unused) {
            return "?" + i;
        }
    }

    public static java.lang.String getName(android.content.Context context, int[] iArr) {
        java.lang.String str;
        try {
            java.lang.String str2 = iArr.length + "[";
            int i = 0;
            while (i < iArr.length) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str2);
                sb.append(i == 0 ? "" : " ");
                java.lang.String sb2 = sb.toString();
                try {
                    str = context.getResources().getResourceEntryName(iArr[i]);
                } catch (android.content.res.Resources.NotFoundException unused) {
                    str = "? " + iArr[i] + " ";
                }
                str2 = sb2 + str;
                i++;
            }
            return str2 + "]";
        } catch (java.lang.Exception e) {
            e.toString();
            return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static java.lang.String getName(android.view.View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (java.lang.Exception unused) {
            return com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static java.lang.String getState(androidx.constraintlayout.motion.widget.MotionLayout motionLayout, int i) {
        return i == -1 ? "UNDEFINED" : motionLayout.getContext().getResources().getResourceEntryName(i);
    }

    public static void logStack(java.lang.String str, java.lang.String str2, int i) {
        java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().getStackTrace();
        int min = java.lang.Math.min(i, stackTrace.length - 1);
        java.lang.String str3 = " ";
        for (int i2 = 1; i2 <= min; i2++) {
            java.lang.StackTraceElement stackTraceElement = stackTrace[i2];
            java.lang.String str4 = ".(" + stackTrace[i2].getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTrace[i2].getLineNumber() + ") " + stackTrace[i2].getMethodName();
            str3 = str3 + " ";
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str2);
            sb.append(str3);
            sb.append(str4);
            sb.append(str3);
        }
    }

    public static void printStack(java.lang.String str, int i) {
        java.lang.StackTraceElement[] stackTrace = new java.lang.Throwable().getStackTrace();
        int min = java.lang.Math.min(i, stackTrace.length - 1);
        java.lang.String str2 = " ";
        for (int i2 = 1; i2 <= min; i2++) {
            java.lang.StackTraceElement stackTraceElement = stackTrace[i2];
            java.lang.String str3 = ".(" + stackTrace[i2].getFileName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + stackTrace[i2].getLineNumber() + ") ";
            str2 = str2 + " ";
            java.lang.System.out.println(str + str2 + str3 + str2);
        }
    }
}
