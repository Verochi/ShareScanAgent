package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"moji/com/mjwallet/WalletAccountManageActivity$onCreate$2", "Landroid/text/InputFilter;", "filter", "", com.tencent.open.SocialConstants.PARAM_SOURCE, "p1", "", com.anythink.core.common.h.c.X, "p3", "Landroid/text/Spanned;", "p4", "p5", "MJWallet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes30.dex */
public final class WalletAccountManageActivity$onCreate$2 implements android.text.InputFilter {
    @Override // android.text.InputFilter
    @org.jetbrains.annotations.Nullable
    public java.lang.CharSequence filter(@org.jetbrains.annotations.NotNull java.lang.CharSequence source, int p1, int p2, @org.jetbrains.annotations.Nullable android.text.Spanned p3, int p4, int p5) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(source, "source");
        if (java.util.regex.Pattern.compile("[a-zA-Z|一-龥]+").matcher(source.toString()).matches()) {
            return null;
        }
        return "";
    }
}
