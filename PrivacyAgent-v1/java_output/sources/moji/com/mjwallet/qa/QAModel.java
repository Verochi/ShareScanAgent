package moji.com.mjwallet.qa;

@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J'\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\"\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lmoji/com/mjwallet/qa/QAModel;", "", "", "component1", "component2", "", "component3", "q", "a", "spread", com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "toString", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "other", "equals", "Ljava/lang/String;", "getQ", "()Ljava/lang/String;", "b", "getA", "c", "Z", "getSpread", "()Z", "setSpread", "(Z)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final /* data */ class QAModel {

    /* renamed from: a, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String q;

    /* renamed from: b, reason: from kotlin metadata and from toString */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String a;

    /* renamed from: c, reason: from kotlin metadata and from toString */
    public boolean spread;

    public QAModel(@org.jetbrains.annotations.NotNull java.lang.String q, @org.jetbrains.annotations.NotNull java.lang.String a, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(q, "q");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        this.q = q;
        this.a = a;
        this.spread = z;
    }

    public /* synthetic */ QAModel(java.lang.String str, java.lang.String str2, boolean z, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    public static /* synthetic */ moji.com.mjwallet.qa.QAModel copy$default(moji.com.mjwallet.qa.QAModel qAModel, java.lang.String str, java.lang.String str2, boolean z, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str = qAModel.q;
        }
        if ((i & 2) != 0) {
            str2 = qAModel.a;
        }
        if ((i & 4) != 0) {
            z = qAModel.spread;
        }
        return qAModel.copy(str, str2, z);
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: component1, reason: from getter */
    public final java.lang.String getQ() {
        return this.q;
    }

    @org.jetbrains.annotations.NotNull
    /* renamed from: component2, reason: from getter */
    public final java.lang.String getA() {
        return this.a;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSpread() {
        return this.spread;
    }

    @org.jetbrains.annotations.NotNull
    public final moji.com.mjwallet.qa.QAModel copy(@org.jetbrains.annotations.NotNull java.lang.String q, @org.jetbrains.annotations.NotNull java.lang.String a, boolean spread) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(q, "q");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(a, "a");
        return new moji.com.mjwallet.qa.QAModel(q, a, spread);
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof moji.com.mjwallet.qa.QAModel)) {
            return false;
        }
        moji.com.mjwallet.qa.QAModel qAModel = (moji.com.mjwallet.qa.QAModel) other;
        return kotlin.jvm.internal.Intrinsics.areEqual(this.q, qAModel.q) && kotlin.jvm.internal.Intrinsics.areEqual(this.a, qAModel.a) && this.spread == qAModel.spread;
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getA() {
        return this.a;
    }

    @org.jetbrains.annotations.NotNull
    public final java.lang.String getQ() {
        return this.q;
    }

    public final boolean getSpread() {
        return this.spread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.q.hashCode() * 31) + this.a.hashCode()) * 31;
        boolean z = this.spread;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final void setSpread(boolean z) {
        this.spread = z;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "QAModel(q=" + this.q + ", a=" + this.a + ", spread=" + this.spread + ")";
    }
}
