package androidx.core.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class TextViewOnReceiveContentListener implements androidx.core.view.OnReceiveContentListener {
    private static final java.lang.String LOG_TAG = "ReceiveContent";

    @androidx.annotation.RequiresApi(16)
    public static final class Api16Impl {
        private Api16Impl() {
        }

        public static java.lang.CharSequence coerce(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.ClipData.Item item, int i) {
            if ((i & 1) == 0) {
                return item.coerceToStyledText(context);
            }
            java.lang.CharSequence coerceToText = item.coerceToText(context);
            return coerceToText instanceof android.text.Spanned ? coerceToText.toString() : coerceToText;
        }
    }

    public static final class ApiImpl {
        private ApiImpl() {
        }

        public static java.lang.CharSequence coerce(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.ClipData.Item item, int i) {
            java.lang.CharSequence coerceToText = item.coerceToText(context);
            return ((i & 1) == 0 || !(coerceToText instanceof android.text.Spanned)) ? coerceToText : coerceToText.toString();
        }
    }

    @androidx.annotation.NonNull
    private static java.lang.CharSequence coerceToText(@androidx.annotation.NonNull android.content.ClipData clipData, @androidx.annotation.NonNull android.content.Context context, int i) {
        android.text.SpannableStringBuilder spannableStringBuilder = new android.text.SpannableStringBuilder();
        for (int i2 = 0; i2 < clipData.getItemCount(); i2++) {
            java.lang.CharSequence coerceToText = coerceToText(context, clipData.getItemAt(i2), i);
            if (coerceToText != null) {
                spannableStringBuilder.append(coerceToText);
            }
        }
        return spannableStringBuilder;
    }

    private static java.lang.CharSequence coerceToText(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.NonNull android.content.ClipData.Item item, int i) {
        return androidx.core.widget.TextViewOnReceiveContentListener.Api16Impl.coerce(context, item, i);
    }

    private static void onReceiveForDragAndDrop(@androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull androidx.core.view.ContentInfoCompat contentInfoCompat) {
        replaceSelection((android.text.Editable) textView.getText(), coerceToText(contentInfoCompat.getClip(), textView.getContext(), contentInfoCompat.getFlags()));
    }

    private static void replaceSelection(@androidx.annotation.NonNull android.text.Editable editable, @androidx.annotation.NonNull java.lang.CharSequence charSequence) {
        int selectionStart = android.text.Selection.getSelectionStart(editable);
        int selectionEnd = android.text.Selection.getSelectionEnd(editable);
        int max = java.lang.Math.max(0, java.lang.Math.min(selectionStart, selectionEnd));
        int max2 = java.lang.Math.max(0, java.lang.Math.max(selectionStart, selectionEnd));
        android.text.Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    @androidx.annotation.Nullable
    public androidx.core.view.ContentInfoCompat onReceiveContent(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull androidx.core.view.ContentInfoCompat contentInfoCompat) {
        if (android.util.Log.isLoggable(LOG_TAG, 3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onReceive: ");
            sb.append(contentInfoCompat);
        }
        int source = contentInfoCompat.getSource();
        if (source == 2) {
            return contentInfoCompat;
        }
        if (source == 3) {
            onReceiveForDragAndDrop((android.widget.TextView) view, contentInfoCompat);
            return null;
        }
        android.content.ClipData clip = contentInfoCompat.getClip();
        int flags = contentInfoCompat.getFlags();
        android.widget.TextView textView = (android.widget.TextView) view;
        android.text.Editable editable = (android.text.Editable) textView.getText();
        android.content.Context context = textView.getContext();
        boolean z = false;
        for (int i = 0; i < clip.getItemCount(); i++) {
            java.lang.CharSequence coerceToText = coerceToText(context, clip.getItemAt(i), flags);
            if (coerceToText != null) {
                if (z) {
                    editable.insert(android.text.Selection.getSelectionEnd(editable), "\n");
                    editable.insert(android.text.Selection.getSelectionEnd(editable), coerceToText);
                } else {
                    replaceSelection(editable, coerceToText);
                    z = true;
                }
            }
        }
        return null;
    }
}
