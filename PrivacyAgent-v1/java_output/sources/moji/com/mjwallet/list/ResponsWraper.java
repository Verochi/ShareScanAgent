package moji.com.mjwallet.list;

@kotlin.Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lmoji/com/mjwallet/list/ResponsWraper;", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "a", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", "data", "Lcom/moji/requestcore/MJException;", "b", "Lcom/moji/requestcore/MJException;", "getError", "()Lcom/moji/requestcore/MJException;", "error", "<init>", "(Ljava/lang/Object;Lcom/moji/requestcore/MJException;)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class ResponsWraper<T> {

    /* renamed from: a, reason: from kotlin metadata */
    public final T data;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public final com.moji.requestcore.MJException error;

    public ResponsWraper(T t, @org.jetbrains.annotations.Nullable com.moji.requestcore.MJException mJException) {
        this.data = t;
        this.error = mJException;
    }

    public final T getData() {
        return this.data;
    }

    @org.jetbrains.annotations.Nullable
    public final com.moji.requestcore.MJException getError() {
        return this.error;
    }
}
