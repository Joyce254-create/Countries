package com.example.counties;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CountyAdapter.OnCountyClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view_countries);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<County> counties = getKenyaCounties();
        CountyAdapter adapter = new CountyAdapter(counties, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCountyClick(County county) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_COUNTY, county);
        startActivity(intent);
    }

    private List<County> getKenyaCounties() {
        List<County> list = new ArrayList<>();

        list.add(new County("001", "Mombasa", "Mombasa City", "🌴", "1.2 Million", "Coast Region", "Tourism, Port Services, Trade", "Mombasa is Kenya's coastal hub and oldest city, home to Fort Jesus and Kilindini Harbour, East Africa's largest seaport."));
        list.add(new County("002", "Kwale", "Kwale", "🏖️", "866,000", "Coast Region", "Tourism, Mining (Titanium), Agriculture", "Kwale County is famous for Diani Beach, Shimba Hills National Reserve, and rich coastal wildlife and titanium mining."));
        list.add(new County("003", "Kilifi", "Kilifi", "⛵", "1.4 Million", "Coast Region", "Tourism, Fishing, Cashew Nuts & Coconut", "Kilifi features scenic beaches, Watamu Marine National Park, Malindi resort town, and the historic Gede Ruins."));
        list.add(new County("004", "Tana River", "Hola", "🌊", "315,000", "Coast Region", "Livestock Herding, Irrigation Farming", "Named after Kenya's longest river, Tana River County is home to unique primates, pastoral communities, and riverine forests."));
        list.add(new County("005", "Lamu", "Lamu Town", "🕌", "143,000", "Coast Region", "Swahili Culture, Tourism, Fishing", "Lamu Old Town is a UNESCO World Heritage Site, renowned for Swahili architecture, dhow sailing, and donkey transport."));
        list.add(new County("006", "Taita-Taveta", "Mwatate", "⛰️", "340,000", "Coast Region", "Tourism, Gemstone Mining, Farming", "Famous for Tsavo West and East National Parks, Taita Hills, gemstone mining, and historical World War I sites."));
        list.add(new County("007", "Garissa", "Garissa", "🐪", "841,000", "North Eastern", "Livestock Trade, Irrigation Agriculture", "Garissa is a major commercial center in North Eastern Kenya along the Tana River, known for livestock marketing and wildlife."));
        list.add(new County("008", "Wajir", "Wajir", "🏜️", "781,000", "North Eastern", "Pastoralism, Camel & Goat Herding", "Wajir features vast semi-arid plains, historic Italian bunkers, and a vibrant pastoral culture centered around camel keeping."));
        list.add(new County("009", "Mandera", "Mandera", "☀️", "867,000", "North Eastern", "Pastoralist Livestock, Cross-border Trade", "Located at the tri-border of Kenya, Ethiopia, and Somalia, Mandera is known for its resilient pastoral community and trade."));
        list.add(new County("010", "Marsabit", "Marsabit", "🌋", "459,000", "Eastern Region", "Pastoralism, Lake Turkana Fishing, Tourism", "Kenya's largest county by area, featuring Mount Marsabit, Lake Paradise, Chalbi Desert, and rich cultural heritage."));

        list.add(new County("011", "Isiolo", "Isiolo", "🦏", "268,000", "Eastern Region", "Livestock, Eco-Tourism (Samburu Reserve)", "Known as the gateway to Northern Kenya, Isiolo features Samburu and Buffalo Springs National Reserves and LAPSSET corridor."));
        list.add(new County("012", "Meru", "Meru", "🌱", "1.5 Million", "Eastern Region", "Miraa, Coffee, Tea & Banana Farming", "Located on the fertile slopes of Mount Kenya, Meru is a agricultural powerhouse producing tea, coffee, and horticulture."));
        list.add(new County("013", "Tharaka-Nithi", "Kathwana", "⛰️", "393,000", "Eastern Region", "Agriculture, Mount Kenya Climbing, Grain", "Home to Chogoria Mount Kenya climbing route, rich farmland, and scenic waterfalls along river valleys."));
        list.add(new County("014", "Embu", "Embu", "☕", "608,000", "Eastern Region", "Tea, Coffee, Macadamia Nuts & Maize", "Embu lies on the eastern slopes of Mt. Kenya, known for Seven Forks Hydroelectric Dams and fertile tea & coffee highlands."));
        list.add(new County("015", "Kitui", "Kitui", "🧱", "1.1 Million", "Eastern Region", "Coal Mining, Honey, Livestock & Crafts", "Famous for Akamba handicrafts, honey production, mineral deposits, and vast conservation areas like Tsavo East border."));
        list.add(new County("016", "Machakos", "Machakos", "🏙️", "1.4 Million", "Eastern Region", "Manufacturing, Real Estate, Horticulture", "Known as 'Place of Yellow Hills', Machakos is an industrial hub featuring Konza Technopolis and Machakos People's Park."));
        list.add(new County("017", "Makueni", "Wote", "🥭", "987,000", "Eastern Region", "Mango & Fruit Farming, Sand Dams, Grain", "Makueni is Kenya's leader in fruit processing (mangoes & oranges), community sand dams, and terraced conservation agriculture."));
        list.add(new County("018", "Nyandarua", "Ol Kalou", "🥔", "638,000", "Central Region", "Potato & Dairy Farming, Aberdare Tourism", "Home to the Aberdare Ranges and Lake Ol Bolossat, Nyandarua is Kenya's top potato producer and major dairy supplier."));
        list.add(new County("019", "Nyeri", "Nyeri", "☕", "759,000", "Central Region", "Coffee, Tea, Dairy & Mt. Kenya Tourism", "Historic central highland county, burial site of Baden-Powell, featuring Aberdare National Park and prime coffee estates."));
        list.add(new County("020", "Kirinyaga", "Kerugoya", "🌾", "610,000", "Central Region", "Rice Farming (Mwea), Tea & Coffee", "Home to Mwea Irrigation Scheme (Kenya's largest rice farm) and scenic Mt. Kenya forest slopes."));

        list.add(new County("021", "Murang'a", "Murang'a", "🥑", "1.0 Million", "Central Region", "Avocado, Tea, Coffee & Water Resources", "Cradle of the Kikuyu community, Murang'a leads Kenya in avocado exports, coffee production, and fresh water supply."));
        list.add(new County("022", "Kiambu", "Kiambu", "🏗️", "2.4 Million", "Central Region", "Real Estate, Industry, Dairy & Coffee", "Bordering Nairobi, Kiambu is one of Kenya's wealthiest counties with bustling towns like Thika, Ruiru, and Karuri."));
        list.add(new County("023", "Turkana", "Lodwar", "🌊", "926,000", "Rift Valley", "Oil Exploration, Lake Fishing, Pastoralism", "Home to Lake Turkana ('Jade Sea'), Cradle of Humankind fossil sites, oil fields, and rich indigenous traditions."));
        list.add(new County("024", "West Pokot", "Kapenguria", "🏔️", "621,0" +
                "" +
                "00", "Rift Valley", "Livestock, Gold Mining, Turkwel Hydro", "Known for Kapenguria Six historic museum, Cherangani Hills, Turkwel Gorge Dam, and traditional pastoralism."));
        list.add(new County("025", "Samburu", "Maralal", "🐆", "310,000", "Rift Valley", "Eco-Tourism, Cultural Heritage, Cattle", "Famous for Samburu National Reserve, Maralal Camel Derby, rugged landscapes, and vibrant Samburu cultural traditions."));
        list.add(new County("026", "Trans-Nzoia", "Kitale", "🌽", "990,000", "Rift Valley", "Maize Farming, Seed Production, Dairy", "Known as 'Kenya's Granary', Trans-Nzoia produces the bulk of Kenya's maize supply and houses Mount Elgon National Park."));
        list.add(new County("027", "Uasin Gishu", "Eldoret City", "🏃‍♂️", "1.1 Million", "Rift Valley", "Athletics, Wheat & Maize Farming, Education", "Capitalized by Eldoret City ('City of Champions'), famous worldwide for producing elite long-distance runners."));
        list.add(new County("028", "Elgeyo-Marakwet", "Iten", "🏅", "454,000", "Rift Valley", "High Altitude Athletics Training, Potato", "Home to Iten town ('Home of Champions'), the Kerio Valley Escarpment, and world-renowned high-altitude training camps."));
        list.add(new County("029", "Nandi", "Kapsabet", "🍵", "885,000", "Rift Valley", "Tea Estates, Dairy, Athletics", "Known as the 'Source of Champions', Nandi features endless green tea rolling hills and famous sports personalities."));
        list.add(new County("030", "Baringo", "Kabarnet", "🦩", "666,000", "Rift Valley", "Geothermal Energy, Honey, Lake Tourism", "Famous for Lake Baringo, Lake Bogoria flamingos & geysers, Tugen Hills, and high-quality organic honey."));

        list.add(new County("031", "Laikipia", "Rumuruti", "🐘", "518,000", "Rift Valley", "Wildlife Conservancies, Cattle Ranches", "Renowned for private game conservancies like Ol Pejeta, Lewa, endangered black rhinos, and luxury safari tourism."));
        list.add(new County("032", "Nakuru", "Nakuru City", "🦩", "2.1 Million", "Rift Valley", "Flamingo Tourism, Agriculture, Geothermal", "Kenya's 4th city, featuring Lake Nakuru National Park, Menengai Crater, Lake Naivasha, and Olkaria Geothermal Power."));
        list.add(new County("033", "Narok", "Narok", "🦁", "1.1 Million", "Rift Valley", "Maasai Mara Wildlife Tourism, Wheat", "Home to world-famous Maasai Mara National Reserve, the Great Wildebeest Migration, and vast wheat plantations."));
        list.add(new County("034", "Kajiado", "Kajiado", "🦒", "1.1 Million", "Rift Valley", "Amboseli Mt. Kilimanjaro View, Livestock", "Famous for Amboseli National Park with views of Mt. Kilimanjaro, Maasai culture, and rapid suburban expansion."));
        list.add(new County("035", "Kericho", "Kericho", "🍃", "901,000", "Rift Valley", "Tea Plantations, Dairy Farming", "Kenya's tea capital, world famous for producing aromatic black tea across green carpeted highland estates."));
        list.add(new County("036", "Bomet", "Bomet", "🥛", "875,000", "Rift Valley", "Dairy Farming, Tea & Horticulture", "Fertile South Rift county producing rich dairy milk, tea, and horticulture, bordered by Mau Forest Complex."));
        list.add(new County("037", "Kakamega", "Kakamega", "🌳", "1.8 Million", "Western Region", "Kakamega Rainforest, Sugarcane, Bullfighting", "Home to Kenya's only tropical rainforest (Kakamega Forest), Crying Stone of Ilesi, and rich cultural bullfighting."));
        list.add(new County("038", "Vihiga", "Mbale", "🪨", "590,000", "Western Region", "Tea, Agriculture, Granite Rocks", "Densely populated hilly county known for Maragoli Hills, tea farming, and scenic granite rock outcrops."));
        list.add(new County("039", "Bungoma", "Bungoma", "🎋", "1.6 Million", "Western Region", "Sugarcane, Mt. Elgon Caves, Agriculture", "Home to Chetambe Fort, Mt. Elgon Elephant Caves, Nzoia Sugar Company, and vibrant agriculture."));
        list.add(new County("040", "Busia", "Busia", "🐟", "893,000", "Western Region", "Cross-Border Trade with Uganda, Fishing", "Key gateway to East Africa with major border posts at Busia and Malaba, and Lake Victoria fisheries."));

        list.add(new County("041", "Siaya", "Siaya", "🛶", "993,000", "Nyanza Region", "Lake Victoria Fishing, Rice, Tourism", "Bordering Lake Victoria, home to Yala Wetland, Kogelo village (Obama's ancestral home), and rich cultural heritage."));
        list.add(new County("042", "Kisumu", "Kisumu City", "⛵", "1.1 Million", "Nyanza Region", "Port Trade, Lake Victoria Fishing, Tourism", "Kenya's third largest city and commercial hub of Western Kenya, featuring Dunga Hill Camp and Kisumu Impala Sanctuary."));
        list.add(new County("043", "Homa Bay", "Homa Bay", "🐟", "1.1 Million", "Nyanza Region", "Tilapia Fishing, Ruma National Park", "Home to Ruma National Park (sanctuary for rare Roan Antelope), Rusinga Island, and Lake Victoria fish trade."));
        list.add(new County("044", "Migori", "Migori", "🪙", "1.1 Million", "Nyanza Region", "Gold Mining, Sugarcane, Border Trade", "Gold rich county bordering Tanzania at Isebania, producing sugarcane, tobacco, and Lake Victoria fish."));
        list.add(new County("045", "Kisii", "Kisii", "🍌", "1.2 Million", "Nyanza Region", "Soapstone Carving, Bananas, Tea & Coffee", "Famous worldwide for Kisii Soapstone handicrafts, lush banana plantations, and high density agricultural entrepreneurship."));
        list.add(new County("046", "Nyamira", "Nyamira", "🍵", "605,000", "Nyanza Region", "Tea Estates, Pyrethrum, Dairy Farming", "Highland county blessed with rolling green tea farms, high rainfall, and vibrant dairy smallholder farms."));
        list.add(new County("047", "Nairobi", "Nairobi City", "🏙️", "4.3 Million", "Nairobi Area", "Capital City, Commerce, Tech, Finance, UN", "Kenya's capital city & economic engine, famous as the 'Green City in the Sun' and the world's only city with a national park (Nairobi National Park)."));

        return list;
    }
}