package projectTesting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*

ScrappingStation - Zadaniem klasy jest pobranie ze strony nazw paliw sprzedawanych
na danej stacji paliw oraz ceny za   którą dane paliwo jest sprzedawane
Kod używa biblioteki Jsoup do analizy HTML i instrukcji rejestrowania do debugowania oraz w celach informacyjnych
oraz Apache log4j w celu tworzenia logów w trakcie działania programu
*/
public class ScrapingStation {
	
	private static final Logger logger = LogManager.getLogger(ScrapingStation.class.getName());
	public static final String BaseURL = "https://www.autocentrum.pl";
        public static String title;
        public static String price;

    public static Map<String, List<String>> petrolPriceOnStation(String address) {
            Map<String, List<String>> result = new HashMap<>();
            List<String> titles = new ArrayList<>();
            List<String> prices = new ArrayList<>();
            String allUrl = BaseURL + address;
            logger.info("Tutaj jest adres: " + allUrl);
            try {
                Document doc = Jsoup.connect(allUrl).get();
                Elements fuels = doc.select(".fuels-wrapper.flex .station-detail-wrapper:not(a)");
                logger.info("Tutaj znajduje sie zmienna prices: " + fuels);
                for (Element fuel : fuels) {
                    title = fuel.select(".fuel-header.primary-header").text();
                    price = fuel.select(".price").text();
                    logger.info("Tutaj jest tytuł: " + title + " oraz cena: " + price);
                    titles.add(title);
                    prices.add(price);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            result.put("titles", titles);
            result.put("prices", prices);
            return result;
    }


}