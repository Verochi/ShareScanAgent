package kotlin.jvm.internal;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u0011\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u0015J\u0013\u0010\u0004\u001a\u00020\u0003*\u00028\u0000H$¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0003H\u0004J\u001f\u0010\r\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0010\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00178\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "getSize", "(Ljava/lang/Object;)I", "spreadArgument", "", "addSpread", "(Ljava/lang/Object;)V", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "values", "result", "toArray", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "a", "I", "b", "getPosition", "()I", "setPosition", "(I)V", com.alibaba.sdk.android.oss.common.RequestParameters.POSITION, "", "c", "[Ljava/lang/Object;", "getSpreads$annotations", "()V", "spreads", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class PrimitiveSpreadBuilder<T> {

    /* renamed from: a, reason: from kotlin metadata */
    public final int size;

    /* renamed from: b, reason: from kotlin metadata */
    public int position;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final T[] spreads;

    public PrimitiveSpreadBuilder(int i) {
        this.size = i;
        this.spreads = (T[]) new java.lang.Object[i];
    }

    public final void addSpread(@org.jetbrains.annotations.NotNull T spreadArgument) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(spreadArgument, "spreadArgument");
        T[] tArr = this.spreads;
        int i = this.position;
        this.position = i + 1;
        tArr[i] = spreadArgument;
    }

    public final int getPosition() {
        return this.position;
    }

    public abstract int getSize(@org.jetbrains.annotations.NotNull T t);

    public final void setPosition(int i) {
        this.position = i;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    public final int size() {
        int i = 0;
        ?? it = new kotlin.ranges.IntRange(0, this.size - 1).iterator();
        while (it.hasNext()) {
            T t = this.spreads[it.nextInt()];
            i += t != null ? getSize(t) : 1;
        }
        return i;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @org.jetbrains.annotations.NotNull
    public final T toArray(@org.jetbrains.annotations.NotNull T values, @org.jetbrains.annotations.NotNull T result) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(values, "values");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(result, "result");
        ?? it = new kotlin.ranges.IntRange(0, this.size - 1).iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            T t = this.spreads[nextInt];
            if (t != null) {
                if (i < nextInt) {
                    int i3 = nextInt - i;
                    java.lang.System.arraycopy(values, i, result, i2, i3);
                    i2 += i3;
                }
                int size = getSize(t);
                java.lang.System.arraycopy(t, 0, result, i2, size);
                i2 += size;
                i = nextInt + 1;
            }
        }
        int i4 = this.size;
        if (i < i4) {
            java.lang.System.arraycopy(values, i, result, i2, i4 - i);
        }
        return result;
    }
}
