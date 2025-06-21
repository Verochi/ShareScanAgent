package com.aliyun.aio_stat;

/* loaded from: classes.dex */
public class ParamGetter {

    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.aliyun.aio_stat.ParamGetter.b.values().length];
            a = iArr;
            try {
                iArr[com.aliyun.aio_stat.ParamGetter.b.cpu_usage.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
        }
    }

    public enum b {
        event_id,
        stm,
        stat_log_id,
        stat_log_seq,
        stat_log_priority,
        session_id,
        terminal_type,
        device_model,
        os_name,
        os_version,
        uuid,
        application_id,
        application_name,
        application_version,
        cpu_processor,
        cpu_info,
        gpu_info,
        opengl_version,
        device_brand,
        device_manufacturer,
        device_feature,
        cpu_usage,
        mem_usage,
        mem_total,
        electric_usage,
        network_type,
        android_sdk_version,
        install_uuid,
        stat_log_ver,
        time_zone
    }

    @com.aliyun.aio.keep.CalledByNative
    public static java.lang.String getParamValue(int i) {
        return com.aliyun.aio_stat.ParamGetter.a.a[com.aliyun.aio_stat.ParamGetter.b.values()[i].ordinal()] != 1 ? "" : java.lang.String.valueOf(com.aliyun.aio_stat.a.d().e());
    }
}
