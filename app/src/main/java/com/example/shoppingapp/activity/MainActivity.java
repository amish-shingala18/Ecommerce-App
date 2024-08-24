package com.example.shoppingapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shoppingapp.R;
import com.example.shoppingapp.adapter.ProductAdapter;
import com.example.shoppingapp.databinding.ActivityMainBinding;
import com.example.shoppingapp.interfaces.ShoppingInterface;
import com.example.shoppingapp.model.ProductModel;

import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    List<ProductModel> list = new ArrayList<>();
    List<ProductModel> filterList = new ArrayList<>();
    List<CarouselItem> carouselItems = new ArrayList<>();
    public static List<ProductModel> listCart = new ArrayList<>();

    ShoppingInterface shoppingInterface;

    String samsung = "Size (Main_Display)\n" +
            "172.5mm (6.8\" full rectangle) / 172.2mm (6.8\" rounded corners)\n" +
            "Resolution (Main Display)\n" +
            "3120 x 1440 (Quad HD+)\n" +
            "Technology (Main Display)\n" +
            "Dynamic AMOLED 2X\n" +
            "Color Depth (Main Display)\n" +
            "16M\n" +
            "Max Refresh Rate (Main Display)\n" +
            "120 Hz\n" +
            "\n" +
            "Rear Camera - Resolution (Multiple)\n" +
            "200.0 MP + 50.0 MP + 12.0 MP + 10.0 MP\n" +
            "Rear Camera - F Number (Multiple)\n" +
            "F1.7 , F3.4 , F2.2 , F2.4\n" +
            "Main Camera - Auto Focus\n" +
            "Yes\n" +
            "Rear Camera - OIS\n" +
            "Yes\n" +
            "Rear Camera - Zoom\n" +
            "Optical Zoom 3x and 5x, Optical quality Zoom 2x and 10x (Enabled by Adaptive Pixel sensor) , Digital Zoom up to 100x\n" +
            "Front Camera - Resolution\n" +
            "12.0 MP\n" +
            "Front Camera - Aperture F\n" +
            "F2.2\n" +
            "Front Camera - Auto Focus\n" +
            "Yes\n" +
            "Main Camera - Flash\n" +
            "Yes\n" +
            "Video Recording Resolution\n" +
            "UHD 8K (7680 x 4320)@30fps\n" +
            "Slow Motion\n" +
            "240fps @FHD, 120fps @UHD\n" +
            "\n" +
            "Memory_(GB)\n" +
            "12\n" +
            "Storage (GB)\n" +
            "512\n" +
            "Available Storage (GB)\n" +
            "484.0";
    String iphone = "128GB,256GB,512GB\n" +
            "\n" +
            "Super Retina XDR display\n" +
            "15.54 cm / 6.1″ (diagonal)\n" +
            "all‑screen OLED display\n" +
            "2556x1179-pixel resolution at 460 ppi\n" +
            "\n" +
            "Dynamic Island\n" +
            "HDR display\n" +
            "True Tone\n" +
            "Wide colour (P3)\n" +
            "Haptic Touch\n" +
            "20,00,000:1 contrast ratio (typical)\n" +
            "1,000 nits max brightness (typical); 1,600 nits peak brightness (HDR);\n" +
            "2,000 nits peak brightness (outdoor)\n" +
            "Fingerprint-resistant oleophobic coating\n" +
            "Support for display of multiple languages and characters simultaneously\n" +
            "\n" +
            "48MP Main: 26 mm, ƒ/1.6 aperture, sensor‑shift optical image stabilisation, 100% Focus Pixels,\n" +
            "support for super-high-resolution photos (24MP and 48MP)\n" +
            "\n" +
            "Enabled by TrueDepth camera for facial recognition\n" +
            "\n" +
            "Use your voice to send messages, set reminders and more\n" +
            "Activate hands‑free with only your voice using “Hey Siri”\n" +
            "Use your voice to run shortcuts from your favourite apps";
    String armani = "Water Resistant:- 50 m\n" +
            "Display Type:- Analog\n" +
            "Style Code:- AX2122\n" +
            "Series:- Hampton\n" +
            "Occasion:- Casual\n" +
            "Watch Type:- Wrist Watch\n" +
            "Pack of:- 1\n" +
            "Sales Package:- 1 Watch::1 Plastic Box::1 Warranty card";
    String titan = "Water Resistant:- Yes\n" +
            "Display Type:- Analog\n" +
            "Style Code:- NQ1734KM01\n" +
            "Series:- Neo Gents 2016\n" +
            "Occasion:- Casual\n" +
            "Watch Type:- Metallic, Thick Straps, Chronographs\n" +
            "Pack of:- 1\n" +
            "Calendar:- No";
    String samsungFridge = "French Door Frost free Refrigerators: : Premium refrigerators with auto-defrost function and bottom freezer easy access to food and drinks.\n" +
            "\n" +
            "Capacity : 679 liters | Suitable for families with 5 or more members.\n" +
            "\n" +
            "Manufacturer warranty : 1 year on product, 20 years on compressor\n" +
            "\n" +
            "Digital Inverter Compressor : Automatic Adjustment Of Speed In Response To Cooling Demand, Quieter Operation And Uses Less Power\n" +
            "\n" +
            "Storage or Interior description : Fresh Food Capacity : 392 Ltr | Freezer Capacity : 287Ltr | Total No : Of Compartments : 4 | Drawers : 1 | Shelves : 4 | Shelf Type : Toughened Glass Shelves | Anti-Bacterial Gasket | Bottle Storage Capacity : 6\n" +
            "\n" +
            "Convertible Freezer : You can easily convert the freezer into a fridge to create good space. Enjoy ultimate storage flexibility to suit your changing needs\n" +
            "\n" +
            "Water & Ice Dispenser : Non Plumbing water and ice dispenser for all your cold water, crushed ice and solid ice needs";
    String lg = "Side by Side Frost Free Refrigerator: Premium Refrigerators with auto-defrost function to prevent ice build-up\n" +
            "\n" +
            "Capacity 594 L: Suitable for Suitable for families with 5 or more members I freezer capacity: 250 L, fresh food capacity: 344 L\n" +
            "\n" +
            "Warranty: 1 year on product, 10 years on compressor\n" +
            "\n" +
            "Energy savings with Inverter linear compressor: provides higher energy efficiency and reduces energy wastage | helps maintain the appearance and taste of fresh products for longer by reducing temperature fluctuations\n" +
            "\n" +
            "Shelf Type: Tempered Glass Shelves | No. of shelves: 02 | Refrigerator Section: No. of Drawers - 2, No. of Door Basket- 6 | Freezer Section: No. of Drawers - 6\n" +
            "\n" +
            "Included in the box: 1 Refrigerator Unit, User Manual, Warranty Card\n" +
            "\n" +
            "Special Features: Door Cooling+, LED Display, Multi Air Flow, LG ThinQ (Wi-Fi): control and diagnose your refrigerator by your smart phone, Smart Diagnosis, Hygiene Fresh+, Exterior Display";
    String mi = "Connector Type:- USB, Micro USB\n" +
            "Battery Capacity:- 20000\n" +
            "Special Feature:- Short Circuit Protection, Fast Charging\n" +
            "\n" +
            "Triple port output\n" +
            "\n" +
            "Dual input port (Micro-USB/USB-C, Charging Time : 6.9 hours\n" +
            "\n" +
            "Advanced 12 Layer chip protection\n" +
            "\n" +
            "Smart power management\n" +
            "\n" +
            "6 months domestic warranty";
    String boat = "20000mAh capacity with Smart Power Management\n" +
            "\n" +
            "Lightning quick charge\n" +
            "\n" +
            "Universal compatibility\n" +
            "\n" +
            "Hassle-free charge\n" +
            "\n" +
            "Ultra-Durability including High Temperature and Scratch Resistance\n" +
            "\n" +
            "Built-in 12-layer Smart IC protection from short circuit, over charge & over discharge\n" +
            "\n" +
            "Input/Output control and LED indicators.\n" +
            "\n" +
            "Capacity: 20000 mAh\n" +
            "\n" +
            "Lithium Polymer Battery | Type-A, Type-C Connector\n" +
            "\n" +
            "Power Source: AC Adapter\n" +
            "\n" +
            "Charging Cable Included";
    String hp = "HP Victus Gaming Laptop, 12th Gen Intel Core i5-12450H, 4GB GTX 1650 GPU, 15.6-inch (39.6 cm), FHD, IPS, 144Hz, 8GB DDR4, 512GB SSD, Backlit KB, B&O, Dual Speakers (MSO, 2.37 kg), fa0070TX\n" +
            "\n" +
            "Model Name:- 15-fa0070TX\n" +
            "Screen Size:- 15.6 Inches\n" +
            "Hard Disk Size:- 512 GB\n" +
            "CPU Model:- Core i5\n" +
            "RAM Memory Installed Size:- 8 GB\n" +
            "Operating System:- Windows 11 Home\n" +
            "Special Feature:- Built in Alexa\n" +
            "Graphics Card Description:- Integrated";
    String asus = "Model Name:- ASUS Vivobook\n" +
            "Screen Size:- 15.6 Inches\n" +
            "Hard Disk Size:- 512 GB\n" +
            "CPU Model:- Intel Core i5\n" +
            "RAM Memory Installed Size:- 8 GB\n" +
            "Operating System:- Windows 11\n" +
            "Special Feature:- Backlit Keyboard, Anti Glare Coating\n" +
            "Graphics Card Description:- Integrated\n" +
            "\n" +
            "Processor: 12th Gen IntelCore i5-1235U, 1.3 GHz base speed, Up to 4.4 GHz Turbo Max Speed, 10MB Cache, 10 cores\n" +
            "\n" +
            "Memory: 8GB (4GB onboard + 4GB SO-DIMM) DDR4 3200MHz Upgradeable Up to 12GB with | Storage: 512GB M.2 NVMe PCIe 3.0 SSD Upgradeable Up to 1TB SSD\n" +
            "\n" +
            "Display: 15.6-inch (39.62 cms), FHD (1920 x 1080) 16:9 aspect ratio, LED Backlit, 220nits, 45% NTSC color gamut, Anti-glare display, TÜV Rheinland-certified, Screen-to-body ratio: 82 ％\n" +
            "\n" +
            "Graphics: Integrated Intel Iris Xe Graphics\n" +
            "\n" +
            "Operating System: Pre-loaded Windows 11 Home with lifetime validity | Software Included: Pre-Installed Office Home and Student 2021 | 1-Year McAfee Anti-Virus\n" +
            "\n" +
            "Design & Battery: 1.99 cm Thin | Thin and Light Laptop | Laptop weight: 1.7 kg | 42WHrs, 3-cell Li-ion battery | Up to 6 hours battery life ;Note: Battery life depends on conditions of usage\n" +
            "\n" +
            "Keyboard: Backlit Chiclet Keyboard";
    String boatAirdopes = "With Mic:Yes\n" +
            "\n" +
            "Active Noise Cancellation: upto 32dB\n" +
            "\n" +
            "50 Hours Playback: 6 HRS/Charge+ Additional 44HRS with Case\n" +
            "\n" +
            "ASAP Charge: 10 Mins Charge= 150 Mins Playback\n" +
            "\n" +
            "Beast Mode: 50ms Low Latency for Gaming\n" +
            "\n" +
            "Quad Mics ENx Technology: Clear Voice Calls\n" +
            "\n" +
            "Dual EQ Modes: boAt Signature Sound & Balanced Mode\n" +
            "\n" +
            "Bluetooth v5.3";
    String jbl = "With Mic:Yes\n" +
            "\n" +
            "Bluetooth version: 5.2\n" +
            "\n" +
            "Wireless range: 10 m\n" +
            "\n" +
            "Battery life: 32 hrs | Charging time: 2 hrs\n" +
            "\n" +
            "IP54-certified earbuds and IPX2 charging case are water and dust resistant| JBL Headphones App compatible\n" +
            "\n" +
            "Smart Ambient technology|TalkThru|Hands-free calls with VoiceAware\n" +
            "\n" +
            "Quick Charge: 10 mins = 2 hours of Playtime|JBL Deep Bass Sound|Ergonomic Design Comfort Fit";

    String samsungColor = "Titanium Gray, Titanium Black, Titanium Violet, Titanium Yellow";
    String iphonecolor = "Black, Blue, Green, Yellow, Pink";
    String armaniColor = "Golden";
    String titanColor = "Silver";
    String samsungFridgeColor = "Black";
    String lgColor = "Platinum Silver";
    String miColor = "Black";
    String boatColor = "Steel Blue, Burgundy, Carbon Black, Martian Red";
    String hpColor = "Blue";
    String asusColor = "Quiet Blue";
    String boatAirdopesColor = "Assassin Red, Black, Black Sabre, Celestial Blue, Cool Sapphire, Electric Blue";
    String jblColor = "Black, Beige, Mint, White";

    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imgCarousal.registerLifecycle(getLifecycle());

        carouselItems.add(new CarouselItem(R.drawable.livesale_1));
        carouselItems.add(new CarouselItem(R.drawable.livesale_2));
        carouselItems.add(new CarouselItem(R.drawable.livesale_3));
        carouselItems.add(new CarouselItem(R.drawable.livesale_4));
        carouselItems.add(new CarouselItem(R.drawable.livesale_5));
        carouselItems.add(new CarouselItem(R.drawable.livesale_6));
        carouselItems.add(new CarouselItem(R.drawable.livesale_7));
        carouselItems.add(new CarouselItem(R.drawable.livesale_8));
        carouselItems.add(new CarouselItem(R.drawable.livesale_9));

        binding.imgCarousal.setAutoPlay(true);
        binding.imgCarousal.setAutoPlayDelay(3000);
        binding.imgCarousal.setData(carouselItems);


        list.add(new ProductModel(R.drawable.samsung_black,"Samsung S24 Ultra","134,999","₹","129,999",samsung,samsungColor,1));
        list.add(new ProductModel(R.drawable.iphone_black,"Apple iphone 15","79,900","₹","71,999",iphone,iphonecolor,1));
        list.add(new ProductModel(R.drawable.armani,"A/X Armani Exchange","17,495","₹","8,159",armani,armaniColor,1));
        list.add(new ProductModel(R.drawable.titan,"Titan NQ1734KM01","9,895","₹","6,745",titan,titanColor,1));
        list.add(new ProductModel(R.drawable.samsung_fridge,"Samsung 679L Frost Free","240,000","₹","172,035",samsungFridge,samsungFridgeColor,1));
        list.add(new ProductModel(R.drawable.lg_fridge,"LG 594L Frost Free","154,490","₹","91,990",lg,lgColor,1));
        list.add(new ProductModel(R.drawable.mi_powerbank,"Mi 20000 mAh 18W","3,499","₹","1,858",mi,miColor,1));
        list.add(new ProductModel(R.drawable.boat_powerbank,"boAt 20000 mAh 22.5W","4,499","₹","1,441",boat,boatColor,1));
        list.add(new ProductModel(R.drawable.hp_laptop,"HP Victus Intel Core i5","77,566","₹","55,580",hp,hpColor,1));
        list.add(new ProductModel(R.drawable.asus_laptop,"ASUS Vivobook 15 Intel Core i5","70,990","₹","48,990",asus,asusColor,1));
        list.add(new ProductModel(R.drawable.boat_buds,"boAt Airdopes 161 ANC","5,999","₹","1,399",boatAirdopes,boatAirdopesColor,1));
        list.add(new ProductModel(R.drawable.jbl_buds,"JBL Wave Beam TWS","4,999","₹","3,498",jbl,jblColor,1));

//        shoppingInterface=new ShoppingInterface() {
//            @Override
//            public void onClick(int position) {
//                Intent intent = new Intent(MainActivity.this,ShoppingDetailsActivity.class);
//                intent.putExtra("image",list.get(position).modelImage);
//                intent.putExtra("product Name",list.get(position).modelNames);
//                intent.putExtra("originalPrice",list.get(position).modelOriginal);
//                intent.putExtra("price",list.get(position).modelPrice);
//                intent.putExtra("description",list.get(position).modelDescription);
//                intent.putExtra("product Color",list.get(position).modelColor);
////                intent.putExtra("product Quantity",list.get(position).qa);
//                //intent.putExtra("rating",list.get(position).)
//                startActivity(intent);
//            }
//        };

        ProductAdapter adapter = new ProductAdapter(list,shoppingInterface);
        binding.rvProducts.setAdapter(adapter);

        binding.svItem.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.imgCarousal.setVisibility(View.GONE);
            }
        });
        binding.svItem.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                binding.imgCarousal.setVisibility(View.VISIBLE);
                return false;
            }
        });
        binding.svItem.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int position) {
                return false;
            }

            @Override
            public boolean onSuggestionClick(int position) {
                return false;
            }
        });
        binding.svItem.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList=list.stream().filter(a->a.modelNames.toLowerCase().contains(newText.toLowerCase())).collect(Collectors.toList());
                adapter.search(filterList);
                return false;
            }
        });

        binding.imgCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCart = new Intent(MainActivity.this,AddtoCartActivity.class);
                startActivity(intentCart);
            }
        });
    }
}