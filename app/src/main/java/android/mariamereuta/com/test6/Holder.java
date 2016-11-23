package android.mariamereuta.com.test6;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Maria on 22-Nov-16.
 */

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView mImageView;
    TextView mFirma;
    TextView mMeniu;

    ItemClickListener mItemClickListener;

    public Holder(View itemView) {
        super(itemView);

        this.mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        this.mFirma = (TextView) itemView.findViewById(R.id.firma);
        this.mMeniu = (TextView) itemView.findViewById(R.id.meniu);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.mItemClickListener.onItemClick(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.mItemClickListener = ic;
    }
}
