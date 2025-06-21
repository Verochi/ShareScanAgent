package kotlin.properties;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\t\u0010\nJ+\u0010\f\u001a\u00020\u000b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\f\u0010\rJ&\u0010\u000f\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J.\u0010\u0012\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0011\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0011\u001a\u00028\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkotlin/properties/ObservableProperty;", androidx.exifinterface.media.ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/properties/ReadWriteProperty;", "", "Lkotlin/reflect/KProperty;", org.apache.tools.ant.taskdefs.condition.ParserSupports.PROPERTY, "oldValue", "newValue", "", "beforeChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "", "afterChange", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "thisRef", "getValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "value", "setValue", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "a", "Ljava/lang/Object;", "initialValue", "<init>", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class ObservableProperty<V> implements kotlin.properties.ReadWriteProperty<java.lang.Object, V> {

    /* renamed from: a, reason: from kotlin metadata */
    public V value;

    public ObservableProperty(V v) {
        this.value = v;
    }

    public void afterChange(@org.jetbrains.annotations.NotNull kotlin.reflect.KProperty<?> property, V oldValue, V newValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
    }

    public boolean beforeChange(@org.jetbrains.annotations.NotNull kotlin.reflect.KProperty<?> property, V oldValue, V newValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        return true;
    }

    @Override // kotlin.properties.ReadWriteProperty, kotlin.properties.ReadOnlyProperty
    public V getValue(@org.jetbrains.annotations.Nullable java.lang.Object thisRef, @org.jetbrains.annotations.NotNull kotlin.reflect.KProperty<?> property) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        return this.value;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(@org.jetbrains.annotations.Nullable java.lang.Object thisRef, @org.jetbrains.annotations.NotNull kotlin.reflect.KProperty<?> property, V value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        V v = this.value;
        if (beforeChange(property, v, value)) {
            this.value = value;
            afterChange(property, v, value);
        }
    }
}
