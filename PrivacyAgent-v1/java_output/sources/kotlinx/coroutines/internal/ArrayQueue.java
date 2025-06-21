package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\t\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\u0004H\u0002R\u001e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0015\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "element", "", "addLast", "(Ljava/lang/Object;)V", "removeFirstOrNull", "()Ljava/lang/Object;", "clear", "a", "", "[Ljava/lang/Object;", "elements", "", "b", "I", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_HEAD, "c", "tail", "", "isEmpty", "()Z", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public class ArrayQueue<T> {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.lang.Object[] elements = new java.lang.Object[16];

    /* renamed from: b, reason: from kotlin metadata */
    public int head;

    /* renamed from: c, reason: from kotlin metadata */
    public int tail;

    public final void a() {
        java.lang.Object[] objArr = this.elements;
        int length = objArr.length;
        java.lang.Object[] objArr2 = new java.lang.Object[length << 1];
        kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, this.head, 0, 10, (java.lang.Object) null);
        java.lang.Object[] objArr3 = this.elements;
        int length2 = objArr3.length;
        int i = this.head;
        kotlin.collections.ArraysKt___ArraysJvmKt.copyInto$default(objArr3, objArr2, length2 - i, 0, i, 4, (java.lang.Object) null);
        this.elements = objArr2;
        this.head = 0;
        this.tail = length;
    }

    public final void addLast(@org.jetbrains.annotations.NotNull T element) {
        java.lang.Object[] objArr = this.elements;
        int i = this.tail;
        objArr[i] = element;
        int length = (objArr.length - 1) & (i + 1);
        this.tail = length;
        if (length == this.head) {
            a();
        }
    }

    public final void clear() {
        this.head = 0;
        this.tail = 0;
        this.elements = new java.lang.Object[this.elements.length];
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    @org.jetbrains.annotations.Nullable
    public final T removeFirstOrNull() {
        int i = this.head;
        if (i == this.tail) {
            return null;
        }
        java.lang.Object[] objArr = this.elements;
        T t = (T) objArr[i];
        objArr[i] = null;
        this.head = (i + 1) & (objArr.length - 1);
        if (t != null) {
            return t;
        }
        throw new java.lang.NullPointerException("null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
    }
}
