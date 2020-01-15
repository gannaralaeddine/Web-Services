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
        private TextView cin;
        private TextView name;
        private TextView age;
        private TextView coutry;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            cin = itemView.findViewById(R.id.cin);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            coutry = itemView.findViewById(R.id.coutry);
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent);
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UsersAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position)
    {
        User user = users.get(position);

        holder.cin.setText(user.getEmail());
        holder.name.setText(user.getFirstName());
        holder.age.setText(user.getLastName());
        holder.coutry.setText(user.getPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
