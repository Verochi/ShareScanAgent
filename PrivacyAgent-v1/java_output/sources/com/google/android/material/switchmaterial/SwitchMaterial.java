package com.google.android.material.switchmaterial;

/* loaded from: classes22.dex */
public class SwitchMaterial extends androidx.appcompat.widget.SwitchCompat {
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_CompoundButton_Switch;
    private static final int[][] ENABLED_CHECKED_STATES = {new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};

    @androidx.annotation.NonNull
    private final com.google.android.material.elevation.ElevationOverlayProvider elevationOverlayProvider;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList materialThemeColorsThumbTintList;

    @androidx.annotation.Nullable
    private android.content.res.ColorStateList materialThemeColorsTrackTintList;
    private boolean useMaterialThemeColors;

    public SwitchMaterial(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    public SwitchMaterial(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.switchStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SwitchMaterial(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, attributeSet, i, r4), attributeSet, i);
        int i2 = DEF_STYLE_RES;
        android.content.Context context2 = getContext();
        this.elevationOverlayProvider = new com.google.android.material.elevation.ElevationOverlayProvider(context2);
        android.content.res.TypedArray obtainStyledAttributes = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.SwitchMaterial, i, i2, new int[0]);
        this.useMaterialThemeColors = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.SwitchMaterial_useMaterialThemeColors, false);
        obtainStyledAttributes.recycle();
    }

    private android.content.res.ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.materialThemeColorsThumbTintList == null) {
            int color = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R.attr.colorSurface);
            int color2 = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R.attr.colorControlActivated);
            float dimension = getResources().getDimension(com.google.android.material.R.dimen.mtrl_switch_thumb_elevation);
            if (this.elevationOverlayProvider.isThemeElevationOverlayEnabled()) {
                dimension += com.google.android.material.internal.ViewUtils.getParentAbsoluteElevation(this);
            }
            int compositeOverlayIfNeeded = this.elevationOverlayProvider.compositeOverlayIfNeeded(color, dimension);
            int[][] iArr = ENABLED_CHECKED_STATES;
            int[] iArr2 = new int[iArr.length];
            iArr2[0] = com.google.android.material.color.MaterialColors.layer(color, color2, 1.0f);
            iArr2[1] = compositeOverlayIfNeeded;
            iArr2[2] = com.google.android.material.color.MaterialColors.layer(color, color2, 0.38f);
            iArr2[3] = compositeOverlayIfNeeded;
            this.materialThemeColorsThumbTintList = new android.content.res.ColorStateList(iArr, iArr2);
        }
        return this.materialThemeColorsThumbTintList;
    }

    private android.content.res.ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.materialThemeColorsTrackTintList == null) {
            int[][] iArr = ENABLED_CHECKED_STATES;
            int[] iArr2 = new int[iArr.length];
            int color = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R.attr.colorSurface);
            int color2 = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R.attr.colorControlActivated);
            int color3 = com.google.android.material.color.MaterialColors.getColor(this, com.google.android.material.R.attr.colorOnSurface);
            iArr2[0] = com.google.android.material.color.MaterialColors.layer(color, color2, 0.54f);
            iArr2[1] = com.google.android.material.color.MaterialColors.layer(color, color3, 0.32f);
            iArr2[2] = com.google.android.material.color.MaterialColors.layer(color, color2, 0.12f);
            iArr2[3] = com.google.android.material.color.MaterialColors.layer(color, color3, 0.12f);
            this.materialThemeColorsTrackTintList = new android.content.res.ColorStateList(iArr, iArr2);
        }
        return this.materialThemeColorsTrackTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.useMaterialThemeColors && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.useMaterialThemeColors = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            setThumbTintList(null);
            setTrackTintList(null);
        }
    }
}
