package cn.yklove.leetcode.contest.weekly275;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author beamjl
 */
public class LeetCode3 {

    static class Solution {

        static int[] ints = new int[26];

        static {
            ints[0] = 1;
            ints[1] = 2;
            ints[2] = 4;
            ints[3] = 8;
            ints[4] = 16;
            ints[5] = 32;
            ints[6] = 64;
            ints[7] = 128;
            ints[8] = 256;
            ints[9] = 512;
            ints[10] = 1024;
            ints[11] = 2048;
            ints[12] = 4096;
            ints[13] = 8192;
            ints[14] = 16384;
            ints[15] = 32768;
            ints[16] = 65536;
            ints[17] = 131072;
            ints[18] = 262144;
            ints[19] = 524288;
            ints[20] = 1048576;
            ints[21] = 2097152;
            ints[22] = 4194304;
            ints[23] = 8388608;
            ints[24] = 16777216;
            ints[25] = 33554432;
        }

        public int wordCount(String[] startWords, String[] targetWords) {

            int ans = 0;
            Map<Integer, List<String>> mapA = new HashMap<>();
            Map<Integer, List<String>> mapB = new HashMap<>();
            for (String startWord : startWords) {
                List<String> list = mapA.get(startWord.length());
                if (Objects.nonNull(list)) {

                    list.add(startWord);
                } else {
                    list = new ArrayList<>();
                    list.add(startWord);
                    mapA.put(startWord.length(), list);
                }
            }
            for (String targetWord : targetWords) {
                List<String> list = mapB.get(targetWord.length());
                if (Objects.nonNull(list)) {
                    list.add(targetWord);
                } else {
                    list = new ArrayList<>();
                    list.add(targetWord);
                    mapB.put(targetWord.length(), list);
                }
            }
            for (Map.Entry<Integer, List<String>> entry : mapB.entrySet()) {
                Integer key = entry.getKey();
                if (mapA.containsKey(key - 1)) {
                    ans += count2(mapA.get(key - 1), entry.getValue());
                }
            }
            return ans;
        }

        private int count2(List<String> startWords, List<String> targetWords) {
            int ans = 0;
            for (String targetWord : targetWords) {
                int target2 = 0;
                for (char c : targetWord.toCharArray()) {
                    target2 = target2 | ints[c - 'a'];
                }
                for (String startWord : startWords) {
                    int startWord2 = 0;
                    for (char c : startWord.toCharArray()) {
                        startWord2 = startWord2 | ints[c - 'a'];
                    }
                    int i = startWord2 ^ target2;
                    if ((i & (i - 1)) == 0) {
                        ans++;
                        break;
                    }
                }
            }
            return ans;
        }
    }

    Solution solution = new Solution();

    @Test
    public void test() {
        Assert.assertEquals(1, solution.wordCount(new String[]{"ab", "a"}, new String[]{"abc", "abcd"}));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, solution.wordCount(new String[]{"tqnu", "jld", "gnb", "bux", "qut"}, new String[]{"mtqnu", "n", "l", "jauw", "ubh", "qutn", "cqkbs", "nkrog", "bhl", "qjld"}));
    }

    @Test
    public void test3() {
        Assert.assertEquals(254, solution.wordCount(new String[]{"mgxfkirslbh", "wpmsq", "pxfouenr", "lnq", "vcomefldanb", "gdsjz", "xortwlsgevidjpc", "kynjtdlpg", "hmofavtbgykidw", "bsefprtwxuamjih", "yvuxreobngjp", "ihbywqkteusjxl", "ugh", "auydixmtogrkve", "ox", "wvknsj", "pyekgfcab", "zsunrh", "ecrpmxuw", "mtvpdgwr", "kpbmwlxgus", "ob", "gfhqz", "qvjkgtxecdoafpi", "rnufgtom", "vijqecrny", "lkgtqcxbrfhay", "eq", "mbhf", "iv", "bzevwoxrnjp", "wgusokd", "cnkexvsquwlgbfp", "zebrwf", "gdxleczutofajir", "x", "mtraowpeschbkxi", "daickygrp", "p", "xjlwcbapyszdtv", "hgab", "nlgf", "z", "mt", "oumqabs", "alf", "whfruolazjdcb", "tf", "dxngwmft", "ibuvnosrqdgjyp", "hftpg", "jcnah", "recavwlgfxiuk", "stjuiedvlfwbhpq", "dqakvgfrc", "nzqtouwbism", "dwymhgcsx", "zvqr", "c", "hevgr", "jbsvmrtcnow", "fptlcxg", "wsiqcgnlfxb", "zapnjquycdsxvi", "lcvabg", "hpuzsbgqkeixwr", "ornd", "eqgukchjnwids", "ysxbhdzpvgcew", "ji", "ozna", "be", "muhikqnd", "axlhyftvrpkucs", "aedofvlhzqmxrt", "g", "leifus", "i", "qlgcrxsdnmytb", "t", "fbhlgrvozsyxajt", "puyqhksclinob", "vfbpcedhn", "nqism", "zi", "qgb", "qweg", "sh", "qmbunh", "sp", "cainjebqmvyslo", "hya", "ifyrxkgemqc", "hmcrgabdlqkfs", "o", "abikmjqpr", "hbzedog", "yxijqknhl", "g", "jhbav", "n", "bvglmordite", "r", "ulmkqdwytxipvao", "ngfkuvxatzqryl", "wzmxuiyj", "jguv", "vzgmelrnjpsoa", "lgndsxvuiq", "cflwyxbezdgsqj", "tiqznalvrdepws", "znofuykwilps", "srquzgomnlkcb", "fuktdpbinwl", "bevucxl", "zgxahrynjqfsmu", "digtkmachbrxven", "zlkpqatvibr", "awdilqtmbrvceg", "oswhbncfx", "ruzqfvtjphg", "x", "i", "cydkbxnl", "zprdiwholgm", "bheaiprnvodm", "ftihvlsjayw", "agdub", "v", "ahlqydvnkgeju", "jkv", "bepnzdw", "ogjuhltpnmaire", "gojxtmraiqz", "sfhv", "pgmjzehnfxrbk", "msat", "aodegjbmt", "n", "fpanl", "ghylfn", "vzxysgwncmeb", "onyeabqimcrtwp", "dvcbqueixzfwgo", "lafgbztpmdnyws", "ydaixthclnjgkq", "mgyajwfieus", "jinvoyud", "xrb", "g", "ceivybxtljdzu", "ijrqzdegpxs", "gjw", "kczrpqbtwjulamv", "alrvb", "usftxanbdw", "hitvrca", "aybtr", "kbxpwivucnley", "tv", "lgpbaytvjdfeowx", "igmkqlnedjaxsc", "qlvwszxhbrfe", "bofcmzyvsg", "gc", "zojkdvixfbant", "cstlvhpkfrdwney", "nblsowtza", "zjqthpwfbgsae", "xqrvdfusnhcbwlj", "lmsgtn", "dvwyxbch", "jagbesnvwhkfxoc", "rs", "ocyph", "rgmfyvwbekxad", "ynov", "w", "xlizrsf", "lctpaxqizb", "tmovsbjxqeh", "aqcoslvfmkg", "odpqkzlrxh", "osyfzjwbthpamue", "atihkjxbcmdfu", "ocrjlfnug", "psjwqyeibu", "fgkjnmpc", "bkljzrc", "rfgwkp", "kygcnhdu", "zjmwei", "lctvhjrngafo", "ouvgm", "kmcrx", "y", "r", "anri", "gtlrnepusmjbwh", "rketigxb", "zompxictdrqhy", "nbcavygtpldwmsr", "fdjbo", "dokmrypczgnf", "gjidtncwouer", "gdclb", "pbehgj", "rmzgxscqolnh", "pgwyiu", "rozvjcekpgudl", "ngzjyotwepavc", "rexjomgdfblsu", "ihjsz", "uy", "ivmx", "fmewhrgsxj", "ftdbcxpaglunhj", "yxnatjghfbzd", "rnqbmdhtwzgpsoi", "kabsdq", "aifosqdtmlxprjy", "vzcnmyfu", "zcogsdvrpy", "maorzpfqus", "jmxrhfgtepqoz", "srkoghcuvewxfdz", "jvrfdtgihb", "ndg", "kxtqhg", "ftdlihv", "gklsuycht", "yxcv", "axsydfeg", "ayostk", "fhrwkb", "ezxauvsjfodit", "gdzxkbcowtyrnqp", "lxjraocfhi", "idge", "afptqjcvd", "rpdagkqows", "uvjregzl", "vaeknyjci", "ztuavj", "qtodpfaxslmc", "hxamecynpdq", "nlzwr", "owbzkhcqlnyd", "axsioeklpbcuyq", "xpczv", "aruicpsw", "ebolyfqshp", "tuyjgbqxkcnav", "mcnyewxfvsi", "izb", "w", "ybrfj", "yrpchjik", "erljaoiyfxpkght", "swjgimbzaqc", "aiq", "nstwhcabkd", "pyrnahv", "ckezagrnw", "bqrxjysckmzife", "cqeslp", "bpcxfwy", "z", "eqypbakhzsdj", "dijepvmtohsbg", "tokfxvnzrsl", "vnamdoblrqwfx", "udfmzj", "txornzeiykw", "qzgjeidfybavhpc", "bcnasehw", "doqlptju", "uciwskjzfpdtlr", "orcayhmvgzx", "wvyq", "uixyfapoznleb", "zsawrfun", "ifjcovxalpmbryk", "cdvajtmnyr", "d", "vyu", "vwcknlphbite", "xarzstglin", "adm", "ifpkuzhs", "hlfrkscuzimb", "kliwz", "trcqxlmy", "gidhkfcvmzab", "cjxyoszh", "bhunojsazwfxvi", "l", "mwqfzlsguaeoi", "fqdomyght", "j", "swtqiovuaphm", "unyjg", "ieyxp", "aolfrbg", "pyovktzmrjuie", "uew", "l", "npwisxm", "a", "rkexvymhaof", "yuipgq", "qzvnsx", "bwatpdu", "vthizgue", "eh", "oxubpyaqjmfsd", "zxlsftu", "dusl", "rpdsmljtcoaqveg", "jfgnilepzhc", "nz", "wftpvsijg", "larx", "ylv", "drptekxzainhybo", "kamdovjbsnizq", "igoaprsznvjfkwb", "jt", "gcpfi", "ihvkomuc", "qnbgcdxviwulke", "cxuhyvdkesprq", "lixvrwskot", "wngphsjztvx", "wv", "rcbsphoqijdtmv", "nhprx", "a", "m", "wctzuk", "fingedrwyjsbl", "kbyqad", "xtgbyqovckn", "xr", "ygaenxqc", "dnibrxzohft", "jy", "fbyxqadrewshu", "rvfcdtgmkypwai", "wr", "csotefgijw", "rabphzvwcndqil", "zk", "zwycqvaiubers", "pty", "qrgtk", "kagdqfo", "efharqwngoicds", "tmgyub", "fln", "paqesokun", "nilutckzejqxgdv", "xtuzogl", "htfzpqywla", "wsmo", "glbfvmjzs", "brsc", "ojcqrn", "yqsncexfjumzgo", "sunqiwjhvbtxokm", "hw", "gy", "m", "wfli", "eqazhgjvfydtusr", "bu", "lwu", "mnpobr", "xtv", "aysfkui", "vwmjgknbxheu", "ktabp", "yqjpfxwen", "podsig", "erqdbxgckiwlht", "emdbpfvzl", "gauhjcvxrtmd", "eykrotbig", "qfhwydcn", "njgtvwmzlk", "n", "urtnipf", "c", "ptdwigz", "qgvutfsrxp", "mczxv", "whayfszc", "wqcaskzb", "ox", "ngqpswbhd", "tabc", "lwtf", "lbukxpzacyevw", "tvsjzbaqohgwke", "qspcakoudj", "mho", "jdw", "situxhcgfnq", "vhopwt", "yqk", "pblx", "haxbyjvinrq", "gbiehqudwprjn", "hlg"},
                new String[]{"nsewcbujhad", "aeb", "phvbaeinctkwl", "cybwlsuzinvk", "qwhxytpvefrjz", "gvy", "ixcalbqfz", "igftodzvcnswjlm", "thbdfgivurj", "nbd", "dgqolunivxs", "bcsovemfldan", "unhzrsd", "skwlendhyucapzi", "zyrmohljp", "qum", "btmzgfqaspwjeh", "jgkmzqoyvtw", "tlgrawcxkn", "qdwogyrfs", "gephoxvsdj", "dfvxywjknm", "wru", "jnumkcfydo", "ewhbxfqgkclsj", "lz", "ghxopqbey", "xc", "jiznkxvcues", "uykrcxaofhm", "vmqdipal", "zjkmbqxtyefsicr", "fiawpvldc", "h", "dompynwi", "zbkynwmcxgves", "mxi", "ranoytupxb", "pyaqedhvzgjcbifl", "fy", "nrobdxvspqyjgui", "snrm", "gfyknowupqrta", "wivmt", "qtxyhcblrakfdg", "vfczbhtoa", "reho", "o", "rzn", "rabsgdfxij", "gpyhft", "jiv", "ufqji", "xe", "pnifxjhmtosa", "j", "vzodg", "cthzjspulafxiwb", "ohbmuqn", "rdliztsjukcwfpv", "saoqpd", "pxu", "kxnguybvejfwo", "fukagtlbndmpry", "sqlpaytnvhkrmo", "pm", "umco", "imjqrd", "riq", "vywxz", "npiu", "rvzjq", "qso", "epkloxmr", "racvl", "znkcwbg", "sfp", "mguztnorf", "pnjogwuyztacev", "qdyxcfzbhp", "bcwhdqzjultrai", "sfvheigw", "vgqb", "brsyjegvmhdc", "xwuadlp", "aft", "pinl", "gctwje", "ufjzmdp", "ohbxag", "cdfamgpntkwu", "ruaekpdbfqtzclj", "cesowgvpltxjihdr", "nfy", "jftgxplc", "zhlgtxou", "tljanzupriodew", "rlesyncqbkftuoh", "eqslt", "giotujnrwfdce", "qldztvnyguwxso", "vjkdfzuaseitxo", "rdimnopgzhlw", "ckrjyqwplitsfo", "dwvj", "wgje", "qcmrxk", "qgflbvxhn", "qoniymsa", "ftdcoxpqakigrejv", "hrusofb", "qcm", "scwykazqb", "riswegfoctj", "tq", "ekoc", "sjpkg", "dikj", "sqigfbrel", "eoknxfrup", "ot", "djfsbwkpuhl", "yvafsiku", "clnbxzg", "ivbhygjqrxan", "rit", "msprwq", "hfdjmckqzpulrw", "hfwazycos", "kdmnqztsi", "nrhol", "lctab", "svf", "crxngv", "gczkqjs", "agfqzhmy", "dvoxgmh", "ndvcuykgh", "vct", "nywvhcxbd", "e", "pbufvcszi", "ql", "agvpjizktbwsorfn", "zxvgbkwca", "omeayvfwhqzrpi", "fmgcxeutzdk", "ldpbcrayxztsjvw", "nxt", "ypluzeavsqw", "zmbv", "rucwispfa", "iucj", "jnhbzw", "vqhetubalnf", "poivetgflayxkjhr", "tje", "nr", "spygwiqr", "ewyuforkmpicnx", "vg", "hakjcn", "aygvphcszitqwku", "baovglc", "qmurcdzbhy", "wucgnfmlsjz", "kslongxrqhcmz", "pgfvquewxncalksb", "drqhje", "parmfuzhdkvb", "orfwcqbsv", "uoq", "iocesyphtzxvuwk", "oisafxherlpvjd", "xrbw", "iktsg", "dag", "ifpyer", "onerqivbwmjz", "ia", "kemzasyxndgjhoc", "ukvj", "celxkzuhwypbva", "y", "agejbtoqislvh", "xiopwdtfkba", "fqbihmywglxdnc", "cjmeizw", "ghzfqw", "eylv", "jbuylhnfk", "pkyfr", "rf", "dyvhipqjmgrezaf", "kcolxfmgnqvyz", "nphgbcujmo", "fqupgtrxvis", "f", "drishmtobjqcapv", "exutnvc", "pkzcqhmgnf", "ycgqbdtsenmlhf", "k", "wtgerl", "lqa", "ku", "i", "ydlzsgfirbjx", "owecuxrpm", "i", "ekr", "tglokjeyc", "ckmfij", "coxekquhwmd", "kfsdwcq", "hnpymjovxue", "twqyv", "demvwrtcsiabglq", "y", "kvnqszx", "g", "ewtuijhxyo", "mwhrsfxjgeb", "dwxfbntusoa", "lhiboak", "kune", "ow", "awzpn", "jqesgiuzrdpx", "rijvynudo", "ycvutdmgkroiexa", "qvo", "wupmsxni", "rcpnhx", "wsbcanhpe", "sdelrbyxqukzmw", "qhrygcuabnv", "fruaynbsedwqxh", "flyhcwnaoej", "ni", "rbtopmn", "jvtdensy", "few", "dn", "a", "chg", "h", "tiwdrbp", "tdm", "qghetodvsjimbp", "hymzfvgsobc", "kdqstyjznvhapb", "oem", "lb", "mhod", "adjhexcpqmny", "ljsiq", "whgdyxmzcs", "tc", "vyquexhzlwirbo", "gykq", "qhmjgo", "wmcrasnoxf", "xzrbwvpefnoj", "eyhaqspxvkrdcu", "ncbtsvzfr", "kwal", "slfyi", "fz", "nzbdmr", "akpdhycirg", "ofrbxuc", "ajkyobq", "tkxhd", "tjcxrw", "qiruxdljayvw", "xhvakznmibru", "shgizj", "mtgbuokycqjwz", "lbodjf", "xbgmzwslkup", "ix", "tefw", "szlqbfcrvewxh", "yugjdax", "aekjsruy", "womqkfdny", "jgzw", "lavbxr", "lijybwtshfva", "fwvlt", "abhvjc", "ub", "qew", "kwimvrfxsn", "mldvjhbsxkfqtp", "gfewmbh", "oe", "adurofqsiwcyek", "mrahvpzxqo", "gxtbcrjvnayquk", "agdukwhevqynjl", "fal", "jzrvwinkusldbot", "qnia", "kwhuiacrvobp", "ewmr", "rmwdsvtgp", "zctjunxidevybl", "ckuexlrgpn", "dh", "dczbrilvhnwpaqt", "ustilnpkfowzy", "bknrejhxopmgzf", "uzvteaj", "xnkie", "dxbtswmrekfvncu", "yeuaxkilbcshopq", "ax", "suchdoxfbn", "iegrpnd", "qetwovbjs", "kxrobvsuwzd", "suwj", "xsgdcavhoeyrznl", "fo", "vtpyhaowszmq", "hfwonijbvdzxsua", "onatjk", "sau", "dvbwoatyjsxpgefl", "na", "mglfynh", "ywlkdcbnx", "qwvojklutydran", "aql", "gdol", "m", "ufskachixjtmbd", "kxlwg", "klgmyuparhtox", "fvshdugarpyejqzt", "ejidg", "uknhpsfqdotvjya", "novyphxwj", "blxps", "d", "kc", "cnaroqj", "qu", "incfrutp", "ci", "dtugyziblrqh", "dsfoquxevlarht", "zwmnptjau", "ytecmgvjf", "maoictxvjus", "uwhxytnv", "tbmzpscehxkarwoi", "ztxv", "kigyjb", "frlapn", "wcveqlpj", "arz", "bfqkiatlmvsueo", "jkepaqwimx", "jefodwbt", "xcnqwdhtlkmiryp", "xulkbnq", "ot", "m", "jchodig", "wcqgmilbajzs", "zekqsxwgfdjyblc", "nmxavdocguybrtp", "bkyczmptogqiu", "mastzincjxqb", "nzm", "dxpfaoelg", "hygbrxamzcov", "b", "pkgvdzsrcyo", "whqopvdgexfntaz", "iowrnxkltsv", "f", "nvcuymzwf", "sxevmktrdyqpga", "ulwzsntvhgo", "fkvzgxbadmihc", "kmferiap", "gnpylhidxqvre", "zfunlhxpajsmte", "psomxbu", "tpyz", "vrbnpzicehqlk", "vut", "hmosw", "wrcoegynlmihktq", "ehujpgb", "teurhbpola", "te", "qmhvgazpy", "qn", "xgkevnmujhbcw", "cednjuyzfrk", "bl", "tvjsdkzgbfrnolx", "o", "jeszr", "lf", "pxmrstykena", "etkaqgywb", "xitepcoqmywnabr", "phfeo", "tuzkb", "ltcpynmzkhe", "qf", "jceaqor", "vikewzdsflayrh", "amipvtk", "bqjxfctm", "xyuflbwdni", "zjn", "avnyhxtgcbmsj", "fyxztlw", "rhiksqzwbncdu", "jnsgkmxz", "mbhfu", "unrqvayjeiocsld", "ugb", "iu", "orjyfb", "cfxyv", "dkrzslecipt", "rh", "otuwqevildhsfpbj", "lsxrizef", "ufwl", "vpbsgxlucam", "zldruejvg", "qdszvjpgh", "omqlsijg", "zrjsyimekutopv", "tqiwgkjxhp", "pmldfswutjenyo", "juzltnvkgwm", "istbrgxek", "zsekjfihrbmdgtl", "ntxlkarzsfvo", "tfzmsyn", "junvwaoiy", "iuehozgtv", "gwpfkry", "jyuwpvil", "zor", "mrxfkeiguqcy", "tlops", "jvratnwemgupsl", "ufvrzmts", "dpkjsfmthglwic", "bhkandtjwvgpr", "gbcmstwonrvj", "gnsxietuyvohjc", "np", "rpjyhckie", "tj", "fhoxkpinujs", "boq", "vlytmzbcj", "nboyucs", "f", "tmkrbvcequgolsi", "inthajrleycopd", "mzpkoteqjfhgxr", "wifjoezhqlaydrg", "dufr", "zsg", "rafzbmldtkc", "uamgpkrzet", "eajgftqzl", "ifkgbcwn", "mbgqnsrv", "thgewzbiufdp", "ng", "oszkxyeritnw", "npvryhas", "gqwpnlft", "gtbsreykoi", "ytcuaefbkwo", "whv", "indxwfc", "zqi", "snvihkaglfxp", "zjlefovgdby", "jlkwuacx", "jzkocbnaismqdv", "qxnz", "fehcipdbnv", "qwhpxnejfy", "lrnwjz", "jfduoehpxgs", "md", "dej", "erbipdhgnquwjc", "utyabgm", "mrghpwtnaiqkfc", "mlcoq", "smxavtwkeizo", "j", "anjwekzo", "gvsoqdbwnc", "ribnmhugpt", "zxqgtkh", "lh", "zvib", "ianrw", "ozekxhrdqpl", "gdns", "fxymzdjbthang", "vynmo", "segtfrnjzuvd", "h", "x", "qlfwdxjzna", "jmlrotpyhcuv", "zfwsqrgxk", "lmq", "qwdifkjecshung", "utdihflv", "mnuvsawckq", "ucakhswdtbn", "oaedpl", "rohtbfdxnzei", "cu", "vdlcw", "tsgudkwo", "ugijehftmalzv", "ehmkjblipgv", "n", "bd", "sgko", "neb", "qxbuingv", "fcvtpjadqz", "zqnrskbme", "ldgxwijqnkrfcp", "cnj", "lcqxgyena", "hufobzqekpxvldm", "ctxn", "ab", "aolvmzespbrnjg", "io", "kbhwspg", "jwhomcr", "npfl", "zidqsvpunjbyaxc", "bav", "tmwrjlsed", "jzibvwcstlgrk", "hizmbwqyge", "onyxbergpvjul", "o", "noigbrtqzhuwpsdm", "wgyoitnkacj", "cleatwzurifgdxoj", "ydprewfczknlt", "yjiemrltqhkfzd", "qbhe", "y", "uhgq", "a", "eptlxqmoairfyjds", "pytesjdvo", "ulajndfgx", "knvpfcmldwbios", "ejqxawcop", "c", "xhloesfqypb", "j", "yflgq", "vcyu", "chqztuvn", "vmwubperxk", "samxt", "po", "t", "exfdpatnwosk", "xcqonaptfmlsd", "tlmayecdkisrpbz", "hgyvzlbxetufjmw", "fsgakpcndiuzeb", "m", "luevtfj", "avguom", "afqwnblsomk", "qlozdybwcfnhk", "fosmbqua", "afdmrgsqwxvo", "lzdfjtbqc", "qhagb", "qeimns", "xnhrs", "xdtwiymhskqoa", "hfbgnwjuzevlkpr", "by", "ogtlerhvdmbi", "epcdgwajviourbx", "pdohxc", "oxqkbethrlwnpma", "pwdhq", "tkgnzbhverafc", "zlpbvitakqrf", "ynbfxwpc", "ygmxtiv", "ybtpaudw", "nagxrepfl", "rvp", "rhbiavct", "vmqspyzfuw", "ajex", "fgjrad", "zr", "wzk", "jk", "rkqzmjabip", "ditpyqoxwnzgja", "ybsnciveoakjlmq", "ywverqzmujginxc", "czvrm", "bazyusfmdtjgie", "yhmlbrtxskuwqa", "pnqgesyzuvwkt", "ahpntv", "kmgcndrfyzpoj", "zobskapmlj"}));
    }

}
