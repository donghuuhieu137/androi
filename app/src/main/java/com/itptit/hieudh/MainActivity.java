package com.itptit.hieudh;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private int fakeId = 1;
    private EditText edtJobDescription, edtJobFinishDate,  edtJobName, editTextDate;

    private RadioGroup radioGroupGender;
    private Button btnAdd, buttonDate;
    private int lastSelectedYear;
    private int lastSelectedMonth;
    private int lastSelectedDayOfMonth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnAdd.setOnClickListener(view -> {
            try {
                String jobName = edtJobName.getText().toString();
                String jobDescription = edtJobDescription.getText().toString();
                String jobFinishDate = edtJobFinishDate.getText().toString();

                Model job = new Model();
                job.setId(fakeId);
                job.setName(jobName);
                job.setDescription(jobDescription);
                job.setFinishDate(jobFinishDate);
                radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {

                        // on below line we are getting radio button from our group.
                        RadioButton radioButton = findViewById(checkedId);

                        // on below line we are displaying a toast message.
                        String edtJobGender = radioButton.getText().toString();
                        job.setGender(edtJobGender);
                    }
                });
                fakeId++;
                if(jobName.isEmpty() || jobDescription.isEmpty() ||  jobFinishDate.isEmpty()){
                    Toast.makeText(this,"vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    jobListAdapter.addCat(job);
                }
            } catch (Exception e){
                Toast.makeText(this,e.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        this.editTextDate = (EditText) this.findViewById(R.id.editText_date);
        this.buttonDate = (Button) this.findViewById(R.id.button_date);

        this.buttonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSelectDate();
            }
        });

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        this.lastSelectedYear = c.get(Calendar.YEAR);
        this.lastSelectedMonth = c.get(Calendar.MONTH);
        this.lastSelectedDayOfMonth = c.get(Calendar.DAY_OF_MONTH);

    }

    private void initView() {
        btnAdd = findViewById(R.id.btnAdd);
        edtJobName = findViewById(R.id.edtJobName);
        edtJobDescription = findViewById(R.id.edtJobDescription);
        radioGroupGender = findViewById(R.id.edtJobGender);
        edtJobFinishDate = findViewById(R.id.edtJobFinishDate);
    }

    // User click on 'Select Date' button.
    private void buttonSelectDate() {
        // Date Select Listener.
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear, int dayOfMonth) {

                editTextDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                lastSelectedYear = year;
                lastSelectedMonth = monthOfYear;
                lastSelectedDayOfMonth = dayOfMonth;
            }
        };
        DatePickerDialog datePickerDialog = null;
        datePickerDialog = new DatePickerDialog(this,
                dateSetListener, lastSelectedYear, lastSelectedMonth, lastSelectedDayOfMonth);
        // Show
        datePickerDialog.show();
    }
}