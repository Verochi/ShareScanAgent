package com.google.android.exoplayer2.source.dash.manifest;

/* loaded from: classes22.dex */
public class AdaptationSet {
    public static final int ID_UNSET = -1;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> accessibilityDescriptors;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> essentialProperties;
    public final int id;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> representations;
    public final java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> supplementalProperties;
    public final int type;

    public AdaptationSet(int i, int i2, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Representation> list, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list2, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list3, java.util.List<com.google.android.exoplayer2.source.dash.manifest.Descriptor> list4) {
        this.id = i;
        this.type = i2;
        this.representations = java.util.Collections.unmodifiableList(list);
        this.accessibilityDescriptors = java.util.Collections.unmodifiableList(list2);
        this.essentialProperties = java.util.Collections.unmodifiableList(list3);
        this.supplementalProperties = java.util.Collections.unmodifiableList(list4);
    }
}
