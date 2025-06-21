package moji.com.mjwallet;

@kotlin.Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"moji/com/mjwallet/CashExtractInfoActivity$onCreate$8", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", com.anythink.core.common.h.c.X, "p3", "onTextChanged", "s", "MJWallet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes30.dex */
public final class CashExtractInfoActivity$onCreate$8 implements android.text.TextWatcher {
    public final /* synthetic */ moji.com.mjwallet.CashExtractInfoActivity n;

    public CashExtractInfoActivity$onCreate$8(moji.com.mjwallet.CashExtractInfoActivity cashExtractInfoActivity) {
        this.n = cashExtractInfoActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@org.jetbrains.annotations.Nullable android.text.Editable p0) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@org.jetbrains.annotations.Nullable java.lang.CharSequence p0, int p1, int p2, int p3) {
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b8  */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onTextChanged(@org.jetbrains.annotations.Nullable java.lang.CharSequence s2, int p1, int p2, int p3) {
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding;
        boolean z;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding2;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding3;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding4;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding5;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding6;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding7;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding8;
        boolean contains$default;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding9;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding10;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding11;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding12;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding13;
        boolean z2 = false;
        moji.com.mjwallet.databinding.ActivityWalletWithDrawalBinding activityWalletWithDrawalBinding14 = null;
        if (s2 != null) {
            contains$default = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) s2.toString(), (java.lang.CharSequence) ".", false, 2, (java.lang.Object) null);
            if (contains$default) {
                if ((s2.length() - 1) - kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) s2.toString(), ".", 0, false, 6, (java.lang.Object) null) > 2) {
                    java.lang.CharSequence subSequence = s2.toString().subSequence(0, kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) s2.toString(), ".", 0, false, 6, (java.lang.Object) null) + 2 + 1);
                    activityWalletWithDrawalBinding11 = this.n.binding;
                    if (activityWalletWithDrawalBinding11 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityWalletWithDrawalBinding11 = null;
                    }
                    activityWalletWithDrawalBinding11.inputAmount.setText(subSequence);
                    activityWalletWithDrawalBinding12 = this.n.binding;
                    if (activityWalletWithDrawalBinding12 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityWalletWithDrawalBinding12 = null;
                    }
                    android.widget.EditText editText = activityWalletWithDrawalBinding12.inputAmount;
                    activityWalletWithDrawalBinding13 = this.n.binding;
                    if (activityWalletWithDrawalBinding13 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityWalletWithDrawalBinding13 = null;
                    }
                    editText.setSelection(activityWalletWithDrawalBinding13.inputAmount.getText().toString().length());
                } else if (kotlin.text.StringsKt__StringsKt.startsWith$default(s2, (java.lang.CharSequence) ".", false, 2, (java.lang.Object) null)) {
                    activityWalletWithDrawalBinding9 = this.n.binding;
                    if (activityWalletWithDrawalBinding9 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                        activityWalletWithDrawalBinding9 = null;
                    }
                    activityWalletWithDrawalBinding9.inputAmount.setText("");
                    activityWalletWithDrawalBinding10 = this.n.binding;
                    if (activityWalletWithDrawalBinding10 == null) {
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        activityWalletWithDrawalBinding14 = activityWalletWithDrawalBinding10;
                    }
                    activityWalletWithDrawalBinding14.inputAmount.setSelection(0);
                    return;
                }
            }
        }
        if (s2 != null) {
            if ((s2.length() > 0) && new java.math.BigDecimal(s2.toString()).floatValue() > 99999.0f) {
                java.lang.String bigDecimal = new java.math.BigDecimal(s2.toString()).divide(new java.math.BigDecimal(10), 1, java.math.RoundingMode.DOWN).toString();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bigDecimal, "BigDecimal(s.toString())…dingMode.DOWN).toString()");
                activityWalletWithDrawalBinding6 = this.n.binding;
                if (activityWalletWithDrawalBinding6 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityWalletWithDrawalBinding6 = null;
                }
                activityWalletWithDrawalBinding6.inputAmount.setText(bigDecimal);
                activityWalletWithDrawalBinding7 = this.n.binding;
                if (activityWalletWithDrawalBinding7 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityWalletWithDrawalBinding7 = null;
                }
                android.widget.EditText editText2 = activityWalletWithDrawalBinding7.inputAmount;
                activityWalletWithDrawalBinding8 = this.n.binding;
                if (activityWalletWithDrawalBinding8 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityWalletWithDrawalBinding8 = null;
                }
                editText2.setSelection(activityWalletWithDrawalBinding8.inputAmount.getText().toString().length());
            }
        }
        if (s2 != null) {
            if ((s2.length() > 0) && kotlin.text.StringsKt__StringsJVMKt.startsWith$default(s2.toString(), "0", false, 2, null) && s2.length() > 1 && s2.charAt(1) != '.') {
                activityWalletWithDrawalBinding4 = this.n.binding;
                if (activityWalletWithDrawalBinding4 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                    activityWalletWithDrawalBinding4 = null;
                }
                activityWalletWithDrawalBinding4.inputAmount.setText("0");
                activityWalletWithDrawalBinding5 = this.n.binding;
                if (activityWalletWithDrawalBinding5 == null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityWalletWithDrawalBinding14 = activityWalletWithDrawalBinding5;
                }
                activityWalletWithDrawalBinding14.inputAmount.setSelection(1);
                return;
            }
        }
        activityWalletWithDrawalBinding = this.n.binding;
        if (activityWalletWithDrawalBinding == null) {
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWalletWithDrawalBinding = null;
        }
        if (activityWalletWithDrawalBinding.tvUserAccount.getText() != null) {
            activityWalletWithDrawalBinding3 = this.n.binding;
            if (activityWalletWithDrawalBinding3 == null) {
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityWalletWithDrawalBinding3 = null;
            }
            java.lang.CharSequence text = activityWalletWithDrawalBinding3.tvUserAccount.getText();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(text, "binding.tvUserAccount.text");
            if (!(text.length() == 0)) {
                z = false;
                activityWalletWithDrawalBinding2 = this.n.binding;
                if (activityWalletWithDrawalBinding2 != null) {
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityWalletWithDrawalBinding14 = activityWalletWithDrawalBinding2;
                }
                android.widget.TextView textView = activityWalletWithDrawalBinding14.confirmCashExtract;
                if (s2 != null) {
                    if ((s2.length() > 0) && !z) {
                        z2 = true;
                    }
                }
                textView.setEnabled(z2);
            }
        }
        z = true;
        activityWalletWithDrawalBinding2 = this.n.binding;
        if (activityWalletWithDrawalBinding2 != null) {
        }
        android.widget.TextView textView2 = activityWalletWithDrawalBinding14.confirmCashExtract;
        if (s2 != null) {
        }
        textView2.setEnabled(z2);
    }
}
