package kotlin.random;

@kotlin.Metadata(d1 = {"\u0000\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lkotlin/random/FallbackThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "kotlin/random/FallbackThreadLocalRandom$implStorage$1", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "Lkotlin/random/FallbackThreadLocalRandom$implStorage$1;", "implStorage", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "impl", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class FallbackThreadLocalRandom extends kotlin.random.AbstractPlatformRandom {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.random.FallbackThreadLocalRandom$implStorage$1 implStorage = new kotlin.random.FallbackThreadLocalRandom$implStorage$1();

    @Override // kotlin.random.AbstractPlatformRandom
    @org.jetbrains.annotations.NotNull
    public java.util.Random getImpl() {
        java.util.Random random = this.implStorage.get();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(random, "implStorage.get()");
        return random;
    }
}
