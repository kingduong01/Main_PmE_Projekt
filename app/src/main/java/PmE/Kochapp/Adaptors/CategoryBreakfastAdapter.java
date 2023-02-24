package PmE.Kochapp.Adaptors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import PmE.Kochapp.Domains.CategoryBreakfastDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryBreakfastAdapter extends RecyclerView.Adapter < CategoryBreakfastAdapter.ViewHolder > {
    ArrayList < CategoryBreakfastDomain > breakfastDomains;
    private CategoryBreakfastRecyclerViewClickListener categoryBreakfastOnclickListener;

    public CategoryBreakfastAdapter ( ArrayList<CategoryBreakfastDomain> breakfastDomains, CategoryBreakfastRecyclerViewClickListener categoryBreakfastOnclickListener ) {
        this.breakfastDomains = breakfastDomains;
        this.categoryBreakfastOnclickListener = categoryBreakfastOnclickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder ( @NonNull ViewGroup parent, int viewType ) {
        View inflate = LayoutInflater.from ( parent.getContext() ) . inflate ( R.layout.viewholder_categorylist,parent,false );
        return new ViewHolder ( inflate );
    }

    /**
     * This method is called by the RecyclerView to display the data at the specified position.
     * It updates the contents of the ViewHolder to reflect the item at the given position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder ( @NonNull CategoryBreakfastAdapter.ViewHolder holder, int position ) {

        // Set the title, cooking time, and difficulty of the breakfast item in the ViewHolder
        holder.titleBreakfast.setText ( breakfastDomains.get ( position ) .getTitleBreakfast() );
        holder.cookingTimeBreakfast.setText ( breakfastDomains.get (position ) .getCookingTimeBreakfast() );
        holder.difficultyBreakfast.setText ( breakfastDomains.get ( position ) .getDifficultyBreakfast() );

        // Get the ID of the drawable resource for the breakfast item image
        int drawableRessrceId = holder.itemView.getContext()
                .getResources()
                .getIdentifier ( breakfastDomains.get( position ) .getImgeBreakfast(),
                        "drawable",
                        holder.itemView.getContext() .getPackageName() );

        // Load the breakfast item image into the ImageView using Glide library
        Glide.with ( holder.itemView.getContext() )
                .load ( drawableRessrceId )
                .into ( holder.imageCategoryBreakfast );
    }

    @Override
    public int getItemCount() {
        return breakfastDomains.size();
    }

    /**
     * The ViewHolder class holds references to the views that make up each item in the RecyclerView.
     * It also implements an OnClickListener to handle clicks on each item.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView titleBreakfast, cookingTimeBreakfast, difficultyBreakfast;
        ImageView imageCategoryBreakfast;

        /**
         * Constructor for the ViewHolder class.
         * @param itemView The View that represents each item in the RecyclerView.
         */
        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );
            titleBreakfast = itemView.findViewById ( R.id.categoryListTitle_id);
            cookingTimeBreakfast = itemView.findViewById ( R.id.categoryListTitleCookingtime_id);
            difficultyBreakfast = itemView.findViewById ( R.id.categoryListDifficulty_id);
            imageCategoryBreakfast = itemView.findViewById ( R.id.categoryListImage_id);

            itemView.setOnClickListener( this );
        }

        /**
         * Override of the onClick method from the OnClickListener interface.
         * @param view The View that was clicked.
         */
        @Override
        public void onClick ( View view ) {
            // Call the onclickCategoryBreakfast method on the categoryBreakfastOnclickListener,
            // passing in the clicked view and the position of the ViewHolder in the adapter
            categoryBreakfastOnclickListener.onclickCategoryBreakfast ( view, getAdapterPosition() );

        }
    }

    public interface CategoryBreakfastRecyclerViewClickListener{
        void onclickCategoryBreakfast ( View view, int position );
    }
}
