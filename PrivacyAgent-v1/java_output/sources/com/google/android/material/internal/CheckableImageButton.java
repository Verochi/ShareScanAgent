package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class CheckableImageButton extends androidx.appcompat.widget.AppCompatImageButton implements android.widget.Checkable {
    private static final int[] DRAWABLE_STATE_CHECKED = {android.R.attr.state_checked};
    private boolean checkable;
    private boolean checked;
    private boolean pressable;

    /* renamed from: com.google.android.material.internal.CheckableImageButton$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.core.view.AccessibilityDelegateCompat {
        public AnonymousClass1() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(android.view.View view, @androidx.annotation.NonNull android.view.accessibility.AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setChecked(com.google.android.material.internal.CheckableImageButton.this.isChecked());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(android.view.View view, @androidx.annotation.NonNull androidx.core.view.accessibility.AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(com.google.android.material.internal.CheckableImageButton.this.isCheckable());
            accessibilityNodeInfoCompat.setChecked(com.google.android.material.internal.CheckableImageButton.this.isChecked());
        }
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final android.os.Parcelable.Creator<com.google.android.material.internal.CheckableImageButton.SavedState> CREATOR = new com.google.android.material.internal.CheckableImageButton.SavedState.AnonymousClass1();
        boolean checked;

        /* renamed from: com.google.android.material.internal.CheckableImageButton$SavedState$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<com.google.android.material.internal.CheckableImageButton.SavedState> {
            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.internal.CheckableImageButton.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
                return new com.google.android.material.internal.CheckableImageButton.SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            @androidx.annotation.NonNull
            public com.google.android.material.internal.CheckableImageButton.SavedState createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
                return new com.google.android.material.internal.CheckableImageButton.SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @androidx.annotation.NonNull
            public com.google.android.material.internal.CheckableImageButton.SavedState[] newArray(int i) {
                return new com.google.android.material.internal.CheckableImageButton.SavedState[i];
            }
        }

        public SavedState(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            super(parcel, classLoader);
            readFromParcel(parcel);
        }

        public SavedState(android.os.Parcelable parcelable) {
            super(parcelable);
        }

        private void readFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            this.checked = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.checked ? 1 : 0);
        }
    }

    public CheckableImageButton(android.content.Context context) {
        this(context, null);
    }

    public CheckableImageButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.imageButtonStyle);
    }

    public CheckableImageButton(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.checkable = true;
        this.pressable = true;
        androidx.core.view.ViewCompat.setAccessibilityDelegate(this, new com.google.android.material.internal.CheckableImageButton.AnonymousClass1());
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isPressable() {
        return this.pressable;
    }

    @Override // android.widget.ImageView, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (!this.checked) {
            return super.onCreateDrawableState(i);
        }
        int[] iArr = DRAWABLE_STATE_CHECKED;
        return android.view.View.mergeDrawableStates(super.onCreateDrawableState(i + iArr.length), iArr);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(android.os.Parcelable parcelable) {
        if (!(parcelable instanceof com.google.android.material.internal.CheckableImageButton.SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        com.google.android.material.internal.CheckableImageButton.SavedState savedState = (com.google.android.material.internal.CheckableImageButton.SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    @Override // android.view.View
    @androidx.annotation.NonNull
    public android.os.Parcelable onSaveInstanceState() {
        com.google.android.material.internal.CheckableImageButton.SavedState savedState = new com.google.android.material.internal.CheckableImageButton.SavedState(super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    public void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.checkable || this.checked == z) {
            return;
        }
        this.checked = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.pressable = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.pressable) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }
}
