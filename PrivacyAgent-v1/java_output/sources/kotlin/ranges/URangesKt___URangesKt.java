package kotlin.ranges;

@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0016\u0010\u0002\u001a\u00020\u0005*\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007ø\u0001\u0000\u001a\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0007ø\u0001\u0000\u001a\u0016\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0016\u0010\b\u001a\u00020\u0005*\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a\u0011\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007ø\u0001\u0000\u001a\u0011\u0010\t\u001a\u0004\u0018\u00010\u0005*\u00020\u0004H\u0007ø\u0001\u0000\u001a\u001e\u0010\f\u001a\u00020\u0001*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\f\u001a\u00020\u0005*\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000f\u001a\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0007ø\u0001\u0000\u001a\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u0005*\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0007ø\u0001\u0000\u001a\u001f\u0010\u0016\u001a\u00020\u0013*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0016\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001f\u0010\u0016\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001f\u0010\u0016\u001a\u00020\u0013*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u0016\u001a\u00020\u0013*\u00020\n2\u0006\u0010\u0012\u001a\u00020\u001dH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u0016\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u001dH\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\u001f\u0010%\u001a\u00020\u0000*\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u0000*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a\u001f\u0010%\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u001f\u0010%\u001a\u00020\u0000*\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\f\u0010,\u001a\u00020\u0000*\u00020\u0000H\u0007\u001a\f\u0010,\u001a\u00020\u0004*\u00020\u0004H\u0007\u001a\u0015\u0010.\u001a\u00020\u0000*\u00020\u00002\u0006\u0010.\u001a\u00020-H\u0087\u0004\u001a\u0015\u0010.\u001a\u00020\u0004*\u00020\u00042\u0006\u0010.\u001a\u00020/H\u0087\u0004\u001a\u001f\u00102\u001a\u00020\n*\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\u001f\u00102\u001a\u00020\n*\u00020\u00012\u0006\u0010\"\u001a\u00020\u0001H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a\u001f\u00102\u001a\u00020\u000e*\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a\u001f\u00102\u001a\u00020\n*\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0087\u0004ø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a\u001e\u0010<\u001a\u00020\u0001*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\u001e\u0010<\u001a\u00020\u0005*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u001e\u0010<\u001a\u00020\u0011*\u00020\u00112\u0006\u00109\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a\u001e\u0010<\u001a\u00020\u001d*\u00020\u001d2\u0006\u00109\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001a\u001e\u0010E\u001a\u00020\u0001*\u00020\u00012\u0006\u0010C\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010;\u001a\u001e\u0010E\u001a\u00020\u0005*\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bF\u0010>\u001a\u001e\u0010E\u001a\u00020\u0011*\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\bG\u0010@\u001a\u001e\u0010E\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010C\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\bH\u0010B\u001a&\u0010K\u001a\u00020\u0001*\u00020\u00012\u0006\u00109\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\bI\u0010J\u001a&\u0010K\u001a\u00020\u0005*\u00020\u00052\u0006\u00109\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\bL\u0010M\u001a&\u0010K\u001a\u00020\u0011*\u00020\u00112\u0006\u00109\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H\u0007ø\u0001\u0000¢\u0006\u0004\bN\u0010O\u001a&\u0010K\u001a\u00020\u001d*\u00020\u001d2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\u001dH\u0007ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a$\u0010K\u001a\u00020\u0001*\u00020\u00012\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00010RH\u0007ø\u0001\u0000¢\u0006\u0004\bT\u0010U\u001a$\u0010K\u001a\u00020\u0005*\u00020\u00052\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00050RH\u0007ø\u0001\u0000¢\u0006\u0004\bV\u0010W\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006X"}, d2 = {"Lkotlin/ranges/UIntProgression;", "Lkotlin/UInt;", "first", "(Lkotlin/ranges/UIntProgression;)I", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ULong;", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "Lkotlin/ranges/UIntRange;", "Lkotlin/random/Random;", "random", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "Lkotlin/ranges/ULongRange;", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "Lkotlin/UByte;", "value", "", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "Lkotlin/UShort;", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", com.huawei.hms.push.constant.RemoteMessageConst.TO, "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "reversed", "", "step", "", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "minimumValue", "coerceAtLeast-J1ME1BU", "(II)I", "coerceAtLeast", "coerceAtLeast-eb3DHEI", "(JJ)J", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast-5PvTz6A", "(SS)S", "maximumValue", "coerceAtMost-J1ME1BU", "coerceAtMost", "coerceAtMost-eb3DHEI", "coerceAtMost-Kr8caGY", "coerceAtMost-5PvTz6A", "coerceIn-WZ9TVnA", "(III)I", "coerceIn", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-VKSA0NQ", "(SSS)S", "Lkotlin/ranges/ClosedRange;", "range", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/ranges/URangesKt")
/* loaded from: classes14.dex */
class URangesKt___URangesKt {
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-5PvTz6A, reason: not valid java name */
    public static final short m581coerceAtLeast5PvTz6A(short s2, short s3) {
        return kotlin.jvm.internal.Intrinsics.compare(s2 & kotlin.UShort.MAX_VALUE, 65535 & s3) < 0 ? s3 : s2;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-J1ME1BU, reason: not valid java name */
    public static final int m582coerceAtLeastJ1ME1BU(int i, int i2) {
        return kotlin.UnsignedKt.uintCompare(i, i2) < 0 ? i2 : i;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-Kr8caGY, reason: not valid java name */
    public static final byte m583coerceAtLeastKr8caGY(byte b, byte b2) {
        return kotlin.jvm.internal.Intrinsics.compare(b & 255, b2 & 255) < 0 ? b2 : b;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtLeast-eb3DHEI, reason: not valid java name */
    public static final long m584coerceAtLeasteb3DHEI(long j, long j2) {
        return kotlin.UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : j;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-5PvTz6A, reason: not valid java name */
    public static final short m585coerceAtMost5PvTz6A(short s2, short s3) {
        return kotlin.jvm.internal.Intrinsics.compare(s2 & kotlin.UShort.MAX_VALUE, 65535 & s3) > 0 ? s3 : s2;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-J1ME1BU, reason: not valid java name */
    public static final int m586coerceAtMostJ1ME1BU(int i, int i2) {
        return kotlin.UnsignedKt.uintCompare(i, i2) > 0 ? i2 : i;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-Kr8caGY, reason: not valid java name */
    public static final byte m587coerceAtMostKr8caGY(byte b, byte b2) {
        return kotlin.jvm.internal.Intrinsics.compare(b & 255, b2 & 255) > 0 ? b2 : b;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceAtMost-eb3DHEI, reason: not valid java name */
    public static final long m588coerceAtMosteb3DHEI(long j, long j2) {
        return kotlin.UnsignedKt.ulongCompare(j, j2) > 0 ? j2 : j;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-JPwROB0, reason: not valid java name */
    public static final long m589coerceInJPwROB0(long j, @org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<kotlin.ULong> range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof kotlin.ranges.ClosedFloatingPointRange) {
            return ((kotlin.ULong) kotlin.ranges.RangesKt___RangesKt.coerceIn(kotlin.ULong.m214boximpl(j), (kotlin.ranges.ClosedFloatingPointRange<kotlin.ULong>) range)).getData();
        }
        if (!range.isEmpty()) {
            return kotlin.UnsignedKt.ulongCompare(j, range.getStart().getData()) < 0 ? range.getStart().getData() : kotlin.UnsignedKt.ulongCompare(j, range.getEndInclusive().getData()) > 0 ? range.getEndInclusive().getData() : j;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-VKSA0NQ, reason: not valid java name */
    public static final short m590coerceInVKSA0NQ(short s2, short s3, short s4) {
        int i = s3 & kotlin.UShort.MAX_VALUE;
        int i2 = s4 & kotlin.UShort.MAX_VALUE;
        if (kotlin.jvm.internal.Intrinsics.compare(i, i2) <= 0) {
            int i3 = 65535 & s2;
            return kotlin.jvm.internal.Intrinsics.compare(i3, i) < 0 ? s3 : kotlin.jvm.internal.Intrinsics.compare(i3, i2) > 0 ? s4 : s2;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((java.lang.Object) kotlin.UShort.m243toStringimpl(s4)) + " is less than minimum " + ((java.lang.Object) kotlin.UShort.m243toStringimpl(s3)) + '.');
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-WZ9TVnA, reason: not valid java name */
    public static final int m591coerceInWZ9TVnA(int i, int i2, int i3) {
        if (kotlin.UnsignedKt.uintCompare(i2, i3) <= 0) {
            return kotlin.UnsignedKt.uintCompare(i, i2) < 0 ? i2 : kotlin.UnsignedKt.uintCompare(i, i3) > 0 ? i3 : i;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((java.lang.Object) kotlin.UInt.m195toStringimpl(i3)) + " is less than minimum " + ((java.lang.Object) kotlin.UInt.m195toStringimpl(i2)) + '.');
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-b33U2AM, reason: not valid java name */
    public static final byte m592coerceInb33U2AM(byte b, byte b2, byte b3) {
        int i = b2 & 255;
        int i2 = b3 & 255;
        if (kotlin.jvm.internal.Intrinsics.compare(i, i2) <= 0) {
            int i3 = b & 255;
            return kotlin.jvm.internal.Intrinsics.compare(i3, i) < 0 ? b2 : kotlin.jvm.internal.Intrinsics.compare(i3, i2) > 0 ? b3 : b;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((java.lang.Object) kotlin.UByte.m171toStringimpl(b3)) + " is less than minimum " + ((java.lang.Object) kotlin.UByte.m171toStringimpl(b2)) + '.');
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-sambcqE, reason: not valid java name */
    public static final long m593coerceInsambcqE(long j, long j2, long j3) {
        if (kotlin.UnsignedKt.ulongCompare(j2, j3) <= 0) {
            return kotlin.UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : kotlin.UnsignedKt.ulongCompare(j, j3) > 0 ? j3 : j;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((java.lang.Object) kotlin.ULong.m219toStringimpl(j3)) + " is less than minimum " + ((java.lang.Object) kotlin.ULong.m219toStringimpl(j2)) + '.');
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: coerceIn-wuiCnnA, reason: not valid java name */
    public static final int m594coerceInwuiCnnA(int i, @org.jetbrains.annotations.NotNull kotlin.ranges.ClosedRange<kotlin.UInt> range) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof kotlin.ranges.ClosedFloatingPointRange) {
            return ((kotlin.UInt) kotlin.ranges.RangesKt___RangesKt.coerceIn(kotlin.UInt.m190boximpl(i), (kotlin.ranges.ClosedFloatingPointRange<kotlin.UInt>) range)).getData();
        }
        if (!range.isEmpty()) {
            return kotlin.UnsignedKt.uintCompare(i, range.getStart().getData()) < 0 ? range.getStart().getData() : kotlin.UnsignedKt.uintCompare(i, range.getEndInclusive().getData()) > 0 ? range.getEndInclusive().getData() : i;
        }
        throw new java.lang.IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: contains-68kG9v0, reason: not valid java name */
    public static final boolean m595contains68kG9v0(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntRange contains, byte b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m572containsWZ4Q5Ns(kotlin.UInt.m191constructorimpl(b & 255));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: contains-Gab390E, reason: not valid java name */
    public static final boolean m596containsGab390E(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongRange contains, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m578containsVKZWuLQ(kotlin.ULong.m215constructorimpl(i & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: contains-ULb-yJY, reason: not valid java name */
    public static final boolean m597containsULbyJY(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongRange contains, byte b) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m578containsVKZWuLQ(kotlin.ULong.m215constructorimpl(b & 255));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: contains-ZsK3CEQ, reason: not valid java name */
    public static final boolean m598containsZsK3CEQ(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntRange contains, short s2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m572containsWZ4Q5Ns(kotlin.UInt.m191constructorimpl(s2 & kotlin.UShort.MAX_VALUE));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: contains-fz5IDCE, reason: not valid java name */
    public static final boolean m599containsfz5IDCE(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntRange contains, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return kotlin.ULong.m215constructorimpl(j >>> 32) == 0 && contains.m572containsWZ4Q5Ns(kotlin.UInt.m191constructorimpl((int) j));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    /* renamed from: contains-uhHAxoY, reason: not valid java name */
    public static final boolean m600containsuhHAxoY(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongRange contains, short s2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(contains, "$this$contains");
        return contains.m578containsVKZWuLQ(kotlin.ULong.m215constructorimpl(s2 & 65535));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    /* renamed from: downTo-5PvTz6A, reason: not valid java name */
    public static final kotlin.ranges.UIntProgression m601downTo5PvTz6A(short s2, short s3) {
        return kotlin.ranges.UIntProgression.INSTANCE.m571fromClosedRangeNkh28Cs(kotlin.UInt.m191constructorimpl(s2 & kotlin.UShort.MAX_VALUE), kotlin.UInt.m191constructorimpl(s3 & kotlin.UShort.MAX_VALUE), -1);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    /* renamed from: downTo-J1ME1BU, reason: not valid java name */
    public static final kotlin.ranges.UIntProgression m602downToJ1ME1BU(int i, int i2) {
        return kotlin.ranges.UIntProgression.INSTANCE.m571fromClosedRangeNkh28Cs(i, i2, -1);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    /* renamed from: downTo-Kr8caGY, reason: not valid java name */
    public static final kotlin.ranges.UIntProgression m603downToKr8caGY(byte b, byte b2) {
        return kotlin.ranges.UIntProgression.INSTANCE.m571fromClosedRangeNkh28Cs(kotlin.UInt.m191constructorimpl(b & 255), kotlin.UInt.m191constructorimpl(b2 & 255), -1);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    /* renamed from: downTo-eb3DHEI, reason: not valid java name */
    public static final kotlin.ranges.ULongProgression m604downToeb3DHEI(long j, long j2) {
        return kotlin.ranges.ULongProgression.INSTANCE.m577fromClosedRange7ftBX0g(j, j2, -1L);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    public static final int first(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntProgression uIntProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.getFirst();
        }
        throw new java.util.NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    public static final long first(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongProgression uLongProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.getFirst();
        }
        throw new java.util.NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @org.jetbrains.annotations.Nullable
    public static final kotlin.UInt firstOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntProgression uIntProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return kotlin.UInt.m190boximpl(uIntProgression.getFirst());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @org.jetbrains.annotations.Nullable
    public static final kotlin.ULong firstOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongProgression uLongProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return kotlin.ULong.m214boximpl(uLongProgression.getFirst());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    public static final int last(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntProgression uIntProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (!uIntProgression.isEmpty()) {
            return uIntProgression.getLast();
        }
        throw new java.util.NoSuchElementException("Progression " + uIntProgression + " is empty.");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    public static final long last(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongProgression uLongProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (!uLongProgression.isEmpty()) {
            return uLongProgression.getLast();
        }
        throw new java.util.NoSuchElementException("Progression " + uLongProgression + " is empty.");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @org.jetbrains.annotations.Nullable
    public static final kotlin.UInt lastOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntProgression uIntProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        if (uIntProgression.isEmpty()) {
            return null;
        }
        return kotlin.UInt.m190boximpl(uIntProgression.getLast());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7)
    @org.jetbrains.annotations.Nullable
    public static final kotlin.ULong lastOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongProgression uLongProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        if (uLongProgression.isEmpty()) {
            return null;
        }
        return kotlin.ULong.m214boximpl(uLongProgression.getLast());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    public static final int random(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntRange uIntRange, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        try {
            return kotlin.random.URandomKt.nextUInt(random, uIntRange);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.util.NoSuchElementException(e.getMessage());
        }
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    public static final long random(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongRange uLongRange, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        try {
            return kotlin.random.URandomKt.nextULong(random, uLongRange);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.util.NoSuchElementException(e.getMessage());
        }
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class, kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.Nullable
    public static final kotlin.UInt randomOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntRange uIntRange, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uIntRange, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return kotlin.UInt.m190boximpl(kotlin.random.URandomKt.nextUInt(random, uIntRange));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class, kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.Nullable
    public static final kotlin.ULong randomOrNull(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongRange uLongRange, @org.jetbrains.annotations.NotNull kotlin.random.Random random) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uLongRange, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(random, "random");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return kotlin.ULong.m214boximpl(kotlin.random.URandomKt.nextULong(random, uLongRange));
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.UIntProgression reversed(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntProgression uIntProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        return kotlin.ranges.UIntProgression.INSTANCE.m571fromClosedRangeNkh28Cs(uIntProgression.getLast(), uIntProgression.getFirst(), -uIntProgression.getStep());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.ULongProgression reversed(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongProgression uLongProgression) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        return kotlin.ranges.ULongProgression.INSTANCE.m577fromClosedRange7ftBX0g(uLongProgression.getLast(), uLongProgression.getFirst(), -uLongProgression.getStep());
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.UIntProgression step(@org.jetbrains.annotations.NotNull kotlin.ranges.UIntProgression uIntProgression, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uIntProgression, "<this>");
        kotlin.ranges.RangesKt__RangesKt.checkStepIsPositive(i > 0, java.lang.Integer.valueOf(i));
        kotlin.ranges.UIntProgression.Companion companion = kotlin.ranges.UIntProgression.INSTANCE;
        int first = uIntProgression.getFirst();
        int last = uIntProgression.getLast();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m571fromClosedRangeNkh28Cs(first, last, i);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    public static final kotlin.ranges.ULongProgression step(@org.jetbrains.annotations.NotNull kotlin.ranges.ULongProgression uLongProgression, long j) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(uLongProgression, "<this>");
        kotlin.ranges.RangesKt__RangesKt.checkStepIsPositive(j > 0, java.lang.Long.valueOf(j));
        kotlin.ranges.ULongProgression.Companion companion = kotlin.ranges.ULongProgression.INSTANCE;
        long first = uLongProgression.getFirst();
        long last = uLongProgression.getLast();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m577fromClosedRange7ftBX0g(first, last, j);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    /* renamed from: until-5PvTz6A, reason: not valid java name */
    public static final kotlin.ranges.UIntRange m605until5PvTz6A(short s2, short s3) {
        return kotlin.jvm.internal.Intrinsics.compare(s3 & kotlin.UShort.MAX_VALUE, 0) <= 0 ? kotlin.ranges.UIntRange.INSTANCE.getEMPTY() : new kotlin.ranges.UIntRange(kotlin.UInt.m191constructorimpl(s2 & kotlin.UShort.MAX_VALUE), kotlin.UInt.m191constructorimpl(kotlin.UInt.m191constructorimpl(r3) - 1), null);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    /* renamed from: until-J1ME1BU, reason: not valid java name */
    public static final kotlin.ranges.UIntRange m606untilJ1ME1BU(int i, int i2) {
        return kotlin.UnsignedKt.uintCompare(i2, 0) <= 0 ? kotlin.ranges.UIntRange.INSTANCE.getEMPTY() : new kotlin.ranges.UIntRange(i, kotlin.UInt.m191constructorimpl(i2 - 1), null);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    /* renamed from: until-Kr8caGY, reason: not valid java name */
    public static final kotlin.ranges.UIntRange m607untilKr8caGY(byte b, byte b2) {
        return kotlin.jvm.internal.Intrinsics.compare(b2 & 255, 0) <= 0 ? kotlin.ranges.UIntRange.INSTANCE.getEMPTY() : new kotlin.ranges.UIntRange(kotlin.UInt.m191constructorimpl(b & 255), kotlin.UInt.m191constructorimpl(kotlin.UInt.m191constructorimpl(r3) - 1), null);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
    @org.jetbrains.annotations.NotNull
    /* renamed from: until-eb3DHEI, reason: not valid java name */
    public static final kotlin.ranges.ULongRange m608untileb3DHEI(long j, long j2) {
        return kotlin.UnsignedKt.ulongCompare(j2, 0L) <= 0 ? kotlin.ranges.ULongRange.INSTANCE.getEMPTY() : new kotlin.ranges.ULongRange(j, kotlin.ULong.m215constructorimpl(j2 - kotlin.ULong.m215constructorimpl(1 & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT)), null);
    }
}
