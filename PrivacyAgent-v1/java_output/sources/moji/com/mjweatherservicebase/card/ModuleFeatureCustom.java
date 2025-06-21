package moji.com.mjweatherservicebase.card;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R6\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lmoji/com/mjweatherservicebase/card/ModuleFeatureCustom;", "", "", "a", "Ljava/lang/String;", "getShareTitle", "()Ljava/lang/String;", "setShareTitle", "(Ljava/lang/String;)V", "shareTitle", "b", "getGraphicSharePath", "setGraphicSharePath", "graphicSharePath", "Lcom/moji/share/entity/ShareFromType;", "c", "Lcom/moji/share/entity/ShareFromType;", "getShareFrom", "()Lcom/moji/share/entity/ShareFromType;", "setShareFrom", "(Lcom/moji/share/entity/ShareFromType;)V", "shareFrom", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/ArrayList;", "getTypeList", "()Ljava/util/ArrayList;", "setTypeList", "(Ljava/util/ArrayList;)V", "typeList", "<init>", "()V", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class ModuleFeatureCustom {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.String shareTitle;

    /* renamed from: b, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.String graphicSharePath;

    /* renamed from: c, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public com.moji.share.entity.ShareFromType shareFrom;

    /* renamed from: d, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.util.ArrayList<java.lang.Integer> typeList;

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getGraphicSharePath() {
        return this.graphicSharePath;
    }

    @org.jetbrains.annotations.Nullable
    public final com.moji.share.entity.ShareFromType getShareFrom() {
        return this.shareFrom;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getShareTitle() {
        return this.shareTitle;
    }

    @org.jetbrains.annotations.Nullable
    public final java.util.ArrayList<java.lang.Integer> getTypeList() {
        return this.typeList;
    }

    public final void setGraphicSharePath(@org.jetbrains.annotations.Nullable java.lang.String str) {
        this.graphicSharePath = str;
    }

    public final void setShareFrom(@org.jetbrains.annotations.Nullable com.moji.share.entity.ShareFromType shareFromType) {
        this.shareFrom = shareFromType;
    }

    public final void setShareTitle(@org.jetbrains.annotations.Nullable java.lang.String str) {
        this.shareTitle = str;
    }

    public final void setTypeList(@org.jetbrains.annotations.Nullable java.util.ArrayList<java.lang.Integer> arrayList) {
        this.typeList = arrayList;
    }
}
