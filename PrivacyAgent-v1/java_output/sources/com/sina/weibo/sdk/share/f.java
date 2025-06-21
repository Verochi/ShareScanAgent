package com.sina.weibo.sdk.share;

/* loaded from: classes19.dex */
public final class f {
    public java.lang.ref.WeakReference<android.app.Activity> g;

    public f(android.app.Activity activity) {
        this.g = new java.lang.ref.WeakReference<>(activity);
    }

    public final void b(com.sina.weibo.sdk.api.WeiboMultiMessage weiboMultiMessage) {
        android.app.Activity activity = this.g.get();
        if (activity == null) {
            return;
        }
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putInt("_weibo_command_type", 1);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(java.lang.System.currentTimeMillis());
        bundle.putString("_weibo_transaction", sb.toString());
        bundle.putAll(weiboMultiMessage.writeToBundle(bundle));
        android.content.Intent intent = new android.content.Intent(activity, (java.lang.Class<?>) com.sina.weibo.sdk.share.ShareTransActivity.class);
        intent.putExtra("start_flag", 0);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, 10001);
    }
}
