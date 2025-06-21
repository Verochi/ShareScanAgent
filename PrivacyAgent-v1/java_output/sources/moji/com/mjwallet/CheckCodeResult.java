package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lmoji/com/mjwallet/CheckCodeResult;", "", "", "component1", "", "component2", "success", "p", com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "toString", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "equals", "a", "Z", "getSuccess", "()Z", "b", "Ljava/lang/String;", "getP", "()Ljava/lang/String;", "<init>", "(ZLjava/lang/String;)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final /* data */ class CheckCodeResult {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    public final boolean success;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String p;

    public CheckCodeResult(boolean z, @org.jetbrains.annotations.NotNull java.lang.String p) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p, "p");
        this.success = z;
        this.p = p;
    }

    public static /* synthetic */ moji.com.mjwallet.CheckCodeResult copy$default(moji.com.mjwallet.CheckCodeResult checkCodeResult, boolean z, java.lang.String str, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = checkCodeResult.success;
        }
        if ((i & 2) != 0) {
            str = checkCodeResult.p;
        }
        return checkCodeResult.copy(z, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: component2, reason: from getter */
    public final java.lang.String getP() {
        return this.p;
    }

    @org.jetbrains.annotations.NotNull
    public final moji.com.mjwallet.CheckCodeResult copy(boolean success, @org.jetbrains.annotations.NotNull java.lang.String p) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(p, "p");
        return new moji.com.mjwallet.CheckCodeResult(success, p);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof moji.com.mjwallet.CheckCodeResult)) {
            return false;
        }
        moji.com.mjwallet.CheckCodeResult checkCodeResult = (moji.com.mjwallet.CheckCodeResult) other;
        return this.success == checkCodeResult.success && kotlin.jvm.internal.Intrinsics.areEqual(this.p, checkCodeResult.p);
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getP() {
        return this.p;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.p.hashCode();
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "CheckCodeResult(success=" + this.success + ", p=" + this.p + ")";
    }
}
