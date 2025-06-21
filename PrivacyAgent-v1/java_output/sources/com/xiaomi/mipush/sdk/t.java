package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
public class t {
    public static <T extends com.xiaomi.push.hw<T, ?>> void a(android.content.Context context, com.xiaomi.a.a.a aVar) {
        if (aVar == null) {
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setAction("action_cr_config");
        intent.putExtra("action_cr_event_switch", aVar.b);
        intent.putExtra("action_cr_event_frequency", aVar.e);
        intent.putExtra("action_cr_perf_switch", aVar.c);
        intent.putExtra("action_cr_perf_frequency", aVar.f);
        intent.putExtra("action_cr_event_en", aVar.a);
        intent.putExtra("action_cr_max_file_size", aVar.d);
        com.xiaomi.mipush.sdk.ao.a(context).m118a(intent);
    }
}
