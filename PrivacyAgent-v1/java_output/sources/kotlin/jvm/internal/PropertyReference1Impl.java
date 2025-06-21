package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public class PropertyReference1Impl extends kotlin.jvm.internal.PropertyReference1 {
    @kotlin.SinceKotlin(version = "1.4")
    public PropertyReference1Impl(java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(kotlin.jvm.internal.CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public PropertyReference1Impl(java.lang.Object obj, java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    public PropertyReference1Impl(kotlin.reflect.KDeclarationContainer kDeclarationContainer, java.lang.String str, java.lang.String str2) {
        super(kotlin.jvm.internal.CallableReference.NO_RECEIVER, ((kotlin.jvm.internal.ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof kotlin.reflect.KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty1
    public java.lang.Object get(java.lang.Object obj) {
        return getGetter().call(obj);
    }
}
