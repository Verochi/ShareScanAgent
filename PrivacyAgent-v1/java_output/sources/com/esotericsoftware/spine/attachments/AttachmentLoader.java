package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public interface AttachmentLoader {
    com.esotericsoftware.spine.attachments.BoundingBoxAttachment newBoundingBoxAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str);

    com.esotericsoftware.spine.attachments.ClippingAttachment newClippingAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str);

    com.esotericsoftware.spine.attachments.MeshAttachment newMeshAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str, java.lang.String str2);

    com.esotericsoftware.spine.attachments.PathAttachment newPathAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str);

    com.esotericsoftware.spine.attachments.PointAttachment newPointAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str);

    com.esotericsoftware.spine.attachments.RegionAttachment newRegionAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str, java.lang.String str2);
}
