package com.example.myawesomeresume;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LinearLayout educationDetails;
    CheckBox cbHideEducation;
    LinearLayout skillsDetails;
    CheckBox cbHideSkills;

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

        educationDetails = findViewById(R.id.educationDetails);
        cbHideEducation = findViewById(R.id.cbHideEducation);
        skillsDetails = findViewById(R.id.skillsDetails);
        cbHideSkills = findViewById(R.id.cbHideSkills);

        updateEducationDetailsVisibility();
        updateSkillsDetailsVisibility();

        cbHideEducation.setOnCheckedChangeListener((buttonView, isChecked) -> updateEducationDetailsVisibility());
        cbHideSkills.setOnCheckedChangeListener((buttonView, isChecked) -> updateSkillsDetailsVisibility());
    }

    private void updateEducationDetailsVisibility() {
        if (cbHideEducation.isChecked()) {
            educationDetails.setVisibility(LinearLayout.GONE);
        } else {
            educationDetails.setVisibility(LinearLayout.VISIBLE);
        }
    }

    private void updateSkillsDetailsVisibility() {
        if (cbHideSkills.isChecked()) {
            skillsDetails.setVisibility(LinearLayout.GONE);
        } else {
            skillsDetails.setVisibility(LinearLayout.VISIBLE);
        }
    }
}
