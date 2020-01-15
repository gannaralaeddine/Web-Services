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
public class deleteUser extends Fragment
{

    private EditText userId;

    public deleteUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        userId = view.findViewById(R.id.editText_deleteUserById);

        view.findViewById(R.id.btn_validate_deleteUserById).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiUtil.getRetrofitClass().deleteUserById(Integer.parseInt(userId.getText().toString())).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response)
                    {
                        Toast.makeText(getContext(), "The user "+userId.getText().toString()+" has been deleted" , Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getContext(), "Error" + t.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


        return view;
    }

}
