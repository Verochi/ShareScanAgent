package moji.com.mjweatherservicebase;

@kotlin.Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R$\u0010#\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010+\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006."}, d2 = {"Lmoji/com/mjweatherservicebase/BaseFlowersPageInfo;", "", "Lmoji/com/mjweatherservicebase/card/RFlowersMapInfo;", "a", "Lmoji/com/mjweatherservicebase/card/RFlowersMapInfo;", "getMap", "()Lmoji/com/mjweatherservicebase/card/RFlowersMapInfo;", "setMap", "(Lmoji/com/mjweatherservicebase/card/RFlowersMapInfo;)V", "map", "Lcom/moji/http/me/MeServiceEntity$EntranceRegionResListBean$EntranceResListBean;", "b", "Lcom/moji/http/me/MeServiceEntity$EntranceRegionResListBean$EntranceResListBean;", "getBanner", "()Lcom/moji/http/me/MeServiceEntity$EntranceRegionResListBean$EntranceResListBean;", "setBanner", "(Lcom/moji/http/me/MeServiceEntity$EntranceRegionResListBean$EntranceResListBean;)V", "banner", "", "c", "Z", "isEmpty", "()Z", "setEmpty", "(Z)V", "d", "isFailure", "setFailure", "", "e", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "msg", "Lcom/moji/http/rapeflowers/RapeFlowersInfoResp;", "f", "Lcom/moji/http/rapeflowers/RapeFlowersInfoResp;", "getInfo", "()Lcom/moji/http/rapeflowers/RapeFlowersInfoResp;", "setInfo", "(Lcom/moji/http/rapeflowers/RapeFlowersInfoResp;)V", "info", "<init>", "()V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class BaseFlowersPageInfo {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public moji.com.mjweatherservicebase.card.RFlowersMapInfo map;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean banner;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean isEmpty;

    /* renamed from: d, reason: from kotlin metadata */
    public boolean isFailure;

    /* renamed from: e, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.String msg;

    /* renamed from: f, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.moji.http.rapeflowers.RapeFlowersInfoResp info;

    @org.jetbrains.annotations.Nullable
    public final com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean getBanner() {
        return this.banner;
    }

    @org.jetbrains.annotations.Nullable
    public final com.moji.http.rapeflowers.RapeFlowersInfoResp getInfo() {
        return this.info;
    }

    @org.jetbrains.annotations.Nullable
    public final moji.com.mjweatherservicebase.card.RFlowersMapInfo getMap() {
        return this.map;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getMsg() {
        return this.msg;
    }

    /* renamed from: isEmpty, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    /* renamed from: isFailure, reason: from getter */
    public final boolean getIsFailure() {
        return this.isFailure;
    }

    public final void setBanner(@org.jetbrains.annotations.Nullable com.moji.http.me.MeServiceEntity.EntranceRegionResListBean.EntranceResListBean entranceResListBean) {
        this.banner = entranceResListBean;
    }

    public final void setEmpty(boolean z) {
        this.isEmpty = z;
    }

    public final void setFailure(boolean z) {
        this.isFailure = z;
    }

    public final void setInfo(@org.jetbrains.annotations.Nullable com.moji.http.rapeflowers.RapeFlowersInfoResp rapeFlowersInfoResp) {
        this.info = rapeFlowersInfoResp;
    }

    public final void setMap(@org.jetbrains.annotations.Nullable moji.com.mjweatherservicebase.card.RFlowersMapInfo rFlowersMapInfo) {
        this.map = rFlowersMapInfo;
    }

    public final void setMsg(@org.jetbrains.annotations.Nullable java.lang.String str) {
        this.msg = str;
    }
}
