package com.pacewisdom.contactsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pacewisdom.contactsapp.R;
import com.pacewisdom.contactsapp.model.ContactModel;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    Context context;
    List<ContactModel> contactList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvContactNo;

        public MyViewHolder(View view) {
            super(view);

            tvName = (TextView) view.findViewById(R.id.tvName);
            tvContactNo = (TextView) view.findViewById(R.id.tvContactNo);
        }
    }

    public ContactAdapter(List<ContactModel> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public ContactAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_item, parent, false);

        return new ContactAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactAdapter.MyViewHolder holder, final int position) {
        final ContactModel model = contactList.get(position);

        holder.tvName.setText(model.getName());
        holder.tvContactNo.setText(model.getPhone());

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

}

