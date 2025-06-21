package androidx.core.content;

/* loaded from: classes.dex */
public final class LocusIdCompat {
    private final java.lang.String mId;
    private final android.content.LocusId mWrapped;

    @androidx.annotation.RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @androidx.annotation.NonNull
        public static android.content.LocusId create(@androidx.annotation.NonNull java.lang.String str) {
            return new android.content.LocusId(str);
        }

        @androidx.annotation.NonNull
        public static java.lang.String getId(@androidx.annotation.NonNull android.content.LocusId locusId) {
            java.lang.String id;
            id = locusId.getId();
            return id;
        }
    }

    public LocusIdCompat(@androidx.annotation.NonNull java.lang.String str) {
        this.mId = (java.lang.String) androidx.core.util.Preconditions.checkStringNotEmpty(str, "id cannot be empty");
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            this.mWrapped = androidx.core.content.LocusIdCompat.Api29Impl.create(str);
        } else {
            this.mWrapped = null;
        }
    }

    @androidx.annotation.NonNull
    private java.lang.String getSanitizedId() {
        return this.mId.length() + "_chars";
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(29)
    public static androidx.core.content.LocusIdCompat toLocusIdCompat(@androidx.annotation.NonNull android.content.LocusId locusId) {
        androidx.core.util.Preconditions.checkNotNull(locusId, "locusId cannot be null");
        return new androidx.core.content.LocusIdCompat((java.lang.String) androidx.core.util.Preconditions.checkStringNotEmpty(androidx.core.content.LocusIdCompat.Api29Impl.getId(locusId), "id cannot be empty"));
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || androidx.core.content.LocusIdCompat.class != obj.getClass()) {
            return false;
        }
        androidx.core.content.LocusIdCompat locusIdCompat = (androidx.core.content.LocusIdCompat) obj;
        java.lang.String str = this.mId;
        return str == null ? locusIdCompat.mId == null : str.equals(locusIdCompat.mId);
    }

    @androidx.annotation.NonNull
    public java.lang.String getId() {
        return this.mId;
    }

    public int hashCode() {
        java.lang.String str = this.mId;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(29)
    public android.content.LocusId toLocusId() {
        return this.mWrapped;
    }

    @androidx.annotation.NonNull
    public java.lang.String toString() {
        return "LocusIdCompat[" + getSanitizedId() + "]";
    }
}
