package androidx.core.util;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\n¢\u0006\u0002\u0010\u0005\u001a2\u0010\u0006\u001a\n \u0002*\u0004\u0018\u0001H\u0003H\u0003\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\n¢\u0006\u0002\u0010\u0005\u001a1\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\bH\u0086\b\u001aA\u0010\t\u001a\u001e\u0012\f\u0012\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\u0012\f\u0012\n \u0002*\u0004\u0018\u0001H\u0003H\u00030\b\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004H\u0086\b¨\u0006\n"}, d2 = {"component1", "F", "kotlin.jvm.PlatformType", androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH, "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "component2", "toAndroidPair", "Lkotlin/Pair;", "toKotlinPair", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class PairKt {
    @android.annotation.SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(@org.jetbrains.annotations.NotNull android.util.Pair<F, S> component1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return (F) component1.first;
    }

    @android.annotation.SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(@org.jetbrains.annotations.NotNull android.util.Pair<F, S> component2) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return (S) component2.second;
    }

    @org.jetbrains.annotations.NotNull
    public static final <F, S> android.util.Pair<F, S> toAndroidPair(@org.jetbrains.annotations.NotNull kotlin.Pair<? extends F, ? extends S> toAndroidPair) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toAndroidPair, "$this$toAndroidPair");
        return new android.util.Pair<>(toAndroidPair.getFirst(), toAndroidPair.getSecond());
    }

    @org.jetbrains.annotations.NotNull
    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(@org.jetbrains.annotations.NotNull android.util.Pair<F, S> toKotlinPair) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toKotlinPair, "$this$toKotlinPair");
        return new kotlin.Pair<>(toKotlinPair.first, toKotlinPair.second);
    }
}
