package fm.jiecao.jcvideoplayer_lib;

/* loaded from: classes9.dex */
public class JCUtils {
    public static android.app.Activity scanForActivity(android.content.Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof android.app.Activity) {
            return (android.app.Activity) context;
        }
        if (context instanceof android.content.ContextWrapper) {
            return scanForActivity(((android.content.ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static java.lang.String stringForTime(int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Formatter formatter = new java.util.Formatter(sb, java.util.Locale.getDefault());
        try {
            int i2 = i / 1000;
            int i3 = i2 % 60;
            int i4 = (i2 / 60) % 60;
            int i5 = i2 / com.anythink.expressad.d.a.b.ck;
            sb.setLength(0);
            if (i5 > 0) {
                java.lang.String formatter2 = formatter.format("%d:%02d:%02d", java.lang.Integer.valueOf(i5), java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i3)).toString();
                formatter.close();
                return formatter2;
            }
            java.lang.String formatter3 = formatter.format("%02d:%02d", java.lang.Integer.valueOf(i4), java.lang.Integer.valueOf(i3)).toString();
            formatter.close();
            return formatter3;
        } catch (java.lang.Throwable th) {
            try {
                formatter.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static java.lang.String stringForTotalTime(java.lang.String str) {
        int parseInt = (android.text.TextUtils.isEmpty(str) || !android.text.TextUtils.isDigitsOnly(str)) ? 0 : java.lang.Integer.parseInt(str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Formatter formatter = new java.util.Formatter(sb, java.util.Locale.getDefault());
        try {
            int i = parseInt % 60;
            int i2 = (parseInt / 60) % 60;
            int i3 = parseInt / com.anythink.expressad.d.a.b.ck;
            sb.setLength(0);
            if (i3 > 0) {
                java.lang.String formatter2 = formatter.format("%d:%02d:%02d", java.lang.Integer.valueOf(i3), java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i)).toString();
                formatter.close();
                return formatter2;
            }
            java.lang.String formatter3 = formatter.format("%02d:%02d", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(i)).toString();
            formatter.close();
            return formatter3;
        } catch (java.lang.Throwable th) {
            try {
                formatter.close();
            } catch (java.lang.Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
