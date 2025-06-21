package com.alimm.tanx.core.image;

/* loaded from: classes.dex */
public interface ILoader {
    void load(com.alimm.tanx.core.image.util.ImageConfig imageConfig, com.alimm.tanx.core.image.util.ImageConfig.ImageBitmapCallback imageBitmapCallback);

    void loadGif(com.alimm.tanx.core.image.util.GifConfig gifConfig, com.alimm.tanx.core.image.util.ImageConfig.GifCallback gifCallback);
}
