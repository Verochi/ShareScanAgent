package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1", f = "CashExtractInfoViewModel.kt", i = {}, l = {96, 109}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
public final class CashExtractInfoViewModel$requestVerificationCode$1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
    int label;
    final /* synthetic */ moji.com.mjwallet.CashExtractInfoViewModel this$0;

    @kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1$1", f = "CashExtractInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        int label;

        public AnonymousClass1(kotlin.coroutines.Continuation<? super moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1.AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.NotNull
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
            return new moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1.AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @org.jetbrains.annotations.Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1.AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            com.moji.tool.ToastTool.showToast(moji.com.mjwallet.R.string.server_error);
            return kotlin.Unit.INSTANCE;
        }
    }

    @kotlin.Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @kotlin.coroutines.jvm.internal.DebugMetadata(c = "moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1$2", f = "CashExtractInfoViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1$2, reason: invalid class name */
    public static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.SuspendLambda implements kotlin.jvm.functions.Function2<kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> {
        int label;

        public AnonymousClass2(kotlin.coroutines.Continuation<? super moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1.AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.NotNull
        public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
            return new moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1.AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @org.jetbrains.annotations.Nullable
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
            return ((moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1.AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
            kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.ResultKt.throwOnFailure(obj);
            com.moji.tool.ToastTool.showToast(moji.com.mjwallet.R.string.network_connect_fail);
            return kotlin.Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashExtractInfoViewModel$requestVerificationCode$1(moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel, kotlin.coroutines.Continuation<? super moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1> continuation) {
        super(2, continuation);
        this.this$0 = cashExtractInfoViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.NotNull
    public final kotlin.coroutines.Continuation<kotlin.Unit> create(@org.jetbrains.annotations.Nullable java.lang.Object obj, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> continuation) {
        return new moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    @org.jetbrains.annotations.Nullable
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final java.lang.Object mo5invoke(@org.jetbrains.annotations.NotNull kotlinx.coroutines.CoroutineScope coroutineScope, @org.jetbrains.annotations.Nullable kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return ((moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1) create(coroutineScope, continuation)).invokeSuspend(kotlin.Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        java.lang.Object coroutine_suspended;
        int i;
        int i2;
        coroutine_suspended = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (com.moji.requestcore.MJException e) {
            com.moji.tool.log.MJLogger.e(moji.com.mjwallet.CashExtractInfoViewModel.TAG, e);
            if (e.getCode() == 604) {
                i = this.this$0.mSendVerificationCodeRequestRetryCount;
                if (i < 2) {
                    moji.com.mjwallet.CashExtractInfoViewModel cashExtractInfoViewModel = this.this$0;
                    i2 = cashExtractInfoViewModel.mSendVerificationCodeRequestRetryCount;
                    cashExtractInfoViewModel.mSendVerificationCodeRequestRetryCount = i2 + 1;
                    this.this$0.requestVerificationCode();
                }
            }
            kotlinx.coroutines.MainCoroutineDispatcher main = kotlinx.coroutines.Dispatchers.getMain();
            moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1.AnonymousClass2 anonymousClass2 = new moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1.AnonymousClass2(null);
            this.label = 2;
            if (kotlinx.coroutines.BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i3 == 0) {
            kotlin.ResultKt.throwOnFailure(obj);
            java.lang.Object executeSyncOrThrowException = new com.moji.http.pcd.SendVerificationCodeRequest().executeSyncOrThrowException();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(executeSyncOrThrowException, "SendVerificationCodeRequ…uteSyncOrThrowException()");
            if (!((com.moji.requestcore.entity.MJBaseRespRc) executeSyncOrThrowException).OK()) {
                kotlinx.coroutines.MainCoroutineDispatcher main2 = kotlinx.coroutines.Dispatchers.getMain();
                moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1.AnonymousClass1 anonymousClass1 = new moji.com.mjwallet.CashExtractInfoViewModel$requestVerificationCode$1.AnonymousClass1(null);
                this.label = 1;
                if (kotlinx.coroutines.BuildersKt.withContext(main2, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.ResultKt.throwOnFailure(obj);
                return kotlin.Unit.INSTANCE;
            }
            kotlin.ResultKt.throwOnFailure(obj);
        }
        this.this$0.mSendVerificationCodeRequestRetryCount = 0;
        return kotlin.Unit.INSTANCE;
    }
}
