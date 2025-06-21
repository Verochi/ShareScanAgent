package androidx.appcompat.widget;

/* loaded from: classes.dex */
final class AppCompatReceiveContentHelper {
    private static final java.lang.String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    private static final java.lang.String LOG_TAG = "ReceiveContent";

    /* renamed from: androidx.appcompat.widget.AppCompatReceiveContentHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener {
        final /* synthetic */ android.view.View val$view;

        public AnonymousClass1(android.view.View view) {
            this.val$view = view;
        }

        @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
        public boolean onCommitContent(androidx.core.view.inputmethod.InputContentInfoCompat inputContentInfoCompat, int i, android.os.Bundle bundle) {
            if (android.os.Build.VERSION.SDK_INT >= 25 && (i & 1) != 0) {
                try {
                    inputContentInfoCompat.requestPermission();
                    android.view.inputmethod.InputContentInfo inputContentInfo = (android.view.inputmethod.InputContentInfo) inputContentInfoCompat.unwrap();
                    bundle = bundle == null ? new android.os.Bundle() : new android.os.Bundle(bundle);
                    bundle.putParcelable(androidx.appcompat.widget.AppCompatReceiveContentHelper.EXTRA_INPUT_CONTENT_INFO, inputContentInfo);
                } catch (java.lang.Exception unused) {
                    return false;
                }
            }
            return androidx.core.view.ViewCompat.performReceiveContent(this.val$view, new androidx.core.view.ContentInfoCompat.Builder(new android.content.ClipData(inputContentInfoCompat.getDescription(), new android.content.ClipData.Item(inputContentInfoCompat.getContentUri())), 2).setLinkUri(inputContentInfoCompat.getLinkUri()).setExtras(bundle).build()) == null;
        }
    }

    @androidx.annotation.RequiresApi(24)
    public static final class OnDropApi24Impl {
        private OnDropApi24Impl() {
        }

        public static boolean onDropForTextView(@androidx.annotation.NonNull android.view.DragEvent dragEvent, @androidx.annotation.NonNull android.widget.TextView textView, @androidx.annotation.NonNull android.app.Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
            textView.beginBatchEdit();
            try {
                android.text.Selection.setSelection((android.text.Spannable) textView.getText(), offsetForPosition);
                androidx.core.view.ViewCompat.performReceiveContent(textView, new androidx.core.view.ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
                textView.endBatchEdit();
                return true;
            } catch (java.lang.Throwable th) {
                textView.endBatchEdit();
                throw th;
            }
        }

        public static boolean onDropForView(@androidx.annotation.NonNull android.view.DragEvent dragEvent, @androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.app.Activity activity) {
            activity.requestDragAndDropPermissions(dragEvent);
            androidx.core.view.ViewCompat.performReceiveContent(view, new androidx.core.view.ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
            return true;
        }
    }

    private AppCompatReceiveContentHelper() {
    }

    @androidx.annotation.NonNull
    public static androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener createOnCommitContentListener(@androidx.annotation.NonNull android.view.View view) {
        return new androidx.appcompat.widget.AppCompatReceiveContentHelper.AnonymousClass1(view);
    }

    public static boolean maybeHandleDragEventViaPerformReceiveContent(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.NonNull android.view.DragEvent dragEvent) {
        if (android.os.Build.VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null && androidx.core.view.ViewCompat.getOnReceiveContentMimeTypes(view) != null) {
            android.app.Activity tryGetActivity = tryGetActivity(view);
            if (tryGetActivity == null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Can't handle drop: no activity: view=");
                sb.append(view);
                return false;
            }
            if (dragEvent.getAction() == 1) {
                return !(view instanceof android.widget.TextView);
            }
            if (dragEvent.getAction() == 3) {
                return view instanceof android.widget.TextView ? androidx.appcompat.widget.AppCompatReceiveContentHelper.OnDropApi24Impl.onDropForTextView(dragEvent, (android.widget.TextView) view, tryGetActivity) : androidx.appcompat.widget.AppCompatReceiveContentHelper.OnDropApi24Impl.onDropForView(dragEvent, view, tryGetActivity);
            }
        }
        return false;
    }

    public static boolean maybeHandleMenuActionViaPerformReceiveContent(@androidx.annotation.NonNull android.widget.TextView textView, int i) {
        if ((i != 16908322 && i != 16908337) || androidx.core.view.ViewCompat.getOnReceiveContentMimeTypes(textView) == null) {
            return false;
        }
        android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) textView.getContext().getSystemService("clipboard");
        android.content.ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            androidx.core.view.ViewCompat.performReceiveContent(textView, new androidx.core.view.ContentInfoCompat.Builder(primaryClip, 1).setFlags(i != 16908322 ? 1 : 0).build());
        }
        return true;
    }

    @androidx.annotation.Nullable
    public static android.app.Activity tryGetActivity(@androidx.annotation.NonNull android.view.View view) {
        for (android.content.Context context = view.getContext(); context instanceof android.content.ContextWrapper; context = ((android.content.ContextWrapper) context).getBaseContext()) {
            if (context instanceof android.app.Activity) {
                return (android.app.Activity) context;
            }
        }
        return null;
    }
}
