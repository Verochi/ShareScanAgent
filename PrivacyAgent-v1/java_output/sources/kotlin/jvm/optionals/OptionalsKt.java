package kotlin.jvm.optionals;

@kotlin.Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u001a4\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\n\b\u0001\u0010\u0002*\u0004\b\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0007\u001a\u0002H\u0006H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a>\u0010\t\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\n\b\u0001\u0010\u0002*\u0004\b\u0002H\u0006*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a#\u0010\f\u001a\u0004\u0018\u0001H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\r\u001a;\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0010\b\u0001\u0010\u000f*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0011\u001a\u0002H\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0014\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u001a$\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0016\"\b\b\u0000\u0010\u0002*\u00020\u0003*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0004H\u0007\u0082\u0002\u000b\n\u0002\b9\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "Ljava/util/Optional;", "getOrDefault", "R", "defaultValue", "(Ljava/util/Optional;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lkotlin/Function0;", "(Ljava/util/Optional;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrNull", "(Ljava/util/Optional;)Ljava/lang/Object;", "toCollection", "C", "", "destination", "(Ljava/util/Optional;Ljava/util/Collection;)Ljava/util/Collection;", "toList", "", "toSet", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class OptionalsKt {
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.ExperimentalStdlibApi
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.sequences.Sequence<T> asSequence(@org.jetbrains.annotations.NotNull java.util.Optional<? extends T> optional) {
        boolean isPresent;
        java.lang.Object obj;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(optional, "<this>");
        isPresent = optional.isPresent();
        if (!isPresent) {
            return kotlin.sequences.SequencesKt__SequencesKt.emptySequence();
        }
        obj = optional.get();
        return kotlin.sequences.SequencesKt__SequencesKt.sequenceOf(obj);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.ExperimentalStdlibApi
    public static final <R, T extends R> R getOrDefault(@org.jetbrains.annotations.NotNull java.util.Optional<T> optional, R r) {
        boolean isPresent;
        java.lang.Object obj;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(optional, "<this>");
        isPresent = optional.isPresent();
        if (!isPresent) {
            return r;
        }
        obj = optional.get();
        return (R) obj;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.ExperimentalStdlibApi
    public static final <R, T extends R> R getOrElse(@org.jetbrains.annotations.NotNull java.util.Optional<T> optional, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends R> defaultValue) {
        boolean isPresent;
        java.lang.Object obj;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(optional, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        isPresent = optional.isPresent();
        if (!isPresent) {
            return defaultValue.invoke();
        }
        obj = optional.get();
        return (R) obj;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.ExperimentalStdlibApi
    @org.jetbrains.annotations.Nullable
    public static final <T> T getOrNull(@org.jetbrains.annotations.NotNull java.util.Optional<T> optional) {
        java.lang.Object orElse;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(optional, "<this>");
        orElse = optional.orElse(null);
        return (T) orElse;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.ExperimentalStdlibApi
    @org.jetbrains.annotations.NotNull
    public static final <T, C extends java.util.Collection<? super T>> C toCollection(@org.jetbrains.annotations.NotNull java.util.Optional<T> optional, @org.jetbrains.annotations.NotNull C destination) {
        boolean isPresent;
        java.lang.Object obj;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(optional, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(destination, "destination");
        isPresent = optional.isPresent();
        if (isPresent) {
            obj = optional.get();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(obj, "get()");
            destination.add(obj);
        }
        return destination;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.ExperimentalStdlibApi
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> toList(@org.jetbrains.annotations.NotNull java.util.Optional<? extends T> optional) {
        boolean isPresent;
        java.lang.Object obj;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(optional, "<this>");
        isPresent = optional.isPresent();
        if (!isPresent) {
            return kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
        }
        obj = optional.get();
        return kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(obj);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @kotlin.ExperimentalStdlibApi
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.Set<T> toSet(@org.jetbrains.annotations.NotNull java.util.Optional<? extends T> optional) {
        boolean isPresent;
        java.util.Set<T> emptySet;
        java.lang.Object obj;
        java.util.Set<T> of;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(optional, "<this>");
        isPresent = optional.isPresent();
        if (!isPresent) {
            emptySet = kotlin.collections.SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        obj = optional.get();
        of = kotlin.collections.SetsKt__SetsJVMKt.setOf(obj);
        return of;
    }
}
