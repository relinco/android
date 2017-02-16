package com.example.android.miwok;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                @Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pause playback
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Resume playback
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        /* initialize the ArrayList include all the words */
        final ArrayList<Word> wordArrayList = new ArrayList<Word>();
        String[] engWord = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] miwork = {"lutti", "otiiko", "tolookosu", "oyyisa", "massokka", "temmokka", "temmokka", "kawinta", "wo’e", "na’aacha"};
        int[] pic = {R.drawable.number_one, R.drawable.number_two, R.drawable.number_three, R.drawable.number_four, R.drawable.number_five, R.drawable.number_six, R.drawable.number_seven, R.drawable.number_eight, R.drawable.number_nine, R.drawable.number_ten};
        int[] music = {R.raw.number_one, R.raw.number_two, R.raw.number_three, R.raw.number_four, R.raw.number_five, R.raw.number_six, R.raw.number_seven, R.raw.number_eight, R.raw.number_nine, R.raw.number_ten};
        for (int i = 0; i < engWord.length; i++)
            wordArrayList.add(new Word(pic[i], miwork[i], engWord[i], music[i]));

        /* use ArrayAdapter and ListView construct the activity */
        WordAdapter itemsAdapter = new WordAdapter(this, wordArrayList, R.color.category_numbers);
        ListView listview = (ListView) findViewById(R.id.word_list_view);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int result = mAudioManager.requestAudioFocus(afChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    releaseMediaPlayer();
                    int mediaId = wordArrayList.get(position).getmMusic();
                    mMediaPlayer = MediaPlayer.create(NumbersActivity.this, mediaId);
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();
                        }
                    });
                }
            }
        });
        listview.setAdapter(itemsAdapter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            //mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);

            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }
}
