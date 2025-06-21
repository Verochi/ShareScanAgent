package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class Skin {
    public final java.lang.String a;
    public final com.badlogic.gdx.utils.ObjectMap<com.esotericsoftware.spine.Skin.Key, com.esotericsoftware.spine.attachments.Attachment> b = new com.badlogic.gdx.utils.ObjectMap<>();
    public final com.esotericsoftware.spine.Skin.Key c = new com.esotericsoftware.spine.Skin.Key();
    public final com.badlogic.gdx.utils.Pool<com.esotericsoftware.spine.Skin.Key> d = new com.esotericsoftware.spine.Skin.AnonymousClass1(64);

    /* renamed from: com.esotericsoftware.spine.Skin$1, reason: invalid class name */
    public class AnonymousClass1 extends com.badlogic.gdx.utils.Pool {
        public AnonymousClass1(int i) {
            super(i);
        }

        @Override // com.badlogic.gdx.utils.Pool
        public java.lang.Object newObject() {
            return new com.esotericsoftware.spine.Skin.Key();
        }
    }

    public static class Key {
        public int a;
        public java.lang.String b;
        public int c;

        public void a(int i, java.lang.String str) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("name cannot be null.");
            }
            this.a = i;
            this.b = str;
            this.c = ((str.hashCode() + 31) * 31) + i;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj == null) {
                return false;
            }
            com.esotericsoftware.spine.Skin.Key key = (com.esotericsoftware.spine.Skin.Key) obj;
            return this.a == key.a && this.b.equals(key.b);
        }

        public int hashCode() {
            return this.c;
        }

        public java.lang.String toString() {
            return this.a + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.b;
        }
    }

    public Skin(java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        this.a = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.esotericsoftware.spine.Skeleton skeleton, com.esotericsoftware.spine.Skin skin) {
        com.esotericsoftware.spine.attachments.Attachment attachment;
        com.badlogic.gdx.utils.ObjectMap.Entries<com.esotericsoftware.spine.Skin.Key, com.esotericsoftware.spine.attachments.Attachment> it = skin.b.entries().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.ObjectMap.Entry next = it.next();
            int i = ((com.esotericsoftware.spine.Skin.Key) next.key).a;
            com.esotericsoftware.spine.Slot slot = skeleton.c.get(i);
            if (slot.e == next.value && (attachment = getAttachment(i, ((com.esotericsoftware.spine.Skin.Key) next.key).b)) != null) {
                slot.setAttachment(attachment);
            }
        }
    }

    public void addAttachment(int i, java.lang.String str, com.esotericsoftware.spine.attachments.Attachment attachment) {
        if (attachment == null) {
            throw new java.lang.IllegalArgumentException("attachment cannot be null.");
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("slotIndex must be >= 0.");
        }
        com.esotericsoftware.spine.Skin.Key obtain = this.d.obtain();
        obtain.a(i, str);
        this.b.put(obtain, attachment);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addAttachments(com.esotericsoftware.spine.Skin skin) {
        com.badlogic.gdx.utils.ObjectMap.Entries<com.esotericsoftware.spine.Skin.Key, com.esotericsoftware.spine.attachments.Attachment> it = skin.b.entries().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.ObjectMap.Entry next = it.next();
            K k = next.key;
            addAttachment(((com.esotericsoftware.spine.Skin.Key) k).a, ((com.esotericsoftware.spine.Skin.Key) k).b, (com.esotericsoftware.spine.attachments.Attachment) next.value);
        }
    }

    public void clear() {
        com.badlogic.gdx.utils.ObjectMap.Keys<com.esotericsoftware.spine.Skin.Key> it = this.b.keys().iterator();
        while (it.hasNext()) {
            this.d.free(it.next());
        }
        this.b.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void findAttachmentsForSlot(int i, com.badlogic.gdx.utils.Array<com.esotericsoftware.spine.attachments.Attachment> array) {
        if (array == null) {
            throw new java.lang.IllegalArgumentException("attachments cannot be null.");
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("slotIndex must be >= 0.");
        }
        com.badlogic.gdx.utils.ObjectMap.Entries<com.esotericsoftware.spine.Skin.Key, com.esotericsoftware.spine.attachments.Attachment> it = this.b.entries().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.ObjectMap.Entry next = it.next();
            if (((com.esotericsoftware.spine.Skin.Key) next.key).a == i) {
                array.add((com.esotericsoftware.spine.attachments.Attachment) next.value);
            }
        }
    }

    public void findNamesForSlot(int i, com.badlogic.gdx.utils.Array<java.lang.String> array) {
        if (array == null) {
            throw new java.lang.IllegalArgumentException("names cannot be null.");
        }
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("slotIndex must be >= 0.");
        }
        com.badlogic.gdx.utils.ObjectMap.Keys<com.esotericsoftware.spine.Skin.Key> it = this.b.keys().iterator();
        while (it.hasNext()) {
            com.esotericsoftware.spine.Skin.Key next = it.next();
            if (next.a == i) {
                array.add(next.b);
            }
        }
    }

    public com.esotericsoftware.spine.attachments.Attachment getAttachment(int i, java.lang.String str) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("slotIndex must be >= 0.");
        }
        this.c.a(i, str);
        return this.b.get(this.c);
    }

    public java.lang.String getName() {
        return this.a;
    }

    public void removeAttachment(int i, java.lang.String str) {
        this.c.a(i, str);
        this.b.remove(this.c);
    }

    public java.lang.String toString() {
        return this.a;
    }
}
