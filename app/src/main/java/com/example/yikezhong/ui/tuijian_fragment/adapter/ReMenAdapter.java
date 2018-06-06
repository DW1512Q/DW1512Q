package com.example.yikezhong.ui.tuijian_fragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.yikezhong.R;
import com.example.yikezhong.bean.HotBean;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created   by   Dewey .
 * 推荐 热门
 */
public class ReMenAdapter extends RecyclerView.Adapter<ReMenAdapter.ReMenViewHolder> {
    private Context context;
    private List<HotBean.DataBean> list;

    public ReMenAdapter(Context context, List<HotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    //添加数据的方法
    public void addData(List<HotBean.DataBean> data) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        list.clear();
        list.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ReMenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //添加布局视图
        View view = View.inflate(context, R.layout.remen_adapter, null);
        return new ReMenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReMenViewHolder holder, int position) {
        //设置参数数据
        holder.title.setText(list.get(position).getWorkDesc());
        holder.name.setText(list.get(position).getUser().getNickname());
        holder.time.setText(list.get(position).getCreateTime());
        holder.headImage.setImageURI(list.get(position).getUser().getIcon());
        holder.draweeView.setImageURI(list.get(position).getCover());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class ReMenViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.headImage)
        SimpleDraweeView headImage;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.time)
        TextView time;
        @BindView(R.id.biaoti)
        TextView title;
        @BindView(R.id.draweeView)
        SimpleDraweeView draweeView;

        public ReMenViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}