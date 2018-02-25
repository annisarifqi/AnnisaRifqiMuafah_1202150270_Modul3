package id.web.annisa.annisarifqimuafah_1202150270_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by Ryan Ar-rofiq on 25/02/2018.
 */

public class Drink {
    //inisiasi variabel yg di panggil di activity lain
    private String title;
    private String info;
    private int image;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image";

    //menempatkan variabel di class ini
    public Drink(String title, String info, int image) {
        this.title = title;
        this.info = info;
        this.image = image;
    }

    public int getImage() {
        return image;
    } //mengambil nilai image

    public String getInfo() {
        return info;
    } //mengambil nilai info

    public String getTitle() {
        return title;
    } //mengambil nilai title

    //Menuju activity selanjutnya
    public static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);

        return detailIntent;
    }

}
