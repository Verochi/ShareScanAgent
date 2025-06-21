package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {276, 284, com.anythink.expressad.foundation.g.a.aW}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
/* loaded from: classes14.dex */
public final class Regex$splitToSequence$1 extends kotlin.coroutines.jvm.internal.RestrictedSuspendLambda implements kotlin.jvm.functions.Function2<kotlin.sequences.SequenceScope<? super java.lang.String>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    final /* synthetic */ java.lang.CharSequence $input;
    final /* synthetic */ int $limit;
    int I$0;
    private /* synthetic */ java.lang.Object L$0;
    java.lang.Object L$1;
    int label;
    final /* synthetic */ kotlin.text.Regex this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$splitToSequence$1(kotlin.text.Regex regex, java.lang.CharSequence charSequence, int i, kotlin.coroutines.Continuation<? super kotlin.text.Regex$splitToSequence$1> continuation) {
        super(2, continuation);
        this.this$0 = regex;
        this.$input = charSequence;
        this.$limit = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        kotlin.text.Regex$splitToSequence$1 regex$splitToSequence$1 = new kotlin.text.Regex$splitToSequence$1(this.this$0, this.$input, this.$limit, continuation);
        regex$splitToSequence$1.L$0 = obj;
        return regex$splitToSequence$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super java.lang.String> sequenceScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((kotlin.text.Regex$splitToSequence$1) create(sequenceScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009e A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0070 -> B:13:0x0073). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        java.util.regex.Pattern pattern;
        kotlin.text.Regex$splitToSequence$1 regex$splitToSequence$1;
        kotlin.sequences.SequenceScope sequenceScope;
        java.util.regex.Matcher matcher;
        int i;
        java.lang.String obj2;
        java.lang.String obj3;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            kotlin.sequences.SequenceScope sequenceScope2 = (kotlin.sequences.SequenceScope) this.L$0;
            pattern = this.this$0.nativePattern;
            java.util.regex.Matcher matcher2 = pattern.matcher(this.$input);
            if (this.$limit != 1 && matcher2.find()) {
                int i3 = 0;
                regex$splitToSequence$1 = this;
                sequenceScope = sequenceScope2;
                matcher = matcher2;
                i = 0;
                obj2 = regex$splitToSequence$1.$input.subSequence(i3, matcher.start()).toString();
                regex$splitToSequence$1.L$0 = sequenceScope;
                regex$splitToSequence$1.L$1 = matcher;
                regex$splitToSequence$1.I$0 = i;
                regex$splitToSequence$1.label = 2;
                if (sequenceScope.yield(obj2, regex$splitToSequence$1) == coroutine_suspended) {
                }
                i3 = matcher.end();
                i++;
                if (i != regex$splitToSequence$1.$limit - 1) {
                }
                java.lang.CharSequence charSequence = regex$splitToSequence$1.$input;
                obj3 = charSequence.subSequence(i3, charSequence.length()).toString();
                regex$splitToSequence$1.L$0 = null;
                regex$splitToSequence$1.L$1 = null;
                regex$splitToSequence$1.label = 3;
                if (sequenceScope.yield(obj3, regex$splitToSequence$1) == coroutine_suspended) {
                }
                return kotlin.Unit.INSTANCE;
            }
            java.lang.String obj4 = this.$input.toString();
            this.label = 1;
            if (sequenceScope2.yield(obj4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.ResultKt.throwOnFailure(obj);
                    return kotlin.Unit.INSTANCE;
                }
                i = this.I$0;
                java.util.regex.Matcher matcher3 = (java.util.regex.Matcher) this.L$1;
                sequenceScope = (kotlin.sequences.SequenceScope) this.L$0;
                kotlin.ResultKt.throwOnFailure(obj);
                regex$splitToSequence$1 = this;
                matcher = matcher3;
                i3 = matcher.end();
                i++;
                if (i != regex$splitToSequence$1.$limit - 1 || !matcher.find()) {
                    java.lang.CharSequence charSequence2 = regex$splitToSequence$1.$input;
                    obj3 = charSequence2.subSequence(i3, charSequence2.length()).toString();
                    regex$splitToSequence$1.L$0 = null;
                    regex$splitToSequence$1.L$1 = null;
                    regex$splitToSequence$1.label = 3;
                    if (sequenceScope.yield(obj3, regex$splitToSequence$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return kotlin.Unit.INSTANCE;
                }
                obj2 = regex$splitToSequence$1.$input.subSequence(i3, matcher.start()).toString();
                regex$splitToSequence$1.L$0 = sequenceScope;
                regex$splitToSequence$1.L$1 = matcher;
                regex$splitToSequence$1.I$0 = i;
                regex$splitToSequence$1.label = 2;
                if (sequenceScope.yield(obj2, regex$splitToSequence$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i3 = matcher.end();
                i++;
                if (i != regex$splitToSequence$1.$limit - 1) {
                }
                java.lang.CharSequence charSequence22 = regex$splitToSequence$1.$input;
                obj3 = charSequence22.subSequence(i3, charSequence22.length()).toString();
                regex$splitToSequence$1.L$0 = null;
                regex$splitToSequence$1.L$1 = null;
                regex$splitToSequence$1.label = 3;
                if (sequenceScope.yield(obj3, regex$splitToSequence$1) == coroutine_suspended) {
                }
                return kotlin.Unit.INSTANCE;
            }
            kotlin.ResultKt.throwOnFailure(obj);
        }
        return kotlin.Unit.INSTANCE;
    }
}
