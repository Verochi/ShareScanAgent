package kotlinx.coroutines.channels;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087@\u0018\u0000 &*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003'&(B\u0016\b\u0001\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0013\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0018\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001b\u0010\u001cR\u0011\u0010 \u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\"\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0011\u0010$\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b#\u0010\u001f\u0088\u0001\u001d\u0092\u0001\u0004\u0018\u00010\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "getOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrNull", "getOrThrow-impl", "getOrThrow", "", "exceptionOrNull-impl", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "exceptionOrNull", "", "toString-impl", "(Ljava/lang/Object;)Ljava/lang/String;", "toString", "", "hashCode-impl", "(Ljava/lang/Object;)I", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "", "equals-impl", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "equals", "a", "Ljava/lang/Object;", "getHolder$annotations", "()V", "holder", "isSuccess-impl", "(Ljava/lang/Object;)Z", "isSuccess", "isFailure-impl", "isFailure", "isClosed-impl", "isClosed", "constructor-impl", "Companion", "Closed", "Failed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
@kotlin.jvm.JvmInline
/* loaded from: classes16.dex */
public final class ChannelResult<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.channels.ChannelResult.Companion INSTANCE = new kotlinx.coroutines.channels.ChannelResult.Companion(null);

    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.channels.ChannelResult.Failed b = new kotlinx.coroutines.channels.ChannelResult.Failed();

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object holder;

    @kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Closed;", "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "cause", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Closed extends kotlinx.coroutines.channels.ChannelResult.Failed {

        @kotlin.jvm.JvmField
        @org.jetbrains.annotations.Nullable
        public final java.lang.Throwable cause;

        public Closed(@org.jetbrains.annotations.Nullable java.lang.Throwable th) {
            this.cause = th;
        }

        public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
            return (other instanceof kotlinx.coroutines.channels.ChannelResult.Closed) && kotlin.jvm.internal.Intrinsics.areEqual(this.cause, ((kotlinx.coroutines.channels.ChannelResult.Closed) other).cause);
        }

        public int hashCode() {
            java.lang.Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    @kotlinx.coroutines.InternalCoroutinesApi
    @kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\n\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u0007H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\r\u0010\u000eJ,\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0001\u0010\u00072\u0006\u0010\u0010\u001a\u0002H\u0007H\u0007ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Companion;", "", "()V", com.alipay.sdk.m.u.h.j, "Lkotlinx/coroutines/channels/ChannelResult$Failed;", "closed", "Lkotlinx/coroutines/channels/ChannelResult;", androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST, "cause", "", "closed-JP2dKIU", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "failure", "failure-PtdJZtk", "()Ljava/lang/Object;", "success", "value", "success-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @kotlinx.coroutines.InternalCoroutinesApi
        @org.jetbrains.annotations.NotNull
        /* renamed from: closed-JP2dKIU, reason: not valid java name */
        public final <E> java.lang.Object m784closedJP2dKIU(@org.jetbrains.annotations.Nullable java.lang.Throwable cause) {
            return kotlinx.coroutines.channels.ChannelResult.m772constructorimpl(new kotlinx.coroutines.channels.ChannelResult.Closed(cause));
        }

        @kotlinx.coroutines.InternalCoroutinesApi
        @org.jetbrains.annotations.NotNull
        /* renamed from: failure-PtdJZtk, reason: not valid java name */
        public final <E> java.lang.Object m785failurePtdJZtk() {
            return kotlinx.coroutines.channels.ChannelResult.m772constructorimpl(kotlinx.coroutines.channels.ChannelResult.b);
        }

        @kotlinx.coroutines.InternalCoroutinesApi
        @org.jetbrains.annotations.NotNull
        /* renamed from: success-JP2dKIU, reason: not valid java name */
        public final <E> java.lang.Object m786successJP2dKIU(E value) {
            return kotlinx.coroutines.channels.ChannelResult.m772constructorimpl(value);
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/ChannelResult$Failed;", "", "()V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class Failed {
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return "Failed";
        }
    }

    @kotlin.PublishedApi
    public /* synthetic */ ChannelResult(java.lang.Object obj) {
        this.holder = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ kotlinx.coroutines.channels.ChannelResult m771boximpl(java.lang.Object obj) {
        return new kotlinx.coroutines.channels.ChannelResult(obj);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> java.lang.Object m772constructorimpl(@org.jetbrains.annotations.Nullable java.lang.Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m773equalsimpl(java.lang.Object obj, java.lang.Object obj2) {
        return (obj2 instanceof kotlinx.coroutines.channels.ChannelResult) && kotlin.jvm.internal.Intrinsics.areEqual(obj, ((kotlinx.coroutines.channels.ChannelResult) obj2).getHolder());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m774equalsimpl0(java.lang.Object obj, java.lang.Object obj2) {
        return kotlin.jvm.internal.Intrinsics.areEqual(obj, obj2);
    }

    @org.jetbrains.annotations.Nullable
    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final java.lang.Throwable m775exceptionOrNullimpl(java.lang.Object obj) {
        kotlinx.coroutines.channels.ChannelResult.Closed closed = obj instanceof kotlinx.coroutines.channels.ChannelResult.Closed ? (kotlinx.coroutines.channels.ChannelResult.Closed) obj : null;
        if (closed == null) {
            return null;
        }
        return closed.cause;
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getHolder$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* renamed from: getOrNull-impl, reason: not valid java name */
    public static final T m776getOrNullimpl(java.lang.Object obj) {
        if (obj instanceof kotlinx.coroutines.channels.ChannelResult.Failed) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrThrow-impl, reason: not valid java name */
    public static final T m777getOrThrowimpl(java.lang.Object obj) {
        java.lang.Throwable th;
        if (!(obj instanceof kotlinx.coroutines.channels.ChannelResult.Failed)) {
            return obj;
        }
        if (!(obj instanceof kotlinx.coroutines.channels.ChannelResult.Closed) || (th = ((kotlinx.coroutines.channels.ChannelResult.Closed) obj).cause) == null) {
            throw new java.lang.IllegalStateException(kotlin.jvm.internal.Intrinsics.stringPlus("Trying to call 'getOrThrow' on a failed channel result: ", obj).toString());
        }
        throw th;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m778hashCodeimpl(java.lang.Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isClosed-impl, reason: not valid java name */
    public static final boolean m779isClosedimpl(java.lang.Object obj) {
        return obj instanceof kotlinx.coroutines.channels.ChannelResult.Closed;
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m780isFailureimpl(java.lang.Object obj) {
        return obj instanceof kotlinx.coroutines.channels.ChannelResult.Failed;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m781isSuccessimpl(java.lang.Object obj) {
        return !(obj instanceof kotlinx.coroutines.channels.ChannelResult.Failed);
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static java.lang.String m782toStringimpl(java.lang.Object obj) {
        if (obj instanceof kotlinx.coroutines.channels.ChannelResult.Closed) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(java.lang.Object obj) {
        return m773equalsimpl(getHolder(), obj);
    }

    public int hashCode() {
        return m778hashCodeimpl(getHolder());
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return m782toStringimpl(getHolder());
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ java.lang.Object getHolder() {
        return this.holder;
    }
}
