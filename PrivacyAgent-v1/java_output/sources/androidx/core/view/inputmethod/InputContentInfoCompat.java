package androidx.core.view.inputmethod;

/* loaded from: classes.dex */
public final class InputContentInfoCompat {
    private final androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl mImpl;

    @androidx.annotation.RequiresApi(25)
    public static final class InputContentInfoCompatApi25Impl implements androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl {

        @androidx.annotation.NonNull
        final android.view.inputmethod.InputContentInfo mObject;

        public InputContentInfoCompatApi25Impl(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull android.content.ClipDescription clipDescription, @androidx.annotation.Nullable android.net.Uri uri2) {
            this.mObject = new android.view.inputmethod.InputContentInfo(uri, clipDescription, uri2);
        }

        public InputContentInfoCompatApi25Impl(@androidx.annotation.NonNull java.lang.Object obj) {
            this.mObject = (android.view.inputmethod.InputContentInfo) obj;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @androidx.annotation.NonNull
        public android.net.Uri getContentUri() {
            android.net.Uri contentUri;
            contentUri = this.mObject.getContentUri();
            return contentUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @androidx.annotation.NonNull
        public android.content.ClipDescription getDescription() {
            android.content.ClipDescription description;
            description = this.mObject.getDescription();
            return description;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @androidx.annotation.Nullable
        public java.lang.Object getInputContentInfo() {
            return this.mObject;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @androidx.annotation.Nullable
        public android.net.Uri getLinkUri() {
            android.net.Uri linkUri;
            linkUri = this.mObject.getLinkUri();
            return linkUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
            this.mObject.releasePermission();
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
            this.mObject.requestPermission();
        }
    }

    public static final class InputContentInfoCompatBaseImpl implements androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl {

        @androidx.annotation.NonNull
        private final android.net.Uri mContentUri;

        @androidx.annotation.NonNull
        private final android.content.ClipDescription mDescription;

        @androidx.annotation.Nullable
        private final android.net.Uri mLinkUri;

        public InputContentInfoCompatBaseImpl(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull android.content.ClipDescription clipDescription, @androidx.annotation.Nullable android.net.Uri uri2) {
            this.mContentUri = uri;
            this.mDescription = clipDescription;
            this.mLinkUri = uri2;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @androidx.annotation.NonNull
        public android.net.Uri getContentUri() {
            return this.mContentUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @androidx.annotation.NonNull
        public android.content.ClipDescription getDescription() {
            return this.mDescription;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @androidx.annotation.Nullable
        public java.lang.Object getInputContentInfo() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        @androidx.annotation.Nullable
        public android.net.Uri getLinkUri() {
            return this.mLinkUri;
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void releasePermission() {
        }

        @Override // androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl
        public void requestPermission() {
        }
    }

    public interface InputContentInfoCompatImpl {
        @androidx.annotation.NonNull
        android.net.Uri getContentUri();

        @androidx.annotation.NonNull
        android.content.ClipDescription getDescription();

        @androidx.annotation.Nullable
        java.lang.Object getInputContentInfo();

        @androidx.annotation.Nullable
        android.net.Uri getLinkUri();

        void releasePermission();

        void requestPermission();
    }

    public InputContentInfoCompat(@androidx.annotation.NonNull android.net.Uri uri, @androidx.annotation.NonNull android.content.ClipDescription clipDescription, @androidx.annotation.Nullable android.net.Uri uri2) {
        if (android.os.Build.VERSION.SDK_INT >= 25) {
            this.mImpl = new androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.mImpl = new androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatBaseImpl(uri, clipDescription, uri2);
        }
    }

    private InputContentInfoCompat(@androidx.annotation.NonNull androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatImpl inputContentInfoCompatImpl) {
        this.mImpl = inputContentInfoCompatImpl;
    }

    @androidx.annotation.Nullable
    public static androidx.core.view.inputmethod.InputContentInfoCompat wrap(@androidx.annotation.Nullable java.lang.Object obj) {
        if (obj != null && android.os.Build.VERSION.SDK_INT >= 25) {
            return new androidx.core.view.inputmethod.InputContentInfoCompat(new androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatApi25Impl(obj));
        }
        return null;
    }

    @androidx.annotation.NonNull
    public android.net.Uri getContentUri() {
        return this.mImpl.getContentUri();
    }

    @androidx.annotation.NonNull
    public android.content.ClipDescription getDescription() {
        return this.mImpl.getDescription();
    }

    @androidx.annotation.Nullable
    public android.net.Uri getLinkUri() {
        return this.mImpl.getLinkUri();
    }

    public void releasePermission() {
        this.mImpl.releasePermission();
    }

    public void requestPermission() {
        this.mImpl.requestPermission();
    }

    @androidx.annotation.Nullable
    public java.lang.Object unwrap() {
        return this.mImpl.getInputContentInfo();
    }
}
