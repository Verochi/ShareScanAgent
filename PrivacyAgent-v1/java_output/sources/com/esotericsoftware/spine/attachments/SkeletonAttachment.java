package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public class SkeletonAttachment extends com.esotericsoftware.spine.attachments.Attachment {
    public com.esotericsoftware.spine.Skeleton b;

    public SkeletonAttachment(java.lang.String str) {
        super(str);
    }

    public com.esotericsoftware.spine.Skeleton getSkeleton() {
        return this.b;
    }

    public void setSkeleton(com.esotericsoftware.spine.Skeleton skeleton) {
        this.b = skeleton;
    }
}
