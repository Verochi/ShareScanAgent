package com.jd.ad.sdk.nativead;

/* loaded from: classes23.dex */
public class JADNativeWidget {
    private JADNativeWidget() {
    }

    @androidx.annotation.NonNull
    public static android.graphics.Bitmap getJDLogo(@androidx.annotation.NonNull android.content.Context context) {
        return android.graphics.BitmapFactory.decodeResource(context.getResources(), com.jd.ad.sdk.nativead.R.drawable.jad_logo);
    }

    @androidx.annotation.NonNull
    public static android.graphics.Bitmap getLogo(@androidx.annotation.NonNull android.content.Context context) {
        return android.graphics.BitmapFactory.decodeResource(context.getResources(), com.jd.ad.sdk.nativead.R.drawable.jad_logo_normal);
    }

    public static android.view.View getShakeAnimationView(android.content.Context context) {
        return new com.jd.ad.sdk.jad_n_an.jad_n_na(context).getView();
    }

    public static android.view.View getShakeAnimationView(android.content.Context context, java.lang.String str) {
        return new com.jd.ad.sdk.jad_n_an.jad_n_na(context, str).getView();
    }

    public static android.view.View getSwipeAnimationView(android.content.Context context) {
        return new com.jd.ad.sdk.jad_n_an.jad_n_ob(context).getView();
    }

    @androidx.annotation.NonNull
    public static android.graphics.Bitmap getTextLogo(@androidx.annotation.NonNull android.content.Context context) {
        return android.graphics.BitmapFactory.decodeResource(context.getResources(), com.jd.ad.sdk.nativead.R.drawable.jad_logo_no_ic);
    }
}
