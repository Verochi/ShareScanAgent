package com.huawei.hms.push;

/* loaded from: classes22.dex */
public class m {
    public static com.huawei.hms.push.n a(com.huawei.hms.push.k kVar) {
        com.huawei.hms.push.n nVar = com.huawei.hms.push.n.STYLE_DEFAULT;
        return (kVar.w() < 0 || kVar.w() >= com.huawei.hms.push.n.values().length) ? nVar : com.huawei.hms.push.n.values()[kVar.w()];
    }

    public static void a(android.app.Notification.Builder builder, java.lang.String str, com.huawei.hms.push.k kVar) {
        android.app.Notification.BigTextStyle bigTextStyle = new android.app.Notification.BigTextStyle();
        if (!android.text.TextUtils.isEmpty(kVar.h())) {
            bigTextStyle.setBigContentTitle(kVar.h());
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = null;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            bigTextStyle.bigText(str);
        }
        builder.setStyle(bigTextStyle);
    }
}
