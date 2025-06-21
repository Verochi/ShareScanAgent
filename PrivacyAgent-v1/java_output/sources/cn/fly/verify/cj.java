package cn.fly.verify;

/* loaded from: classes.dex */
public class cj implements cn.fly.verify.cw<android.content.pm.PackageManager> {
    @Override // cn.fly.verify.cw
    public boolean a(android.content.pm.PackageManager packageManager, java.lang.Class<android.content.pm.PackageManager> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        if (cn.fly.verify.dt.a("019<dedg1f@djdkeiXeifeiUej4fWdjdddi3cf fh").equals(str) && objArr.length == 2) {
            java.lang.Object obj = objArr[0];
            if (obj instanceof android.content.Intent) {
                java.lang.Object obj2 = objArr[1];
                if (obj2 instanceof java.lang.Integer) {
                    objArr2[0] = packageManager.queryIntentServices((android.content.Intent) obj, ((java.lang.Integer) obj2).intValue());
                    return true;
                }
            }
        }
        if (cn.fly.verify.dt.a("0254ee7fiYfcPd3dgJechSeiDeifeiZfleddjglPdc*dlId*eeVf").equals(str) && objArr.length == 1) {
            java.lang.Object obj3 = objArr[0];
            if (obj3 instanceof java.lang.String) {
                objArr2[0] = packageManager.getLaunchIntentForPackage((java.lang.String) obj3);
                return true;
            }
        }
        if (cn.fly.verify.dt.a("015%dj8f)fhed)gGddPf?elXci@didddiSiBdk").equals(str) && objArr.length == 2) {
            java.lang.Object obj4 = objArr[0];
            if (obj4 instanceof java.lang.Integer) {
                java.lang.Object obj5 = objArr[1];
                if (obj5 instanceof java.lang.Integer) {
                    objArr2[0] = packageManager.resolveActivity((android.content.Intent) obj4, ((java.lang.Integer) obj5).intValue());
                    return true;
                }
            }
        }
        return false;
    }
}
