package kotlin.properties;

/* JADX INFO: Add missing generic type declarations: [T] */
@kotlin.Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", org.apache.tools.ant.taskdefs.condition.ParserSupports.PROPERTY, "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes14.dex */
public final class Delegates$observable$1<T> extends kotlin.properties.ObservableProperty<T> {
    public final /* synthetic */ kotlin.jvm.functions.Function3<kotlin.reflect.KProperty<?>, T, T, kotlin.Unit> b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Delegates$observable$1(T t, kotlin.jvm.functions.Function3<? super kotlin.reflect.KProperty<?>, ? super T, ? super T, kotlin.Unit> function3) {
        super(t);
        this.b = function3;
    }

    @Override // kotlin.properties.ObservableProperty
    public void afterChange(@org.jetbrains.annotations.NotNull kotlin.reflect.KProperty<?> property, T oldValue, T newValue) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(property, "property");
        this.b.invoke(property, oldValue, newValue);
    }
}
