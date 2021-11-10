package my.android.exercise.according.to.video3.roomdbapplication.notedb;


import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;

//Serializable  ->allows to make the Entity and Constants exact name

@Entity(tableName = Constants.Table_Name_Note)
public class Note implements Serializable {

    //Columns
    @PrimaryKey(autoGenerate = true)
    private long note_id;

    @ColumnInfo(name = "note_content")
    private String content;
    private String title;
    private Date date;

    //Constructors
    public Note(String content, String title) {
        this.content = content;
        this.title = title;
        this.date=new Date(System.currentTimeMillis());
    }

    @Ignore
    public Note(){

    }

    //adding getter and setter

    public long getNote_id() {
        return note_id;
    }

    public void setNote_id(long note_id) {
        this.note_id = note_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //override the equals boolean function


    @Override
    public boolean equals(@Nullable Object obj) {
        if (this==obj) return true;
        if (!(obj instanceof Note)) return false;
        Note note=(Note) obj;
        if (note_id!=note.note_id) return false;
        return title!=null?title.equals(note.title):note.title==null;

    }

    //override the hash code function for a returning a result of note_id


    @Override
    public int hashCode() {
        int result= (int) note_id;
        result=31*result+(title!=null?title.hashCode():0);
        return result;
    }

    //calling the to String method

    @Override
    public String toString() {
        return "Note{" +
                "note_id=" + note_id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                '}';
    }
}
