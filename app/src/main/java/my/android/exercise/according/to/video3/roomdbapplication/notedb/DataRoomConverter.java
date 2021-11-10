package my.android.exercise.according.to.video3.roomdbapplication.notedb;

import android.os.Bundle;

import androidx.room.TypeConverter;

import java.util.Date;

public class DataRoomConverter {


    @TypeConverter
    public static Date toDate(Long value){
        return value == null? null : new Date(value);

    }

    @TypeConverter
    public static Long toLong(Date value){
        return value == null? null : value.getTime();

    }


}
