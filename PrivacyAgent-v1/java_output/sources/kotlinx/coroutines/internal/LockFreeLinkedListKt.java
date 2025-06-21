package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0001\"\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0081T¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\u00048\u0000X\u0081T¢\u0006\f\n\u0004\b\t\u0010\u0006\u0012\u0004\b\n\u0010\b\"\u001a\u0010\u000b\u001a\u00020\u00048\u0000X\u0081T¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u0012\u0004\b\f\u0010\b\" \u0010\u0012\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010\" \u0010\u0016\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u0012\u0004\b\u0015\u0010\b\u001a\u0004\b\u0014\u0010\u0010*\n\u0010\u0018\"\u00020\u00172\u00020\u0017*\u001c\u0010\u001b\u001a\u0004\b\u0000\u0010\u0019\"\b\u0012\u0004\u0012\u00028\u00000\u001a2\b\u0012\u0004\u0012\u00028\u00000\u001a*\f\b\u0002\u0010\u001c\"\u00020\u00012\u00020\u0001*\n\u0010\u001e\"\u00020\u001d2\u00020\u001d*\u001c\u0010 \u001a\u0004\b\u0000\u0010\u0019\"\b\u0012\u0004\u0012\u00028\u00000\u001f2\b\u0012\u0004\u0012\u00028\u00000\u001f¨\u0006!"}, d2 = {"", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "unwrap", "", "UNDECIDED", "I", "getUNDECIDED$annotations", "()V", com.alipay.sdk.m.f0.c.p, "getSUCCESS$annotations", "FAILURE", "getFAILURE$annotations", "a", "Ljava/lang/Object;", "getCONDITION_FALSE", "()Ljava/lang/Object;", "getCONDITION_FALSE$annotations", "CONDITION_FALSE", "b", "getLIST_EMPTY", "getLIST_EMPTY$annotations", "LIST_EMPTY", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AbstractAtomicDesc;", "AbstractAtomicDesc", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "AddLastDesc", "Node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "PrepareOp", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "RemoveFirstDesc", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class LockFreeLinkedListKt {
    public static final int FAILURE = 2;
    public static final int SUCCESS = 1;
    public static final int UNDECIDED = 0;

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object a = new kotlinx.coroutines.internal.Symbol("CONDITION_FALSE");

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object b = new kotlinx.coroutines.internal.Symbol("LIST_EMPTY");

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object getCONDITION_FALSE() {
        return a;
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getCONDITION_FALSE$annotations() {
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getFAILURE$annotations() {
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.Object getLIST_EMPTY() {
        return b;
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getLIST_EMPTY$annotations() {
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getSUCCESS$annotations() {
    }

    @kotlin.PublishedApi
    public static /* synthetic */ void getUNDECIDED$annotations() {
    }

    @kotlin.PublishedApi
    @org.jetbrains.annotations.NotNull
    public static final kotlinx.coroutines.internal.LockFreeLinkedListNode unwrap(@org.jetbrains.annotations.NotNull java.lang.Object obj) {
        kotlinx.coroutines.internal.Removed removed = obj instanceof kotlinx.coroutines.internal.Removed ? (kotlinx.coroutines.internal.Removed) obj : null;
        kotlinx.coroutines.internal.LockFreeLinkedListNode lockFreeLinkedListNode = removed != null ? removed.ref : null;
        return lockFreeLinkedListNode == null ? (kotlinx.coroutines.internal.LockFreeLinkedListNode) obj : lockFreeLinkedListNode;
    }
}
