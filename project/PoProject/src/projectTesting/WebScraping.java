package projectTesting;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.logging.log4j.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
	Zadaniem klasy WebScraping jest obsługa pobierania danych  ze strony www.autocentrum.pl
	Kod używa biblioteki Jsoup do analizy HTML i instrukcji rejestrowania do debugowania oraz w celach informacyjnych
	oraz Apache log4j w celu tworzenia logów w trakcie działania programu
 */

public class WebScraping {
	
	private static final Logger logger = LogManager.getLogger(WebScraping.class.getName());
	private final String BaseURL = "https://www.autocentrum.pl";
	private final String cityURL = "https://www.autocentrum.pl/stacje-paliw/?s=1&order=&q=kraków+";
	public ArrayList<String> addressLink = new ArrayList<>();
	public ArrayList<String> addressName = new ArrayList<>();
	
	public String getAddress(String street) {
		// Przyjmuje parametr street, zamienia spacje na '+' i zwraca zmodyfikowaną ulicę lub ostrzeżenie, jeśli ulica jest pusta lub null.
		if (street != null) {
		    if (street.trim().isEmpty()) {
		        logger.warn("Nie został podany żaden adres. Wyszukiwania tylko ze wszystkich stacji Kraków.");
		    } else {
		        String streetEdit = street.replace(" ", "+");
		        logger.info("Zedytowany adres: " + streetEdit);
		        return streetEdit;
		    }
		} else {
		    logger.warn("Przekazany adres ma wartość null. Wyszukiwania tylko ze wszystkich stacji Kraków.");
		}
		return "";
	}
	
	public int numberOfPages(String streed_edit) {
		// Łączy się z adresem URL (łącząc bazowy URL i zmodyfikowany parametr street), pobiera dokument za pomocą Jsoup i określa liczbę stron
		int numberOfPages = 0;
		try {
		    Document doc = Jsoup.connect(cityURL + streed_edit).get();
		    Elements pages = doc.select(".pagination li"); //sprawdzamy element z klasy pagination i odczytujemy tagi zawierajace <li>
		    if(pages.size() <= 0) {
		    	numberOfPages = 0;
		    	logger.fatal("Nieprawidlowosci w wyszukiwanym adresie. Brak mozliwosci sprawdzenia danych!");
		    	logger.info("Liczba stron: " + numberOfPages);
		    }
		    else {
		    	numberOfPages = pages.size()-2;
		    	logger.info("Liczba stron: " + numberOfPages);
		    }

		} catch (IOException e) {
		    e.printStackTrace();
		}
		return numberOfPages;
	}
	
	public void listToAvailableAddress(String streed_edit, int numberOfPages) {
		/*
		   Iteruje przez strony, łączy się z każdą stroną, pobiera informacje o stacjach paliw (takie jak linki, nazwy i adresy) i rejestruje szczegóły.
		   Wyciągnięte dane są przechowywane w ArrayListach (addressLink i addressName).
		 */

		String linkWithChangedPage = "https://www.autocentrum.pl/stacje-paliw/?s=" + numberOfPages + "&order=&q=kraków+"+streed_edit; 
		
		String stationLink = "";
		if(numberOfPages <= 0) {
			logger.fatal("Brak mozliwych do uzyskania danych. Liczba stron jesst <= od 0");
		}
		for(int i=1;i<=numberOfPages;i++) {
                        if(i <= 1){
                           linkWithChangedPage = "https://www.autocentrum.pl/stacje-paliw/?s=" + i + "&order=&q=kraków+"+streed_edit;
                        }else{
                           linkWithChangedPage = "https://www.autocentrum.pl/stacje-paliw/strona-" + i + "/?s=1&order=&q=kraków+"+streed_edit;
                        }

                        logger.info("Numer storny: " + i);
			try {
			
                            Document doc = Jsoup.connect(linkWithChangedPage).get();
			    Elements listOfStations = doc.select(".station-item");
	
			    for (Element station : listOfStations) {
			        Element linkElement = station.select("a").first();
			        
			        //Uzyskiwanie linku do wyszukiwanych adresów
			        if (linkElement != null) {
			            stationLink = linkElement.attr("href");
			            addressLink.add(stationLink);
			            logger.debug("Station Link: " + stationLink);
			        }else {
			        	logger.error("Brak elementu pod podanym linkiem");
			        }		        
			        //
			        
			        String stationAddress = station.select(".content .name.shorter").text();
			        String stationName = station.select(".content .address").text();
                                if(stationAddress.contains("Kraków, ")) {
                                    logger.debug("Nazwy stacji: " + stationAddress + " " + stationName);
                                    addressName.add(stationAddress + " " + stationName);
                                    if (addressName.isEmpty() && numberOfPages != 0) {
                                        logger.error("Wystapil blad zapisywania nazw dostepnych stacji beznzynowych!");
                                    }
                                        }
                            }
			} catch (IOException e) {
			    e.printStackTrace();
			}
			logger.info("Link z adresu w tablicy: " + addressLink);
			logger.info("Nazwa z adresu w tablicy: " + addressName);
		}
		
	}

}
