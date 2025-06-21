package com.anythink.china.common;

/* loaded from: classes12.dex */
public final class d {
    public static final java.lang.String a = "android.permission.READ_PHONE_STATE";
    public static final java.lang.String b = "android.permission.WRITE_EXTERNAL_STORAGE";

    public interface a {
        void a();
    }

    private static void a(android.content.Context context, com.anythink.china.common.d.a aVar, java.lang.String... strArr) {
        if (context == null || android.os.Build.VERSION.SDK_INT < 23) {
            return;
        }
        int nextInt = new java.util.Random().nextInt(com.airbnb.lottie.utils.Utils.SECOND_IN_NANOS);
        if (aVar != null) {
            com.anythink.china.activity.TransparentActivity.e.put(java.lang.Integer.valueOf(nextInt), aVar);
        }
        android.content.Intent intent = new android.content.Intent(context, (java.lang.Class<?>) com.anythink.china.activity.TransparentActivity.class);
        intent.putExtra("type", 1000);
        intent.putExtra(com.anythink.china.activity.TransparentActivity.b, nextInt);
        intent.putExtra(com.anythink.china.activity.TransparentActivity.d, strArr);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static boolean a(android.content.Context context, java.lang.String str) {
        try {
            return androidx.core.content.ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
