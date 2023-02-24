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

    /**
     * This method is called by the RecyclerView to display the data at the specified position.
     * It updates the contents of the ViewHolder to reflect the item at the given position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CategoryPastaAdapter.ViewHolder holder, int position) {

        // Set the title, cooking time, and difficulty of the pasta item in the ViewHolder
        holder.titlePasta.setText ( pastaDomains.get ( position ) .getTitlePasta() );
        holder.cookingTimePasta.setText ( pastaDomains.get (position ) .getCookingTimePasta() );
        holder.difficultyPasta.setText ( pastaDomains.get ( position ) .getDifficultyPasta() );

        // Get the ID of the drawable resource for the pasta item image
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

    /**
     * The ViewHolder class holds references to the views that make up each item in the RecyclerView.
     * It also implements an OnClickListener to handle clicks on each item.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView titlePasta;
        public TextView cookingTimePasta;
        public TextView difficultyPasta;
        public ImageView imageCategoryPasta;

        /**
         * Constructor for the ViewHolder class.
         * @param itemView The View that represents each item in the RecyclerView.
         */
        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            titlePasta = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimePasta = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyPasta = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imageCategoryPasta = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener( this );
        }

        /**
         * Override of the onClick method from the OnClickListener interface.
         * @param view The View that was clicked.
         */
        @Override
        public void onClick ( View view ) {
            // Call the onclickCategoryPasta method on the categoryPastaOnclickListener,
            // passing in the clicked view and the position of the ViewHolder in the adapter
            categoryPastaOnclickListener.onclickCategoryPasta ( view, getAdapterPosition() );

        }
    }

    public interface CategoryPastaRecyclerViewClickListener{
        void onclickCategoryPasta ( View view, int position );
    }
}
