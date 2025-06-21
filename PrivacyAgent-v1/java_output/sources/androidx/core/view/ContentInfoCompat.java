package androidx.core.view;

/* loaded from: classes.dex */
public final class ContentInfoCompat {
    public static final int FLAG_CONVERT_TO_PLAIN_TEXT = 1;
    public static final int SOURCE_APP = 0;
    public static final int SOURCE_CLIPBOARD = 1;
    public static final int SOURCE_DRAG_AND_DROP = 3;
    public static final int SOURCE_INPUT_METHOD = 2;

    @androidx.annotation.NonNull
    final android.content.ClipData mClip;

    @androidx.annotation.Nullable
    final android.os.Bundle mExtras;
    final int mFlags;

    @androidx.annotation.Nullable
    final android.net.Uri mLinkUri;
    final int mSource;

    public static final class Builder {

        @androidx.annotation.NonNull
        android.content.ClipData mClip;

        @androidx.annotation.Nullable
        android.os.Bundle mExtras;
        int mFlags;

        @androidx.annotation.Nullable
        android.net.Uri mLinkUri;
        int mSource;

        public Builder(@androidx.annotation.NonNull android.content.ClipData clipData, int i) {
            this.mClip = clipData;
            this.mSource = i;
        }

        public Builder(@androidx.annotation.NonNull androidx.core.view.ContentInfoCompat contentInfoCompat) {
            this.mClip = contentInfoCompat.mClip;
            this.mSource = contentInfoCompat.mSource;
            this.mFlags = contentInfoCompat.mFlags;
            this.mLinkUri = contentInfoCompat.mLinkUri;
            this.mExtras = contentInfoCompat.mExtras;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.ContentInfoCompat build() {
            return new androidx.core.view.ContentInfoCompat(this);
        }

        @androidx.annotation.NonNull
        public androidx.core.view.ContentInfoCompat.Builder setClip(@androidx.annotation.NonNull android.content.ClipData clipData) {
            this.mClip = clipData;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.ContentInfoCompat.Builder setExtras(@androidx.annotation.Nullable android.os.Bundle bundle) {
            this.mExtras = bundle;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.ContentInfoCompat.Builder setFlags(int i) {
            this.mFlags = i;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.ContentInfoCompat.Builder setLinkUri(@androidx.annotation.Nullable android.net.Uri uri) {
            this.mLinkUri = uri;
            return this;
        }

        @androidx.annotation.NonNull
        public androidx.core.view.ContentInfoCompat.Builder setSource(int i) {
            this.mSource = i;
            return this;
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Flags {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Source {
    }

    public ContentInfoCompat(androidx.core.view.ContentInfoCompat.Builder builder) {
        this.mClip = (android.content.ClipData) androidx.core.util.Preconditions.checkNotNull(builder.mClip);
        this.mSource = androidx.core.util.Preconditions.checkArgumentInRange(builder.mSource, 0, 3, com.tencent.open.SocialConstants.PARAM_SOURCE);
        this.mFlags = androidx.core.util.Preconditions.checkFlagsArgument(builder.mFlags, 1);
        this.mLinkUri = builder.mLinkUri;
        this.mExtras = builder.mExtras;
    }

    private static android.content.ClipData buildClipData(android.content.ClipDescription clipDescription, java.util.List<android.content.ClipData.Item> list) {
        android.content.ClipData clipData = new android.content.ClipData(new android.content.ClipDescription(clipDescription), list.get(0));
        for (int i = 1; i < list.size(); i++) {
            clipData.addItem(list.get(i));
        }
        return clipData;
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static java.lang.String flagsToString(int i) {
        return (i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : java.lang.String.valueOf(i);
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static java.lang.String sourceToString(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? java.lang.String.valueOf(i) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    @androidx.annotation.NonNull
    public android.content.ClipData getClip() {
        return this.mClip;
    }

    @androidx.annotation.Nullable
    public android.os.Bundle getExtras() {
        return this.mExtras;
    }

    public int getFlags() {
        return this.mFlags;
    }

    @androidx.annotation.Nullable
    public android.net.Uri getLinkUri() {
        return this.mLinkUri;
    }

    public int getSource() {
        return this.mSource;
    }

    @androidx.annotation.NonNull
    public android.util.Pair<androidx.core.view.ContentInfoCompat, androidx.core.view.ContentInfoCompat> partition(@androidx.annotation.NonNull androidx.core.util.Predicate<android.content.ClipData.Item> predicate) {
        if (this.mClip.getItemCount() == 1) {
            boolean test = predicate.test(this.mClip.getItemAt(0));
            return android.util.Pair.create(test ? this : null, test ? null : this);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (int i = 0; i < this.mClip.getItemCount(); i++) {
            android.content.ClipData.Item itemAt = this.mClip.getItemAt(i);
            if (predicate.test(itemAt)) {
                arrayList.add(itemAt);
            } else {
                arrayList2.add(itemAt);
            }
        }
        return arrayList.isEmpty() ? android.util.Pair.create(null, this) : arrayList2.isEmpty() ? android.util.Pair.create(this, null) : android.util.Pair.create(new androidx.core.view.ContentInfoCompat.Builder(this).setClip(buildClipData(this.mClip.getDescription(), arrayList)).build(), new androidx.core.view.ContentInfoCompat.Builder(this).setClip(buildClipData(this.mClip.getDescription(), arrayList2)).build());
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return "ContentInfoCompat{clip=" + this.mClip + ", source=" + sourceToString(this.mSource) + ", flags=" + flagsToString(this.mFlags) + ", linkUri=" + this.mLinkUri + ", extras=" + this.mExtras + com.alipay.sdk.m.u.i.d;
    }
}
