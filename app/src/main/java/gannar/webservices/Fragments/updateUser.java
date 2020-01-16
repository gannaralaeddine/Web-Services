package gannar.webservices.Fragments;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import gannar.webservices.R;
import gannar.webservices.Retro.ApiUtil;
import gannar.webservices.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class updateUser extends Fragment
{

    private EditText id, email, firstName, lastName, phoneNumber, age, country;

    public updateUser() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_user, container, false);

        id = view.findViewById(R.id.update_id);
        email = view.findViewById(R.id.update_email);
        firstName = view.findViewById(R.id.update_first_name);
        lastName = view.findViewById(R.id.update_last_name);
        phoneNumber = view.findViewById(R.id.update_phone_number);
        age = view.findViewById(R.id.update_age);
        country = view.findViewById(R.id.update_country);

        view.findViewById(R.id.btn_validate_updateUser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(id.getText().toString()) || TextUtils.isEmpty(email.getText().toString()) ||
                        TextUtils.isEmpty(firstName.getText().toString()) || TextUtils.isEmpty(lastName.getText().toString()) ||
                        TextUtils.isEmpty(phoneNumber.getText().toString()) || TextUtils.isEmpty(age.getText().toString()))
                {
                    Toast.makeText(getContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    User user = new User();
                    user.setEmail(email.getText().toString());
                    user.setFirstName(firstName.getText().toString());
                    user.setLastName(lastName.getText().toString());
                    user.setPhoneNumber(phoneNumber.getText().toString());
                    user.setAge(age.getText().toString());
                    user.setCountry(country.getText().toString());

                    ApiUtil.getRetrofitClass().updateUser(Integer.parseInt(id.getText().toString()), user).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Toast.makeText(getContext(), "The user is updated successfully" , Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getContext(), "Error" + t.getMessage() , Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        return view;
    }

}