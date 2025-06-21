package com.aliyun.svideo.editor.effects.sound;

/* loaded from: classes12.dex */
public class MockEffectSoundData {
    private static java.util.List<com.aliyun.svideo.editor.effects.sound.SoundEffectInfo> mSoundData = new java.util.ArrayList();
    private static com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel[] sModels;

    public static class SoundModel {
        private int mNameId;
        private int mResourceId;
        private com.aliyun.svideosdk.editor.AudioEffectType mType;
        private int mWeight;

        private SoundModel(int i, int i2, int i3, com.aliyun.svideosdk.editor.AudioEffectType audioEffectType) {
            this.mNameId = i;
            this.mWeight = i2;
            this.mResourceId = i3;
            this.mType = audioEffectType;
        }

        public /* synthetic */ SoundModel(int i, int i2, int i3, com.aliyun.svideosdk.editor.AudioEffectType audioEffectType, defpackage.ol1 ol1Var) {
            this(i, i2, i3, audioEffectType);
        }
    }

    static {
        com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel[] soundModelArr = {new com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_sound_default, 0, com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_sound_default, com.aliyun.svideosdk.editor.AudioEffectType.EFFECT_TYPE_DEFAULT, null), new com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_sound_loli, 50, com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_sound_loli, com.aliyun.svideosdk.editor.AudioEffectType.EFFECT_TYPE_LOLITA, null), new com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_sound_uncle, 50, com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_sound_uncle, com.aliyun.svideosdk.editor.AudioEffectType.EFFECT_TYPE_UNCLE, null), new com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_sound_echo, 50, com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_sound_echo, com.aliyun.svideosdk.editor.AudioEffectType.EFFECT_TYPE_ECHO, null), new com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_sound_reverb, 50, com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_sound_reverb, com.aliyun.svideosdk.editor.AudioEffectType.EFFECT_TYPE_REVERB, null), new com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_sound_minions, 50, com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_sound_minions, com.aliyun.svideosdk.editor.AudioEffectType.EFFECT_TYPE_MINIONS, null), new com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_sound_robot, 50, com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_sound_robot, com.aliyun.svideosdk.editor.AudioEffectType.EFFECT_TYPE_ROBOT, null), new com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_sound_devil, 50, com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_sound_devil, com.aliyun.svideosdk.editor.AudioEffectType.EFFECT_TYPE_BIG_DEVIL, null), new com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel(com.aliyun.svideo.editor.R.string.alivc_editor_dialog_sound_dialect, 50, com.aliyun.svideo.editor.R.drawable.alivc_svideo_effect_sound_fayanl, com.aliyun.svideosdk.editor.AudioEffectType.EFFECT_TYPE_DIALECT, null)};
        sModels = soundModelArr;
        for (com.aliyun.svideo.editor.effects.sound.MockEffectSoundData.SoundModel soundModel : soundModelArr) {
            com.aliyun.svideo.editor.effects.sound.SoundEffectInfo soundEffectInfo = new com.aliyun.svideo.editor.effects.sound.SoundEffectInfo();
            soundEffectInfo.soundNameId = soundModel.mNameId;
            soundEffectInfo.audioEffectType = soundModel.mType;
            soundEffectInfo.soundWeight = soundModel.mWeight;
            soundEffectInfo.imgIcon = soundModel.mResourceId;
            mSoundData.add(soundEffectInfo);
        }
    }

    public static java.util.List<com.aliyun.svideo.editor.effects.sound.SoundEffectInfo> getEffectSound() {
        return mSoundData;
    }
}
