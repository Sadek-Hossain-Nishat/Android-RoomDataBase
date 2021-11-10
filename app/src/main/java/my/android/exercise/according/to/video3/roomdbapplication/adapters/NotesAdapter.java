package my.android.exercise.according.to.video3.roomdbapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import my.android.exercise.according.to.video3.roomdbapplication.R;
import my.android.exercise.according.to.video3.roomdbapplication.notedb.Note;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.BeanHolder> {

    // 1 assigning some necessary variables
    private List<Note> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private OnNoteItemClick onNoteItemClick;

    // 2 creating a constructor
    public NotesAdapter(List<Note> list, Context context) {
        layoutInflater=LayoutInflater.from(context);
        this.list = list;
        this.context = context;
        this.onNoteItemClick=(OnNoteItemClick) context;
    }

    @NonNull
    @Override
    public BeanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=layoutInflater.inflate(R.layout.note_list_item,parent,false);
        return new BeanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeanHolder holder, int position) {
        holder.textViewTitle.setText(list.get(position).getTitle());
        holder.textViewContent.setText(list.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public interface OnNoteItemClick{
        void onNoteClick(int pos);
    }


    // BeanHolder class (ViewHolder)
    public class BeanHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewContent, textViewTitle;
        public BeanHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewContent=itemView.findViewById(R.id.item_text);
            textViewTitle=itemView.findViewById(R.id.tv_title);
        }

        @Override
        public void onClick(View v) {

            onNoteItemClick.onNoteClick(getAdapterPosition());

        }
    }
}
