package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public class PropertyReference0Impl extends kotlin.jvm.internal.PropertyReference0 {
    @kotlin.SinceKotlin(version = "1.4")
    public PropertyReference0Impl(java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(kotlin.jvm.internal.CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public PropertyReference0Impl(java.lang.Object obj, java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    public PropertyReference0Impl(kotlin.reflect.KDeclarationContainer kDeclarationContainer, java.lang.String str, java.lang.String str2) {
        super(kotlin.jvm.internal.CallableReference.NO_RECEIVER, ((kotlin.jvm.internal.ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof kotlin.reflect.KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty0
    public java.lang.Object get() {
        return getGetter().call(new java.lang.Object[0]);
    }
}
