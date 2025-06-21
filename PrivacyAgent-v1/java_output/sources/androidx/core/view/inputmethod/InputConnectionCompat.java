package androidx.core.view.inputmethod;

/* loaded from: classes.dex */
public final class InputConnectionCompat {
    private static final java.lang.String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final java.lang.String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final java.lang.String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final java.lang.String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final java.lang.String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final java.lang.String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final java.lang.String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final java.lang.String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final java.lang.String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final java.lang.String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final java.lang.String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final java.lang.String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final java.lang.String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final java.lang.String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    /* renamed from: androidx.core.view.inputmethod.InputConnectionCompat$1, reason: invalid class name */
    public class AnonymousClass1 extends android.view.inputmethod.InputConnectionWrapper {
        final /* synthetic */ androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener val$listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(android.view.inputmethod.InputConnection inputConnection, boolean z, androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener onCommitContentListener) {
            super(inputConnection, z);
            this.val$listener = onCommitContentListener;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitContent(android.view.inputmethod.InputContentInfo inputContentInfo, int i, android.os.Bundle bundle) {
            if (this.val$listener.onCommitContent(androidx.core.view.inputmethod.InputContentInfoCompat.wrap(inputContentInfo), i, bundle)) {
                return true;
            }
            return super.commitContent(inputContentInfo, i, bundle);
        }
    }

    /* renamed from: androidx.core.view.inputmethod.InputConnectionCompat$2, reason: invalid class name */
    public class AnonymousClass2 extends android.view.inputmethod.InputConnectionWrapper {
        final /* synthetic */ androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener val$listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(android.view.inputmethod.InputConnection inputConnection, boolean z, androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener onCommitContentListener) {
            super(inputConnection, z);
            this.val$listener = onCommitContentListener;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean performPrivateCommand(java.lang.String str, android.os.Bundle bundle) {
            if (androidx.core.view.inputmethod.InputConnectionCompat.handlePerformPrivateCommand(str, bundle, this.val$listener)) {
                return true;
            }
            return super.performPrivateCommand(str, bundle);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(androidx.core.view.inputmethod.InputContentInfoCompat inputContentInfoCompat, int i, android.os.Bundle bundle);
    }

    @java.lang.Deprecated
    public InputConnectionCompat() {
    }

    public static boolean commitContent(@androidx.annotation.NonNull android.view.inputmethod.InputConnection inputConnection, @androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, @androidx.annotation.NonNull androidx.core.view.inputmethod.InputContentInfoCompat inputContentInfoCompat, int i, @androidx.annotation.Nullable android.os.Bundle bundle) {
        boolean z;
        boolean commitContent;
        android.content.ClipDescription description = inputContentInfoCompat.getDescription();
        java.lang.String[] contentMimeTypes = androidx.core.view.inputmethod.EditorInfoCompat.getContentMimeTypes(editorInfo);
        int length = contentMimeTypes.length;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            if (description.hasMimeType(contentMimeTypes[i2])) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return false;
        }
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            commitContent = inputConnection.commitContent((android.view.inputmethod.InputContentInfo) inputContentInfoCompat.unwrap(), i, bundle);
            return commitContent;
        }
        int protocol = androidx.core.view.inputmethod.EditorInfoCompat.getProtocol(editorInfo);
        if (protocol == 2) {
            z2 = true;
        } else if (protocol != 3 && protocol != 4) {
            return false;
        }
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putParcelable(z2 ? COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY : COMMIT_CONTENT_CONTENT_URI_KEY, inputContentInfoCompat.getContentUri());
        bundle2.putParcelable(z2 ? COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY : COMMIT_CONTENT_DESCRIPTION_KEY, inputContentInfoCompat.getDescription());
        bundle2.putParcelable(z2 ? COMMIT_CONTENT_LINK_URI_INTEROP_KEY : COMMIT_CONTENT_LINK_URI_KEY, inputContentInfoCompat.getLinkUri());
        bundle2.putInt(z2 ? COMMIT_CONTENT_FLAGS_INTEROP_KEY : COMMIT_CONTENT_FLAGS_KEY, i);
        bundle2.putParcelable(z2 ? COMMIT_CONTENT_OPTS_INTEROP_KEY : COMMIT_CONTENT_OPTS_KEY, bundle);
        return inputConnection.performPrivateCommand(z2 ? COMMIT_CONTENT_INTEROP_ACTION : COMMIT_CONTENT_ACTION, bundle2);
    }

    @androidx.annotation.NonNull
    public static android.view.inputmethod.InputConnection createWrapper(@androidx.annotation.NonNull android.view.inputmethod.InputConnection inputConnection, @androidx.annotation.NonNull android.view.inputmethod.EditorInfo editorInfo, @androidx.annotation.NonNull androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener onCommitContentListener) {
        if (inputConnection == null) {
            throw new java.lang.IllegalArgumentException("inputConnection must be non-null");
        }
        if (editorInfo == null) {
            throw new java.lang.IllegalArgumentException("editorInfo must be non-null");
        }
        if (onCommitContentListener != null) {
            return android.os.Build.VERSION.SDK_INT >= 25 ? new androidx.core.view.inputmethod.InputConnectionCompat.AnonymousClass1(inputConnection, false, onCommitContentListener) : androidx.core.view.inputmethod.EditorInfoCompat.getContentMimeTypes(editorInfo).length == 0 ? inputConnection : new androidx.core.view.inputmethod.InputConnectionCompat.AnonymousClass2(inputConnection, false, onCommitContentListener);
        }
        throw new java.lang.IllegalArgumentException("onCommitContentListener must be non-null");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static boolean handlePerformPrivateCommand(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.NonNull android.os.Bundle bundle, @androidx.annotation.NonNull androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener onCommitContentListener) {
        boolean z;
        android.os.ResultReceiver resultReceiver;
        ?? r0 = 0;
        r0 = 0;
        if (bundle == null) {
            return false;
        }
        if (android.text.TextUtils.equals(COMMIT_CONTENT_ACTION, str)) {
            z = false;
        } else {
            if (!android.text.TextUtils.equals(COMMIT_CONTENT_INTEROP_ACTION, str)) {
                return false;
            }
            z = true;
        }
        try {
            resultReceiver = (android.os.ResultReceiver) bundle.getParcelable(z ? COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY : COMMIT_CONTENT_RESULT_RECEIVER_KEY);
            try {
                android.net.Uri uri = (android.net.Uri) bundle.getParcelable(z ? COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY : COMMIT_CONTENT_CONTENT_URI_KEY);
                android.content.ClipDescription clipDescription = (android.content.ClipDescription) bundle.getParcelable(z ? COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY : COMMIT_CONTENT_DESCRIPTION_KEY);
                android.net.Uri uri2 = (android.net.Uri) bundle.getParcelable(z ? COMMIT_CONTENT_LINK_URI_INTEROP_KEY : COMMIT_CONTENT_LINK_URI_KEY);
                int i = bundle.getInt(z ? COMMIT_CONTENT_FLAGS_INTEROP_KEY : COMMIT_CONTENT_FLAGS_KEY);
                android.os.Bundle bundle2 = (android.os.Bundle) bundle.getParcelable(z ? COMMIT_CONTENT_OPTS_INTEROP_KEY : COMMIT_CONTENT_OPTS_KEY);
                if (uri != null && clipDescription != null) {
                    r0 = onCommitContentListener.onCommitContent(new androidx.core.view.inputmethod.InputContentInfoCompat(uri, clipDescription, uri2), i, bundle2);
                }
                if (resultReceiver != 0) {
                    resultReceiver.send(r0, null);
                }
                return r0;
            } catch (java.lang.Throwable th) {
                th = th;
                if (resultReceiver != 0) {
                    resultReceiver.send(0, null);
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            resultReceiver = 0;
        }
    }
}
