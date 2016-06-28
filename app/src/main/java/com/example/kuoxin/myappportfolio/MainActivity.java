package com.example.kuoxin.myappportfolio;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButtons();

    }

    private void initButtons(){
        LinearLayout buttonPanel = (LinearLayout) findViewById(R.id.button_panel);
        for (int i = 0; i < buttonPanel.getChildCount(); i ++) {
            View item = buttonPanel.getChildAt(i);
            if (item instanceof Button) {
                Button button = (Button) item;
                button.setOnClickListener(new DisplayToastListener(button.getText().toString()));
            }
        }
    }

    private static class DisplayToastListener implements View.OnClickListener {

        private String messageToDisplay;

        public DisplayToastListener(String messageToDisplay) {
            this.messageToDisplay = messageToDisplay;
        }

        @Override
        public void onClick(View view) {
            //Context context = getApplicationContext();
            Context context = view.getContext();
            CharSequence text = "This Button Will Launch" + ((Button) view).getText().toString();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
