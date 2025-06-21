package kotlinx.coroutines.internal;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/internal/Symbol;", "", "", "toString", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "value", "unbox", "(Ljava/lang/Object;)Ljava/lang/Object;", "a", "Ljava/lang/String;", "getSymbol", "()Ljava/lang/String;", "symbol", "<init>", "(Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class Symbol {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String symbol;

    public Symbol(@org.jetbrains.annotations.NotNull java.lang.String str) {
        this.symbol = str;
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSymbol() {
        return this.symbol;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return kotlin.text.Typography.less + this.symbol + kotlin.text.Typography.greater;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T unbox(@org.jetbrains.annotations.Nullable java.lang.Object value) {
        if (value == this) {
            return null;
        }
        return value;
    }
}
