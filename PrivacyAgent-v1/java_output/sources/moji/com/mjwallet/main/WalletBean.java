package moji.com.mjwallet.main;

@kotlinx.parcelize.Parcelize
@kotlin.Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lmoji/com/mjwallet/main/WalletBean;", "Landroid/os/Parcelable;", "success", "", "balance", "", "errorCode", "", "(ZJI)V", "getBalance", "()J", "getErrorCode", "()I", "getSuccess", "()Z", "component1", "component2", "component3", com.sensorsdata.sf.ui.view.UIProperty.action_type_copy, "describeContents", "equals", "other", "", com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HASHCODE, "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "MJWallet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final /* data */ class WalletBean implements android.os.Parcelable {

    @org.jetbrains.annotations.NotNull
    public static final android.os.Parcelable.Creator<moji.com.mjwallet.main.WalletBean> CREATOR = new moji.com.mjwallet.main.WalletBean.Creator();
    private final long balance;
    private final int errorCode;
    private final boolean success;

    @kotlin.Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements android.os.Parcelable.Creator<moji.com.mjwallet.main.WalletBean> {
        @Override // android.os.Parcelable.Creator
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjwallet.main.WalletBean createFromParcel(@org.jetbrains.annotations.NotNull android.os.Parcel parcel) {
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new moji.com.mjwallet.main.WalletBean(parcel.readInt() != 0, parcel.readLong(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        @org.jetbrains.annotations.NotNull
        public final moji.com.mjwallet.main.WalletBean[] newArray(int i) {
            return new moji.com.mjwallet.main.WalletBean[i];
        }
    }

    public WalletBean(boolean z, long j, int i) {
        this.success = z;
        this.balance = j;
        this.errorCode = i;
    }

    public /* synthetic */ WalletBean(boolean z, long j, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(z, j, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ moji.com.mjwallet.main.WalletBean copy$default(moji.com.mjwallet.main.WalletBean walletBean, boolean z, long j, int i, int i2, java.lang.Object obj) {
        if ((i2 & 1) != 0) {
            z = walletBean.success;
        }
        if ((i2 & 2) != 0) {
            j = walletBean.balance;
        }
        if ((i2 & 4) != 0) {
            i = walletBean.errorCode;
        }
        return walletBean.copy(z, j, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final long getBalance() {
        return this.balance;
    }

    /* renamed from: component3, reason: from getter */
    public final int getErrorCode() {
        return this.errorCode;
    }

    @org.jetbrains.annotations.NotNull
    public final moji.com.mjwallet.main.WalletBean copy(boolean success, long balance, int errorCode) {
        return new moji.com.mjwallet.main.WalletBean(success, balance, errorCode);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@org.jetbrains.annotations.Nullable java.lang.Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof moji.com.mjwallet.main.WalletBean)) {
            return false;
        }
        moji.com.mjwallet.main.WalletBean walletBean = (moji.com.mjwallet.main.WalletBean) other;
        return this.success == walletBean.success && this.balance == walletBean.balance && this.errorCode == walletBean.errorCode;
    }

    public final long getBalance() {
        return this.balance;
    }

    public final int getErrorCode() {
        return this.errorCode;
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
        return (((r0 * 31) + defpackage.ap0.a(this.balance)) * 31) + this.errorCode;
    }

    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return "WalletBean(success=" + this.success + ", balance=" + this.balance + ", errorCode=" + this.errorCode + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel parcel, int flags) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.success ? 1 : 0);
        parcel.writeLong(this.balance);
        parcel.writeInt(this.errorCode);
    }
}
