package androidx.databinding;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends androidx.databinding.MergedDataBinderMapper {
    static androidx.databinding.DataBinderMapper sTestOverride;

    static {
        try {
            sTestOverride = (androidx.databinding.DataBinderMapper) androidx.databinding.DataBinderMapper.class.getClassLoader().loadClass("androidx.databinding.TestDataBinderMapperImpl").newInstance();
        } catch (java.lang.Throwable unused) {
            sTestOverride = null;
        }
    }

    public DataBinderMapperImpl() {
        addMapper((androidx.databinding.DataBinderMapper) new com.moji.mjweather.DataBinderMapperImpl());
        androidx.databinding.DataBinderMapper dataBinderMapper = sTestOverride;
        if (dataBinderMapper != null) {
            addMapper(dataBinderMapper);
        }
    }
}
