package androidx.core.widget;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", com.anythink.expressad.foundation.d.c.bT, "", me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT, "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1 implements android.text.TextWatcher {
    final /* synthetic */ kotlin.jvm.functions.Function1 $afterTextChanged;

    public TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$1(kotlin.jvm.functions.Function1 function1) {
        this.$afterTextChanged = function1;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@org.jetbrains.annotations.Nullable android.text.Editable s2) {
        this.$afterTextChanged.invoke(s2);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }
}
