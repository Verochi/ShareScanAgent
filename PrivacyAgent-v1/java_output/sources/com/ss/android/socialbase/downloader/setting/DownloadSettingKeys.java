package com.ss.android.socialbase.downloader.setting;

/* loaded from: classes19.dex */
public interface DownloadSettingKeys {
    public static final java.lang.String BUG_FIX = "bugfix";
    public static final java.lang.String CANCEL_WITH_NET_OPT = "cancel_with_net_opt";
    public static final java.lang.String DEBUG = "debug";
    public static final java.lang.String DEFAULT_304_MAX_AGE = "default_304_max_age";
    public static final java.lang.String DISABLED_TASK_KEYS = "disabled_task_keys";
    public static final java.lang.String DISABLE_SQLITE_WAL = "disable_sqlite_wal";
    public static final java.lang.String DISABLE_TASK_SETTING = "disable_task_setting";
    public static final java.lang.String DIVIDE_PLUGIN = "divide_plugin";
    public static final java.lang.String DNS_EXPIRE_MIN = "dns_expire_min";
    public static final java.lang.String DOWNLOAD_FAILED_CHECK_NET = "download_failed_check_net";
    public static final java.lang.String DOWNLOAD_FINISH_CHECK_TTMD5 = "download_finish_check_ttmd5";
    public static final java.lang.String DOWNLOAD_SERVICE_FOREGROUND = "download_service_foreground";
    public static final java.lang.String DOWNLOAD_WHEN_SPACE_NEGATIVE = "download_when_space_negative";
    public static final java.lang.String ENABLE_REFLECT_SYSTEM_PROPERTIES = "enable_reflect_system_properties";
    public static final java.lang.String FLUSH_BUFFER_SIZE_BYTE = "flush_buffer_size_byte";
    public static final java.lang.String FORCE_CHECK_FILE_LENGTH = "force_check_file_length";
    public static final java.lang.String FORCE_CLOSE_DOWNLOAD_CACHE_CHECK = "force_close_download_cache_check";
    public static final java.lang.String GLOBAL_KEY_PRECONNECT_CONNECTION_OUTDATE_TIME = "preconnect_connection_outdate_time";
    public static final java.lang.String GLOBAL_KEY_PRECONNECT_HEAD_INFO_OUTDATE_TIME = "preconnect_head_info_outdate_time";
    public static final java.lang.String GLOBAL_KEY_PRECONNECT_MAX_CACHE_SIZE = "preconnect_max_cache_size";
    public static final java.lang.String KEY_AH_PLANS = "ah_plans";
    public static final java.lang.String KEY_ANTI_HIJACK_DIR = "download_dir";
    public static final java.lang.String KEY_APP_INSTALL_RETURN_RESULT = "app_install_return_result";
    public static final java.lang.String KEY_EXCEPTION_MSG_LENGTH = "exception_msg_length";
    public static final java.lang.String KEY_PAUSE_RESERVE_ON_WIFI = "pause_reserve_on_wifi";
    public static final java.lang.String KEY_SET_NOTIFICATION_GROUP = "set_notification_group";
    public static final java.lang.String MONITOR_DOWNLOAD_CONNECT = "monitor_download_connect";
    public static final java.lang.String MONITOR_DOWNLOAD_IO = "monitor_download_io";
    public static final java.lang.String MONITOR_RW = "monitor_rw";
    public static final java.lang.String MONITOR_SEGMENT_IO = "monitor_segment_io";
    public static final java.lang.String MONITOR_SLA = "monitor_sla";
    public static final java.lang.String NET_LIB_STRATEGY = "net_lib_strategy";
    public static final java.lang.String NOTIFICATION_TEXT_OPT = "notification_text_opt";
    public static final java.lang.String NOTIFICATION_TIME_WINDOW = "notification_time_window";
    public static final java.lang.String NO_HIDE_NOTIFICATION = "no_hide_notification";
    public static final java.lang.String NO_NET_OPT = "no_net_opt";
    public static final java.lang.String OPT_MKDIR_FAILED = "opt_mkdir_failed";
    public static final java.lang.String OPT_NOTIFICATION_UI = "enable_notification_ui";
    public static final java.lang.String PACKAGE_FLAG_CONFIG = "package_flag_config";
    public static final java.lang.String RESET_RETAIN_RETRY_TIMES = "reset_retain_retry_times";
    public static final java.lang.String RETRY_SCHEDULE = "retry_schedule";
    public static final java.lang.String RETRY_SCHEDULE_CONFIG = "retry_schedule_config";
    public static final java.lang.String RW_CONCURRENT = "rw_concurrent";
    public static final java.lang.String RW_CONCURRENT_MAX_BUFFER_COUNT = "rw_concurrent_max_buffer_count";
    public static final java.lang.String SAVE_PATH_SECURITY = "save_path_security";
    public static final java.lang.String SEGMENT_CONFIG = "segment_config";
    public static final java.lang.String SETTING_TAG = "setting_tag";
    public static final java.lang.String SPACE_FILL_MIN_KEEP_MB = "space_fill_min_keep_mb";
    public static final java.lang.String SPACE_FILL_PART_DOWNLOAD = "space_fill_part_download";
    public static final java.lang.String SYNC_INTERVAL_MS_BG = "sync_interval_ms_bg";
    public static final java.lang.String SYNC_INTERVAL_MS_FG = "sync_interval_ms_fg";
    public static final java.lang.String SYNC_STRATEGY = "sync_strategy";
    public static final java.lang.String USE_HOST_DNS = "use_host_dns";
    public static final java.lang.String USE_NETWORK_CALLBACK = "use_network_callback";
    public static final java.lang.String oppo = "kllk";

    public interface AhPlans {
        public static final java.lang.String KEY_AH_DEVICE_PLANS = "device_plans";
        public static final java.lang.String KEY_AH_DEVICE_REQUIREMENTS = "device_requirements";
        public static final java.lang.String KEY_AH_DEVICE_ROM = "device_rom";
        public static final java.lang.String KEY_AH_PLAN_TYPE = "type";
        public static final java.lang.String KEY_ALLOW_OS_API_RANGE = "allow_os_api_range";
        public static final java.lang.String KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP = "show_unknown_source_on_startup";
        public static final java.lang.String KEY_JUMP_INTERVAL = "jump_interval";
        public static final java.lang.String KEY_JUMP_UNKNOWN_SOURCE_ENABLE_FOR_ALL = "enable_for_all";
        public static final java.lang.String KEY_JUMP_UNKNOWN_SOURCE_TIPS = "jump_unknown_source_tips";
        public static final java.lang.String KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL = "query_interval";
        public static final java.lang.String KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT = "time_out_second";
        public static final java.lang.String KEY_MIN_OS_API = "min_os_api";
        public static final java.lang.String KEY_SECURITY_MODE = "scy_mode";
        public static final java.lang.String KEY_SHOW_TIPS = "show_tips";
        public static final java.lang.String KEY_SHOW_UNKNOWN_SOURCE_DIALOG = "show_unknown_source_dialog";

        public interface DeviceRequirements {
            public static final java.lang.String KEY_ALLOW_VERSION_RANGE = "allow_version_range";
            public static final java.lang.String KEY_ANTI_HIJACK_PACKAGE_NAMES = "package_names";
            public static final java.lang.String KEY_ANTI_HIJACK_VERSION_ALLOW = "version_allow";
            public static final java.lang.String KEY_ANTI_HIJACK_VERSION_BLOCK = "version_block";
        }
    }

    public interface AntiHijackDir {
        public static final java.lang.String KEY_ANTI_HIJACK_DIR_NAME = "dir_name";
        public static final java.lang.String KEY_ANTI_HIJACK_INSTALL_DESC = "ins_desc";
        public static final java.lang.String KEY_IGNORE_TASK_SAVE_PATH = "ignore_task_save_path";
    }

    public interface BugFix {
        public static final java.lang.String BUGFIX_CLEAR_INVALID_TASK_ERROR = "clear_invalid_task_error";
        public static final java.lang.String BUGFIX_FIX_GET_HTTP_RESP_HEAD_IGNORE_CASE = "fix_get_http_resp_head_ignore_case";
        public static final java.lang.String BUGFIX_FIX_START_WITH_FILE_EXIST_UPDATE_ERROR = "fix_start_with_file_exist_update_error";
        public static final java.lang.String BUGFIX_GET_DOWNLOAD_INFO_BY_LIST = "get_download_info_by_list";
        public static final java.lang.String BUGFIX_PAUSE_WITH_INTERRUPT = "pause_with_interrupt";
        public static final java.lang.String BUGFIX_SIGBUS_DOWNLOADER_DB = "fix_sigbus_downloader_db";
        public static final java.lang.String DEFAULT = "default";
        public static final java.lang.String FIX_END_FOR_FILE_EXIST_ERROR = "fix_end_for_file_exist_error";
        public static final java.lang.String FIX_FILE_DATA_VALID = "fix_file_data_valid";
        public static final java.lang.String FIX_FILE_EXIST_UPDATE_DOWNLOAD_INFO = "fix_file_exist_update_download_info";
        public static final java.lang.String FIX_FILE_RENAME_FAILED = "fix_file_rename_failed";
        public static final java.lang.String FIX_GET_TOTAL_BYTES = "fix_get_total_bytes";
        public static final java.lang.String FIX_NOTIFY_TOO_FAST = "notify_too_fast";
        public static final java.lang.String FIX_ON_CANCEL_CALL_TWICE = "fix_on_cancel_call_twice";
        public static final java.lang.String FIX_RESUME_TASK_OVERRIDE_SETTINGS = "resume_task_override_settings";
        public static final java.lang.String FIX_TASK_RESUME_DELAY = "task_resume_delay";
        public static final java.lang.String IGNORE_BASE_EX_ON_STOP_STATUS = "ignore_base_ex_on_stop_status";
        public static final java.lang.String NON_GOING_NOTIFICATION_FOREGROUND = "non_going_notification_foreground";
        public static final java.lang.String NOT_AUTO_BOOT_SERVICE = "switch_not_auto_boot_service";
        public static final java.lang.String NOT_DELETE_WHEN_CLEAN_SPACE = "not_delete_when_clean_space";
        public static final java.lang.String SERVICE_ALIVE = "service_alive";
        public static final java.lang.String STATUS_NOT_UPDATE_TO_DB = "status_not_update_to_db";
    }

    public interface OptimizeForError {
        public static final java.lang.String OPTIMIZE_ADD_LISTENER = "optimize_add_listener";
        public static final java.lang.String OPTIMIZE_HEAD_REQUEST = "optimize_head_request";
        public static final java.lang.String OPTIMIZE_SAVE_PATH = "optimize_save_path";
    }

    public interface RetryScheduleConfig {
        public static final java.lang.String ALLOW_ERROR_CODE = "allow_error_code";
        public static final java.lang.String INTERVAL_SEC = "interval_sec";
        public static final java.lang.String INTERVAL_SEC_ACCELERATION = "interval_sec_acceleration";
        public static final java.lang.String MAX_COUNT = "max_count";
        public static final java.lang.String USE_JOB_SCHEDULER = "use_job_scheduler";
    }

    public interface SegmentConfig {
        public static final java.lang.String BUFFER_COUNT = "buffer_count";
        public static final java.lang.String BUFFER_SIZE = "buffer_size";
        public static final java.lang.String CONNECT_TIMEOUT = "connect_timeout";
        public static final java.lang.String IP_STRATEGY = "ip_strategy";
        public static final java.lang.String MAIN_RATIO = "main_ratio";
        public static final java.lang.String POOR_SPEED_RATIO = "poor_speed_ratio";
        public static final java.lang.String RATIO_SEGMENT = "ratio_segment";
        public static final java.lang.String READ_TIMEOUT = "read_timeout";
        public static final java.lang.String SEGMENT_MAX_KB = "segment_max_kb";
        public static final java.lang.String SEGMENT_MIN_INIT_MB = "segment_min_init_mb";
        public static final java.lang.String SEGMENT_MIN_KB = "segment_min_kb";
        public static final java.lang.String SEGMENT_MODE = "segment_mode";
        public static final java.lang.String THREAD_COUNT = "thread_count";
        public static final java.lang.String URL_BALANCE = "url_balance";
    }
}
