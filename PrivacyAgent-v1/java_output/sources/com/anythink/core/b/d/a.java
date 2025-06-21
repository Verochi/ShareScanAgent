package com.anythink.core.b.d;

/* loaded from: classes12.dex */
public class a {
    static final java.lang.String a = "a";

    public static double a(double d, double d2) {
        return d2 > 0.0d ? d + (d2 * d) : d;
    }

    public static double a(double d, double d2, double d3) {
        return d3 > 0.0d ? d2 + ((d - d2) * d3) : d2;
    }

    public static double a(com.anythink.core.common.f.au auVar) {
        int a2 = auVar.a();
        double av = a2 != 2 ? (a2 == 3 || a2 == 4 || a2 == 5 || a2 == 8) ? auVar.av() : 0.0d : auVar.at();
        if (av > 0.0d) {
            return av;
        }
        return 0.0d;
    }

    public static int a(boolean z, int i, int i2) {
        return i == i2 ? !z ? 1 : 2 : (i == 67 || i == 35) ? 3 : 4;
    }

    private static java.lang.String a(int i) {
        return i == 2 ? com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB : com.anythink.core.api.ErrorCode.networkError;
    }

    public static java.lang.String a(com.anythink.core.common.f.q qVar, double d) {
        int i = qVar.d;
        return (i == 8 || i == 28) ? java.lang.String.valueOf((int) java.lang.Math.round(d)) : java.lang.String.valueOf(d);
    }

    public static java.lang.String a(com.anythink.core.common.f.q qVar, double d, double d2) {
        java.lang.String str = qVar.winNoticeUrl;
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        int i = qVar.d;
        java.lang.String replace = str.replace(com.anythink.core.b.d.b.e, a(qVar, d2));
        return i == 28 ? replace.replace(com.anythink.core.b.d.b.b, a(qVar, d)) : replace;
    }

    public static java.lang.String a(com.anythink.core.common.f.q qVar, int i, boolean z, double d, java.lang.String str) {
        java.lang.String replace;
        java.lang.String str2 = qVar.loseNoticeUrl;
        if (android.text.TextUtils.isEmpty(str2)) {
            return null;
        }
        int i2 = qVar.d;
        java.lang.String replace2 = str2.replace(com.anythink.core.b.d.b.b, a(qVar, d)).replace(com.anythink.core.b.d.b.c, str);
        if (i2 == 8) {
            replace = replace2.replace(com.anythink.core.b.d.b.d, java.lang.String.valueOf(i == i2 ? !z ? 1 : 4 : (i == 67 || i == 35) ? 3 : 2));
        } else if (i2 == 29) {
            replace = replace2.replace(com.anythink.core.b.d.b.d, i2 == i ? "1" : "10001");
        } else {
            replace = replace2.replace(com.anythink.core.b.d.b.d, "");
        }
        return i2 == 6 ? replace.replace(com.anythink.core.b.d.b.f, com.anythink.core.api.ATAdConst.CURRENCY.USD.toString()) : replace;
    }

    public static java.lang.String a(boolean z, int i) {
        return i == 3 ? "-1" : i == 1 ? "5" : i == 4 ? "2" : z ? com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB : com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL;
    }

    public static double b(com.anythink.core.common.f.au auVar) {
        double au;
        int a2 = auVar.a();
        if (a2 == 1) {
            if (auVar.d() == 22) {
                au = auVar.au();
                auVar.u();
            }
            au = 0.0d;
        } else if (a2 != 2) {
            if (a2 == 3 || a2 == 4 || a2 == 5 || a2 == 8) {
                au = auVar.aw();
            }
            au = 0.0d;
        } else {
            au = auVar.au();
        }
        if (au > 0.0d) {
            return au;
        }
        return 0.0d;
    }

    public static java.lang.String b(boolean z, int i, int i2) {
        return i == 3 ? "-1" : i2 == 8 ? i == 1 ? "5" : "1" : i2 == 29 ? i == 1 ? com.anythink.core.api.ErrorCode.adapterNotExistError : "2" : i2 == 34 ? i == 2 ? com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB : com.anythink.core.api.ErrorCode.networkError : (i2 == 59 || z) ? com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB : com.anythink.core.api.ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL;
    }

    private static int c(boolean z, int i, int i2) {
        return i == i2 ? !z ? 1 : 4 : (i == 67 || i == 35) ? 3 : 2;
    }
}
