package kotlin.collections;

@kotlin.Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0015\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\r\u0012\u0006\u0010'\u001a\u00020\u0005¢\u0006\u0004\b(\u0010)B\u0011\b\u0016\u0012\u0006\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\b(\u0010*J\u0018\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\n\u001a\u00020\tJ\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\r\"\u0004\b\u0001\u0010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0012J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0005R\u001c\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001eR$\u0010&\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00058\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lkotlin/collections/RingBuffer;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "index", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "(I)Ljava/lang/Object;", "", "g", "", "iterator", "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "maxCapacity", "f", "element", "", "e", "(Ljava/lang/Object;)V", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "h", "[Ljava/lang/Object;", "buffer", "t", "I", "capacity", com.umeng.analytics.pro.bo.aN, "startIndex", "<set-?>", "v", "getSize", "()I", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "filledSize", "<init>", "([Ljava/lang/Object;I)V", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class RingBuffer<T> extends kotlin.collections.AbstractList<T> implements java.util.RandomAccess {

    /* renamed from: n, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.Object[] buffer;

    /* renamed from: t, reason: from kotlin metadata */
    public final int capacity;

    /* renamed from: u, reason: from kotlin metadata */
    public int startIndex;

    /* renamed from: v, reason: from kotlin metadata */
    public int size;

    public RingBuffer(int i) {
        this(new java.lang.Object[i], 0);
    }

    public RingBuffer(@org.jetbrains.annotations.NotNull java.lang.Object[] buffer, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.buffer = buffer;
        if (!(i >= 0)) {
            throw new java.lang.IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
        }
        if (i <= buffer.length) {
            this.capacity = buffer.length;
            this.size = i;
            return;
        }
        throw new java.lang.IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    public final void e(T element) {
        if (g()) {
            throw new java.lang.IllegalStateException("ring buffer is full");
        }
        this.buffer[(this.startIndex + size()) % this.capacity] = element;
        this.size = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    public final kotlin.collections.RingBuffer<T> f(int maxCapacity) {
        int coerceAtMost;
        java.lang.Object[] array;
        int i = this.capacity;
        coerceAtMost = kotlin.ranges.RangesKt___RangesKt.coerceAtMost(i + (i >> 1) + 1, maxCapacity);
        if (this.startIndex == 0) {
            array = java.util.Arrays.copyOf(this.buffer, coerceAtMost);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new java.lang.Object[coerceAtMost]);
        }
        return new kotlin.collections.RingBuffer<>(array, size());
    }

    public final boolean g() {
        return size() == this.capacity;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int index) {
        kotlin.collections.AbstractList.INSTANCE.checkElementIndex$kotlin_stdlib(index, size());
        return (T) this.buffer[(this.startIndex + index) % this.capacity];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.size;
    }

    public final void h(int n) {
        if (!(n >= 0)) {
            throw new java.lang.IllegalArgumentException(("n shouldn't be negative but it is " + n).toString());
        }
        if (!(n <= size())) {
            throw new java.lang.IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + n + ", size = " + size()).toString());
        }
        if (n > 0) {
            int i = this.startIndex;
            int i2 = (i + n) % this.capacity;
            if (i > i2) {
                kotlin.collections.ArraysKt___ArraysJvmKt.fill(this.buffer, (java.lang.Object) null, i, this.capacity);
                kotlin.collections.ArraysKt___ArraysJvmKt.fill(this.buffer, (java.lang.Object) null, 0, i2);
            } else {
                kotlin.collections.ArraysKt___ArraysJvmKt.fill(this.buffer, (java.lang.Object) null, i, i2);
            }
            this.startIndex = i2;
            this.size = size() - n;
        }
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @org.jetbrains.annotations.NotNull
    public java.util.Iterator<T> iterator() {
        return new kotlin.collections.RingBuffer$iterator$1(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @org.jetbrains.annotations.NotNull
    public java.lang.Object[] toArray() {
        return toArray(new java.lang.Object[size()]);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @org.jetbrains.annotations.NotNull
    public <T> T[] toArray(@org.jetbrains.annotations.NotNull T[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        if (array.length < size()) {
            array = (T[]) java.util.Arrays.copyOf(array, size());
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(array, "copyOf(this, newSize)");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.startIndex; i2 < size && i3 < this.capacity; i3++) {
            array[i2] = this.buffer[i3];
            i2++;
        }
        while (i2 < size) {
            array[i2] = this.buffer[i];
            i2++;
            i++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        kotlin.jvm.internal.Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.RingBuffer.toArray>");
        return array;
    }
}
