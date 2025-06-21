package kotlin;

@kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087@\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0014\b\u0001\u0012\u0006\u0010\u0014\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0012\u0010\u0013\u0088\u0001\u0014\u0092\u0001\u00020\u0006ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlin/UInt;", "", "", "toString-impl", "(I)Ljava/lang/String;", "toString", "", "hashCode-impl", "(I)I", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "other", "", "equals-impl", "(ILjava/lang/Object;)Z", "equals", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "getData$annotations", "()V", "data", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.jvm.JvmInline
@kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
/* loaded from: classes14.dex */
public final class UInt implements java.lang.Comparable<kotlin.UInt> {
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;

    /* renamed from: n, reason: from kotlin metadata */
    public final int data;

    @kotlin.PublishedApi
    public /* synthetic */ UInt(int i) {
        this.data = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ kotlin.UInt m190boximpl(int i) {
        return new kotlin.UInt(i);
    }

    @kotlin.PublishedApi
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m191constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m192equalsimpl(int i, java.lang.Object obj) {
        return (obj instanceof kotlin.UInt) && i == ((kotlin.UInt) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m193equalsimpl0(int i, int i2) {
        return i == i2;
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m194hashCodeimpl(int i) {
        return i;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static java.lang.String m195toStringimpl(int i) {
        return java.lang.String.valueOf(i & net.lingala.zip4j.util.InternalZipConstants.ZIP_64_LIMIT);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(kotlin.UInt uInt) {
        return kotlin.UnsignedKt.uintCompare(getData(), uInt.getData());
    }

    public boolean equals(java.lang.Object obj) {
        return m192equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m194hashCodeimpl(this.data);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return m195toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getData() {
        return this.data;
    }
}
