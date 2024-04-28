package sg.edu.np.mad.madpractical2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sg.edu.np.mad.practical2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        User user = new User("John Doe", "MAD Developer", 1, false);

        //Set and apply text views
        TextView tvName = findViewById(R.id.title);
        TextView tvDescription = findViewById(R.id.desc);


        TextView btnFollow = findViewById(R.id.button);
        TextView btnMessage = findViewById(R.id.button2);
        TextView tvTitle = findViewById(R.id.headLine);

        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");
        btnMessage.setText("Message");
        tvTitle.setText("MAD Practical");
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnFollow.getText() == "Follow") {
                    btnFollow.setText("Unfollow");
                }
                else {
                    btnFollow.setText("Follow");
                }
            }
        });
    }
}