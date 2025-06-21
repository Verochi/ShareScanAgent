package kotlin.sequences;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a-\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\"\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0012\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000\u001a2\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\tH\u0007\u001a\"\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002\u001a+\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r0\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aE\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a@\u0010\u0017\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00160\u0015\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0010*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00150\u0002\u001a\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u001a&\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0007\u001ab\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00020\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u001b\"\u0004\b\u0002\u0010\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00010\u0011H\u0000\u001a\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002\u001a&\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\"2\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t\u001a?\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\"2\b\u0010%\u001a\u0004\u0018\u00018\u00002\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0011H\u0007¢\u0006\u0004\b$\u0010&\u001a<\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0000*\u00020\"2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0011¨\u0006("}, d2 = {androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/sequences/Sequence;", "asSequence", "", "elements", "sequenceOf", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "emptySequence", "Lkotlin/Function0;", "defaultValue", "ifEmpty", "flatten", "", "flattenSequenceOfIterable", "(Lkotlin/sequences/Sequence;)Lkotlin/sequences/Sequence;", "R", "Lkotlin/Function1;", "iterator", "a", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "Lkotlin/Pair;", "", "unzip", "shuffled", "Lkotlin/random/Random;", "random", "C", com.tencent.open.SocialConstants.PARAM_SOURCE, "Lkotlin/Function2;", "", "transform", "flatMapIndexed", "constrainOnce", "", "nextFunction", "generateSequence", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "seedFunction", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes14.dex */
public class SequencesKt__SequencesKt extends kotlin.sequences.SequencesKt__SequencesJVMKt {
    public static final <T, R> kotlin.sequences.Sequence<R> a(kotlin.sequences.Sequence<? extends T> sequence, kotlin.jvm.functions.Function1<? super T, ? extends java.util.Iterator<? extends R>> function1) {
        return sequence instanceof kotlin.sequences.TransformingSequence ? ((kotlin.sequences.TransformingSequence) sequence).flatten$kotlin_stdlib(function1) : new kotlin.sequences.FlatteningSequence(sequence, kotlin.sequences.SequencesKt__SequencesKt$flatten$3.INSTANCE, function1);
    }

    @org.jetbrains.annotations.NotNull
    public static <T> kotlin.sequences.Sequence<T> asSequence(@org.jetbrains.annotations.NotNull java.util.Iterator<? extends T> it) {
        kotlin.sequences.Sequence<T> constrainOnce;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "<this>");
        constrainOnce = constrainOnce(new kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(it));
        return constrainOnce;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public static <T> kotlin.sequences.Sequence<T> constrainOnce(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sequence instanceof kotlin.sequences.ConstrainedOnceSequence ? sequence : new kotlin.sequences.ConstrainedOnceSequence(sequence);
    }

    @org.jetbrains.annotations.NotNull
    public static <T> kotlin.sequences.Sequence<T> emptySequence() {
        return kotlin.sequences.EmptySequence.a;
    }

    @org.jetbrains.annotations.NotNull
    public static final <T, C, R> kotlin.sequences.Sequence<R> flatMapIndexed(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> source, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super T, ? extends C> transform, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super C, ? extends java.util.Iterator<? extends R>> iterator) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(transform, "transform");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterator, "iterator");
        return kotlin.sequences.SequencesKt__SequenceBuilderKt.sequence(new kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1(source, transform, iterator, null));
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.sequences.Sequence<T> flatten(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends kotlin.sequences.Sequence<? extends T>> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return a(sequence, kotlin.sequences.SequencesKt__SequencesKt$flatten$1.INSTANCE);
    }

    @kotlin.jvm.JvmName(name = "flattenSequenceOfIterable")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.sequences.Sequence<T> flattenSequenceOfIterable(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends java.lang.Iterable<? extends T>> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return a(sequence, kotlin.sequences.SequencesKt__SequencesKt$flatten$2.INSTANCE);
    }

    @kotlin.internal.LowPriorityInOverloadResolution
    @org.jetbrains.annotations.NotNull
    public static <T> kotlin.sequences.Sequence<T> generateSequence(@org.jetbrains.annotations.Nullable T t, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return t == null ? kotlin.sequences.EmptySequence.a : new kotlin.sequences.GeneratorSequence(new kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2(t), nextFunction);
    }

    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.sequences.Sequence<T> generateSequence(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> nextFunction) {
        kotlin.sequences.Sequence<T> constrainOnce;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        constrainOnce = constrainOnce(new kotlin.sequences.GeneratorSequence(nextFunction, new kotlin.sequences.SequencesKt__SequencesKt$generateSequence$1(nextFunction)));
        return constrainOnce;
    }

    @org.jetbrains.annotations.NotNull
    public static <T> kotlin.sequences.Sequence<T> generateSequence(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> seedFunction, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, ? extends T> nextFunction) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(seedFunction, "seedFunction");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        return new kotlin.sequences.GeneratorSequence(seedFunction, nextFunction);
    }

    @kotlin.SinceKotlin(version = "1.3")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.sequences.Sequence<T> ifEmpty(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends kotlin.sequences.Sequence<? extends T>> defaultValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return kotlin.sequences.SequencesKt__SequenceBuilderKt.sequence(new kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1(sequence, defaultValue, null));
    }

    @org.jetbrains.annotations.NotNull
    public static <T> kotlin.sequences.Sequence<T> sequenceOf(@org.jetbrains.annotations.NotNull T... elements) {
        kotlin.sequences.Sequence<T> asSequence;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.length == 0) {
            return emptySequence();
        }
        asSequence = kotlin.collections.ArraysKt___ArraysKt.asSequence(elements);
        return asSequence;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.sequences.Sequence<T> shuffled(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        return shuffled(sequence, kotlin.random.Random.INSTANCE);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    public static final <T> kotlin.sequences.Sequence<T> shuffled(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends T> sequence, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        return kotlin.sequences.SequencesKt__SequenceBuilderKt.sequence(new kotlin.sequences.SequencesKt__SequencesKt$shuffled$1(sequence, random, null));
    }

    @org.jetbrains.annotations.NotNull
    public static final <T, R> kotlin.Pair<java.util.List<T>, java.util.List<R>> unzip(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<? extends kotlin.Pair<? extends T, ? extends R>> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (kotlin.Pair<? extends T, ? extends R> pair : sequence) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.TuplesKt.to(arrayList, arrayList2);
    }
}
