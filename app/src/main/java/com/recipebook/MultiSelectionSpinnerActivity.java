package com.recipebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.recipebook.custom.MultiSelectionSpinner;
import com.recipebook.model.GeneralModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MultiSelectionSpinnerActivity extends AppCompatActivity implements MultiSelectionSpinner.OnMultipleItemsSelectedListener {

    ArrayList<GeneralModel> label_data = new ArrayList<>();
    ArrayList<String> labelData = new ArrayList<>();

    @BindView(R.id.contact_label)
    MultiSelectionSpinner contactLabel;
    StringBuilder builder = new StringBuilder();
    @BindView(R.id.check_btn)
    Button checkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_selection_spinner);
        ButterKnife.bind(this);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MultiSelectionSpinnerActivity.this, "" + builder.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        lable();

    }


    public void lable() {
        try {
            label_data.clear();
            labelData.clear();
            GeneralModel da = new GeneralModel();
            da.setId("");
            da.setName("Select Label");
            label_data.add(da);
            labelData.add("Select Label");
            for (int i = 0; i < 5; i++) {
                da = new GeneralModel();
                da.setId("" + i);
                da.setName(i + "Spinner");
                label_data.add(da);

                labelData.add(i + "Spinner");
            }
            contactLabel.setItems(labelData);
            contactLabel.setListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectedIndices(List<Integer> indices) {

    }

    @Override
    public void selectedStrings(List<String> strings) {
        builder.setLength(0);
        for (int i = 0; i < label_data.size(); i++) {
            String name = label_data.get(i).getName();
            for (int j = 0; j < strings.size(); j++) {
                if (name.equals("" + strings.get(j).toString())) {
                    if (!name.equals("Select Label")) {
                        if (builder.length() < 0) {
                            builder.append(label_data.get(i).getId());
                        } else {
                            builder.append(",").append(label_data.get(i).getId());
                        }

                    }
                }
            }
        }

    }
}
