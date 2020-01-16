package gannar.webservices.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import gannar.webservices.R;
import gannar.webservices.User;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.viewHolder>
{
    private Context context;
    private List <User> users;

    public UsersAdapter(Context context, List <User> users)
    {
        this.context = context;
        this.users = users;
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        private TextView id, email, firstName, lastName, phoneNumber, age, country;

        private viewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.item_user_id);
            email = itemView.findViewById(R.id.item_user_email);
            firstName = itemView.findViewById(R.id.item_user_first_name);
            lastName = itemView.findViewById(R.id.item_user_last_name);
            phoneNumber = itemView.findViewById(R.id.item_user_phone_number);
            age = itemView.findViewById(R.id.item_user_age);
            country = itemView.findViewById(R.id.item_user_coutry);
        }
    }

        @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UsersAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        User user = users.get(position);
        holder.id.setText(Integer.toString(user.getId()));
        holder.email.setText(user.getEmail());
        holder.firstName.setText(user.getFirstName());
        holder.lastName.setText(user.getLastName());
        holder.phoneNumber.setText(user.getPhoneNumber());
        holder.age.setText(user.getAge());
        holder.country.setText(user.getCountry());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
