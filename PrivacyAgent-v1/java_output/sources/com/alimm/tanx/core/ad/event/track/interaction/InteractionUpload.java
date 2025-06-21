package com.alimm.tanx.core.ad.event.track.interaction;

/* loaded from: classes.dex */
public class InteractionUpload implements com.alimm.tanx.core.utils.NotConfused {
    public static final int CLOSE = 3;
    private static final java.lang.String INTERACT_DESC = "__INTERACT_DESC__";
    private static final java.lang.String INTERACT_TYPE = "__INTERACT_TYPE__";
    public static final int POOR_CONTENT = 5;
    private static final java.lang.String TAG = "InteractionUpload";
    public static final int UNINTERESTED = 4;
    private static com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload instance;

    /* renamed from: com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload$1, reason: invalid class name */
    public class AnonymousClass1 implements com.alimm.tanx.core.net.callback.NetWorkCallBack {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void error(int i, java.lang.String str, java.lang.String str2) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.TAG, str2);
        }

        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
        public void succ(java.lang.Object obj) {
            com.alimm.tanx.core.utils.LogUtils.d(com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.TAG, "");
        }
    }

    public static com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload getInstance() {
        if (instance == null) {
            synchronized (com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.class) {
                if (instance == null) {
                    instance = new com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload();
                }
            }
        }
        return instance;
    }

    public void uploadInteraction(java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.ITrackItem> list, int i) {
        uploadInteraction(list, i, "");
    }

    public void uploadInteraction(java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.ITrackItem> list, int i, java.lang.String str) {
        uploadInteraction(list, i + "", str);
    }

    public void uploadInteraction(java.util.List<? extends com.alimm.tanx.core.ad.listener.bean.ITrackItem> list, java.lang.String str, java.lang.String str2) {
        if (list != null) {
            for (com.alimm.tanx.core.ad.listener.bean.ITrackItem iTrackItem : list) {
                if (iTrackItem != null && iTrackItem.getType() == 5) {
                    for (java.lang.String str3 : iTrackItem.getUrl()) {
                        if (!android.text.TextUtils.isEmpty(str3)) {
                            try {
                                java.lang.String replace = android.text.TextUtils.isEmpty(str) ? str3.replace(INTERACT_TYPE, "") : str3.replace(INTERACT_TYPE, str);
                                str3 = android.text.TextUtils.isEmpty(str2) ? replace.replace(INTERACT_DESC, "") : replace.replace(INTERACT_DESC, str2);
                            } catch (java.lang.Exception e) {
                                com.alimm.tanx.core.utils.LogUtils.e("uploadInteraction", e);
                            }
                            com.alimm.tanx.core.net.bean.RequestBean build = new com.alimm.tanx.core.net.bean.RequestBean().setUrl(str3).build();
                            build.setOverrideError(true);
                            com.alimm.tanx.core.net.NetWorkManager.getInstance().sendHttpGet(build, java.lang.Object.class, false, false, new com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload.AnonymousClass1());
                        }
                    }
                }
            }
        }
    }
}
