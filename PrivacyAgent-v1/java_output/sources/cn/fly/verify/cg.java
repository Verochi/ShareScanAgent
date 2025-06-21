package cn.fly.verify;

/* loaded from: classes.dex */
public class cg implements cn.fly.verify.cw<android.content.Context> {
    @Override // cn.fly.verify.cw
    public boolean a(android.content.Context context, java.lang.Class<android.content.Context> cls, java.lang.String str, java.lang.Object[] objArr, boolean[] zArr, java.lang.Object[] objArr2, java.lang.Throwable[] thArr) {
        int checkSelfPermission;
        if (cn.fly.verify.dn.a("016Lcc.dgJchbidf gdHbdchGdObhbbbg9ad").equals(str) && objArr.length == 1) {
            java.lang.Object obj = objArr[0];
            if (obj instanceof java.lang.String) {
                try {
                    objArr2[0] = context.getSystemService((java.lang.String) obj);
                } catch (java.lang.Throwable th) {
                    objArr2[0] = null;
                    thArr[0] = th;
                }
                return true;
            }
        }
        if ("getApplicationInfo".equals(str) && objArr.length == 0) {
            objArr2[0] = context.getApplicationInfo();
            return true;
        }
        if (cn.fly.verify.dn.a("018%ccMdg)eicb3cgdcgAeg(d@dfcbNe*bbZd]bh").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getContentResolver();
            return true;
        }
        if (cn.fly.verify.dn.a("014Acc0dg.ejVba'bj^bYcc8dFcfHb.bdAd").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getPackageName();
            return true;
        }
        if (cn.fly.verify.dn.a("017;ccTdg=ejNbaAbj?b_cc>d8fa?bcb+ccAd$bh").equals(str) && objArr.length == 0) {
            objArr2[0] = context.getPackageManager();
            return true;
        }
        if (cn.fly.verify.dn.a("013+dfFgbJbh*gDcj3ag;bgbbbg g'bi").equals(str) && objArr.length == 1) {
            java.lang.Object obj2 = objArr[0];
            if (obj2 instanceof android.content.Intent) {
                context.startActivity((android.content.Intent) obj2);
                return true;
            }
        }
        if (cn.fly.verify.dn.a("0118ccVdg djbgXed%dfdibgbh").equals(str)) {
            objArr2[0] = context.getFilesDir();
            return true;
        }
        if (cn.fly.verify.dn.a("009MccUdgHcjdfdf_dgVdf").equals(str)) {
            objArr2[0] = context.getAssets();
            return true;
        }
        if (cn.fly.verify.dn.a("019afdaVbjchZdeAcdejTd^bhbdbgdfdfbgcb6c").equals(str) && objArr.length == 1) {
            java.lang.Object obj3 = objArr[0];
            if (obj3 instanceof java.lang.String) {
                if (android.os.Build.VERSION.SDK_INT >= 23) {
                    checkSelfPermission = context.checkSelfPermission((java.lang.String) obj3);
                    objArr2[0] = java.lang.Integer.valueOf(checkSelfPermission);
                } else {
                    objArr2[0] = java.lang.Integer.valueOf(context.getPackageManager().checkPermission((java.lang.String) objArr[0], context.getPackageName()));
                }
                return true;
            }
        }
        if (cn.fly.verify.dn.a("011Ldcbg c4bach1dHbhbbbg<ad").equals(str) && objArr.length == 3) {
            objArr2[0] = java.lang.Boolean.valueOf(context.bindService((android.content.Intent) objArr[0], (android.content.ServiceConnection) objArr[1], ((java.lang.Integer) objArr[2]).intValue()));
            return true;
        }
        if (cn.fly.verify.dn.a("0134be[cIdcbg3c(bach0d5bhbbbg+ad").equals(str) && objArr.length == 1) {
            java.lang.Object obj4 = objArr[0];
            if (obj4 instanceof android.content.ServiceConnection) {
                context.unbindService((android.content.ServiceConnection) obj4);
                return true;
            }
        }
        return false;
    }
}
