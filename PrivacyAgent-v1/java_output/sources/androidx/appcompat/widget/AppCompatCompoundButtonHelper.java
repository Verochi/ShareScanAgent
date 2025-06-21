package androidx.appcompat.widget;

/* loaded from: classes.dex */
class AppCompatCompoundButtonHelper {
    private android.content.res.ColorStateList mButtonTintList = null;
    private android.graphics.PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;

    @androidx.annotation.NonNull
    private final android.widget.CompoundButton mView;

    public AppCompatCompoundButtonHelper(@androidx.annotation.NonNull android.widget.CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    public void applyButtonTint() {
        android.graphics.drawable.Drawable buttonDrawable = androidx.core.widget.CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                android.graphics.drawable.Drawable mutate = androidx.core.graphics.drawable.DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.mHasButtonTint) {
                    androidx.core.graphics.drawable.DrawableCompat.setTintList(mutate, this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    androidx.core.graphics.drawable.DrawableCompat.setTintMode(mutate, this.mButtonTintMode);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.mView.getDrawableState());
                }
                this.mView.setButtonDrawable(mutate);
            }
        }
    }

    public int getCompoundPaddingLeft(int i) {
        return i;
    }

    public android.content.res.ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    public android.graphics.PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[Catch: all -> 0x0085, TRY_ENTER, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:11:0x003e, B:13:0x0046, B:15:0x004c, B:16:0x0059, B:18:0x0061, B:19:0x006a, B:21:0x0072), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061 A[Catch: all -> 0x0085, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:11:0x003e, B:13:0x0046, B:15:0x004c, B:16:0x0059, B:18:0x0061, B:19:0x006a, B:21:0x0072), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #1 {all -> 0x0085, blocks: (B:3:0x001d, B:5:0x0025, B:8:0x002b, B:11:0x003e, B:13:0x0046, B:15:0x004c, B:16:0x0059, B:18:0x0061, B:19:0x006a, B:21:0x0072), top: B:2:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        boolean z;
        int i2;
        int i3;
        int resourceId;
        int resourceId2;
        android.content.Context context = this.mView.getContext();
        int[] iArr = androidx.appcompat.R.styleable.CompoundButton;
        androidx.appcompat.widget.TintTypedArray obtainStyledAttributes = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, 0);
        android.widget.CompoundButton compoundButton = this.mView;
        androidx.core.view.ViewCompat.saveAttributeDataForStyleable(compoundButton, compoundButton.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        try {
            int i4 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat;
            if (obtainStyledAttributes.hasValue(i4) && (resourceId2 = obtainStyledAttributes.getResourceId(i4, 0)) != 0) {
                try {
                    android.widget.CompoundButton compoundButton2 = this.mView;
                    compoundButton2.setButtonDrawable(androidx.appcompat.content.res.AppCompatResources.getDrawable(compoundButton2.getContext(), resourceId2));
                    z = true;
                } catch (android.content.res.Resources.NotFoundException unused) {
                }
                if (!z) {
                    int i5 = androidx.appcompat.R.styleable.CompoundButton_android_button;
                    if (obtainStyledAttributes.hasValue(i5) && (resourceId = obtainStyledAttributes.getResourceId(i5, 0)) != 0) {
                        android.widget.CompoundButton compoundButton3 = this.mView;
                        compoundButton3.setButtonDrawable(androidx.appcompat.content.res.AppCompatResources.getDrawable(compoundButton3.getContext(), resourceId));
                    }
                }
                i2 = androidx.appcompat.R.styleable.CompoundButton_buttonTint;
                if (obtainStyledAttributes.hasValue(i2)) {
                    androidx.core.widget.CompoundButtonCompat.setButtonTintList(this.mView, obtainStyledAttributes.getColorStateList(i2));
                }
                i3 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode;
                if (obtainStyledAttributes.hasValue(i3)) {
                    androidx.core.widget.CompoundButtonCompat.setButtonTintMode(this.mView, androidx.appcompat.widget.DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i3, -1), null));
                }
            }
            z = false;
            if (!z) {
            }
            i2 = androidx.appcompat.R.styleable.CompoundButton_buttonTint;
            if (obtainStyledAttributes.hasValue(i2)) {
            }
            i3 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode;
            if (obtainStyledAttributes.hasValue(i3)) {
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
        } else {
            this.mSkipNextApply = true;
            applyButtonTint();
        }
    }

    public void setSupportButtonTintList(android.content.res.ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    public void setSupportButtonTintMode(@androidx.annotation.Nullable android.graphics.PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
