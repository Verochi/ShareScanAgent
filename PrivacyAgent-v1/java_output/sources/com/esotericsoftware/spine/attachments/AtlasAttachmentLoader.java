package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public class AtlasAttachmentLoader implements com.esotericsoftware.spine.attachments.AttachmentLoader {
    public com.badlogic.gdx.graphics.g2d.TextureAtlas a;

    public AtlasAttachmentLoader(com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas) {
        if (textureAtlas == null) {
            throw new java.lang.IllegalArgumentException("atlas cannot be null.");
        }
        this.a = textureAtlas;
    }

    @Override // com.esotericsoftware.spine.attachments.AttachmentLoader
    public com.esotericsoftware.spine.attachments.BoundingBoxAttachment newBoundingBoxAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str) {
        return new com.esotericsoftware.spine.attachments.BoundingBoxAttachment(str);
    }

    @Override // com.esotericsoftware.spine.attachments.AttachmentLoader
    public com.esotericsoftware.spine.attachments.ClippingAttachment newClippingAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str) {
        return new com.esotericsoftware.spine.attachments.ClippingAttachment(str);
    }

    @Override // com.esotericsoftware.spine.attachments.AttachmentLoader
    public com.esotericsoftware.spine.attachments.MeshAttachment newMeshAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str, java.lang.String str2) {
        com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion findRegion = this.a.findRegion(str2);
        if (findRegion != null) {
            com.esotericsoftware.spine.attachments.MeshAttachment meshAttachment = new com.esotericsoftware.spine.attachments.MeshAttachment(str);
            meshAttachment.setRegion(findRegion);
            return meshAttachment;
        }
        throw new java.lang.RuntimeException("Region not found in atlas: " + str2 + " (mesh attachment: " + str + ")");
    }

    @Override // com.esotericsoftware.spine.attachments.AttachmentLoader
    public com.esotericsoftware.spine.attachments.PathAttachment newPathAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str) {
        return new com.esotericsoftware.spine.attachments.PathAttachment(str);
    }

    @Override // com.esotericsoftware.spine.attachments.AttachmentLoader
    public com.esotericsoftware.spine.attachments.PointAttachment newPointAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str) {
        return new com.esotericsoftware.spine.attachments.PointAttachment(str);
    }

    @Override // com.esotericsoftware.spine.attachments.AttachmentLoader
    public com.esotericsoftware.spine.attachments.RegionAttachment newRegionAttachment(com.esotericsoftware.spine.Skin skin, java.lang.String str, java.lang.String str2) {
        com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion findRegion = this.a.findRegion(str2);
        if (findRegion != null) {
            com.esotericsoftware.spine.attachments.RegionAttachment regionAttachment = new com.esotericsoftware.spine.attachments.RegionAttachment(str);
            regionAttachment.setRegion(findRegion);
            return regionAttachment;
        }
        throw new java.lang.RuntimeException("Region not found in atlas: " + str2 + " (region attachment: " + str + ")");
    }
}
