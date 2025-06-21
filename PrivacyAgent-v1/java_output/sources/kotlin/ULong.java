package kotlin;

@kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0087@\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0018B\u0014\b\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\u0088\u0001\u0015\u0092\u0001\u00020\u0010ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlin/ULong;", "", "", "toString-impl", "(J)Ljava/lang/String;", "toString", "", "hashCode-impl", "(J)I", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "other", "", "equals-impl", "(JLjava/lang/Object;)Z", "equals", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "J", "getData$annotations", "()V", "data", "constructor-impl", "(J)J", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
@kotlin.jvm.JvmInline
@kotlin.WasExperimental(markerClass = {kotlin.ExperimentalUnsignedTypes.class})
/* loaded from: classes14.dex */
public final class ULong implements java.lang.Comparable<kotlin.ULong> {
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;

    /* renamed from: n, reason: from kotlin metadata */
    public final long data;

    @kotlin.PublishedApi
    public /* synthetic */ ULong(long j) {
        this.data = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ kotlin.ULong m214boximpl(long j) {
        return new kotlin.ULong(j);
    }

    @kotlin.PublishedApi
    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m215constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m216equalsimpl(long j, java.lang.Object obj) {
        return (obj instanceof kotlin.ULong) && j == ((kotlin.ULong) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m217equalsimpl0(long j, long j2) {
        return j == j2;
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m218hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static java.lang.String m219toStringimpl(long j) {
        return kotlin.UnsignedKt.ulongToString(j);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(kotlin.ULong uLong) {
        return kotlin.UnsignedKt.ulongCompare(getData(), uLong.getData());
    }

    public boolean equals(java.lang.Object obj) {
        return m216equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m218hashCodeimpl(this.data);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return m219toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getData() {
        return this.data;
    }
}
