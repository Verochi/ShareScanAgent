package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public class PropertyReference2Impl extends kotlin.jvm.internal.PropertyReference2 {
    @kotlin.SinceKotlin(version = "1.4")
    public PropertyReference2Impl(java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(cls, str, str2, i);
    }

    public PropertyReference2Impl(kotlin.reflect.KDeclarationContainer kDeclarationContainer, java.lang.String str, java.lang.String str2) {
        super(((kotlin.jvm.internal.ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof kotlin.reflect.KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty2
    public java.lang.Object get(java.lang.Object obj, java.lang.Object obj2) {
        return getGetter().call(obj, obj2);
    }
}
