    package projectTesting;
    import java.util.ArrayList;
    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;
    /*
        Klasa ScrapingClass pośredniczy w  całym procesie WebScrapingu danych za pomocą klas WebScraping i ScrapingStation
        Kod używa biblioteki Jsoup do analizy HTML i instrukcji rejestrowania do debugowania oraz w celach informacyjnych
        oraz Apache log4j w celu tworzenia logów w trakcie działania programu
     */
    public class ScrapingClass {

        private static final Logger logger = LogManager.getLogger(ScrapingClass.class.getName());
            public static ArrayList<String> addressNames;
            public static ArrayList<String> addressLinks;

        public static void main(String[] args) {
                WebScraping web = new WebScraping();
                String address = MainUI.getInputText(); // pobranie adresu od użytkownika w celu wyszukania  konkretnej stacji
                logger.info("Wartosc adresu: " + address);
                int numberOfPages = web.numberOfPages(address);
                web.listToAvailableAddress(address, numberOfPages);
                addressNames = web.addressName;
                logger.info("Sprawdzenie addressNames w klasie ScrapingClass: " + addressNames);
                addressLinks = web.addressLink;
        }
    }
