package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public class MutablePropertyReference1Impl extends kotlin.jvm.internal.MutablePropertyReference1 {
    @kotlin.SinceKotlin(version = "1.4")
    public MutablePropertyReference1Impl(java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(kotlin.jvm.internal.CallableReference.NO_RECEIVER, cls, str, str2, i);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public MutablePropertyReference1Impl(java.lang.Object obj, java.lang.Class cls, java.lang.String str, java.lang.String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    public MutablePropertyReference1Impl(kotlin.reflect.KDeclarationContainer kDeclarationContainer, java.lang.String str, java.lang.String str2) {
        super(kotlin.jvm.internal.CallableReference.NO_RECEIVER, ((kotlin.jvm.internal.ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof kotlin.reflect.KClass) ? 1 : 0);
    }

    @Override // kotlin.reflect.KProperty1
    public java.lang.Object get(java.lang.Object obj) {
        return getGetter().call(obj);
    }

    @Override // kotlin.reflect.KMutableProperty1
    public void set(java.lang.Object obj, java.lang.Object obj2) {
        getSetter().call(obj, obj2);
    }
}
