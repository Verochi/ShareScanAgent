package com.jd.ad.sdk.jad_er;

/* loaded from: classes23.dex */
public class jad_an {
    public static boolean jad_an(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        boolean jad_an = com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an.jad_an(13, (java.lang.String) null);
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(str));
        if (!(context instanceof android.app.Activity) || !jad_an) {
            intent.addFlags(268435456);
        }
        if (com.jd.ad.sdk.jad_qd.jad_hu.jad_er() != 1) {
            return false;
        }
        try {
            if (!(context instanceof android.app.Activity) || jad_an) {
                context.startActivity(intent);
            } else {
                try {
                    ((android.app.Activity) context).startActivityForResult(intent, com.jd.ad.sdk.bl.initsdk.JADYunSdk.REQUEST_CODE_MEDIA_DIALOG);
                } catch (java.lang.Exception unused) {
                    context.startActivity(intent);
                }
            }
            return true;
        } catch (java.lang.Exception e) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.INTERACTION_CLICK_OPEN_JD_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e.getMessage()));
            return false;
        }
    }

    public static boolean jad_bo(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull java.lang.String str) {
        if (!android.text.TextUtils.isEmpty(str) && context != null) {
            try {
                com.jd.ad.sdk.bl.adinteraction.deeplink.JADWebViewActivity.startActivity(context, str);
                return true;
            } catch (java.lang.Exception unused) {
            }
        }
        return false;
    }
}
