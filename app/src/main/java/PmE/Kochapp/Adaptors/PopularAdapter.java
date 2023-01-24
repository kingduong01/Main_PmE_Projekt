package PmE.Kochapp.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import PmE.Kochapp.Domains.PopularDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList < PopularDomain > popularDomains;
    private PopularRecyclerViewClickListener popularOnclickListener;

    public PopularAdapter ( ArrayList<PopularDomain> popularDomains, PopularRecyclerViewClickListener popularOnclickListener) {
        this.popularDomains = popularDomains;
        this.popularOnclickListener = popularOnclickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder ( @NonNull ViewGroup parent, int viewType ) {
        View inflate = LayoutInflater.from ( parent.getContext() ).inflate(R.layout.viewholder_popular,parent,false );
        return new ViewHolder ( inflate );
    }


    /*
     */
    @Override
    public void onBindViewHolder ( @NonNull ViewHolder holder, int position ) {
        holder.titlePopular.setText ( popularDomains.get ( position ).getTitlePopular () );
        holder.cookingTimePopular.setText ( popularDomains.get ( position ) .getCookingTimePopular () );
        holder.difficultyPopular.setText ( popularDomains.get (position ) .getDifficultyPopular () );

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(popularDomains.get(position).getImagePopular(), "drawable", holder.itemView.getContext().getPackageName());


        Glide.with( holder.itemView.getContext() )
                .load( drawableResourceId )
                .into( holder.imagePopular );
    }

    @Override
    public int getItemCount() {
        return popularDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titlePopular, cookingTimePopular, difficultyPopular;
        ImageView imagePopular;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titlePopular = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimePopular = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyPopular = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imagePopular = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener ( this );
        }

        @Override
        public void onClick ( View view ) {
            popularOnclickListener.onclickPopular ( view, getAdapterPosition() );
        }
    }

    public interface PopularRecyclerViewClickListener{
        void onclickPopular ( View view, int position );
    }


}
