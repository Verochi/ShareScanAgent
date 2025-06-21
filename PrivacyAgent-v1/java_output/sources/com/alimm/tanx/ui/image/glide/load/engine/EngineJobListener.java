package com.alimm.tanx.ui.image.glide.load.engine;

/* loaded from: classes.dex */
interface EngineJobListener {
    void onEngineJobCancelled(com.alimm.tanx.ui.image.glide.load.engine.EngineJob engineJob, com.alimm.tanx.ui.image.glide.load.Key key);

    void onEngineJobComplete(com.alimm.tanx.ui.image.glide.load.Key key, com.alimm.tanx.ui.image.glide.load.engine.EngineResource<?> engineResource);
}
