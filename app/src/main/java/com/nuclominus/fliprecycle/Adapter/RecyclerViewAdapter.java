package com.nuclominus.fliprecycle.Adapter;

import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nuclominus.fliprecycle.DataObj.ListItem;
import com.nuclominus.fliprecycle.R;
import com.nuclominus.fliprecycle.Utils.AnimationUtil;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<ListItem> items;

    public RecyclerViewAdapter(List<ListItem> records) {
        this.items = records;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ListItem item = items.get(i);

        if (viewHolder.item != null) {
            viewHolder.menuR.setAlpha(0);
            viewHolder.item.setVisibility(false);
        }

        viewHolder.item = item;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView name;
        protected ListItem item;
        protected RelativeLayout cardR, menuR;
        protected CheckBox heart, email, cloud;


        public ViewHolder(final View itemView) {
            super(itemView);

            cardR = (RelativeLayout) itemView.findViewById(R.id.cardR);
            menuR = (RelativeLayout) itemView.findViewById(R.id.menuR);
            heart = (CheckBox) itemView.findViewById(R.id.heartView);
            email = (CheckBox) itemView.findViewById(R.id.emailView);
            cloud = (CheckBox) itemView.findViewById(R.id.cloudView);

            heart.setOnClickListener(this);
            email.setOnClickListener(this);
            cloud.setOnClickListener(this);
            cardR.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.cardR: {
                    item.setVisibility(cardChecker(view, item.isVisible()));
                }
                break;

                case R.id.heartView: {
                }
                break;

                case R.id.emailView: {
                }
                break;

                case R.id.cloudView: {
                }
                break;
            }
        }

        private boolean cardChecker(View view, boolean visibility) {
            if (!visibility) {
                AnimationUtil.run(view.findViewById(R.id.cardView), 0);
                ObjectAnimator fadeAltAnim = ObjectAnimator.ofFloat(menuR, View.ALPHA, 0, 1);
                fadeAltAnim.setDuration(400);
                fadeAltAnim.start();
                return true;
            } else {
                AnimationUtil.run(view.findViewById(R.id.cardView), 1);
                ObjectAnimator fadeAltAnim = ObjectAnimator.ofFloat(menuR, View.ALPHA, 1, 0);
                fadeAltAnim.setDuration(100);
                fadeAltAnim.start();
                return false;
            }
        }
    }
}
