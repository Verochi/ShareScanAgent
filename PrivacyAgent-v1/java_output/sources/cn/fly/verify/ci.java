package cn.fly.verify;

/* loaded from: classes.dex */
public class ci implements cn.fly.verify.cw<android.app.NotificationManager> {
    @Override // cn.fly.verify.cw
    public boolean a(android.app.NotificationManager notificationManager, java.lang.Class<android.app.NotificationManager> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        if (cn.fly.verify.ba.a("025eTfl;hfkh.gjgfNk9fkghfk0efkSfkgf=g)imLjfgghi").equals(str) && android.os.Build.VERSION.SDK_INT >= 26 && objArr.length == 1) {
            java.lang.Object obj = objArr[0];
            if (obj instanceof android.app.NotificationChannel) {
                notificationManager.createNotificationChannel((android.app.NotificationChannel) obj);
                return true;
            }
        }
        if (cn.fly.verify.ba.a("006gHgfRk0fkghfm").equals(str)) {
            if (objArr.length == 2) {
                int intValue = ((java.lang.Integer) objArr[0]).intValue();
                android.app.Notification notification = (android.app.Notification) objArr[1];
                notificationManager.notify(intValue, notification);
                com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNotify(notificationManager, intValue, notification);
                return true;
            }
            if (objArr.length == 3) {
                java.lang.String str2 = (java.lang.String) objArr[0];
                int intValue2 = ((java.lang.Integer) objArr[1]).intValue();
                android.app.Notification notification2 = (android.app.Notification) objArr[2];
                notificationManager.notify(str2, intValue2, notification2);
                com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper.onNotify(notificationManager, str2, intValue2, notification2);
                return true;
            }
        } else {
            if (cn.fly.verify.ba.a("025Ffe'hihkh4gjgf]kMfkghfkOefk[fkgf,g0im2jfgghi").equals(str) && android.os.Build.VERSION.SDK_INT >= 26 && objArr.length == 1) {
                notificationManager.deleteNotificationChannel((java.lang.String) objArr[0]);
                return true;
            }
            if (cn.fly.verify.ba.a("006efgehi").equals(str)) {
                if (objArr.length == 1) {
                    notificationManager.cancel(((java.lang.Integer) objArr[0]).intValue());
                    return true;
                }
                if (objArr.length == 2) {
                    notificationManager.cancel((java.lang.String) objArr[0], ((java.lang.Integer) objArr[1]).intValue());
                    return true;
                }
            }
        }
        return false;
    }
}
