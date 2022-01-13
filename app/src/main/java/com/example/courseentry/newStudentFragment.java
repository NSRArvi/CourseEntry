package com.example.courseentry;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;

import com.example.courseentry.databinding.FragmentNewStudentBinding;
import com.example.courseentry.pickers.DatePicker;

import java.util.List;

public class newStudentFragment extends Fragment implements DatePicker.OnDatePickListner {
    private FragmentNewStudentBinding binding;
    private String courseType = Student.SEIP;
    private String courseName;
    private List<String> courseList = Student.seipCourseList;
    public newStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewStudentBinding.inflate(inflater,container,false);

        initAdapter();
        binding.courseSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                courseName = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.courseTypeRg.setOnCheckedChangeListener((radioGroup, i) -> {
            final RadioButton rb = radioGroup.findViewById(i);
            courseType = rb.getText().toString();

            switch (i){
                case R.id.seipRb:
                    courseList = Student.seipCourseList;
                    break;
                case R.id.paidRb:
                    courseList = Student.paidCourseList;
                    break;
            }
            initAdapter();

        });
        binding.dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePicker(this).show(getChildFragmentManager(), null);
            }
        });
        binding.timeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.saveBtn.setOnClickListener(view -> {
            final String name = binding.nameEt.getText().toString();
            final Student s1 = new Student(name,courseType,courseName);
            Student.studentList.add(s1);
            Navigation.findNavController(view).popBackStack();
        });
        return binding.getRoot();
    }

    private void initAdapter() {

        final ArrayAdapter<String> adapter =
                new ArrayAdapter<>(getActivity()
                        , android.R.layout.simple_list_item_1
                        ,courseList);
        binding.courseSp.setAdapter(adapter);
    }

    @Override
    public void onDatePicked(String date) {
        binding.dateTv.setText(date);
    }
}