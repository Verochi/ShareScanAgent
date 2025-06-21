package com.google.android.exoplayer2.metadata;

/* loaded from: classes22.dex */
public final class Metadata implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.Metadata> CREATOR = new com.google.android.exoplayer2.metadata.Metadata.AnonymousClass1();
    private final com.google.android.exoplayer2.metadata.Metadata.Entry[] entries;

    /* renamed from: com.google.android.exoplayer2.metadata.Metadata$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.Metadata> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.Metadata createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.Metadata(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.Metadata[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.Metadata[i];
        }
    }

    public interface Entry extends android.os.Parcelable {
        @androidx.annotation.Nullable
        byte[] getWrappedMetadataBytes();

        @androidx.annotation.Nullable
        com.google.android.exoplayer2.Format getWrappedMetadataFormat();
    }

    public Metadata(android.os.Parcel parcel) {
        this.entries = new com.google.android.exoplayer2.metadata.Metadata.Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.metadata.Metadata.Entry[] entryArr = this.entries;
            if (i >= entryArr.length) {
                return;
            }
            entryArr[i] = (com.google.android.exoplayer2.metadata.Metadata.Entry) parcel.readParcelable(com.google.android.exoplayer2.metadata.Metadata.Entry.class.getClassLoader());
            i++;
        }
    }

    public Metadata(java.util.List<? extends com.google.android.exoplayer2.metadata.Metadata.Entry> list) {
        this.entries = (com.google.android.exoplayer2.metadata.Metadata.Entry[]) list.toArray(new com.google.android.exoplayer2.metadata.Metadata.Entry[0]);
    }

    public Metadata(com.google.android.exoplayer2.metadata.Metadata.Entry... entryArr) {
        this.entries = entryArr;
    }

    public com.google.android.exoplayer2.metadata.Metadata copyWithAppendedEntries(com.google.android.exoplayer2.metadata.Metadata.Entry... entryArr) {
        return entryArr.length == 0 ? this : new com.google.android.exoplayer2.metadata.Metadata((com.google.android.exoplayer2.metadata.Metadata.Entry[]) com.google.android.exoplayer2.util.Util.nullSafeArrayConcatenation(this.entries, entryArr));
    }

    public com.google.android.exoplayer2.metadata.Metadata copyWithAppendedEntriesFrom(@androidx.annotation.Nullable com.google.android.exoplayer2.metadata.Metadata metadata) {
        return metadata == null ? this : copyWithAppendedEntries(metadata.entries);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.Metadata.class != obj.getClass()) {
            return false;
        }
        return java.util.Arrays.equals(this.entries, ((com.google.android.exoplayer2.metadata.Metadata) obj).entries);
    }

    public com.google.android.exoplayer2.metadata.Metadata.Entry get(int i) {
        return this.entries[i];
    }

    public int hashCode() {
        return java.util.Arrays.hashCode(this.entries);
    }

    public int length() {
        return this.entries.length;
    }

    public java.lang.String toString() {
        java.lang.String valueOf = java.lang.String.valueOf(java.util.Arrays.toString(this.entries));
        return valueOf.length() != 0 ? "entries=".concat(valueOf) : new java.lang.String("entries=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.entries.length);
        for (com.google.android.exoplayer2.metadata.Metadata.Entry entry : this.entries) {
            parcel.writeParcelable(entry, 0);
        }
    }
}
