package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes22.dex */
public abstract class Id3Frame implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    public final java.lang.String id;

    public Id3Frame(java.lang.String str) {
        this.id = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return defpackage.kl1.a(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ com.google.android.exoplayer2.Format getWrappedMetadataFormat() {
        return defpackage.kl1.b(this);
    }

    public java.lang.String toString() {
        return this.id;
    }
}
