package gannar.webservices.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

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
public class getUser extends Fragment {

    private EditText userId;

    public getUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_user_by_id, container, false);

            userId = view.findViewById(R.id.editText_getUserById);

            view.findViewById(R.id.btn_validate_getUserById).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    ApiUtil.getRetrofitClass().getUserById(Integer.parseInt(userId.getText().toString())).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response)
                        {
                            User user = response.body();
                            Toast.makeText(getContext(), "Cin: "+user.getEmail()+"\nFirst name: "+user.getFirstName()+"\nLast name: "+user.getLastName()+"\nPhone Number: "+user.getPhoneNumber(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t)
                        {
                            Toast.makeText(getContext(), "Error" + t.getMessage() , Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

        return view;
    }

}
