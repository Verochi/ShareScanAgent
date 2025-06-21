package androidx.appcompat.app;

/* loaded from: classes.dex */
public class AlertDialog extends androidx.appcompat.app.AppCompatDialog implements android.content.DialogInterface {
    static final int LAYOUT_HINT_NONE = 0;
    static final int LAYOUT_HINT_SIDE = 1;
    public static final /* synthetic */ int n = 0;
    final androidx.appcompat.app.AlertController mAlert;

    public static class Builder {
        private final androidx.appcompat.app.AlertController.AlertParams P;
        private final int mTheme;

        public Builder(@androidx.annotation.NonNull android.content.Context context) {
            this(context, androidx.appcompat.app.AlertDialog.resolveDialogTheme(context, 0));
        }

        public Builder(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.StyleRes int i) {
            this.P = new androidx.appcompat.app.AlertController.AlertParams(new android.view.ContextThemeWrapper(context, androidx.appcompat.app.AlertDialog.resolveDialogTheme(context, i)));
            this.mTheme = i;
        }

        @androidx.annotation.NonNull
        public androidx.appcompat.app.AlertDialog create() {
            androidx.appcompat.app.AlertDialog alertDialog = new androidx.appcompat.app.AlertDialog(this.P.mContext, this.mTheme);
            this.P.apply(alertDialog.mAlert);
            alertDialog.setCancelable(this.P.mCancelable);
            if (this.P.mCancelable) {
                alertDialog.setCanceledOnTouchOutside(true);
            }
            alertDialog.setOnCancelListener(this.P.mOnCancelListener);
            alertDialog.setOnDismissListener(this.P.mOnDismissListener);
            android.content.DialogInterface.OnKeyListener onKeyListener = this.P.mOnKeyListener;
            if (onKeyListener != null) {
                alertDialog.setOnKeyListener(onKeyListener);
            }
            return alertDialog;
        }

        @androidx.annotation.NonNull
        public android.content.Context getContext() {
            return this.P.mContext;
        }

        public androidx.appcompat.app.AlertDialog.Builder setAdapter(android.widget.ListAdapter listAdapter, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setCancelable(boolean z) {
            this.P.mCancelable = z;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setCursor(android.database.Cursor cursor, android.content.DialogInterface.OnClickListener onClickListener, java.lang.String str) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mLabelColumn = str;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setCustomTitle(@androidx.annotation.Nullable android.view.View view) {
            this.P.mCustomTitleView = view;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setIcon(@androidx.annotation.DrawableRes int i) {
            this.P.mIconId = i;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setIcon(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
            this.P.mIcon = drawable;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setIconAttribute(@androidx.annotation.AttrRes int i) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            this.P.mContext.getTheme().resolveAttribute(i, typedValue, true);
            this.P.mIconId = typedValue.resourceId;
            return this;
        }

        @java.lang.Deprecated
        public androidx.appcompat.app.AlertDialog.Builder setInverseBackgroundForced(boolean z) {
            this.P.mForceInverseBackground = z;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setItems(@androidx.annotation.ArrayRes int i, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            this.P.mOnClickListener = onClickListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setItems(java.lang.CharSequence[] charSequenceArr, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setMessage(@androidx.annotation.StringRes int i) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mMessage = alertParams.mContext.getText(i);
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setMessage(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.P.mMessage = charSequence;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setMultiChoiceItems(@androidx.annotation.ArrayRes int i, boolean[] zArr, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            androidx.appcompat.app.AlertController.AlertParams alertParams2 = this.P;
            alertParams2.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams2.mCheckedItems = zArr;
            alertParams2.mIsMultiChoice = true;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setMultiChoiceItems(android.database.Cursor cursor, java.lang.String str, java.lang.String str2, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mIsCheckedColumn = str;
            alertParams.mLabelColumn = str2;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setMultiChoiceItems(java.lang.CharSequence[] charSequenceArr, boolean[] zArr, android.content.DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnCheckboxClickListener = onMultiChoiceClickListener;
            alertParams.mCheckedItems = zArr;
            alertParams.mIsMultiChoice = true;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setNegativeButton(@androidx.annotation.StringRes int i, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = alertParams.mContext.getText(i);
            this.P.mNegativeButtonListener = onClickListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setNegativeButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mNegativeButtonText = charSequence;
            alertParams.mNegativeButtonListener = onClickListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setNegativeButtonIcon(android.graphics.drawable.Drawable drawable) {
            this.P.mNegativeButtonIcon = drawable;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setNeutralButton(@androidx.annotation.StringRes int i, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mNeutralButtonText = alertParams.mContext.getText(i);
            this.P.mNeutralButtonListener = onClickListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setNeutralButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mNeutralButtonText = charSequence;
            alertParams.mNeutralButtonListener = onClickListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setNeutralButtonIcon(android.graphics.drawable.Drawable drawable) {
            this.P.mNeutralButtonIcon = drawable;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setOnCancelListener(android.content.DialogInterface.OnCancelListener onCancelListener) {
            this.P.mOnCancelListener = onCancelListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setOnDismissListener(android.content.DialogInterface.OnDismissListener onDismissListener) {
            this.P.mOnDismissListener = onDismissListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setOnItemSelectedListener(android.widget.AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.P.mOnItemSelectedListener = onItemSelectedListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setOnKeyListener(android.content.DialogInterface.OnKeyListener onKeyListener) {
            this.P.mOnKeyListener = onKeyListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setPositiveButton(@androidx.annotation.StringRes int i, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = alertParams.mContext.getText(i);
            this.P.mPositiveButtonListener = onClickListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setPositiveButton(java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mPositiveButtonText = charSequence;
            alertParams.mPositiveButtonListener = onClickListener;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setPositiveButtonIcon(android.graphics.drawable.Drawable drawable) {
            this.P.mPositiveButtonIcon = drawable;
            return this;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public androidx.appcompat.app.AlertDialog.Builder setRecycleOnMeasureEnabled(boolean z) {
            this.P.mRecycleOnMeasure = z;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setSingleChoiceItems(@androidx.annotation.ArrayRes int i, int i2, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = alertParams.mContext.getResources().getTextArray(i);
            androidx.appcompat.app.AlertController.AlertParams alertParams2 = this.P;
            alertParams2.mOnClickListener = onClickListener;
            alertParams2.mCheckedItem = i2;
            alertParams2.mIsSingleChoice = true;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setSingleChoiceItems(android.database.Cursor cursor, int i, java.lang.String str, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mCursor = cursor;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i;
            alertParams.mLabelColumn = str;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setSingleChoiceItems(android.widget.ListAdapter listAdapter, int i, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mAdapter = listAdapter;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setSingleChoiceItems(java.lang.CharSequence[] charSequenceArr, int i, android.content.DialogInterface.OnClickListener onClickListener) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mItems = charSequenceArr;
            alertParams.mOnClickListener = onClickListener;
            alertParams.mCheckedItem = i;
            alertParams.mIsSingleChoice = true;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setTitle(@androidx.annotation.StringRes int i) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mTitle = alertParams.mContext.getText(i);
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setTitle(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
            this.P.mTitle = charSequence;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setView(int i) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mView = null;
            alertParams.mViewLayoutResId = i;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        public androidx.appcompat.app.AlertDialog.Builder setView(android.view.View view) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            alertParams.mViewSpacingSpecified = false;
            return this;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @java.lang.Deprecated
        public androidx.appcompat.app.AlertDialog.Builder setView(android.view.View view, int i, int i2, int i3, int i4) {
            androidx.appcompat.app.AlertController.AlertParams alertParams = this.P;
            alertParams.mView = view;
            alertParams.mViewLayoutResId = 0;
            alertParams.mViewSpacingSpecified = true;
            alertParams.mViewSpacingLeft = i;
            alertParams.mViewSpacingTop = i2;
            alertParams.mViewSpacingRight = i3;
            alertParams.mViewSpacingBottom = i4;
            return this;
        }

        public androidx.appcompat.app.AlertDialog show() {
            androidx.appcompat.app.AlertDialog create = create();
            create.show();
            return create;
        }
    }

    public AlertDialog(@androidx.annotation.NonNull android.content.Context context) {
        this(context, 0);
    }

    public AlertDialog(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.StyleRes int i) {
        super(context, resolveDialogTheme(context, i));
        this.mAlert = new androidx.appcompat.app.AlertController(getContext(), this, getWindow());
    }

    public AlertDialog(@androidx.annotation.NonNull android.content.Context context, boolean z, @androidx.annotation.Nullable android.content.DialogInterface.OnCancelListener onCancelListener) {
        this(context, 0);
        setCancelable(z);
        setOnCancelListener(onCancelListener);
    }

    public static int resolveDialogTheme(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.StyleRes int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        context.getTheme().resolveAttribute(androidx.appcompat.R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public android.widget.Button getButton(int i) {
        return this.mAlert.getButton(i);
    }

    public android.widget.ListView getListView() {
        return this.mAlert.getListView();
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.mAlert.installContent();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (this.mAlert.onKeyDown(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        if (this.mAlert.onKeyUp(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void setButton(int i, java.lang.CharSequence charSequence, android.content.DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, null, null);
    }

    public void setButton(int i, java.lang.CharSequence charSequence, android.graphics.drawable.Drawable drawable, android.content.DialogInterface.OnClickListener onClickListener) {
        this.mAlert.setButton(i, charSequence, onClickListener, null, drawable);
    }

    public void setButton(int i, java.lang.CharSequence charSequence, android.os.Message message) {
        this.mAlert.setButton(i, charSequence, null, message, null);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setButtonPanelLayoutHint(int i) {
        this.mAlert.setButtonPanelLayoutHint(i);
    }

    public void setCustomTitle(android.view.View view) {
        this.mAlert.setCustomTitle(view);
    }

    public void setIcon(int i) {
        this.mAlert.setIcon(i);
    }

    public void setIcon(android.graphics.drawable.Drawable drawable) {
        this.mAlert.setIcon(drawable);
    }

    public void setIconAttribute(int i) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        getContext().getTheme().resolveAttribute(i, typedValue, true);
        this.mAlert.setIcon(typedValue.resourceId);
    }

    public void setMessage(java.lang.CharSequence charSequence) {
        this.mAlert.setMessage(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setTitle(java.lang.CharSequence charSequence) {
        super.setTitle(charSequence);
        this.mAlert.setTitle(charSequence);
    }

    public void setView(android.view.View view) {
        this.mAlert.setView(view);
    }

    public void setView(android.view.View view, int i, int i2, int i3, int i4) {
        this.mAlert.setView(view, i, i2, i3, i4);
    }
}
