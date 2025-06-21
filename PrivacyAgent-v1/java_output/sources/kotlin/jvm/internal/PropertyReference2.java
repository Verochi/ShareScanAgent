package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public abstract class PropertyReference2 extends kotlin.jvm.internal.PropertyReference implements kotlin.reflect.KProperty2 {
    public PropertyReference2() {
    }

    @kotlin.SinceKotlin(version = "1.4")
    public PropertyReference2(java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(kotlin.jvm.internal.CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.KCallable computeReflected() {
        return kotlin.jvm.internal.Reflection.property2(this);
    }

    @Override // kotlin.reflect.KProperty2
    @kotlin.SinceKotlin(version = "1.1")
    public java.lang.Object getDelegate(java.lang.Object obj, java.lang.Object obj2) {
        return ((kotlin.reflect.KProperty2) getReflected()).getDelegate(obj, obj2);
    }

    @Override // kotlin.reflect.KProperty
    public kotlin.reflect.KProperty2.Getter getGetter() {
        return ((kotlin.reflect.KProperty2) getReflected()).getGetter();
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public java.lang.Object mo5invoke(java.lang.Object obj, java.lang.Object obj2) {
        return get(obj, obj2);
    }
}
