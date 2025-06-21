package moji.com.mjweatherservicebase.list;

@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lmoji/com/mjweatherservicebase/list/RFlowersSpot;", "", "", "a", "Z", "isEmpty", "()Z", "setEmpty", "(Z)V", "b", "isFailure", "setFailure", "c", "isInner", "setInner", "d", "getIntercept", "setIntercept", "intercept", "Lcom/moji/http/rapeflowers/RapeFlowersSpotResp;", "e", "Lcom/moji/http/rapeflowers/RapeFlowersSpotResp;", "getData", "()Lcom/moji/http/rapeflowers/RapeFlowersSpotResp;", "setData", "(Lcom/moji/http/rapeflowers/RapeFlowersSpotResp;)V", "data", "<init>", "()V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class RFlowersSpot {

    /* renamed from: a, reason: from kotlin metadata */
    public boolean isEmpty;

    /* renamed from: b, reason: from kotlin metadata */
    public boolean isFailure;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean isInner;

    /* renamed from: d, reason: from kotlin metadata */
    public boolean intercept;

    /* renamed from: e, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.moji.http.rapeflowers.RapeFlowersSpotResp data;

    @org.jetbrains.annotations.Nullable
    public final com.moji.http.rapeflowers.RapeFlowersSpotResp getData() {
        return this.data;
    }

    public final boolean getIntercept() {
        return this.intercept;
    }

    /* renamed from: isEmpty, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    /* renamed from: isFailure, reason: from getter */
    public final boolean getIsFailure() {
        return this.isFailure;
    }

    /* renamed from: isInner, reason: from getter */
    public final boolean getIsInner() {
        return this.isInner;
    }

    public final void setData(@org.jetbrains.annotations.Nullable com.moji.http.rapeflowers.RapeFlowersSpotResp rapeFlowersSpotResp) {
        this.data = rapeFlowersSpotResp;
    }

    public final void setEmpty(boolean z) {
        this.isEmpty = z;
    }

    public final void setFailure(boolean z) {
        this.isFailure = z;
    }

    public final void setInner(boolean z) {
        this.isInner = z;
    }

    public final void setIntercept(boolean z) {
        this.intercept = z;
    }
}
