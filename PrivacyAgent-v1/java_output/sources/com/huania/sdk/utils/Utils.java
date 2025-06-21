package com.huania.sdk.utils;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ'\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/huania/sdk/utils/Utils;", "", "()V", "formateMeihuan", "", "f", "", "scale", "", "(Ljava/lang/Float;I)Ljava/lang/String;", "formateMeihuanInt", "(Ljava/lang/Float;I)I", "getTheoryCountdown", com.anythink.expressad.d.a.b.dk, com.umeng.analytics.AnalyticsConfig.RTD_START_TIME, "", com.anythink.core.d.e.a.ad, "(FLjava/lang/Long;Ljava/lang/Long;)I", "sdk_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes22.dex */
public final class Utils {
    public static final com.huania.sdk.utils.Utils INSTANCE = new com.huania.sdk.utils.Utils();

    @org.jetbrains.annotations.NotNull
    public final java.lang.String formateMeihuan(@org.jetbrains.annotations.Nullable java.lang.Float f, int scale) {
        java.util.List split$default;
        if (f == null) {
            return "0";
        }
        java.lang.String bigDecimal = new java.math.BigDecimal(java.lang.String.valueOf(f.floatValue())).setScale(scale + 3, 1).toString();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(bigDecimal, "bigDecimal.setScale(scal…al.ROUND_DOWN).toString()");
        split$default = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) bigDecimal, new java.lang.String[]{"."}, false, 0, 6, (java.lang.Object) null);
        java.lang.String valueOf = java.lang.String.valueOf(split$default.get(1));
        java.lang.String substring = valueOf.substring(scale, valueOf.length() - 1);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        double pow = java.lang.Math.pow(10.0d, -scale);
        if (java.lang.Integer.parseInt(substring) > 50) {
            java.lang.String bigDecimal2 = new java.math.BigDecimal(f.floatValue() + pow).setScale(scale, 1).toString();
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(bigDecimal2, "BigDecimal(f + t).setSca…al.ROUND_DOWN).toString()");
            return bigDecimal2;
        }
        java.lang.String bigDecimal3 = new java.math.BigDecimal(java.lang.String.valueOf(f.floatValue())).setScale(scale, 1).toString();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(bigDecimal3, "BigDecimal(f.toString())…al.ROUND_DOWN).toString()");
        return bigDecimal3;
    }

    public final int formateMeihuanInt(@org.jetbrains.annotations.Nullable java.lang.Float f, int scale) {
        return java.lang.Integer.parseInt(formateMeihuan(f, scale));
    }

    public final int getTheoryCountdown(float countdown, @org.jetbrains.annotations.Nullable java.lang.Long startTime, @org.jetbrains.annotations.Nullable java.lang.Long updateTime) {
        if (startTime == null || updateTime == null) {
            return 0;
        }
        long longValue = (updateTime.longValue() - startTime.longValue()) / 1000;
        int formateMeihuanInt = INSTANCE.formateMeihuanInt(java.lang.Float.valueOf(countdown - longValue), 0);
        com.huania.sdk.utils.Logger.INSTANCE.d("系统响应时间：" + longValue + "    " + countdown + "   理论预警时间：" + formateMeihuanInt);
        return formateMeihuanInt;
    }
}
