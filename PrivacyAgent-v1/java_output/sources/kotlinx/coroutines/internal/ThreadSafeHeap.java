package kotlinx.coroutines.internal;

@kotlinx.coroutines.InternalCoroutinesApi
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\b\u0017\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0004j\u0002`\u0005B\u0007¢\u0006\u0004\b1\u0010\bJ\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u000b\u0010\nJ&\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\r0\fH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\u0013J.\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00028\u00002\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\r0\fH\u0086\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u0017\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u001e\u0010\u0013J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001aH\u0082\u0010¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001aH\u0082\u0010¢\u0006\u0004\b\"\u0010!J\u0017\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000#H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001aH\u0002¢\u0006\u0004\b'\u0010(R \u0010$\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010)R$\u0010.\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001a8F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010!R\u0011\u0010/\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "", "clear", "()V", "peek", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "Lkotlin/Function1;", "", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "node", "addLast", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "firstImpl", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "addImpl", "i", "d", "(I)V", "c", "", "a", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "j", "e", "(II)V", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "value", "getSize", "()I", "b", com.anythink.core.api.ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE, "isEmpty", "()Z", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public class ThreadSafeHeap<T extends kotlinx.coroutines.internal.ThreadSafeHeapNode & java.lang.Comparable<? super T>> {

    @org.jetbrains.annotations.NotNull
    private volatile /* synthetic */ int _size = 0;

    @org.jetbrains.annotations.Nullable
    public T[] a;

    public final T[] a() {
        T[] tArr = this.a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new kotlinx.coroutines.internal.ThreadSafeHeapNode[4];
            this.a = tArr2;
            return tArr2;
        }
        if (get_size() < tArr.length) {
            return tArr;
        }
        java.lang.Object[] copyOf = java.util.Arrays.copyOf(tArr, get_size() * 2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((kotlinx.coroutines.internal.ThreadSafeHeapNode[]) copyOf);
        this.a = tArr3;
        return tArr3;
    }

    @kotlin.PublishedApi
    public final void addImpl(@org.jetbrains.annotations.NotNull T node) {
        node.setHeap(this);
        T[] a = a();
        int i = get_size();
        b(i + 1);
        a[i] = node;
        node.setIndex(i);
        d(i);
    }

    public final void addLast(@org.jetbrains.annotations.NotNull T node) {
        synchronized (this) {
            addImpl(node);
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
    }

    public final boolean addLastIf(@org.jetbrains.annotations.NotNull T node, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> cond) {
        boolean z;
        synchronized (this) {
            try {
                if (cond.invoke(firstImpl()).booleanValue()) {
                    addImpl(node);
                    z = true;
                } else {
                    z = false;
                }
                kotlin.jvm.internal.InlineMarker.finallyStart(1);
            } catch (java.lang.Throwable th) {
                kotlin.jvm.internal.InlineMarker.finallyStart(1);
                kotlin.jvm.internal.InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
        return z;
    }

    public final void b(int i) {
        this._size = i;
    }

    public final void c(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= get_size()) {
                return;
            }
            T[] tArr = this.a;
            kotlin.jvm.internal.Intrinsics.checkNotNull(tArr);
            int i3 = i2 + 1;
            if (i3 < get_size()) {
                T t = tArr[i3];
                kotlin.jvm.internal.Intrinsics.checkNotNull(t);
                T t2 = tArr[i2];
                kotlin.jvm.internal.Intrinsics.checkNotNull(t2);
                if (((java.lang.Comparable) t).compareTo(t2) < 0) {
                    i2 = i3;
                }
            }
            T t3 = tArr[i];
            kotlin.jvm.internal.Intrinsics.checkNotNull(t3);
            T t4 = tArr[i2];
            kotlin.jvm.internal.Intrinsics.checkNotNull(t4);
            if (((java.lang.Comparable) t3).compareTo(t4) <= 0) {
                return;
            }
            e(i, i2);
            i = i2;
        }
    }

    public final void clear() {
        synchronized (this) {
            T[] tArr = this.a;
            if (tArr != null) {
                kotlin.collections.ArraysKt___ArraysJvmKt.fill$default(tArr, (java.lang.Object) null, 0, 0, 6, (java.lang.Object) null);
            }
            this._size = 0;
            kotlin.Unit unit = kotlin.Unit.INSTANCE;
        }
    }

    public final void d(int i) {
        while (i > 0) {
            T[] tArr = this.a;
            kotlin.jvm.internal.Intrinsics.checkNotNull(tArr);
            int i2 = (i - 1) / 2;
            T t = tArr[i2];
            kotlin.jvm.internal.Intrinsics.checkNotNull(t);
            T t2 = tArr[i];
            kotlin.jvm.internal.Intrinsics.checkNotNull(t2);
            if (((java.lang.Comparable) t).compareTo(t2) <= 0) {
                return;
            }
            e(i, i2);
            i = i2;
        }
    }

    public final void e(int i, int j) {
        T[] tArr = this.a;
        kotlin.jvm.internal.Intrinsics.checkNotNull(tArr);
        T t = tArr[j];
        kotlin.jvm.internal.Intrinsics.checkNotNull(t);
        T t2 = tArr[i];
        kotlin.jvm.internal.Intrinsics.checkNotNull(t2);
        tArr[i] = t;
        tArr[j] = t2;
        t.setIndex(i);
        t2.setIndex(j);
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.Nullable
    public final T firstImpl() {
        T[] tArr = this.a;
        if (tArr == null) {
            return null;
        }
        return tArr[0];
    }

    /* renamed from: getSize, reason: from getter */
    public final int get_size() {
        return this._size;
    }

    public final boolean isEmpty() {
        return get_size() == 0;
    }

    @org.jetbrains.annotations.Nullable
    public final T peek() {
        T firstImpl;
        synchronized (this) {
            firstImpl = firstImpl();
        }
        return firstImpl;
    }

    public final boolean remove(@org.jetbrains.annotations.NotNull T node) {
        boolean z;
        synchronized (this) {
            if (node.getHeap() == null) {
                z = false;
            } else {
                removeAtImpl(node.getIndex());
                z = true;
            }
        }
        return z;
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public final T removeAtImpl(int index) {
        T[] tArr = this.a;
        kotlin.jvm.internal.Intrinsics.checkNotNull(tArr);
        b(get_size() - 1);
        if (index < get_size()) {
            e(index, get_size());
            int i = (index - 1) / 2;
            if (index > 0) {
                T t = tArr[index];
                kotlin.jvm.internal.Intrinsics.checkNotNull(t);
                T t2 = tArr[i];
                kotlin.jvm.internal.Intrinsics.checkNotNull(t2);
                if (((java.lang.Comparable) t).compareTo(t2) < 0) {
                    e(index, i);
                    d(i);
                }
            }
            c(index);
        }
        T t3 = tArr[get_size()];
        kotlin.jvm.internal.Intrinsics.checkNotNull(t3);
        t3.setHeap(null);
        t3.setIndex(-1);
        tArr[get_size()] = null;
        return t3;
    }

    @org.jetbrains.annotations.Nullable
    public final T removeFirstIf(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> predicate) {
        synchronized (this) {
            try {
                T firstImpl = firstImpl();
                if (firstImpl == null) {
                    kotlin.jvm.internal.InlineMarker.finallyStart(2);
                    kotlin.jvm.internal.InlineMarker.finallyEnd(2);
                    return null;
                }
                T removeAtImpl = predicate.invoke(firstImpl).booleanValue() ? removeAtImpl(0) : null;
                kotlin.jvm.internal.InlineMarker.finallyStart(1);
                kotlin.jvm.internal.InlineMarker.finallyEnd(1);
                return removeAtImpl;
            } catch (java.lang.Throwable th) {
                kotlin.jvm.internal.InlineMarker.finallyStart(1);
                kotlin.jvm.internal.InlineMarker.finallyEnd(1);
                throw th;
            }
        }
    }

    @org.jetbrains.annotations.Nullable
    public final T removeFirstOrNull() {
        T removeAtImpl;
        synchronized (this) {
            removeAtImpl = get_size() > 0 ? removeAtImpl(0) : null;
        }
        return removeAtImpl;
    }
}
