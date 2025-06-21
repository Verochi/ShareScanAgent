package androidx.databinding.adapters;

@androidx.databinding.InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute = "android:progress", type = android.widget.SeekBar.class)})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class SeekBarBindingAdapter {

    /* renamed from: androidx.databinding.adapters.SeekBarBindingAdapter$1, reason: invalid class name */
    public class AnonymousClass1 implements android.widget.SeekBar.OnSeekBarChangeListener {
        final /* synthetic */ androidx.databinding.InverseBindingListener val$attrChanged;
        final /* synthetic */ androidx.databinding.adapters.SeekBarBindingAdapter.OnProgressChanged val$progressChanged;
        final /* synthetic */ androidx.databinding.adapters.SeekBarBindingAdapter.OnStartTrackingTouch val$start;
        final /* synthetic */ androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch val$stop;

        public AnonymousClass1(androidx.databinding.adapters.SeekBarBindingAdapter.OnProgressChanged onProgressChanged, androidx.databinding.InverseBindingListener inverseBindingListener, androidx.databinding.adapters.SeekBarBindingAdapter.OnStartTrackingTouch onStartTrackingTouch, androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch) {
            this.val$progressChanged = onProgressChanged;
            this.val$attrChanged = inverseBindingListener;
            this.val$start = onStartTrackingTouch;
            this.val$stop = onStopTrackingTouch;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z) {
            androidx.databinding.adapters.SeekBarBindingAdapter.OnProgressChanged onProgressChanged = this.val$progressChanged;
            if (onProgressChanged != null) {
                onProgressChanged.onProgressChanged(seekBar, i, z);
            }
            androidx.databinding.InverseBindingListener inverseBindingListener = this.val$attrChanged;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(android.widget.SeekBar seekBar) {
            androidx.databinding.adapters.SeekBarBindingAdapter.OnStartTrackingTouch onStartTrackingTouch = this.val$start;
            if (onStartTrackingTouch != null) {
                onStartTrackingTouch.onStartTrackingTouch(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(android.widget.SeekBar seekBar) {
            androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch = this.val$stop;
            if (onStopTrackingTouch != null) {
                onStopTrackingTouch.onStopTrackingTouch(seekBar);
            }
        }
    }

    public interface OnProgressChanged {
        void onProgressChanged(android.widget.SeekBar seekBar, int i, boolean z);
    }

    public interface OnStartTrackingTouch {
        void onStartTrackingTouch(android.widget.SeekBar seekBar);
    }

    public interface OnStopTrackingTouch {
        void onStopTrackingTouch(android.widget.SeekBar seekBar);
    }

    @androidx.databinding.BindingAdapter(requireAll = false, value = {"android:onStartTrackingTouch", "android:onStopTrackingTouch", "android:onProgressChanged", "android:progressAttrChanged"})
    public static void setOnSeekBarChangeListener(android.widget.SeekBar seekBar, androidx.databinding.adapters.SeekBarBindingAdapter.OnStartTrackingTouch onStartTrackingTouch, androidx.databinding.adapters.SeekBarBindingAdapter.OnStopTrackingTouch onStopTrackingTouch, androidx.databinding.adapters.SeekBarBindingAdapter.OnProgressChanged onProgressChanged, androidx.databinding.InverseBindingListener inverseBindingListener) {
        if (onStartTrackingTouch == null && onStopTrackingTouch == null && onProgressChanged == null && inverseBindingListener == null) {
            seekBar.setOnSeekBarChangeListener(null);
        } else {
            seekBar.setOnSeekBarChangeListener(new androidx.databinding.adapters.SeekBarBindingAdapter.AnonymousClass1(onProgressChanged, inverseBindingListener, onStartTrackingTouch, onStopTrackingTouch));
        }
    }

    @androidx.databinding.BindingAdapter({"android:progress"})
    public static void setProgress(android.widget.SeekBar seekBar, int i) {
        if (i != seekBar.getProgress()) {
            seekBar.setProgress(i);
        }
    }
}
