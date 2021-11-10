package my.android.exercise.according.to.video3.roomdbapplication.notedb;


import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM "+Constants.Table_Name_Note)
    List<Note> getNotes();

    //insert the data
    @Insert
    long insertNote(Note note);


    //update the  data of a row
    @Update
    void updatNote(Note repos);

    //delete the data of a row
    @Delete
    void deleteNote(Note note);



    //delete all notes from the database
    @Delete
    void deleteNotes(Note... note);
    //... means an array of object of Note
    //here it will be notes instead of note



}
