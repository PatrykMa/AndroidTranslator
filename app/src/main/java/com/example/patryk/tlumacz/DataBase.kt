package com.example.patryk.tlumacz
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.content.Context
import android.widget.Toast

val DataBaseName :String ="slowka"

val TableWorldName : String="PolAng"
val Col_FirstLanguage :String ="polskie"
val Col_SeceondLanguage : String ="angielskie"
val Col_ID :String ="ID_w"
val Col_typ :String ="kategoria"

val TableCategoryName :String="kategorie"
val Col_Kategory:String ="kategoria"
val Col_KategoryID :String ="ID_k"

/**
 * Created by Patryk on 2018-03-10.
 */
class DataBase(var context: Context) : SQLiteOpenHelper(context,DataBaseName,null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TableWorldName +" (" +
                Col_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                Col_FirstLanguage + " VARCHAR(256)," +
                Col_typ + " VARCHAR(256)," +
                Col_SeceondLanguage + " VARCHAR(256))"

        val createSecTable = "CREATE TABLE " + TableCategoryName +" (" +
                Col_KategoryID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
                Col_Kategory + " VARCHAR(256))"

        db?.execSQL(createTable)
        db?.execSQL(createSecTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?,oldVersion: Int,newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertCategory(cat : Category ){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(Col_Kategory,cat.Kategoria)
        var result = db.insert(TableCategoryName,null,cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }

    fun readCategory() : MutableList<Category>{
        var list : MutableList<Category> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TableCategoryName
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                var cat = Category()
                cat.ID = result.getString(result.getColumnIndex(Col_KategoryID)).toInt()
                cat.Kategoria = result.getString(result.getColumnIndex(Col_Kategory))
                list.add(cat)
            }while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun readCategoryMaxNumber() : Int{
        var list : MutableList<Category> = ArrayList()
        var wynik: Int=-1
        val db = this.readableDatabase
        val query = "Select " + Col_KategoryID+ " from " + TableCategoryName + " ORDER BY DESC"
        val result = db.rawQuery(query,null)
        if(result.moveToFirst()){
            wynik=  result.getString(result.getColumnIndex(Col_KategoryID)).toInt()
        }
        result.close()
        db.close()
        return wynik
    }

    fun getCategoryById(id : Int ) : String{
        var list : MutableList<Category> = ArrayList()

        val db = this.readableDatabase
        val query = "Select " + Col_Kategory + " from " + TableCategoryName + " WHERE " + Col_KategoryID + " = " + id.toString()
        val result = db.rawQuery(query,null)
        var kat : String = ""
        if(result.moveToFirst()){
                kat = result.getString(result.getColumnIndex(Col_Kategory))

        }

        result.close()
        db.close()
        return kat
    }

}