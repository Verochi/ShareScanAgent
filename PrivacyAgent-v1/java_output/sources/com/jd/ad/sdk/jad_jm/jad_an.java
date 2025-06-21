package com.jd.ad.sdk.jad_jm;

/* loaded from: classes23.dex */
public class jad_an {
    public static java.util.List<java.lang.String> jad_an(android.content.Context context) {
        try {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            android.content.Intent intent = new android.content.Intent();
            intent.setAction("android.intent.action.SCREEN_ON");
            java.util.Iterator<android.content.pm.ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(intent, 0).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().activityInfo.packageName);
            }
            return arrayList;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }
}
