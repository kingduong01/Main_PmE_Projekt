package PmE.Kochapp.Adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.*;
import com.bumptech.glide.Glide;

import PmE.Kochapp.Domains.CategoryDomain;
import PmE.Kochapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain> categoryDomains;
    private CategoryRecyclerViewClickListener categoryOnclickListener;

    public CategoryAdapter ( ArrayList<CategoryDomain> categoryDomains, CategoryRecyclerViewClickListener categoryOnclickListener ) {
        this.categoryDomains = categoryDomains;
        this.categoryOnclickListener = categoryOnclickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder ( @NonNull ViewGroup parent, int viewType ) {
        View inflate = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.viewholder_category,parent,false );
        return new ViewHolder ( inflate );
    }


    /**
     * Binds the data to the view positions in the RecyclerView.
     *
     * @param holder    ViewHolder containing the view to which data is to be bound
     * @param position  Position of the view in RecyclerView
     */
    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position ) {
        holder.categoryName.setText(categoryDomains.get( position ) .getTitle() );
        String imageURL = "";
        switch (position){
            case 0:{
                imageURL = "image_category_breakfast";
                holder.mainLayout.setBackground (  ContextCompat.getDrawable ( holder.itemView.getContext(),R.drawable.categorybackground1 ) );
                break;
            }
            case 1:{
                imageURL = "image_category_pasta";
                holder.mainLayout.setBackground ( ContextCompat.getDrawable ( holder.itemView.getContext ( ),R.drawable.categorybackground1 ) );
                break;
            }
            case 2:{
                imageURL = "image_category_vegan";
                holder.mainLayout.setBackground ( ContextCompat.getDrawable ( holder.itemView.getContext(),R.drawable.categorybackground1 ) );
                break;
            }
            case 3:{
                imageURL = "image_category_meat";
                holder.mainLayout.setBackground ( ContextCompat.getDrawable ( holder.itemView.getContext(),R.drawable.categorybackground1 ) );
                break;
            }
            case 4:{
                imageURL = "image_category_dessert";
                holder.mainLayout.setBackground ( ContextCompat.getDrawable ( holder.itemView.getContext(),R.drawable.categorybackground1 ) );
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier ( imageURL, "drawable", holder.itemView.getContext().getPackageName() );


        Glide.with ( holder.itemView.getContext() )
                .load (drawableResourceId )
                .into (holder.categoryImage );
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }


    /**
     * ViewHolder-Klasse für die Ansichtselemente im RecyclerView.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView categoryName;
        ImageView categoryImage;
        ConstraintLayout mainLayout;

        /**
         * Konstruktor für den ViewHolder.
         *
         * @param itemView  Ansichtselement, das in den ViewHolder eingefügt wird
         */
        public ViewHolder ( @NonNull View itemView ) {
            super ( itemView );

            categoryName = itemView.findViewById ( R.id.categoryName_id );
            categoryImage = itemView.findViewById ( R.id.categoryPic_id );
            mainLayout = itemView.findViewById ( R.id.mainLayout_id );

            itemView.setOnClickListener ( this );
        }

        /**
         * Handles clicking on a category.
         *
         * @param view      View item that was clicked
         */
        @Override
        public void onClick ( View view ) {
            categoryOnclickListener.onclickCategory ( view, getAdapterPosition () );
        }
    }

    public interface CategoryRecyclerViewClickListener{
        void onclickCategory ( View view, int position );
    }
}
