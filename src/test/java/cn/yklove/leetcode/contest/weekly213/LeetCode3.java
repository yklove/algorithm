package cn.yklove.leetcode.contest.weekly213;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author qinggeng
 */
public class LeetCode3 {

    class Solution {

        private int[][][] dp;

        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            dp = new int[ladders + 1][heights.length + 1][bricks + 1];
            return process(heights, bricks, ladders, 0);
        }

        private int process(int[] heights, int bricks, int ladders, int index) {
            if (dp[ladders][index][bricks] != 0) {
                return dp[ladders][index][bricks];
            }
            if (index == heights.length - 1) {
                dp[ladders][index][bricks] = index;
                return index;
            }
            int diff = heights[index] - heights[index + 1];
            if (diff >= 0) {
                int process = process(heights, bricks, ladders, index + 1);
                dp[ladders][index][bricks] = process;
                return process;
            }
            diff = Math.abs(diff);
            if (diff > bricks && ladders == 0) {
                dp[ladders][index][bricks] = index;
                return index;
            }
            int max = Math.max(
                    bricks - diff < 0 ? 0 : process(heights, bricks - diff, ladders, index + 1),
                    ladders - 1 < 0 ? 0 : process(heights, bricks, ladders - 1, index + 1));
            dp[ladders][index][bricks] = max;
            return max;
        }
    }

    class Solution2 {

        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            int[][] dp = new int[ladders + 1][bricks + 1];
            for (int i = 0; i <= ladders; i++) {
                for (int j = 0; j <= bricks; j++) {
                    dp[i][j] = heights.length - 1;
                }
            }
            for (int index = heights.length - 2; index >= 0; index--) {
                int[][] tmpDp = new int[ladders + 1][bricks + 1];
                for (int i = 0; i <= ladders; i++) {
                    for (int j = 0; j <= bricks; j++) {
                        int diff = heights[index] - heights[index + 1];
                        if (diff >= 0) {
                            tmpDp[i][j] = dp[i][j];
                            continue;
                        }
                        diff = Math.abs(diff);
                        if (diff > j && i == 0) {
                            tmpDp[i][j] = index;
                            continue;
                        }
                        tmpDp[i][j] = Math.max(
                                j - diff < 0 ? 0 : dp[i][j - diff],
                                i - 1 < 0 ? 0 : dp[i - 1][j]);
                    }
                }
                dp = tmpDp;
            }
            return dp[ladders][bricks];
        }

    }

    Solution2 solution = new Solution2();

    @Test
    public void test() {
        Assert.assertEquals(4, solution.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
    }

    @Test
    public void test2() {
        Assert.assertEquals(7, solution.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, solution.furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0));
    }

    @Test
    public void test4() {
        Assert.assertEquals(3, solution.furthestBuilding(new int[]{787549, 423744, 251573, 329120, 140748, 321967, 295769, 233135, 679784, 54861, 785130, 263947, 527169, 450212, 422719, 291634, 507945, 324104, 568062, 422319, 273604, 245178, 334136, 100996, 924040, 617522, 607490, 133070, 747528, 575697, 788627, 22863, 919790, 542788, 410138, 297095, 560782, 13067, 150733, 569476, 603080, 291203, 671246, 584255, 316196, 656820, 421984, 942026, 467670, 290696, 906723, 75901, 752669, 833703, 936983, 510116, 871319, 318126, 727334, 680562, 482529, 936626, 319699, 66352, 370013, 522166, 930609, 600396, 850201, 993561, 203577, 96610, 386137, 706898, 694449, 773753, 946723, 35705, 551484, 20995, 242868, 761332, 506857, 265372, 740251, 786023, 302798, 492729, 612461, 458486, 993478, 118073, 388682, 931004, 685872, 264797, 593875, 472316, 678996, 934563, 147143, 701532, 766250, 697361, 346368, 706240, 950981, 82703, 544540, 517167, 492525, 721027, 780472, 916971, 955540, 874843, 634407, 317640, 807485, 284792, 600098, 229258, 901977, 863606, 791853, 923767, 627511, 550079, 560857, 609184, 205747, 511460, 417884, 161583, 833206, 220978, 986701, 716430, 864853, 935285, 238950, 242801, 844546, 938284, 173331, 632277, 855999, 126229, 256009, 813656, 325926, 124140, 843104, 653418, 553719, 963058, 397776, 190641, 363197, 318825, 993144, 17616, 135317, 905492, 110618, 674284, 672074, 839823, 198944, 120096, 343153, 212066, 89046, 667090, 895076, 76046, 756388, 489707, 351592, 920104, 567620, 511409, 239263, 41359, 125366, 269238, 504887, 339539, 440646, 480107, 219003, 951819, 677702, 447751, 626270, 216441, 786568, 358634, 589699, 3150, 882460, 556315, 576381, 101906, 83405, 952098, 450066, 240821, 157297, 380110, 423698, 11077, 890814, 893393, 454278, 145359, 449744, 111901, 957717, 794291, 143844, 835381, 514203, 507583, 748649, 934685, 52997, 741434, 204411, 601228, 564725, 382807, 341849, 901823, 11277, 456456, 413939, 374667, 636321, 44334, 60372, 778236, 835123, 953445, 127236, 735762, 259480, 893723, 135373, 684075, 477836, 119391, 931163, 38043, 411080, 190117, 99645, 134749, 989567, 351063, 945443, 314093, 575572, 186993, 934581, 661119, 313088, 94948, 748752, 163178, 115943, 703726, 904254, 676070, 746385, 316249, 473287, 107273, 504928, 551096, 487860, 339945, 454586, 400207, 818952, 631313, 763681, 459450, 604585, 632133, 250084, 501792, 292332, 177011, 186242, 117948, 300445, 979554, 176269, 148533, 318166, 112906, 751523, 390268, 614764, 183939, 121187, 390607, 94386, 87827, 393556, 183877, 897150, 605754, 992408, 451796, 753945, 745884, 454625, 762988, 217363, 548738, 911375, 820030, 371776, 138616, 753751, 851487, 652981, 774254, 638280, 848007, 570536, 114223, 188819, 803553, 92930, 119628, 281250, 92202, 865450, 546815, 414886, 837563, 331302, 849192, 430472, 794820, 919926, 561852, 998840, 829744, 839017, 916677, 494609, 122381, 755596, 151142, 677900, 635129, 111484, 611132, 851976, 546347, 236081, 844751, 82621, 194381, 335281, 891473, 728406, 415536, 164465, 291738, 334815, 216874, 989465, 144750, 303818, 916121, 389564, 879718, 353448, 162900, 271040, 856291, 458662, 567729, 518552, 137655, 922130, 705053, 320173, 860510, 358745, 206335, 635029, 974726, 428810, 935192, 116449, 302188, 692551, 670048, 876649, 922005, 695964, 480400, 404373, 391575, 931293, 856989, 339380, 801334, 472995, 366961, 369835, 60140, 226641, 981961, 292897, 566660, 629627, 241324, 618125, 605111, 200448, 167008, 43449, 786357, 62891, 577267, 639382, 749006, 965095, 63276, 779801, 821741, 839176, 945102, 322738, 907233, 639470, 549112, 57249, 74474, 645122, 146956, 251621, 543575, 220788, 425873, 225149, 229803, 705690, 521374, 65129, 922062, 87182, 421902, 598483, 274629, 729469, 998132, 499491, 409429, 201030, 228715, 473357, 746141, 408435, 50429, 600276, 56011, 626010, 108018, 900961, 172621, 86622, 244957, 17185, 289908, 158174, 215433, 62174, 707399, 406026, 906747, 191400, 375627, 886827, 882699, 159114, 363455, 798255, 346161, 461264, 658210, 364877, 704482, 928183, 98346, 619018, 646680, 86802, 175124, 560710, 127364, 526577, 582948, 5890, 145782, 814075, 10813, 686385, 857954, 470534, 768693, 189443, 253400, 763529, 482353, 666386, 711976, 436173, 692037, 720238, 886811, 63086, 328440, 713149, 500649, 327395, 890347, 684202, 867534, 300398, 890983, 216477, 16050, 753590, 446976, 342964, 570766, 828451, 130452, 459184, 65051, 689547, 266178, 542899, 137763, 352308, 443007, 449420, 406711, 198840, 963969, 642762, 590403, 279354, 192138, 120955, 264610, 537396, 186453, 357242, 125127, 946378, 379391, 572099, 850335, 979224, 692936, 474831, 645527, 891607, 865683, 943688, 725142, 833708, 239016, 237390, 187603, 87863, 653236, 107130, 628210, 666711, 141892, 808546, 408415, 645256, 411816, 694819, 945380, 68296, 231843, 321479, 691116, 575318, 655590, 703465, 55706, 653900, 890632, 787798, 569442, 278446, 609252, 634917, 150740, 53462, 904020, 52004, 339456, 878965, 241023, 189213, 650791, 727754, 57885, 819214, 638872, 94593, 534598, 783272, 583612, 56397, 93310, 476630, 349829, 551527, 38152, 747390, 998443, 497145, 656557, 730832, 842055, 88213, 482957, 968377, 876036, 518797, 940387, 426094, 491688, 710668, 147787, 435190, 673156, 210260, 178956, 17949, 785203, 790191, 225160, 669729, 568610, 487127, 743444, 305738, 556740, 598781, 191130, 74572, 88876, 34849, 338536, 80276, 159248, 858044, 459478, 334685, 985225, 623925, 937673, 256197, 232470, 737420, 309226, 81818, 188092, 391620, 8569, 970797, 253685, 531087, 152682, 169034, 465697, 478655, 352776, 310642, 603670, 539684, 572299, 113778, 967984, 251288, 488500, 795811, 407621, 288006, 511061, 642911, 669063, 254888, 814636, 670415, 296582, 446118, 998375, 267347, 961145, 103236, 174530, 562716, 489699, 962010, 132896, 208493, 537926, 356985, 344475, 502363, 148391, 123884, 865503, 872075, 211012, 748370, 559596, 332479, 794647, 983633, 769544, 352743, 413726, 124711, 469076, 778902, 296997, 428675, 487963, 550502, 505075, 992831, 203934, 406668, 858030, 768023, 896467, 979598, 305177, 817966, 811448, 862920, 318693, 889238, 667770, 471828, 289091, 676154, 214014, 388903, 672075, 525747, 665449, 461782, 101567, 112899, 812071, 274898, 519463, 623683, 54286, 251936, 393753, 743990, 41141, 182045, 386782, 22357, 247947, 512152, 889376, 750224, 298628, 915653, 630373, 189003, 857960, 241917, 275535, 328324, 146277, 697219, 566164, 521873, 853256, 882889, 108614, 52904, 465997, 425448, 179876, 573958, 217416, 650429, 606678, 281384, 534673, 909316, 870413, 55977, 173768, 766206, 56226, 619536, 476644, 881193, 450924, 525070, 593599, 577461, 239669, 824505, 981917, 493122, 338059, 495429, 161598, 634362, 530034, 699857, 495583, 10437, 65057, 917040, 471880, 941168, 397282, 58440, 925295, 133658, 848229, 529007, 988473, 58761, 703302, 680146, 383893, 172785, 593649, 559720, 183551, 99899, 570815, 640575, 382990, 940179, 198954, 977534, 533770, 243336, 339482, 573473, 796118, 450800, 98604, 566833, 65677, 682960, 895748, 391961, 308757, 64132, 527287, 223958, 95059, 889844, 265483, 423720, 625882, 779118, 340409, 260731, 926376, 167850, 182188, 360492, 609259, 27134, 355206, 893682, 669253, 782915, 425318, 262208, 29429, 917440, 833079, 733718, 367016, 734725, 586547, 288082, 48806, 83801, 48565, 680301, 328562, 314702, 341609, 558542, 43549, 10898, 671452, 390696, 489896, 176093, 546475, 686672, 481693, 238531, 710968, 173589, 845463, 47329, 543458, 432528, 554340, 545878, 377261, 513021, 280427, 776112, 556431, 986310, 118421, 652617, 986077, 988642, 804011, 221594, 579879, 642033, 625409, 652977, 52102, 699189, 607816, 200860, 108534, 155294, 982512, 362739, 850838, 937510, 110414, 416964, 412815, 331569, 101365, 936301, 647785, 861984, 952018, 674050, 166367, 655246, 977339, 451099, 87263, 823103, 252462, 710435, 848126, 496954, 409744, 739484, 74516, 75250, 219726, 288586, 335455, 395778, 992079, 507495, 588612, 512527, 428851, 65797, 964062, 231041, 781741, 804844, 578364, 35027, 371380, 854634, 531603, 554751, 740400, 63095, 179171, 56124, 62346, 518032, 800782, 750239, 957079, 867780, 100810, 877659, 412240, 954339, 552530, 960330, 804074, 353796, 626101, 494472, 205081, 242572, 129267, 971915, 588428, 546143, 902858, 616637, 349445, 692250, 867983, 787650, 782853, 447178, 372562, 127700, 228379, 618550, 17500, 980369, 770023, 14935, 994139, 695838, 868997, 28215, 989391, 620134, 311394, 457494, 812936, 568721, 153739, 121699, 103043, 498699, 915447, 902474, 23076, 91871, 843681, 727894, 471990, 866966, 182274, 818198, 992621, 224897, 309435, 20774, 569242, 510272, 945374, 310335, 52404, 536449, 380443, 827751, 132872, 614805, 339030, 177204, 560263, 984562, 79868, 501269, 891190, 285523, 369346, 750852, 830449, 895622, 87650, 489716, 952786, 801797, 888618, 70074, 277817, 985209, 588999, 136540, 907362, 828553, 509724, 275684, 743572, 631974, 799750, 847596, 169518, 262089, 804122, 673406, 225146, 262308, 918471, 492969, 689427, 435831, 76114, 273191, 814137, 769994, 716027, 353168, 665669, 636558, 487805, 647265, 745869, 532275, 216033, 924613, 572444, 368747, 472840, 571924, 249056, 624336, 182105, 699399, 998709, 956599, 41088, 146813, 934857, 995109, 574515, 550661, 521812, 850495, 345816, 20307, 383325, 878201, 117269, 805157, 539351, 577506, 302988, 397529, 290872, 931054, 129131, 974013, 541445, 69964, 387770, 588621, 198380, 720770, 901959, 492481, 124640, 850981, 59034, 467563, 331371, 381956, 286492, 555325, 190876, 991990, 77151, 367522, 668472, 964834, 39426, 881344, 673511, 179611, 845786, 687550, 177169, 504928, 666900, 443778, 821183, 783409, 37913, 459578, 808139, 592172, 55195, 782158, 160921, 829586, 182637, 589845, 896125, 487803, 413436, 267204, 659905, 872880, 214159, 529374, 807898, 820632, 458673, 508627, 996964, 368551, 499320, 133962, 466304, 247966, 227468, 675013, 887140, 882306, 407948, 20488, 152393, 708589, 448605, 63266}, 987331174, 225));
    }

}
