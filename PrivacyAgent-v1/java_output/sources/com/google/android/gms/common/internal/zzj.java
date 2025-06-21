package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public final class zzj {
    public static final android.net.Uri a;
    public static final android.net.Uri b;

    static {
        android.net.Uri parse = android.net.Uri.parse("https://plus.google.com/");
        a = parse;
        b = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static android.content.Intent zza() {
        android.content.Intent intent = new android.content.Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    public static android.content.Intent zza(java.lang.String str) {
        android.net.Uri fromParts = android.net.Uri.fromParts("package", str, null);
        android.content.Intent intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static android.content.Intent zza(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        android.net.Uri.Builder appendQueryParameter = android.net.Uri.parse("market://details").buildUpon().appendQueryParameter("id", str);
        if (!android.text.TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        intent.setData(appendQueryParameter.build());
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }
}
