package kotlin.random;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0000*\u00020\u0001H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000¨\u0006\t"}, d2 = {"Lkotlin/random/Random;", "Ljava/util/Random;", "asJavaRandom", "asKotlinRandom", "", "hi26", "low27", "", "doubleFromParts", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class PlatformRandomKt {
    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final java.util.Random asJavaRandom(@org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        java.util.Random impl;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        kotlin.random.AbstractPlatformRandom abstractPlatformRandom = random instanceof kotlin.random.AbstractPlatformRandom ? (kotlin.random.AbstractPlatformRandom) random : null;
        return (abstractPlatformRandom == null || (impl = abstractPlatformRandom.getImpl()) == null) ? new kotlin.random.KotlinRandom(random) : impl;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final kotlin.random.Random asKotlinRandom(@org.jetbrains.annotations.NotNull java.util.Random random) {
        kotlin.random.Random impl;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "<this>");
        kotlin.random.KotlinRandom kotlinRandom = random instanceof kotlin.random.KotlinRandom ? (kotlin.random.KotlinRandom) random : null;
        return (kotlinRandom == null || (impl = kotlinRandom.getImpl()) == null) ? new kotlin.random.PlatformRandom(random) : impl;
    }

    public static final double doubleFromParts(int i, int i2) {
        return ((i << 27) + i2) / 9.007199254740992E15d;
    }
}
