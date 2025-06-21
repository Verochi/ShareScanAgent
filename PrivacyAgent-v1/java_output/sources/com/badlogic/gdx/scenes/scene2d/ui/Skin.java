package com.badlogic.gdx.scenes.scene2d.ui;

/* loaded from: classes12.dex */
public class Skin implements com.badlogic.gdx.utils.Disposable {
    public com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object>> a = new com.badlogic.gdx.utils.ObjectMap<>();
    public com.badlogic.gdx.graphics.g2d.TextureAtlas b;

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Skin$1, reason: invalid class name */
    public class AnonymousClass1 extends com.badlogic.gdx.utils.Json {
        public AnonymousClass1() {
        }

        @Override // com.badlogic.gdx.utils.Json
        public <T> T readValue(java.lang.Class<T> cls, java.lang.Class cls2, com.badlogic.gdx.utils.JsonValue jsonValue) {
            return (!jsonValue.isString() || com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(java.lang.CharSequence.class, cls)) ? (T) super.readValue(cls, cls2, jsonValue) : (T) com.badlogic.gdx.scenes.scene2d.ui.Skin.this.get(jsonValue.asString(), cls);
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Skin$2, reason: invalid class name */
    public class AnonymousClass2 extends com.badlogic.gdx.utils.Json.ReadOnlySerializer<com.badlogic.gdx.scenes.scene2d.ui.Skin> {
        public final /* synthetic */ com.badlogic.gdx.scenes.scene2d.ui.Skin a;

        public AnonymousClass2(com.badlogic.gdx.scenes.scene2d.ui.Skin skin) {
            this.a = skin;
        }

        @Override // com.badlogic.gdx.utils.Json.ReadOnlySerializer, com.badlogic.gdx.utils.Json.Serializer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.badlogic.gdx.scenes.scene2d.ui.Skin read(com.badlogic.gdx.utils.Json json, com.badlogic.gdx.utils.JsonValue jsonValue, java.lang.Class cls) {
            for (com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.child; jsonValue2 != null; jsonValue2 = jsonValue2.next) {
                try {
                    b(json, com.badlogic.gdx.utils.reflect.ClassReflection.forName(jsonValue2.name()), jsonValue2);
                } catch (com.badlogic.gdx.utils.reflect.ReflectionException e) {
                    throw new com.badlogic.gdx.utils.SerializationException(e);
                }
            }
            return this.a;
        }

        public final void b(com.badlogic.gdx.utils.Json json, java.lang.Class cls, com.badlogic.gdx.utils.JsonValue jsonValue) {
            java.lang.Class cls2 = cls == com.badlogic.gdx.scenes.scene2d.ui.Skin.TintedDrawable.class ? com.badlogic.gdx.scenes.scene2d.utils.Drawable.class : cls;
            for (com.badlogic.gdx.utils.JsonValue jsonValue2 = jsonValue.child; jsonValue2 != null; jsonValue2 = jsonValue2.next) {
                java.lang.Object readValue = json.readValue(cls, jsonValue2);
                if (readValue != null) {
                    try {
                        com.badlogic.gdx.scenes.scene2d.ui.Skin.this.add(jsonValue2.name, readValue, cls2);
                        if (cls2 != com.badlogic.gdx.scenes.scene2d.utils.Drawable.class && com.badlogic.gdx.utils.reflect.ClassReflection.isAssignableFrom(com.badlogic.gdx.scenes.scene2d.utils.Drawable.class, cls2)) {
                            com.badlogic.gdx.scenes.scene2d.ui.Skin.this.add(jsonValue2.name, readValue, com.badlogic.gdx.scenes.scene2d.utils.Drawable.class);
                        }
                    } catch (java.lang.Exception e) {
                        throw new com.badlogic.gdx.utils.SerializationException("Error reading " + com.badlogic.gdx.utils.reflect.ClassReflection.getSimpleName(cls) + ": " + jsonValue2.name, e);
                    }
                }
            }
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Skin$3, reason: invalid class name */
    public class AnonymousClass3 extends com.badlogic.gdx.utils.Json.ReadOnlySerializer<com.badlogic.gdx.graphics.g2d.BitmapFont> {
        public final /* synthetic */ com.badlogic.gdx.files.FileHandle a;
        public final /* synthetic */ com.badlogic.gdx.scenes.scene2d.ui.Skin b;

        public AnonymousClass3(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.scenes.scene2d.ui.Skin skin) {
            this.a = fileHandle;
            this.b = skin;
        }

        @Override // com.badlogic.gdx.utils.Json.ReadOnlySerializer, com.badlogic.gdx.utils.Json.Serializer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.badlogic.gdx.graphics.g2d.BitmapFont read(com.badlogic.gdx.utils.Json json, com.badlogic.gdx.utils.JsonValue jsonValue, java.lang.Class cls) {
            com.badlogic.gdx.graphics.g2d.BitmapFont bitmapFont;
            java.lang.String str = (java.lang.String) json.readValue("file", java.lang.String.class, jsonValue);
            int intValue = ((java.lang.Integer) json.readValue("scaledSize", (java.lang.Class<java.lang.Class>) java.lang.Integer.TYPE, (java.lang.Class) (-1), jsonValue)).intValue();
            java.lang.Boolean bool = java.lang.Boolean.FALSE;
            java.lang.Boolean bool2 = (java.lang.Boolean) json.readValue("flip", (java.lang.Class<java.lang.Class>) java.lang.Boolean.class, (java.lang.Class) bool, jsonValue);
            java.lang.Boolean bool3 = (java.lang.Boolean) json.readValue("markupEnabled", (java.lang.Class<java.lang.Class>) java.lang.Boolean.class, (java.lang.Class) bool, jsonValue);
            com.badlogic.gdx.files.FileHandle child = this.a.parent().child(str);
            if (!child.exists()) {
                child = com.badlogic.gdx.Gdx.files.internal(str);
            }
            if (!child.exists()) {
                throw new com.badlogic.gdx.utils.SerializationException("Font file not found: " + child);
            }
            java.lang.String nameWithoutExtension = child.nameWithoutExtension();
            try {
                com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion> regions = this.b.getRegions(nameWithoutExtension);
                if (regions != null) {
                    bitmapFont = new com.badlogic.gdx.graphics.g2d.BitmapFont(new com.badlogic.gdx.graphics.g2d.BitmapFont.BitmapFontData(child, bool2.booleanValue()), regions, true);
                } else {
                    com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion = (com.badlogic.gdx.graphics.g2d.TextureRegion) this.b.optional(nameWithoutExtension, com.badlogic.gdx.graphics.g2d.TextureRegion.class);
                    if (textureRegion != null) {
                        bitmapFont = new com.badlogic.gdx.graphics.g2d.BitmapFont(child, textureRegion, bool2.booleanValue());
                    } else {
                        com.badlogic.gdx.files.FileHandle child2 = child.parent().child(nameWithoutExtension + ".png");
                        bitmapFont = child2.exists() ? new com.badlogic.gdx.graphics.g2d.BitmapFont(child, child2, bool2.booleanValue()) : new com.badlogic.gdx.graphics.g2d.BitmapFont(child, bool2.booleanValue());
                    }
                }
                bitmapFont.getData().markupEnabled = bool3.booleanValue();
                if (intValue != -1) {
                    bitmapFont.getData().setScale(intValue / bitmapFont.getCapHeight());
                }
                return bitmapFont;
            } catch (java.lang.RuntimeException e) {
                throw new com.badlogic.gdx.utils.SerializationException("Error loading bitmap font: " + child, e);
            }
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Skin$4, reason: invalid class name */
    public class AnonymousClass4 extends com.badlogic.gdx.utils.Json.ReadOnlySerializer<com.badlogic.gdx.graphics.Color> {
        public AnonymousClass4() {
        }

        @Override // com.badlogic.gdx.utils.Json.ReadOnlySerializer, com.badlogic.gdx.utils.Json.Serializer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.badlogic.gdx.graphics.Color read(com.badlogic.gdx.utils.Json json, com.badlogic.gdx.utils.JsonValue jsonValue, java.lang.Class cls) {
            if (jsonValue.isString()) {
                return (com.badlogic.gdx.graphics.Color) com.badlogic.gdx.scenes.scene2d.ui.Skin.this.get(jsonValue.asString(), com.badlogic.gdx.graphics.Color.class);
            }
            java.lang.String str = (java.lang.String) json.readValue("hex", (java.lang.Class<java.lang.Class>) java.lang.String.class, (java.lang.Class) null, jsonValue);
            if (str != null) {
                return com.badlogic.gdx.graphics.Color.valueOf(str);
            }
            java.lang.Class cls2 = java.lang.Float.TYPE;
            return new com.badlogic.gdx.graphics.Color(((java.lang.Float) json.readValue("r", (java.lang.Class<java.lang.Class>) cls2, (java.lang.Class) java.lang.Float.valueOf(0.0f), jsonValue)).floatValue(), ((java.lang.Float) json.readValue("g", (java.lang.Class<java.lang.Class>) cls2, (java.lang.Class) java.lang.Float.valueOf(0.0f), jsonValue)).floatValue(), ((java.lang.Float) json.readValue("b", (java.lang.Class<java.lang.Class>) cls2, (java.lang.Class) java.lang.Float.valueOf(0.0f), jsonValue)).floatValue(), ((java.lang.Float) json.readValue("a", (java.lang.Class<java.lang.Class>) cls2, (java.lang.Class) java.lang.Float.valueOf(1.0f), jsonValue)).floatValue());
        }
    }

    /* renamed from: com.badlogic.gdx.scenes.scene2d.ui.Skin$5, reason: invalid class name */
    public class AnonymousClass5 extends com.badlogic.gdx.utils.Json.ReadOnlySerializer {
        public AnonymousClass5() {
        }

        @Override // com.badlogic.gdx.utils.Json.ReadOnlySerializer, com.badlogic.gdx.utils.Json.Serializer
        public java.lang.Object read(com.badlogic.gdx.utils.Json json, com.badlogic.gdx.utils.JsonValue jsonValue, java.lang.Class cls) {
            java.lang.String str = (java.lang.String) json.readValue("name", java.lang.String.class, jsonValue);
            com.badlogic.gdx.graphics.Color color = (com.badlogic.gdx.graphics.Color) json.readValue("color", com.badlogic.gdx.graphics.Color.class, jsonValue);
            com.badlogic.gdx.scenes.scene2d.utils.Drawable newDrawable = com.badlogic.gdx.scenes.scene2d.ui.Skin.this.newDrawable(str, color);
            if (newDrawable instanceof com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable) {
                ((com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable) newDrawable).setName(jsonValue.name + " (" + str + ", " + color + ")");
            }
            return newDrawable;
        }
    }

    public static class TintedDrawable {
        public com.badlogic.gdx.graphics.Color color;
        public java.lang.String name;
    }

    public Skin() {
    }

    public Skin(com.badlogic.gdx.files.FileHandle fileHandle) {
        com.badlogic.gdx.files.FileHandle sibling = fileHandle.sibling(fileHandle.nameWithoutExtension() + ".atlas");
        if (sibling.exists()) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas = new com.badlogic.gdx.graphics.g2d.TextureAtlas(sibling);
            this.b = textureAtlas;
            addRegions(textureAtlas);
        }
        load(fileHandle);
    }

    public Skin(com.badlogic.gdx.files.FileHandle fileHandle, com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas) {
        this.b = textureAtlas;
        addRegions(textureAtlas);
        load(fileHandle);
    }

    public Skin(com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas) {
        this.b = textureAtlas;
        addRegions(textureAtlas);
    }

    public static com.badlogic.gdx.utils.reflect.Method a(java.lang.Class cls, java.lang.String str) {
        for (com.badlogic.gdx.utils.reflect.Method method : com.badlogic.gdx.utils.reflect.ClassReflection.getMethods(cls)) {
            if (method.getName().equals(str)) {
                return method;
            }
        }
        return null;
    }

    public void add(java.lang.String str, java.lang.Object obj) {
        add(str, obj, obj.getClass());
    }

    public void add(java.lang.String str, java.lang.Object obj, java.lang.Class cls) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("resource cannot be null.");
        }
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object> objectMap = this.a.get(cls);
        if (objectMap == null) {
            objectMap = new com.badlogic.gdx.utils.ObjectMap<>((cls == com.badlogic.gdx.graphics.g2d.TextureRegion.class || cls == com.badlogic.gdx.scenes.scene2d.utils.Drawable.class || cls == com.badlogic.gdx.graphics.g2d.Sprite.class) ? 256 : 64);
            this.a.put(cls, objectMap);
        }
        objectMap.put(str, obj);
    }

    public void addRegions(com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas) {
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion> regions = textureAtlas.getRegions();
        int i = regions.size;
        for (int i2 = 0; i2 < i; i2++) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = regions.get(i2);
            java.lang.String str = atlasRegion.name;
            if (atlasRegion.index != -1) {
                str = str + "_" + atlasRegion.index;
            }
            add(str, atlasRegion, com.badlogic.gdx.graphics.g2d.TextureRegion.class);
        }
    }

    @Override // com.badlogic.gdx.utils.Disposable
    public void dispose() {
        com.badlogic.gdx.graphics.g2d.TextureAtlas textureAtlas = this.b;
        if (textureAtlas != null) {
            textureAtlas.dispose();
        }
        com.badlogic.gdx.utils.ObjectMap.Values<com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object>> it = this.a.values().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.ObjectMap.Values<java.lang.Object> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                java.lang.Object next = it2.next();
                if (next instanceof com.badlogic.gdx.utils.Disposable) {
                    ((com.badlogic.gdx.utils.Disposable) next).dispose();
                }
            }
        }
    }

    public java.lang.String find(java.lang.Object obj) {
        if (obj == null) {
            throw new java.lang.IllegalArgumentException("style cannot be null.");
        }
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object> objectMap = this.a.get(obj.getClass());
        if (objectMap == null) {
            return null;
        }
        return objectMap.findKey(obj, true);
    }

    public <T> T get(java.lang.Class<T> cls) {
        return (T) get("default", cls);
    }

    public <T> T get(java.lang.String str, java.lang.Class<T> cls) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("type cannot be null.");
        }
        if (cls == com.badlogic.gdx.scenes.scene2d.utils.Drawable.class) {
            return (T) getDrawable(str);
        }
        if (cls == com.badlogic.gdx.graphics.g2d.TextureRegion.class) {
            return (T) getRegion(str);
        }
        if (cls == com.badlogic.gdx.graphics.g2d.NinePatch.class) {
            return (T) getPatch(str);
        }
        if (cls == com.badlogic.gdx.graphics.g2d.Sprite.class) {
            return (T) getSprite(str);
        }
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object> objectMap = this.a.get(cls);
        if (objectMap == null) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
        }
        T t = (T) objectMap.get(str);
        if (t != null) {
            return t;
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("No " + cls.getName() + " registered with name: " + str);
    }

    public <T> com.badlogic.gdx.utils.ObjectMap<java.lang.String, T> getAll(java.lang.Class<T> cls) {
        return (com.badlogic.gdx.utils.ObjectMap) this.a.get(cls);
    }

    public com.badlogic.gdx.graphics.g2d.TextureAtlas getAtlas() {
        return this.b;
    }

    public com.badlogic.gdx.graphics.Color getColor(java.lang.String str) {
        return (com.badlogic.gdx.graphics.Color) get(str, com.badlogic.gdx.graphics.Color.class);
    }

    public com.badlogic.gdx.scenes.scene2d.utils.Drawable getDrawable(java.lang.String str) {
        com.badlogic.gdx.scenes.scene2d.utils.Drawable spriteDrawable;
        com.badlogic.gdx.scenes.scene2d.utils.Drawable spriteDrawable2;
        com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable = (com.badlogic.gdx.scenes.scene2d.utils.Drawable) optional(str, com.badlogic.gdx.scenes.scene2d.utils.Drawable.class);
        if (drawable != null) {
            return drawable;
        }
        try {
            com.badlogic.gdx.graphics.g2d.TextureRegion region = getRegion(str);
            if (region instanceof com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) {
                com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = (com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) region;
                if (atlasRegion.splits != null) {
                    spriteDrawable2 = new com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable(getPatch(str));
                } else if (atlasRegion.rotate || atlasRegion.packedWidth != atlasRegion.originalWidth || atlasRegion.packedHeight != atlasRegion.originalHeight) {
                    spriteDrawable2 = new com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable(getSprite(str));
                }
                drawable = spriteDrawable2;
            }
            if (drawable == null) {
                drawable = new com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable(region);
            }
        } catch (com.badlogic.gdx.utils.GdxRuntimeException unused) {
        }
        if (drawable == null) {
            com.badlogic.gdx.graphics.g2d.NinePatch ninePatch = (com.badlogic.gdx.graphics.g2d.NinePatch) optional(str, com.badlogic.gdx.graphics.g2d.NinePatch.class);
            if (ninePatch != null) {
                spriteDrawable = new com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable(ninePatch);
            } else {
                com.badlogic.gdx.graphics.g2d.Sprite sprite = (com.badlogic.gdx.graphics.g2d.Sprite) optional(str, com.badlogic.gdx.graphics.g2d.Sprite.class);
                if (sprite == null) {
                    throw new com.badlogic.gdx.utils.GdxRuntimeException("No Drawable, NinePatch, TextureRegion, Texture, or Sprite registered with name: " + str);
                }
                spriteDrawable = new com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable(sprite);
            }
            drawable = spriteDrawable;
        }
        if (drawable instanceof com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable) {
            ((com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable) drawable).setName(str);
        }
        add(str, drawable, com.badlogic.gdx.scenes.scene2d.utils.Drawable.class);
        return drawable;
    }

    public com.badlogic.gdx.graphics.g2d.BitmapFont getFont(java.lang.String str) {
        return (com.badlogic.gdx.graphics.g2d.BitmapFont) get(str, com.badlogic.gdx.graphics.g2d.BitmapFont.class);
    }

    public com.badlogic.gdx.utils.Json getJsonLoader(com.badlogic.gdx.files.FileHandle fileHandle) {
        com.badlogic.gdx.scenes.scene2d.ui.Skin.AnonymousClass1 anonymousClass1 = new com.badlogic.gdx.scenes.scene2d.ui.Skin.AnonymousClass1();
        anonymousClass1.setTypeName(null);
        anonymousClass1.setUsePrototypes(false);
        anonymousClass1.setSerializer(com.badlogic.gdx.scenes.scene2d.ui.Skin.class, new com.badlogic.gdx.scenes.scene2d.ui.Skin.AnonymousClass2(this));
        anonymousClass1.setSerializer(com.badlogic.gdx.graphics.g2d.BitmapFont.class, new com.badlogic.gdx.scenes.scene2d.ui.Skin.AnonymousClass3(fileHandle, this));
        anonymousClass1.setSerializer(com.badlogic.gdx.graphics.Color.class, new com.badlogic.gdx.scenes.scene2d.ui.Skin.AnonymousClass4());
        anonymousClass1.setSerializer(com.badlogic.gdx.scenes.scene2d.ui.Skin.TintedDrawable.class, new com.badlogic.gdx.scenes.scene2d.ui.Skin.AnonymousClass5());
        return anonymousClass1;
    }

    public com.badlogic.gdx.graphics.g2d.NinePatch getPatch(java.lang.String str) {
        int[] iArr;
        com.badlogic.gdx.graphics.g2d.NinePatch ninePatch = (com.badlogic.gdx.graphics.g2d.NinePatch) optional(str, com.badlogic.gdx.graphics.g2d.NinePatch.class);
        if (ninePatch != null) {
            return ninePatch;
        }
        try {
            com.badlogic.gdx.graphics.g2d.TextureRegion region = getRegion(str);
            if ((region instanceof com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) && (iArr = ((com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) region).splits) != null) {
                ninePatch = new com.badlogic.gdx.graphics.g2d.NinePatch(region, iArr[0], iArr[1], iArr[2], iArr[3]);
                if (((com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) region).pads != null) {
                    ninePatch.setPadding(r2[0], r2[1], r2[2], r2[3]);
                }
            }
            if (ninePatch == null) {
                ninePatch = new com.badlogic.gdx.graphics.g2d.NinePatch(region);
            }
            add(str, ninePatch, com.badlogic.gdx.graphics.g2d.NinePatch.class);
            return ninePatch;
        } catch (com.badlogic.gdx.utils.GdxRuntimeException unused) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
        }
    }

    public com.badlogic.gdx.graphics.g2d.TextureRegion getRegion(java.lang.String str) {
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion = (com.badlogic.gdx.graphics.g2d.TextureRegion) optional(str, com.badlogic.gdx.graphics.g2d.TextureRegion.class);
        if (textureRegion != null) {
            return textureRegion;
        }
        com.badlogic.gdx.graphics.Texture texture = (com.badlogic.gdx.graphics.Texture) optional(str, com.badlogic.gdx.graphics.Texture.class);
        if (texture != null) {
            com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion2 = new com.badlogic.gdx.graphics.g2d.TextureRegion(texture);
            add(str, textureRegion2, com.badlogic.gdx.graphics.g2d.TextureRegion.class);
            return textureRegion2;
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("No TextureRegion or Texture registered with name: " + str);
    }

    public com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion> getRegions(java.lang.String str) {
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion = (com.badlogic.gdx.graphics.g2d.TextureRegion) optional(str + "_0", com.badlogic.gdx.graphics.g2d.TextureRegion.class);
        if (textureRegion == null) {
            return null;
        }
        com.badlogic.gdx.utils.Array<com.badlogic.gdx.graphics.g2d.TextureRegion> array = new com.badlogic.gdx.utils.Array<>();
        int i = 1;
        while (textureRegion != null) {
            array.add(textureRegion);
            textureRegion = (com.badlogic.gdx.graphics.g2d.TextureRegion) optional(str + "_" + i, com.badlogic.gdx.graphics.g2d.TextureRegion.class);
            i++;
        }
        return array;
    }

    public com.badlogic.gdx.graphics.g2d.Sprite getSprite(java.lang.String str) {
        com.badlogic.gdx.graphics.g2d.Sprite sprite = (com.badlogic.gdx.graphics.g2d.Sprite) optional(str, com.badlogic.gdx.graphics.g2d.Sprite.class);
        if (sprite != null) {
            return sprite;
        }
        try {
            com.badlogic.gdx.graphics.g2d.TextureRegion region = getRegion(str);
            if (region instanceof com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) {
                com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = (com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) region;
                if (atlasRegion.rotate || atlasRegion.packedWidth != atlasRegion.originalWidth || atlasRegion.packedHeight != atlasRegion.originalHeight) {
                    sprite = new com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasSprite(atlasRegion);
                }
            }
            if (sprite == null) {
                sprite = new com.badlogic.gdx.graphics.g2d.Sprite(region);
            }
            add(str, sprite, com.badlogic.gdx.graphics.g2d.Sprite.class);
            return sprite;
        } catch (com.badlogic.gdx.utils.GdxRuntimeException unused) {
            throw new com.badlogic.gdx.utils.GdxRuntimeException("No NinePatch, TextureRegion, or Texture registered with name: " + str);
        }
    }

    public com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable getTiledDrawable(java.lang.String str) {
        com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable tiledDrawable = (com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable) optional(str, com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable.class);
        if (tiledDrawable != null) {
            return tiledDrawable;
        }
        com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable tiledDrawable2 = new com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable(getRegion(str));
        tiledDrawable2.setName(str);
        add(str, tiledDrawable2, com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable.class);
        return tiledDrawable2;
    }

    public boolean has(java.lang.String str, java.lang.Class cls) {
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object> objectMap = this.a.get(cls);
        if (objectMap == null) {
            return false;
        }
        return objectMap.containsKey(str);
    }

    public void load(com.badlogic.gdx.files.FileHandle fileHandle) {
        try {
            getJsonLoader(fileHandle).fromJson(com.badlogic.gdx.scenes.scene2d.ui.Skin.class, fileHandle);
        } catch (com.badlogic.gdx.utils.SerializationException e) {
            throw new com.badlogic.gdx.utils.SerializationException("Error reading file: " + fileHandle, e);
        }
    }

    public com.badlogic.gdx.scenes.scene2d.utils.Drawable newDrawable(com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable) {
        if (drawable instanceof com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable) {
            return new com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable((com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable) drawable);
        }
        if (drawable instanceof com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable) {
            return new com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable((com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable) drawable);
        }
        if (drawable instanceof com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable) {
            return new com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable((com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable) drawable);
        }
        if (drawable instanceof com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable) {
            return new com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable((com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable) drawable);
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Unable to copy, unknown drawable type: " + drawable.getClass());
    }

    public com.badlogic.gdx.scenes.scene2d.utils.Drawable newDrawable(com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable, float f, float f2, float f3, float f4) {
        return newDrawable(drawable, new com.badlogic.gdx.graphics.Color(f, f2, f3, f4));
    }

    public com.badlogic.gdx.scenes.scene2d.utils.Drawable newDrawable(com.badlogic.gdx.scenes.scene2d.utils.Drawable drawable, com.badlogic.gdx.graphics.Color color) {
        com.badlogic.gdx.scenes.scene2d.utils.Drawable tint;
        if (drawable instanceof com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable) {
            tint = ((com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable) drawable).tint(color);
        } else if (drawable instanceof com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable) {
            tint = ((com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable) drawable).tint(color);
        } else {
            if (!(drawable instanceof com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable)) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Unable to copy, unknown drawable type: " + drawable.getClass());
            }
            tint = ((com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable) drawable).tint(color);
        }
        if (tint instanceof com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable) {
            com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable baseDrawable = (com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable) tint;
            if (drawable instanceof com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable) {
                baseDrawable.setName(((com.badlogic.gdx.scenes.scene2d.utils.BaseDrawable) drawable).getName() + " (" + color + ")");
            } else {
                baseDrawable.setName(" (" + color + ")");
            }
        }
        return tint;
    }

    public com.badlogic.gdx.scenes.scene2d.utils.Drawable newDrawable(java.lang.String str) {
        return newDrawable(getDrawable(str));
    }

    public com.badlogic.gdx.scenes.scene2d.utils.Drawable newDrawable(java.lang.String str, float f, float f2, float f3, float f4) {
        return newDrawable(getDrawable(str), new com.badlogic.gdx.graphics.Color(f, f2, f3, f4));
    }

    public com.badlogic.gdx.scenes.scene2d.utils.Drawable newDrawable(java.lang.String str, com.badlogic.gdx.graphics.Color color) {
        return newDrawable(getDrawable(str), color);
    }

    public <T> T optional(java.lang.String str, java.lang.Class<T> cls) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        if (cls == null) {
            throw new java.lang.IllegalArgumentException("type cannot be null.");
        }
        com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Object> objectMap = this.a.get(cls);
        if (objectMap == null) {
            return null;
        }
        return (T) objectMap.get(str);
    }

    public void remove(java.lang.String str, java.lang.Class cls) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("name cannot be null.");
        }
        this.a.get(cls).remove(str);
    }

    public void setEnabled(com.badlogic.gdx.scenes.scene2d.Actor actor, boolean z) {
        com.badlogic.gdx.utils.reflect.Method a = a(actor.getClass(), "getStyle");
        if (a == null) {
            return;
        }
        try {
            java.lang.Object invoke = a.invoke(actor, new java.lang.Object[0]);
            java.lang.String find = find(invoke);
            if (find == null) {
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(find.replace("-disabled", ""));
            sb.append(z ? "" : "-disabled");
            java.lang.Object obj = get(sb.toString(), invoke.getClass());
            com.badlogic.gdx.utils.reflect.Method a2 = a(actor.getClass(), "setStyle");
            if (a2 == null) {
                return;
            }
            a2.invoke(actor, obj);
        } catch (java.lang.Exception unused) {
        }
    }
}
