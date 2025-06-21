package androidx.appcompat.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final android.graphics.PorterDuff.Mode DEFAULT_MODE = android.graphics.PorterDuff.Mode.SRC_IN;
    private static androidx.appcompat.widget.AppCompatDrawableManager INSTANCE = null;
    private static final java.lang.String TAG = "AppCompatDrawableManag";
    private androidx.appcompat.widget.ResourceManagerInternal mResourceManager;

    /* renamed from: androidx.appcompat.widget.AppCompatDrawableManager$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks {
        private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL = {androidx.appcompat.R.drawable.abc_textfield_search_default_mtrl_alpha, androidx.appcompat.R.drawable.abc_textfield_default_mtrl_alpha, androidx.appcompat.R.drawable.abc_ab_share_pack_mtrl_alpha};
        private final int[] TINT_COLOR_CONTROL_NORMAL = {androidx.appcompat.R.drawable.abc_ic_commit_search_api_mtrl_alpha, androidx.appcompat.R.drawable.abc_seekbar_tick_mark_material, androidx.appcompat.R.drawable.abc_ic_menu_share_mtrl_alpha, androidx.appcompat.R.drawable.abc_ic_menu_copy_mtrl_am_alpha, androidx.appcompat.R.drawable.abc_ic_menu_cut_mtrl_alpha, androidx.appcompat.R.drawable.abc_ic_menu_selectall_mtrl_alpha, androidx.appcompat.R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
        private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED = {androidx.appcompat.R.drawable.abc_textfield_activated_mtrl_alpha, androidx.appcompat.R.drawable.abc_textfield_search_activated_mtrl_alpha, androidx.appcompat.R.drawable.abc_cab_background_top_mtrl_alpha, androidx.appcompat.R.drawable.abc_text_cursor_material, androidx.appcompat.R.drawable.abc_text_select_handle_left_mtrl, androidx.appcompat.R.drawable.abc_text_select_handle_middle_mtrl, androidx.appcompat.R.drawable.abc_text_select_handle_right_mtrl};
        private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY = {androidx.appcompat.R.drawable.abc_popup_background_mtrl_mult, androidx.appcompat.R.drawable.abc_cab_background_internal_bg, androidx.appcompat.R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        private final int[] TINT_COLOR_CONTROL_STATE_LIST = {androidx.appcompat.R.drawable.abc_tab_indicator_material, androidx.appcompat.R.drawable.abc_textfield_search_material};
        private final int[] TINT_CHECKABLE_BUTTON_LIST = {androidx.appcompat.R.drawable.abc_btn_check_material, androidx.appcompat.R.drawable.abc_btn_radio_material, androidx.appcompat.R.drawable.abc_btn_check_material_anim, androidx.appcompat.R.drawable.abc_btn_radio_material_anim};

        private boolean arrayContains(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        private android.content.res.ColorStateList createBorderlessButtonColorStateList(@androidx.annotation.NonNull android.content.Context context) {
            return createButtonColorStateList(context, 0);
        }

        private android.content.res.ColorStateList createButtonColorStateList(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.ColorInt int i) {
            int themeAttrColor = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, androidx.appcompat.R.attr.colorControlHighlight);
            return new android.content.res.ColorStateList(new int[][]{androidx.appcompat.widget.ThemeUtils.DISABLED_STATE_SET, androidx.appcompat.widget.ThemeUtils.PRESSED_STATE_SET, androidx.appcompat.widget.ThemeUtils.FOCUSED_STATE_SET, androidx.appcompat.widget.ThemeUtils.EMPTY_STATE_SET}, new int[]{androidx.appcompat.widget.ThemeUtils.getDisabledThemeAttrColor(context, androidx.appcompat.R.attr.colorButtonNormal), androidx.core.graphics.ColorUtils.compositeColors(themeAttrColor, i), androidx.core.graphics.ColorUtils.compositeColors(themeAttrColor, i), i});
        }

        private android.content.res.ColorStateList createColoredButtonColorStateList(@androidx.annotation.NonNull android.content.Context context) {
            return createButtonColorStateList(context, androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, androidx.appcompat.R.attr.colorAccent));
        }

        private android.content.res.ColorStateList createDefaultButtonColorStateList(@androidx.annotation.NonNull android.content.Context context) {
            return createButtonColorStateList(context, androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, androidx.appcompat.R.attr.colorButtonNormal));
        }

        private android.content.res.ColorStateList createSwitchThumbColorStateList(android.content.Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i = androidx.appcompat.R.attr.colorSwitchThumbNormal;
            android.content.res.ColorStateList themeAttrColorStateList = androidx.appcompat.widget.ThemeUtils.getThemeAttrColorStateList(context, i);
            if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                iArr[0] = androidx.appcompat.widget.ThemeUtils.DISABLED_STATE_SET;
                iArr2[0] = androidx.appcompat.widget.ThemeUtils.getDisabledThemeAttrColor(context, i);
                iArr[1] = androidx.appcompat.widget.ThemeUtils.CHECKED_STATE_SET;
                iArr2[1] = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, androidx.appcompat.R.attr.colorControlActivated);
                iArr[2] = androidx.appcompat.widget.ThemeUtils.EMPTY_STATE_SET;
                iArr2[2] = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, i);
            } else {
                int[] iArr3 = androidx.appcompat.widget.ThemeUtils.DISABLED_STATE_SET;
                iArr[0] = iArr3;
                iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
                iArr[1] = androidx.appcompat.widget.ThemeUtils.CHECKED_STATE_SET;
                iArr2[1] = androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, androidx.appcompat.R.attr.colorControlActivated);
                iArr[2] = androidx.appcompat.widget.ThemeUtils.EMPTY_STATE_SET;
                iArr2[2] = themeAttrColorStateList.getDefaultColor();
            }
            return new android.content.res.ColorStateList(iArr, iArr2);
        }

        private android.graphics.drawable.LayerDrawable getRatingBarLayerDrawable(@androidx.annotation.NonNull androidx.appcompat.widget.ResourceManagerInternal resourceManagerInternal, @androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DimenRes int i) {
            android.graphics.drawable.BitmapDrawable bitmapDrawable;
            android.graphics.drawable.BitmapDrawable bitmapDrawable2;
            android.graphics.drawable.BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            android.graphics.drawable.Drawable drawable = resourceManagerInternal.getDrawable(context, androidx.appcompat.R.drawable.abc_star_black_48dp);
            android.graphics.drawable.Drawable drawable2 = resourceManagerInternal.getDrawable(context, androidx.appcompat.R.drawable.abc_star_half_black_48dp);
            if ((drawable instanceof android.graphics.drawable.BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (android.graphics.drawable.BitmapDrawable) drawable;
                bitmapDrawable2 = new android.graphics.drawable.BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, android.graphics.Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable.draw(canvas);
                bitmapDrawable = new android.graphics.drawable.BitmapDrawable(createBitmap);
                bitmapDrawable2 = new android.graphics.drawable.BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(android.graphics.Shader.TileMode.REPEAT);
            if ((drawable2 instanceof android.graphics.drawable.BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (android.graphics.drawable.BitmapDrawable) drawable2;
            } else {
                android.graphics.Bitmap createBitmap2 = android.graphics.Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, android.graphics.Bitmap.Config.ARGB_8888);
                android.graphics.Canvas canvas2 = new android.graphics.Canvas(createBitmap2);
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable2.draw(canvas2);
                bitmapDrawable3 = new android.graphics.drawable.BitmapDrawable(createBitmap2);
            }
            android.graphics.drawable.LayerDrawable layerDrawable = new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        private void setPorterDuffColorFilter(android.graphics.drawable.Drawable drawable, int i, android.graphics.PorterDuff.Mode mode) {
            if (androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE;
            }
            drawable.setColorFilter(androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public android.graphics.drawable.Drawable createDrawableFor(@androidx.annotation.NonNull androidx.appcompat.widget.ResourceManagerInternal resourceManagerInternal, @androidx.annotation.NonNull android.content.Context context, int i) {
            if (i == androidx.appcompat.R.drawable.abc_cab_background_top_material) {
                return new android.graphics.drawable.LayerDrawable(new android.graphics.drawable.Drawable[]{resourceManagerInternal.getDrawable(context, androidx.appcompat.R.drawable.abc_cab_background_internal_bg), resourceManagerInternal.getDrawable(context, androidx.appcompat.R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i == androidx.appcompat.R.drawable.abc_ratingbar_material) {
                return getRatingBarLayerDrawable(resourceManagerInternal, context, androidx.appcompat.R.dimen.abc_star_big);
            }
            if (i == androidx.appcompat.R.drawable.abc_ratingbar_indicator_material) {
                return getRatingBarLayerDrawable(resourceManagerInternal, context, androidx.appcompat.R.dimen.abc_star_medium);
            }
            if (i == androidx.appcompat.R.drawable.abc_ratingbar_small_material) {
                return getRatingBarLayerDrawable(resourceManagerInternal, context, androidx.appcompat.R.dimen.abc_star_small);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public android.content.res.ColorStateList getTintListForDrawableRes(@androidx.annotation.NonNull android.content.Context context, int i) {
            if (i == androidx.appcompat.R.drawable.abc_edit_text_material) {
                return androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, androidx.appcompat.R.color.abc_tint_edittext);
            }
            if (i == androidx.appcompat.R.drawable.abc_switch_track_mtrl_alpha) {
                return androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, androidx.appcompat.R.color.abc_tint_switch_track);
            }
            if (i == androidx.appcompat.R.drawable.abc_switch_thumb_material) {
                return createSwitchThumbColorStateList(context);
            }
            if (i == androidx.appcompat.R.drawable.abc_btn_default_mtrl_shape) {
                return createDefaultButtonColorStateList(context);
            }
            if (i == androidx.appcompat.R.drawable.abc_btn_borderless_material) {
                return createBorderlessButtonColorStateList(context);
            }
            if (i == androidx.appcompat.R.drawable.abc_btn_colored_material) {
                return createColoredButtonColorStateList(context);
            }
            if (i == androidx.appcompat.R.drawable.abc_spinner_mtrl_am_alpha || i == androidx.appcompat.R.drawable.abc_spinner_textfield_background_material) {
                return androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, androidx.appcompat.R.color.abc_tint_spinner);
            }
            if (arrayContains(this.TINT_COLOR_CONTROL_NORMAL, i)) {
                return androidx.appcompat.widget.ThemeUtils.getThemeAttrColorStateList(context, androidx.appcompat.R.attr.colorControlNormal);
            }
            if (arrayContains(this.TINT_COLOR_CONTROL_STATE_LIST, i)) {
                return androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, androidx.appcompat.R.color.abc_tint_default);
            }
            if (arrayContains(this.TINT_CHECKABLE_BUTTON_LIST, i)) {
                return androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, androidx.appcompat.R.color.abc_tint_btn_checkable);
            }
            if (i == androidx.appcompat.R.drawable.abc_seekbar_thumb_material) {
                return androidx.appcompat.content.res.AppCompatResources.getColorStateList(context, androidx.appcompat.R.color.abc_tint_seek_thumb);
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public android.graphics.PorterDuff.Mode getTintModeForDrawableRes(int i) {
            if (i == androidx.appcompat.R.drawable.abc_switch_thumb_material) {
                return android.graphics.PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        public boolean tintDrawable(@androidx.annotation.NonNull android.content.Context context, int i, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            if (i == androidx.appcompat.R.drawable.abc_seekbar_track_material) {
                android.graphics.drawable.LayerDrawable layerDrawable = (android.graphics.drawable.LayerDrawable) drawable;
                android.graphics.drawable.Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int i2 = androidx.appcompat.R.attr.colorControlNormal;
                setPorterDuffColorFilter(findDrawableByLayerId, androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, i2), androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE);
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, i2), androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE);
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(android.R.id.progress), androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, androidx.appcompat.R.attr.colorControlActivated), androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE);
                return true;
            }
            if (i != androidx.appcompat.R.drawable.abc_ratingbar_material && i != androidx.appcompat.R.drawable.abc_ratingbar_indicator_material && i != androidx.appcompat.R.drawable.abc_ratingbar_small_material) {
                return false;
            }
            android.graphics.drawable.LayerDrawable layerDrawable2 = (android.graphics.drawable.LayerDrawable) drawable;
            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.background), androidx.appcompat.widget.ThemeUtils.getDisabledThemeAttrColor(context, androidx.appcompat.R.attr.colorControlNormal), androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE);
            android.graphics.drawable.Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress);
            int i3 = androidx.appcompat.R.attr.colorControlActivated;
            setPorterDuffColorFilter(findDrawableByLayerId2, androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, i3), androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE);
            setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(android.R.id.progress), androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, i3), androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x006d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0052  */
        @Override // androidx.appcompat.widget.ResourceManagerInternal.ResourceManagerHooks
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean tintDrawableUsingColorFilter(@androidx.annotation.NonNull android.content.Context context, int i, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
            android.graphics.PorterDuff.Mode mode;
            int i2;
            int i3;
            boolean z;
            android.graphics.PorterDuff.Mode mode2 = androidx.appcompat.widget.AppCompatDrawableManager.DEFAULT_MODE;
            if (arrayContains(this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
                i2 = androidx.appcompat.R.attr.colorControlNormal;
            } else if (arrayContains(this.COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
                i2 = androidx.appcompat.R.attr.colorControlActivated;
            } else {
                if (!arrayContains(this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
                    if (i == androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha) {
                        mode = mode2;
                        z = true;
                        i3 = java.lang.Math.round(40.8f);
                        i2 = android.R.attr.colorForeground;
                    } else if (i != androidx.appcompat.R.drawable.abc_dialog_material_background) {
                        mode = mode2;
                        i2 = 0;
                        i3 = -1;
                        z = false;
                    }
                    if (!z) {
                        return false;
                    }
                    if (androidx.appcompat.widget.DrawableUtils.canSafelyMutateDrawable(drawable)) {
                        drawable = drawable.mutate();
                    }
                    drawable.setColorFilter(androidx.appcompat.widget.AppCompatDrawableManager.getPorterDuffColorFilter(androidx.appcompat.widget.ThemeUtils.getThemeAttrColor(context, i2), mode));
                    if (i3 != -1) {
                        drawable.setAlpha(i3);
                    }
                    return true;
                }
                mode2 = android.graphics.PorterDuff.Mode.MULTIPLY;
                mode = mode2;
                i2 = android.R.attr.colorBackground;
                i3 = -1;
                z = true;
                if (!z) {
                }
            }
            mode = mode2;
            i3 = -1;
            z = true;
            if (!z) {
            }
        }
    }

    public static synchronized androidx.appcompat.widget.AppCompatDrawableManager get() {
        androidx.appcompat.widget.AppCompatDrawableManager appCompatDrawableManager;
        synchronized (androidx.appcompat.widget.AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                preload();
            }
            appCompatDrawableManager = INSTANCE;
        }
        return appCompatDrawableManager;
    }

    public static synchronized android.graphics.PorterDuffColorFilter getPorterDuffColorFilter(int i, android.graphics.PorterDuff.Mode mode) {
        android.graphics.PorterDuffColorFilter porterDuffColorFilter;
        synchronized (androidx.appcompat.widget.AppCompatDrawableManager.class) {
            porterDuffColorFilter = androidx.appcompat.widget.ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    public static synchronized void preload() {
        synchronized (androidx.appcompat.widget.AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                androidx.appcompat.widget.AppCompatDrawableManager appCompatDrawableManager = new androidx.appcompat.widget.AppCompatDrawableManager();
                INSTANCE = appCompatDrawableManager;
                appCompatDrawableManager.mResourceManager = androidx.appcompat.widget.ResourceManagerInternal.get();
                INSTANCE.mResourceManager.setHooks(new androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1());
            }
        }
    }

    public static void tintDrawable(android.graphics.drawable.Drawable drawable, androidx.appcompat.widget.TintInfo tintInfo, int[] iArr) {
        androidx.appcompat.widget.ResourceManagerInternal.tintDrawable(drawable, tintInfo, iArr);
    }

    public synchronized android.graphics.drawable.Drawable getDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i) {
        return this.mResourceManager.getDrawable(context, i);
    }

    public synchronized android.graphics.drawable.Drawable getDrawable(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i, boolean z) {
        return this.mResourceManager.getDrawable(context, i, z);
    }

    public synchronized android.content.res.ColorStateList getTintList(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i) {
        return this.mResourceManager.getTintList(context, i);
    }

    public synchronized void onConfigurationChanged(@androidx.annotation.NonNull android.content.Context context) {
        this.mResourceManager.onConfigurationChanged(context);
    }

    public synchronized android.graphics.drawable.Drawable onDrawableLoadedFromResources(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull androidx.appcompat.widget.VectorEnabledTintResources vectorEnabledTintResources, @androidx.annotation.DrawableRes int i) {
        return this.mResourceManager.onDrawableLoadedFromResources(context, vectorEnabledTintResources, i);
    }

    public boolean tintDrawableUsingColorFilter(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.DrawableRes int i, @androidx.annotation.NonNull android.graphics.drawable.Drawable drawable) {
        return this.mResourceManager.tintDrawableUsingColorFilter(context, i, drawable);
    }
}
