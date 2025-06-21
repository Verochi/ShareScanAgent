package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public abstract class PropertyReference1 extends kotlin.jvm.internal.PropertyReference implements kotlin.reflect.KProperty1 {
    public PropertyReference1() {
    }

    @kotlin.SinceKotlin(version = "1.1")
    public PropertyReference1(java.lang.Object obj) {
        super(obj);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public PropertyReference1(java.lang.Object obj, java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.KCallable computeReflected() {
        return kotlin.jvm.internal.Reflection.property1(this);
    }

    @Override // kotlin.reflect.KProperty1
    @kotlin.SinceKotlin(version = "1.1")
    public java.lang.Object getDelegate(java.lang.Object obj) {
        return ((kotlin.reflect.KProperty1) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.reflect.KProperty
    public kotlin.reflect.KProperty1.Getter getGetter() {
        return ((kotlin.reflect.KProperty1) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public java.lang.Object invoke(java.lang.Object obj) {
        return get(obj);
    }
}
