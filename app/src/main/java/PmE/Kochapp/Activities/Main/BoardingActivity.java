package PmE.Kochapp.Activities.Main;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import PmE.Kochapp.R;


public class BoardingActivity extends AppCompatActivity {
    private Button boardingButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boarding);

        boardingButton = findViewById ( R.id.boardingButton_id );


        boardingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomeActivity();
            }
        });
    }
    public void openHomeActivity(){
        Intent homeIntent = new Intent ( this, HomeActivity.class);
        startActivity(homeIntent);
    }

}
