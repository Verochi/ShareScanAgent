package moji.com.mjweatherservicebase.detail;

@kotlin.Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lmoji/com/mjweatherservicebase/detail/DetailData;", "", "", "component1", "Lcom/moji/http/rapeflowers/RapeFlowersDetailResp;", "component2", "Lcom/moji/requestcore/MJException;", "component3", "success", "result", "exception", com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "", "toString", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "equals", "a", "Z", "getSuccess", "()Z", "b", "Lcom/moji/http/rapeflowers/RapeFlowersDetailResp;", "getResult", "()Lcom/moji/http/rapeflowers/RapeFlowersDetailResp;", "c", "Lcom/moji/requestcore/MJException;", "getException", "()Lcom/moji/requestcore/MJException;", "<init>", "(ZLcom/moji/http/rapeflowers/RapeFlowersDetailResp;Lcom/moji/requestcore/MJException;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final /* data */ class DetailData {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    public final boolean success;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.Nullable
    public final com.moji.http.rapeflowers.RapeFlowersDetailResp result;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.Nullable
    public final com.moji.requestcore.MJException exception;

    public DetailData(boolean z, @org.jetbrains.annotations.Nullable com.moji.http.rapeflowers.RapeFlowersDetailResp rapeFlowersDetailResp, @org.jetbrains.annotations.Nullable com.moji.requestcore.MJException mJException) {
        this.success = z;
        this.result = rapeFlowersDetailResp;
        this.exception = mJException;
    }

    public static /* synthetic */ moji.com.mjweatherservicebase.detail.DetailData copy$default(moji.com.mjweatherservicebase.detail.DetailData detailData, boolean z, com.moji.http.rapeflowers.RapeFlowersDetailResp rapeFlowersDetailResp, com.moji.requestcore.MJException mJException, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            z = detailData.success;
        }
        if ((i & 2) != 0) {
            rapeFlowersDetailResp = detailData.result;
        }
        if ((i & 4) != 0) {
            mJException = detailData.exception;
        }
        return detailData.copy(z, rapeFlowersDetailResp, mJException);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    @org.jetbrains.annotations.Nullable
    /* renamed from: component2, reason: from getter */
    public final com.moji.http.rapeflowers.RapeFlowersDetailResp getResult() {
        return this.result;
    }

    @org.jetbrains.annotations.Nullable
    /* renamed from: component3, reason: from getter */
    public final com.moji.requestcore.MJException getException() {
        return this.exception;
    }

    @org.jetbrains.annotations.NotNull
    public final moji.com.mjweatherservicebase.detail.DetailData copy(boolean success, @org.jetbrains.annotations.Nullable com.moji.http.rapeflowers.RapeFlowersDetailResp result, @org.jetbrains.annotations.Nullable com.moji.requestcore.MJException exception) {
        return new moji.com.mjweatherservicebase.detail.DetailData(success, result, exception);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof moji.com.mjweatherservicebase.detail.DetailData)) {
            return false;
        }
        moji.com.mjweatherservicebase.detail.DetailData detailData = (moji.com.mjweatherservicebase.detail.DetailData) other;
        return this.success == detailData.success && kotlin.jvm.internal.Intrinsics.areEqual(this.result, detailData.result) && kotlin.jvm.internal.Intrinsics.areEqual(this.exception, detailData.exception);
    }

    @org.jetbrains.annotations.Nullable
    public final com.moji.requestcore.MJException getException() {
        return this.exception;
    }

    @org.jetbrains.annotations.Nullable
    public final com.moji.http.rapeflowers.RapeFlowersDetailResp getResult() {
        return this.result;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.success;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        com.moji.http.rapeflowers.RapeFlowersDetailResp rapeFlowersDetailResp = this.result;
        int hashCode = (i + (rapeFlowersDetailResp == null ? 0 : rapeFlowersDetailResp.hashCode())) * 31;
        com.moji.requestcore.MJException mJException = this.exception;
        return hashCode + (mJException != null ? mJException.hashCode() : 0);
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "DetailData(success=" + this.success + ", result=" + this.result + ", exception=" + this.exception + ")";
    }
}
