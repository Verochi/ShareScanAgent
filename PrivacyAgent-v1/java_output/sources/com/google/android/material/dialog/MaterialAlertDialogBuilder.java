package com.google.android.material.dialog;

/* loaded from: classes22.dex */
public class MaterialAlertDialogBuilder extends androidx.appcompat.app.AlertDialog.Builder {

    @androidx.annotation.AttrRes
    private static final int DEF_STYLE_ATTR = com.google.android.material.R.attr.alertDialogStyle;

    @androidx.annotation.StyleRes
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.MaterialAlertDialog_MaterialComponents;

    @androidx.annotation.AttrRes
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = com.google.android.material.R.attr.materialAlertDialogTheme;

    @androidx.annotation.Nullable
    private android.graphics.drawable.Drawable background;

    @androidx.annotation.NonNull
    @androidx.annotation.Dimension
    private final android.graphics.Rect backgroundInsets;

    public MaterialAlertDialogBuilder(@androidx.annotation.NonNull android.content.Context context) {
        this(context, 0);
    }

    public MaterialAlertDialogBuilder(@androidx.annotation.NonNull android.content.Context context, int i) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, i));
        android.content.Context context2 = getContext();
        android.content.res.Resources.Theme theme = context2.getTheme();
        int i2 = DEF_STYLE_ATTR;
        int i3 = DEF_STYLE_RES;
        this.backgroundInsets = com.google.android.material.dialog.MaterialDialogs.getDialogBackgroundInsets(context2, i2, i3);
        int color = com.google.android.material.color.MaterialColors.getColor(context2, com.google.android.material.R.attr.colorSurface, getClass().getCanonicalName());
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(context2, null, i2, i3);
        materialShapeDrawable.initializeElevationOverlay(context2);
        materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(color));
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    private static android.content.Context createMaterialAlertDialogThemedContext(@androidx.annotation.NonNull android.content.Context context) {
        int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
        android.content.Context wrap = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        return materialAlertDialogThemeOverlay == 0 ? wrap : new androidx.appcompat.view.ContextThemeWrapper(wrap, materialAlertDialogThemeOverlay);
    }

    private static int getMaterialAlertDialogThemeOverlay(@androidx.annotation.NonNull android.content.Context context) {
        android.util.TypedValue resolve = com.google.android.material.resources.MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    private static int getOverridingThemeResId(@androidx.annotation.NonNull android.content.Context context, int i) {
        return i == 0 ? getMaterialAlertDialogThemeOverlay(context) : i;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public androidx.appcompat.app.AlertDialog create() {
        androidx.appcompat.app.AlertDialog create = super.create();
        android.view.Window window = create.getWindow();
        android.view.View decorView = window.getDecorView();
        android.graphics.drawable.Drawable drawable = this.background;
        if (drawable instanceof com.google.android.material.shape.MaterialShapeDrawable) {
            ((com.google.android.material.shape.MaterialShapeDrawable) drawable).setElevation(androidx.core.view.ViewCompat.getElevation(decorView));
        }
        window.setBackgroundDrawable(com.google.android.material.dialog.MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        decorView.setOnTouchListener(new com.google.android.material.dialog.InsetDialogOnTouchListener(create, this.backgroundInsets));
        return create;
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getBackground() {
        return this.background;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setAdapter(@androidx.annotation.Nullable android.widget.ListAdapter listAdapter, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setAdapter(listAdapter, onClickListener);
    }

    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setBackground(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        this.background = drawable;
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setBackgroundInsetBottom(@androidx.annotation.Px int i) {
        this.backgroundInsets.bottom = i;
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setBackgroundInsetEnd(@androidx.annotation.Px int i) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.left = i;
        } else {
            this.backgroundInsets.right = i;
        }
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setBackgroundInsetStart(@androidx.annotation.Px int i) {
        if (getContext().getResources().getConfiguration().getLayoutDirection() == 1) {
            this.backgroundInsets.right = i;
        } else {
            this.backgroundInsets.left = i;
        }
        return this;
    }

    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setBackgroundInsetTop(@androidx.annotation.Px int i) {
        this.backgroundInsets.top = i;
        return this;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setCancelable(boolean z) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setCancelable(z);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setCursor(@androidx.annotation.Nullable android.database.Cursor cursor, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener, @androidx.annotation.NonNull java.lang.String str) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setCursor(cursor, onClickListener, str);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setCustomTitle(@androidx.annotation.Nullable android.view.View view) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setCustomTitle(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setIcon(@androidx.annotation.DrawableRes int i) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setIcon(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setIconAttribute(@androidx.annotation.AttrRes int i) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setIconAttribute(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setItems(@androidx.annotation.ArrayRes int i, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setItems(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setItems(@androidx.annotation.Nullable java.lang.CharSequence[] charSequenceArr, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setItems(charSequenceArr, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setMessage(@androidx.annotation.StringRes int i) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setMessage(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setMessage(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setMultiChoiceItems(@androidx.annotation.ArrayRes int i, @androidx.annotation.Nullable boolean[] zArr, @androidx.annotation.Nullable android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setMultiChoiceItems(i, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setMultiChoiceItems(@androidx.annotation.Nullable android.database.Cursor cursor, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.lang.String str2, @androidx.annotation.Nullable android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setMultiChoiceItems(@androidx.annotation.Nullable java.lang.CharSequence[] charSequenceArr, @androidx.annotation.Nullable boolean[] zArr, @androidx.annotation.Nullable android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNegativeButton(@androidx.annotation.StringRes int i, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNegativeButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNegativeButton(@androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNegativeButtonIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNeutralButton(@androidx.annotation.StringRes int i, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNeutralButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNeutralButton(@androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setNeutralButtonIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setOnCancelListener(@androidx.annotation.Nullable android.content.DialogInterface.OnCancelListener onCancelListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setOnCancelListener(onCancelListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setOnDismissListener(@androidx.annotation.Nullable android.content.DialogInterface.OnDismissListener onDismissListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setOnDismissListener(onDismissListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setOnItemSelectedListener(@androidx.annotation.Nullable android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setOnKeyListener(@androidx.annotation.Nullable android.content.DialogInterface.OnKeyListener onKeyListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setOnKeyListener(onKeyListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setPositiveButton(@androidx.annotation.StringRes int i, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setPositiveButton(i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setPositiveButton(@androidx.annotation.Nullable java.lang.CharSequence charSequence, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setPositiveButtonIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setSingleChoiceItems(@androidx.annotation.ArrayRes int i, int i2, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setSingleChoiceItems(i, i2, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setSingleChoiceItems(@androidx.annotation.Nullable android.database.Cursor cursor, int i, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, i, str, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setSingleChoiceItems(@androidx.annotation.Nullable android.widget.ListAdapter listAdapter, int i, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setSingleChoiceItems(@androidx.annotation.Nullable java.lang.CharSequence[] charSequenceArr, int i, @androidx.annotation.Nullable android.content.DialogInterface.OnClickListener onClickListener) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, i, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setTitle(@androidx.annotation.StringRes int i) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setTitle(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setView(int i) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setView(i);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    @androidx.annotation.NonNull
    public com.google.android.material.dialog.MaterialAlertDialogBuilder setView(@androidx.annotation.Nullable android.view.View view) {
        return (com.google.android.material.dialog.MaterialAlertDialogBuilder) super.setView(view);
    }
}
