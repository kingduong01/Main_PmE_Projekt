package PmE.Kochapp.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import PmE.Kochapp.Domains.CategoryPastaDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryPastaAdapter extends RecyclerView.Adapter < CategoryPastaAdapter.ViewHolder > {
    ArrayList <CategoryPastaDomain> pastaDomains;
    private CategoryPastaAdapter.CategoryPastaRecyclerViewClickListener categoryPastaOnclickListener;

    public CategoryPastaAdapter ( ArrayList<CategoryPastaDomain> pastaDomains, CategoryPastaAdapter.CategoryPastaRecyclerViewClickListener categoryPastaOnclickListener ) {
        this.pastaDomains = pastaDomains;
        this.categoryPastaOnclickListener = categoryPastaOnclickListener;
    }

    @Override
    public CategoryPastaAdapter.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType ) {
        View inflate = LayoutInflater.from ( parent.getContext() ) . inflate ( R.layout.viewholder_categorylist,parent,false );
        return new CategoryPastaAdapter.ViewHolder( inflate );
    }



    @Override
    public void onBindViewHolder(@NonNull CategoryPastaAdapter.ViewHolder holder, int position) {
        holder.titlePasta.setText ( pastaDomains.get ( position ) .getTitlePasta() );
        holder.cookingTimePasta.setText ( pastaDomains.get (position ) .getCookingTimePasta() );
        holder.difficultyPasta.setText ( pastaDomains.get ( position ) .getDifficultyPasta() );

        int drawableRessrceId = holder.itemView.getContext()
                .getResources()
                .getIdentifier ( pastaDomains.get( position ) .getImgePasta(),
                        "drawable",
                        holder.itemView.getContext() .getPackageName() );

        Glide.with ( holder.itemView.getContext() )
                .load ( drawableRessrceId )
                .into ( holder.imageCategoryPasta );
    }



    @Override
    public int getItemCount() {
        return pastaDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView titlePasta;
        public TextView cookingTimePasta;
        public TextView difficultyPasta;
        public ImageView imageCategoryPasta;

        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            titlePasta = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimePasta = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyPasta = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imageCategoryPasta = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener( this );
        }

        @Override
        public void onClick ( View view ) {
            categoryPastaOnclickListener.onclickCategoryPasta ( view, getAdapterPosition() );

        }
    }

    public interface CategoryPastaRecyclerViewClickListener{
        void onclickCategoryPasta ( View view, int position );
    }
}
