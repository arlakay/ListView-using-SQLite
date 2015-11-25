package com.jsfood.database;

import java.util.ArrayList;
import com.jsfood.model.Restaurant;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

public class RestaurantDB extends SQLiteOpenHelper {
	private Context context = null;
	private SQLiteDatabase database = null;
	private static final String DATABASE_NAME  = "RestaurantDB";
	private static final String DATABASE_TABLE = "tbl_m_restaurant";
	
	//  The name and column index of each column in your database.
	public static final String KEY_ID       = "Id";
    public static final String KEY_CATEGORI = "Categori";
	public static final String KEY_NAME     = "Name";
	public static final String KEY_ADDRESS  = "Address";
	public static final String KEY_DETAIL   = "Detail";
	public static final String KEY_PIC      = "Pic";
	
	//  Constructor with parameter context
	public RestaurantDB(Context context) {
		super(context, DATABASE_NAME, null, 1);
	}
	
	//  Drop Table 'tbl_m_restaurant'
	public void dropTable(SQLiteDatabase db) {
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
	}
	
	//  Create Table 'tbl_m_restaurant'
	public void createTable(SQLiteDatabase db, Context context) {
		this.context = context;
		database = this.context.openOrCreateDatabase(DATABASE_NAME, SQLiteDatabase.CREATE_IF_NECESSARY, null);
		String sqlCreate = "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE + " ("
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_CATEGORI + " varchar(50),"
				+ KEY_NAME + " varchar(50),"
				+ KEY_ADDRESS + " varchar(250),"
				+ KEY_DETAIL + " text," 
				+ KEY_PIC + " varchar(50)" + ");";
		DBUtil.createTable(database, DATABASE_TABLE, sqlCreate); 
	}

	//  Generate data to database SQLite
	public void generateData(SQLiteDatabase db){
		ContentValues cv = new ContentValues();
		cv.put(KEY_ID, 1);
        cv.put(KEY_CATEGORI, "1");
		cv.put(KEY_NAME, "FILOSOFI KOPI");  
		cv.put(KEY_ADDRESS, "BLOK M MELAWAI, JAKARTA");
		cv.put(KEY_DETAIL, "Filosofi Kopi coffee shop at Blok M Melawai area has become the talk of the town lately following the success of Filosofi Kopi Movie.\n\n"+
				"This coffee shop is located inside Pusat Niaga Blok M Square area at Melawai 6 street across M Hotel. The building of this coffee shop is very interesting, it is actually built from abandoned building where they renovate the first floor into a cozy charming space. Coffee and non coffee menu are available here with price range from IDR 18k to IDR 40k while the snacks menu are quite limited to waffle, fries and fried cassava.\n\n"+
				"Filosofi Kopi movie is a movie adapted from Dewi Lestari’s Filosofi Kopi book where the set of coffee shop they use to shoot this movie is actually has been opened to the public lately and packed with a lot of customers in instant both from coffee lovers and Filosofi Kopi movie lovers where they can enjoy the coffee while imagining every single scene of the movie from every corner. Here are some picture of Filosofi Kopi coffee shop, Let’s start the tour!\n\n"+
				"Address:\nFilosofi Kopi\nJl. Melawai VI\nBlok M, Kebayoran Baru\nSouth Jakarta, 12160\n\nOpening Hours:\n08.00-11.30, 13.30-22.00\n\n"+
                "Sumber: http://anakjajan.com/2015/05/20/filosofi-kopi-blok-m-melawai-jakarta/");
		cv.put(KEY_PIC, "filosofi_kopi_one");
		db.insert(DATABASE_TABLE, null, cv);

		cv.put(KEY_ID, 2);
        cv.put(KEY_CATEGORI, "1");
		cv.put(KEY_NAME, "AMBER CHOCOLATE BAR");  
		cv.put(KEY_ADDRESS, "SENOPATI, JAKARTA");
		cv.put(KEY_DETAIL, "I’m always amazed by how fast the restaurant or cafe scene at Senopati area grow, I think almost every time we pass this street there’s always a new establishment opening with another new concept including Amber Chocolate Bar.\n\n"+
					"Amber Chocolate Bar has already opened since the end of December 2014 and after returning from Japan, I immediately drag my foodie friend Hans to accompany me to visit Amber.\n\n"+
					"It’s located at Senopati street South Jakarta right across Cacaote. The huge building is covered by the plant thoroughly making it impossible not to be noticed.\n\n"+
					"There are three floors with 3 distinctive concepts in each floor: Pastry Boutique on the 1st floor with elegant and lux interior, Library with more casual ambiance for dining and Sky Roof Top with luxurious marble bar and 360 degrees view.\n\n"+
					"Because it was still early in the afternoon and we were quite full, we sat at the 1st floor (Pastry Boutique) and only ordered some cakes along with their signature Hot Chocolate.\n\n"+
					"Strawberry Mousse IDR 35k\nWe ordered this one simply because it looks pretty. Flavor wise was decent, not overly sweet with refreshing fruity mousse.\n\n"+
					"Macaron Raspberry Sandwich IDR 40k\nCrunchy huge macaron yet cream and fresh raspberries inside. I love the tanginess from fresh raspberries resulting a balanced sweet flavor.\n\n"+
					"Chocolate Salt Caramel Pie IDR 40k\nThis one was our favorite, chocolate mousse kinda texture with crunchy pie crust and melting salted caramel sauce in the middle. Sweet yet savory in every bite, yummy!\n\n"+
					"Amber Signature Hot Chocolate – Val Jivawa Hot Chocolate Fountain IDR 55k\nLuscious, silky smooth yet rich cacao drink flowing from their signature chocolate fountain. The creaminess and bitterness were in perfect composition making it very comforting especially during rainy day. Must try!\n\n"+
					"Overall, I personally love the concept from Amber, they certainly have a gorgeous and beautiful interior, looking forward for another visit for heavy meal. Let’s Jajan!!\n\n"+
					"Address:\nAmber Chocolate Bar\nJl. Senopati Raya No. 61, Kebayoran Baru, Jakarta Selatan\nPhone: (+6221) 29044412\nInstagram: @amberchocolatebar\nOpening Hours: Pastry Boutique 07:00 – 22:00, Library 10:00 – 23:00, Sky Lounge 17:00 – 01:00\n\n"+
                    "Sumber: http://anakjajan.com/2015/01/13/amber-chocolate-bar-senopati-jakarta/");
		cv.put(KEY_PIC, "amber_chocolate_bar");
		db.insert(DATABASE_TABLE, null, cv);

        cv.put(KEY_ID, 3);
        cv.put(KEY_CATEGORI, "1");
        cv.put(KEY_NAME, "WOODPECKER COFFEE");
        cv.put(KEY_ADDRESS, "PANGLIMA POLIM JAKARTA");
        cv.put(KEY_DETAIL, "How do you describe you perfect coffee shop?? Great music, nice coffee, fast wifi connection and cozy ambiance?? Well this newly opened Woodpecker Coffee Shop at Jakarta Panglima Polim area might be the answer.\n\n"+
                    "Located at Panglima Polim V street, this little coffee shop is super easy to spot, it’s right across Mangia and Taco Local or right beside Holy Gyu steak.\n\n"+
                    "This coffee shop unfortunately is quite small with limited seating capacity, but AnakJajan really love the simple combination with brown wooden and grey cement furniture and huge glass window on the front giving this coffee shop a really nice and bright natural light.\n\n"+
                    "So basically if you visit during daytime, it will be almost effortless for you to take a great picture or I may say ‘instagenic’ photo.\n\n"+
                    "AnakJajan ordered Cappuccino IDR 27k and Machiato IDR 18k. Cappuccino was smooth creamy and nice while Machiato was super acid, we didn’t manage to ask the staff about which coffee they are using because AnakJajan were too busy chatting and gossiping with our foodie friends Hans and Aline and also because one of the customer brought his super cute and huge dog we couldn’t stop looking at it.\n\n"+
                    "As for the food, they only provide one menu that is Waffle. The waffle cost IDR 15k/waffle where you can choose original or oreo batter and also soft or crispy texture. You can also add additional topping such as maple syrup, fresh strawberry, nutella, banana, etc. We chose Waffle Oreo IDR 15k + Nutella IDR 10k + Banana IDR 5k. Waffle was delicious and crispy especially when you pair it with Nutella, unfortunately the Banana served was not as much as I saw on instagram posts that usually cover the whole waffle.\n\n"+
                    "Overall, AnakJajan enjoyed our time at Woodpecker, coffee and waffle were great but it might be a bit uncomfortable to stay for a long time because of the limited seat. Let’s Jajan!!\n\n"+
                    "Address:\n" +
                    "Woodpecker\n" +
                    "Jl. Panglima Polim V No.23\n" +
                    "South Jakarta\n\n"+
                    "Sumber: http://anakjajan.com/2014/08/12/woodpecker-coffee-panglima-polim-jakarta/");
        cv.put(KEY_PIC, "woodpecker_coffee");
        db.insert(DATABASE_TABLE, null, cv);

        cv.put(KEY_ID, 4);
        cv.put(KEY_CATEGORI, "1");
        cv.put(KEY_NAME, "TRAFIQUE COFFEE");
        cv.put(KEY_ADDRESS, "HANG TUAH RAYA JAKARTA");
        cv.put(KEY_DETAIL, "Trafique Coffee is a newly opened coffee shop at Hang Tuah Raya street south Jakarta near Senayan City Mall. This place is rather difficult to find because they are not putting any signboard, so you need to pay attention and find a white brick building with yellow door and huge yellow number 9 sign.\n\n"+
                    "Once AnakJajan entered this coffee shop, we instantly fell in love with it, ambiance inside was so calm and homy it was like we were visiting a friend’s house.\n\n"+
                    "Space inside Trafique Coffee was really spacious with bright white brick wall, high ceiling and backyard. Smoking and non smoking area are separated with glass door.\n\n"+
                    "Fyi, Trafique Coffee roast and grind their own coffee. There are quite a lot of coffee selection from hot to cold, manual brew to unique combination using tonic water or sprite with espresso. Moreover, Trafique Coffee also offer some cake selection: Tiramisu IDR 25k, Brownies IDR 15k, Strawberry Cheesecake IDR 30k, Hummingbird Cake IDR 35k, Carrot Cake IDR 35k; Soup: Red Bean Soup IDR 50k, Oxtail Cream Soup IDR 55k; and Bread: Crispy Thai Toast IDR 28k, Sausage Bread Roll IDR 28k, Choco Cheese Bread Roll IDR 28k. Food selection is rather limited at this moment, probably they will add more as time goes by.\n\n"+
                    "The cakes look appealing and we heard that their carrot cake was Really GOOD, but since AnakJajan are still very full after having a super huge huge huge meal at Hardrock Cafe anniversary (review coming soon) earlier, we only manage to try their coffee and it was good.\n\n"+
                    "Overall coffee and ambiance at Trafique was good, we spent quite a long time sitting and chatting with friends we almost lose track of time. Looking forward for another visit. Let’s Jajan!!\n\n"+
                    "Address:\n" +
                    "Trafique Coffee\n" +
                    "Jl. Hang Tuah Raya No.9\n" +
                    "South Jakarta\n" +
                    "Opening Hours: 08.00 – 20.00 everyday\n\n"+
                    "Sumber: http://anakjajan.com/2014/06/16/trafique-coffee/");
        cv.put(KEY_PIC, "trafique_coffee");
        db.insert(DATABASE_TABLE, null, cv);

        cv.put(KEY_ID, 5);
        cv.put(KEY_CATEGORI, "1");
        cv.put(KEY_NAME, "ASIAN DOLCE LATTE – STARBUCKS");
        cv.put(KEY_ADDRESS, "STARBUCKS 1PARK (DEKAT GANDARIA CITY)");
        cv.put(KEY_DETAIL, "Sahabat Jajan, do you know that Starbucks setiap periode tertentu selalu meluncurkan varian makanan/minuman baru yang limited tersedia selama periode tertentu saja.  beberapa waktu yang lalu di salah satu outlet terbaru Starbucks di 1Park AnakJajan mencicipi makanan dan minuman terbaru Starbucks.\n\n"+
                    "Sumatra Mousse\n" +
                    "Kreasi cake yang satu ini menggunakan kopi Sumatra sebagai ingredientnya, rada yang dominan dari kue ini adalah bittersweet hasil perpaduan kopi dan dark choco.\n\n"+
                    "Sumatra Eclair\n" +
                    "Huge piece of eclair, pada bagian atasnya eclair diberi topping caramel yang tebal dan legit, kemudian didalamnya diisi dengan chocolate truffle yang juga mengandung kopi Sumatra, karena rasanya yang cukup manis akan lebih cocok jika dipadukan dengan kopi pahit, perfect for a sweetooth.\n\n"+
                    "Hot Asian Dolce Latte\n" +
                    "Tersedia mulai dari 5 Maret sampai dengan 22 April 2013 Sahabat Jajan bisa menemukan Asian Dolce Latte di outlet-outlet Starbucks terdekat.\n" +
                    "Asian Dolce Latte terbuat dari campuran double shot dark-roasted Starbucks Espresso Roast dengan dolce sauce, steamed milk. Sekilas aroma milky dari dolce sauce agak mengingatkan AnakJajan dengan susu kental manis yang khas.\n\n"+
                    "Iced Asian Dolce Latte\n" +
                    "Selain versi panas, Sahabat Jajan juga bisa menikmati minuman ini dengan es, hanya saja bagi AnakJajan aroma khas dari Asian Dolce Latte dapat lebih terasa pada versi panas. Penggunaan whipped cream pada minuman ini tidak seperti whipped cream pada biasanya melainkan ini warnanya agak sadikit kecoklatan karena whipped cream yang digunakan mengandung espresso didalamnya menghasilkan aroma yang lebih special.\n\n"+
                    "Tea at Starbucks\n" +
                    "Selain kopi, do you know kalau di Starbucks juga tersedia tea bags dengan 4 varian Spearmint Green, English Breakfast, Earl Grey dan Chai.\n\n"+
                    "Buat Sahabat Jajan yang sering menggunakan kereta api, sejak akhir Januari 2013 kemarin Starbucks resmi membuka gerai pertama mereka di stasiun kereta api buka mulai dari jam 5 pagi sampai 8 malam setiap hari.\n\n"+
                    "Alamat:\n" +
                    "Starbucks 1Park\n" +
                    "1Park Residences, Ground Floor Unit A1,A2 (dekat Gandaria City)\n" +
                    "Jl. KG M Syafi I Hadzami No.1\n" +
                    "Kebayoran Baru, Jakarta Selatan 12240\n\n"+
                    "Sumber: http://anakjajan.com/2013/03/25/asian-dolce-latte-starbucks/");
        cv.put(KEY_PIC, "asian_dolce_latte");
        db.insert(DATABASE_TABLE, null, cv);

        cv.put(KEY_ID, 6);
        cv.put(KEY_CATEGORI, "2");
        cv.put(KEY_NAME, "THE REPUBLIC OF BURGER");
        cv.put(KEY_ADDRESS, "Ruko Kemayoran Arcade 2 Block b1, Sector 7th");
        cv.put(KEY_DETAIL, "Hello meat monster!! How do you like your burger?? Me and Mr. Jajan both are a huge fan of burger, we love our burger with soft bun and huge meat patty with generous amount of melting cheese in it and we are very pleased that The Republic of Burger has it all!\n\n"+
                    "Here in The Republic of Burger, small portion of meat patty is a big no no!! Their normal portion of burger is 250gr home-made patty made from 100% Australian premium Wagyu Beef seasoned and grilled directly by order. But of course if you have limited tummy space, don’t worry because here they also serve Junior size of burger with 150gr meat patty for IDR 38k to IDR 42k.\n\n"+
                    "At this moment you can visit The Republic of Burger at Cipete and Bintaro outlet, they are also opening very very soon at Kemang, will keep you updated later when it’s opening.\n\n"+
                    "The Poutine Monster IDR 39k\n" +
                    "As I’ve always said, I’m a huge fan of potato!! Anything potato related will make me crazy and this one is not an exception, love it!! 350gr fresh cut Canadian fries drizzled with their homemade Volcano sauce and bockwurst sausage. The volcano sauce is phenomenal! Spicy yet tasty and addicting. Btw they also serve burger with this spicy sauce if I’m not mistaken, so gonna get burger with volcano sauce for next visit!\n\n"+
                    "Nutella Freeze IDR 39k\n" +
                    "This is one of the signature and recommended drink here made from Nutella, chocolate ice cream and low fat milk. It has a balance creaminess and sweetness with chocolatey, milky and nutty flavor combination.\n\n"+
                    "Summer Breeze IDR 29k\n" +
                    "Refreshing and fruity drink with lovely color combination, red from grenadine syrup, orange from orange juice and blue from soda water.\n\n"+
                    "The Republican Monster IDR 76k\n" +
                    "Messy messy good!! 250gr Australian premium Wagyu beef grilled patty topped with double melted cheddar cheese and crispy sliced bacon. There are several sauce options for the sauce, we opted for black pepper sauce with savory flavor and warm peppery kick in it.\n\n"+
                    "The beef patty itself was tender, moist and juicy with a great seasoning in it not to mention the huge portion while the bun was soft and fluffy. Combination between beef patty and bun itself already tasty, it became even better by adding melting cheese, and crispy bacon in it, no wonder this one is one of their best seller.\n\n"+
                    "Another thing that I love from The Republic of Burger is they use organic vegetables and all of the menu here contain no MSG, no chemicals and any other harmful preservatives.\n\n"+
                    "Juicy Lucy Monster IDR 70k\n" +
                    "This one is very special because the 250gr beef patty is stuffed with melted cheese inside, my oh my!! Heavenly! Similar with the burger above, the patty also tender, moist and juicy with soft bun.\n\n"+
                    "See the juicy patty and melted cheese inside?? I’m sure that you are now drooling right now?? Don’t worry, I’m also drooling until my keyboard wet already while writing this post.\n\n"+
                    "Fries is served as side dish to go with the burger, we had waffle fries but you can choose Aussie fries, waffle, curly or pompoms fries as you wish.\n\n"+
                    "Overall, tasty burger, great portion and affordable price. If you are a big fan of burger, we are very sure that you will enjoy it as much as we did. Let’s Jajan!!\n\n"+
                    "Address:\n" +
                    "The Republic of Burger\n" +
                    "1st outlet: Jalan Cipete Raya No 26, South Jakarta (will be closed in the end of December 2014)\n" +
                    "Phone (+6221) 36580862\n" +
                    "2nd outlet: Ruko Kemayoran Arcade 2 Block b1, Sector 7th\n" +
                    "3rd outlet: South Kemang No. 150 D4 (soon will be opened in the end of this week, *will be updated soon)\n" +
                    "Phone: (+6221) 36580862\n\n"+
                    "Sumber: http://anakjajan.com/2014/12/06/the-republic-of-burger/");
        cv.put(KEY_PIC, "the_republic_of_burger");
        db.insert(DATABASE_TABLE, null, cv);

        cv.put(KEY_ID, 7);
        cv.put(KEY_CATEGORI, "2");
        cv.put(KEY_NAME, "‘SMOKE IT UP’ AMERICAN BARBECUE – POTATO HEAD");
        cv.put(KEY_ADDRESS, "Pacific Place G 51 A");
        cv.put(KEY_DETAIL, "Heyyhoooo barbecue lovers!! This month, Potato Head Jakarta Pacific Place is collaborating with talented chefs from Up In Smoke Barbeque, Justin and Zachary, California and Texas to serve amazing American BBQ at Potato Head.\n\n"+
                    "Do you still remember our 10 Tips on How to Take Instagenic Photos for Instagram?? Well because the lighting inside Potato Head Pacific Place is very minimum and dark, AnakJajan had no choice but to follow tips no.2 that is using phont flash light feature, so most of the food photo in this post are produced using phone flashlight lighting.\n\n"+
                    "There are several menu creation for ‘Smoke It Up’ all made from scratch with special family recipe with “low and slow” technique using custom built smokers and a variety of local hardwoods to smoke the meats with low temperatures for up to 14 hours to create smoky tender and flavorful meat.\n\n"+
                    "Along with the meat, there are 3 special cocktail mix designed to accompany the strong and smoky flavours of the dishes perfectly, Red Alley IDR 120k, Socialite IDR 120k and Bourbon Darjeeling Marteani IDR 120k, out favorite would be the strong with a nice refreshing kick Socialite.\n\n"+
                    "Socialite IDR 120k\n" +
                    "Jim bean white bourbon whiskey, fresh lemon pieces with homemade vanilla icing sugar\n\n"+
                    "Bourbon Darjeeling Marteani IDR 120k\n" +
                    "Jim beam white bourbon whiskey, fresh lemon juice, black tea and brown sugar\n" +
                    "\n" +
                    "Chicken Noodle Soup IDR 90k\n" +
                    "Fresh organic vegetables, pasta poured with comforting chicken broth with a nice smokiness in it and then paired with a slice of crunchy cheese toast. Very simple yet hearty, no the usually chicken noodle soup you can find elsewhere.\n\n"+
                    "Pulled Pork Sliders IDR 115k\n" +
                    "Our number 1 favorite of the night, two mini burger buns filled with slow smoked pulled pork shoulder with sweet tangy sauce and crunchy fresh coleslaw. Pulled pork was super tender and addicting.\n\n"+
                    "Beef Brisket IDR 320k\n" +
                    "Special rubbed with house blend spiced and slow smoked for 14 hours resulting a very smoky yet tender beef brisket. Taste even better with their BBQ sauce, oh my god this BBQ sauce is very special and one of a kind I wish they sell it in the supermarket.\n\n"+
                    "German Minnesota Potato Salad IDR 35k\n" +
                    "Simple and light potato salad made by using old family recipe from Germany with fresh homemade ingredients.\n\n"+
                    "Barbecue Beans IDR 50k\n" +
                    "Soft tender 8 hours slow cooked bean seasoned with their to die for homemade bbq sauce with brisket and pulled pork, no wonder it taste so gewwd!\n" +
                    "\n" +
                    "Chicken IDR 165k\n" +
                    "All of the flavor and smoky aroma are infused perfectly in to the perfectly cooked chicken resulting very tender yet juicy chicken breast served with Alabama white sauce. The Alabama sauce was too sour and tangy due to the use of apple cider, I personally love to pair it with BBQ sauce more though.\n\n"+
                    "By the way, ‘Smoke It Up’ menu and special edition bourbon cocktails only available until 31st October, so make sure you try it while it is available. Let’s smoke it up!!\n\n"+
                    "Address:\n" +
                    "Potato Head\n" +
                    "Pacific Place G 51 A\n" +
                    "Jendral Sudirman Kav 52-53\n" +
                    "South Jakarta\n" +
                    "PhoneL (+6221) 57973322\n" +
                    "instagram: @pttheadjakarta\n\n"+
                    "Sumber: http://anakjajan.com/2014/10/16/smoke-it-up-american-barbecue-potato-head/");
        cv.put(KEY_PIC, "american_barbercue");
        db.insert(DATABASE_TABLE, null, cv);

        cv.put(KEY_ID, 8);
        cv.put(KEY_CATEGORI, "2");
        cv.put(KEY_NAME, "BRANCHE BISTRO");
        cv.put(KEY_ADDRESS, "SENOPATI JAKARTA");
        cv.put(KEY_DETAIL, "Another new hangout spot on the Senopati!! Seriously almost every time we went to Senopati we will find a new restaurant or cafe on this street. This time is Branche Bistro, located exactly beside Pipiltin Cocoa Senopati and across the also newly opened Sake+.\n\n"+
                    "Branche is a French Casual Bistro serving Hors D’oeuvre, Soup, Salad, Main Course and Dessert for price range IDR 42k – IDR 225k and for the drink they provide soft drink, mocktail, juice and flavor tea with price range IDR 27,5k to IDR 52k. Food and menu selection are quite limited at this moment due to the soft opening, I think they will slowly add more food and drink selection as time goes by.\n\n"+
                    "Branche’s building consist of 3 floors, first floor with bar area, second floor with a lovely balcony and third floor was not available yet when we visit. Furniture and interior arrangement inside this lovely bistro is handsome if I may say. Combination between dark wooden furniture, metal staircase, metal chandelier, grey-ish cement floor are simple yet intriguing.\n\n"+
                    "When we hangout with our foodie friends, it’s almost impossible to have only one meal, Branche was actually our third stop after having coffee time at WoodPecker and ‘afternoon snack’ at HolyGyu!\n\n"+
                    "Crispy Dory Finger IDR 62k\n" +
                    "Crispy light beer batter on the outside and silky tender dory fish inside, it was delicious especially when you dip it in the garlic aioli dipping sauce, I wish they provide bigger portion for main course.\n\n"+
                    "Branche Beef Burger IDR 95k\n" +
                    "Don’t be deceived by the appearances, it may look appealing and delicious, but it was pure a sad sad and sad burger for me. Dry bread combined with dry and crumbling beef patty, poached egg also could use longer cooking time because the egg yolk was too raw and liquid. The only thing I enjoyed from this dish is the fries.\n\n"+
                    "Crispy Barramundi IDR 110k\n" +
                    "Unique dish with unique combination, savory pan seared barramundi and caramelized mushroom with sweet pineapple pure and mashed sweet potato. Barramundi was perfectly cooked with crispy skin, pineapple puree pineapple puree was a bit similar with pineapple tart/nastar cookie filling.\n\n"+
                    "Overall, AnakJajan enjoyed our time gossiping with our friends at Branche, interior and ambiance was lovely, food was okay, maybe will be back to try another menu. Let’s Jajan!!\n\n"+
                    "Address:\n" +
                    "Branche Bistro\n" +
                    "Senopati No.33\n" +
                    "Kebayoran Baru, South Jakarta\n" +
                    "Phone: (+6221) 5734448\n" +
                    "Opening Hours: starts open from 17.00\n\n"+
                    "Sumber: http://anakjajan.com/2014/08/20/branche-bistro-senopati-jakarta/");
        cv.put(KEY_PIC, "branche_bistro");
        db.insert(DATABASE_TABLE, null, cv);

        cv.put(KEY_ID, 9);
        cv.put(KEY_CATEGORI, "2");
        cv.put(KEY_NAME, "THREE BUNS – BURGER & HEADS");
        cv.put(KEY_ADDRESS, "SENOPATI JAKARTA");
        cv.put(KEY_DETAIL, "It is kinda hard to find a place that sells burger with great quality. That’s why we are so happy knowing there’s a new place at Senopati called Three Buns – Burger & Heads that specialized in burger.\n\n"+
                    "Three Buns Burger and Heads located near Izakaya Issei Senopati with a catchy old vintage blue + white van in front.\n\n"+
                    "The place is quite spacious with semi indoor interior, terraced seating, with lot’s of plants on the wall. The way they decorate this place is really smart and new at Jakarta. Not to mention they also have a really great soulful music playlist giving us chill & relax vibe. But unfortunately during the day, it can be a bit hot and humid.\n\n"+
                    "Enough the talk about the place, now we’ll discuss about the food. Burgers at Three Buns Burger and Heads are claimed to be 100% all-natural burgers using the finest quality meat, bespoke artisan buns & homemade slow cooked sauce. Their burgers patty are freshly ground everyday and cooked medium (unless otherwise requested), you can also request the ‘PROTEIN STYLE’ burger wrapped in lettuce instead of a bun. We met the lovely Anya from Three Buns, she and her partner are in charge in creating amazing drink there,she told us that their sodas are all homamade with natural ingredients and no preservatives.\n\n"+
                    "Price range IDR 95k-125k for burgers, side dish IDR 35k-55k and then for the drinks IDR 25k-115k(water, tea, soda, cocktail, beer, wine per glass). Abit pricey though, but once you taste it, I’m sure you will know that it’s really worth the price.\n\n"+
                    "How to order??\n" +
                    "Go to the van, order and pay it then you will get the queue number.\n" +
                    "Then after that you need to check Queue Board, your order is ready to be picked up when your queue number on the board is on.\n\n"+
                    "Bare Roots Cola IDR 30k\n" +
                    "Secret botanical mix\n" +
                    "Lovely cola drink, very refreshing and it has really nice aroma, not any ordinary cola drink that you can find easily.\n\n"+
                    "Wings-Its IDR 55k\n" +
                    "Crispy, fall off the bone twice cooked chicken wings, hot sauce, scallions & smoky BBQ sauce\n\n"+
                    "Naughty Fries IDR 45k\n" +
                    "Spiced bearnaise, beef chilli, crisp shallots, parmesan\n" +
                    "Me likey!! The fries are really naughty because it’s really good!! Medium size cut fries with generous amount of toppings, abut spicy but quite addicting.\n\n"+
                    "Four Floors IDR 125k\n" +
                    "Double prime 100gr beef patties, double cheese, triple onions, lettuce, pickles, ketchup & den miso\n" +
                    "This one is the most pricey burger there, but also the biggest one because it contain 2 piece of 100gr patties.\n\n"+
                    "Honky-Tonk IDR 100k\n" +
                    "Soya milk fried chicken, coleslaw, lettuce, hot sauce & den miso\n\n"+
                    "The fried chicken is really big and quite thick, not dry but not as juicy as I expected. Overall was quite good with the hot sauce and refreshing sour coleslaw combination.\n\n"+
                    "Baby Huey IDR 95k\n" +
                    "Prime 150g beef patty, cheese, lettuce, ketchup, pickles & spiced mayo\n\n"+
                    "SOO DAMN GOOD!! I cried on the first bite!! Cooked medium, you can clearly taste the damn juicy beef patty. It was well seasoned and the whole combination with cheese, lettuce, ketchup, pickles and spiced mayo are really good without overpowering the sexiness from the beef itself!!\n\n"+
                    "Overall AnakJajan are really happy that finally there’s a great burger place open in Jakarta. The burgers at Three Buns Burger and Heads have a huge portion and taste INCREDIBLY DELICIOUS!! Cannot wait to visit again and try other burgers. Let’s Jajan!!\n\n"+
                    "Address:\n" +
                    "Three Buns – Burger & Heads\n" +
                    "Jl. Senopati Raya No. 90\n" +
                    "Kebayoran Baru, South Jakarta 12190\n" +
                    "Phone: (021) 29307780\n" +
                    "threebuns.com\n" +
                    "Opening Hours: 11.00 am until late\n\n"+
                    "Sumber: http://anakjajan.com/2014/04/19/three-buns-burger-heads-senopati-jakarta/");
        cv.put(KEY_PIC, "three_buns");
        db.insert(DATABASE_TABLE, null, cv);

        cv.put(KEY_ID, 10);
        cv.put(KEY_CATEGORI, "2");
        cv.put(KEY_NAME, "BRUNCH AT UMABO");
        cv.put(KEY_ADDRESS, "Jalan Wijaya 1 No 22, Jakarta Selatan");
        cv.put(KEY_DETAIL, "UMABO , a new opened restaurant at Wijaya, Jakarta selatan. Lokasinya tidaklah susah utk ditemukan karena papan billboard restaurant yang besar, simple yet catchy. Interiornya simple dengan dominasi warna coklat kayu dan abu memberikan suasana yang cozy, belum lagi khusus untuk weekend brunch diputarin lagu-lagu Jazz yang membuat AnakJajan semakin betah berlama-lama disini. Suasana enak, music enak, tentu saja menu makanan pun harus menarik dan enak donk? Let’s talk about the menu.\n\n"+
                    "Basically UMABO berasal dari kata Umami Bowl dengan signature menu Rice Bowl-nya namun tentu saja tidak hanya tersedia makanan yang disajikan dengan mangkok saja, menu seperti burger pun menjadi salah satu andalan disini loh.\n\n"+
                    "Khusus untuk Sabtu dan Minggu tersedia menu Weekend Brunch specially prepared by Chef Fernando Sindu & Ivan Wibowo, pilihan menu Brunch sangat bervarian, berikut beberapa menu yang AnakJajan cobain.\n\n"+
                    "J- Town Burger IDR 65k\n" +
                    "150 gram hamburg patty, short ribs, cheddar cheese, fried egg, shredded Lettuce, breakfast potatoes\n" +
                    "This burger instantly become Mr.Jajan’s favorite burger.\n\n"+
                    "Tidak seperti burger western yang pattynya diracik simple hanya menggunakan salt and pepper, beef patty pada J-Town burger diracik dengan aneka bumbu khas ala Japanese Hamburger, flavorful yet juicy as well. And the chef also geniously add short ribs & perfectly cooked egg giving us an explosion of flavor. Totally will be back for this menu.\n\n"+
                    "Ribs Bene IDR 60k \n" +
                    "Slow poached eggs, braised ribs, garlic spread, toasted sourdough, choron sausce, petite salad \n" +
                    "Nah kalau yang ini favoritnya Mrs. Jajan. Menu-menu brunch or breakfast selalu identik dengan telur, you are a fan of eggs benedict, you should totally try Ribs Bene, poached egg yang perfectly cooked dicombine dengan toast sourdough bread yang crunchy, dan braised ribs yang generous. Seporsi Ribs Bene yang savory semakin sempurna ketika di padukan dengan salad yang abit sweet and sour. I like it so much that I must say this menu is perfectly recommended!\n\n"+
                    "Cornitas IDR 28k \n" +
                    "Crispy corn, pineapple salsa, chili jam, parmesan \n" +
                    "This menu is really unique, jagung goreng kemudian diberi saus yang asam asin manis diluarnya. Cocok buat ngemil – ngemil sambil menunggu menu lain keluar\n\n"+
                    "Breakfast Flatbread IDR 42k \n" +
                    "“Ceplok” egg, crispy smoked beef, charred scallions, cheddar cheese, rose marinara, peperroncino\n" +
                    "This portion is huge, flatbread dengan topping smoked beef, cheddar cheese, telur dan daun bawang yang ditumis wangi dipanggang bersama, walaupun baked surprisingly telurnya masih meleleh loh kuning telurnya.\n\n"+
                    "Churros IDR 25k\n" +
                    "Spanish Curls, Cinnamon sugar, chocolate sauce\n" +
                    "Freshly fried churros yang crunchy outside and empuk didalamnya disajikan dengan saus chocolate yang bittersweet.\n\n"+
                    "Overall we really enjoyed our brunch at Uma-Bo, there’s nothing beats a great brunch to start your great weekend. Let’s Jajan!!\n\n"+
                    "Address :\n" +
                    "UMA – BO\n" +
                    "Jalan Wijaya 1 No 22, Jakarta Selatan\n" +
                    "Phone: (021) 72220\n\n"+
                    "Sumber: http://anakjajan.com/2014/02/21/brunch-at-umabo/");
        cv.put(KEY_PIC, "brunch_at_umabo");
        db.insert(DATABASE_TABLE, null, cv);
	}
	
	//  Array all list Restaurant
	public ArrayList<Restaurant> toArray() {
		return this.toArray("");
	}

	//  Array list Restaurant filter by 'String filterText Name'
	public ArrayList<Restaurant> toArray(String filterText) {
		Cursor cursor = null;
		ArrayList<Restaurant> allContact = null;
		
		String filterQuery = "";
		if( !filterText.equalsIgnoreCase("") ) {
			filterQuery = " WHERE Categori = '" + filterText + "'";
		}

		try {
			allContact = new ArrayList<Restaurant>();

			cursor = database.rawQuery("SELECT * FROM " + DATABASE_TABLE + filterQuery, null);
			if (cursor.getCount() > 0) {
				int indexId       = cursor.getColumnIndex("Id");
                int indexCategori = cursor.getColumnIndex("Categori");
				int indexName     = cursor.getColumnIndex("Name");
				int indexAddress  = cursor.getColumnIndex("Address");
				int indexDetail   = cursor.getColumnIndex("Detail");
				int indexPic      = cursor.getColumnIndex("Pic");
				cursor.moveToFirst();
				do {
					String Pic      = cursor.getString(indexPic);
					String Detail   = cursor.getString(indexDetail);
					String Address  = cursor.getString(indexAddress);
					String Name     = cursor.getString(indexName);
                    String Categori = cursor.getString(indexCategori);
					String Id 	    = cursor.getString(indexId);

					Restaurant contact = new Restaurant();
					contact.setPic(Pic);
					contact.setDetail(Detail);
					contact.setAddress(Address);
					contact.setName(Name);
                    contact.setCategori(Categori);
					contact.setId(Id);

					allContact.add(contact);

					cursor.moveToNext();
				} while (!cursor.isAfterLast());
			}
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
		return allContact;
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	}
	
}