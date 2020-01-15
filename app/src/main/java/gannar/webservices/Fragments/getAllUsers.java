package gannar.webservices.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gannar.webservices.Adapters.UsersAdapter;
import gannar.webservices.R;
import gannar.webservices.Retro.ApiUtil;
import gannar.webservices.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class getAllUsers extends Fragment
{
    RecyclerView recyclerView;

    public getAllUsers() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_get_all_users, container, false);

            recyclerView = view.findViewById(R.id.recycleView);



        ApiUtil.getRetrofitClass().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response)
            {

                List <User> usersList = response.body();
                UsersAdapter adapter = new UsersAdapter(getContext(), usersList);
                recyclerView.setAdapter(adapter);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(linearLayoutManager);

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t)
            {
                Toast.makeText(getContext(), "Error" + t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
