package kotlin.jvm.internal;

/* loaded from: classes14.dex */
public class FunctionReferenceImpl extends kotlin.jvm.internal.FunctionReference {
    @kotlin.SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i, java.lang.Class cls, java.lang.String str, java.lang.String str2, int i2) {
        super(i, kotlin.jvm.internal.CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    @kotlin.SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i, java.lang.Object obj, java.lang.Class cls, java.lang.String str, java.lang.String str2, int i2) {
        super(i, obj, cls, str, str2, i2);
    }

    public FunctionReferenceImpl(int i, kotlin.reflect.KDeclarationContainer kDeclarationContainer, java.lang.String str, java.lang.String str2) {
        super(i, kotlin.jvm.internal.CallableReference.NO_RECEIVER, ((kotlin.jvm.internal.ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof kotlin.reflect.KClass) ? 1 : 0);
    }
}
