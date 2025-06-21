package kotlin.streams.jdk8;

@kotlin.Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001a\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\t\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0003H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007¨\u0006\r"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 7, 1}, pn = "kotlin.streams", xi = 48)
@kotlin.jvm.JvmName(name = "StreamsKt")
/* loaded from: classes14.dex */
public final class StreamsKt {
    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<java.lang.Double> asSequence(@org.jetbrains.annotations.NotNull java.util.stream.DoubleStream doubleStream) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(doubleStream, "<this>");
        return new kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$4(doubleStream);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<java.lang.Integer> asSequence(@org.jetbrains.annotations.NotNull java.util.stream.IntStream intStream) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intStream, "<this>");
        return new kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$2(intStream);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final kotlin.sequences.Sequence<java.lang.Long> asSequence(@org.jetbrains.annotations.NotNull java.util.stream.LongStream longStream) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longStream, "<this>");
        return new kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$3(longStream);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.sequences.Sequence<T> asSequence(@org.jetbrains.annotations.NotNull java.util.stream.Stream<T> stream) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(stream, "<this>");
        return new kotlin.streams.jdk8.StreamsKt$asSequence$$inlined$Sequence$1(stream);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.stream.Stream<T> asStream(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence) {
        java.util.stream.Stream<T> stream;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        stream = java.util.stream.StreamSupport.stream(new defpackage.zr2(sequence), 16, false);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(stream, "stream({ Spliterators.sp…literator.ORDERED, false)");
        return stream;
    }

    public static final java.util.Spliterator b(kotlin.sequences.Sequence this_asStream) {
        java.util.Spliterator spliteratorUnknownSize;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(this_asStream, "$this_asStream");
        spliteratorUnknownSize = java.util.Spliterators.spliteratorUnknownSize(this_asStream.iterator(), 16);
        return spliteratorUnknownSize;
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Double> toList(@org.jetbrains.annotations.NotNull java.util.stream.DoubleStream doubleStream) {
        double[] array;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(doubleStream, "<this>");
        array = doubleStream.toArray();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return kotlin.collections.ArraysKt___ArraysJvmKt.asList(array);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Integer> toList(@org.jetbrains.annotations.NotNull java.util.stream.IntStream intStream) {
        int[] array;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(intStream, "<this>");
        array = intStream.toArray();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return kotlin.collections.ArraysKt___ArraysJvmKt.asList(array);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.Long> toList(@org.jetbrains.annotations.NotNull java.util.stream.LongStream longStream) {
        long[] array;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(longStream, "<this>");
        array = longStream.toArray();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(array, "toArray()");
        return kotlin.collections.ArraysKt___ArraysJvmKt.asList(array);
    }

    @kotlin.SinceKotlin(version = "1.2")
    @org.jetbrains.annotations.NotNull
    public static final <T> java.util.List<T> toList(@org.jetbrains.annotations.NotNull java.util.stream.Stream<T> stream) {
        java.util.stream.Collector list;
        java.lang.Object collect;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(stream, "<this>");
        list = java.util.stream.Collectors.toList();
        collect = stream.collect(list);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(collect, "collect(Collectors.toList<T>())");
        return (java.util.List) collect;
    }
}
