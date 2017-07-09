package us.xingkong.starmessage;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import us.xingkong.starmessage.been.Items;

/**
 * Created by SeaLynn0 on 2017/7/9.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private Context mContext;
    private List<Items> itemsList;

    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Items item = itemsList.get(position);
        holder.name.setText(item.getName());
        holder.type.setText(item.getType());
        holder.version.setText(item.getMaster_release().getVersion());
        Glide.with(mContext).load(item.getIcon_url()).into(holder.icon);
    }

    public ItemsAdapter(List<Items>list,Context context){
        itemsList = list;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        AppCompatImageView icon;
        AppCompatTextView name;
        AppCompatTextView type;
        AppCompatTextView version;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView)view;
            icon = view.findViewById(R.id.head_portrait);
            name = view.findViewById(R.id.name);
            type = view.findViewById(R.id.type);
            version = view.findViewById(R.id.version);
        }
    }
}
