package cn.ucai.fulicenter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.fulicenter.I;
import cn.ucai.fulicenter.R;
import cn.ucai.fulicenter.bean.BoutiqueBean;
import cn.ucai.fulicenter.utils.ImageLoader;
import cn.ucai.fulicenter.utils.MFGT;
import cn.ucai.fulicenter.view.FooterViewHolder;

/**
 * Created by Administrator on 2016/10/19 0019.
 */

public class BoutiqueAdapter extends RecyclerView.Adapter {
    Context mContext;
    ArrayList<BoutiqueBean> mlist;


    public BoutiqueAdapter(Context mContext, ArrayList<BoutiqueBean> list) {
        this.mContext = mContext;
        mlist = new ArrayList<>();
        mlist.addAll(list);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder
            holder = new BoutiqueViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_boutique, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            BoutiqueViewHolder bv = (BoutiqueViewHolder) holder;
            BoutiqueBean boutiqueBean =mlist.get(position);
            ImageLoader.downloadImg(mContext,bv.boutiqueImageView,boutiqueBean.getImageurl());
            bv.boutiqueTitle.setText(boutiqueBean.getTitle());
            bv.boutiqueName.setText(boutiqueBean.getName());
            bv.boutiqueName2.setText(boutiqueBean.getDescription());
            bv.boutiqueLinearLayout.setTag(boutiqueBean);
    }

    @Override
    public int getItemCount() {
        return mlist != null ? mlist.size()  : 0;
    }
    public void initData(ArrayList<BoutiqueBean> list) {
        if (mlist!=null){
            mlist.clear();
        }
        mlist.addAll(list);
        notifyDataSetChanged();
    }





    class BoutiqueViewHolder  extends RecyclerView.ViewHolder{
        @BindView(R.id.boutique_imageView)
        ImageView boutiqueImageView;
        @BindView(R.id.boutique_title)
        TextView boutiqueTitle;
        @BindView(R.id.boutique_name)
        TextView boutiqueName;
        @BindView(R.id.boutique_name2)
        TextView boutiqueName2;
        @BindView(R.id.boutique_linearLayout)
        LinearLayout boutiqueLinearLayout;

        BoutiqueViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
        @OnClick(R.id.boutique_linearLayout)
        public  void onBoutiqueClick(){
            BoutiqueBean bean = (BoutiqueBean) boutiqueLinearLayout.getTag();
            MFGT.gotoBoutiqueChildActivity(mContext,bean);
        }
    }
}
