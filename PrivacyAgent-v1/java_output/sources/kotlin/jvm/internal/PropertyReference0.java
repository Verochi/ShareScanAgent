package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public abstract class PropertyReference0 extends kotlin.jvm.internal.PropertyReference implements kotlin.reflect.KProperty0 {
    public PropertyReference0() {
    }

    @kotlin.SinceKotlin(version = "1.1")
    public PropertyReference0(java.lang.Object obj) {
        super(obj);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public PropertyReference0(java.lang.Object obj, java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.KCallable computeReflected() {
        return kotlin.jvm.internal.Reflection.property0(this);
    }

    @Override // kotlin.reflect.KProperty0
    @kotlin.SinceKotlin(version = "1.1")
    public java.lang.Object getDelegate() {
        return ((kotlin.reflect.KProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.reflect.KProperty
    public kotlin.reflect.KProperty0.Getter getGetter() {
        return ((kotlin.reflect.KProperty0) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public java.lang.Object invoke() {
        return get();
    }
}
