package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u001c\u0010\u0000\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\n0\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0005\u001a\u001a\u0010\f\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001a\u0010\u0010\u001a\u00020\u0011*\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u001a\u0010\u0016\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/UCollectionsKt")
/* loaded from: classes14.dex */
class UCollectionsKt___UCollectionsKt {
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @kotlin.jvm.JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@org.jetbrains.annotations.NotNull java.lang.Iterable<kotlin.UByte> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.Iterator<kotlin.UByte> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = kotlin.UInt.m191constructorimpl(i + kotlin.UInt.m191constructorimpl(it.next().getData() & 255));
        }
        return i;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @kotlin.jvm.JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@org.jetbrains.annotations.NotNull java.lang.Iterable<kotlin.UInt> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.Iterator<kotlin.UInt> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = kotlin.UInt.m191constructorimpl(i + it.next().getData());
        }
        return i;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @kotlin.jvm.JvmName(name = "sumOfULong")
    public static final long sumOfULong(@org.jetbrains.annotations.NotNull java.lang.Iterable<kotlin.ULong> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.Iterator<kotlin.ULong> it = iterable.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = kotlin.ULong.m215constructorimpl(j + it.next().getData());
        }
        return j;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @kotlin.jvm.JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@org.jetbrains.annotations.NotNull java.lang.Iterable<kotlin.UShort> iterable) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(iterable, "<this>");
        java.util.Iterator<kotlin.UShort> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = kotlin.UInt.m191constructorimpl(i + kotlin.UInt.m191constructorimpl(it.next().getData() & kotlin.UShort.MAX_VALUE));
        }
        return i;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.ExperimentalUnsignedTypes
    @org.jetbrains.annotations.NotNull
    public static final byte[] toUByteArray(@org.jetbrains.annotations.NotNull java.util.Collection<kotlin.UByte> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        byte[] m174constructorimpl = kotlin.UByteArray.m174constructorimpl(collection.size());
        java.util.Iterator<kotlin.UByte> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            kotlin.UByteArray.m185setVurrAj0(m174constructorimpl, i, it.next().getData());
            i++;
        }
        return m174constructorimpl;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.ExperimentalUnsignedTypes
    @org.jetbrains.annotations.NotNull
    public static final int[] toUIntArray(@org.jetbrains.annotations.NotNull java.util.Collection<kotlin.UInt> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        int[] m198constructorimpl = kotlin.UIntArray.m198constructorimpl(collection.size());
        java.util.Iterator<kotlin.UInt> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            kotlin.UIntArray.m209setVXSXFK8(m198constructorimpl, i, it.next().getData());
            i++;
        }
        return m198constructorimpl;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.ExperimentalUnsignedTypes
    @org.jetbrains.annotations.NotNull
    public static final long[] toULongArray(@org.jetbrains.annotations.NotNull java.util.Collection<kotlin.ULong> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        long[] m222constructorimpl = kotlin.ULongArray.m222constructorimpl(collection.size());
        java.util.Iterator<kotlin.ULong> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            kotlin.ULongArray.m233setk8EXiF4(m222constructorimpl, i, it.next().getData());
            i++;
        }
        return m222constructorimpl;
    }

    @kotlin.SinceKotlin(version = "1.3")
    @kotlin.ExperimentalUnsignedTypes
    @org.jetbrains.annotations.NotNull
    public static final short[] toUShortArray(@org.jetbrains.annotations.NotNull java.util.Collection<kotlin.UShort> collection) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(collection, "<this>");
        short[] m246constructorimpl = kotlin.UShortArray.m246constructorimpl(collection.size());
        java.util.Iterator<kotlin.UShort> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            kotlin.UShortArray.m257set01HTLdE(m246constructorimpl, i, it.next().getData());
            i++;
        }
        return m246constructorimpl;
    }
}
