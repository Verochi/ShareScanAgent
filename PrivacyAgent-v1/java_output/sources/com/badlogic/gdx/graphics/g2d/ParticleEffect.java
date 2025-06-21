package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class ParticleEffect implements com.badlogic.gdx.utils.Disposable {
    public final com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.ParticleEmitter> a;
    public com.badlogic.gdx.math.collision.BoundingBox b;
    public boolean c;

    public ParticleEffect() {
        this.a = new com.badlogic.gdx.utils.Array<>(8);
    }

    public ParticleEffect(com.badlogic.gdx.graphics.g2d.ParticleEffect particleEffect) {
        this.a = new com.badlogic.gdx.utils.Array<>(true, particleEffect.a.size);
        int i = particleEffect.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.add(newEmitter(particleEffect.a.get(i2)));
        }
    }

    public void allowCompletion() {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).allowCompletion();
        }
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        if (this.c) {
            int i = this.a.size;
            for (int i2 = 0; i2 < i; i2++) {
                this.a.get(i2).getSprite().getTexture().dispose();
            }
        }
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch) {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).draw(batch);
        }
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f) {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).draw(batch, f);
        }
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter findEmitter(java.lang.String str) {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.badlogic.gdx.graphics.g2d.ParticleEmitter particleEmitter = this.a.get(i2);
            if (particleEmitter.getName().equals(str)) {
                return particleEmitter;
            }
        }
        return null;
    }

    public void flipY() {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).flipY();
        }
    }

    public com.badlogic.gdx.math.collision.BoundingBox getBoundingBox() {
        if (this.b == null) {
            this.b = new com.badlogic.gdx.math.collision.BoundingBox();
        }
        com.badlogic.gdx.math.collision.BoundingBox boundingBox = this.b;
        boundingBox.inf();
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.ParticleEmitter> it = this.a.iterator();
        while (it.hasNext()) {
            boundingBox.ext(it.next().getBoundingBox());
        }
        return boundingBox;
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.ParticleEmitter> getEmitters() {
        return this.a;
    }

    public boolean isComplete() {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (!this.a.get(i2).isComplete()) {
                return false;
            }
        }
        return true;
    }

    public void load(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.files.FileHandle fileHandle2) {
        loadEmitters(fileHandle);
        loadEmitterImages(fileHandle2);
    }

    public void load(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas) {
        load(fileHandle, textureAtlas, null);
    }

    public void load(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas, java.lang.String str) {
        loadEmitters(fileHandle);
        loadEmitterImages(textureAtlas, str);
    }

    public void loadEmitterImages(com.badlogic.gdx.files.FileHandle fileHandle) {
        this.c = true;
        java.util.HashMap hashMap = new java.util.HashMap(this.a.size);
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.badlogic.gdx.graphics.g2d.ParticleEmitter particleEmitter = this.a.get(i2);
            java.lang.String imagePath = particleEmitter.getImagePath();
            if (imagePath != null) {
                java.lang.String name = new java.io.File(imagePath.replace('\\', '/')).getName();
                com.badlogic.gdx.graphics.g2d.Sprite sprite = (com.badlogic.gdx.graphics.g2d.Sprite) hashMap.get(name);
                if (sprite == null) {
                    sprite = new com.badlogic.gdx.graphics.g2d.Sprite(loadTexture(fileHandle.child(name)));
                    hashMap.put(name, sprite);
                }
                particleEmitter.setSprite(sprite);
            }
        }
    }

    public void loadEmitterImages(com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas) {
        loadEmitterImages(textureAtlas, null);
    }

    public void loadEmitterImages(com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas, java.lang.String str) {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.badlogic.gdx.graphics.g2d.ParticleEmitter particleEmitter = this.a.get(i2);
            java.lang.String imagePath = particleEmitter.getImagePath();
            if (imagePath != null) {
                java.lang.String name = new java.io.File(imagePath.replace('\\', '/')).getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf != -1) {
                    name = name.substring(0, lastIndexOf);
                }
                if (str != null) {
                    name = str + name;
                }
                com.badlogic.gdx.graphics.g2d.Sprite createSprite = textureAtlas.createSprite(name);
                if (createSprite == null) {
                    throw new java.lang.IllegalArgumentException("SpriteSheet missing image: " + name);
                }
                particleEmitter.setSprite(createSprite);
            }
        }
    }

    public void loadEmitters(com.badlogic.gdx.files.FileHandle fileHandle) {
        java.io.InputStream read = fileHandle.read();
        this.a.clear();
        java.io.BufferedReader bufferedReader = null;
        try {
            try {
                java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.InputStreamReader(read), 512);
                do {
                    try {
                        this.a.add(newEmitter(bufferedReader2));
                        if (bufferedReader2.readLine() == null) {
                            break;
                        }
                    } catch (java.io.IOException e) {
                        e = e;
                        bufferedReader = bufferedReader2;
                        throw new com.badlogic.gdx.utils.GdxRuntimeException("Error loading effect: " + fileHandle, e);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        com.badlogic.gdx.utils.StreamUtils.closeQuietly(bufferedReader);
                        throw th;
                    }
                } while (bufferedReader2.readLine() != null);
                com.badlogic.gdx.utils.StreamUtils.closeQuietly(bufferedReader2);
            } catch (java.io.IOException e2) {
                e = e2;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public com.badlogic.gdx.graphics.Texture loadTexture(com.badlogic.gdx.files.FileHandle fileHandle) {
        return new com.badlogic.gdx.graphics.Texture(fileHandle, false);
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter newEmitter(com.badlogic.gdx.graphics.g2d.ParticleEmitter particleEmitter) {
        return new com.badlogic.gdx.graphics.g2d.ParticleEmitter(particleEmitter);
    }

    public com.badlogic.gdx.graphics.g2d.ParticleEmitter newEmitter(java.io.BufferedReader bufferedReader) throws java.io.IOException {
        return new com.badlogic.gdx.graphics.g2d.ParticleEmitter(bufferedReader);
    }

    public void reset() {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).reset();
        }
    }

    public void save(java.io.Writer writer) throws java.io.IOException {
        int i = this.a.size;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            com.badlogic.gdx.graphics.g2d.ParticleEmitter particleEmitter = this.a.get(i2);
            int i4 = i3 + 1;
            if (i3 > 0) {
                writer.write("\n\n");
            }
            particleEmitter.save(writer);
            i2++;
            i3 = i4;
        }
    }

    public void scaleEffect(float f) {
        java.util.Iterator<com.badlogic.gdx.graphics.g2d.ParticleEmitter> it = this.a.iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.graphics.g2d.ParticleEmitter next = it.next();
            next.getScale().setHigh(next.getScale().getHighMin() * f, next.getScale().getHighMax() * f);
            next.getScale().setLow(next.getScale().getLowMin() * f, next.getScale().getLowMax() * f);
            next.getVelocity().setHigh(next.getVelocity().getHighMin() * f, next.getVelocity().getHighMax() * f);
            next.getVelocity().setLow(next.getVelocity().getLowMin() * f, next.getVelocity().getLowMax() * f);
            next.getGravity().setHigh(next.getGravity().getHighMin() * f, next.getGravity().getHighMax() * f);
            next.getGravity().setLow(next.getGravity().getLowMin() * f, next.getGravity().getLowMax() * f);
            next.getWind().setHigh(next.getWind().getHighMin() * f, next.getWind().getHighMax() * f);
            next.getWind().setLow(next.getWind().getLowMin() * f, next.getWind().getLowMax() * f);
            next.getSpawnWidth().setHigh(next.getSpawnWidth().getHighMin() * f, next.getSpawnWidth().getHighMax() * f);
            next.getSpawnWidth().setLow(next.getSpawnWidth().getLowMin() * f, next.getSpawnWidth().getLowMax() * f);
            next.getSpawnHeight().setHigh(next.getSpawnHeight().getHighMin() * f, next.getSpawnHeight().getHighMax() * f);
            next.getSpawnHeight().setLow(next.getSpawnHeight().getLowMin() * f, next.getSpawnHeight().getLowMax() * f);
            next.getXOffsetValue().setLow(next.getXOffsetValue().getLowMin() * f, next.getXOffsetValue().getLowMax() * f);
            next.getYOffsetValue().setLow(next.getYOffsetValue().getLowMin() * f, next.getYOffsetValue().getLowMax() * f);
        }
    }

    public void setDuration(int i) {
        int i2 = this.a.size;
        for (int i3 = 0; i3 < i2; i3++) {
            com.badlogic.gdx.graphics.g2d.ParticleEmitter particleEmitter = this.a.get(i3);
            particleEmitter.setContinuous(false);
            particleEmitter.duration = i;
            particleEmitter.durationTimer = 0.0f;
        }
    }

    public void setEmittersCleanUpBlendFunction(boolean z) {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).setCleansUpBlendFunction(z);
        }
    }

    public void setFlip(boolean z, boolean z2) {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).setFlip(z, z2);
        }
    }

    public void setParticleFade(float f, float f2) {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).setParticleFade(f, f2);
        }
    }

    public void setPosition(float f, float f2) {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).setPosition(f, f2);
        }
    }

    public void start() {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).start();
        }
    }

    public void update(float f) {
        int i = this.a.size;
        for (int i2 = 0; i2 < i; i2++) {
            this.a.get(i2).update(f);
        }
    }
}
