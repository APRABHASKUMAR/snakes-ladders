package com.example.snakeandladder;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BoxGridRecyclerAdapter extends RecyclerView.Adapter<BoxGridRecyclerAdapter.BoxTileViewHolder> {
    private List<Box> boxes;
    BoxGrid boxGrid;



    public BoxGridRecyclerAdapter(List<Box> boxes, BoxGrid boxGrid) {
        this.boxes = boxes;

        this.boxGrid = boxGrid;
    }

    @NonNull
    @Override
    public BoxTileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_box, parent, false);
        return new BoxTileViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BoxTileViewHolder holder, int position) {
        holder.bind(boxes.get(position));
        holder.setIsRecyclable(false);
    }

    @Override
    public int getItemCount() {
        return boxes.size();
    }



    class BoxTileViewHolder extends RecyclerView.ViewHolder {
        TextView valueTextView;

        public BoxTileViewHolder(@NonNull View itemView) {
            super(itemView);

            valueTextView = itemView.findViewById(R.id.item_box_value);

        }

        public void bind(final Box box) {

            itemView.setBackgroundColor(Color.GRAY);
            valueTextView.setText(String.valueOf(box.geti()));
            if (boxGrid.getA() == box.geti())
                valueTextView.setText(R.string.red);
            if (boxGrid.getB() == box.geti())
                valueTextView.setText(R.string.blue);
            if (box.getValue() == Box.ladder) {
                itemView.setBackgroundColor(Color.GREEN);
            } else if (box.getValue() == Box.snake) {
                itemView.setBackgroundColor(Color.RED);
            } else {
                itemView.setBackgroundColor(Color.GRAY);
                }




        }
    }
}
