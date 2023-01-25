package PmE.Kochapp.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import PmE.Kochapp.Domains.CategoryVeganDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryVeganAdapter extends RecyclerView.Adapter < CategoryVeganAdapter.ViewHolder >{
    ArrayList <CategoryVeganDomain> veganDomains;
    private CategoryVeganAdapter.CategoryVeganRecyclerViewClickListener categoryVeganOnclickListener;

    public CategoryVeganAdapter ( ArrayList<CategoryVeganDomain> veganDomains, CategoryVeganAdapter.CategoryVeganRecyclerViewClickListener categoryVeganOnclickListener ) {
        this.veganDomains = veganDomains;
        this.categoryVeganOnclickListener = categoryVeganOnclickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType ) {
        View inflate = LayoutInflater.from ( parent.getContext() ) . inflate ( R.layout.viewholder_categorylist,parent,false );
        return new CategoryVeganAdapter.ViewHolder( inflate );
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleVegan.setText ( veganDomains.get ( position ) .getTitleVegan() );
        holder.cookingTimeVegan.setText ( veganDomains.get (position ) .getCookingTimeVegan() );
        holder.difficultyVegan.setText ( veganDomains.get ( position ) .getDifficultyVegan() );

        int drawableRessrceId = holder.itemView.getContext()
                .getResources()
                .getIdentifier ( veganDomains.get( position ) .getImgeVegan(),
                        "drawable",
                        holder.itemView.getContext() .getPackageName() );

        Glide.with ( holder.itemView.getContext() )
                .load ( drawableRessrceId )
                .into ( holder.imageCategoryVegan );
    }



    @Override
    public int getItemCount() {
        return veganDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleVegan, cookingTimeVegan, difficultyVegan;
        ImageView imageCategoryVegan;

        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            titleVegan = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimeVegan = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyVegan = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imageCategoryVegan = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick ( View view ) {
            categoryVeganOnclickListener.onclickCategoryVegan ( view, getAdapterPosition() );

        }
    }

    public interface CategoryVeganRecyclerViewClickListener{
        void onclickCategoryVegan ( View view, int position );
    }
}
