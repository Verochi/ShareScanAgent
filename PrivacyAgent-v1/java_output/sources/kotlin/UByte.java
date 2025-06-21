package kotlin;

@kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\t\b\u0087@\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0014\b\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\u0088\u0001\u0015\u0092\u0001\u00020\u0010ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlin/UByte;", "", "", "toString-impl", "(B)Ljava/lang/String;", "toString", "", "hashCode-impl", "(B)I", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "other", "", "equals-impl", "(BLjava/lang/Object;)Z", "equals", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "B", "getData$annotations", "()V", "data", "constructor-impl", "(B)B", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.jvm.JvmInline
@kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
/* loaded from: classes14.dex */
public final class UByte implements java.lang.Comparable<kotlin.UByte> {
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;

    /* renamed from: n, reason: from kotlin metadata */
    public final byte data;

    @kotlin.PublishedApi
    public /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ kotlin.UByte m166boximpl(byte b) {
        return new kotlin.UByte(b);
    }

    @kotlin.PublishedApi
    /* renamed from: constructor-impl, reason: not valid java name */
    public static byte m167constructorimpl(byte b) {
        return b;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m168equalsimpl(byte b, java.lang.Object obj) {
        return (obj instanceof kotlin.UByte) && b == ((kotlin.UByte) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m169equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m170hashCodeimpl(byte b) {
        return b;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static java.lang.String m171toStringimpl(byte b) {
        return java.lang.String.valueOf(b & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(kotlin.UByte uByte) {
        return kotlin.jvm.internal.Intrinsics.compare(getData() & 255, uByte.getData() & 255);
    }

    public boolean equals(java.lang.Object obj) {
        return m168equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m170hashCodeimpl(this.data);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return m171toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ byte getData() {
        return this.data;
    }
}
