package kotlin.sequences;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"sum", "Lkotlin/UInt;", "Lkotlin/sequences/Sequence;", "Lkotlin/UByte;", "sumOfUByte", "(Lkotlin/sequences/Sequence;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Lkotlin/sequences/Sequence;)J", "Lkotlin/UShort;", "sumOfUShort", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/sequences/USequencesKt")
/* loaded from: classes14.dex */
class USequencesKt___USequencesKt {
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @kotlin.jvm.JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<kotlin.UByte> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        java.util.Iterator<kotlin.UByte> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = kotlin.UInt.m191constructorimpl(i + kotlin.UInt.m191constructorimpl(it.next().getData() & 255));
        }
        return i;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @kotlin.jvm.JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<kotlin.UInt> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        java.util.Iterator<kotlin.UInt> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = kotlin.UInt.m191constructorimpl(i + it.next().getData());
        }
        return i;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @kotlin.jvm.JvmName(name = "sumOfULong")
    public static final long sumOfULong(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<kotlin.ULong> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        java.util.Iterator<kotlin.ULong> it = sequence.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = kotlin.ULong.m215constructorimpl(j + it.next().getData());
        }
        return j;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @kotlin.jvm.JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@org.jetbrains.annotations.NotNull kotlin.sequences.Sequence<kotlin.UShort> sequence) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(sequence, "<this>");
        java.util.Iterator<kotlin.UShort> it = sequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = kotlin.UInt.m191constructorimpl(i + kotlin.UInt.m191constructorimpl(it.next().getData() & kotlin.UShort.MAX_VALUE));
        }
        return i;
    }
}
