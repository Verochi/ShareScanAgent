package kotlin.jvm.internal;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/reflect/KTypeProjection;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class TypeReference$asString$args$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function1<kotlin.reflect.KTypeProjection, java.lang.CharSequence> {
    final /* synthetic */ kotlin.jvm.internal.TypeReference this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeReference$asString$args$1(kotlin.jvm.internal.TypeReference typeReference) {
        super(1);
        this.this$0 = typeReference;
    }

    @Override // kotlin.jvm.functions.Function1
    @org.jetbrains.annotations.NotNull
    public final java.lang.CharSequence invoke(@org.jetbrains.annotations.NotNull kotlin.reflect.KTypeProjection it) {
        java.lang.String a;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(it, "it");
        a = this.this$0.a(it);
        return a;
    }
}
