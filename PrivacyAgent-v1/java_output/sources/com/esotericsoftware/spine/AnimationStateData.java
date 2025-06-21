package com.esotericsoftware.spine;

/* loaded from: classes22.dex */
public class AnimationStateData {
    public final com.esotericsoftware.spine.SkeletonData a;
    public final com.badlogic.gdx.utils.ObjectFloatMap<com.esotericsoftware.spine.AnimationStateData.Key> b = new com.badlogic.gdx.utils.ObjectFloatMap<>();
    public final com.esotericsoftware.spine.AnimationStateData.Key c = new com.esotericsoftware.spine.AnimationStateData.Key();
    public float d;

    public static class Key {
        public com.esotericsoftware.spine.Animation a;
        public com.esotericsoftware.spine.Animation b;

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            com.esotericsoftware.spine.AnimationStateData.Key key = (com.esotericsoftware.spine.AnimationStateData.Key) obj;
            com.esotericsoftware.spine.Animation animation = this.a;
            if (animation == null) {
                if (key.a != null) {
                    return false;
                }
            } else if (!animation.equals(key.a)) {
                return false;
            }
            com.esotericsoftware.spine.Animation animation2 = this.b;
            if (animation2 == null) {
                if (key.b != null) {
                    return false;
                }
            } else if (!animation2.equals(key.b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((this.a.hashCode() + 31) * 31) + this.b.hashCode();
        }

        public java.lang.String toString() {
            return this.a.a + "->" + this.b.a;
        }
    }

    public AnimationStateData(com.esotericsoftware.spine.SkeletonData skeletonData) {
        if (skeletonData == null) {
            throw new java.lang.IllegalArgumentException("skeletonData cannot be null.");
        }
        this.a = skeletonData;
    }

    public float getDefaultMix() {
        return this.d;
    }

    public float getMix(com.esotericsoftware.spine.Animation animation, com.esotericsoftware.spine.Animation animation2) {
        if (animation == null) {
            throw new java.lang.IllegalArgumentException("from cannot be null.");
        }
        if (animation2 == null) {
            throw new java.lang.IllegalArgumentException("to cannot be null.");
        }
        com.esotericsoftware.spine.AnimationStateData.Key key = this.c;
        key.a = animation;
        key.b = animation2;
        return this.b.get(key, this.d);
    }

    public com.esotericsoftware.spine.SkeletonData getSkeletonData() {
        return this.a;
    }

    public void setDefaultMix(float f) {
        this.d = f;
    }

    public void setMix(com.esotericsoftware.spine.Animation animation, com.esotericsoftware.spine.Animation animation2, float f) {
        if (animation == null) {
            throw new java.lang.IllegalArgumentException("from cannot be null.");
        }
        if (animation2 == null) {
            throw new java.lang.IllegalArgumentException("to cannot be null.");
        }
        com.esotericsoftware.spine.AnimationStateData.Key key = new com.esotericsoftware.spine.AnimationStateData.Key();
        key.a = animation;
        key.b = animation2;
        this.b.put(key, f);
    }

    public void setMix(java.lang.String str, java.lang.String str2, float f) {
        com.esotericsoftware.spine.Animation findAnimation = this.a.findAnimation(str);
        if (findAnimation == null) {
            throw new java.lang.IllegalArgumentException("Animation not found: " + str);
        }
        com.esotericsoftware.spine.Animation findAnimation2 = this.a.findAnimation(str2);
        if (findAnimation2 != null) {
            setMix(findAnimation, findAnimation2, f);
            return;
        }
        throw new java.lang.IllegalArgumentException("Animation not found: " + str2);
    }
}
