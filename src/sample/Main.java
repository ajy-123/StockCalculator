package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    public double varTotalAssets;
    public double varCurrentAssets;
    public double varTotalLiabilities;
    public double varShareholdersEquity;
    public double varCurrentLiabilities;
    public double varPreferredStock;
    public double varSharesOutstanding;
    public double currentMarketPrice;
    public double Earnings;


    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;

        /* **************************
        CODE FOR THIRD SCENE
         */

        VBox resultsLayout = new VBox();
        VBox.setMargin(resultsLayout, new Insets(20));
        resultsLayout.setSpacing(20);



        //Creating Label for P/E
        Label priceToEarnings = new Label();


        //Creating Label for Net Current Asset Value Per Share
        Label ncavps = new Label();

        //Creating Label for Book Value Per Share
        Label bookValuePerShare = new Label();

        //Creating Label for Price to Book
        Label priceToBook = new Label();

        //Creating currents label
        Label currentAssetsToLiabilities = new Label();


        resultsLayout.getChildren().addAll(priceToEarnings, ncavps, bookValuePerShare, priceToBook,
                currentAssetsToLiabilities);

        Scene resultsScene = new Scene(resultsLayout, 500, 500);






        /* **************
        CODE FOR SECOND SCENE
         */
        //Creating and formatting GridPane layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        //Making Label for Asset
        Label totalAssets = new Label("Total Assets:");
        GridPane.setConstraints(totalAssets, 0,0);

        //Making TextField for Asset
        TextField inputAsset = new TextField();
        GridPane.setConstraints(inputAsset, 1, 0);

        //Making Label for Current Asset
        Label currentAssets = new Label("Current Assets:");
        GridPane.setConstraints(currentAssets, 0,1);

        //Making TextField for CURRENT Asset
        TextField inputCurrentAsset = new TextField();
        GridPane.setConstraints(inputCurrentAsset, 1, 1);

        //Making Label for Liabilities
        Label totalLiabilities = new Label("Total Liabilities:");
        GridPane.setConstraints(totalLiabilities, 0,2);

        //Making TextField for Liabilities
        TextField inputLiabilities = new TextField();
        GridPane.setConstraints(inputLiabilities, 1, 2);

        //Making Label for Liabilities
        Label currentLiabilities = new Label("Current Liabilities:");
        GridPane.setConstraints(currentLiabilities, 0,3);

        //Making TextField for Liabilities
        TextField inputCurrentLiabilities = new TextField();
        GridPane.setConstraints(inputCurrentLiabilities, 1, 3);

        //Making Label for Shares Outstanding
        Label sharesOutstanding = new Label("Shares Outstanding:");
        GridPane.setConstraints(sharesOutstanding, 0,4);

        //Making TextField for Shares Outstanding
        TextField inputSharesOutstanding = new TextField();
        GridPane.setConstraints(inputSharesOutstanding, 1, 4);

        //Making Label for Preferred Stock
        Label preferredStock = new Label("Preferred Stock Issued at Value:");
        GridPane.setConstraints(preferredStock, 0,5);

        //Making TextField for Preferred Stock
        TextField inputPreferredStock = new TextField();
        GridPane.setConstraints(inputPreferredStock, 1, 5);

        //Making Label for Net Earnings
        Label netEarnings = new Label("Net Earnings:");
        GridPane.setConstraints(netEarnings, 0,6);

        //Making TextField for Net Earnings
        TextField inputNetEarnings = new TextField();
        GridPane.setConstraints(inputNetEarnings, 1, 6);

        //Making Label for marketPrice
        Label marketPrice = new Label("Market Price:");
        GridPane.setConstraints(marketPrice, 0,7);

        //Making TextField for Market Price
        TextField inputMarketPrice = new TextField();
        GridPane.setConstraints(inputMarketPrice, 1, 7);

        //Making Label for Shareholders Equity
        Label shareholdersEquity = new Label("Shareholders Equity:");
        GridPane.setConstraints(shareholdersEquity, 0,8);

        //Making TextField for Shareholders Equity
        TextField inputShareholdersEquity = new TextField();
        GridPane.setConstraints(inputShareholdersEquity, 1, 8);

        Button calculateButton = new Button("Calculate");
        GridPane.setConstraints(calculateButton,0,9);
        calculateButton.setOnAction(event -> {
            window.setScene(resultsScene);
            //Setting public variables to the values of the input fields
            varTotalAssets = Double.parseDouble(inputAsset.getText());
            varCurrentAssets = Double.parseDouble(inputCurrentAsset.getText());
            varTotalLiabilities = Double.parseDouble(inputLiabilities.getText());
            varShareholdersEquity = Double.parseDouble(inputShareholdersEquity.getText());
            varPreferredStock = Double.parseDouble(inputPreferredStock.getText());
            varSharesOutstanding = Double.parseDouble(inputSharesOutstanding.getText());
            currentMarketPrice = Double.parseDouble(inputMarketPrice.getText());
            Earnings = Double.parseDouble(inputNetEarnings.getText());
            varCurrentLiabilities = Double.parseDouble(inputCurrentLiabilities.getText());


            //Taking input fields and using algorithms to display on results window
            Algorithms Algorithms = new Algorithms(varTotalAssets, varCurrentAssets,varTotalLiabilities
            ,varCurrentLiabilities,varShareholdersEquity, varSharesOutstanding, varPreferredStock,
                    currentMarketPrice, Earnings);
            double[] calculatedRatios = Algorithms.RatiosList();

            ncavps.setText("Net current asset value per share is: " + calculatedRatios[0]);
            priceToEarnings.setText("P/E:" + calculatedRatios[1]);
            bookValuePerShare.setText("Book Value Per Share: " + calculatedRatios[2]);
            priceToBook.setText("Price to Book Ratio: " + calculatedRatios[3]);
            currentAssetsToLiabilities.setText("Current Assets to Liabilities: " + calculatedRatios[4]);




        });


        //Adds all to scene and then shows Scene in Window
        grid.getChildren().addAll(totalAssets, totalLiabilities, inputAsset, inputLiabilities, sharesOutstanding,
                inputSharesOutstanding, preferredStock, inputPreferredStock, currentAssets, inputCurrentAsset, shareholdersEquity,
                inputShareholdersEquity, calculateButton, netEarnings, inputNetEarnings, marketPrice, inputMarketPrice,
                currentLiabilities, inputCurrentLiabilities);

        Scene inputScene = new Scene(grid, 500, 500);


        /* *******************************
        CODE FOR FIRST SCENE
         */
        //Creating Introductory Scene
        StackPane introductionLayout = new StackPane();

        //Creating Introduction Label
        Label introductionLabel = new Label("Hello and welcome to this stock value calculator!\n " +
                "This calculator will take certain inputs (assets, liabilities, shares outstanding, etc.) \n" +
                "and give you useful ratios such as P/E and NCAVPS. \n" +
                "A few disclaimers before we start: \n \n \n" +
                "-All necessary information about a company can be found on the SEC's EDGAR website \n \n" +
                "-SEC Reports present their ledgers in millions. Do the same for this program \n \n" +
                "-These analyses are NOT by someone who is an accredited financial adviser and, as such \n" +
                "you should use these ratios / analyses as a tool, not as complete advice");

        //Creating button to change the scene from introduction to input
        Button progressButton = new Button("Next");
        StackPane.setAlignment(progressButton, Pos.BOTTOM_CENTER);
        progressButton.setOnAction(event -> {
            window.setScene(inputScene);
        });


        //Adding elements to introLayout
        introductionLayout.getChildren().addAll(introductionLabel, progressButton);

        //Adding all and setting window
        Scene introductionScene = new Scene(introductionLayout, 500, 300);
        window.setScene(introductionScene);
        window.setTitle("Stock Valuation Calculator");
        window.show();
    }
}
