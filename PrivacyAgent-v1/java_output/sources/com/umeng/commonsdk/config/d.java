package com.umeng.commonsdk.config;

/* loaded from: classes19.dex */
public class d {
    public static final long a = 1000;
    public static final java.lang.String b = "_LAST_FIELD";
    public static final java.lang.String c = "3749699455";
    public static final java.lang.String d = "2130669566";
    public static final java.lang.String e = "262139";
    public static final java.lang.String f = "1983";
    public static final int g = 64;
    private static java.util.Map<java.lang.String, java.lang.String[]> l = new java.util.HashMap();
    public static java.lang.String[] h = new java.lang.String[com.umeng.commonsdk.config.d.a.values().length];
    public static java.lang.String[] i = new java.lang.String[com.umeng.commonsdk.config.d.b.values().length];
    public static java.lang.String[] j = new java.lang.String[com.umeng.commonsdk.config.d.c.values().length];
    public static java.lang.String[] k = new java.lang.String[com.umeng.commonsdk.config.d.EnumC0518d.values().length];

    public enum a {
        header_utoken,
        header_cpu,
        header_mccmnc,
        header_sub_os_name,
        header_sub_os_version,
        header_device_type,
        header_device_id_imei,
        header_device_id_mac,
        header_device_id_android_id,
        header_device_id_serialNo,
        header_bulid,
        header_os_version,
        header_resolution,
        header_mc,
        header_timezone,
        header_local_info,
        header_carrier,
        header_access,
        header_tracking_imei,
        header_tracking_android_id,
        header_tracking_utdid,
        header_tracking_idmd5,
        header_tracking_idfa,
        header_tracking_mac,
        header_tracking_serial,
        header_tracking_uuid,
        header_tracking_uop,
        header_tracking_oldumid,
        header_tracking_newumid,
        header_ekv_send_on_exit,
        header_device_oaid,
        header_local_ip,
        header_foreground_count,
        header_first_resume,
        header_sub_os_info,
        header_ntf_switch,
        header_ringer_mode,
        _LAST_FIELD
    }

    public enum b {
        inner_rs,
        inner_by,
        inner_gp,
        inner_to,
        inner_mo,
        inner_ca,
        inner_fl,
        inner_gdf_r,
        inner_thm_z,
        inner_dsk_s,
        inner_sd,
        inner_build,
        inner_sr,
        inner_scr,
        inner_sinfo,
        inner_winfo,
        inner_input,
        inner_bt,
        inner_mem,
        inner_cpu,
        inner_rom,
        inner_bstn,
        inner_cam,
        inner_appls,
        inner_lbs,
        internal_run_server,
        internal_imsi,
        internal_meid,
        tp_tp,
        inner_imei2,
        inner_iccid,
        inner_batt2,
        inner_build2,
        inner_cpu2,
        ccg_switch,
        check_system_app,
        check_pus_permission,
        _LAST_FIELD
    }

    public enum c {
        push_cpu,
        push_imei,
        push_mac,
        push_android_id,
        push_serialNo,
        push_settings_android_id,
        push_network_access_mode,
        push_on_line,
        push_time_zone,
        push_locale_info,
        push_resolution,
        push_operator,
        push_utdid,
        push_service_work,
        push_service_name,
        push_intent_exist,
        push_data_data,
        push_notification_enabled,
        _LAST_FIELD
    }

    /* renamed from: com.umeng.commonsdk.config.d$d, reason: collision with other inner class name */
    public enum EnumC0518d {
        share_device_id,
        share_imsi,
        share_iccid,
        share_sn,
        share_net_accmode,
        share_android_id,
        share_wifi_mac,
        share_sd_size,
        share_ssid,
        share_resolution,
        share_conn_type,
        _LAST_FIELD
    }

    static {
        java.lang.String[] strArr = h;
        if (strArr != null && strArr.length > 0) {
            for (int i2 = 0; i2 < com.umeng.commonsdk.config.d.a.values().length; i2++) {
                h[i2] = com.umeng.commonsdk.config.d.a.values()[i2].toString();
            }
            java.util.Map<java.lang.String, java.lang.String[]> map = l;
            if (map != null) {
                map.put(com.umeng.commonsdk.config.d.a.class.getName(), h);
            }
        }
        java.lang.String[] strArr2 = i;
        if (strArr2 != null && strArr2.length > 0) {
            for (int i3 = 0; i3 < com.umeng.commonsdk.config.d.b.values().length; i3++) {
                i[i3] = com.umeng.commonsdk.config.d.b.values()[i3].toString();
            }
            java.util.Map<java.lang.String, java.lang.String[]> map2 = l;
            if (map2 != null) {
                map2.put(com.umeng.commonsdk.config.d.b.class.getName(), i);
            }
        }
        java.lang.String[] strArr3 = j;
        if (strArr3 != null && strArr3.length > 0) {
            for (int i4 = 0; i4 < com.umeng.commonsdk.config.d.c.values().length; i4++) {
                j[i4] = com.umeng.commonsdk.config.d.c.values()[i4].toString();
            }
            java.util.Map<java.lang.String, java.lang.String[]> map3 = l;
            if (map3 != null) {
                map3.put(com.umeng.commonsdk.config.d.c.class.getName(), j);
            }
        }
        java.lang.String[] strArr4 = k;
        if (strArr4 == null || strArr4.length <= 0) {
            return;
        }
        for (int i5 = 0; i5 < com.umeng.commonsdk.config.d.EnumC0518d.values().length; i5++) {
            k[i5] = com.umeng.commonsdk.config.d.EnumC0518d.values()[i5].toString();
        }
        java.util.Map<java.lang.String, java.lang.String[]> map4 = l;
        if (map4 != null) {
            map4.put(com.umeng.commonsdk.config.d.EnumC0518d.class.getName(), k);
        }
    }

    public static boolean a(java.lang.String str) {
        return (str == null || str.length() <= 0 || b.equalsIgnoreCase(str)) ? false : true;
    }

    public static java.lang.String[] b(java.lang.String str) {
        if (str == null || str.length() <= 0 || !l.containsKey(str)) {
            return null;
        }
        return l.get(str);
    }
}
