package us.xingkong.starmessage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import us.xingkong.starmessage.R;
import us.xingkong.starmessage.been.Items;

/**
 * Created by SeaLynn0 on 2017/7/9.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private Context mContext;
    private List<Items> itemsList;

    @NonNull
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Items item = itemsList.get(position);
        holder.name.setText(item.getName());
        holder.type.setText(item.getType());
        holder.version.setText(item.getMaster_release().getVersion());
        Glide.with(mContext)
                .load(item.getIcon_url())
//                .placeholder(R.drawable.ic_action_photo)
//                .error(R.drawable.ic_action_error)
                .into(holder.icon);
    }

    public ItemsAdapter(List<Items>list,Context context){
        itemsList = list;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        @BindView(R.id.head_portrait)
        AppCompatImageView icon;
        @BindView(R.id.name)
        AppCompatTextView name;
        @BindView(R.id.type)
        AppCompatTextView type;
        @BindView(R.id.version)
        AppCompatTextView version;

        ViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
            cardView = (CardView)view;
        }
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }
}
