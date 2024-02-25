    package projectTesting;

    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
     */

    import java.awt.Font;
    import java.awt.GridLayout;
    import java.awt.event.ComponentAdapter;
    import java.awt.event.ComponentEvent;
    import java.io.IOException;
    import java.net.UnknownHostException;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Map;
    import javax.swing.*;
    import org.apache.logging.log4j.LogManager;
    import org.apache.logging.log4j.Logger;
    import java.util.logging.Level;
    import org.jsoup.Jsoup;
    import org.jsoup.nodes.Document;

    import static javax.swing.JOptionPane.WARNING_MESSAGE;

    /**
     *
     * @author user
     */
    public class MainUI extends javax.swing.JFrame {

        private static final Logger logger = LogManager.getLogger(MainUI.class.getName());
        public static String inputText;
        private final static String BaseURL = "https://www.autocentrum.pl";


        /*
          Tworzy wszystkie komponenty do klasy MainUI
         */
        public MainUI() {
            initComponents();
        }

        private void updateFontBasedOnWidth() {
            int width = getWidth();
            logger.info("Zmieniono rozmiar, aktualny: " + width);
            int fontSizeSM = 16;
            int fontSizeMD = 18;
            int fontSizeLG = 20;
            int fontSizeXL = 24;
            int fontSize2XL = 28;
            int fontSize3XL = 32;

            /*
            Fragment kodu odpowiedzialny za responsywność rozmiaru czcionki według zmieniającej się szerokości
            */

            if (width < 600) {
                EnterAddressLabel.setFont(new java.awt.Font("Bookman Old Style", 1, fontSizeSM));
                logger.info("Rozmiar HeaderAddressInput na: " + fontSizeSM);
            } else if (width >= 600 && width < 800) {
                EnterAddressLabel.setFont(new java.awt.Font("Bookman Old Style", 1, fontSizeMD));
                logger.info("Rozmiar HeaderAddressInput na: " + fontSizeMD);
            } else if (width >= 800 && width < 1000) {
                EnterAddressLabel.setFont(new java.awt.Font("Bookman Old Style", 1, fontSizeLG));
                logger.info("Rozmiar HeaderAddressInput na: " + fontSizeLG);
            } else if (width >= 1000 && width < 1200) {
                EnterAddressLabel.setFont(new java.awt.Font("Bookman Old Style", 1, fontSizeXL));
                logger.info("Rozmiar HeaderAddressInput na: " + fontSizeXL);
            } else if (width >= 1200 && width < 1600) {
                EnterAddressLabel.setFont(new java.awt.Font("Bookman Old Style", 1, fontSize2XL));
                logger.info("Rozmiar HeaderAddressInput na: " + fontSize2XL);
            } else if (width >= 1600) {
                EnterAddressLabel.setFont(new java.awt.Font("Bookman Old Style", 1, fontSize3XL));
                logger.info("Rozmiar HeaderAddressInput na: " + fontSize3XL);
            }
        }

        private void updateAddressInputButtonWidth() {
            /*
              Code snippet responsible for AddresInputField responsiveness
             */
            int width = getWidth();
            // Adjust the preferred width based on the width of the container
            int preferredWidth;
            if (width < 600) {
                preferredWidth = 100;
            } else if (width >= 600 && width < 800) {
                preferredWidth = 150;
            } else if (width >= 800 && width < 1000) {
                preferredWidth = 200;
            } else if (width >= 1000 && width < 1200) {
                preferredWidth = 250;
            } else if (width >= 1200 && width < 1600) {
                preferredWidth = 300;
            } else {
                preferredWidth = 400;
            }

            int originalHeight = AddressInputButton.getPreferredSize().height;

            // Set the preferred size of AddressInputButton
            AddressInputButton.setPreferredSize(new java.awt.Dimension(preferredWidth, originalHeight));

            javax.swing.GroupLayout InputAddressPanelLayout = new javax.swing.GroupLayout(InputAddressPanel);
            InputAddressPanelLayout.setHorizontalGroup(
                    InputAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InputAddressPanelLayout.createSequentialGroup()
                                    .addComponent(InputAddressField)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AddressInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, preferredWidth, javax.swing.GroupLayout.PREFERRED_SIZE)) // Set the desired width here
            );

        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            Header = new javax.swing.JPanel();
            Loading = new javax.swing.JLabel();
            CenterPanel = new javax.swing.JPanel();
            CenterLabel = new javax.swing.JPanel();
            EnterAddressLabel = new javax.swing.JLabel();
            InputAddressPanel = new javax.swing.JPanel();
            InputAddressField = new javax.swing.JTextField();
            AddressInputButton = new javax.swing.JButton();
            ListPanel = new javax.swing.JPanel();
            OnAddressList = new javax.swing.JScrollPane();
            AddressList = new javax.swing.JList<>();
            LabelPanel = new javax.swing.JPanel();

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
            );

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setMinimumSize(new java.awt.Dimension(600, 400));
            setPreferredSize(new java.awt.Dimension(600, 400));

            Header.setPreferredSize(new java.awt.Dimension(600, 50));

            Loading.setVisible(false);
            Loading.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
            Loading.setForeground(new java.awt.Color(255, 255, 255));
            Loading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            Loading.setText("Loading...");

            javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
            Header.setLayout(HeaderLayout);
            HeaderLayout.setHorizontalGroup(
                HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HeaderLayout.createSequentialGroup()
                    .addComponent(Loading, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addContainerGap())
            );
            HeaderLayout.setVerticalGroup(
                HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HeaderLayout.createSequentialGroup()
                    .addComponent(Loading, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addContainerGap())
            );

            getContentPane().add(Header, java.awt.BorderLayout.PAGE_START);

            CenterPanel.setMinimumSize(new java.awt.Dimension(600, 400));
            CenterPanel.setPreferredSize(new java.awt.Dimension(600, 400));

            EnterAddressLabel.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
            EnterAddressLabel.setForeground(new java.awt.Color(0, 209, 255));
            EnterAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            EnterAddressLabel.setText("Podaj adres stacji paliw w Krakowie:");

            javax.swing.GroupLayout CenterLabelLayout = new javax.swing.GroupLayout(CenterLabel);
            CenterLabel.setLayout(CenterLabelLayout);
            CenterLabelLayout.setHorizontalGroup(
                CenterLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(EnterAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            CenterLabelLayout.setVerticalGroup(
                CenterLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(EnterAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            EnterAddressLabel.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    updateFontBasedOnWidth();
                    updateAddressInputButtonWidth();
                }
            });

            InputAddressField.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
            InputAddressField.setForeground(new java.awt.Color(0, 209, 255));
            InputAddressField.setActionCommand("<Not Set>");

            AddressInputButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            AddressInputButton.setForeground(new java.awt.Color(255, 255, 255));
            AddressInputButton.setText("Szukaj");
            AddressInputButton.setPreferredSize(new java.awt.Dimension(75, 25));
            AddressInputButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AddressInputButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout InputAddressPanelLayout = new javax.swing.GroupLayout(InputAddressPanel);
            InputAddressPanel.setLayout(InputAddressPanelLayout);
            InputAddressPanelLayout.setHorizontalGroup(
                InputAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InputAddressPanelLayout.createSequentialGroup()
                    .addComponent(InputAddressField)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(AddressInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            InputAddressPanelLayout.setVerticalGroup(
                InputAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InputAddressPanelLayout.createSequentialGroup()
                    .addGroup(InputAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(AddressInputButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(InputAddressField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE))
            );

            OnAddressList.setVisible(false);
            OnAddressList.setPreferredSize(new java.awt.Dimension(getWidth(), getHeight()));
            OnAddressList.setRequestFocusEnabled(false);

            AddressList.setVisible(false);
            AddressList.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
            AddressList.setForeground(new java.awt.Color(12, 146, 148));
            AddressList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            AddressList.setToolTipText("");
            AddressList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            AddressList.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    AddressListMouseClicked(evt);
                }
            });
            OnAddressList.setViewportView(AddressList);

            LabelPanel.setVisible(false);

            javax.swing.GroupLayout LabelPanelLayout = new javax.swing.GroupLayout(LabelPanel);
            LabelPanel.setLayout(LabelPanelLayout);
            LabelPanelLayout.setHorizontalGroup(
                LabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 582, Short.MAX_VALUE)
            );
            LabelPanelLayout.setVerticalGroup(
                LabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 102, Short.MAX_VALUE)
            );

            javax.swing.GroupLayout ListPanelLayout = new javax.swing.GroupLayout(ListPanel);
            ListPanel.setLayout(ListPanelLayout);
            ListPanelLayout.setHorizontalGroup(
                ListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ListPanelLayout.createSequentialGroup()
                    .addComponent(OnAddressList, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addGap(8, 8, 8))
                .addGroup(ListPanelLayout.createSequentialGroup()
                    .addComponent(LabelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            ListPanelLayout.setVerticalGroup(
                ListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ListPanelLayout.createSequentialGroup()
                    .addComponent(OnAddressList, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(LabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE))
            );

            OnAddressList.setBounds(0, 0, getWidth(), getHeight());

            javax.swing.GroupLayout CenterPanelLayout = new javax.swing.GroupLayout(CenterPanel);
            CenterPanel.setLayout(CenterPanelLayout);
            CenterPanelLayout.setHorizontalGroup(
                CenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CenterPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(CenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CenterLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(InputAddressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ListPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            CenterPanelLayout.setVerticalGroup(
                CenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CenterPanelLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(CenterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(InputAddressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(ListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE))
            );

            getContentPane().add(CenterPanel, java.awt.BorderLayout.CENTER);

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        /*
            Metoda wywoływana poprzez naciśnięcie przycisku
            Powoduje szukanie wprowadzonego adresu i aktualizacje
            tablicy ze znalezionymi stacjami paliw.
        */

        private void AddressInputButtonActionPerformed(java.awt.event.ActionEvent evt) {
            Loading();

            // Blokowanie przycisku
            AddressInputButton.setEnabled(false);


            /*
                Dodanie SwingWorkera w celu zapobiegnięciu wielokrotnemu klikaniu przycisku podczas ładowania danych
            */
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

                //sprawdzenie czy można połączyć się ze stroną z której pozyskujemy dane
                @Override
                protected Void doInBackground() throws Exception {
                    boolean connected = false;
                    while (!connected) {
                        try {
                            Document doc = Jsoup.connect(BaseURL).get();
                            connected = true;
                        } catch (UnknownHostException e) {
                            JOptionPane.showMessageDialog(MainUI.this, "Problem z połączeniem z siecią", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (IOException ex) {
                            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            Thread.sleep(5000); // 5 sekudn oczekiwania na ponowienie połączenai z siecią
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    //przypadek kiedy nie został wprowadzony żaden tekst
                    inputText = InputAddressField.getText();
                    if (InputAddressField.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(MainUI.this, "Brak wskazania konkretnego adresu. Wyszukiwanie wszystkich dostępnych stacji","Warning",WARNING_MESSAGE);
                    }
                    logger.info("Wprowadzona wartość tekstowego: " + inputText);
                    AddressInputButton.setEnabled(false);

                    Thread scrapingThread = new Thread(() -> {
                        ScrapingClass.main(null);
                    });

                    scrapingThread.start();

                    try {
                        scrapingThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    ArrayList<String> addressName = ScrapingClass.addressNames;
                    String[] addressNames = addressName.toArray(new String[0]);
                    AddressList.setModel(new javax.swing.AbstractListModel<String>() {
                        public int getSize() {
                            return addressNames.length;
                        }

                        public String getElementAt(int i) {
                            return addressNames[i];
                        }
                    });
                    if (addressNames.length == 0) {
                        JOptionPane.showMessageDialog(MainUI.this, "Brak danych do wyświetlenia");
                        logger.info("Okno z wiadomością o braku danych");
                    }

                    logger.info("Sprawdzenie addresList: " + ScrapingClass.addressNames);
                    AddressInputButton.setEnabled(true);
                    OnAddressList.setVisible(true);
                    AddressList.setVisible(true);
                    LabelPanel.setVisible(false);
                    notLoading();

                    return null;
                }

                @Override
                protected void done() {
                    AddressInputButton.setEnabled(true);
                    notLoading();
                }
            };

            worker.execute();
        }

        /*
            Obsługa funkcji ładowania
         */
        private void Loading(){
            Loading.setVisible(true);
            Loading.revalidate();
            Loading.repaint();
        }
        private void notLoading(){
            Loading.setVisible(false);
            Loading.revalidate();
            Loading.repaint();
        }

        private void AddressListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddressListMouseClicked
            // TODO add your handling code here:
            if (evt.getClickCount() == 2) {
                Loading();
                int index = AddressList.getSelectedIndex();
                String item = AddressList.getSelectedValue();
                logger.info("Selected item: " + item + " na indexie: " + index);
                logger.info("Link do wybranej stacji: " + ScrapingClass.addressLinks.get(index));
                Map<String, List<String>> result = ScrapingStation.petrolPriceOnStation(ScrapingClass.addressLinks.get(index));
                List<String> titles = result.get("titles");
                List<String> prices = result.get("prices");

                //jeżeli dla wybranej stacji nie ma danych
                if(titles.isEmpty()){
                    JOptionPane.showMessageDialog(MainUI.this, "Brak danych dla tej stacji");
                }

                updateLabelPanel(titles, prices);

                AddressList.setVisible(false);
                OnAddressList.setVisible(false);
                LabelPanel.setVisible(true);
                notLoading();
            }
        }//GEN-LAST:event_AddressListMouseClicked
        /*
        Tworzenie tablicy z cenami
         */
        private void updateLabelPanel(List<String> titles, List<String> prices) {

            LabelPanel.removeAll();


            LabelPanel.setLayout(new GridLayout(titles.size(), 2));

        for (int i = 0; i < titles.size(); i++) {
            String title = titles.get(i);
            String price = prices.get(i);

            Font font = new Font("Arial", Font.BOLD, 20);
            JTextArea titleTextArea = new JTextArea(title);
            JTextArea priceTextArea = new JTextArea("Cena: " + price);
            titleTextArea.setForeground(new java.awt.Color(0, 209, 255));
            priceTextArea.setForeground(new java.awt.Color(0, 209, 255));
            titleTextArea.setEditable(false);
            priceTextArea.setEditable(false);
            titleTextArea.setFont(font);
            priceTextArea.setFont(font);

            // Add JTextAreas to LabelPanel
            LabelPanel.add(titleTextArea);
            LabelPanel.add(priceTextArea);
        }

        // You might need to call revalidate() and repaint() to update the UI
        LabelPanel.revalidate();
        LabelPanel.repaint();
    }

        public static String getInputText() {
            return inputText;
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */

            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                     UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MainUI().setVisible(true);

                }
            });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton AddressInputButton;
        private javax.swing.JList<String> AddressList;
        private javax.swing.JPanel CenterLabel;
        private javax.swing.JPanel CenterPanel;
        private javax.swing.JLabel EnterAddressLabel;
        private javax.swing.JPanel Header;
        private javax.swing.JTextField InputAddressField;
        private javax.swing.JPanel InputAddressPanel;
        private javax.swing.JPanel LabelPanel;
        private javax.swing.JPanel ListPanel;
        private javax.swing.JLabel Loading;
        private javax.swing.JScrollPane OnAddressList;
        private javax.swing.JPanel jPanel1;
        // End of variables declaration//GEN-END:variables
    }
