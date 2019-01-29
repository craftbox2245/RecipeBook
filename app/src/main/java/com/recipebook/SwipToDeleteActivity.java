package com.recipebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;

import com.recipebook.adapter.GeneralAdapter;
import com.recipebook.custom.DividerItemDecoration;
import com.recipebook.swipeToDelete.OnItemClickListener;
import com.recipebook.swipeToDelete.RecyclerViewAdapter;
import com.recipebook.swipeToDelete.SwipeToDismissTouchListener;
import com.recipebook.swipeToDelete.SwipeableItemClickListener;
import com.recipebook.model.GeneralModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwipToDeleteActivity extends AppCompatActivity {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;

    ArrayList<GeneralModel> data = new ArrayList<>();
    GeneralAdapter adapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swip_to_delete);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Swip To Delete");

        try {
            String[] countries = new String[]{"Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla",
                    "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas",
                    "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia",
                    "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam",
                    "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands",
                    "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia",
                    "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Costa Rica", "Cote d'Ivoire",
                    "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
                    "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia",
                    "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Finland", "France", "France Metropolitan", "French Guiana",
                    "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar",
                    "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti",
                    "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India",
                    "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan",
                    "Kazakhstan", "Kenya", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait",
                    "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya",
                    "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar",
                    "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius",
                    "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat",
                    "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles",
                    "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands",
                    "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn",
                    "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "Rwanda",
                    "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
                    "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore",
                    "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa",
                    "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon",
                    "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic",
                    "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga",
                    "Trinidad and Tobago", "Tunisia", "Türkiye", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine",
                    "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay",
                    "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)",
                    "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Zambia", "Zimbabwe"};

            for (int i = 0; i < countries.length; i++) {
                GeneralModel da = new GeneralModel();
                da.setId("" + i);
                da.setName("" + countries[i]);
                data.add(da);
            }

            adapter = new GeneralAdapter(SwipToDeleteActivity.this, data);
            recycleView.setAdapter(adapter);
            RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(SwipToDeleteActivity.this);
            recycleView.addItemDecoration(itemDecoration);
            recycleView.setLayoutManager(new LinearLayoutManager(SwipToDeleteActivity.this, LinearLayoutManager.VERTICAL, false));


            /* swipe to delete code start */
            final SwipeToDismissTouchListener<RecyclerViewAdapter> touchListener =
                    new SwipeToDismissTouchListener<>(
                            new RecyclerViewAdapter(recycleView),
                            new SwipeToDismissTouchListener.DismissCallbacks<RecyclerViewAdapter>() {
                                @Override
                                public boolean canDismiss(int position) {
                                    return true;
                                }

                                @Override
                                public void onPendingDismiss(RecyclerViewAdapter recyclerView, int position) {

                                }

                                @Override
                                public void onDismiss(RecyclerViewAdapter view, int position) {
                                    data.remove(position);
                                    recycleView.removeViewAt(position);
                                    adapter.notifyItemRemoved(position);
                                    adapter.notifyItemRangeChanged(position, data.size());
                                    adapter.notifyDataSetChanged();
                                }
                            });

            touchListener.setDismissDelay(500000);
            recycleView.setOnTouchListener(touchListener);
            // Setting this scroll listener is required to ensure that during ListView scrolling,
            // we don't look for swipes.
            recycleView.addOnScrollListener((RecyclerView.OnScrollListener) touchListener.makeScrollListener());
            recycleView.addOnItemTouchListener(new SwipeableItemClickListener(this,
                    new OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            if (view.getId() == R.id.txt_delete) {
                                touchListener.processPendingDismisses();
                            } else if (view.getId() == R.id.txt_undo) {
                                touchListener.undoPendingDismiss();
                            } else { // R.id.txt_data
                                //Toast.makeText(CreateOrderActivity.this, "Position " + position, Toast.LENGTH_LONG).show();
                            }
                        }
                    }));
            /* END */
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
