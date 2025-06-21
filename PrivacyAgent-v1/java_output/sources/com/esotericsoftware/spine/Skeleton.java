package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class Skeleton {
    public final com.esotericsoftware.spine.SkeletonData a;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> b;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> c;
    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> d;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.IkConstraint> e;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.TransformConstraint> f;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.PathConstraint> g;
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Updatable> h = new com.badlogic.gdx.utils.Array<>();
    public final com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> i = new com.badlogic.gdx.utils.Array<>();
    public com.esotericsoftware.spine.Skin j;
    public final com.badlogic.gdx.graphics.Color k;
    public float l;
    public boolean m;
    public boolean n;
    public float o;
    public float p;

    public Skeleton(com.esotericsoftware.spine.Skeleton skeleton) {
        com.esotericsoftware.spine.Bone bone;
        if (skeleton == null) {
            throw new java.lang.IllegalArgumentException("skeleton cannot be null.");
        }
        this.a = skeleton.a;
        this.b = new com.badlogic.gdx.utils.Array<>(skeleton.b.size);
        java.util.Iterator<com.esotericsoftware.spine.Bone> it = skeleton.b.iterator();
        while (it.hasNext()) {
            com.esotericsoftware.spine.Bone next = it.next();
            com.esotericsoftware.spine.Bone bone2 = next.c;
            if (bone2 == null) {
                bone = new com.esotericsoftware.spine.Bone(next, this, (com.esotericsoftware.spine.Bone) null);
            } else {
                com.esotericsoftware.spine.Bone bone3 = this.b.get(bone2.a.a);
                com.esotericsoftware.spine.Bone bone4 = new com.esotericsoftware.spine.Bone(next, this, bone3);
                bone3.d.add(bone4);
                bone = bone4;
            }
            this.b.add(bone);
        }
        this.c = new com.badlogic.gdx.utils.Array<>(skeleton.c.size);
        java.util.Iterator<com.esotericsoftware.spine.Slot> it2 = skeleton.c.iterator();
        while (it2.hasNext()) {
            com.esotericsoftware.spine.Slot next2 = it2.next();
            this.c.add(new com.esotericsoftware.spine.Slot(next2, this.b.get(next2.b.a.a)));
        }
        this.d = new com.badlogic.gdx.utils.Array<>(this.c.size);
        java.util.Iterator<com.esotericsoftware.spine.Slot> it3 = skeleton.d.iterator();
        while (it3.hasNext()) {
            this.d.add(this.c.get(it3.next().a.a));
        }
        this.e = new com.badlogic.gdx.utils.Array<>(skeleton.e.size);
        java.util.Iterator<com.esotericsoftware.spine.IkConstraint> it4 = skeleton.e.iterator();
        while (it4.hasNext()) {
            this.e.add(new com.esotericsoftware.spine.IkConstraint(it4.next(), this));
        }
        this.f = new com.badlogic.gdx.utils.Array<>(skeleton.f.size);
        java.util.Iterator<com.esotericsoftware.spine.TransformConstraint> it5 = skeleton.f.iterator();
        while (it5.hasNext()) {
            this.f.add(new com.esotericsoftware.spine.TransformConstraint(it5.next(), this));
        }
        this.g = new com.badlogic.gdx.utils.Array<>(skeleton.g.size);
        java.util.Iterator<com.esotericsoftware.spine.PathConstraint> it6 = skeleton.g.iterator();
        while (it6.hasNext()) {
            this.g.add(new com.esotericsoftware.spine.PathConstraint(it6.next(), this));
        }
        this.j = skeleton.j;
        this.k = new com.badlogic.gdx.graphics.Color(skeleton.k);
        this.l = skeleton.l;
        this.m = skeleton.m;
        this.n = skeleton.n;
        updateCache();
    }

    public Skeleton(com.esotericsoftware.spine.SkeletonData skeletonData) {
        com.esotericsoftware.spine.Bone bone;
        if (skeletonData == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null.");
        }
        this.a = skeletonData;
        this.b = new com.badlogic.gdx.utils.Array<>(skeletonData.b.size);
        java.util.Iterator<com.esotericsoftware.spine.BoneData> it = skeletonData.b.iterator();
        while (it.hasNext()) {
            com.esotericsoftware.spine.BoneData next = it.next();
            com.esotericsoftware.spine.BoneData boneData = next.c;
            if (boneData == null) {
                bone = new com.esotericsoftware.spine.Bone(next, this, (com.esotericsoftware.spine.Bone) null);
            } else {
                com.esotericsoftware.spine.Bone bone2 = this.b.get(boneData.a);
                com.esotericsoftware.spine.Bone bone3 = new com.esotericsoftware.spine.Bone(next, this, bone2);
                bone2.d.add(bone3);
                bone = bone3;
            }
            this.b.add(bone);
        }
        this.c = new com.badlogic.gdx.utils.Array<>(skeletonData.c.size);
        this.d = new com.badlogic.gdx.utils.Array<>(skeletonData.c.size);
        java.util.Iterator<com.esotericsoftware.spine.SlotData> it2 = skeletonData.c.iterator();
        while (it2.hasNext()) {
            com.esotericsoftware.spine.SlotData next2 = it2.next();
            com.esotericsoftware.spine.Slot slot = new com.esotericsoftware.spine.Slot(next2, this.b.get(next2.c.a));
            this.c.add(slot);
            this.d.add(slot);
        }
        this.e = new com.badlogic.gdx.utils.Array<>(skeletonData.h.size);
        java.util.Iterator<com.esotericsoftware.spine.IkConstraintData> it3 = skeletonData.h.iterator();
        while (it3.hasNext()) {
            this.e.add(new com.esotericsoftware.spine.IkConstraint(it3.next(), this));
        }
        this.f = new com.badlogic.gdx.utils.Array<>(skeletonData.i.size);
        java.util.Iterator<com.esotericsoftware.spine.TransformConstraintData> it4 = skeletonData.i.iterator();
        while (it4.hasNext()) {
            this.f.add(new com.esotericsoftware.spine.TransformConstraint(it4.next(), this));
        }
        this.g = new com.badlogic.gdx.utils.Array<>(skeletonData.j.size);
        java.util.Iterator<com.esotericsoftware.spine.PathConstraintData> it5 = skeletonData.j.iterator();
        while (it5.hasNext()) {
            this.g.add(new com.esotericsoftware.spine.PathConstraint(it5.next(), this));
        }
        this.k = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        updateCache();
    }

    public final void a(com.esotericsoftware.spine.Bone bone) {
        if (bone.z) {
            return;
        }
        com.esotericsoftware.spine.Bone bone2 = bone.c;
        if (bone2 != null) {
            a(bone2);
        }
        bone.z = true;
        this.h.add(bone);
    }

    public final void b(com.esotericsoftware.spine.IkConstraint ikConstraint) {
        a(ikConstraint.c);
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = ikConstraint.b;
        com.esotericsoftware.spine.Bone first = array.first();
        a(first);
        if (array.size > 1) {
            com.esotericsoftware.spine.Bone peek = array.peek();
            if (!this.h.contains(peek, true)) {
                this.i.add(peek);
            }
        }
        this.h.add(ikConstraint);
        f(first.d);
        array.peek().z = true;
    }

    public final void c(com.esotericsoftware.spine.PathConstraint pathConstraint) {
        com.esotericsoftware.spine.Slot slot = pathConstraint.c;
        int i = slot.getData().a;
        com.esotericsoftware.spine.Bone bone = slot.b;
        com.esotericsoftware.spine.Skin skin = this.j;
        if (skin != null) {
            d(skin, i, bone);
        }
        com.esotericsoftware.spine.Skin skin2 = this.a.e;
        if (skin2 != null && skin2 != this.j) {
            d(skin2, i, bone);
        }
        int i2 = this.a.d.size;
        for (int i3 = 0; i3 < i2; i3++) {
            d(this.a.d.get(i3), i, bone);
        }
        com.esotericsoftware.spine.attachments.Attachment attachment = slot.e;
        if (attachment instanceof com.esotericsoftware.spine.attachments.PathAttachment) {
            e(attachment, bone);
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = pathConstraint.b;
        int i4 = array.size;
        for (int i5 = 0; i5 < i4; i5++) {
            a(array.get(i5));
        }
        this.h.add(pathConstraint);
        for (int i6 = 0; i6 < i4; i6++) {
            f(array.get(i6).d);
        }
        for (int i7 = 0; i7 < i4; i7++) {
            array.get(i7).z = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(com.esotericsoftware.spine.Skin skin, int i, com.esotericsoftware.spine.Bone bone) {
        com.badlogic.gdx.utils.ObjectMap.Entries<com.esotericsoftware.spine.Skin.Key, com.esotericsoftware.spine.attachments.Attachment> it = skin.b.entries().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.ObjectMap.Entry next = it.next();
            if (((com.esotericsoftware.spine.Skin.Key) next.key).a == i) {
                e((com.esotericsoftware.spine.attachments.Attachment) next.value, bone);
            }
        }
    }

    public final void e(com.esotericsoftware.spine.attachments.Attachment attachment, com.esotericsoftware.spine.Bone bone) {
        if (attachment instanceof com.esotericsoftware.spine.attachments.PathAttachment) {
            int[] bones = ((com.esotericsoftware.spine.attachments.PathAttachment) attachment).getBones();
            if (bones == null) {
                a(bone);
                return;
            }
            com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = this.b;
            int length = bones.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                int i3 = bones[i] + i2;
                while (i2 < i3) {
                    a(array.get(bones[i2]));
                    i2++;
                }
                i = i2;
            }
        }
    }

    public final void f(com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array) {
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.Bone bone = array.get(i2);
            if (bone.z) {
                f(bone.d);
            }
            bone.z = false;
        }
    }

    public com.esotericsoftware.spine.Bone findBone(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("boneName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = this.b;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.Bone bone = array.get(i2);
            if (bone.a.b.equals(str)) {
                return bone;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.IkConstraint findIkConstraint(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("constraintName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.IkConstraint> array = this.e;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.IkConstraint ikConstraint = array.get(i2);
            if (ikConstraint.a.a.equals(str)) {
                return ikConstraint;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.PathConstraint findPathConstraint(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("constraintName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.PathConstraint> array = this.g;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.PathConstraint pathConstraint = array.get(i2);
            if (pathConstraint.a.a.equals(str)) {
                return pathConstraint;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.Slot findSlot(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("slotName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array = this.c;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.Slot slot = array.get(i2);
            if (slot.a.b.equals(str)) {
                return slot;
            }
        }
        return null;
    }

    public com.esotericsoftware.spine.TransformConstraint findTransformConstraint(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("constraintName cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.TransformConstraint> array = this.f;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.TransformConstraint transformConstraint = array.get(i2);
            if (transformConstraint.a.a.equals(str)) {
                return transformConstraint;
            }
        }
        return null;
    }

    public final void g(com.esotericsoftware.spine.TransformConstraint transformConstraint) {
        a(transformConstraint.c);
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = transformConstraint.b;
        int i = array.size;
        if (transformConstraint.a.p) {
            for (int i2 = 0; i2 < i; i2++) {
                com.esotericsoftware.spine.Bone bone = array.get(i2);
                a(bone.c);
                if (!this.h.contains(bone, true)) {
                    this.i.add(bone);
                }
            }
        } else {
            for (int i3 = 0; i3 < i; i3++) {
                a(array.get(i3));
            }
        }
        this.h.add(transformConstraint);
        for (int i4 = 0; i4 < i; i4++) {
            f(array.get(i4).d);
        }
        for (int i5 = 0; i5 < i; i5++) {
            array.get(i5).z = true;
        }
    }

    public com.esotericsoftware.spine.attachments.Attachment getAttachment(int i, java.lang.String str) {
        com.esotericsoftware.spine.attachments.Attachment attachment;
        if (str == null) {
            throw new java.lang.IllegalArgumentException("attachmentName cannot be null.");
        }
        com.esotericsoftware.spine.Skin skin = this.j;
        if (skin != null && (attachment = skin.getAttachment(i, str)) != null) {
            return attachment;
        }
        com.esotericsoftware.spine.Skin skin2 = this.a.e;
        if (skin2 != null) {
            return skin2.getAttachment(i, str);
        }
        return null;
    }

    public com.esotericsoftware.spine.attachments.Attachment getAttachment(java.lang.String str, java.lang.String str2) {
        com.esotericsoftware.spine.SlotData findSlot = this.a.findSlot(str);
        if (findSlot != null) {
            return getAttachment(findSlot.getIndex(), str2);
        }
        throw new java.lang.IllegalArgumentException("Slot not found: " + str);
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> getBones() {
        return this.b;
    }

    public void getBounds(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22, com.badlogic.gdx.utils.FloatArray floatArray) {
        float[] fArr;
        int i;
        if (vector2 == null) {
            throw new java.lang.IllegalArgumentException("offset cannot be null.");
        }
        if (vector22 == null) {
            throw new java.lang.IllegalArgumentException("size cannot be null.");
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array = this.d;
        int i2 = array.size;
        float f = -2.1474836E9f;
        int i3 = 0;
        float f2 = -2.1474836E9f;
        float f3 = 2.1474836E9f;
        float f4 = 2.1474836E9f;
        int i4 = 0;
        while (i4 < i2) {
            com.esotericsoftware.spine.Slot slot = array.get(i4);
            com.esotericsoftware.spine.attachments.Attachment attachment = slot.e;
            if (attachment instanceof com.esotericsoftware.spine.attachments.RegionAttachment) {
                fArr = floatArray.setSize(8);
                ((com.esotericsoftware.spine.attachments.RegionAttachment) attachment).computeWorldVertices(slot.getBone(), fArr, i3, 2);
                i = 8;
            } else if (attachment instanceof com.esotericsoftware.spine.attachments.MeshAttachment) {
                com.esotericsoftware.spine.attachments.MeshAttachment meshAttachment = (com.esotericsoftware.spine.attachments.MeshAttachment) attachment;
                int worldVerticesLength = meshAttachment.getWorldVerticesLength();
                float[] size = floatArray.setSize(worldVerticesLength);
                meshAttachment.computeWorldVertices(slot, 0, worldVerticesLength, size, 0, 2);
                i = worldVerticesLength;
                fArr = size;
            } else {
                fArr = null;
                i = 0;
            }
            if (fArr != null) {
                for (int i5 = 0; i5 < i; i5 += 2) {
                    float f5 = fArr[i5];
                    float f6 = fArr[i5 + 1];
                    f3 = java.lang.Math.min(f3, f5);
                    f4 = java.lang.Math.min(f4, f6);
                    f = java.lang.Math.max(f, f5);
                    f2 = java.lang.Math.max(f2, f6);
                }
            }
            i4++;
            i3 = 0;
        }
        vector2.set(f3, f4);
        vector22.set(f - f3, f2 - f4);
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.k;
    }

    public com.esotericsoftware.spine.SkeletonData getData() {
        return this.a;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> getDrawOrder() {
        return this.d;
    }

    public boolean getFlipX() {
        return this.m;
    }

    public boolean getFlipY() {
        return this.n;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.IkConstraint> getIkConstraints() {
        return this.e;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.PathConstraint> getPathConstraints() {
        return this.g;
    }

    public com.esotericsoftware.spine.Bone getRootBone() {
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = this.b;
        if (array.size == 0) {
            return null;
        }
        return array.first();
    }

    public com.esotericsoftware.spine.Skin getSkin() {
        return this.j;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> getSlots() {
        return this.c;
    }

    public float getTime() {
        return this.l;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.TransformConstraint> getTransformConstraints() {
        return this.f;
    }

    public com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Updatable> getUpdateCache() {
        return this.h;
    }

    public float getX() {
        return this.o;
    }

    public float getY() {
        return this.p;
    }

    public void setAttachment(java.lang.String str, java.lang.String str2) {
        com.esotericsoftware.spine.attachments.Attachment attachment;
        if (str == null) {
            throw new java.lang.IllegalArgumentException("slotName cannot be null.");
        }
        com.esotericsoftware.spine.Slot findSlot = findSlot(str);
        if (findSlot == null) {
            throw new java.lang.IllegalArgumentException("Slot not found: " + str);
        }
        if (str2 != null) {
            attachment = getAttachment(findSlot.a.a, str2);
            if (attachment == null) {
                throw new java.lang.IllegalArgumentException("Attachment not found: " + str2 + ", for slot: " + str);
            }
        } else {
            attachment = null;
        }
        findSlot.setAttachment(attachment);
    }

    public void setBonesToSetupPose() {
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = this.b;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            array.get(i2).setToSetupPose();
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.IkConstraint> array2 = this.e;
        int i3 = array2.size;
        for (int i4 = 0; i4 < i3; i4++) {
            com.esotericsoftware.spine.IkConstraint ikConstraint = array2.get(i4);
            com.esotericsoftware.spine.IkConstraintData ikConstraintData = ikConstraint.a;
            ikConstraint.e = ikConstraintData.e;
            ikConstraint.d = ikConstraintData.f;
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.TransformConstraint> array3 = this.f;
        int i5 = array3.size;
        for (int i6 = 0; i6 < i5; i6++) {
            com.esotericsoftware.spine.TransformConstraint transformConstraint = array3.get(i6);
            com.esotericsoftware.spine.TransformConstraintData transformConstraintData = transformConstraint.a;
            transformConstraint.d = transformConstraintData.e;
            transformConstraint.e = transformConstraintData.f;
            transformConstraint.f = transformConstraintData.g;
            transformConstraint.g = transformConstraintData.h;
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.PathConstraint> array4 = this.g;
        int i7 = array4.size;
        for (int i8 = 0; i8 < i7; i8++) {
            com.esotericsoftware.spine.PathConstraint pathConstraint = array4.get(i8);
            com.esotericsoftware.spine.PathConstraintData pathConstraintData = pathConstraint.a;
            pathConstraint.d = pathConstraintData.i;
            pathConstraint.e = pathConstraintData.j;
            pathConstraint.f = pathConstraintData.k;
            pathConstraint.g = pathConstraintData.l;
        }
    }

    public void setColor(com.badlogic.gdx.graphics.Color color) {
        if (color == null) {
            throw new java.lang.IllegalArgumentException("color cannot be null.");
        }
        this.k.set(color);
    }

    public void setDrawOrder(com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array) {
        if (array == null) {
            throw new java.lang.IllegalArgumentException("drawOrder cannot be null.");
        }
        this.d = array;
    }

    public void setFlip(boolean z, boolean z2) {
        this.m = z;
        this.n = z2;
    }

    public void setFlipX(boolean z) {
        this.m = z;
    }

    public void setFlipY(boolean z) {
        this.n = z;
    }

    public void setPosition(float f, float f2) {
        this.o = f;
        this.p = f2;
    }

    public void setSkin(com.esotericsoftware.spine.Skin skin) {
        com.esotericsoftware.spine.attachments.Attachment attachment;
        if (skin != null) {
            com.esotericsoftware.spine.Skin skin2 = this.j;
            if (skin2 != null) {
                skin.a(this, skin2);
            } else {
                com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array = this.c;
                int i = array.size;
                for (int i2 = 0; i2 < i; i2++) {
                    com.esotericsoftware.spine.Slot slot = array.get(i2);
                    java.lang.String str = slot.a.f;
                    if (str != null && (attachment = skin.getAttachment(i2, str)) != null) {
                        slot.setAttachment(attachment);
                    }
                }
            }
        }
        this.j = skin;
    }

    public void setSkin(java.lang.String str) {
        com.esotericsoftware.spine.Skin findSkin = this.a.findSkin(str);
        if (findSkin != null) {
            setSkin(findSkin);
            return;
        }
        throw new java.lang.IllegalArgumentException("Skin not found: " + str);
    }

    public void setSlotsToSetupPose() {
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Slot> array = this.c;
        java.lang.System.arraycopy(array.items, 0, this.d.items, 0, array.size);
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            array.get(i2).setToSetupPose();
        }
    }

    public void setTime(float f) {
        this.l = f;
    }

    public void setToSetupPose() {
        setBonesToSetupPose();
        setSlotsToSetupPose();
    }

    public void setX(float f) {
        this.o = f;
    }

    public void setY(float f) {
        this.p = f;
    }

    public java.lang.String toString() {
        java.lang.String str = this.a.a;
        return str != null ? str : super.toString();
    }

    public void update(float f) {
        this.l += f;
    }

    public void updateCache() {
        this.h.clear();
        this.i.clear();
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = this.b;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            array.get(i2).z = false;
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.IkConstraint> array2 = this.e;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.TransformConstraint> array3 = this.f;
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.PathConstraint> array4 = this.g;
        int i3 = array2.size;
        int i4 = array3.size;
        int i5 = array4.size;
        int i6 = i3 + i4 + i5;
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = 0;
            while (true) {
                if (i8 < i3) {
                    com.esotericsoftware.spine.IkConstraint ikConstraint = array2.get(i8);
                    if (ikConstraint.a.b == i7) {
                        b(ikConstraint);
                        break;
                    }
                    i8++;
                } else {
                    int i9 = 0;
                    while (true) {
                        if (i9 < i4) {
                            com.esotericsoftware.spine.TransformConstraint transformConstraint = array3.get(i9);
                            if (transformConstraint.a.b == i7) {
                                g(transformConstraint);
                                break;
                            }
                            i9++;
                        } else {
                            int i10 = 0;
                            while (true) {
                                if (i10 < i5) {
                                    com.esotericsoftware.spine.PathConstraint pathConstraint = array4.get(i10);
                                    if (pathConstraint.a.b == i7) {
                                        c(pathConstraint);
                                        break;
                                    }
                                    i10++;
                                }
                            }
                        }
                    }
                }
            }
        }
        int i11 = array.size;
        for (int i12 = 0; i12 < i11; i12++) {
            a(array.get(i12));
        }
    }

    public void updateWorldTransform() {
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = this.i;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.Bone bone = array.get(i2);
            bone.l = bone.e;
            bone.m = bone.f;
            bone.n = bone.g;
            bone.o = bone.h;
            bone.p = bone.i;
            bone.q = bone.j;
            bone.r = bone.k;
            bone.f308s = true;
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Updatable> array2 = this.h;
        int i3 = array2.size;
        for (int i4 = 0; i4 < i3; i4++) {
            array2.get(i4).update();
        }
    }

    public void updateWorldTransform(com.esotericsoftware.spine.Bone bone) {
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Bone> array = this.i;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.esotericsoftware.spine.Bone bone2 = array.get(i2);
            bone2.l = bone2.e;
            bone2.m = bone2.f;
            bone2.n = bone2.g;
            bone2.o = bone2.h;
            bone2.p = bone2.i;
            bone2.q = bone2.j;
            bone2.r = bone2.k;
            bone2.f308s = true;
        }
        com.esotericsoftware.spine.Bone rootBone = getRootBone();
        float f = bone.t;
        float f2 = bone.u;
        float f3 = bone.w;
        float f4 = bone.x;
        float f5 = this.o;
        float f6 = this.p;
        rootBone.v = (f * f5) + (f2 * f6) + bone.v;
        rootBone.y = (f5 * f3) + (f6 * f4) + bone.y;
        float f7 = rootBone.g;
        float f8 = 90.0f + f7 + rootBone.k;
        float cosDeg = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f7 + rootBone.j) * rootBone.h;
        float cosDeg2 = com.esotericsoftware.spine.utils.SpineUtils.cosDeg(f8) * rootBone.i;
        float sinDeg = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(rootBone.g + rootBone.j) * rootBone.h;
        float sinDeg2 = com.esotericsoftware.spine.utils.SpineUtils.sinDeg(f8) * rootBone.i;
        float f9 = (f * cosDeg) + (f2 * sinDeg);
        rootBone.t = f9;
        float f10 = (f * cosDeg2) + (f2 * sinDeg2);
        rootBone.u = f10;
        float f11 = (cosDeg * f3) + (sinDeg * f4);
        rootBone.w = f11;
        float f12 = (f3 * cosDeg2) + (f4 * sinDeg2);
        rootBone.x = f12;
        if (this.n) {
            rootBone.t = -f9;
            rootBone.u = -f10;
        }
        if (this.m) {
            rootBone.w = -f11;
            rootBone.x = -f12;
        }
        com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.Updatable> array2 = this.h;
        int i3 = array2.size;
        for (int i4 = 0; i4 < i3; i4++) {
            com.esotericsoftware.spine.Updatable updatable = array2.get(i4);
            if (updatable != rootBone) {
                updatable.update();
            }
        }
    }
}
