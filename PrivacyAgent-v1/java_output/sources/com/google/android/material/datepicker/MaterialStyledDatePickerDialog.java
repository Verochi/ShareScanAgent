package com.google.android.material.datepicker;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP, androidx.annotation.RestrictTo.Scope.TESTS})
/* loaded from: classes22.dex */
public class MaterialStyledDatePickerDialog extends android.app.DatePickerDialog {

    @androidx.annotation.AttrRes
    private static final int DEF_STYLE_ATTR = 16843612;

    @androidx.annotation.StyleRes
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;

    @androidx.annotation.NonNull
    private final android.graphics.drawable.Drawable background;

    @androidx.annotation.NonNull
    private final android.graphics.Rect backgroundInsets;

    public MaterialStyledDatePickerDialog(@androidx.annotation.NonNull android.content.Context context) {
        this(context, 0);
    }

    public MaterialStyledDatePickerDialog(@androidx.annotation.NonNull android.content.Context context, int i) {
        this(context, i, null, -1, -1, -1);
    }

    public MaterialStyledDatePickerDialog(@androidx.annotation.NonNull android.content.Context context, int i, @androidx.annotation.Nullable android.app.DatePickerDialog.OnDateSetListener onDateSetListener, int i2, int i3, int i4) {
        super(context, i, onDateSetListener, i2, i3, i4);
        android.content.Context context2 = getContext();
        int resolveOrThrow = com.google.android.material.resources.MaterialAttributes.resolveOrThrow(getContext(), com.google.android.material.R.attr.colorSurface, getClass().getCanonicalName());
        int i5 = DEF_STYLE_RES;
        com.google.android.material.shape.MaterialShapeDrawable materialShapeDrawable = new com.google.android.material.shape.MaterialShapeDrawable(context2, null, 16843612, i5);
        materialShapeDrawable.setFillColor(android.content.res.ColorStateList.valueOf(resolveOrThrow));
        android.graphics.Rect dialogBackgroundInsets = com.google.android.material.dialog.MaterialDialogs.getDialogBackgroundInsets(context2, 16843612, i5);
        this.backgroundInsets = dialogBackgroundInsets;
        this.background = com.google.android.material.dialog.MaterialDialogs.insetDrawable(materialShapeDrawable, dialogBackgroundInsets);
    }

    public MaterialStyledDatePickerDialog(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.app.DatePickerDialog.OnDateSetListener onDateSetListener, int i, int i2, int i3) {
        this(context, 0, onDateSetListener, i, i2, i3);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.background);
        getWindow().getDecorView().setOnTouchListener(new com.google.android.material.dialog.InsetDialogOnTouchListener(this, this.backgroundInsets));
    }
}
