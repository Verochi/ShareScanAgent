package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lmoji/com/mjweatherservicebase/card/RFlowersMapInfo;", "Ljava/io/Serializable;", "()V", "map", "", "Lcom/moji/common/bean/spot/SpotMaps$spot_maps$spot_map;", "getMap", "()Ljava/util/List;", "setMap", "(Ljava/util/List;)V", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class RFlowersMapInfo implements java.io.Serializable {

    @org.jetbrains.annotations.Nullable
    private java.util.List<com.moji.common.bean.spot.SpotMaps.spot_maps.spot_map> map;
    private boolean success;

    @org.jetbrains.annotations.Nullable
    private java.lang.String url;

    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.moji.common.bean.spot.SpotMaps.spot_maps.spot_map> getMap() {
        return this.map;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getUrl() {
        return this.url;
    }

    public final void setMap(@org.jetbrains.annotations.Nullable java.util.List<com.moji.common.bean.spot.SpotMaps.spot_maps.spot_map> list) {
        this.map = list;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }

    public final void setUrl(@org.jetbrains.annotations.Nullable java.lang.String str) {
        this.url = str;
    }
}
