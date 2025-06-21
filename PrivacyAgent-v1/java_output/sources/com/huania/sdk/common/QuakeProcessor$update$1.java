package com.huania.sdk.common;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "a", "(Ljava/lang/Long;)J"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class QuakeProcessor$update$1<T, R> implements io.reactivex.functions.Function<T, R> {
    public final /* synthetic */ com.huania.sdk.entity.EarthquakeEntity n;

    public QuakeProcessor$update$1(com.huania.sdk.entity.EarthquakeEntity earthquakeEntity) {
        this.n = earthquakeEntity;
    }

    public final long a(java.lang.Long it) {
        java.lang.Integer curCountdown = this.n.getCurCountdown();
        if (curCountdown == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        long intValue = curCountdown.intValue();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(it, "it");
        return intValue - it.longValue();
    }

    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ java.lang.Object apply(java.lang.Object obj) {
        return java.lang.Long.valueOf(a((java.lang.Long) obj));
    }
}
