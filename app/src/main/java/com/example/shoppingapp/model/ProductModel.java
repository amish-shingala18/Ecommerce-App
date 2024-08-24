package com.example.shoppingapp.model;

import android.widget.RatingBar;

public class ProductModel {

    public int modelImage;
    public String modelNames;
    public String modelPrice;
    public String modelOriginal;
    public String modelRupees;
    public String modelDescription;
    public String modelColor;
    public int qa=1;
    //public float ModelRating;

    public ProductModel(int modelImage,String modelNames,String modelOriginal,String modelRupees,String modelNumber,String modelDescription,String modelColor,int qa)
    {
        this.modelImage=modelImage;
        this.modelNames=modelNames;
        this.modelOriginal=modelOriginal;
        this.modelRupees=modelRupees;
        this.modelPrice=modelNumber;
        this.modelDescription=modelDescription;
        this.modelColor=modelColor;
        this.qa =qa;
        //this.ModelRating=ModelRating;
    }

}
