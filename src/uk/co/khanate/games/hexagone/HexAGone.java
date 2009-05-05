package uk.co.khanate.games.hexagone;

import android.app.Activity;
import android.os.Bundle;

public class HexAGone extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_5_5);
    }
}