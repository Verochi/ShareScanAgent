package com.aliyun.svideo.editor.effectmanager;

/* loaded from: classes12.dex */
public class StateController {
    public static final int STATE_COMPLETE = 0;
    public static final int STATE_EDIT = 1;
    private int mCurrState = 0;
    private java.util.List<com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter> mAdapters = new java.util.ArrayList();

    public static abstract class StateAdapter<VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder> extends androidx.recyclerview.widget.RecyclerView.Adapter<VH> {
        private com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter.OnStateChangeListener mStateChangeListener;

        public interface OnStateChangeListener {
            void onCompleteState();

            void onEditState();
        }

        public void setStateChangeListener(com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter.OnStateChangeListener onStateChangeListener) {
            this.mStateChangeListener = onStateChangeListener;
        }

        public void switchState(int i) {
            com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter.OnStateChangeListener onStateChangeListener = this.mStateChangeListener;
            if (onStateChangeListener != null) {
                if (i == 0) {
                    onStateChangeListener.onCompleteState();
                } else {
                    if (i != 1) {
                        return;
                    }
                    onStateChangeListener.onEditState();
                }
            }
        }
    }

    public void addAdatper(com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter stateAdapter) {
        this.mAdapters.add(stateAdapter);
    }

    public void removeAdapter(com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter stateAdapter) {
        this.mAdapters.remove(stateAdapter);
    }

    public void switchState() {
        if (this.mCurrState == 0) {
            this.mCurrState = 1;
        } else {
            this.mCurrState = 0;
        }
        java.util.Iterator<com.aliyun.svideo.editor.effectmanager.StateController.StateAdapter> it = this.mAdapters.iterator();
        while (it.hasNext()) {
            it.next().switchState(this.mCurrState);
        }
    }
}
