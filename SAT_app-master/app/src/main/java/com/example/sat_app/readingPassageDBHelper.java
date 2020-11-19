package com.example.sat_app;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sat_app.readingPassageContract.*;

import java.util.ArrayList;
import java.util.List;

public class readingPassageDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "englishPassages.db";
    private static final int DATABASE_VERSION = 39;

    private SQLiteDatabase db;

    public readingPassageDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        this.db = sqLiteDatabase;

        final String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " +
                passageTable.TABLE_NAME + " (" +
                passageTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                passageTable.COLUMN_SYNOPSIS + " TEXT, " +
                passageTable.COLUMN_PASSAGE + " TEXT, " +
                passageTable.COLUMN_IMAGE + " TEXT, " +
                passageTable.COLUMN_SECONDPASSAGE + " TEXT, " +
                passageTable.COLUMN_LINE + " INTEGER, " +
                passageTable.COLUMN_TWOPASSAGELINE + " INTEGER, " +
                passageTable.COLUMN_SYNOPSISPADDING + " INTEGER, " +
                passageTable.COLUMN_ID + " TEXT" +
                ")";
        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        fillPassageTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + passageTable.TABLE_NAME);
        onCreate(db);

    }



    private void fillPassageTable() {

        /*

        readingPassage example = new readingPassage ( //change tag
                "", //Synopsis
                "" , //Passage
                null, //Write null if there is no picture, Write the ID if there is
                null, //Write null if there is no secondPassage, else paste second passage here.
                0, //Last line number displayed
                0, //Only write here if there is two passages Input last number line of first passage
                0, //Exactly how many lines is the synopsis
                "P1RP3"); //Practice 1 Reading Passage 3
        addPassage(example); //corresponding tag

        */

        readingPassage p0 = new readingPassage(
                "This passage is from Lydia Minatoya, The Strangeness of\n" +
                        "Beauty. ©1999 by Lydia Minatoya. The setting is Japan in\n" +
                        "1920. Chie and her daughter Naomi are members of the\n" +
                        "House of Fuji, a noble family.",
                "\t\tAkira came directly, breaking all tradition. Was\n" +
                "that it? Had he followed form—had he asked his\n" +
                "mother to speak to his father to approach a\n" +
                "go-between—would Chie have been more receptive?\n" +
                "\t\tHe came on a winter’s eve. He pounded on the\n" +
                "door while a cold rain beat on the shuttered veranda,\n" +
                "so at first Chie thought him only the wind. The maid\n" +
                "knew better. Chie heard her soft scuttling footsteps,\n" +
                "the creak of the door. Then the maid brought a\n" +
                "calling card to the drawing room, for Chie.\n" +
                "\t\tChie was reluctant to go to her guest; perhaps she\n" +
                "was feeling too cozy. She and Naomi were reading at\n" +
                "a low table set atop a charcoal brazier. A thick quilt\n" +
                "spread over the sides of the table so their legs were\n" +
                "tucked inside with the heat.\n" +
                "\t\t“Who is it at this hour, in this weather?” Chie\n" +
                "questioned as she picked the name card off the\n" +
                "maid’s lacquer tray.\n" +
                "\t\t“Shinoda, Akira. Kobe Dental College,” she read.\n" +
                "\t\tNaomi recognized the name. Chie heard a soft\n" +
                "intake of air.\n" +
                "\t\t“I think you should go,” said Naomi.\n" +
                "\t\tAkira was waiting in the entry. He was in his early\n" +
                "twenties, slim and serious, wearing the black\n" +
                "military-style uniform of a student. As he\n" +
                "bowed—his hands hanging straight down, a\n" +
                "black cap in one, a yellow oil-paper umbrella in the\n" +
                "other—Chie glanced beyond him. In the glistening\n" +
                "surface of the courtyard’s rain-drenched paving\n" +
                "stones, she saw his reflection like a dark double.\n" +
                "\t\t“Madame,” said Akira, “forgive my disruption,\n" +
                "but I come with a matter of urgency.”\n" +
                "\t\tHis voice was soft, refined. He straightened and\n" +
                "stole a deferential peek at her face.\n" +
                "\t\tIn the dim light his eyes shone with sincerity.\n" +
                "Chie felt herself starting to like him.\n" +
                "\t\t“Come inside, get out of this nasty night. Surely\n" +
                "your business can wait for a moment or two.”\n" +
                "\t\t“I don’t want to trouble you. Normally I would\n" +
                "approach you more properly but I’ve received word\n" +
                "of a position. I’ve an opportunity to go to America, as\n" +
                "dentist for Seattle’s Japanese community.”\n" +
                "\t\t“Congratulations,” Chie said with amusement.\n" +
                "“That is an opportunity, I’m sure. But how am I\n" +
                "involved?”\n" +
                "\t\tEven noting Naomi’s breathless reaction to the\n" +
                "name card, Chie had no idea. Akira’s message,\n" +
                "delivered like a formal speech, filled her with\n" +
                "maternal amusement. You know how children speak\n" +
                "so earnestly, so hurriedly, so endearingly about\n" +
                "things that have no importance in an adult’s mind?\n" +
                "That’s how she viewed him, as a child.\n" +
                "\t\tIt was how she viewed Naomi. Even though\n" +
                "Naomi was eighteen and training endlessly in the arts\n" +
                "needed to make a good marriage, Chie had made no\n" +
                "effort to find her a husband.\n" +
                "\t\tAkira blushed.\n" +
                "\t\t“Depending on your response, I may stay in\n" +
                "Japan. I’ve come to ask for Naomi’s hand.”\n" +
                "\t\tSuddenly Chie felt the dampness of the night.\n" +
                "\t\t“Does Naomi know anything of your...\n" +
                "ambitions?”\n" +
                "\t\t“We have an understanding. Please don’t judge\n" +
                "my candidacy by the unseemliness of this proposal. I\n" +
                "ask directly because the use of a go-between takes\n" +
                "much time. Either method comes down to the same\n" +
                "thing: a matter of parental approval. If you give your\n" +
                "consent, I become Naomi’s yoshi.* We’ll live in the\n" +
                "House of Fuji. Without your consent, I must go to\n" +
                "America, to secure a new home for my bride.”\n" +
                "\t\tEager to make his point, he’d been looking her full\n" +
                "in the face. Abruptly, his voice turned gentle. “I see\n" +
                "I’ve startled you. My humble apologies. I’ll take no\n" +
                "more of your evening. My address is on my card. If\n" +
                "you don’t wish to contact me, I’ll reapproach you in\n" +
                "two weeks’ time. Until then, good night.”\n" +
                "\t\tHe bowed and left. Taking her ease, with effortless\n" +
                "grace, like a cat making off with a fish.\n" +
                "\t\t“Mother?” Chie heard Naomi’s low voice and\n" +
                "turned from the door. “He has asked you?”\n" +
                "\t\tThe sight of Naomi’s clear eyes, her dark brows\n" +
                "gave Chie strength. Maybe his hopes were\n" +
                "preposterous.\n" +
                "\t\t“Where did you meet such a fellow? Imagine! He\n" +
                "thinks he can marry the Fuji heir and take her to\n" +
                "America all in the snap of his fingers!”\n" +
                "\t\tChie waited for Naomi’s ripe laughter.\n" +
                "\t\tNaomi was silent. She stood a full half minute\n" +
                "looking straight into Chie’s eyes. Finally, she spoke.\n" +
                "“I met him at my literary meeting.”\n" +
                "\t\tNaomi turned to go back into the house, then\n" +
                "stopped.\n" +
                "\t\t“Mother.”\n" +
                "\t\t“Yes?”\n" +
                "\t\t“I mean to have him.”\n" +
                "* a man who marries a woman of higher status and takes her " +
                "family’s name",
                null,
                null,
                95,
                0,
                4,
                "P1RP1");
        addPassage(p0);
        readingPassage p1 = new readingPassage(
                "This passage is adapted from Francis J. Flynn and Gabrielle " +
                        "S. Adams, \"Money Can't Buy Love: Asymmetric Beliefs about " +
                        "Gift Price and Feelings of Appreciation.\" ©2008 by Elsevier " +
                        "Inc.",
                "\t\tEvery day, millions of shoppers hit the stores in\n" +
                        "full force—both online and on foot—searching\n" +
                        "frantically for the perfect gift. Last year, Americans\n" +
                        "spent over $30 billion at retail stores in the month of\n" +
                        "December alone. Aside from purchasing holiday\n" +
                        "gifts, most people regularly buy presents for other\n" +
                        "occasions throughout the year, including weddings,\n" +
                        "birthdays, anniversaries, graduations, and baby\n" +
                        "showers. This frequent experience of gift-giving can\n" +
                        "engender ambivalent feelings in gift-givers. Many\n" +
                        "relish the opportunity to buy presents because\n" +
                        "gift-giving offers a powerful means to build stronger\n" +
                        "bonds with one’s closest peers. At the same time,\n" +
                        "many dread the thought of buying gifts; they worry\n" +
                        "that their purchases will disappoint rather than\n" +
                        "delight the intended recipients.\n" +
                        "\t\tAnthropologists describe gift-giving as a positive\n" +
                        "social process, serving various political, religious, and\n" +
                        "psychological functions. Economists, however, offer\n" +
                        "a less favorable view. According to Waldfogel (1993),\n" +
                        "gift-giving represents an objective waste of resources.\n" +
                        "People buy gifts that recipients would not choose to\n" +
                        "buy on their own, or at least not spend as much\n" +
                        "money to purchase (a phenomenon referred to as\n" +
                        "‘‘the deadweight loss of Christmas”). To wit, givers\n" +
                        "are likely to spend $100 to purchase a gift that\n" +
                        "receivers would spend only $80 to buy themselves.\n" +
                        "This ‘‘deadweight loss” suggests that gift-givers are\n" +
                        "not very good at predicting what gifts others will\n" +
                        "appreciate. That in itself is not surprising to social\n" +
                        "psychologists. Research has found that people often\n" +
                        "struggle to take account of others’ perspectives—\n" +
                        "their insights are subject to egocentrism, social\n" +
                        "projection, and multiple attribution errors.\n" +
                        "\t\tWhat is surprising is that gift-givers have\n" +
                        "considerable experience acting as both gift-givers and\n" +
                        "gift-recipients, but nevertheless tend to overspend\n" +
                        "each time they set out to purchase a meaningful gift.\n" +
                        "In the present research, we propose a unique\n" +
                        "psychological explanation for this overspending\n" +
                        "problem—i.e., that gift-givers equate how much they\n" +
                        "spend with how much recipients will appreciate the\n" +
                        "gift (the more expensive the gift, the stronger a\n" +
                        "gift-recipient’s feelings of appreciation). Although a\n" +
                        "link between gift price and feelings of appreciation\n" +
                        "might seem intuitive to gift-givers, such an\n" +
                        "assumption may be unfounded. Indeed, we propose\n" +
                        "that gift-recipients will be less inclined to base their\n" +
                        "feelings of appreciation on the magnitude of a gift\n" +
                        "than givers assume.\n" +
                        "\t\tWhy do gift-givers assume that gift price is closely\n" +
                        "linked to gift-recipients’ feelings of appreciation?\n" +
                        "Perhaps givers believe that bigger (i.e., more\n" +
                        "expensive) gifts convey stronger signals of\n" +
                        "thoughtfulness and consideration. According to\n" +
                        "Camerer (1988) and others, gift-giving represents a\n" +
                        "symbolic ritual, whereby gift-givers attempt to signal\n" +
                        "their positive attitudes toward the intended recipient\n" +
                        "and their willingness to invest resources in a future\n" +
                        "relationship. In this sense, gift-givers may be\n" +
                        "motivated to spend more money on a gift in order to\n" +
                        "send a “stronger signal” to their intended recipient.\n" +
                        "As for gift-recipients, they may not construe smaller\n" +
                        "and larger gifts as representing smaller and larger\n" +
                        "signals of thoughtfulness and consideration.\n" +
                        "\t\tThe notion of gift-givers and gift-recipients being\n" +
                        "unable to account for the other party’s perspective\n" +
                        "seems puzzling because people slip in and out of\n" +
                        "these roles every day, and, in some cases, multiple\n" +
                        "times in the course of the same day. Yet, despite the\n" +
                        "extensive experience that people have as both givers\n" +
                        "and receivers, they often struggle to transfer\n" +
                        "information gained from one role (e.g., as a giver)\n" +
                        "and apply it in another, complementary role (e.g., as\n" +
                        "a receiver). In theoretical terms, people fail to utilize\n" +
                        "information about their own preferences and\n" +
                        "experiences in order to produce more efficient\n" +
                        "outcomes in their exchange relations. In practical\n" +
                        "terms, people spend hundreds of dollars each year on\n" +
                        "gifts, but somehow never learn to calibrate their gift\n" +
                        "expenditures according to personal insight." ,
                "readingpassagegraphp1rp2",
                null,
                80,
                0,
                4,
                "P1RP2");
        addPassage(p1);
        readingPassage p2 = new readingPassage(
                "Passage 1 is adapted from Michael Slezak, “Space Mining:\n" +
                        "the Next Gold Rush?” ©2013 by New Scientist. Passage 2 is\n" +
                        "from the editors of New Scientist, “Taming the Final\n" +
                        "Frontier.” ©2013 by New Scientist.",
                "\t\tFollow the money and you will end up in space.\n" +
                        "That’s the message from a first-of-its-kind forum on\n" +
                        "mining beyond Earth.\n" +
                        "\t\tConvened in Sydney by the Australian Centre for\n" +
                        "Space Engineering Research, the event brought\n" +
                        "together mining companies, robotics experts, lunar\n" +
                        "scientists, and government agencies that are all\n" +
                        "working to make space mining a reality.\n" +
                        "\t\tThe forum comes hot on the heels of the\n" +
                        "2012 unveiling of two private asteroid-mining firms.\n" +
                        "Planetary Resources of Washington says it will\n" +
                        "launch its first prospecting telescopes in two years,\n" +
                        "while Deep Space Industries of Virginia hopes to be\n" +
                        "harvesting metals from asteroids by 2020. Another\n" +
                        "commercial venture that sprung up in 2012,\n" +
                        "Golden Spike of Colorado, will be offering trips to\n" +
                        "the moon, including to potential lunar miners.\n" +
                        "\t\tWithin a few decades, these firms may be\n" +
                        "meeting earthly demands for precious metals, such as\n" +
                        "platinum and gold, and the rare earth elements vital\n" +
                        "for personal electronics, such as yttrium and\n" +
                        "lanthanum. But like the gold rush pioneers who\n" +
                        "transformed the western United States, the first space\n" +
                        "miners won’t just enrich themselves. They also hope\n" +
                        "to build an off-planet economy free of any bonds\n" +
                        "with Earth, in which the materials extracted and\n" +
                        "processed from the moon and asteroids are delivered\n" +
                        "for space-based projects.\n" +
                        "\t\tIn this scenario, water mined from other\n" +
                        "worlds could become the most desired commodity.\n" +
                        "“In the desert, what’s worth more: a kilogram of gold\n" +
                        "or a kilogram of water?” asks Kris Zacny of\n" +
                        "HoneyBee Robotics in New York. “Gold is useless.\n" +
                        "Water will let you live.”\n" +
                        "\t\tWater ice from the moon’s poles could be sent to\n" +
                        "astronauts on the International Space Station for\n" +
                        "drinking or as a radiation shield. Splitting water into\n" +
                        "oxygen and hydrogen makes spacecraft fuel, so\n" +
                        "ice-rich asteroids could become interplanetary\n" +
                        "refuelling stations.\n" +
                        "\t\tCompanies are eyeing the iron, silicon, and\n" +
                        "aluminium in lunar soil and asteroids, which could\n" +
                        "be used in 3D printers to make spare parts or\n" +
                        "machinery. Others want to turn space dirt into\n" +
                        "concrete for landing pads, shelters, and roads." ,
                null,
                "\t\tThe motivation for deep-space travel is shifting\n" +
                        "from discovery to economics. The past year has seen\n" +
                        "a flurry of proposals aimed at bringing celestial riches\n" +
                        "down to Earth. No doubt this will make a few\n" +
                        "billionaires even wealthier, but we all stand to gain:\n" +
                        "the mineral bounty and spin-off technologies could\n" +
                        "enrich us all.\n" +
                        "\t\tBut before the miners start firing up their rockets,\n" +
                        "we should pause for thought. At first glance, space\n" +
                        "mining seems to sidestep most environmental\n" +
                        "concerns: there is (probably!) no life on asteroids,\n" +
                        "and thus no habitats to trash. But its consequences\n" +
                        "—both here on Earth and in space—merit careful\n" +
                        "consideration.\n" +
                        "\t\tPart of this is about principles. Some will argue\n" +
                        "that space’s “magnificent desolation” is not ours to\n" +
                        "despoil, just as they argue that our own planet’s poles\n" +
                        "should remain pristine. Others will suggest that\n" +
                        "glutting ourselves on space’s riches is not an\n" +
                        "acceptable alternative to developing more sustainable\n" +
                        "ways of earthly life.\n" +
                        "\t\tHistory suggests that those will be hard lines to\n" +
                        "hold, and it may be difficult to persuade the public\n" +
                        "that such barren environments are worth preserving.\n" +
                        "After all, they exist in vast abundance, and even\n" +
                        "fewer people will experience them than have walked\n" +
                        "through Antarctica’s icy landscapes.\n" +
                        "\t\tThere’s also the emerging off-world economy to\n" +
                        "consider. The resources that are valuable in orbit and\n" +
                        "beyond may be very different to those we prize on\n" +
                        "Earth. Questions of their stewardship have barely\n" +
                        "been broached—and the relevant legal and regulatory\n" +
                        "framework is fragmentary, to put it mildly.\n" +
                        "\t\tSpace miners, like their earthly counterparts, are\n" +
                        "often reluctant to engage with such questions.\n" +
                        "One speaker at last week’s space-mining forum in\n" +
                        "Sydney, Australia, concluded with a plea that\n" +
                        "regulation should be avoided. But miners have much\n" +
                        "to gain from a broad agreement on the for-profit\n" +
                        "exploitation of space. Without consensus, claims will\n" +
                        "be disputed, investments risky, and the gains made\n" +
                        "insecure. It is in all of our long-term interests to seek\n" +
                        "one out.",
                85,
                45,
                4,
                "P1RP3");
        addPassage(p2);













        /*
        * All of the grammar passages go here
        *
        * */

        readingPassage P1GP1 = new readingPassage (
                null,
                "|Whey to Go|\n" +
                        "\t\t Greek yogurt—a strained form of cultured\n" +
                        "yogurt—has grown enormously in popularity in the\n" +
                        "United States since it was first introduced in the country\n" +
                        "in the late 1980s.\n" +
                        "\t\t From 2011 to 2012 alone, sales of Greek yogurt in the\n" +
                        "US increased by 50 percent. The resulting increase in\n" +
                        "Greek yogurt production has forced those involved in the\n" +
                        "business to address the detrimental effects that the\n" +
                        "yogurt-making process may be having on the\n" +
                        "environment. Fortunately, farmers and others in the\n" +
                        "Greek yogurt business have found many methods of\n" +
                        "controlling and eliminating most environmental threats.\n" +
                        "Given these solutions as well as the many health benefits\n" +
                        "of the food, the advantages of Greek yogurt }1}_outdo_the\n" +
                        "potential drawbacks of its production.\n" +
                        "\t\t [1] The main environmental problem caused by the\n" +
                        "production of Greek yogurt is the creation of acid whey\n" +
                        "as a by-product. [2] Because it requires up to four times\n" +
                        "more milk to make than conventional yogurt does, Greek\n" +
                        "yogurt produces larger amounts of acid whey, which is\n" +
                        "difficult to dispose of. [3] To address the problem of\n" +
                        "disposal, farmers have found a number of uses for acid\n" +
                        "whey. [4] They can add it to livestock feed as a protein\n" +
                        "}2}_supplement, and people can make their own\n" +
                        "Greek-style yogurt at home by straining regular yogurt._\n" +
                        "[5] If it is improperly introduced into the environment,\n" +
                        "acid-whey runoff }3}_can pollute waterways,_depleting\n" +
                        "the oxygen content of streams and rivers as it\n" +
                        "decomposes. [6] Yogurt manufacturers, food\n" +
                        "}4}_scientists; and_government officials are also\n" +
                        "working together to develop additional solutions for \n" +
                        "reusing whey.}5}\n" +

                        "\t\t }6}_Though these conservation methods can be\n" +
                        "costly and time-consuming, they are well worth the\n" +
                        "effort._Nutritionists consider Greek yogurt to be a healthy\n" +
                        "food: it is an excellent source of calcium and protein,\n" +
                        "serves }7}_to be_a digestive aid, and }8}_it contains_few\n" +
                        "calories in its unsweetened low- and non-fat forms.\n" +
                        "Greek yogurt is slightly lower in sugar and carbohydrates\n" +
                        "than conventional yogurt is. }9}_Also,_because it is more\n" +
                        "concentrated, Greek yogurt contains slightly more\n" +
                        "protein per serving, thereby helping people stay\n" +
                        "\t\t }6}_satiated_for longer periods of time. These health\n" +
                        "benefits have prompted Greek yogurt’s recent surge in\n" +
                        "popularity. In fact, Greek yogurt can be found in an\n" +
                        "increasing number of products such as snack food and\n" +
                        "frozen desserts. Because consumers reap the nutritional\n" +
                        "benefits of Greek yogurt and support those who make\n" +
                        "and sell }11}_it, therefore farmers_and businesses should\n" +
                        "continue finding safe and effective methods of producing\n" +
                        "the food.",
                null,
                null,
                0,
                0,
                0,
                "P1GP1");
        addPassage(P1GP1);
        readingPassage P1GP2 = new readingPassage (
                null,
                "|Dark Snow|\n" +
                        "\t\tMost of Greenland’s interior is covered by a thick\n" +
                        "layer of ice and compressed snow known as the\n" +
                        "Greenland Ice Sheet. The size of the ice sheet fluctuates\n" +
                        "seasonally: in summer, average daily high temperatures\n" +
                        "in Greenland can rise to slightly above 50 degrees\n" +
                        "Fahrenheit, partially melting the ice; in the winter, the\n" +
                        "sheet thickens as additional snow falls, and average daily\n" +
                        "low temperatures can drop }12}_to as low as 20 degrees._\n" +

                        "\t\tTypically, the ice sheet begins to show evidence of\n" +
                        "thawing in late }13}_summer. This follows_several weeks of\n" +
                        "higher temperatures. }14}_For example,_in the summer of\n" +
                        "2012, virtually the entire Greenland Ice Sheet underwent\n" +
                        "thawing at or near its surface by mid-July, the earliest\n" +
                        "date on record. Most scientists looking for the causes of\n" +
                        "the Great Melt of 2012 have focused exclusively on rising\n" +
                        "temperatures. The summer of 2012 was the warmest in\n" +
                        "170 years, records show. But Jason }15}_Box, an associate\n" +
                        "professor of geology at Ohio State_believes that another\n" +
                        "factor added to the early }16}_thaw;_the “dark snow”\n" +
                        "problem.\n" +

                        "\t\tAccording to Box, a leading Greenland expert,\n" +
                        "tundra fires in 2012 from as far away as North America\n" +
                        "produced great amounts of soot, some }17}_of it_drifted\n" +
                        "over Greenland in giant plumes of smoke and then\n" +
                        "}18}_fell_as particles onto the ice sheet. Scientists have long\n" +
                        "known that soot particles facilitate melting by darkening\n" +
                        "snow and ice, limiting }19}_it’s_ability to reflect the Sun’s\n" +
                        "rays. As Box explains, “Soot is an extremely powerful\n" +
                        "light absorber. It settles over the ice and captures the\n" +
                        "Sun’s heat.” The result is a self-reinforcing cycle. As the\n" +
                        "ice melts, the land and water under the ice become\n" +
                        "exposed, and since land and water are darker than snow,\n" +
                        "the surface absorbs even more heat, which }20}_is related\n" +
                        "to the rising temperatures._\n" +

                        "\t\t[1] Box’s research is important because the fires of\n" +
                        "2012 may not be a one-time phenomenon. [2] According\n" +
                        "to scientists, rising Arctic temperatures are making\n" +
                        "northern latitudes greener and thus more fire prone.\n" +
                        "[3] The pattern Box observed in 2012 may repeat\n" +
                        "}21}_itself again,_with harmful effects on the Arctic\n" +
                        "ecosystem. [4] Box is currently organizing an expedition\n" +
                        "to gather this crucial information. [5] The next step for\n" +
                        "Box and his team is to travel to Greenland to perform\n" +
                        "direct sampling of the ice in order to determine just how\n" +
                        "much the soot is contributing to the melting of the ice\n" +
                        "sheet. [6] Members of the public will be able to track his\n" +
                        "team’s progress—and even help fund the\n" +
                        "expedition—through a website Box has created. }22}",
                null,
                null,
                0,
                0,
                0,
                "P1GP2");
        addPassage(P1GP2);

    }

    private void addPassage(readingPassage readingPassage) {
        ContentValues cv = new ContentValues();
        cv.put(passageTable.COLUMN_SYNOPSIS, readingPassage.getSynopsis());
        cv.put(passageTable.COLUMN_PASSAGE, readingPassage.getPassage());
        cv.put(passageTable.COLUMN_IMAGE, readingPassage.getImage());
        cv.put(passageTable.COLUMN_SECONDPASSAGE, readingPassage.getSecondPassage());
        cv.put(passageTable.COLUMN_LINE, readingPassage.getLines());
        cv.put(passageTable.COLUMN_TWOPASSAGELINE, readingPassage.getTwoPassageLine());
        cv.put(passageTable.COLUMN_ID, readingPassage.getId());
        db.insert(passageTable.TABLE_NAME, null, cv);
    }

    public List<readingPassage> getAllPassages() {
        List<readingPassage> readingPassageList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + passageTable.TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                readingPassage readingPassage = new readingPassage();
                readingPassage.setSynopsis(c.getString(c.getColumnIndex(passageTable.COLUMN_SYNOPSIS)));
                readingPassage.setPassage(c.getString(c.getColumnIndex(passageTable.COLUMN_PASSAGE)));
                readingPassage.setImage(c.getString(c.getColumnIndex(passageTable.COLUMN_IMAGE)));
                readingPassage.setSecondPassage(c.getString(c.getColumnIndex(passageTable.COLUMN_SECONDPASSAGE)));
                readingPassage.setLines(c.getInt(c.getColumnIndex(passageTable.COLUMN_LINE)));
                readingPassage.setTwoPassageLine(c.getInt(c.getColumnIndex(passageTable.COLUMN_TWOPASSAGELINE)));
                readingPassage.setSynopsisPadding(c.getColumnIndex(passageTable.COLUMN_SYNOPSISPADDING));
                readingPassage.setId(c.getString(c.getColumnIndex(passageTable.COLUMN_ID)));
                readingPassageList.add(readingPassage);

            } while (c.moveToNext());
        }
        c.close();
        return readingPassageList;
    }
}
