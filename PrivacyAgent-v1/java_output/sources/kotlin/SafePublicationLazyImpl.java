package kotlin;

@kotlin.Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0013*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lkotlin/SafePublicationLazyImpl;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
final class SafePublicationLazyImpl<T> implements kotlin.Lazy<T>, java.io.Serializable {
    private static final java.util.concurrent.atomic.AtomicReferenceFieldUpdater<kotlin.SafePublicationLazyImpl<?>, java.lang.Object> valueUpdater = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(kotlin.SafePublicationLazyImpl.class, java.lang.Object.class, "_value");

    @org.jetbrains.annotations.Nullable
    private volatile java.lang.Object _value;

    @org.jetbrains.annotations.NotNull
    private final java.lang.Object final;

    @org.jetbrains.annotations.Nullable
    private volatile kotlin.jvm.functions.Function0<? extends T> initializer;

    public SafePublicationLazyImpl(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> initializer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
        kotlin.UNINITIALIZED_VALUE uninitialized_value = kotlin.UNINITIALIZED_VALUE.INSTANCE;
        this._value = uninitialized_value;
        this.final = uninitialized_value;
    }

    private final java.lang.Object writeReplace() {
        return new kotlin.InitializedLazyImpl(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t = (T) this._value;
        kotlin.UNINITIALIZED_VALUE uninitialized_value = kotlin.UNINITIALIZED_VALUE.INSTANCE;
        if (t != uninitialized_value) {
            return t;
        }
        kotlin.jvm.functions.Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T invoke = function0.invoke();
            if (defpackage.q1.a(valueUpdater, this, uninitialized_value, invoke)) {
                this.initializer = null;
                return invoke;
            }
        }
        return (T) this._value;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != kotlin.UNINITIALIZED_VALUE.INSTANCE;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return isInitialized() ? java.lang.String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
