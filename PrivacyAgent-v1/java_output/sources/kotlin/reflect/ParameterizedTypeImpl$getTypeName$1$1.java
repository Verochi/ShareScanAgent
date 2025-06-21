package kotlin.reflect;

@kotlin.Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class ParameterizedTypeImpl$getTypeName$1$1 extends kotlin.jvm.internal.FunctionReferenceImpl implements kotlin.jvm.functions.Function1<java.lang.reflect.Type, java.lang.String> {
    public static final kotlin.reflect.ParameterizedTypeImpl$getTypeName$1$1 INSTANCE = new kotlin.reflect.ParameterizedTypeImpl$getTypeName$1$1();

    public ParameterizedTypeImpl$getTypeName$1$1() {
        super(1, kotlin.reflect.TypesJVMKt.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.NotNull
    public final java.lang.String invoke(@org.jetbrains.annotations.NotNull java.lang.reflect.Type p0) {
        java.lang.String e;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p0, "p0");
        e = kotlin.reflect.TypesJVMKt.e(p0);
        return e;
    }
}
