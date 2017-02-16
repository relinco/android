/**
 * Created by inco on 2017/2/12.
 */
package com.example.android.miwok;
/**
  * {@link Word} represents a vocabulary word that the user want to learn
  * it has a default translation and a miwork translation
 * */

public final class Word {
    private int mImg;
    private String mMiworkWord;
    private String mDefaultWord;
    private boolean mResImg;
    private int mMusic;

    /*
        construct method for Word Class
     */
    public Word(int img, String miworkWord, String defaultWord, int musicId) {
        this.mImg = img;
        this.mDefaultWord = defaultWord;
        this.mMiworkWord = miworkWord;
        this.mResImg = true;
        mMusic = musicId;
    }

    public Word(String miworkWord, String defaultWord, int musicId) {
        this.mImg = 0;
        this.mDefaultWord = defaultWord;
        this.mMiworkWord = miworkWord;
        this.mResImg = false;
        this.mMusic = musicId;
    }

    /*
        get the miwork word
     */
    public String getMiworkWord() {
        return mMiworkWord;
    }

    /*
        get the translate word
     */
    public String getDefaultWord() {
        return mDefaultWord;
    }

    /*
        get the img id
     */
    public int getmImg() {
        return mImg;
    }

    public boolean isSetImg()
    {
        return mResImg;
    }

    public int getmMusic() {
        return mMusic;
    }
}
